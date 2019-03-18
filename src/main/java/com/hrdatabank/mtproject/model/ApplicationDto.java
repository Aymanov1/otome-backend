
package com.hrdatabank.mtproject.model;

import java.util.Date;

import com.hrdatabank.mtproject.entities.Candidate;
import com.hrdatabank.mtproject.entities.Job;
import com.hrdatabank.mtproject.entities.Shop;

/**
 * The Class Application.
 */
public class ApplicationDto {

	/** The applied date. */
	private Date appliedDate;

	/** The progress. */
	private String progress;

	/** The shop progress. */
	private String shopProgress;

	protected long idUser;

	protected String userName;

	private int idJob;

	private String positionName;

	private int idShop;

	private String nameShop;

	/** The payment Status. */
	private String paymentStatus;

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

	private Date startingDate;
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
	 * @param appliedDate
	 *            the applied date
	 * @param progress
	 *            the progress
	 * @param shopProgress
	 *            the shop progress
	 * @param candidate
	 *            the candidate
	 * @param job
	 *            the job
	 */

	public ApplicationDto(Date appliedDate, Date startingDate, boolean approved, String progress, String shopProgress,
			Candidate candidate, Job job, String paymentStatus, String candidateName, String candidateNameKatakana,
			String candidatePhone, String candidateJLPT, String candidateDurationInJapan, Date candidateBirthday) {
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
		if (candidate.getBotInformation() != null) {
			this.lastActionDate = candidate.getBotInformation().getLastActionDate();

		} else {
			this.lastActionDate = null;

		}
		// this.candidate = cand;
		// this.job = jobs;
		this.idUser = cand.getIdUser();

		this.idJob = job.getIdJob();

		this.positionName = job.getPositionName();

		this.idShop = job.getShop().getIdShop();

		this.nameShop = job.getShop().getNameShop();

		this.userName = cand.getUserName();

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
	 * @author yassine amira
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
	 * @author yassine amira
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
	 * @author yassine amira
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
	 * @author yassine amira
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
	 * @author yassine amira
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
	 * @author yassine amira
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

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Date getLastActionDate() {
		return lastActionDate;
	}

	public void setLastActionDate(Date lastActionDate) {
		this.lastActionDate = lastActionDate;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getCandidateNameKatakana() {
		return candidateNameKatakana;
	}

	public void setCandidateNameKatakana(String candidateNameKatakana) {
		this.candidateNameKatakana = candidateNameKatakana;
	}

	public String getCandidatePhone() {
		return candidatePhone;
	}

	public void setCandidatePhone(String candidatePhone) {
		this.candidatePhone = candidatePhone;
	}

	public String getCandidateJLPT() {
		return candidateJLPT;
	}

	public void setCandidateJLPT(String candidateJLPT) {
		this.candidateJLPT = candidateJLPT;
	}

	public String getCandidateDurationInJapan() {
		return candidateDurationInJapan;
	}

	public void setCandidateDurationInJapan(String candidateDurationInJapan) {
		this.candidateDurationInJapan = candidateDurationInJapan;
	}

	public Date getCandidateBirthday() {
		return candidateBirthday;
	}

	public void setCandidateBirthday(Date candidateBirthday) {
		this.candidateBirthday = candidateBirthday;
	}

	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public int getIdJob() {
		return idJob;
	}

	public void setIdJob(int idJob) {
		this.idJob = idJob;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public int getIdShop() {
		return idShop;
	}

	public void setIdShop(int idShop) {
		this.idShop = idShop;
	}

	public String getNameShop() {
		return nameShop;
	}

	public void setNameShop(String nameShop) {
		this.nameShop = nameShop;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
