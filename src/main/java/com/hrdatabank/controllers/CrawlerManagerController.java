package com.hrdatabank.controllers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.ScheduledFuture;

import org.crawler.web.enumeration.CrawlerTypesEnum;
import org.crawler.web.initializer.BaitoruInitializer;
import org.crawler.web.initializer.JsenInitializer;
import org.crawler.web.preparer.BaitoruPreparerImpl;
import org.crawler.web.preparer.JsenPreparerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrdatabank.otome.domain.ConfigCrawler;
import com.hrdatabank.otome.domain.JobOtome;
import com.hrdatabank.otome.repositories.ConfigCrawlerRepository;
import com.hrdatabank.otome.repositories.JobOtomeRepository;
import com.hrdatabank.otome.services.JobOtomeService;

/**
 * The Class CrawlerMangerCOntroller. still yet in developmenet
 * 
 * @author Hanios
 */

@RestController
@RequestMapping("/crawler")
public class CrawlerManagerController {

	/** The baitoru preparer impl. */
	@Autowired(required = true)
	BaitoruPreparerImpl baitoruPreparerImpl;
	protected String message;

	@Autowired(required = true)
	JsenPreparerImpl jsenPreparerImpl;

	@Autowired
	protected JobOtomeRepository jobOtomeRepository;

	@Autowired
	protected JobOtomeService jobOtomeService;

	@Autowired
	ConfigCrawlerRepository configCrawlerRepository;

	private ConcurrentTaskScheduler taskScheduler;

	private ConcurrentTaskScheduler taskSchedulerShopName;
	@SuppressWarnings("rawtypes")
	private ScheduledFuture scheduledFuture;

	/** The Constant LOGGER. */
	private static final Logger logger = LoggerFactory.getLogger(CrawlerManagerController.class);

	/**
	 * On starting full search.
	 *
	 * @author Hanios
	 * @param type
	 *            the type
	 * @return the string
	 */
	@GetMapping(value = "/startFullSearch")
	public String onStartingFullSearch(@RequestParam(name = "type") String type) {
		Optional<CrawlerTypesEnum> crawlerTypesEnum = Optional.ofNullable(Arrays.asList(CrawlerTypesEnum.values())
				.stream().filter(x -> type.equalsIgnoreCase(x.name())).findAny().orElse(null));
		crawlerTypesEnum.ifPresent(target -> {
			if (target.equals(CrawlerTypesEnum.BAITORU)) {
				baitoruPreparerImpl.startFullCrawling();
			}

			if (target.equals(CrawlerTypesEnum.JSEN)) {
				jsenPreparerImpl.startFullCrawling();
			}
		});
		return crawlerTypesEnum.isPresent() ? "Full search Crawler is terminated" : "Wrong crawler type";
	}

	/**
	 * On starting part search.
	 *
	 * @author Hanios
	 * @param type
	 *            the type
	 * @param area
	 *            the area
	 * @param category
	 *            the category
	 * @return the string
	 */
	@GetMapping(value = "/startPartSearch")
	public String onStartingPartSearch(@RequestParam(name = "type") String type,
			@RequestParam(name = "area") String area, @RequestParam(name = "category") String category) {
		message = "";
		Optional<CrawlerTypesEnum> crawlerTypesEnum = Optional.ofNullable(Arrays.asList(CrawlerTypesEnum.values())
				.stream().filter(x -> type.equalsIgnoreCase(x.name())).findAny().orElse(null));
		crawlerTypesEnum.ifPresent(target -> {
			if (target.equals(CrawlerTypesEnum.BAITORU)) {
				message += BaitoruInitializer.getInstance().getJobMap().computeIfAbsent(category,
						x -> "Category not correct") + "\n";
				message += BaitoruInitializer.getInstance().getBasicsURLWebsite().computeIfAbsent(area,
						x -> "Area not correct") + "\n";
				if (!message.contains("not correct")) {
					baitoruPreparerImpl.startPartCrawling(area, category);
					message += "Part Search Crawler is terminated";
				}
			}

			if (target.equals(CrawlerTypesEnum.JSEN)) {
				message += JsenInitializer.getInstance().getJobMap().computeIfAbsent(category,
						x -> "Category not correct") + "\n";
				message += JsenInitializer.getInstance().getBasicsURLWebsite().computeIfAbsent(area,
						x -> "Area not correct") + "\n";
				if (!message.contains("not correct")) {
					jsenPreparerImpl.startPartCrawling(area, category);
					message += "Part Search Crawler is terminated";
				}
			}
		});
		return message;
	}

	@PutMapping("/updateConfigCrawler/{id}")
	public ResponseEntity<Object> renewSchedule(@RequestBody ConfigCrawler configCrawler, @PathVariable long id) {

		Optional<ConfigCrawler> configCrawlerOptional = configCrawlerRepository.findById(id);
		if (!configCrawlerOptional.isPresent())
			return ResponseEntity.notFound().build();
		configCrawler.setId(id);
		configCrawlerRepository.save(configCrawler);

		if (taskScheduler == null) {
			this.taskScheduler = new ConcurrentTaskScheduler();
			System.out.println("---------CREATE----------ConcurrentTaskScheduler----1------------");
		}
		if (this.scheduledFuture() != null) {
			System.out.println("---------CANCEL----------scheduledFuture------1----------");
			this.scheduledFuture().cancel(true);
		}
		if (configCrawlerRepository.findById(id).get().getScheduler() != null) {
			String cronString1 = configCrawlerRepository.findById(id).get().getScheduler();
			scheduledFuture = taskScheduler.schedule(new Runnable() {
				@Override
				public void run() {
					System.out.println("-----------All the scheduled tasks are here-------1---------------");
					verifiyJobBaitoru();
				}
			}, new CronTrigger(cronString1));
		}
		return ResponseEntity.noContent().build();
	}

	private ScheduledFuture<?> scheduledFuture() {
		return scheduledFuture;
	}

	@PutMapping("/updateConfigCrawlerShopName/{id}")
	public ResponseEntity<Object> renewScheduleForShopNameCleaning(@RequestBody ConfigCrawler configCrawler,
			@PathVariable long id) {

		Optional<ConfigCrawler> configCrawlerOptional = configCrawlerRepository.findById(id);
		if (!configCrawlerOptional.isPresent())
			return ResponseEntity.notFound().build();
		configCrawler.setId(id);
		configCrawlerRepository.save(configCrawler);

		if (taskSchedulerShopName == null) {
			this.taskSchedulerShopName = new ConcurrentTaskScheduler();
			System.out.println("---------CREATE----------ConcurrentTaskScheduler2----2------------");
		}
		if (this.scheduledFuture() != null) {
			System.out.println("---------CANCEL----------scheduledFuture2------2----------");
			this.scheduledFuture().cancel(true);
		}
		if (configCrawlerRepository.findById(id).get().getSchedulerShopName() != null) {
			String cronString1 = configCrawlerRepository.findById(id).get().getSchedulerShopName();
			scheduledFuture = taskSchedulerShopName.schedule(new Runnable() {
				@Override
				public void run() {
					System.out.println("-----------All the scheduled tasks are here-------2---------------");
					verifiyShopNameNotBanned();
				}
			}, new CronTrigger(cronString1));
		}
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/clean")
	public void verifiyShopNameNotBanned() {
		jobOtomeRepository.cleanJobs();
		System.out.println("jobs cleaned");
	}
	
	@GetMapping("/findCountShops")
	public int findCountShops() {
		return jobOtomeRepository.findCountShops();
		
	}
	
	public void verifiyJobBaitoru() {

		int countLineAff = (int) jobOtomeService.countBaitoruJobsAffiliateActivated();
		int lineAffPages = countLineAff / 2000;

		logger.info("***********countLineAff*************** \n {}", countLineAff);
		logger.info("***********lineAffPages***************\n {}", lineAffPages);

		int countBaituruAff = (int) jobOtomeService.countBaitoruJobsAffiliateActivated();
		int baitoruAffPages = countBaituruAff / 2000;

		int j = 0;

		try {
			while (j <= baitoruAffPages) {
				jobOtomeService.getBaitoruJobsAffiliateActivated(j, 2000).getContent().forEach(job -> {
					if (job.getJobURL() != null && job.isStatus()) {

						try {
							URL u = new URL("https://www.baitoru.com" + job.getJobURL());
							HttpURLConnection huc = (HttpURLConnection) u.openConnection();
							huc.setRequestMethod("GET");
							huc.connect();

							int code = huc.getResponseCode();
							if (code != 200) {
								logger.info("job id {}", job.getIdJob());
								logger.info("jobtype {}", job.getJobURL());

								JobOtome jobToEdit = jobOtomeService.findJobById(job.getIdJob()).get();
								jobToEdit.setStatus(false);
								jobOtomeService.saveJob(jobToEdit);
							} else {
								logger.info("valid url {}", u);
							}
						} catch (IOException e) {
							logger.error("error {}", e.getMessage());
						}
					}
				});

				j++;
			}

		} catch (Exception e) {
			logger.error("error {}", e);
		}
	}

}
