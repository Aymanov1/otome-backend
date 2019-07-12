package com.hrdatabank.otome.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class JobOtome.
 */
@Entity

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Data

/**
 * Instantiates a new job otome.
 *
 * @param idJob
 *            the id job
 * @param numberStaffNeeded
 *            the number staff needed
 * @param possibleWorkingDaysPerWeek
 *            the possible working days per week
 * @param possibleWorkingHoursPerDay
 *            the possible working hours per day
 * @param latitude
 *            the latitude
 * @param longitude
 *            the longitude
 * @param salary
 *            the salary
 * @param hourlyWage
 *            the hourly wage
 * @param shopName
 *            the shop name
 * @param companyName
 *            the company name
 * @param shopAddress
 *            the shop address
 * @param idJobDetail
 *            the id job detail
 * @param jobURL
 *            the job URL
 * @param workTimeEnglish
 *            the work time english
 * @param workTimeJapanese
 *            the work time japanese
 * @param positionName
 *            the position name
 * @param positionCategoryEnglish
 *            the position category english
 * @param positionCategoryJapanese
 *            the position category japanese
 * @param salaryDetail
 *            the salary detail
 * @param jobDetails
 *            the job details
 * @param jobType
 *            the job type
 * @param hourlyWageMemo
 *            the hourly wage memo
 * @param hourlyWageInTrainingPeriod
 *            the hourly wage in training period
 * @param pictureJob
 *            the picture job
 * @param perfecture
 *            the perfecture
 * @param affiliateType
 *            the affiliate type
 * @param tagRelationcontents
 *            the tag relationcontents
 * @param casePrice
 *            the case price
 * @param transportationAllowance
 *            the transportation allowance
 * @param status
 *            the status
 * @param openJobDate
 *            the open job date
 * @param validJobDate
 *            the valid job date
 * @param startTime
 *            the start time
 * @param finishTime
 *            the finish time
 */

/**
 * Copyright (c) 2019 by HRDatabank. All rights reserved.
 *
 * @author Aymanov
 * 
 * Using JRE: 1.8
 * 
 * Project Name: otome-backend
 * 
 * Class Name: JobOtome.java
 * 
 * Instantiates a new job otome.
 * @param idJob the id job
 * @param numberStaffNeeded the number staff needed
 * @param possibleWorkingDaysPerWeek the possible working days per week
 * @param possibleWorkingHoursPerDay the possible working hours per day
 * @param latitude the latitude
 * @param longitude the longitude
 * @param salary the salary
 * @param hourlyWage the hourly wage
 * @param shopName the shop name
 * @param companyName the company name
 * @param idJobDetail the id job detail
 * @param jobURL the job URL
 * @param workTimeEnglish the work time english
 * @param workTimeJapanese the work time japanese
 * @param positionName the position name
 * @param positionCategoryEnglish the position category english
 * @param positionCategoryJapanese the position category japanese
 * @param shopAddress the shop address
 * @param salaryDetail the salary detail
 * @param jobDetails the job details
 * @param jobType the job type
 * @param hourlyWageMemo the hourly wage memo
 * @param hourlyWageInTrainingPeriod the hourly wage in training period
 * @param pictureJob the picture job
 * @param perfecture the perfecture
 * @param affiliateType the affiliate type
 * @param tagRelationcontents the tag relationcontents
 * @param casePrice the case price
 * @param interviewType the interview type
 * @param minHoursPerDay the min hours per day
 * @param minWorkingDays the min working days
 * @param openJobDate the open job date
 * @param validJobDate the valid job date
 * @param transportation the transportation
 * @param status the status
 * @param startTime the start time
 * @param finishTime the finish time
 * @param injectionDate the injection date
 */
@AllArgsConstructor

/*
 * (non-Javadoc)
 * 
 * @see java.lang.Object#toString()
 */

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Builder
public class JobOtome implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The id job. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idJob;
	
	/** The number staff needed. */
	private int numberStaffNeeded;
	
	/** The possible working days per week. */
	private int possibleWorkingDaysPerWeek;
	
	/** The possible working hours per day. */
	private int possibleWorkingHoursPerDay;

	/** The latitude. */
	private Double latitude;
	
	/** The longitude. */
	private Double longitude;
	
	/** The salary. */
	private Double salary;
	
	/** The hourly wage. */
	private Double hourlyWage;

	/** The shop name. */
	private String shopName;
	
	/** The company name. */
	@Builder.Default
	private String companyName = "saint-media";
	
	/** The id job detail. */
	private String idJobDetail;
	
	/** The job URL. */
	private String jobURL;
	
	/** The work time english. */
	private String workTimeEnglish;
	
	/** The work time japanese. */
	private String workTimeJapanese;
	
	/** The position name. */
	@Column(length = 1100)
	private String positionName;
	
	/** The position category english. */
	private String positionCategoryEnglish;
	
	/** The position category japanese. */
	private String positionCategoryJapanese;
	
	/** The shop address. */
	private String shopAddress;
	
	/** The salary detail. */
	private String salaryDetail;
	
	/** The job details. */
	@Column(length = 1100)
	private String jobDetails;
	
	/** The job type. */
	private String jobType;
	
	/** The hourly wage memo. */
	private String hourlyWageMemo;
	
	/** The hourly wage in training period. */
	private String hourlyWageInTrainingPeriod;
	
	/** The picture job. */
	private String pictureJob;
	
	/** The perfecture. */
	private String perfecture;
	
	/** The affiliate type. */
	private String affiliateType;
	
	/** The tag relationcontents. */
	private String tagRelationcontents;
	
	/** The case price. */
	private String casePrice;
	
	/** The interview type. */
	private String interviewType;
	
	/** The min hours per day. */
	private String minHoursPerDay;
	
	/** The min working days. */
	private String minWorkingDays;

	/** The open job date. */
	private Date openJobDate;
	
	/** The valid job date. */
	private Date validJobDate;

	/** The transportation. */
	private boolean transportation;
	
	/** The status. */
	@Builder.Default
	private boolean status = true;

	/** The start time. */
	@Temporal(TemporalType.TIME)
	private Date startTime;
	
	/** The finish time. */
	@Temporal(TemporalType.TIME)
	private Date finishTime;
	
	/** The injection date. */
	@Temporal(TemporalType.TIME)
	private Date injectionDate;

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobOtome.java
	 * 
	 * Instantiates a new job otome.
	 * @param shopName the shop name
	 * @param imageURL the image URL
	 * @param jobDetailId the job detail id
	 * @param jobURL the job URL
	 * @param jobType the job type
	 * @param detail the detail
	 * @param positionName the position name
	 * @param address the address
	 * @param wage the wage
	 * @param transportation the transportation
	 * @param startTime the start time
	 * @param finishTime the finish time
	 */
	public JobOtome(String shopName, String imageURL, String jobDetailId, String jobURL, String jobType, String detail,
			String positionName, String address, String wage, boolean transportation, Date startTime, Date finishTime) {
		super();
		this.idJobDetail = jobDetailId;
		this.shopName = shopName;
		this.pictureJob = imageURL;
		this.jobURL = jobURL;
		this.status = true;
		this.jobType = jobType;
		this.jobDetails = detail;
		this.positionName = positionName;
		this.shopAddress = address;
		this.hourlyWageMemo = wage;
		this.transportation = transportation;
		this.startTime = startTime;
		this.finishTime = finishTime;
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobOtome.java
	 * 
	 * Instantiates a new job otome.
	 * @param shopName2 the shop name 2
	 * @param jobImgUrl the job img url
	 * @param jobUrl2 the job url 2
	 * @param categoryName the category name
	 * @param jobDescription the job description
	 * @param positionName2 the position name 2
	 * @param jobAddress the job address
	 * @param wage the wage
	 * @param minHoursPerDay the min hours per day
	 * @param minWorkingDays the min working days
	 * @param startTime2 the start time 2
	 * @param finishTime2 the finish time 2
	 * @param transportation2 the transportation 2
	 */
	public JobOtome(String shopName2, String jobImgUrl, String jobUrl2, String categoryName, String jobDescription,
			String positionName2, String jobAddress, String wage, String minHoursPerDay, String minWorkingDays,
			Date startTime2, Date finishTime2, boolean transportation2) {
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobOtome.java
	 * 
	 * Instantiates a new job otome.
	 */
	public JobOtome() {

	}
	
	
}
