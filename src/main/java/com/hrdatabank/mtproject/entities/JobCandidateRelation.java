package com.hrdatabank.mtproject.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
 * The Class JobCandidateRelation.
 */
@Entity

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Builder

/**
 * Copyright (c) 2019 by HRDatabank. All rights reserved.
 *
 * @author Aymanov
 * 
 * Using JRE: 1.8
 * 
 * Project Name: otome-backend
 * 
 * Class Name: JobCandidateRelation.java
 * 
 * Instantiates a new job candidate relation.
 */
@NoArgsConstructor

/**
 * Copyright (c) 2019 by HRDatabank. All rights reserved.
 *
 * @author Aymanov
 * 
 * Using JRE: 1.8
 * 
 * Project Name: otome-backend
 * 
 * Class Name: JobCandidateRelation.java
 * 
 * Instantiates a new job candidate relation.
 * @param jobCandidateRelationPK the job candidate relation PK
 * @param callShopMessageCounter the call shop message counter
 * @param noCallOrForgotReason the no call or forgot reason
 * @param noTalkWithShop the no talk with shop
 * @param askTalkWithShop the ask talk with shop
 * @param progress the progress
 * @param shopProgress the shop progress
 * @param botChekProgress the bot chek progress
 * @param paymentStatus the payment status
 * @param candidateName the candidate name
 * @param candidateNameKatakana the candidate name katakana
 * @param candidatePhone the candidate phone
 * @param candidateJLPT the candidate JLPT
 * @param candidateDurationInJapan the candidate duration in japan
 * @param offered the offered
 * @param applied the applied
 * @param matched the matched
 * @param privacyPolicyChecked the privacy policy checked
 * @param paid the paid
 * @param approved the approved
 * @param approveDate the approve date
 * @param startingDate the starting date
 * @param candidateBirthday the candidate birthday
 * @param offerDate the offer date
 * @param appliedDate the applied date
 * @param matchDate the match date
 * @param postedDate the posted date
 * @param noTalkWithShopDate the no talk with shop date
 * @param noCallOrForgotDate the no call or forgot date
 * @param callShopMessageDate the call shop message date
 * @param interviewDate the interview date
 * @param remindInterviewDate the remind interview date
 * @param remindInterviewDayDate the remind interview day date
 * @param askForWhenInterviewDate the ask for when interview date
 * @param askCandidateHowWasInterviewDate the ask candidate how was interview date
 * @param resultInterviewDate the result interview date
 * @param startWorkingDate the start working date
 * @param youStartWorkingTodayDate the you start working today date
 * @param askForResultDateCandidate the ask for result date candidate
 * @param askForSetInterview the ask for set interview
 * @param askShopHowWasInterviewDate the ask shop how was interview date
 * @param requestMonth the request month
 * @param candidate the candidate
 * @param job the job
 * @param chat the chat
 * @param casePrice the case price
 * @param applyDateCp the apply date cp
 * @param validityPeriodCp the validity period cp
 * @param birthdateCp the birthdate cp
 * @param validityDateCp the validity date cp
 * @param staffNameCp the staff name cp
 * @param candidateNameCp the candidate name cp
 * @param candidateKatakanaCp the candidate katakana cp
 * @param genderCp the gender cp
 * @param candidateAddressCp the candidate address cp
 * @param candidateAddressKatakanaCp the candidate address katakana cp
 * @param candidatePhoneCp the candidate phone cp
 * @param candidateFaxCp the candidate fax cp
 * @param positionNameCp the position name cp
 * @param candidatePreferenceCp the candidate preference cp
 * @param staffCommentCp the staff comment cp
 * @param candidateDocumentCp the candidate document cp
 * @param source the source
 * @param url the url
 * @param companyFaxCp the company fax cp
 * @param responsiblePersonCp the responsible person cp
 * @param companyContractPeriodCp the company contract period cp
 * @param traningPeriodCp the traning period cp
 * @param educationHistoryCp the education history cp
 * @param companyNameCp the company name cp
 * @param companyAddressCp the company address cp
 * @param companyPhoneNumberCp the company phone number cp
 * @param jobNameCp the job name cp
 * @param employTypeCp the employ type cp
 * @param requiredJlptCp the required jlpt cp
 * @param requiredDurationCp the required duration cp
 * @param shopNameCp the shop name cp
 * @param shopAddressCp the shop address cp
 * @param nearestStationCp the nearest station cp
 * @param hourlyWageCp the hourly wage cp
 * @param transportationAllowanceCp the transportation allowance cp
 * @param startTimeCp the start time cp
 * @param finishTimeCp the finish time cp
 */
@AllArgsConstructor

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Data

/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
@EqualsAndHashCode(callSuper = false)
@Table(name = "job_candidate_relation")
public class JobCandidateRelation implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The job candidate relation PK. */
	@EmbeddedId
	private JobCandidateRelationPK jobCandidateRelationPK;

	/** The call shop message counter. */
	@Column(columnDefinition = "int default 0")
	private int callShopMessageCounter;

	/** The no call or forgot reason. */
	@Column(columnDefinition = "int default 0") // 0 if first time**1 if second time
	private int noCallOrForgotReason;

	/** The no talk with shop. */
	@Column(columnDefinition = "int default 0") // 0 if first time**1 if second time
	private int noTalkWithShop;

	/** The ask talk with shop. */
	@Column(columnDefinition = "int default 0") // 0 if first time**1 if second time
	private int askTalkWithShop;

	/** The progress. */
	private String progress;

	/** The shop progress. */
	private String shopProgress;

	/** The bot chek progress. */
	private String botChekProgress;

	/** The payment Status. */
	private String paymentStatus;

	/** The candidate name. */
	protected String candidateName;

	/** The candidate name Katakana. */
	protected String candidateNameKatakana;

	/** The phone. */
	private String candidatePhone;

	/** The j LPT. */
	private String candidateJLPT;

	/** The duration in japan. */
	private String candidateDurationInJapan;

	/** The offered. */
	@Builder.Default
	private boolean offered = false;

	/** The applied. */
	@Builder.Default
	private boolean applied = false;

	/** The matched. */
	@Builder.Default
	private boolean matched = false;

	/** The privacy policy checked. */
	@Builder.Default
	@Column(columnDefinition = "boolean default false", nullable = false)
	private boolean privacyPolicyChecked = false;

	/** The payed. */
	@Builder.Default
	@Column(columnDefinition = "boolean default false", nullable = false)
	private boolean paid = false;

	/** The approved. */
	@Builder.Default
	@Column(columnDefinition = "boolean default false", nullable = false)
	private boolean approved = false;

	/** The approve date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date approveDate;

	/** The starting date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date startingDate;

	/** The birthday. */
	@Temporal(TemporalType.DATE)
	private Date candidateBirthday;

	/** The offer date. */
	private Date offerDate;

	/** The applied date. */
	private Date appliedDate;

	/** The match date. */
	private Date matchDate;

	/** The posted date. */
	private Date postedDate;

	/** The no talk with shop date. */
	@Temporal(TemporalType.DATE)
	private Date noTalkWithShopDate;

	/** The no call or forgot date. */
	@Temporal(TemporalType.DATE)
	private Date noCallOrForgotDate;

	/** The call shop message date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date callShopMessageDate;

	/** The interview date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date interviewDate;

	/** The remind interview date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date remindInterviewDate;

	/** The remind interview day date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date remindInterviewDayDate;

	/** The ask for when interview date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date askForWhenInterviewDate;

	/** The ask candidate how was interview date. */
	@Temporal(TemporalType.DATE)
	private Date askCandidateHowWasInterviewDate;

	/** The result interview date. */
	@Temporal(TemporalType.DATE)
	private Date resultInterviewDate;

	/** The start working date. */
	@Temporal(TemporalType.DATE)
	private Date startWorkingDate;

	/** The you start working today date. */
	@Temporal(TemporalType.DATE)
	private Date youStartWorkingTodayDate;

	/** The ask for result date candidate. */
	@Temporal(TemporalType.DATE)
	private Date askForResultDateCandidate;

	/** The ask for set interview. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date askForSetInterview;

	/** The ask shop how was interview date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date askShopHowWasInterviewDate;

	/** The request month. */
	private String requestMonth;

	/** The candidate. */
	@ManyToOne
	@JoinColumn(name = "idCandidate", referencedColumnName = "id_user", insertable = false, updatable = false)
	@JsonIgnoreProperties({ "jobCandidateRelations", "shopCandidateRelations" })
	private Candidate candidate;

	/** The job. */
	@ManyToOne
	@JoinColumn(name = "idJob", referencedColumnName = "idJob", insertable = false, updatable = false)
	@JsonIgnoreProperties({ "jobCandidateRelations", "shopCandidateRelations" })
	private Job job;

	/** The chat. */
	@OneToOne
	@JoinColumn(name = "idChat", referencedColumnName = "idChat")
	private Chat chat;
	
	/** ***********************. */
	@Column(columnDefinition = "varchar(255) default '0'")
	private String casePrice;
	
	/** **********************. */
	private Date applyDateCp;
	
	/** The validity period cp. */
	private String validityPeriodCp;
	
	/** The birthdate cp. */
	private Date birthdateCp;
	
	/** The validity date cp. */
	@Column(columnDefinition = "varchar(255) default ''")
	private String validityDateCp;
	
	/** The staff name cp. */
	@Column(columnDefinition = "varchar(255) default '三枝周'")
	private String staffNameCp;
	
	/** The candidate name cp. */
	private String candidateNameCp;
	
	/** The candidate katakana cp. */
	private String candidateKatakanaCp;
	
	/** The gender cp. */
	@Column(columnDefinition = "varchar(255) default ''")
	private String genderCp;
	
	/** The candidate address cp. */
	@Column(columnDefinition = "varchar(255) default ''")
	private String candidateAddressCp;
	
	/** The candidate address katakana cp. */
	@Column(columnDefinition = "varchar(255) default ''")
	private String candidateAddressKatakanaCp;
	
	/** The candidate phone cp. */
	private String candidatePhoneCp;
	
	/** The candidate fax cp. */
	@Column(columnDefinition = "varchar(255)  default '無'")
	private String candidateFaxCp;
	
	/** The position name cp. */
	private String positionNameCp;
	
	/** The candidate preference cp. */
	@Column(columnDefinition = "varchar(255)  default 'なし'")
	private String candidatePreferenceCp;
	
	/** The staff comment cp. */
	@Column(columnDefinition = "varchar(255)  default  'なし'")
	private String staffCommentCp;
	
	/** The candidate document cp. */
	@Column(columnDefinition = "varchar(255) default  'なし'")
	private String candidateDocumentCp;
	
	/** The source. */
	@Column(columnDefinition = "varchar(255) default  ''")
	private String source;

	/** The url. */
	@Column(columnDefinition = "varchar(255) default  ''")
	private String url;

	/** ********************************. */

	private String companyFaxCp;
	
	/** The responsible person cp. */
	private String responsiblePersonCp;
	
	/** The company contract period cp. */
	private String companyContractPeriodCp;
	
	/** The traning period cp. */
	private String traningPeriodCp;
	
	/** The education history cp. */
	private String educationHistoryCp;
	
	/** The company name cp. */
	private String companyNameCp;
	
	/** The company address cp. */
	private String companyAddressCp;
	
	/** The company phone number cp. */
	private String companyPhoneNumberCp;

	/** ****************************. */
	private String jobNameCp;
	
	/** The employ type cp. */
	@Column(columnDefinition = "varchar(255) default  'アルバイト'")
	private String employTypeCp;
	
	/** The required jlpt cp. */
	private String requiredJlptCp;
	
	/** The required duration cp. */
	private String requiredDurationCp;
	
	/** The shop name cp. */
	private String shopNameCp;
	
	/** The shop address cp. */
	private String shopAddressCp;
	
	/** The nearest station cp. */
	private String nearestStationCp;
	
	/** The hourly wage cp. */
	private Double hourlyWageCp;
	
	/** The transportation allowance cp. */
	@Column(columnDefinition = "boolean default false", nullable = false)
	private boolean transportationAllowanceCp;
	
	/** The start time cp. */
	@Temporal(TemporalType.TIME)
	private Date startTimeCp;
	
	/** The finish time cp. */
	@Temporal(TemporalType.TIME)
	private Date finishTimeCp;

	/**********************************/
	// number_of_time ==> ==> ==> Default : 4
	// working_time_details ==> ==> ==> Default : なし
	// dayoff ==> ==> ==> Default : 週休二日制
	// paid_holiday ==> ==> ==> Default : 入社半年経過後10日
	// insurance ==> ==> ==> Default : 雇用保険
	// others_details ==> ==> ==> Default : blank
	// staff_hired ==> ==> ==> Default: １名
	// selection_detail ==> ==> ==> Default : 面接1回
	/*********************************/

}
