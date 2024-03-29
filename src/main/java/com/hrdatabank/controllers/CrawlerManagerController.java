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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * The Class CrawlerMangerCOntroller. still yet in developmenet
 * 
 * @author Hanios
 */

@RestController
@RequestMapping("/crawler")
@CrossOrigin(origins = "**")
public class CrawlerManagerController {

	/** The baitoru preparer impl. */
	@Autowired(required = true)
	BaitoruPreparerImpl baitoruPreparerImpl;

	/** The message. */
	protected String message;

	/** The jsen preparer impl. */
	@Autowired(required = true)
	JsenPreparerImpl jsenPreparerImpl;

	/** The job otome repository. */
	@Autowired
	protected JobOtomeRepository jobOtomeRepository;

	/** The job otome service. */
	@Autowired
	protected JobOtomeService jobOtomeService;

	/** The config crawler repository. */
	@Autowired
	ConfigCrawlerRepository configCrawlerRepository;

	/** The task scheduler. */
	private ConcurrentTaskScheduler taskScheduler;

	/** The task scheduler shop name. */
	private ConcurrentTaskScheduler taskSchedulerShopName;

	/** The task scheduler auto crawler. */
	private ConcurrentTaskScheduler taskSchedulerAutoCrawler;
	/** The scheduled future. */
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
	@ApiOperation(value = " Starting Full Search by crawler type ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success/ OK response"),
			@ApiResponse(code = 401, message = "Unauthorized Action"),
			@ApiResponse(code = 403, message = "Forbidden Action"),
			@ApiResponse(code = 500, message = "Internal Server ERROR ") })
	@GetMapping(value = "/startFullSearch")
	public String onStartingFullSearch(@RequestParam(name = "type") String type) {
		logger.info("startFullSearch{}", "");
		Optional<CrawlerTypesEnum> crawlerTypesEnum = Optional.ofNullable(Arrays.asList(CrawlerTypesEnum.values())
				.stream().filter(x -> type.equalsIgnoreCase(x.name())).findAny().orElse(null));
		crawlerTypesEnum.ifPresent(target -> {

			baitoruPreparerImpl.startFullCrawling();

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
	@ApiOperation(value = " Starting Part Search by crawler type")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success/ OK response"),
			@ApiResponse(code = 401, message = "Unauthorized Action"),
			@ApiResponse(code = 403, message = "Forbidden Action"),
			@ApiResponse(code = 500, message = "Internal Server ERROR ") })
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

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: CrawlerManagerController.java
	 * 
	 *         Shutdown.
	 * @param type
	 *            the type
	 * @return the response entity
	 */
	@PostMapping(value = "/shutdown")
	public ResponseEntity<?> shutdown(@RequestParam(name = "type") String type) {
		if (type.equalsIgnoreCase(CrawlerTypesEnum.BAITORU.name())) {
			baitoruPreparerImpl.stopCrawling();
		} else if (type.equalsIgnoreCase(CrawlerTypesEnum.JSEN.name())) {
			jsenPreparerImpl.stopCrawling();
		}

		return ResponseEntity.ok().build();
	}

	/**
	 * Renew schedule.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: CrawlerManagerController.java
	 * 
	 *         Renew schedule.
	 * @param configCrawler
	 *            the config crawler
	 * @param id
	 *            the id
	 * @return the response entity
	 */
	@ApiOperation(value = "Renew Schedule for 404 jobs removing")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success/ OK response"),
			@ApiResponse(code = 401, message = "Unauthorized Action"),
			@ApiResponse(code = 403, message = "Forbidden Action"),
			@ApiResponse(code = 500, message = "Internal Server ERROR ") })
	@PutMapping("/updateConfigCrawler/{id}")
	public ResponseEntity<Object> renewSchedule(@RequestBody ConfigCrawler configCrawler, @PathVariable long id) {

		Optional<ConfigCrawler> configCrawlerOptional = configCrawlerRepository.findById(id);
		if (!configCrawlerOptional.isPresent())
			return ResponseEntity.notFound().build();
		configCrawler.setId(id);
		configCrawlerRepository.save(configCrawler);

		if (taskScheduler == null) {
			this.taskScheduler = new ConcurrentTaskScheduler();
			logger.info("---------CREATE----------ConcurrentTaskScheduler----1------------{}", "");
		}
		if (this.scheduledFuture() != null) {
			logger.info("---------CANCEL----------scheduledFuture------1----------{}", "");
			this.scheduledFuture().cancel(true);
		}
		if (configCrawlerRepository.findById(id).get().getScheduler() != null) {
			String cronString1 = configCrawlerRepository.findById(id).get().getScheduler();
			scheduledFuture = taskScheduler.schedule(new Runnable() {
				@Override
				public void run() {
					logger.info("-----------All the scheduled tasks are here-------1---------------{}", "");
					verifiyJobBaitoru();
				}
			}, new CronTrigger(cronString1));
		}
		return ResponseEntity.noContent().build();
	}

	/**
	 * Scheduled future.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: CrawlerManagerController.java
	 * 
	 *         Scheduled future.
	 * @return the scheduled future
	 */
	private ScheduledFuture<?> scheduledFuture() {
		return scheduledFuture;
	}

	/**
	 * Renew schedule for shop name cleaning.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: CrawlerManagerController.java
	 * 
	 *         Renew schedule for shop name cleaning.
	 * @param configCrawler
	 *            the config crawler
	 * @param id
	 *            the id
	 * @return the response entity
	 */
	@ApiOperation(value = "renew Schedule For Shop Name Cleaning")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success/ OK response"),
			@ApiResponse(code = 401, message = "Unauthorized Action"),
			@ApiResponse(code = 403, message = "Forbidden Action"),
			@ApiResponse(code = 500, message = "Internal Server ERROR ") })
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
			logger.info("---------CREATE----------ConcurrentTaskScheduler2----2------------ {}", "");
		}
		if (this.scheduledFuture() != null) {
			logger.info("---------CANCEL----------scheduledFuture2------2----------{}", "");
			this.scheduledFuture().cancel(true);
		}
		if (configCrawlerRepository.findById(id).get().getSchedulerShopName() != null) {
			String cronString1 = configCrawlerRepository.findById(id).get().getSchedulerShopName();
			scheduledFuture = taskSchedulerShopName.schedule(new Runnable() {
				@Override
				public void run() {
					logger.info("-----------All the scheduled tasks are here-------2---------------{}", "");
					verifiyShopNameNotBanned();
				}
			}, new CronTrigger(cronString1));
		}
		return ResponseEntity.noContent().build();
	}

	/**
	 * Renew schedule for shop name cleaning.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: CrawlerManagerController.java
	 * 
	 *         Renew schedule auto crawling.
	 * @param configCrawler
	 *            the config crawler
	 * @param id
	 *            the id
	 * @return the response entity
	 */
	@ApiOperation(value = "renew Schedule For Auto crawling")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success/ OK response"),
			@ApiResponse(code = 401, message = "Unauthorized Action"),
			@ApiResponse(code = 403, message = "Forbidden Action"),
			@ApiResponse(code = 500, message = "Internal Server ERROR ") })
	@PutMapping("/updateConfigCrawlerAutoCrawling/{id}")
	public ResponseEntity<Object> renewScheduleAutoCrawling(@RequestBody ConfigCrawler configCrawler,
			@PathVariable long id) {

		Optional<ConfigCrawler> configCrawlerOptional = configCrawlerRepository.findById(id);
		if (!configCrawlerOptional.isPresent())
			return ResponseEntity.notFound().build();
		configCrawler.setId(id);
		configCrawlerRepository.save(configCrawler);

		if (taskSchedulerAutoCrawler == null) {
			this.taskSchedulerAutoCrawler = new ConcurrentTaskScheduler();
			logger.info("---------CREATE----------ConcurrentTaskScheduler3----3------------{}", "");
		}
		if (this.scheduledFuture() != null) {
			logger.info("---------CANCEL----------scheduledFuture3-----3----------{}", "");
			this.scheduledFuture().cancel(true);
		}
		if (configCrawlerRepository.findById(id).get().getSchedulerAutoCrawler() != null) {
			String cronString1 = configCrawlerRepository.findById(id).get().getSchedulerAutoCrawler();
			scheduledFuture = taskSchedulerAutoCrawler.schedule(new Runnable() {
				@Override
				public void run() {
					logger.info("-----------All the scheduled tasks are here-------3---------------{}", "");
					onStartingFullSearch(CrawlerTypesEnum.BAITORU.name());
				}
			}, new CronTrigger(cronString1));
		}
		return ResponseEntity.noContent().build();
	}

	/**
	 * Verifiy shop name not banned.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: CrawlerManagerController.java
	 * 
	 *         this method Verifiy shop name not banned.
	 */
	@ApiOperation(value = "verifiy Shop Name Not Banned")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success/ OK response"),
			@ApiResponse(code = 401, message = "Unauthorized Action"),
			@ApiResponse(code = 403, message = "Forbidden Action"),
			@ApiResponse(code = 500, message = "Internal Server ERROR ") })
	@GetMapping("/clean")
	public void verifiyShopNameNotBanned() {
		jobOtomeRepository.cleanJobs();
		logger.info("jobs cleaned{}", "");
	}

	/**
	 * Find count shops.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: CrawlerManagerController.java
	 * 
	 *         Find count shops.
	 * @return the int
	 */
	@ApiOperation(value = "Get Count Shops")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success/ OK response"),
			@ApiResponse(code = 401, message = "Unauthorized Action"),
			@ApiResponse(code = 403, message = "Forbidden Action"),
			@ApiResponse(code = 500, message = "Internal Server ERROR ") })
	@GetMapping("/findCountShops")
	public int findCountShops() {
		return jobOtomeRepository.findCountShops();

	}

	/**
	 * Verifiy job baitoru.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: CrawlerManagerController.java
	 * 
	 *         this method Verifiy job baitoru.
	 */
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
