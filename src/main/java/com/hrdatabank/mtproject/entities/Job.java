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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

// TODO: Auto-generated Javadoc
/**
 * The Class Job.
 */
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
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
}
