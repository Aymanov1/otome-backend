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

// TODO: Auto-generated Javadoc
/**
 * The Class JsenCrawlerController.
 */
public class JsenCrawlerController extends AbstractCrawlerController {
	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(JsenCrawlerController.class.getName());

	/** The Constant JSEN_CRAWLER_CONTROLLER. */
	private static final JsenCrawlerController JSEN_CRAWLER_CONTROLLER = new JsenCrawlerController();

	/**
	 * Instantiates a new jsen crawler controller.
	 */
	private JsenCrawlerController() {

	}

	/**
	 * Gets the single instance of JsenCrawlerController.
	 *
	 * @return single instance of JsenCrawlerController
	 */
	public static JsenCrawlerController getInstance() {
		return JSEN_CRAWLER_CONTROLLER;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.crawler.web.crawcontroller.AbstractCrawlerController#createController(
	 * java.util.List, int, java.lang.Class)
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
