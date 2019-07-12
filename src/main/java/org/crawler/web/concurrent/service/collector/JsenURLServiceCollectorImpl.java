package org.crawler.web.concurrent.service.collector;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

/**
 * The Class JsenURLServiceCollectorImpl.
 */
@Service
public class JsenURLServiceCollectorImpl implements IURLServiceCollector {
	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(JsenURLServiceCollectorImpl.class.getName());

	/** The max pages. */
	private int maxPages = 0;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.crawler.web.concurrent.service.collector.IURLServiceCollector#findURLs(
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public CompletableFuture<List<String>> findURLs(String baseUrl, String enCategory) {
		String url = enCategory + baseUrl;
		List<String> urls = new ArrayList<>();
		List<String> finalListURLs = new ArrayList<>();
		try {
			Document document = Jsoup.connect(url).get();
			Element elementsPaginator = document.selectFirst("em.u-font-l");
			if (elementsPaginator != null) {
				String pagesNumber = elementsPaginator.ownText();
				String intValue = pagesNumber.replaceAll("[^0-9]", "");
				divideAndRoundUp(Long.valueOf(intValue), 20L);
				maxPages = safeLongToInt(divideAndRoundUp(Long.valueOf(intValue), 20L));
			}
		} catch (Exception e) {
			LOGGER.warning("Error : {}" + e.getMessage());
		}

		for (int i = 1; i < maxPages; i++) {
			StringBuilder buf = new StringBuilder(url);
			int index = 22;
			buf.insert(index, "?page=" + (i + 1));
			String strUrl = buf.toString();
			urls.add(strUrl);
		}
		urls.forEach(e -> {
			Document doc;
			try {
				doc = Jsoup.connect(e).get();
				Elements elements = doc.select("a.p-works-card-wrapper-link");
				elements.forEach(r -> {
					finalListURLs.add("https://j-sen.jp" + r.attr("href"));
					LOGGER.info("https://j-sen.jp" + r.attr("href"));
				});
			} catch (IOException ex) {
				LOGGER.warning("Error : {}" + ex.getMessage());
			}

		});

		return CompletableFuture.completedFuture(finalListURLs);
	}

	/**
	 * Divide and round up.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: JsenURLServiceCollectorImpl.java
	 * 
	 *         Divide and round up.
	 * @param num
	 *            the num
	 * @param divisor
	 *            the divisor
	 * @return the long
	 */
	public static long divideAndRoundUp(long num, long divisor) {
		if (num == 0 || divisor == 0) {
			return 0;
		}

		int sign = (num > 0 ? 1 : -1) * (divisor > 0 ? 1 : -1);

		if (sign > 0) {
			return (num + divisor - 1) / divisor;
		} else {
			return (num / divisor);
		}
	}

	/**
	 * Safe long to int.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: JsenURLServiceCollectorImpl.java
	 * 
	 *         Safe long to int.
	 * @param l
	 *            the l
	 * @return the int
	 */
	public static int safeLongToInt(long l) {
		if (l < Integer.MIN_VALUE || l > Integer.MAX_VALUE) {
			throw new IllegalArgumentException(l + " cannot be cast to int without changing its value.");
		}
		return (int) l;
	}

}
