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

@Entity

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
@AllArgsConstructor

/*
 * (non-Javadoc)
 * 
 * @see java.lang.Object#toString()
 */
@Builder
public class JobOtome implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idJob;
	private int numberStaffNeeded;
	private int possibleWorkingDaysPerWeek;
	private int possibleWorkingHoursPerDay;

	private Double latitude;
	private Double longitude;
	private Double salary;
	private Double hourlyWage;

	private String shopName;
	@Builder.Default
	private String companyName = "saint-media";
	private String idJobDetail;
	private String jobURL;
	private String workTimeEnglish;
	private String workTimeJapanese;
	@Column(length = 1100)
	private String positionName;
	private String positionCategoryEnglish;
	private String positionCategoryJapanese;
	private String shopAddress;
	private String salaryDetail;
	@Column(length = 1100)
	private String jobDetails;
	private String jobType;
	private String hourlyWageMemo;
	private String hourlyWageInTrainingPeriod;
	private String pictureJob;
	private String perfecture;
	private String affiliateType;
	private String tagRelationcontents;
	private String casePrice;
	private String interviewType;
	private String minHoursPerDay;
	private String minWorkingDays;

	private Date openJobDate;
	private Date validJobDate;

	private boolean transportation;
	@Builder.Default
	private boolean status = true;

	@Temporal(TemporalType.TIME)
	private Date startTime;
	@Temporal(TemporalType.TIME)
	private Date finishTime;

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

	public JobOtome(String shopName2, String jobImgUrl, String jobUrl2, String categoryName, String jobDescription,
			String positionName2, String jobAddress, String wage, String minHoursPerDay, String minWorkingDays,
			Date startTime2, Date finishTime2, boolean transportation2) {
	}
}
