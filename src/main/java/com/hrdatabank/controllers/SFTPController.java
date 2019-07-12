package com.hrdatabank.controllers;

import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;

import org.crawler.web.enumeration.CrawlerTypesEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrdatabank.otome.domain.ConfigCrawler;
import com.hrdatabank.otome.repositories.ConfigCrawlerRepository;
import com.hrdatabank.otome.services.JsenLacottoServiceImple;
import com.hrdatabank.otome.services.SFTPService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * The Class SFTPController.
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/sftp")
public class SFTPController {

	/** The log. */
	private static Logger log = LoggerFactory.getLogger(SFTPController.class);

	/** The sftp service. */
	@Autowired
	SFTPService sftpService;

	/** The host lacotto. */
	@Value("${hostLacotto}")
	private String hostLacotto;

	/** The user lacotto. */
	@Value("${userLacotto}")
	private String userLacotto;

	/** The password lacotto. */
	@Value("${passwordLacotto}")
	private String passwordLacotto;

	/** The path lacotto from. */
	@Value("${pathLacottoFrom}")
	private String pathLacottoFrom;

	/** The path lacotto destination. */
	@Value("${pathLacottoDestination}")
	private String pathLacottoDestination;

	/** The port lacotto. */
	@Value("${portLacotto}")
	private int portLacotto;

	/** The host jsen. */
	@Value("${hostJsen}")
	private String hostJsen;

	/** The user jsen. */
	@Value("${userJsen}")
	private String userJsen;

	/** The password jsen. */
	@Value("${passwordJsen}")
	private String passwordJsen;

	/** The path jsen from. */
	@Value("${pathJsenFrom}")
	private String pathJsenFrom;

	/** The path jsen destination. */
	@Value("${pathJsenDestination}")
	private String pathJsenDestination;

	/** The jsen lacotto service. */
	@Autowired
	JsenLacottoServiceImple jsenLacottoService;

	/** The config crawler repository. */
	@Autowired
	ConfigCrawlerRepository configCrawlerRepository;

	/** The task scheduler. */
	private ConcurrentTaskScheduler taskSchedulerJSEN;

	/** The task scheduler shop name. */
	private ConcurrentTaskScheduler taskSchedulerLacotto;

	/** The scheduled future. */
	@SuppressWarnings("rawtypes")
	private ScheduledFuture scheduledFuture;

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: SFTPController.java
	 * 
	 *         Renew schedule lacotto injection.
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
	@PutMapping("/updateConfigInjectorLacotto/{id}")
	public ResponseEntity<Object> renewScheduleLacottoInjection(@RequestBody ConfigCrawler configCrawler,
			@PathVariable long id) {

		Optional<ConfigCrawler> configCrawlerOptional = configCrawlerRepository.findById(id);
		if (!configCrawlerOptional.isPresent())
			return ResponseEntity.notFound().build();
		configCrawler.setId(id);
		configCrawlerRepository.save(configCrawler);

		if (taskSchedulerLacotto == null) {
			this.taskSchedulerLacotto = new ConcurrentTaskScheduler();
			log.info("---------CREATE----------ConcurrentTaskScheduler4----4------------{}", "");
		}
		if (this.scheduledFuture() != null) {
			log.info("---------CANCEL----------scheduledFuture4-----4----------{}", "");
			this.scheduledFuture().cancel(true);
		}
		if (configCrawlerRepository.findById(id).get().getSchedulerAutoCrawler() != null) {
			String cronString1 = configCrawlerRepository.findById(id).get().getSchedulerAutoInjectionLacotto();
			scheduledFuture = taskSchedulerLacotto.schedule(new Runnable() {
				@Override
				public void run() {
					log.info("-----------All the scheduled tasks are here-------4---------------{}", "");
					downloadFilesToServer(CrawlerTypesEnum.LACOTTO.toString());
					try {
						injectFilesToServer(CrawlerTypesEnum.LACOTTO.toString());
					} catch (InterruptedException | ExecutionException e) {
						e.printStackTrace();
					}
				}
			}, new CronTrigger(cronString1));
		}
		return ResponseEntity.noContent().build();
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
	 *         Class Name: SFTPController.java
	 * 
	 *         Renew schedule JSEN injection.
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
	@PutMapping("/updateConfigInjectorJSEN/{id}")
	public ResponseEntity<Object> renewScheduleJSENInjection(@RequestBody ConfigCrawler configCrawler,
			@PathVariable long id) {

		Optional<ConfigCrawler> configCrawlerOptional = configCrawlerRepository.findById(id);
		if (!configCrawlerOptional.isPresent())
			return ResponseEntity.notFound().build();
		configCrawler.setId(id);
		configCrawlerRepository.save(configCrawler);

		if (taskSchedulerJSEN == null) {
			this.taskSchedulerJSEN = new ConcurrentTaskScheduler();
			log.info("---------CREATE----------ConcurrentTaskScheduler5----5------------{}", "");
		}
		if (this.scheduledFuture() != null) {
			log.info("---------CANCEL----------scheduledFuture5----5----------{}", "");
			this.scheduledFuture().cancel(true);
		}
		if (configCrawlerRepository.findById(id).get().getSchedulerAutoCrawler() != null) {
			String cronString1 = configCrawlerRepository.findById(id).get().getSchedulerAutoInjectionJSEN();
			scheduledFuture = taskSchedulerJSEN.schedule(new Runnable() {
				@Override
				public void run() {
					log.info("-----------All the scheduled tasks are here-------5---------------{}", "");
					downloadFilesToServer(CrawlerTypesEnum.JSEN.toString());

					try {
						injectFilesToServer(CrawlerTypesEnum.JSEN.toString());
					} catch (InterruptedException | ExecutionException e) {
						e.printStackTrace();
					}

				}
			}, new CronTrigger(cronString1));
		}
		return ResponseEntity.noContent().build();
	}

	/**
	 * Download files to server.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: SFTPController.java
	 * 
	 *         Download files to server.
	 * @param serverType
	 *            the server type (LACOTTO-JSEN)
	 * @return the status of downloading from the SFTP/FTP server
	 */
	@ApiOperation(value = " Start retrieving files from SFTP/FTP by crawler type ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success/ OK response"),
			@ApiResponse(code = 401, message = "Unauthorized Action"),
			@ApiResponse(code = 403, message = "Forbidden Action"),
			@ApiResponse(code = 500, message = "Internal Server ERROR ") })
	@GetMapping(path = "/download/{serverType}")
	public String downloadFilesToServer(@PathVariable("serverType") String serverType) {
		if (serverType.equalsIgnoreCase(CrawlerTypesEnum.LACOTTO.toString())) {
			return sftpService.downloadFromServer(hostLacotto, userLacotto, passwordLacotto, portLacotto,
					pathLacottoFrom, pathLacottoDestination);

		} else if (serverType.equalsIgnoreCase(CrawlerTypesEnum.JSEN.toString())) {
			return sftpService.downloadFromFTPServer(hostJsen, userJsen, passwordJsen, pathJsenFrom,
					pathJsenDestination);
		}
		return "it seems there is a problem, please check the log for details";
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
	 *         Class Name: SFTPController.java
	 * 
	 *         Inject files to server.
	 * @param serverType
	 *            the server type
	 * @return the string
	 * @throws InterruptedException
	 *             the interrupted exception
	 * @throws ExecutionException
	 *             the execution exception
	 */
	@ApiOperation(value = " Start injecting csv files from SFTP/FTP by crawler type to Database")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success/ OK response"),
			@ApiResponse(code = 401, message = "Unauthorized Action"),
			@ApiResponse(code = 403, message = "Forbidden Action"),
			@ApiResponse(code = 500, message = "Internal Server ERROR ") })
	@GetMapping(path = "/inject/{serverType}")
	public String injectFilesToServer(@PathVariable("serverType") String serverType)
			throws InterruptedException, ExecutionException {
		if (serverType.equalsIgnoreCase(CrawlerTypesEnum.LACOTTO.toString())) {
			try {
				jsenLacottoService.getStopLacotto().set(false);
				jsenLacottoService.importCSVForLacottoJobsWithOpenCsv("/opt/tomcat/csv/lacotto_job_offer.csv");
				return "Done";
			} catch (Exception e) {
				log.error("error", e);
				return "not Done";
			}

		} else if (serverType.equalsIgnoreCase(CrawlerTypesEnum.JSEN.toString())) {
			try {
				jsenLacottoService.importJsenCSV("/opt/tomcat/csv/mb_works_for_joboty.csv");
				jsenLacottoService.getStopJsen().set(false);

				return "Done";
			} catch (Exception e) {
				log.error("error", e);
				return "not Done";
			}
		}
		return "it seems there is a problem, please check the log for details";
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
	 *         Class Name: SFTPController.java
	 * 
	 *         Stop.
	 * @param serverType
	 *            the server type
	 * @return the string
	 * @throws InterruptedException
	 *             the interrupted exception
	 * @throws ExecutionException
	 *             the execution exception
	 */
	@ApiOperation(value = " stop injecting csv files from SFTP/FTP by crawler type to Database")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success/ OK response"),
			@ApiResponse(code = 401, message = "Unauthorized Action"),
			@ApiResponse(code = 403, message = "Forbidden Action"),
			@ApiResponse(code = 500, message = "Internal Server ERROR ") })
	@GetMapping(path = "/inject/stop/{serverType}")
	public String stop(@PathVariable("serverType") String serverType) throws InterruptedException, ExecutionException {
		if (serverType.equalsIgnoreCase(CrawlerTypesEnum.LACOTTO.toString())) {
			jsenLacottoService.getStopLacotto().set(true);
		} else if (serverType.equalsIgnoreCase(CrawlerTypesEnum.JSEN.toString())) {
			jsenLacottoService.getStopJsen().set(true);
		}
		return "done";
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
	 *         Class Name: SFTPController.java
	 * 
	 *         Scheduled future.
	 * @return the scheduled future
	 */
	private ScheduledFuture<?> scheduledFuture() {
		return scheduledFuture;
	}

}
