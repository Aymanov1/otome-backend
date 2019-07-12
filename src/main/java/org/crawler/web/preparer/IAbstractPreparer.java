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
	 * @param area
	 *            the area
	 * @param category
	 *            the category
	 */
	void startPartCrawling(String area, String category);

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: IAbstractPreparer.java
	 * 
	 *         this method Stop crawling.
	 */
	void stopCrawling();
}
