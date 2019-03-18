package com.hrdatabank.mtproject.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JobCandidateRelationDto {

	private int idJob;
	private int idCandidate;
	private int callShopMessageCounter;
	private int noCallOrForgotReason;
	private int noTalkWithShop;
	private int askTalkWithShop;
	private String progress;
	private String shopProgress;
	private String botChekProgress;
	private boolean offered;
	private boolean applied;
	private boolean matched;
	private boolean approved;
	private Date offerDate;
	private Date appliedDate;
	private Date matchDate;
	private Date postedDate;
	private Date noTalkWithShopDate;
	private Date noCallOrForgotDate;
	private Date callShopMessageDate;
	private Date interviewDate;
	private Date remindInterviewDate;
	private Date remindInterviewDayDate;
	private Date askForWhenInterviewDate;
	private Date askCandidateHowWasInterviewDate;
	private Date resultInterviewDate;
	private Date startWorkingDate;
	private Date youStartWorkingTodayDate;
	private Date askForResultDateCandidate;
	private Date askForSetInterview;
	private Date askShopHowWasInterviewDate;
	private Date approveDate;
	private Date startingDate;

	private int idShop;
	private String nameShop;
	private String positionName;
	private String interviewDateJob;
	private String casePrice;

	protected String candidateName;
	protected String candidateNameKatakana;
	private String candidatePhone;
	private String candidateJLPT;
	private String candidateDurationInJapan;
	private Date candidateBirthday;

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

	public int getIdJob() {
		return idJob;
	}

	public void setIdJob(int idJob) {
		this.idJob = idJob;
	}

	public int getIdCandidate() {
		return idCandidate;
	}

	public void setIdCandidate(int idCandidate) {
		this.idCandidate = idCandidate;
	}

	public int getCallShopMessageCounter() {
		return callShopMessageCounter;
	}

	public void setCallShopMessageCounter(int callShopMessageCounter) {
		this.callShopMessageCounter = callShopMessageCounter;
	}

	public int getNoCallOrForgotReason() {
		return noCallOrForgotReason;
	}

	public void setNoCallOrForgotReason(int noCallOrForgotReason) {
		this.noCallOrForgotReason = noCallOrForgotReason;
	}

	public int getNoTalkWithShop() {
		return noTalkWithShop;
	}

	public void setNoTalkWithShop(int noTalkWithShop) {
		this.noTalkWithShop = noTalkWithShop;
	}

	public int getAskTalkWithShop() {
		return askTalkWithShop;
	}

	public void setAskTalkWithShop(int askTalkWithShop) {
		this.askTalkWithShop = askTalkWithShop;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public String getShopProgress() {
		return shopProgress;
	}

	public void setShopProgress(String shopProgress) {
		this.shopProgress = shopProgress;
	}

	public String getBotChekProgress() {
		return botChekProgress;
	}

	public void setBotChekProgress(String botChekProgress) {
		this.botChekProgress = botChekProgress;
	}

	public boolean isOffered() {
		return offered;
	}

	public void setOffered(boolean offered) {
		this.offered = offered;
	}

	public boolean isApplied() {
		return applied;
	}

	public void setApplied(boolean applied) {
		this.applied = applied;
	}

	public boolean isMatched() {
		return matched;
	}

	public void setMatched(boolean matched) {
		this.matched = matched;
	}

	public Date getOfferDate() {
		return offerDate;
	}

	public void setOfferDate(Date offerDate) {
		this.offerDate = offerDate;
	}

	public Date getAppliedDate() {
		return appliedDate;
	}

	public void setAppliedDate(Date appliedDate) {
		this.appliedDate = appliedDate;
	}

	public Date getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

	public Date getNoTalkWithShopDate() {
		return noTalkWithShopDate;
	}

	public void setNoTalkWithShopDate(Date noTalkWithShopDate) {
		this.noTalkWithShopDate = noTalkWithShopDate;
	}

	public Date getNoCallOrForgotDate() {
		return noCallOrForgotDate;
	}

	public void setNoCallOrForgotDate(Date noCallOrForgotDate) {
		this.noCallOrForgotDate = noCallOrForgotDate;
	}

	public Date getCallShopMessageDate() {
		return callShopMessageDate;
	}

	public void setCallShopMessageDate(Date callShopMessageDate) {
		this.callShopMessageDate = callShopMessageDate;
	}

	public Date getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}

	public Date getRemindInterviewDate() {
		return remindInterviewDate;
	}

	public void setRemindInterviewDate(Date remindInterviewDate) {
		this.remindInterviewDate = remindInterviewDate;
	}

	public Date getRemindInterviewDayDate() {
		return remindInterviewDayDate;
	}

	public void setRemindInterviewDayDate(Date remindInterviewDayDate) {
		this.remindInterviewDayDate = remindInterviewDayDate;
	}

	public Date getAskForWhenInterviewDate() {
		return askForWhenInterviewDate;
	}

	public void setAskForWhenInterviewDate(Date askForWhenInterviewDate) {
		this.askForWhenInterviewDate = askForWhenInterviewDate;
	}

	public Date getAskCandidateHowWasInterviewDate() {
		return askCandidateHowWasInterviewDate;
	}

	public void setAskCandidateHowWasInterviewDate(Date askCandidateHowWasInterviewDate) {
		this.askCandidateHowWasInterviewDate = askCandidateHowWasInterviewDate;
	}

	public Date getResultInterviewDate() {
		return resultInterviewDate;
	}

	public void setResultInterviewDate(Date resultInterviewDate) {
		this.resultInterviewDate = resultInterviewDate;
	}

	public Date getStartWorkingDate() {
		return startWorkingDate;
	}

	public void setStartWorkingDate(Date startWorkingDate) {
		this.startWorkingDate = startWorkingDate;
	}

	public Date getYouStartWorkingTodayDate() {
		return youStartWorkingTodayDate;
	}

	public void setYouStartWorkingTodayDate(Date youStartWorkingTodayDate) {
		this.youStartWorkingTodayDate = youStartWorkingTodayDate;
	}

	public Date getAskForResultDateCandidate() {
		return askForResultDateCandidate;
	}

	public void setAskForResultDateCandidate(Date askForResultDateCandidate) {
		this.askForResultDateCandidate = askForResultDateCandidate;
	}

	public Date getAskForSetInterview() {
		return askForSetInterview;
	}

	public void setAskForSetInterview(Date askForSetInterview) {
		this.askForSetInterview = askForSetInterview;
	}

	public Date getAskShopHowWasInterviewDate() {
		return askShopHowWasInterviewDate;
	}

	public void setAskShopHowWasInterviewDate(Date askShopHowWasInterviewDate) {
		this.askShopHowWasInterviewDate = askShopHowWasInterviewDate;
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

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getInterviewDateJob() {
		return interviewDateJob;
	}

	public void setInterviewDateJob(String interviewDateJob) {
		this.interviewDateJob = interviewDateJob;
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

	public Date getApproveDate() {
		return approveDate;
	}

	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public String getCasePrice() {
		return casePrice;
	}

	public void setCasePrice(String casePrice) {
		this.casePrice = casePrice;
	}

	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

}
