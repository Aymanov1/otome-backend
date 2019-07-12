package com.hrdatabank.mtproject.model;

import java.util.Date;

import com.hrdatabank.mtproject.entities.Candidate;
import com.hrdatabank.mtproject.entities.Job;
import com.hrdatabank.mtproject.entities.Shop;

// TODO: Auto-generated Javadoc
/**
 * The Class Application.
 */
public class Application {

	/** The applied date. */
	private Date appliedDate;

	/** The progress. */
	private String progress;

	/** The shop progress. */
	private String shopProgress;

	/** The candidate. */
	private Candidate candidate;

	/** The job. */
	private Job job;
	/** The payment Status. */
	private String paymentStatus;

	/** The last action date. */
	private Date lastActionDate;

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
	/** The birthday. */
	private Date candidateBirthday;

	
	/** The starting date. */
	private Date startingDate;
	
	/** The approved. */
	private boolean approved;

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Wala Ben Amor
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: Application.java
	 * 
	 *         Instantiates a new application.
	 * @param appliedDate            the applied date
	 * @param startingDate the starting date
	 * @param approved the approved
	 * @param progress            the progress
	 * @param shopProgress            the shop progress
	 * @param candidate            the candidate
	 * @param job            the job
	 * @param paymentStatus the payment status
	 * @param candidateName the candidate name
	 * @param candidateNameKatakana the candidate name katakana
	 * @param candidatePhone the candidate phone
	 * @param candidateJLPT the candidate JLPT
	 * @param candidateDurationInJapan the candidate duration in japan
	 * @param candidateBirthday the candidate birthday
	 */

	public Application(Date appliedDate,Date startingDate, boolean approved, String progress, String shopProgress, Candidate candidate, Job job,
			String paymentStatus, String candidateName, String candidateNameKatakana, String candidatePhone,
			String candidateJLPT, String candidateDurationInJapan, Date candidateBirthday) {
		super();
		this.setAppliedDate(appliedDate);
		this.setStartingDate(startingDate);
		this.setApproved(approved);
		this.progress = progress;
		Candidate cand = new Candidate();
		cand.setUserName(candidate.getUserName());
		cand.setIdUser(candidate.getIdUser());
		cand.setBirthday(candidate.getBirthday());
		cand.setJLPT(candidate.getJLPT());
		cand.setDurationInJapan(candidate.getDurationInJapan());
		cand.setPhone(candidate.getPhone());
		cand.setMemo(candidate.getMemo());
		cand.setUserNameKatakana(candidate.getUserNameKatakana());
		Job jobs = new Job();
		Shop shop = new Shop();
		jobs.setIdJob(job.getIdJob());
		shop.setNameShop(job.getShop().getNameShop());
		shop.setIdShop(job.getShop().getIdShop());
		jobs.setPositionName(job.getPositionName());
		jobs.setShop(shop);
		this.lastActionDate = candidate.getBotInformation().getLastActionDate();
		this.candidate = cand;
		this.job = jobs;
		this.shopProgress = shopProgress;
		this.paymentStatus = paymentStatus;
		this.candidateName = candidateName;
		this.candidateNameKatakana = candidateNameKatakana;
		this.candidatePhone = candidatePhone;
		this.candidateJLPT = candidateJLPT;
		this.candidateDurationInJapan = candidateDurationInJapan;
		this.candidateBirthday = candidateBirthday;
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
	 *         Class Name: Application.java
	 * 
	 *         Instantiates a new application.
	 * @param appliedDate            the applied date
	 * @param progress            the progress
	 * @param shopProgress            the shop progress
	 * @param candidate            the candidate
	 * @param job            the job
	 * @param paymentStatus the payment status
	 */

	public Application(Date appliedDate, String progress, String shopProgress, Candidate candidate, Job job,
			String paymentStatus) {
		super();
		this.setAppliedDate(appliedDate);
		this.progress = progress;
		Candidate cand = new Candidate();
		cand.setUserName(candidate.getUserName());
		cand.setIdUser(candidate.getIdUser());
		cand.setBirthday(candidate.getBirthday());
		cand.setJLPT(candidate.getJLPT());
		cand.setDurationInJapan(candidate.getDurationInJapan());
		cand.setPhone(candidate.getPhone());
		cand.setMemo(candidate.getMemo());
		cand.setUserNameKatakana(candidate.getUserNameKatakana());
		Job jobs = new Job();
		Shop shop = new Shop();
		jobs.setIdJob(job.getIdJob());
		shop.setNameShop(job.getShop().getNameShop());
		shop.setIdShop(job.getShop().getIdShop());
		jobs.setPositionName(job.getPositionName());
		jobs.setShop(shop);
		this.lastActionDate = candidate.getBotInformation().getLastActionDate();
		this.candidate = cand;
		this.job = jobs;
		this.shopProgress = shopProgress;
		this.paymentStatus = paymentStatus;
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
	 *         Class Name: Application.java
	 * 
	 *         Gets the progress.
	 * @return the progress
	 */
	public String getProgress() {
		return progress;
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
	 *         Class Name: Application.java
	 * 
	 *         Sets the progress.
	 * @param progress
	 *            the new progress
	 */
	public void setProgress(String progress) {
		this.progress = progress;
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
	 *         Class Name: Application.java
	 * 
	 *         Gets the candidate.
	 * @return the candidate
	 */
	public Candidate getCandidate() {
		return candidate;
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
	 *         Class Name: Application.java
	 * 
	 *         Sets the candidate.
	 * @param candidate
	 *            the new candidate
	 */
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
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
	 *         Class Name: Application.java
	 * 
	 *         Gets the job.
	 * @return the job
	 */
	public Job getJob() {
		return job;
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
	 *         Class Name: Application.java
	 * 
	 *         Sets the job.
	 * @param job
	 *            the new job
	 */
	public void setJob(Job job) {
		this.job = job;
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
	 *         Class Name: Application.java
	 * 
	 *         Gets the applied date.
	 * @return the applied date
	 */
	public Date getAppliedDate() {
		return appliedDate;
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
	 *         Class Name: Application.java
	 * 
	 *         Sets the applied date.
	 * @param appliedDate
	 *            the new applied date
	 */
	public void setAppliedDate(Date appliedDate) {
		this.appliedDate = appliedDate;
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
	 *         Class Name: Application.java
	 * 
	 *         Gets the shop progress.
	 * @return the shop progress
	 */
	public String getShopProgress() {
		return shopProgress;
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
	 *         Class Name: Application.java
	 * 
	 *         Sets the shop progress.
	 * @param shopProgress
	 *            the new shop progress
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
	 * Class Name: Application.java
	 * 
	 * Gets the payment status.
	 * @return the payment status
	 */
	public String getPaymentStatus() {
		return paymentStatus;
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
	 * Class Name: Application.java
	 * 
	 * Sets the payment status.
	 * @param paymentStatus the new payment status
	 */
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
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
	 * Class Name: Application.java
	 * 
	 * Gets the last action date.
	 * @return the last action date
	 */
	public Date getLastActionDate() {
		return lastActionDate;
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
	 * Class Name: Application.java
	 * 
	 * Sets the last action date.
	 * @param lastActionDate the new last action date
	 */
	public void setLastActionDate(Date lastActionDate) {
		this.lastActionDate = lastActionDate;
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
	 * Class Name: Application.java
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
	 * Class Name: Application.java
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
	 * Class Name: Application.java
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
	 * Class Name: Application.java
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
	 * Class Name: Application.java
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
	 * Class Name: Application.java
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
	 * Class Name: Application.java
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
	 * Class Name: Application.java
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
	 * Class Name: Application.java
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
	 * Class Name: Application.java
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
	 * Class Name: Application.java
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
	 * Class Name: Application.java
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
	 * Class Name: Application.java
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
	 * Class Name: Application.java
	 * 
	 * Sets the starting date.
	 * @param startingDate the new starting date
	 */
	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
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
	 * Class Name: Application.java
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
	 * Class Name: Application.java
	 * 
	 * Sets the approved.
	 * @param approved the new approved
	 */
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
}
