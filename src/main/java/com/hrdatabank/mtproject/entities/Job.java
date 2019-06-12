package com.hrdatabank.mtproject.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class Job.
 */
@Entity
public class Job implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id job. */
	@Id
	@SequenceGenerator(name = "jobidentifier", sequenceName = "JOB_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jobidentifier")
	private int idJob;

	/** The possible working days per week. */
	private int possibleWorkingDaysPerWeek;

	/** The possible working hours per day. */
	private int possibleWorkingHoursPerDay;

	/** The id job list. */
	@Column(columnDefinition = "int default 0")
	private int idJobList;

	/** The id job detail. */
	private String idJobDetail;

	/** The job URL. */
	private String jobURL;

	/** The work time english. */
	private String workTimeEnglish;

	/** The work time japanese. */
	private String workTimeJapanese;

	/** The position name. */
	private String positionName;

	/** The position category english. */
	private String positionCategoryEnglish;

	/** The position category japanese. */
	private String positionCategoryJapanese;

	/** The salary detail. */
	private String salaryDetail;

	/** The job details. */
	private String jobDetails;

	/** The job type. */
	private String jobType;

	/** The training period. */
	private String trainingPeriod;

	/** The interview type. */
	private String interviewType;

	/** The required JLPT. */
	private String requiredJLPT;

	/** The required duration in japan. */
	private String requiredDurationInJapan;

	/** The hourly wage memo. */
	private String hourlyWageMemo;

	/** The hourly wage in training period. */
	private String hourlyWageInTrainingPeriod;

	/** The picture job. */
	private String pictureJob;

	/** The work time detail. */
	private String workTimeDetail;

	private String prefecture;

	private String affiliateType;

	private String tagRelationcontents;

	/** The number staff needed. */
	private int numberStaffNeeded;

	/** The salary. */
	private double salary;

	/** The hourly wage. */
	private double hourlyWage;

	/** The and requirement. */
	@Column(columnDefinition = "boolean default true", nullable = true)
	private boolean andRequirement;

	/** The status. */
	@Column(columnDefinition = "boolean default false", nullable = false)
	private boolean status;

	@Column(columnDefinition = "boolean default false", nullable = false)
	private boolean checkedAlgorithm;

	/** The start working time. */
	@Temporal(TemporalType.TIME)
	private Date startWorkingTime;

	/** The finish working time. */
	@Temporal(TemporalType.TIME)
	private Date finishWorkingTime;

	/** The interview date job. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date interviewDateJob;

	/** The open job date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date openJobDate;

	/** The valid job date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date validJobDate;

	/** The shop. */
	@ManyToOne
	@JoinColumn(name = "idShop", referencedColumnName = "idShop")

	@JsonIgnoreProperties({ "jobs" })
	private Shop shop;

	/** The job candidate relations. */
	@OneToMany(mappedBy = "job", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({ "job" })
	private List<JobCandidateRelation> jobCandidateRelations;

	/** The job candidate relations. */
	@OneToMany(mappedBy = "job", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({ "job" })
	private List<JobTagRelation> jobTagRelations;

	@Column(columnDefinition = "varchar(255) default '0'")
	private String casePrice;

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: Job.java
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
	 *         Class Name: Job.java
	 * 
	 *         Sets the id job.
	 * @param idJob the new id job
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
	 *         Class Name: Job.java
	 * 
	 *         Gets the shop.
	 * @return the shop
	 */
	public Shop getShop() {
		return shop;
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
	 *         Class Name: Job.java
	 * 
	 *         Sets the shop.
	 * @param shop the new shop
	 */
	public void setShop(Shop shop) {
		this.shop = shop;
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
	 *         Class Name: Job.java
	 * 
	 *         Gets the job candidate relations.
	 * @return the job candidate relations
	 */
	public List<JobCandidateRelation> getJobCandidateRelations() {
		return jobCandidateRelations;
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
	 *         Class Name: Job.java
	 * 
	 *         Sets the job candidate relations.
	 * @param jobCandidateRelations the new job candidate relations
	 */
	public void setJobCandidateRelations(List<JobCandidateRelation> jobCandidateRelations) {
		this.jobCandidateRelations = jobCandidateRelations;
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
	 *         Class Name: Job.java
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
	 *         Class Name: Job.java
	 * 
	 *         Sets the position name.
	 * @param positionName the new position name
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
	 *         Class Name: Job.java
	 * 
	 *         Gets the position category english.
	 * @return the position category english
	 */
	public String getPositionCategoryEnglish() {
		return positionCategoryEnglish;
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
	 *         Class Name: Job.java
	 * 
	 *         Sets the position category english.
	 * @param positionCategoryEnglish the new position category english
	 */
	public void setPositionCategoryEnglish(String positionCategoryEnglish) {
		this.positionCategoryEnglish = positionCategoryEnglish;
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
	 *         Class Name: Job.java
	 * 
	 *         Gets the salary detail.
	 * @return the salary detail
	 */
	public String getSalaryDetail() {
		return salaryDetail;
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
	 *         Class Name: Job.java
	 * 
	 *         Sets the salary detail.
	 * @param salaryDetail the new salary detail
	 */
	public void setSalaryDetail(String salaryDetail) {
		this.salaryDetail = salaryDetail;
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
	 *         Class Name: Job.java
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
	 *         Class Name: Job.java
	 * 
	 *         Sets the job details.
	 * @param jobDetails the new job details
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
	 *         Class Name: Job.java
	 * 
	 *         Gets the number staff needed.
	 * @return the number staff needed
	 */
	public int getNumberStaffNeeded() {
		return numberStaffNeeded;
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
	 *         Class Name: Job.java
	 * 
	 *         Sets the number staff needed.
	 * @param numberStaffNeeded the new number staff needed
	 */
	public void setNumberStaffNeeded(int numberStaffNeeded) {
		this.numberStaffNeeded = numberStaffNeeded;
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
	 *         Class Name: Job.java
	 * 
	 *         Gets the salary.
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
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
	 *         Class Name: Job.java
	 * 
	 *         Sets the salary.
	 * @param salary the new salary
	 */
	public void setSalary(double salary) {
		this.salary = salary;
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
	 *         Class Name: Job.java
	 * 
	 *         Gets the hourly wage.
	 * @return the hourly wage
	 */
	public double getHourlyWage() {
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
	 *         Class Name: Job.java
	 * 
	 *         Sets the hourly wage.
	 * @param hourlyWage the new hourly wage
	 */
	public void setHourlyWage(double hourlyWage) {
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
	 *         Class Name: Job.java
	 * 
	 *         Gets the start working time.
	 * @return the start working time
	 */
	@JsonProperty
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
	 *         Class Name: Job.java
	 * 
	 *         Sets the start working time.
	 * @param startWorkingTime the new start working time
	 */
	@JsonIgnore
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
	 *         Class Name: Job.java
	 * 
	 *         Gets the finish working time.
	 * @return the finish working time
	 */
	@JsonProperty
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
	 *         Class Name: Job.java
	 * 
	 *         Sets the finish working time.
	 * @param finishWorkingTime the new finish working time
	 */
	@JsonIgnore
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
	 *         Class Name: Job.java
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
	 *         Class Name: Job.java
	 * 
	 *         Sets the possible working days per week.
	 * @param possibleWorkingDaysPerWeek the new possible working days per week
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
	 *         Class Name: Job.java
	 * 
	 *         Gets the training period.
	 * @return the training period
	 */
	public String getTrainingPeriod() {
		return trainingPeriod;
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
	 *         Class Name: Job.java
	 * 
	 *         Sets the training period.
	 * @param trainingPeriod the new training period
	 */
	public void setTrainingPeriod(String trainingPeriod) {
		this.trainingPeriod = trainingPeriod;
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
	 *         Class Name: Job.java
	 * 
	 *         Gets the hourly wage in training period.
	 * @return the hourly wage in training period
	 */
	public String getHourlyWageInTrainingPeriod() {
		return hourlyWageInTrainingPeriod;
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
	 *         Class Name: Job.java
	 * 
	 *         Sets the hourly wage in training period.
	 * @param hourlyWageInTrainingPeriod the new hourly wage in training period
	 */
	public void setHourlyWageInTrainingPeriod(String hourlyWageInTrainingPeriod) {
		this.hourlyWageInTrainingPeriod = hourlyWageInTrainingPeriod;
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
	 *         Class Name: Job.java
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
	 *         Class Name: Job.java
	 * 
	 *         Sets the possible working hours per day.
	 * @param possibleWorkingHoursPerDay the new possible working hours per day
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
	 *         Class Name: Job.java
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
	 *         Class Name: Job.java
	 * 
	 *         Sets the interview type.
	 * @param interviewType the new interview type
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
	 *         Class Name: Job.java
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
	 *         Class Name: Job.java
	 * 
	 *         Sets the required JLPT.
	 * @param requiredJLPT the new required JLPT
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
	 *         Class Name: Job.java
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
	 *         Class Name: Job.java
	 * 
	 *         Sets the required duration in japan.
	 * @param requiredDurationInJapan the new required duration in japan
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
	 *         Class Name: Job.java
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
	 *         Class Name: Job.java
	 * 
	 *         Sets the interview date job.
	 * @param interviewDateJob the new interview date job
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
	 *         Class Name: Job.java
	 * 
	 *         Gets the work time english.
	 * @return the work time english
	 */
	public String getWorkTimeEnglish() {
		return workTimeEnglish;
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
	 *         Class Name: Job.java
	 * 
	 *         Sets the work time english.
	 * @param workTimeEnglish the new work time english
	 */
	public void setWorkTimeEnglish(String workTimeEnglish) {
		this.workTimeEnglish = workTimeEnglish;
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
	 *         Class Name: Job.java
	 * 
	 *         Gets the work time japanese.
	 * @return the work time japanese
	 */
	public String getWorkTimeJapanese() {
		return workTimeJapanese;
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
	 *         Class Name: Job.java
	 * 
	 *         Sets the work time japanese.
	 * @param workTimeJapanese the new work time japanese
	 */
	public void setWorkTimeJapanese(String workTimeJapanese) {
		this.workTimeJapanese = workTimeJapanese;
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
	 *         Class Name: Job.java
	 * 
	 *         Gets the hourly wage memo.
	 * @return the hourly wage memo
	 */
	public String getHourlyWageMemo() {
		return hourlyWageMemo;
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
	 *         Class Name: Job.java
	 * 
	 *         Sets the hourly wage memo.
	 * @param hourlyWageMemo the new hourly wage memo
	 */
	public void setHourlyWageMemo(String hourlyWageMemo) {
		this.hourlyWageMemo = hourlyWageMemo;
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
	 *         Class Name: Job.java
	 * 
	 *         Gets the position category japanese.
	 * @return the position category japanese
	 */
	public String getPositionCategoryJapanese() {
		return positionCategoryJapanese;
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
	 *         Class Name: Job.java
	 * 
	 *         Sets the position category japanese.
	 * @param positionCategoryJapanese the new position category japanese
	 */
	public void setPositionCategoryJapanese(String positionCategoryJapanese) {
		this.positionCategoryJapanese = positionCategoryJapanese;
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
	 *         Class Name: Job.java
	 * 
	 *         Gets the job type.
	 * @return the job type
	 */
	public String getJobType() {
		return jobType;
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
	 *         Class Name: Job.java
	 * 
	 *         Sets the job type.
	 * @param jobType the new job type
	 */
	public void setJobType(String jobType) {
		this.jobType = jobType;
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
	 *         Class Name: Job.java
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
	 *         Class Name: Job.java
	 * 
	 *         Sets the picture job.
	 * @param pictureJob the new picture job
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
	 *         Class Name: Job.java
	 * 
	 *         Gets the open job date.
	 * @return the open job date
	 */
	public Date getOpenJobDate() {
		return openJobDate;
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
	 *         Class Name: Job.java
	 * 
	 *         Sets the open job date.
	 * @param openJobDate the new open job date
	 */
	public void setOpenJobDate(Date openJobDate) {
		this.openJobDate = openJobDate;
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
	 *         Class Name: Job.java
	 * 
	 *         Gets the valid job date.
	 * @return the valid job date
	 */
	public Date getValidJobDate() {
		return validJobDate;
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
	 *         Class Name: Job.java
	 * 
	 *         Sets the valid job date.
	 * @param validJobDate the new valid job date
	 */
	public void setValidJobDate(Date validJobDate) {
		this.validJobDate = validJobDate;
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
	 *         Class Name: Job.java
	 * 
	 *         Gets the work time detail.
	 * @return the work time detail
	 */
	public String getWorkTimeDetail() {
		return workTimeDetail;
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
	 *         Class Name: Job.java
	 * 
	 *         Sets the work time detail.
	 * @param workTimeDetail the new work time detail
	 */
	public void setWorkTimeDetail(String workTimeDetail) {
		this.workTimeDetail = workTimeDetail;
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
	 *         Class Name: Job.java
	 * 
	 *         Checks if is and requirement.
	 * @return true, if is and requirement
	 */
	public boolean isAndRequirement() {
		return andRequirement;
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
	 *         Class Name: Job.java
	 * 
	 *         Sets the and requirement.
	 * @param andRequirement the new and requirement
	 */
	public void setAndRequirement(boolean andRequirement) {
		this.andRequirement = andRequirement;
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
	 *         Class Name: Job.java
	 * 
	 *         Checks if is status.
	 * @return true, if is status
	 */
	public boolean isStatus() {
		return status;
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
	 *         Class Name: Job.java
	 * 
	 *         Sets the status.
	 * @param status the new status
	 */
	public void setStatus(boolean status) {
		this.status = status;
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
	 *         Class Name: Job.java
	 * 
	 *         Gets the id job detail.
	 * @return the id job detail
	 */
	public String getIdJobDetail() {
		return idJobDetail;
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
	 *         Class Name: Job.java
	 * 
	 *         Sets the id job detail.
	 * @param idJobDetail the new id job detail
	 */
	public void setIdJobDetail(String idJobDetail) {
		this.idJobDetail = idJobDetail;
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
	 *         Class Name: Job.java
	 * 
	 *         Gets the id job list.
	 * @return the id job list
	 */
	public int getIdJobList() {
		return idJobList;
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
	 *         Class Name: Job.java
	 * 
	 *         Sets the id job list.
	 * @param idJobList the new id job list
	 */
	public void setIdJobList(int idJobList) {
		this.idJobList = idJobList;
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
	 *         Class Name: Job.java
	 * 
	 *         Gets the job URL.
	 * @return the job URL
	 */
	public String getJobURL() {
		return jobURL;
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
	 *         Class Name: Job.java
	 * 
	 *         Sets the job URL.
	 * @param jobURL the new job URL
	 */
	public void setJobURL(String jobURL) {
		this.jobURL = jobURL;
	}

	public boolean isCheckedAlgorithm() {
		return checkedAlgorithm;
	}

	public void setCheckedAlgorithm(boolean checkedAlgorithm) {
		this.checkedAlgorithm = checkedAlgorithm;
	}

	public String getPrefecture() {
		return prefecture;
	}

	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}

	public String getAffiliateType() {
		return affiliateType;
	}

	public void setAffiliateType(String affiliateType) {
		this.affiliateType = affiliateType;
	}

	public List<JobTagRelation> getJobTagRelations() {
		return jobTagRelations;
	}

	public void setJobTagRelations(List<JobTagRelation> jobTagRelations) {
		this.jobTagRelations = jobTagRelations;
	}

	public String getTagRelationcontents() {
		return tagRelationcontents;
	}

	public void setTagRelationcontents(String tagRelationcontents) {
		this.tagRelationcontents = tagRelationcontents;
	}

	public String getCasePrice() {
		return casePrice;
	}

	public void setCasePrice(String casePrice) {
		this.casePrice = casePrice;
	}

}
