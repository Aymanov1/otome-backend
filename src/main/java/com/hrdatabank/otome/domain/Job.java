package com.hrdatabank.otome.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

// TODO: Auto-generated Javadoc
/**
 * The Class Job.
 */
@Data
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
	@Column(length = 1337)
	private String salaryDetail;

	/** The job details. */
	@Column(length = 1337)
	private String jobDetails;

	/** The job type. */
	private String jobType;

	/** The training period. */
	@Column(length = 1337)
	private String trainingPeriod;

	/** The interview type. */
	private String interviewType;

	/** The required JLPT. */
	private String requiredJLPT;

	/** The required duration in japan. */
	private String requiredDurationInJapan;

	/** The hourly wage memo. */
	@Column(length = 1337)
	private String hourlyWageMemo;

	/** The hourly wage in training period. */
	@Column(length = 1337)
	private String hourlyWageInTrainingPeriod;

	/** The picture job. */
	@Column(length = 1337)
	private String pictureJob;

	/** The work time detail. */
	@Column(length = 1337)
	private String workTimeDetail;

	private String prefecture;

	private String affiliateType;
	@Column(length = 1337)
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

	@Column(columnDefinition = "varchar(255) default '0'")
	private String casePrice;

	@Temporal(TemporalType.TIME)
	private Date injectionDate;

}
