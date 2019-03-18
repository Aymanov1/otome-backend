package org.crawler.web.concurrent.service.collector;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface IURLServiceCollector {

	/**
	 * Find URLs.
	 *
	 * @author Hanios
	 * @param baseUrl
	 *            the base url
	 * @param enCategory
	 *            the en category
	 * @return the completable future
	 */
	public CompletableFuture<List<String>> findURLs(String baseUrl, String enCategory);
}
