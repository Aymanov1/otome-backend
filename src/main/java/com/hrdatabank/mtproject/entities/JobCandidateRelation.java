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

/**
 * The Class JobCandidateRelation.
 */
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
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
	/**************************/
	@Column(columnDefinition = "varchar(255) default '0'")
	private String casePrice;
	/*************************/
	private Date applyDateCp;
	private String validityPeriodCp;
	private Date birthdateCp;
	@Column(columnDefinition = "varchar(255) default ''")
	private String validityDateCp;
	@Column(columnDefinition = "varchar(255) default '三枝周'")
	private String staffNameCp;
	private String candidateNameCp;
	private String candidateKatakanaCp;
	@Column(columnDefinition = "varchar(255) default ''")
	private String genderCp;
	@Column(columnDefinition = "varchar(255) default ''")
	private String candidateAddressCp;
	@Column(columnDefinition = "varchar(255) default ''")
	private String candidateAddressKatakanaCp;
	private String candidatePhoneCp;
	@Column(columnDefinition = "varchar(255)  default '無'")
	private String candidateFaxCp;
	private String positionNameCp;
	@Column(columnDefinition = "varchar(255)  default 'なし'")
	private String candidatePreferenceCp;
	@Column(columnDefinition = "varchar(255)  default  'なし'")
	private String staffCommentCp;
	@Column(columnDefinition = "varchar(255) default  'なし'")
	private String candidateDocumentCp;
	@Column(columnDefinition = "varchar(255) default  ''")
	private String source;

	@Column(columnDefinition = "varchar(255) default  ''")
	private String url;

	/***********************************/

	private String companyFaxCp;
	private String responsiblePersonCp;
	private String companyContractPeriodCp;
	private String traningPeriodCp;
	private String educationHistoryCp;
	private String companyNameCp;
	private String companyAddressCp;
	private String companyPhoneNumberCp;

	/*******************************/
	private String jobNameCp;
	@Column(columnDefinition = "varchar(255) default  'アルバイト'")
	private String employTypeCp;
	private String requiredJlptCp;
	private String requiredDurationCp;
	private String shopNameCp;
	private String shopAddressCp;
	private String nearestStationCp;
	private Double hourlyWageCp;
	@Column(columnDefinition = "boolean default false", nullable = false)
	private boolean transportationAllowanceCp;
	@Temporal(TemporalType.TIME)
	private Date startTimeCp;
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
