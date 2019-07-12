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

	/** The id job list. */
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobDto.java
	 * 
	 *         Instantiates a new job dto.
	 * @param idJob            the id job
	 * @param idShop            the id shop
	 * @param idCompany            the id company
	 * @param nameShop            the name shop
	 * @param positionName            the position name
	 * @param hourlyWage            the hourly wage
	 * @param transportationAllowance            the transportation allowance
	 * @param possibleWorkingDaysPerWeek            the possible working days per week
	 * @param possibleWorkingHoursPerDay            the possible working hours per day
	 * @param pictureJob            the picture job
	 * @param requiredJLPT            the required JLPT
	 * @param requiredDurationInJapan            the required duration in japan
	 * @param interviewType            the interview type
	 * @param interviewVenue            the interview venue
	 * @param addressShop            the address shop
	 * @param phoneShop            the phone shop
	 * @param interviewDateJob            the interview date job
	 * @param nearestStationDetail            the nearest station detail
	 * @param latitude            the latitude
	 * @param longitude            the longitude
	 * @param jobDetails            the job details
	 * @param finishWorkingTime            the finish working time
	 * @param startWorkingTime            the start working time
	 * @param idobDetails            the idob details
	 * @param jobURL the job URL
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
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author rihabkallel
	 * 
	 * 
	 *         constructor for recommendation
	 * @param idJob the id job
	 * @param idShop the id shop
	 * @param idCompany the id company
	 * @param nameShop the name shop
	 * @param positionName the position name
	 * @param phoneShop the phone shop
	 * @param possibleWorkingDaysPerWeek the possible working days per week
	 * @param possibleWorkingHoursPerDay the possible working hours per day
	 * @param hourlyWage the hourly wage
	 * @param pictureJob the picture job
	 * @param requiredJLPT the required JLPT
	 * @param requiredDurationInJapan the required duration in japan
	 * @param interviewType the interview type
	 * @param interviewVenue the interview venue
	 * @param addressShop the address shop
	 * @param interviewDateJob the interview date job
	 * @param latitude the latitude
	 * @param longitude the longitude
	 * @param jobDetails the job details
	 * @param finishWorkingTime the finish working time
	 * @param startWorkingTime the start working time
	 * @param idjobDetails the idjob details
	 * @param idJobList the id job list
	 * @param idJobDetail the id job detail
	 * @param jobURL the job URL
	 * @param workTimeEnglish the work time english
	 * @param workTimeJapanese the work time japanese
	 * @param positionCategoryEnglish the position category english
	 * @param positionCategoryJapanese the position category japanese
	 * @param salaryDetail the salary detail
	 * @param jobType the job type
	 * @param trainingPeriod the training period
	 * @param hourlyWageMemo the hourly wage memo
	 * @param hourlyWageInTrainingPeriod the hourly wage in training period
	 * @param workTimeDetail the work time detail
	 * @param numberStaffNeeded the number staff needed
	 * @param salary the salary
	 * @param status the status
	 * @param openJobDate the open job date
	 * @param validJobDate the valid job date
	 * @param descriptionShop the description shop
	 * @param category the category
	 * @param openTime the open time
	 * @param logoShop the logo shop
	 * @param userIdLine the user id line
	 * @param emailShop the email shop
	 * @param phoneNumber the phone number
	 * @param applyPhoneNumber the apply phone number
	 * @param reference the reference
	 * @param requirement the requirement
	 * @param interviewVenueShop the interview venue shop
	 * @param possiblePhoneTime the possible phone time
	 * @param transportationAllowanceShop the transportation allowance shop
	 * @param nameCompany the name company
	 * @param logoCompany the logo company
	 * @param description the description
	 * @param phoneNumberCompany the phone number company
	 * @param addressCompany the address company
	 * @param emailCompany the email company
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * Gets the idjob details.
	 * @return the idjob details
	 */
	public String getIdjobDetails() {
		return idjobDetails;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the idjob details.
	 * @param idjobDetails the new idjob details
	 */
	public void setIdjobDetails(String idjobDetails) {
		this.idjobDetails = idjobDetails;
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
	 * Class Name: JobDto.java
	 * 
	 * Gets the id job list.
	 * @return the id job list
	 */
	public int getIdJobList() {
		return idJobList;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the id job list.
	 * @param idJobList the new id job list
	 */
	public void setIdJobList(int idJobList) {
		this.idJobList = idJobList;
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
	 * Class Name: JobDto.java
	 * 
	 * Gets the id job detail.
	 * @return the id job detail
	 */
	public String getIdJobDetail() {
		return idJobDetail;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the id job detail.
	 * @param idJobDetail the new id job detail
	 */
	public void setIdJobDetail(String idJobDetail) {
		this.idJobDetail = idJobDetail;
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
	 * Class Name: JobDto.java
	 * 
	 * Gets the job URL.
	 * @return the job URL
	 */
	public String getJobURL() {
		return jobURL;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the job URL.
	 * @param jobURL the new job URL
	 */
	public void setJobURL(String jobURL) {
		this.jobURL = jobURL;
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
	 * Class Name: JobDto.java
	 * 
	 * Gets the work time english.
	 * @return the work time english
	 */
	public String getWorkTimeEnglish() {
		return workTimeEnglish;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the work time english.
	 * @param workTimeEnglish the new work time english
	 */
	public void setWorkTimeEnglish(String workTimeEnglish) {
		this.workTimeEnglish = workTimeEnglish;
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
	 * Class Name: JobDto.java
	 * 
	 * Gets the work time japanese.
	 * @return the work time japanese
	 */
	public String getWorkTimeJapanese() {
		return workTimeJapanese;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the work time japanese.
	 * @param workTimeJapanese the new work time japanese
	 */
	public void setWorkTimeJapanese(String workTimeJapanese) {
		this.workTimeJapanese = workTimeJapanese;
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
	 * Class Name: JobDto.java
	 * 
	 * Gets the position category english.
	 * @return the position category english
	 */
	public String getPositionCategoryEnglish() {
		return positionCategoryEnglish;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the position category english.
	 * @param positionCategoryEnglish the new position category english
	 */
	public void setPositionCategoryEnglish(String positionCategoryEnglish) {
		this.positionCategoryEnglish = positionCategoryEnglish;
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
	 * Class Name: JobDto.java
	 * 
	 * Gets the position category japanese.
	 * @return the position category japanese
	 */
	public String getPositionCategoryJapanese() {
		return positionCategoryJapanese;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the position category japanese.
	 * @param positionCategoryJapanese the new position category japanese
	 */
	public void setPositionCategoryJapanese(String positionCategoryJapanese) {
		this.positionCategoryJapanese = positionCategoryJapanese;
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
	 * Class Name: JobDto.java
	 * 
	 * Gets the salary detail.
	 * @return the salary detail
	 */
	public String getSalaryDetail() {
		return salaryDetail;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the salary detail.
	 * @param salaryDetail the new salary detail
	 */
	public void setSalaryDetail(String salaryDetail) {
		this.salaryDetail = salaryDetail;
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
	 * Class Name: JobDto.java
	 * 
	 * Gets the job type.
	 * @return the job type
	 */
	public String getJobType() {
		return jobType;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the job type.
	 * @param jobType the new job type
	 */
	public void setJobType(String jobType) {
		this.jobType = jobType;
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
	 * Class Name: JobDto.java
	 * 
	 * Gets the training period.
	 * @return the training period
	 */
	public String getTrainingPeriod() {
		return trainingPeriod;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the training period.
	 * @param trainingPeriod the new training period
	 */
	public void setTrainingPeriod(String trainingPeriod) {
		this.trainingPeriod = trainingPeriod;
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
	 * Class Name: JobDto.java
	 * 
	 * Gets the hourly wage memo.
	 * @return the hourly wage memo
	 */
	public String getHourlyWageMemo() {
		return hourlyWageMemo;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the hourly wage memo.
	 * @param hourlyWageMemo the new hourly wage memo
	 */
	public void setHourlyWageMemo(String hourlyWageMemo) {
		this.hourlyWageMemo = hourlyWageMemo;
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
	 * Class Name: JobDto.java
	 * 
	 * Gets the hourly wage in training period.
	 * @return the hourly wage in training period
	 */
	public String getHourlyWageInTrainingPeriod() {
		return hourlyWageInTrainingPeriod;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the hourly wage in training period.
	 * @param hourlyWageInTrainingPeriod the new hourly wage in training period
	 */
	public void setHourlyWageInTrainingPeriod(String hourlyWageInTrainingPeriod) {
		this.hourlyWageInTrainingPeriod = hourlyWageInTrainingPeriod;
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
	 * Class Name: JobDto.java
	 * 
	 * Gets the work time detail.
	 * @return the work time detail
	 */
	public String getWorkTimeDetail() {
		return workTimeDetail;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the work time detail.
	 * @param workTimeDetail the new work time detail
	 */
	public void setWorkTimeDetail(String workTimeDetail) {
		this.workTimeDetail = workTimeDetail;
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
	 * Class Name: JobDto.java
	 * 
	 * Gets the number staff needed.
	 * @return the number staff needed
	 */
	public int getNumberStaffNeeded() {
		return numberStaffNeeded;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the number staff needed.
	 * @param numberStaffNeeded the new number staff needed
	 */
	public void setNumberStaffNeeded(int numberStaffNeeded) {
		this.numberStaffNeeded = numberStaffNeeded;
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
	 * Class Name: JobDto.java
	 * 
	 * Gets the salary.
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the salary.
	 * @param salary the new salary
	 */
	public void setSalary(double salary) {
		this.salary = salary;
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
	 * Class Name: JobDto.java
	 * 
	 * Checks if is and requirement.
	 * @return true, if is and requirement
	 */
	public boolean isAndRequirement() {
		return andRequirement;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the and requirement.
	 * @param andRequirement the new and requirement
	 */
	public void setAndRequirement(boolean andRequirement) {
		this.andRequirement = andRequirement;
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
	 * Class Name: JobDto.java
	 * 
	 * Checks if is status.
	 * @return true, if is status
	 */
	public boolean isStatus() {
		return status;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the status.
	 * @param status the new status
	 */
	public void setStatus(boolean status) {
		this.status = status;
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
	 * Class Name: JobDto.java
	 * 
	 * Gets the open job date.
	 * @return the open job date
	 */
	public Date getOpenJobDate() {
		return openJobDate;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the open job date.
	 * @param openJobDate the new open job date
	 */
	public void setOpenJobDate(Date openJobDate) {
		this.openJobDate = openJobDate;
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
	 * Class Name: JobDto.java
	 * 
	 * Gets the valid job date.
	 * @return the valid job date
	 */
	public Date getValidJobDate() {
		return validJobDate;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the valid job date.
	 * @param validJobDate the new valid job date
	 */
	public void setValidJobDate(Date validJobDate) {
		this.validJobDate = validJobDate;
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
	 * Class Name: JobDto.java
	 * 
	 * Gets the description shop.
	 * @return the description shop
	 */
	public String getDescriptionShop() {
		return descriptionShop;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the description shop.
	 * @param descriptionShop the new description shop
	 */
	public void setDescriptionShop(String descriptionShop) {
		this.descriptionShop = descriptionShop;
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
	 * Class Name: JobDto.java
	 * 
	 * Gets the category.
	 * @return the category
	 */
	public String getCategory() {
		return category;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the category.
	 * @param category the new category
	 */
	public void setCategory(String category) {
		this.category = category;
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
	 * Class Name: JobDto.java
	 * 
	 * Gets the open time.
	 * @return the open time
	 */
	public String getOpenTime() {
		return openTime;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the open time.
	 * @param openTime the new open time
	 */
	public void setOpenTime(String openTime) {
		this.openTime = openTime;
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
	 * Class Name: JobDto.java
	 * 
	 * Gets the logo shop.
	 * @return the logo shop
	 */
	public String getLogoShop() {
		return logoShop;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the logo shop.
	 * @param logoShop the new logo shop
	 */
	public void setLogoShop(String logoShop) {
		this.logoShop = logoShop;
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
	 * Class Name: JobDto.java
	 * 
	 * Gets the user id line.
	 * @return the user id line
	 */
	public String getUserIdLine() {
		return userIdLine;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the user id line.
	 * @param userIdLine the new user id line
	 */
	public void setUserIdLine(String userIdLine) {
		this.userIdLine = userIdLine;
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
	 * Class Name: JobDto.java
	 * 
	 * Gets the email shop.
	 * @return the email shop
	 */
	public String getEmailShop() {
		return emailShop;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the email shop.
	 * @param emailShop the new email shop
	 */
	public void setEmailShop(String emailShop) {
		this.emailShop = emailShop;
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
	 * Class Name: JobDto.java
	 * 
	 * Gets the phone number.
	 * @return the phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the phone number.
	 * @param phoneNumber the new phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	 * Class Name: JobDto.java
	 * 
	 * Gets the apply phone number.
	 * @return the apply phone number
	 */
	public String getApplyPhoneNumber() {
		return applyPhoneNumber;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the apply phone number.
	 * @param applyPhoneNumber the new apply phone number
	 */
	public void setApplyPhoneNumber(String applyPhoneNumber) {
		this.applyPhoneNumber = applyPhoneNumber;
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
	 * Class Name: JobDto.java
	 * 
	 * Gets the reference.
	 * @return the reference
	 */
	public String getReference() {
		return reference;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the reference.
	 * @param reference the new reference
	 */
	public void setReference(String reference) {
		this.reference = reference;
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
	 * Class Name: JobDto.java
	 * 
	 * Gets the requirement.
	 * @return the requirement
	 */
	public String getRequirement() {
		return requirement;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the requirement.
	 * @param requirement the new requirement
	 */
	public void setRequirement(String requirement) {
		this.requirement = requirement;
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
	 * Class Name: JobDto.java
	 * 
	 * Gets the interview venue shop.
	 * @return the interview venue shop
	 */
	public String getInterviewVenueShop() {
		return interviewVenueShop;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the interview venue shop.
	 * @param interviewVenueShop the new interview venue shop
	 */
	public void setInterviewVenueShop(String interviewVenueShop) {
		this.interviewVenueShop = interviewVenueShop;
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
	 * Class Name: JobDto.java
	 * 
	 * Gets the possible phone time.
	 * @return the possible phone time
	 */
	public String getPossiblePhoneTime() {
		return possiblePhoneTime;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the possible phone time.
	 * @param possiblePhoneTime the new possible phone time
	 */
	public void setPossiblePhoneTime(String possiblePhoneTime) {
		this.possiblePhoneTime = possiblePhoneTime;
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
	 * Class Name: JobDto.java
	 * 
	 * Gets the longitude shop.
	 * @return the longitude shop
	 */
	public Double getLongitudeShop() {
		return longitudeShop;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the longitude shop.
	 * @param longitudeShop the new longitude shop
	 */
	public void setLongitudeShop(Double longitudeShop) {
		this.longitudeShop = longitudeShop;
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
	 * Class Name: JobDto.java
	 * 
	 * Gets the latitude shop.
	 * @return the latitude shop
	 */
	public Double getLatitudeShop() {
		return latitudeShop;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the latitude shop.
	 * @param latitudeShop the new latitude shop
	 */
	public void setLatitudeShop(Double latitudeShop) {
		this.latitudeShop = latitudeShop;
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
	 * Class Name: JobDto.java
	 * 
	 * Checks if is transportation allowance shop.
	 * @return true, if is transportation allowance shop
	 */
	public boolean isTransportationAllowanceShop() {
		return transportationAllowanceShop;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the transportation allowance shop.
	 * @param transportationAllowanceShop the new transportation allowance shop
	 */
	public void setTransportationAllowanceShop(boolean transportationAllowanceShop) {
		this.transportationAllowanceShop = transportationAllowanceShop;
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
	 * Class Name: JobDto.java
	 * 
	 * Gets the name company.
	 * @return the name company
	 */
	public String getNameCompany() {
		return nameCompany;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the name company.
	 * @param nameCompany the new name company
	 */
	public void setNameCompany(String nameCompany) {
		this.nameCompany = nameCompany;
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
	 * Class Name: JobDto.java
	 * 
	 * Gets the logo company.
	 * @return the logo company
	 */
	public String getLogoCompany() {
		return logoCompany;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the logo company.
	 * @param logoCompany the new logo company
	 */
	public void setLogoCompany(String logoCompany) {
		this.logoCompany = logoCompany;
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
	 * Class Name: JobDto.java
	 * 
	 * Gets the description.
	 * @return the description
	 */
	public String getDescription() {
		return description;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the description.
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * Class Name: JobDto.java
	 * 
	 * Gets the phone number company.
	 * @return the phone number company
	 */
	public String getPhoneNumberCompany() {
		return phoneNumberCompany;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the phone number company.
	 * @param phoneNumberCompany the new phone number company
	 */
	public void setPhoneNumberCompany(String phoneNumberCompany) {
		this.phoneNumberCompany = phoneNumberCompany;
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
	 * Class Name: JobDto.java
	 * 
	 * Gets the address company.
	 * @return the address company
	 */
	public String getAddressCompany() {
		return addressCompany;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the address company.
	 * @param addressCompany the new address company
	 */
	public void setAddressCompany(String addressCompany) {
		this.addressCompany = addressCompany;
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
	 * Class Name: JobDto.java
	 * 
	 * Gets the email company.
	 * @return the email company
	 */
	public String getEmailCompany() {
		return emailCompany;
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
	 * Class Name: JobDto.java
	 * 
	 * Sets the email company.
	 * @param emailCompany the new email company
	 */
	public void setEmailCompany(String emailCompany) {
		this.emailCompany = emailCompany;
	}

}