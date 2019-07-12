package com.hrdatabank.otome.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostUpdate;

import lombok.Data;

/**
 * The Class ConfigCrawler.
 */
@Entity

/**
 * Copyright (c) 2019 by HRDatabank. All rights reserved.
 *
 * @author Aymanov
 * 
 * Using JRE: 1.8
 * 
 * Project Name: otome-backend
 * 
 * Class Name: ConfigCrawler.java
 * 
 * Instantiates a new config crawler.
 */
@Data
// @EntityListeners(JobSchedulerBaitoru.class)
public class ConfigCrawler {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	/** The scheduler. */
	private String scheduler;
	
	/** The scheduler shop name. */
	private String schedulerShopName;
	
	/** The scheduler auto crawler. */
	private String schedulerAutoCrawler;
	
	/** The scheduler auto injection JSEN. */
	private String schedulerAutoInjectionJSEN;
	
	/** The scheduler auto injection lacotto. */
	private String schedulerAutoInjectionLacotto;

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: ConfigCrawler.java
	 * 
	 * this method On post update.
	 */
	@PostUpdate
	void onPostUpdate() {
		System.out.println("MyEntity.onPostUpdate() " + scheduler);
	}
}
