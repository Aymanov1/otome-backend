package org.crawler.web.preparer;

/**
 * The Interface IAbstractPreparer.
 * 
 * @author Hanios
 */
public interface IAbstractPreparer {

	/**
	 * Start full crawling.
	 * 
	 * @author Hanios
	 */
	void startFullCrawling();

	/**
	 * Start part crawling.
	 * 
	 * @author Hanios
	 * @param area     the area
	 * @param category the category
	 */
	void startPartCrawling(String area, String category);

	void stopCrawling();
}
