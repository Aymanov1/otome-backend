/*
 * 
 */
package org.crawler.web.concurrent.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.crawler.web.crawlcontroller.BaitoruCrawlerController;
import org.crawler.web.crawler.BaitoruCrawler;
import org.crawler.web.initializer.BaitoruInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.hrdatabank.otome.repositories.ConfigCrawlerRepository;
import com.hrdatabank.otome.repositories.JobOtomeRepository;
import com.hrdatabank.otome.services.JobOtomeService;

/**
 * The Class CrawlerServiceLauncher.
 * 
 * @author Hanios
 */
@Service
public class BaitoruCrawlerServiceLauncherImpl implements ICrawlerServiceLauncher {

	/** The Constant LOGGER. */
	private static final Logger logger = LoggerFactory.getLogger(BaitoruCrawlerServiceLauncherImpl.class);

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
	@Async
	@Override
	public CompletableFuture<Boolean> startCrawlingURLs(List<String> urls) {
		try {
			BaitoruCrawlerController.getInstance().createController(urls, 50, BaitoruCrawler.class);

			BaitoruInitializer.getInstance().getJobDetails().forEach(j -> {
				try {
					logger.info("{}", j);
					jobOtomeRepository.saveAndFlush(j);
				} catch (Exception exception) {
					logger.error("Exception {}", exception);
				}
			});
			BaitoruInitializer.getInstance().getJobDetails().clear();
		} catch (Exception exception) {
			logger.error("Exception {}", exception);
		}

		return CompletableFuture.completedFuture(true);
	}

}
