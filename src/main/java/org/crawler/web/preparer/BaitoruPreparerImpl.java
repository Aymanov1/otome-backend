package org.crawler.web.preparer;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.crawler.web.concurrent.service.BaitoruCrawlerServiceLauncherImpl;
import org.crawler.web.concurrent.service.collector.BaitoruURLServiceCollectorImpl;
import org.crawler.web.initializer.BaitoruInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The Class BaitoruPreparer.
 * 
 * @author Hanios
 */
@Component
public class BaitoruPreparerImpl implements IAbstractPreparer {

	/** The url service collector. */
	@Autowired
	private BaitoruURLServiceCollectorImpl baitoruURLServiceCollectorImpl;

	/** The baitoru crawler service launcher impl. */
	@Autowired
	private BaitoruCrawlerServiceLauncherImpl baitoruCrawlerServiceLauncherImpl;

	/** The Constant logger. */
	private static final Logger LOGGER = Logger.getLogger(BaitoruURLServiceCollectorImpl.class.getName());

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.crawler.web.preparer.AbstractPreparer#fillCategoryAreaMap()
	 */
	@Override
	public void startFullCrawling() {
		BaitoruInitializer.getInstance().getJobMap().forEach((k, v) -> BaitoruInitializer.getInstance()
				.getBasicsURLWebsite().forEach((key, url) -> startPartCrawling(key, k)));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.crawler.web.preparer.IAbstractPreparer#startPartCrawling(java.lang.
	 * String, java.lang.String)
	 */
	@Override
	public void startPartCrawling(String area, String category) {
		try {
			CompletableFuture<List<String>> completableFuture = baitoruURLServiceCollectorImpl.findURLs(
					BaitoruInitializer.getInstance().getBasicsURLWebsite().get(area),
					BaitoruInitializer.getInstance().getJobMap().get(category));
			CompletableFuture.allOf(completableFuture).join();
			CompletableFuture<Boolean> done = baitoruCrawlerServiceLauncherImpl
					.startCrawlingURLs(completableFuture.get());
			CompletableFuture.allOf(done).join();
		} catch (InterruptedException | ExecutionException e) {
			LOGGER.log(Level.SEVERE, "startPartCrawling", e);
		}
	}

}
