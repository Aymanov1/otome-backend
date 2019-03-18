package org.crawler.web.crawlcontroller;

import java.util.List;

import edu.uci.ics.crawler4j.crawler.WebCrawler;

/**
 * The Class AbstractCrawlerController.
 * 
 * @author Hanios
 */
public abstract class AbstractCrawlerController {

	/** The crawl storage folder. */
	protected String crawlStorageFolder = "C:/Users/Hamada/Documents/data";

	/** The number of crawlers. */
	protected int numberOfCrawlers = 200;

	/**
	 * Creates the controller.
	 *
	 * @author Hanios
	 * @param <T>
	 * @param urls
	 *            the urls
	 * @param numberOfPages
	 *            the number of pages
	 * @param crawlerClass
	 *            the crawler class
	 * @throws Exception
	 *             the exception
	 */
	public abstract <T extends WebCrawler> void createController(List<String> urls, int numberOfPages,
			Class<T> crawlerClass);
}
