package com.hrdatabank.mtproject.model;

import java.util.Date;
// TODO: Auto-generated Javadoc

/**
 * The Class JobDto.
 */
public class JobDto {

	/** The id job. */
	private int idJob;

	/** The id shop. */
	private int idShop;

	/** The id company. */
	private int idCompany;

	/** The name shop. */
	private String nameShop;

	/** The position name. */
	private String positionName;

	/** The phone shop. */
	private String phoneShop;

	/** The transportation allowance. */
	private boolean transportationAllowance;

	/** The possible working days per week. */
	private int possibleWorkingDaysPerWeek;

	/** The possible working hours per day. */
	private int possibleWorkingHoursPerDay;

	/** The hourly wage. */
	private Double hourlyWage;

	/** The picture job. */
	private String pictureJob;

	/** The required JLPT. */
	private String requiredJLPT;

	/** The required duration in japan. */
	private String requiredDurationInJapan;

	/** The interview type. */
	private String interviewType;

	/** The interview venue. */
	private String interviewVenue;

	/** The address shop. */
	private String addressShop;

	/** The interview date job. */
	private Date interviewDateJob;

	/** The nearest station detail. */
	private String nearestStationDetail;

	/** The latitude. */
	private Double latitude;

	/** The longitude. */
	private Double longitude;

	/** The job details. */
	private String jobDetails;

	/** The finish working time. */
	private Date finishWorkingTime;

	/** The start working time. */
	private Date startWorkingTime;

	/** The idob details. */
	private String idobDetails;
	/** The idjob details. */
	private String idjobDetails;

	private int idJobList;

	/** The id job detail. */
	private String idJobDetail;

	/** The job URL. */
	private String jobURL;

	/** The work time english. */
	private String workTimeEnglish;

	/** The work time japanese. */
	private String workTimeJapanese;

	/** The position category english. */
	private String positionCategoryEnglish;

	/** The position category japanese. */
	private String positionCategoryJapanese;

	/** The salary detail. */
	private String salaryDetail;

	/** The job type. */
	private String jobType;

	/** The training period. */
	private String trainingPeriod;

	/** The hourly wage memo. */
	private String hourlyWageMemo;

	/** The hourly wage in training period. */
	private String hourlyWageInTrainingPeriod;

	/** The work time detail. */
	private String workTimeDetail;

	/** The number staff needed. */
	private int numberStaffNeeded;

	/** The salary. */
	private double salary;

	/** The and requirement. */
	private boolean andRequirement;

	/** The status. */
	private boolean status;

	/** The open job date. */
	private Date openJobDate;

	/** The valid job date. */
	private Date validJobDate;

	/** The description shop. */
	private String descriptionShop;

	/** The category. */
	private String category;

	/** The open time. */
	private String openTime;

	/** The logo shop. */
	private String logoShop;

	/** The user id line. */
	private String userIdLine;

	/** The email shop. */
	private String emailShop;

	/** The phone number. */
	private String phoneNumber;

	/** The apply phone number. */
	private String applyPhoneNumber;

	/** The reference. */
	private String reference;

	/** The requirement. */
	private String requirement;

	/** The interview venue. */
	private String interviewVenueShop;

	/** The possible phone time. */
	private String possiblePhoneTime;

	/** The longitude. */
	private Double longitudeShop;

	/** The latitude. */
	private Double latitudeShop;

	/** The transportation allowance. */
	private boolean transportationAllowanceShop;

	/** The name company. */
	private String nameCompany;

	/** The logo company. */
	private String logoCompany;

	/** The description. */
	private String description;

	/** The phone number. */
	private String phoneNumberCompany;

	/** The address company. */
	private String addressCompany;

	/** The email company. */
	private String emailCompany;

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Gets the id job.
	 * @return the id job
	 */
	public int getIdJob() {
		return idJob;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Sets the id job.
	 * @param idJob
	 *            the new id job
	 */
	public void setIdJob(int idJob) {
		this.idJob = idJob;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Instantiates a new job dto.
	 * @param idJob
	 *            the id job
	 * @param idShop
	 *            the id shop
	 * @param idCompany
	 *            the id company
	 * @param nameShop
	 *            the name shop
	 * @param positionName
	 *            the position name
	 * @param hourlyWage
	 *            the hourly wage
	 * @param transportationAllowance
	 *            the transportation allowance
	 * @param possibleWorkingDaysPerWeek
	 *            the possible working days per week
	 * @param possibleWorkingHoursPerDay
	 *            the possible working hours per day
	 * @param pictureJob
	 *            the picture job
	 * @param requiredJLPT
	 *            the required JLPT
	 * @param requiredDurationInJapan
	 *            the required duration in japan
	 * @param interviewType
	 *            the interview type
	 * @param interviewVenue
	 *            the interview venue
	 * @param addressShop
	 *            the address shop
	 * @param phoneShop
	 *            the phone shop
	 * @param interviewDateJob
	 *            the interview date job
	 * @param nearestStationDetail
	 *            the nearest station detail
	 * @param latitude
	 *            the latitude
	 * @param longitude
	 *            the longitude
	 * @param jobDetails
	 *            the job details
	 * @param finishWorkingTime
	 *            the finish working time
	 * @param startWorkingTime
	 *            the start working time
	 * @param idobDetails
	 *            the idob details
	 */
	public JobDto(int idJob, int idShop, int idCompany, String nameShop, String positionName, Double hourlyWage,
			boolean transportationAllowance, int possibleWorkingDaysPerWeek, int possibleWorkingHoursPerDay,
			String pictureJob, String requiredJLPT, String requiredDurationInJapan, String interviewType,
			String interviewVenue, String addressShop, String phoneShop, Date interviewDateJob,
			String nearestStationDetail, Double latitude, Double longitude, String jobDetails, Date finishWorkingTime,
			Date startWorkingTime, String idobDetails, String jobURL) {
		super();
		this.idJob = idJob;
		this.idShop = idShop;
		this.idCompany = idCompany;
		this.nameShop = nameShop;
		this.positionName = positionName;
		this.hourlyWage = hourlyWage;
		this.transportationAllowance = transportationAllowance;
		this.possibleWorkingDaysPerWeek = possibleWorkingDaysPerWeek;
		this.possibleWorkingHoursPerDay = possibleWorkingHoursPerDay;
		this.pictureJob = pictureJob;
		this.requiredJLPT = requiredJLPT;
		this.requiredDurationInJapan = requiredDurationInJapan;
		this.interviewType = interviewType;
		this.interviewVenue = interviewVenue;
		this.addressShop = addressShop;
		this.phoneShop = phoneShop;
		this.interviewDateJob = interviewDateJob;
		this.nearestStationDetail = nearestStationDetail;
		this.latitude = latitude;
		this.longitude = longitude;
		this.jobDetails = jobDetails;
		this.finishWorkingTime = finishWorkingTime;
		this.startWorkingTime = startWorkingTime;
		this.idobDetails = idobDetails;
		this.jobURL = jobURL;
	}

	/**
	 * @author rihabkallel
	 * 
	 * 
	 *         constructor for recommendation
	 * @param idJob
	 * @param idShop
	 * @param idCompany
	 * @param nameShop
	 * @param positionName
	 * @param phoneShop
	 * @param transportationAllowance
	 * @param possibleWorkingDaysPerWeek
	 * @param possibleWorkingHoursPerDay
	 * @param hourlyWage
	 * @param pictureJob
	 * @param requiredJLPT
	 * @param requiredDurationInJapan
	 * @param interviewType
	 * @param interviewVenue
	 * @param addressShop
	 * @param interviewDateJob
	 * @param nearestStationDetail
	 * @param latitude
	 * @param longitude
	 * @param jobDetails
	 * @param finishWorkingTime
	 * @param startWorkingTime
	 * @param idobDetails
	 * @param idJobList
	 * @param idJobDetail
	 * @param jobURL
	 * @param workTimeEnglish
	 * @param workTimeJapanese
	 * @param positionCategoryEnglish
	 * @param positionCategoryJapanese
	 * @param salaryDetail
	 * @param jobType
	 * @param trainingPeriod
	 * @param hourlyWageMemo
	 * @param hourlyWageInTrainingPeriod
	 * @param workTimeDetail
	 * @param numberStaffNeeded
	 * @param salary
	 * @param andRequirement
	 * @param status
	 * @param openJobDate
	 * @param validJobDate
	 * @param descriptionShop
	 * @param category
	 * @param openTime
	 * @param logoShop
	 * @param userIdLine
	 * @param emailShop
	 * @param phoneNumber
	 * @param applyPhoneNumber
	 * @param reference
	 * @param requirement
	 * @param interviewVenueShop
	 * @param possiblePhoneTime
	 * @param longitudeShop
	 * @param latitudeShop
	 * @param transportationAllowanceShop
	 * @param nameCompany
	 * @param logoCompany
	 * @param description
	 * @param phoneNumberCompany
	 * @param addressCompany
	 * @param emailCompany
	 */
	public JobDto(int idJob, int idShop, int idCompany, String nameShop, String positionName, String phoneShop,
			int possibleWorkingDaysPerWeek, int possibleWorkingHoursPerDay, Double hourlyWage, String pictureJob,
			String requiredJLPT, String requiredDurationInJapan, String interviewType, String interviewVenue,
			String addressShop, Date interviewDateJob, Double latitude, Double longitude, String jobDetails,
			Date finishWorkingTime, Date startWorkingTime, String idjobDetails, int idJobList, String idJobDetail,
			String jobURL, String workTimeEnglish, String workTimeJapanese, String positionCategoryEnglish,
			String positionCategoryJapanese, String salaryDetail, String jobType, String trainingPeriod,
			String hourlyWageMemo, String hourlyWageInTrainingPeriod, String workTimeDetail, int numberStaffNeeded,
			double salary, boolean status, Date openJobDate, Date validJobDate, String descriptionShop, String category,
			String openTime, String logoShop, String userIdLine, String emailShop, String phoneNumber,
			String applyPhoneNumber, String reference, String requirement, String interviewVenueShop,
			String possiblePhoneTime, boolean transportationAllowanceShop, String nameCompany, String logoCompany,
			String description, String phoneNumberCompany, String addressCompany, String emailCompany) {
		super();
		this.idJob = idJob;
		this.idShop = idShop;
		this.idCompany = idCompany;
		this.nameShop = nameShop;
		this.positionName = positionName;
		this.phoneShop = phoneShop;
		this.possibleWorkingDaysPerWeek = possibleWorkingDaysPerWeek;
		this.possibleWorkingHoursPerDay = possibleWorkingHoursPerDay;
		this.hourlyWage = hourlyWage;
		this.pictureJob = pictureJob;
		this.requiredJLPT = requiredJLPT;
		this.requiredDurationInJapan = requiredDurationInJapan;
		this.interviewType = interviewType;
		this.interviewVenue = interviewVenue;
		this.addressShop = addressShop;
		this.interviewDateJob = interviewDateJob;
		this.latitude = latitude;
		this.longitude = longitude;
		this.jobDetails = jobDetails;
		this.finishWorkingTime = finishWorkingTime;
		this.startWorkingTime = startWorkingTime;
		this.idjobDetails = idjobDetails;
		this.idJobList = idJobList;
		this.idJobDetail = idJobDetail;
		this.jobURL = jobURL;
		this.workTimeEnglish = workTimeEnglish;
		this.workTimeJapanese = workTimeJapanese;
		this.positionCategoryEnglish = positionCategoryEnglish;
		this.positionCategoryJapanese = positionCategoryJapanese;
		this.salaryDetail = salaryDetail;
		this.jobType = jobType;
		this.trainingPeriod = trainingPeriod;
		this.hourlyWageMemo = hourlyWageMemo;
		this.hourlyWageInTrainingPeriod = hourlyWageInTrainingPeriod;
		this.workTimeDetail = workTimeDetail;
		this.numberStaffNeeded = numberStaffNeeded;
		this.salary = salary;
		this.status = status;
		this.openJobDate = openJobDate;
		this.validJobDate = validJobDate;
		this.descriptionShop = descriptionShop;
		this.category = category;
		this.openTime = openTime;
		this.logoShop = logoShop;
		this.userIdLine = userIdLine;
		this.emailShop = emailShop;
		this.phoneNumber = phoneNumber;
		this.applyPhoneNumber = applyPhoneNumber;
		this.reference = reference;
		this.requirement = requirement;
		this.interviewVenueShop = interviewVenueShop;
		this.possiblePhoneTime = possiblePhoneTime;
		this.transportationAllowanceShop = transportationAllowanceShop;
		this.nameCompany = nameCompany;
		this.logoCompany = logoCompany;
		this.description = description;
		this.phoneNumberCompany = phoneNumberCompany;
		this.addressCompany = addressCompany;
		this.emailCompany = emailCompany;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Gets the id shop.
	 * @return the id shop
	 */
	public int getIdShop() {
		return idShop;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Sets the id shop.
	 * @param idShop
	 *            the new id shop
	 */
	public void setIdShop(int idShop) {
		this.idShop = idShop;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Gets the id company.
	 * @return the id company
	 */
	public int getIdCompany() {
		return idCompany;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Sets the id company.
	 * @param idCompany
	 *            the new id company
	 */
	public void setIdCompany(int idCompany) {
		this.idCompany = idCompany;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Gets the name shop.
	 * @return the name shop
	 */
	public String getNameShop() {
		return nameShop;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Sets the name shop.
	 * @param nameShop
	 *            the new name shop
	 */
	public void setNameShop(String nameShop) {
		this.nameShop = nameShop;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Gets the position name.
	 * @return the position name
	 */
	public String getPositionName() {
		return positionName;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Sets the position name.
	 * @param positionName
	 *            the new position name
	 */
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Gets the hourly wage.
	 * @return the hourly wage
	 */
	public Double getHourlyWage() {
		return hourlyWage;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Sets the hourly wage.
	 * @param hourlyWage
	 *            the new hourly wage
	 */
	public void setHourlyWage(Double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Checks if is transportation allowance.
	 * @return true, if is transportation allowance
	 */
	public boolean isTransportationAllowance() {
		return transportationAllowance;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Sets the transportation allowance.
	 * @param transportationAllowance
	 *            the new transportation allowance
	 */
	public void setTransportationAllowance(boolean transportationAllowance) {
		this.transportationAllowance = transportationAllowance;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Gets the possible working days per week.
	 * @return the possible working days per week
	 */
	public int getPossibleWorkingDaysPerWeek() {
		return possibleWorkingDaysPerWeek;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Sets the possible working days per week.
	 * @param possibleWorkingDaysPerWeek
	 *            the new possible working days per week
	 */
	public void setPossibleWorkingDaysPerWeek(int possibleWorkingDaysPerWeek) {
		this.possibleWorkingDaysPerWeek = possibleWorkingDaysPerWeek;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Gets the possible working hours per day.
	 * @return the possible working hours per day
	 */
	public int getPossibleWorkingHoursPerDay() {
		return possibleWorkingHoursPerDay;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Sets the possible working hours per day.
	 * @param possibleWorkingHoursPerDay
	 *            the new possible working hours per day
	 */
	public void setPossibleWorkingHoursPerDay(int possibleWorkingHoursPerDay) {
		this.possibleWorkingHoursPerDay = possibleWorkingHoursPerDay;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Gets the picture job.
	 * @return the picture job
	 */
	public String getPictureJob() {
		return pictureJob;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Sets the picture job.
	 * @param pictureJob
	 *            the new picture job
	 */
	public void setPictureJob(String pictureJob) {
		this.pictureJob = pictureJob;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Gets the required JLPT.
	 * @return the required JLPT
	 */
	public String getRequiredJLPT() {
		return requiredJLPT;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Sets the required JLPT.
	 * @param requiredJLPT
	 *            the new required JLPT
	 */
	public void setRequiredJLPT(String requiredJLPT) {
		this.requiredJLPT = requiredJLPT;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Gets the required duration in japan.
	 * @return the required duration in japan
	 */
	public String getRequiredDurationInJapan() {
		return requiredDurationInJapan;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Sets the required duration in japan.
	 * @param requiredDurationInJapan
	 *            the new required duration in japan
	 */
	public void setRequiredDurationInJapan(String requiredDurationInJapan) {
		this.requiredDurationInJapan = requiredDurationInJapan;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Gets the interview type.
	 * @return the interview type
	 */
	public String getInterviewType() {
		return interviewType;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Sets the interview type.
	 * @param interviewType
	 *            the new interview type
	 */
	public void setInterviewType(String interviewType) {
		this.interviewType = interviewType;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Gets the interview venue.
	 * @return the interview venue
	 */
	public String getInterviewVenue() {
		return interviewVenue;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Sets the interview venue.
	 * @param interviewVenue
	 *            the new interview venue
	 */
	public void setInterviewVenue(String interviewVenue) {
		this.interviewVenue = interviewVenue;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Gets the address shop.
	 * @return the address shop
	 */
	public String getAddressShop() {
		return addressShop;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Sets the address shop.
	 * @param addressShop
	 *            the new address shop
	 */
	public void setAddressShop(String addressShop) {
		this.addressShop = addressShop;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Gets the interview date job.
	 * @return the interview date job
	 */
	public Date getInterviewDateJob() {
		return interviewDateJob;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Sets the interview date job.
	 * @param interviewDateJob
	 *            the new interview date job
	 */
	public void setInterviewDateJob(Date interviewDateJob) {
		this.interviewDateJob = interviewDateJob;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Gets the nearest station detail.
	 * @return the nearest station detail
	 */
	public String getNearestStationDetail() {
		return nearestStationDetail;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Sets the nearest station detail.
	 * @param nearestStationDetail
	 *            the new nearest station detail
	 */
	public void setNearestStationDetail(String nearestStationDetail) {
		this.nearestStationDetail = nearestStationDetail;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Gets the latitude.
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Sets the latitude.
	 * @param latitude
	 *            the new latitude
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Gets the longitude.
	 * @return the longitude
	 */
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Sets the longitude.
	 * @param longitude
	 *            the new longitude
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Gets the job details.
	 * @return the job details
	 */
	public String getJobDetails() {
		return jobDetails;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Sets the job details.
	 * @param jobDetails
	 *            the new job details
	 */
	public void setJobDetails(String jobDetails) {
		this.jobDetails = jobDetails;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Gets the finish working time.
	 * @return the finish working time
	 */
	public Date getFinishWorkingTime() {
		return finishWorkingTime;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Sets the finish working time.
	 * @param finishWorkingTime
	 *            the new finish working time
	 */
	public void setFinishWorkingTime(Date finishWorkingTime) {
		this.finishWorkingTime = finishWorkingTime;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Gets the start working time.
	 * @return the start working time
	 */
	public Date getStartWorkingTime() {
		return startWorkingTime;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Sets the start working time.
	 * @param startWorkingTime
	 *            the new start working time
	 */
	public void setStartWorkingTime(Date startWorkingTime) {
		this.startWorkingTime = startWorkingTime;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Gets the phone shop.
	 * @return the phone shop
	 */
	public String getPhoneShop() {
		return phoneShop;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Sets the phone shop.
	 * @param phoneShop
	 *            the new phone shop
	 */
	public void setPhoneShop(String phoneShop) {
		this.phoneShop = phoneShop;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Gets the idob details.
	 * @return the idob details
	 */
	public String getIdobDetails() {
		return idobDetails;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Sets the idob details.
	 * @param idobDetails
	 *            the new idob details
	 */
	public void setIdobDetails(String idobDetails) {
		this.idobDetails = idobDetails;
	}

	public String getIdjobDetails() {
		return idjobDetails;
	}

	public void setIdjobDetails(String idjobDetails) {
		this.idjobDetails = idjobDetails;
	}

	public int getIdJobList() {
		return idJobList;
	}

	public void setIdJobList(int idJobList) {
		this.idJobList = idJobList;
	}

	public String getIdJobDetail() {
		return idJobDetail;
	}

	public void setIdJobDetail(String idJobDetail) {
		this.idJobDetail = idJobDetail;
	}

	public String getJobURL() {
		return jobURL;
	}

	public void setJobURL(String jobURL) {
		this.jobURL = jobURL;
	}

	public String getWorkTimeEnglish() {
		return workTimeEnglish;
	}

	public void setWorkTimeEnglish(String workTimeEnglish) {
		this.workTimeEnglish = workTimeEnglish;
	}

	public String getWorkTimeJapanese() {
		return workTimeJapanese;
	}

	public void setWorkTimeJapanese(String workTimeJapanese) {
		this.workTimeJapanese = workTimeJapanese;
	}

	public String getPositionCategoryEnglish() {
		return positionCategoryEnglish;
	}

	public void setPositionCategoryEnglish(String positionCategoryEnglish) {
		this.positionCategoryEnglish = positionCategoryEnglish;
	}

	public String getPositionCategoryJapanese() {
		return positionCategoryJapanese;
	}

	public void setPositionCategoryJapanese(String positionCategoryJapanese) {
		this.positionCategoryJapanese = positionCategoryJapanese;
	}

	public String getSalaryDetail() {
		return salaryDetail;
	}

	public void setSalaryDetail(String salaryDetail) {
		this.salaryDetail = salaryDetail;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getTrainingPeriod() {
		return trainingPeriod;
	}

	public void setTrainingPeriod(String trainingPeriod) {
		this.trainingPeriod = trainingPeriod;
	}

	public String getHourlyWageMemo() {
		return hourlyWageMemo;
	}

	public void setHourlyWageMemo(String hourlyWageMemo) {
		this.hourlyWageMemo = hourlyWageMemo;
	}

	public String getHourlyWageInTrainingPeriod() {
		return hourlyWageInTrainingPeriod;
	}

	public void setHourlyWageInTrainingPeriod(String hourlyWageInTrainingPeriod) {
		this.hourlyWageInTrainingPeriod = hourlyWageInTrainingPeriod;
	}

	public String getWorkTimeDetail() {
		return workTimeDetail;
	}

	public void setWorkTimeDetail(String workTimeDetail) {
		this.workTimeDetail = workTimeDetail;
	}

	public int getNumberStaffNeeded() {
		return numberStaffNeeded;
	}

	public void setNumberStaffNeeded(int numberStaffNeeded) {
		this.numberStaffNeeded = numberStaffNeeded;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public boolean isAndRequirement() {
		return andRequirement;
	}

	public void setAndRequirement(boolean andRequirement) {
		this.andRequirement = andRequirement;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getOpenJobDate() {
		return openJobDate;
	}

	public void setOpenJobDate(Date openJobDate) {
		this.openJobDate = openJobDate;
	}

	public Date getValidJobDate() {
		return validJobDate;
	}

	public void setValidJobDate(Date validJobDate) {
		this.validJobDate = validJobDate;
	}

	public String getDescriptionShop() {
		return descriptionShop;
	}

	public void setDescriptionShop(String descriptionShop) {
		this.descriptionShop = descriptionShop;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getLogoShop() {
		return logoShop;
	}

	public void setLogoShop(String logoShop) {
		this.logoShop = logoShop;
	}

	public String getUserIdLine() {
		return userIdLine;
	}

	public void setUserIdLine(String userIdLine) {
		this.userIdLine = userIdLine;
	}

	public String getEmailShop() {
		return emailShop;
	}

	public void setEmailShop(String emailShop) {
		this.emailShop = emailShop;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getApplyPhoneNumber() {
		return applyPhoneNumber;
	}

	public void setApplyPhoneNumber(String applyPhoneNumber) {
		this.applyPhoneNumber = applyPhoneNumber;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public String getInterviewVenueShop() {
		return interviewVenueShop;
	}

	public void setInterviewVenueShop(String interviewVenueShop) {
		this.interviewVenueShop = interviewVenueShop;
	}

	public String getPossiblePhoneTime() {
		return possiblePhoneTime;
	}

	public void setPossiblePhoneTime(String possiblePhoneTime) {
		this.possiblePhoneTime = possiblePhoneTime;
	}

	public Double getLongitudeShop() {
		return longitudeShop;
	}

	public void setLongitudeShop(Double longitudeShop) {
		this.longitudeShop = longitudeShop;
	}

	public Double getLatitudeShop() {
		return latitudeShop;
	}

	public void setLatitudeShop(Double latitudeShop) {
		this.latitudeShop = latitudeShop;
	}

	public boolean isTransportationAllowanceShop() {
		return transportationAllowanceShop;
	}

	public void setTransportationAllowanceShop(boolean transportationAllowanceShop) {
		this.transportationAllowanceShop = transportationAllowanceShop;
	}

	public String getNameCompany() {
		return nameCompany;
	}

	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
	}

	public String getLogoCompany() {
		return logoCompany;
	}

	public void setLogoCompany(String logoCompany) {
		this.logoCompany = logoCompany;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoneNumberCompany() {
		return phoneNumberCompany;
	}

	public void setPhoneNumberCompany(String phoneNumberCompany) {
		this.phoneNumberCompany = phoneNumberCompany;
	}

	public String getAddressCompany() {
		return addressCompany;
	}

	public void setAddressCompany(String addressCompany) {
		this.addressCompany = addressCompany;
	}

	public String getEmailCompany() {
		return emailCompany;
	}

	public void setEmailCompany(String emailCompany) {
		this.emailCompany = emailCompany;
	}

}