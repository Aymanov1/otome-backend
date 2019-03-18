package com.hrdatabank.mtproject.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class BotInformation.
 */
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "bot_information")
public class BotInformation implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id bot information. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idBotInformation;

	/** The id related job. */
	private int idRelatedJob;

	/** The no call or forgot reason. */
	@Column(columnDefinition = "int default 0") /** 0 if first time**1 if second time */
	private int noCallOrForgotReason;

	/** The status. */
	private int status;

	/** The page more job. */
	@Column(columnDefinition = "int default 0") /** 0 if first time**1 if second time */
	private int pageMoreJob;

	/** The wrong date counter. */
	@Column(columnDefinition = "int default 0") /** 0 if first time**1 if second time */
	private int wrongDateCounter;

	/** The station incrementor. */
	@Column(columnDefinition = "int default 1") /** increments by 1 till reaching 15 */
	private int stationIncrementor;

	/** The end station CD. */
	@Column(columnDefinition = "int default 0")
	private int endStationCD;

	/** The start station CD. */
	@Column(columnDefinition = "int default 0")
	private int startStationCD;

	/** The station ID after increment. */
	@Column(columnDefinition = "int default 0")
	private int stationIDAfterIncrement;

	@Column(columnDefinition = "int default 0")
	private int idFirstSimilarStation;

	@Column(columnDefinition = "Decimal(10,10) default '0.5'")
	private double randomSearchSeed;

	/** The search criteria. */
	@Builder.Default
	private String searchCriteria = "address";

	/** The address to search. */
	private String addressToSearch;
	private Double addressToSearchLat;
	private Double addressToSearchLong;

	/** The language bot. */
	@Builder.Default
	private String languageBot = "japanese";

	/** The prefer category. */
	private String preferCategory;

	/** The Work time. */
	private String WorkTime;

	/** The job type. */
	private String jobType;

	private String SearchCriteriaForHowWasIt;

	/** The list number. */
	private String listNumber;

	/** The shop search. */
	private String shopSearch;

	/** The source of search. */
	private String sourceOfSearch;

	/** The job search list. */
	@Column
	@ElementCollection(targetClass = Integer.class)
	@CollectionTable(name = "bot_information_job_search_list")
	private List<Integer> jobSearchList;

	@Column
	@ElementCollection(fetch = FetchType.EAGER)
	@MapKeyColumn(name = "idJob")
	@CollectionTable(name = "bot_information_search_log")
	private Map<Integer, String> searchLog;

	/** The newly added candidate. */
	@Column(columnDefinition = "boolean default false", nullable = false)
	private boolean newlyAddedCandidate;

	@Column(columnDefinition = "boolean default false", nullable = false)
	private boolean ignored;

	/** The pending bot. */
	@Column(columnDefinition = "boolean default false", nullable = false)
	private boolean pendingBot;

	@Temporal(TemporalType.TIMESTAMP)
	private Date chooseStationDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date chooseTimeDate;

	/** The ask for not fixing date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date askForNotFixingDate;

	/** The you start working today date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date youStartWorkingTodayDate;

	/** The ask for station date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date askForStationDate;

	/** The last action date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastActionDate;

	/** The ask for language date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date askForLanguageDate;

	/** The ask how was it date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date askHowWasItDate;

	/** The ask for job type date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date askForJobTypeDate;

	/** The ask shop how was interview date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date askShopHowWasInterviewDate;

	/** The ask candidate how was interview date. */
	@Temporal(TemporalType.DATE)
	private Date askCandidateHowWasInterviewDate;

	/** The ask for reason date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date askForReasonDate;

	/** The ask for applying other jobs date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date askForApplyingOtherJobsDate;

	/** The start working time. */
	@Temporal(TemporalType.TIME)
	private Date startWorkingTime;

	/** The how was the work date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date howWasTheWorkDate;

	/** The finish working time. */
	@Temporal(TemporalType.TIME)
	private Date finishWorkingTime;

	/** The ask for when start working. */
	@Temporal(TemporalType.DATE)
	private Date askForWhenStartWorking;

	/** The ask for result date candidate. */
	@Temporal(TemporalType.DATE)
	private Date askForResultDateCandidate;

	/** The ask for when is the result date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date askForWhenIsTheResultDate;

	/** The no call or forgot date. */
	@Temporal(TemporalType.DATE)
	private Date noCallOrForgotDate;

	/** The ask for set interview. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date askForSetInterview;

	/** The ask for when interview date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date askForWhenInterviewDate;

	/** The ask for apply again date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date askForApplyAgainDate;

	/** The ask for help menu date. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date askForHelpMenuDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date similarStationDate;

	/** The NearestStationBotInformationRelation search list. */
	@OneToMany(mappedBy = "botInformation")
	@JsonIgnoreProperties({ "botInformation" })
	private List<NearestStationBotInformationRelation> nearestStationBotInformationRelations;

	private String tagToSearch;

}
