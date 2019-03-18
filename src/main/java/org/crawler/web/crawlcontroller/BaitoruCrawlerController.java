package org.crawler.web.crawlcontroller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

/**
 * The Class BaitoruCrawlerController.
 * 
 * @author Hanios
 */
public class BaitoruCrawlerController extends AbstractCrawlerController {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(BaitoruCrawlerController.class.getName());
	/** The Constant BAITORU_CRAWLER_CONTROLLER. */
	private static final BaitoruCrawlerController BAITORU_CRAWLER_CONTROLLER = new BaitoruCrawlerController();

	/**
	 * Instantiates a new baitoru crawler controller.
	 * 
	 * @author Hanios
	 */
	private BaitoruCrawlerController() {

	}

	/**
	 * Gets the single instance of BaitoruCrawlerController.
	 * 
	 * @author Hanios
	 * @return single instance of BaitoruCrawlerController
	 */
	public static BaitoruCrawlerController getInstance() {
		return BAITORU_CRAWLER_CONTROLLER;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.crawler.web.controllers.AbstractCrawlerController#createController(java.
	 * util.List, int, java.lang.Class)
	 */
	@Override
	public <T extends WebCrawler> void createController(List<String> urls, int numberOfPages, Class<T> crawlerClass) {
		try {
			CrawlConfig config = new CrawlConfig();

			config.setCrawlStorageFolder(crawlStorageFolder);
			config.setPolitenessDelay(1000);

			config.setMaxDepthOfCrawling(2);
			config.setMaxPagesToFetch(numberOfPages);
			config.setIncludeBinaryContentInCrawling(false);
			config.setResumableCrawling(false);

			PageFetcher pageFetcher = new PageFetcher(config);
			RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
			RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
			CrawlController controller;

			controller = new CrawlController(config, pageFetcher, robotstxtServer);

			urls.forEach(url -> controller.addSeed(url));

			controller.startNonBlocking(crawlerClass, numberOfCrawlers);
			controller.waitUntilFinish();
		} catch (Exception exception) {
			LOGGER.log(Level.SEVERE, "Exception", exception);
		}

	}

}
