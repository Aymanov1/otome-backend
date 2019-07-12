package org.crawler.web.concurrent.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * The Interface ICrawlerServiceLauncher.
 */
public interface ICrawlerServiceLauncher {

	/**
	 * Start crawling URLs.
	 * 
	 * @author Hanios
	 * @param urls
	 *            the urls
	 * @return the completable future
	 */
	CompletableFuture<Boolean> startCrawlingURLs(List<String> urls);
}
