package org.crawler.web.preparer;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.crawler.web.concurrent.service.JsenICrawlerServiceLauncherImpl;
import org.crawler.web.concurrent.service.collector.BaitoruURLServiceCollectorImpl;
import org.crawler.web.concurrent.service.collector.JsenURLServiceCollectorImpl;
import org.crawler.web.initializer.JsenInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// TODO: Auto-generated Javadoc
/**
 * The Class JsenPreparerImpl.
 */
@Component
public class JsenPreparerImpl implements IAbstractPreparer {
	/** The url service collector. */
	@Autowired
	private JsenURLServiceCollectorImpl jsenURLServiceCollectorImpl;

	/** The jsen I crawler service launcher impl. */
	@Autowired
	private JsenICrawlerServiceLauncherImpl jsenICrawlerServiceLauncherImpl;

	/** The Constant logger. */
	private static final Logger LOGGER = Logger.getLogger(BaitoruURLServiceCollectorImpl.class.getName());

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.crawler.web.preparer.IAbstractPreparer#startFullCrawling()
	 */
	@Override
	public void startFullCrawling() {
		JsenInitializer.getInstance().getJobMap().forEach((k, v) -> JsenInitializer.getInstance().getBasicsURLWebsite()
				.forEach((key, url) -> startPartCrawling(key, k)));

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
			System.out.println("area = " + area + "////category = " + category);
			CompletableFuture<List<String>> completableFuture = jsenURLServiceCollectorImpl.findURLs(
					JsenInitializer.getInstance().getBasicsURLWebsite().get(area),
					JsenInitializer.getInstance().getJobMap().get(category));
			CompletableFuture.allOf(completableFuture).join();
			CompletableFuture<Boolean> done = jsenICrawlerServiceLauncherImpl
					.startCrawlingURLs(completableFuture.get());
			CompletableFuture.allOf(done).join();
		} catch (InterruptedException | ExecutionException e) {
			LOGGER.log(Level.SEVERE, "startPartCrawling", e);
		}

	}

}
