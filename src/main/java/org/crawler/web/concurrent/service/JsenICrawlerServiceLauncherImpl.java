package org.crawler.web.concurrent.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.crawler.web.crawlcontroller.JsenCrawlerController;
import org.crawler.web.crawler.JsenCrawler;
import org.crawler.web.initializer.JsenInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrdatabank.otome.repositories.ConfigCrawlerRepository;
import com.hrdatabank.otome.repositories.JobOtomeRepository;
import com.hrdatabank.otome.services.JobOtomeService;

/**
 * The Class JsenICrawlerServiceLauncherImpl.
 */
@Service
public class JsenICrawlerServiceLauncherImpl implements ICrawlerServiceLauncher {
	/** The Constant LOGGER. */
	private static final Logger logger = LoggerFactory.getLogger(JsenICrawlerServiceLauncherImpl.class);

	/** The job otome repository. */
	@Autowired
	protected JobOtomeRepository jobOtomeRepository;

	/** The job otome service. */
	@Autowired
	protected JobOtomeService jobOtomeService;

	/** The config crawler repository. */
	@Autowired
	ConfigCrawlerRepository configCrawlerRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.crawler.web.concurrent.service.ICrawlerServiceLauncher#startCrawlingURLs(
	 * java.util.List)
	 */
	@Override
	public CompletableFuture<Boolean> startCrawlingURLs(List<String> urls) {
		try {
			JsenCrawlerController.getInstance().createController(urls, 50, JsenCrawler.class);

			JsenInitializer.getInstance().getJobDetails().forEach(j -> {
				try {
					logger.info("{}", j);
					jobOtomeRepository.saveAndFlush(j);
				} catch (Exception exception) {
					logger.error("Exception {}", exception);
				}
			});
			JsenInitializer.getInstance().getJobDetails().clear();
		} catch (Exception exception) {
			logger.error("Exception {}", exception);
		}

		return CompletableFuture.completedFuture(true);
	}

}
