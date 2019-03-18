package org.crawler.web.concurrent.service.collector;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * The Class BaitoruURLServiceCollectorImpl.
 * 
 * @author Hanios
 */
@Service
public class BaitoruURLServiceCollectorImpl implements IURLServiceCollector {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(BaitoruURLServiceCollectorImpl.class.getName());

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.crawler.web.concurrent.service.IURLServiceCollector#findURLs(java.lang.
	 * String, java.lang.String)
	 */
	@Async
	@Override
	public CompletableFuture<List<String>> findURLs(String baseUrl, String enCategory) {
		List<String> urls = new ArrayList<>();
		String url = baseUrl + "" + enCategory + "/part/";
		urls.add(url);
		int maxPages = 0;
		try {
			Document document = Jsoup.connect(url).get();
			Element elementsPaginator = document.select("div.common-globalPager").first();
			if (elementsPaginator != null) {
				Elements liElements = elementsPaginator.select("li");
				if (liElements.size() > 1)
					maxPages = Integer.parseInt(liElements.get(liElements.size() - 2).child(0).ownText());
				else
					maxPages = Integer.parseInt(liElements.get(liElements.size() - 1).child(0).ownText());
			}
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
		}

		for (int i = 1; i < maxPages; i++) {
			url = baseUrl + "" + enCategory + "/page" + (i + 1) + "/part"; // for part time we add part url /part/
			urls.add(url);
		}

		return CompletableFuture.completedFuture(urls);
	}

}
