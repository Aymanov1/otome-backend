package com.hrdatabank.mtproject.model;

import java.text.SimpleDateFormat;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class JobCandidateRelationDto.
 */
public class JobCandidateRelationDto {

	/** The id job. */
	private int idJob;
	
	/** The id candidate. */
	private int idCandidate;
	
	/** The call shop message counter. */
	private int callShopMessageCounter;
	
	/** The no call or forgot reason. */
	private int noCallOrForgotReason;
	
	/** The no talk with shop. */
	private int noTalkWithShop;
	
	/** The ask talk with shop. */
	private int askTalkWithShop;
	
	/** The progress. */
	private String progress;
	
	/** The shop progress. */
	private String shopProgress;
	
	/** The bot chek progress. */
	private String botChekProgress;
	
	/** The offered. */
	private boolean offered;
	
	/** The applied. */
	private boolean applied;
	
	/** The matched. */
	private boolean matched;
	
	/** The approved. */
	private boolean approved;
	
	/** The offer date. */
	private Date offerDate;
	
	/** The applied date. */
	private Date appliedDate;
	
	/** The match date. */
	private Date matchDate;
	
	/** The posted date. */
	private Date postedDate;
	
	/** The no talk with shop date. */
	private Date noTalkWithShopDate;
	
	/** The no call or forgot date. */
	private Date noCallOrForgotDate;
	
	/** The call shop message date. */
	private Date callShopMessageDate;
	
	/** The interview date. */
	private Date interviewDate;
	
	/** The remind interview date. */
	private Date remindInterviewDate;
	
	/** The remind interview day date. */
	private Date remindInterviewDayDate;
	
	/** The ask for when interview date. */
	private Date askForWhenInterviewDate;
	
	/** The ask candidate how was interview date. */
	private Date askCandidateHowWasInterviewDate;
	
	/** The result interview date. */
	private Date resultInterviewDate;
	
	/** The start working date. */
	private Date startWorkingDate;
	
	/** The you start working today date. */
	private Date youStartWorkingTodayDate;
	
	/** The ask for result date candidate. */
	private Date askForResultDateCandidate;
	
	/** The ask for set interview. */
	private Date askForSetInterview;
	
	/** The ask shop how was interview date. */
	private Date askShopHowWasInterviewDate;
	
	/** The approve date. */
	private Date approveDate;
	
	/** The starting date. */
	private Date startingDate;

	/** The id shop. */
	private int idShop;
	
	/** The name shop. */
	private String nameShop;
	
	/** The position name. */
	private String positionName;
	
	/** The interview date job. */
	private String interviewDateJob;
	
	/** The case price. */
	private String casePrice;

	/** The candidate name. */
	protected String candidateName;
	
	/** The candidate name katakana. */
	protected String candidateNameKatakana;
	
	/** The candidate phone. */
	private String candidatePhone;
	
	/** The candidate JLPT. */
	private String candidateJLPT;
	
	/** The candidate duration in japan. */
	private String candidateDurationInJapan;
	
	/** The candidate birthday. */
	private Date candidateBirthday;

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Instantiates a new job candidate relation dto.
	 * @param idJob the id job
	 * @param idCandidate the id candidate
	 * @param callShopMessageCounter the call shop message counter
	 * @param noCallOrForgotReason the no call or forgot reason
	 * @param noTalkWithShop the no talk with shop
	 * @param askTalkWithShop the ask talk with shop
	 * @param progress the progress
	 * @param shopProgress the shop progress
	 * @param botChekProgress the bot chek progress
	 * @param offered the offered
	 * @param applied the applied
	 * @param matched the matched
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
	 */
	public JobCandidateRelationDto(int idJob, int idCandidate, int callShopMessageCounter, int noCallOrForgotReason,
			int noTalkWithShop, int askTalkWithShop, String progress, String shopProgress, String botChekProgress,
			boolean offered, boolean applied, boolean matched, Date offerDate, Date appliedDate, Date matchDate,
			Date postedDate, Date noTalkWithShopDate, Date noCallOrForgotDate, Date callShopMessageDate,
			Date interviewDate, Date remindInterviewDate, Date remindInterviewDayDate, Date askForWhenInterviewDate,
			Date askCandidateHowWasInterviewDate, Date resultInterviewDate, Date startWorkingDate,
			Date youStartWorkingTodayDate, Date askForResultDateCandidate, Date askForSetInterview,
			Date askShopHowWasInterviewDate) {
		super();
		this.idJob = idJob;
		this.idCandidate = idCandidate;
		this.callShopMessageCounter = callShopMessageCounter;
		this.noCallOrForgotReason = noCallOrForgotReason;
		this.noTalkWithShop = noTalkWithShop;
		this.askTalkWithShop = askTalkWithShop;
		this.progress = progress;
		this.shopProgress = shopProgress;
		this.botChekProgress = botChekProgress;
		this.offered = offered;
		this.applied = applied;
		this.matched = matched;
		this.offerDate = offerDate;
		this.appliedDate = appliedDate;
		this.matchDate = matchDate;
		this.postedDate = postedDate;
		this.noTalkWithShopDate = noTalkWithShopDate;
		this.noCallOrForgotDate = noCallOrForgotDate;
		this.callShopMessageDate = callShopMessageDate;
		this.interviewDate = interviewDate;
		this.remindInterviewDate = remindInterviewDate;
		this.remindInterviewDayDate = remindInterviewDayDate;
		this.askForWhenInterviewDate = askForWhenInterviewDate;
		this.askCandidateHowWasInterviewDate = askCandidateHowWasInterviewDate;
		this.resultInterviewDate = resultInterviewDate;
		this.startWorkingDate = startWorkingDate;
		this.youStartWorkingTodayDate = youStartWorkingTodayDate;
		this.askForResultDateCandidate = askForResultDateCandidate;
		this.askForSetInterview = askForSetInterview;
		this.askShopHowWasInterviewDate = askShopHowWasInterviewDate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Instantiates a new job candidate relation dto.
	 * @param idJob the id job
	 * @param idCandidate the id candidate
	 * @param idShop the id shop
	 * @param nameShop the name shop
	 * @param positionName the position name
	 * @param progress the progress
	 * @param interviewDateJob the interview date job
	 */
	public JobCandidateRelationDto(int idJob, int idCandidate, int idShop, String nameShop, String positionName,
			String progress, Date interviewDateJob) {
		super();
		this.idJob = idJob;
		this.idCandidate = idCandidate;
		this.idShop = idShop;
		this.nameShop = nameShop;
		this.positionName = positionName;
		this.progress = progress;
		if (interviewDateJob != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			String interview = formatter.format(interviewDateJob);
			this.interviewDateJob = interview;

		} else {
			this.interviewDateJob = null;

		}
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Instantiates a new job candidate relation dto.
	 * @param idJob the id job
	 * @param idCandidate the id candidate
	 * @param candidateName the candidate name
	 * @param candidateNameKatakana the candidate name katakana
	 * @param candidatePhone the candidate phone
	 * @param candidateJLPT the candidate JLPT
	 * @param candidateDurationInJapan the candidate duration in japan
	 * @param candidateBirthday the candidate birthday
	 */
	public JobCandidateRelationDto(int idJob, int idCandidate, String candidateName, String candidateNameKatakana,
			String candidatePhone, String candidateJLPT, String candidateDurationInJapan, Date candidateBirthday) {
		super();
		this.idJob = idJob;
		this.idCandidate = idCandidate;
		this.candidateName = candidateName;
		this.candidateNameKatakana = candidateNameKatakana;
		this.candidatePhone = candidatePhone;
		this.candidateJLPT = candidateJLPT;
		this.candidateDurationInJapan = candidateDurationInJapan;
		this.candidateBirthday = candidateBirthday;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Instantiates a new job candidate relation dto.
	 * @param idJob the id job
	 * @param idCandidate the id candidate
	 * @param idShop the id shop
	 * @param candidateName the candidate name
	 * @param candidateNameKatakana the candidate name katakana
	 * @param candidatePhone the candidate phone
	 * @param nameShop the name shop
	 * @param positionName the position name
	 * @param startingDate the starting date
	 * @param approveDate the approve date
	 * @param casePrice the case price
	 * @param approved the approved
	 * @param appliedDate the applied date
	 */
	public JobCandidateRelationDto(int idJob, int idCandidate, int idShop, String candidateName,
			String candidateNameKatakana, String candidatePhone, String nameShop, String positionName,
			Date startingDate, Date approveDate, String casePrice, boolean approved, Date appliedDate) {
		super();
		this.idJob = idJob;
		this.idCandidate = idCandidate;
		this.idShop = idShop;
		this.candidateName = candidateName;
		this.candidateNameKatakana = candidateNameKatakana;
		this.candidatePhone = candidatePhone;
		this.nameShop = nameShop;
		this.positionName = positionName;
		this.startingDate = startingDate;
		this.approveDate = approveDate;
		this.casePrice = casePrice;
		this.approved = approved;
		this.appliedDate = appliedDate;

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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the id job.
	 * @return the id job
	 */
	public int getIdJob() {
		return idJob;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the id job.
	 * @param idJob the new id job
	 */
	public void setIdJob(int idJob) {
		this.idJob = idJob;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the id candidate.
	 * @return the id candidate
	 */
	public int getIdCandidate() {
		return idCandidate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the id candidate.
	 * @param idCandidate the new id candidate
	 */
	public void setIdCandidate(int idCandidate) {
		this.idCandidate = idCandidate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the call shop message counter.
	 * @return the call shop message counter
	 */
	public int getCallShopMessageCounter() {
		return callShopMessageCounter;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the call shop message counter.
	 * @param callShopMessageCounter the new call shop message counter
	 */
	public void setCallShopMessageCounter(int callShopMessageCounter) {
		this.callShopMessageCounter = callShopMessageCounter;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the no call or forgot reason.
	 * @return the no call or forgot reason
	 */
	public int getNoCallOrForgotReason() {
		return noCallOrForgotReason;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the no call or forgot reason.
	 * @param noCallOrForgotReason the new no call or forgot reason
	 */
	public void setNoCallOrForgotReason(int noCallOrForgotReason) {
		this.noCallOrForgotReason = noCallOrForgotReason;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the no talk with shop.
	 * @return the no talk with shop
	 */
	public int getNoTalkWithShop() {
		return noTalkWithShop;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the no talk with shop.
	 * @param noTalkWithShop the new no talk with shop
	 */
	public void setNoTalkWithShop(int noTalkWithShop) {
		this.noTalkWithShop = noTalkWithShop;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the ask talk with shop.
	 * @return the ask talk with shop
	 */
	public int getAskTalkWithShop() {
		return askTalkWithShop;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the ask talk with shop.
	 * @param askTalkWithShop the new ask talk with shop
	 */
	public void setAskTalkWithShop(int askTalkWithShop) {
		this.askTalkWithShop = askTalkWithShop;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the progress.
	 * @return the progress
	 */
	public String getProgress() {
		return progress;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the progress.
	 * @param progress the new progress
	 */
	public void setProgress(String progress) {
		this.progress = progress;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the shop progress.
	 * @return the shop progress
	 */
	public String getShopProgress() {
		return shopProgress;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the shop progress.
	 * @param shopProgress the new shop progress
	 */
	public void setShopProgress(String shopProgress) {
		this.shopProgress = shopProgress;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the bot chek progress.
	 * @return the bot chek progress
	 */
	public String getBotChekProgress() {
		return botChekProgress;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the bot chek progress.
	 * @param botChekProgress the new bot chek progress
	 */
	public void setBotChekProgress(String botChekProgress) {
		this.botChekProgress = botChekProgress;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Checks if is offered.
	 * @return true, if is offered
	 */
	public boolean isOffered() {
		return offered;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the offered.
	 * @param offered the new offered
	 */
	public void setOffered(boolean offered) {
		this.offered = offered;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Checks if is applied.
	 * @return true, if is applied
	 */
	public boolean isApplied() {
		return applied;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the applied.
	 * @param applied the new applied
	 */
	public void setApplied(boolean applied) {
		this.applied = applied;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Checks if is matched.
	 * @return true, if is matched
	 */
	public boolean isMatched() {
		return matched;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the matched.
	 * @param matched the new matched
	 */
	public void setMatched(boolean matched) {
		this.matched = matched;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the offer date.
	 * @return the offer date
	 */
	public Date getOfferDate() {
		return offerDate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the offer date.
	 * @param offerDate the new offer date
	 */
	public void setOfferDate(Date offerDate) {
		this.offerDate = offerDate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the applied date.
	 * @return the applied date
	 */
	public Date getAppliedDate() {
		return appliedDate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the applied date.
	 * @param appliedDate the new applied date
	 */
	public void setAppliedDate(Date appliedDate) {
		this.appliedDate = appliedDate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the match date.
	 * @return the match date
	 */
	public Date getMatchDate() {
		return matchDate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the match date.
	 * @param matchDate the new match date
	 */
	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the posted date.
	 * @return the posted date
	 */
	public Date getPostedDate() {
		return postedDate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the posted date.
	 * @param postedDate the new posted date
	 */
	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the no talk with shop date.
	 * @return the no talk with shop date
	 */
	public Date getNoTalkWithShopDate() {
		return noTalkWithShopDate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the no talk with shop date.
	 * @param noTalkWithShopDate the new no talk with shop date
	 */
	public void setNoTalkWithShopDate(Date noTalkWithShopDate) {
		this.noTalkWithShopDate = noTalkWithShopDate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the no call or forgot date.
	 * @return the no call or forgot date
	 */
	public Date getNoCallOrForgotDate() {
		return noCallOrForgotDate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the no call or forgot date.
	 * @param noCallOrForgotDate the new no call or forgot date
	 */
	public void setNoCallOrForgotDate(Date noCallOrForgotDate) {
		this.noCallOrForgotDate = noCallOrForgotDate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the call shop message date.
	 * @return the call shop message date
	 */
	public Date getCallShopMessageDate() {
		return callShopMessageDate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the call shop message date.
	 * @param callShopMessageDate the new call shop message date
	 */
	public void setCallShopMessageDate(Date callShopMessageDate) {
		this.callShopMessageDate = callShopMessageDate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the interview date.
	 * @return the interview date
	 */
	public Date getInterviewDate() {
		return interviewDate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the interview date.
	 * @param interviewDate the new interview date
	 */
	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the remind interview date.
	 * @return the remind interview date
	 */
	public Date getRemindInterviewDate() {
		return remindInterviewDate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the remind interview date.
	 * @param remindInterviewDate the new remind interview date
	 */
	public void setRemindInterviewDate(Date remindInterviewDate) {
		this.remindInterviewDate = remindInterviewDate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the remind interview day date.
	 * @return the remind interview day date
	 */
	public Date getRemindInterviewDayDate() {
		return remindInterviewDayDate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the remind interview day date.
	 * @param remindInterviewDayDate the new remind interview day date
	 */
	public void setRemindInterviewDayDate(Date remindInterviewDayDate) {
		this.remindInterviewDayDate = remindInterviewDayDate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the ask for when interview date.
	 * @return the ask for when interview date
	 */
	public Date getAskForWhenInterviewDate() {
		return askForWhenInterviewDate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the ask for when interview date.
	 * @param askForWhenInterviewDate the new ask for when interview date
	 */
	public void setAskForWhenInterviewDate(Date askForWhenInterviewDate) {
		this.askForWhenInterviewDate = askForWhenInterviewDate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the ask candidate how was interview date.
	 * @return the ask candidate how was interview date
	 */
	public Date getAskCandidateHowWasInterviewDate() {
		return askCandidateHowWasInterviewDate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the ask candidate how was interview date.
	 * @param askCandidateHowWasInterviewDate the new ask candidate how was interview date
	 */
	public void setAskCandidateHowWasInterviewDate(Date askCandidateHowWasInterviewDate) {
		this.askCandidateHowWasInterviewDate = askCandidateHowWasInterviewDate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the result interview date.
	 * @return the result interview date
	 */
	public Date getResultInterviewDate() {
		return resultInterviewDate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the result interview date.
	 * @param resultInterviewDate the new result interview date
	 */
	public void setResultInterviewDate(Date resultInterviewDate) {
		this.resultInterviewDate = resultInterviewDate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the start working date.
	 * @return the start working date
	 */
	public Date getStartWorkingDate() {
		return startWorkingDate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the start working date.
	 * @param startWorkingDate the new start working date
	 */
	public void setStartWorkingDate(Date startWorkingDate) {
		this.startWorkingDate = startWorkingDate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the you start working today date.
	 * @return the you start working today date
	 */
	public Date getYouStartWorkingTodayDate() {
		return youStartWorkingTodayDate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the you start working today date.
	 * @param youStartWorkingTodayDate the new you start working today date
	 */
	public void setYouStartWorkingTodayDate(Date youStartWorkingTodayDate) {
		this.youStartWorkingTodayDate = youStartWorkingTodayDate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the ask for result date candidate.
	 * @return the ask for result date candidate
	 */
	public Date getAskForResultDateCandidate() {
		return askForResultDateCandidate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the ask for result date candidate.
	 * @param askForResultDateCandidate the new ask for result date candidate
	 */
	public void setAskForResultDateCandidate(Date askForResultDateCandidate) {
		this.askForResultDateCandidate = askForResultDateCandidate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the ask for set interview.
	 * @return the ask for set interview
	 */
	public Date getAskForSetInterview() {
		return askForSetInterview;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the ask for set interview.
	 * @param askForSetInterview the new ask for set interview
	 */
	public void setAskForSetInterview(Date askForSetInterview) {
		this.askForSetInterview = askForSetInterview;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the ask shop how was interview date.
	 * @return the ask shop how was interview date
	 */
	public Date getAskShopHowWasInterviewDate() {
		return askShopHowWasInterviewDate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the ask shop how was interview date.
	 * @param askShopHowWasInterviewDate the new ask shop how was interview date
	 */
	public void setAskShopHowWasInterviewDate(Date askShopHowWasInterviewDate) {
		this.askShopHowWasInterviewDate = askShopHowWasInterviewDate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the id shop.
	 * @return the id shop
	 */
	public int getIdShop() {
		return idShop;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the id shop.
	 * @param idShop the new id shop
	 */
	public void setIdShop(int idShop) {
		this.idShop = idShop;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the name shop.
	 * @return the name shop
	 */
	public String getNameShop() {
		return nameShop;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the name shop.
	 * @param nameShop the new name shop
	 */
	public void setNameShop(String nameShop) {
		this.nameShop = nameShop;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the position name.
	 * @return the position name
	 */
	public String getPositionName() {
		return positionName;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the position name.
	 * @param positionName the new position name
	 */
	public void setPositionName(String positionName) {
		this.positionName = positionName;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the interview date job.
	 * @return the interview date job
	 */
	public String getInterviewDateJob() {
		return interviewDateJob;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the interview date job.
	 * @param interviewDateJob the new interview date job
	 */
	public void setInterviewDateJob(String interviewDateJob) {
		this.interviewDateJob = interviewDateJob;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the candidate name.
	 * @return the candidate name
	 */
	public String getCandidateName() {
		return candidateName;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the candidate name.
	 * @param candidateName the new candidate name
	 */
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the candidate name katakana.
	 * @return the candidate name katakana
	 */
	public String getCandidateNameKatakana() {
		return candidateNameKatakana;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the candidate name katakana.
	 * @param candidateNameKatakana the new candidate name katakana
	 */
	public void setCandidateNameKatakana(String candidateNameKatakana) {
		this.candidateNameKatakana = candidateNameKatakana;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the candidate phone.
	 * @return the candidate phone
	 */
	public String getCandidatePhone() {
		return candidatePhone;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the candidate phone.
	 * @param candidatePhone the new candidate phone
	 */
	public void setCandidatePhone(String candidatePhone) {
		this.candidatePhone = candidatePhone;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the candidate JLPT.
	 * @return the candidate JLPT
	 */
	public String getCandidateJLPT() {
		return candidateJLPT;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the candidate JLPT.
	 * @param candidateJLPT the new candidate JLPT
	 */
	public void setCandidateJLPT(String candidateJLPT) {
		this.candidateJLPT = candidateJLPT;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the candidate duration in japan.
	 * @return the candidate duration in japan
	 */
	public String getCandidateDurationInJapan() {
		return candidateDurationInJapan;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the candidate duration in japan.
	 * @param candidateDurationInJapan the new candidate duration in japan
	 */
	public void setCandidateDurationInJapan(String candidateDurationInJapan) {
		this.candidateDurationInJapan = candidateDurationInJapan;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the candidate birthday.
	 * @return the candidate birthday
	 */
	public Date getCandidateBirthday() {
		return candidateBirthday;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the candidate birthday.
	 * @param candidateBirthday the new candidate birthday
	 */
	public void setCandidateBirthday(Date candidateBirthday) {
		this.candidateBirthday = candidateBirthday;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Instantiates a new job candidate relation dto.
	 * @param idJob the id job
	 * @param idCandidate the id candidate
	 * @param idShop the id shop
	 * @param candidateName the candidate name
	 * @param candidateNameKatakana the candidate name katakana
	 * @param candidatePhone the candidate phone
	 * @param nameShop the name shop
	 * @param positionName the position name
	 * @param startWorkingDate the start working date
	 * @param approveDate the approve date
	 * @param casePrice the case price
	 */
	public JobCandidateRelationDto(int idJob, int idCandidate, int idShop, String candidateName,
			String candidateNameKatakana, String candidatePhone, String nameShop, String positionName,
			Date startWorkingDate, Date approveDate, String casePrice) {
		super();
		this.idJob = idJob;
		this.idCandidate = idCandidate;
		this.idShop = idShop;
		this.candidateName = candidateName;
		this.candidateNameKatakana = candidateNameKatakana;
		this.candidatePhone = candidatePhone;
		this.nameShop = nameShop;
		this.positionName = positionName;
		this.startWorkingDate = startWorkingDate;
		this.approveDate = approveDate;
		this.casePrice = casePrice;

		/***********************/
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the approve date.
	 * @return the approve date
	 */
	public Date getApproveDate() {
		return approveDate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the approve date.
	 * @param approveDate the new approve date
	 */
	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Checks if is approved.
	 * @return true, if is approved
	 */
	public boolean isApproved() {
		return approved;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the approved.
	 * @param approved the new approved
	 */
	public void setApproved(boolean approved) {
		this.approved = approved;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the case price.
	 * @return the case price
	 */
	public String getCasePrice() {
		return casePrice;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the case price.
	 * @param casePrice the new case price
	 */
	public void setCasePrice(String casePrice) {
		this.casePrice = casePrice;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Gets the starting date.
	 * @return the starting date
	 */
	public Date getStartingDate() {
		return startingDate;
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
	 * Class Name: JobCandidateRelationDto.java
	 * 
	 * Sets the starting date.
	 * @param startingDate the new starting date
	 */
	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

}
