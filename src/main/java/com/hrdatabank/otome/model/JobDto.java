package com.hrdatabank.otome.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;


/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Data

/**
 * Copyright (c) 2019 by HRDatabank. All rights reserved.
 *
 * @author Aymanov
 * 
 * Using JRE: 1.8
 * 
 * Project Name: otome-backend
 * 
 * Class Name: JobDto.java
 * 
 * Instantiates a new job dto.
 * @param idJob the id job
 * @param shopName the shop name
 * @param jobURL the job URL
 * @param positionName the position name
 * @param positionCategory the position category
 * @param shopAddress the shop address
 * @param hourlyWage the hourly wage
 * @param affiliateType the affiliate type
 * @param transportation the transportation
 * @param status the status
 * @param startTime the start time
 * @param finishTime the finish time
 */
@AllArgsConstructor
public class JobDto {
	
	/** The id job. */
	private long idJob;
	
	/** The shop name. */
	private String shopName;
	
	/** The job URL. */
	private String jobURL;
	
	/** The position name. */
	private String positionName;
	
	/** The position category. */
	private String positionCategory;
	
	/** The shop address. */
	private String shopAddress;
	
	/** The hourly wage. */
	private String hourlyWage;
	
	/** The affiliate type. */
	private String affiliateType;
	
	/** The transportation. */
	private boolean transportation;
	
	/** The status. */
	private boolean status;
	
	/** The start time. */
	private Date startTime;
	
	/** The finish time. */
	private Date finishTime;

}
