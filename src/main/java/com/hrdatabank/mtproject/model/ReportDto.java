package com.hrdatabank.mtproject.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.hrdatabank.mtproject.entities.Shop;

/**
 * idJob The Class Application.
 */
public class ReportDto {
	private int age;

	private int idCandidate;
	private int idJob;
	private int idCompany;

	private String gender;
	private String candidateAddress;
	private String candidateAddressKatakana;
	private String candidatePhone;
	private String candidateFax;
	private String candidatePreference;
	private String staffComment;
	private String candidateDocument;
	private String candidateName;
	private String candidateKatakana;
	private String casePrice;
	private String companyName;
	private String companyAddress;
	private String companyPhoneNumber;
	private String traningPeriod;
	private String educationHistory;
	private String companyContractPeriod;
	private String responsiblePerson;
	private String companyFax;
	private String jobName;
	private String positionName;
	private String requiredJlpt;
	private String requiredDuration;
	private String shopName;
	private String shopAddress;
	private String nearestStationName;
	private String jobCreatedDate;
	private Date birthDate;
	private Date appliedDate;
	private Date startWorkingDate;
	private Date startTime;
	private Date finishTime;
	private Date validDate;
	private String transportationAllowance;
	private Double hourlyWage;
	private String paymentDate;
	private String employType;
	private String numberStaff;
	private String reference;
	private String totalApprovedAmount;
	// Total amount of
	// that company need to pay to us (Confirmed amount)
	private String numberOfTime;
	private String workingTimeDetails;
	private String dayOff;
	private String insurance;
	private String othersDetails;
	private String staffHired;
	private String selectionDetail;
	private String staffName;
	private String paidHoliday;
	private String shopProgress;
	private String clientName;

	public static int calculateAge(Date dateOfBirth) {
		Calendar today = Calendar.getInstance();
		Calendar birthDate = Calendar.getInstance();
		birthDate.setTime(dateOfBirth);
		if (birthDate.after(today)) {
			// throw new IllegalArgumentException("You don't exist yet");
			return 0;
		}
		int todayYear = today.get(Calendar.YEAR);
		int birthDateYear = birthDate.get(Calendar.YEAR);
		int todayDayOfYear = today.get(Calendar.DAY_OF_YEAR);
		int birthDateDayOfYear = birthDate.get(Calendar.DAY_OF_YEAR);
		int todayMonth = today.get(Calendar.MONTH);
		int birthDateMonth = birthDate.get(Calendar.MONTH);
		int todayDayOfMonth = today.get(Calendar.DAY_OF_MONTH);
		int birthDateDayOfMonth = birthDate.get(Calendar.DAY_OF_MONTH);
		int age = todayYear - birthDateYear;

		// If birth date is greater than todays date (after 2 days adjustment of leap
		// year) then decrement age one year
		if ((birthDateDayOfYear - todayDayOfYear > 3) || (birthDateMonth > todayMonth)) {
			age--;

			// If birth date and todays date are of same month and birth day of month is
			// greater than todays day of month then decrement age
		} else if ((birthDateMonth == todayMonth) && (birthDateDayOfMonth > todayDayOfMonth)) {
			age--;
		}
		return age;
	}
	/**************/

	/*******************************/
	// String jobNameCp, String employTypeCp,String requiredJlptCp,String
	// requiredDurationCp,String shopNameCp, String shopAddressCp,String
	// nearestStationCp, String hourlyWageCp,boolean transportationAllowanceCp,Date
	// startTimeCp, Date finishTimeCp

	// String companyFaxCp, String responsiblePersonCp,
	// String companyContractPeriodCp, String traningPeriodCp,String
	// educationHistoryCp;
	/****************/

	// jc.jobNameCp,
	// jc.employTypeCp,jc.requiredJlptCp,jc.requiredDurationCp,jc.shopNameCp,
	// jc.shopAddressCp,jc.nearestStationCp,
	// jc.hourlyWageCp,jc.transportationAllowanceCp,jc.startTimeCp,jc.finishTimeCp

	// ,jc.companyFaxCp,jc.responsiblePersonCp,jc.companyContractPeriodCp,jc.traningPeriodCp,jc.educationHistoryCp
	/*****************/
	public ReportDto(String candidateName, String candidateNameCp, String candidateKatakana, String candidateKatakanaCp,
			Date candidateBirthday, Date candidateBirthdayCp, Date appliedDate, Date startWorkingDate, String casePrice,
			String companyName, String companyAddress, String companyPhoneNumber, String traningPeriod,
			String educationHistory, String companyContractPeriod, String responsiblePerson, String companyFax,
			Shop shop, String jobName, String positionName, Date jobCreatedDate, String requiredJlpt, Date startTime,
			Date finishTime, Double hourlyWage, int idJob, String requiredDuration, String validityDateCp,
			String shopName, String shopAddress, String shopProgress, boolean transportationAllowance, int idCandidate,
			String staffName, String gender, String candidateAddress, String candidateAddressKatakanaCp,
			String candidatePhone, String candidatePhoneCp, String candidateFax, String candidatePreference,
			String staffComment, String candidateDocument, int idCompany, String jobNameCp, String employTypeCp,
			String requiredJlptCp, String requiredDurationCp, String shopNameCp, String shopAddressCp,
			String nearestStationCp, Double hourlyWageCp, boolean transportationAllowanceCp, Date startTimeCp,
			Date finishTimeCp, String companyFaxCp, String responsiblePersonCp, String companyContractPeriodCp,
			String traningPeriodCp, String educationHistoryCp, Date appliedDateCp, String companyNameCp,
			String companyAddressCp, String companyPhoneNumberCp, String positionNameCp) throws ParseException {
		super();

		/****************/
		if (jobNameCp != null && !jobNameCp.equalsIgnoreCase("")) {
			this.jobName = jobNameCp;
		} else if (shopName != null && positionName != null) {
			this.jobName = jobName;
		}

		/****************/

		// SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy/MM/dd");

		DateFormat formatterDate = new SimpleDateFormat("yyyy/MM/dd");

		// SimpleDateFormat formatterTimeStamp = new SimpleDateFormat("yyyy/MM/dd
		// hh:mm:ss");

		if (candidateNameCp == null || candidateNameCp.equalsIgnoreCase("")) {
			this.candidateName = candidateName;
		} else {
			this.candidateName = candidateNameCp;
		}

		if (candidateKatakanaCp == null || candidateKatakanaCp.equalsIgnoreCase("")) {
			this.candidateKatakana = candidateKatakana;
		} else {
			this.candidateKatakana = candidateKatakanaCp;
		}
		if (candidateBirthdayCp == null) {
			this.birthDate = candidateBirthday;
		} else {
			this.birthDate = candidateBirthdayCp;
		}
		if (this.birthDate != null) {
			String birthDay = formatterDate.format(this.birthDate);
			this.birthDate = formatterDate.parse(birthDay);
		}

		if (this.startWorkingDate != null) {
			String startWorkingDay = formatterDate.format(this.startWorkingDate);
			this.startWorkingDate = formatterDate.parse(startWorkingDay);
		}

		if (startWorkingDate != null) {
			String startWorkingDateString = formatterDate.format(startWorkingDate);
			this.startWorkingDate = formatterDate.parse(startWorkingDateString);
		}
		this.casePrice = casePrice;
		if (companyNameCp != null && !companyNameCp.equalsIgnoreCase("")) {
			this.companyName = companyNameCp;
		} else {
			this.companyName = companyName;

		}
		if (companyAddressCp != null && !companyAddressCp.equalsIgnoreCase("")) {
			this.companyAddress = companyAddressCp;
		} else {
			this.companyAddress = companyAddress;
		}
		if (companyPhoneNumberCp != null) {
			this.companyPhoneNumber = companyPhoneNumberCp;

		} else {
			this.companyPhoneNumber = companyPhoneNumber;
		}

		if (traningPeriodCp != null && !traningPeriodCp.equalsIgnoreCase("")) {
			this.traningPeriod = traningPeriodCp;
		} else {
			this.traningPeriod = traningPeriod;
		}

		if (educationHistoryCp != null && !educationHistoryCp.equalsIgnoreCase("")) {
			this.educationHistory = educationHistoryCp;
		} else {
			this.educationHistory = educationHistory;
		}

		if (companyContractPeriodCp != null && !companyContractPeriodCp.equalsIgnoreCase("")) {
			this.companyContractPeriod = companyContractPeriodCp;
		} else {
			this.companyContractPeriod = companyContractPeriod;
		}

		if (responsiblePersonCp != null && !responsiblePersonCp.equalsIgnoreCase("")) {
			this.responsiblePerson = responsiblePersonCp;
		} else {
			this.responsiblePerson = responsiblePerson;
		}

		if (companyFaxCp != null && !companyFaxCp.equalsIgnoreCase("")) {
			this.companyFax = companyFaxCp;
		} else {
			this.companyFax = companyFax;
		}
		if (nearestStationCp != null && !nearestStationCp.equalsIgnoreCase("")) {
			this.nearestStationName = nearestStationCp;
		} else if (shop.getNearestStation() != null) {
			this.nearestStationName = shop.getNearestStation().getJapaneseStation();
		} else {
			this.nearestStationName = null;
		}

		if (positionNameCp == null || positionNameCp.equalsIgnoreCase("")) {
			this.positionName = positionName;

		} else {
			this.positionName = positionNameCp;

		}

		// if (jobCreatedDate != null) {
		// this.jobCreatedDate = formatterTimeStamp.format(jobCreatedDate);
		// }
		if (appliedDateCp != null) {
			String appliedDateString = formatterDate.format(appliedDateCp);
			this.appliedDate = formatterDate.parse(appliedDateString);
		} else if (appliedDate != null) {
			String appliedDateString = formatterDate.format(appliedDate);
			this.appliedDate = formatterDate.parse(appliedDateString);
		}
		if (appliedDate != null)

		{
			this.jobCreatedDate = formatterDate.format(appliedDate);
		}
		if (requiredJlptCp != null && !requiredJlptCp.equalsIgnoreCase("")) {
			this.requiredJlpt = requiredJlptCp;
		} else {
			this.requiredJlpt = requiredJlpt;
		}
		this.startTime = startTime;
		this.finishTime = finishTime;
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");

		if (startTimeCp != null) {
			String startTimeString = formatter.format(startTimeCp);
			this.startTime = formatter.parse(startTimeString);
		} else if (startTime != null) {
			String startTimeString = formatter.format(startTime);
			this.startTime = formatter.parse(startTimeString);
		}
		if (finishTimeCp != null) {
			String finishTimeString = formatter.format(finishTimeCp);
			this.finishTime = formatter.parse(finishTimeString);
		} else if (finishTime != null) {
			String finishTimeString = formatter.format(finishTime);
			this.finishTime = formatter.parse(finishTimeString);
		}

		if (hourlyWageCp != null) {
			this.hourlyWage = hourlyWageCp;
		} else {
			this.hourlyWage = hourlyWage;
		}

		this.idJob = idJob;
		if (requiredDurationCp != null) {
			this.requiredDuration = requiredDurationCp;
		} else {
			this.requiredDuration = requiredDuration;
		}
		if (validityDateCp == null || validityDateCp.equalsIgnoreCase("")) {
			if (appliedDate != null) {
				Calendar c = Calendar.getInstance();
				c.setTime(appliedDate);
				c.add(Calendar.YEAR, 1);
				this.validDate = c.getTime();
			}

		} else {
			if (validityDateCp != null && validityDateCp != "" && !validityDateCp.equalsIgnoreCase("")) {
				System.out.println("-------www---------validityDateCp-----------------------:" + validityDateCp);
				try {
					this.validDate = formatterDate.parse(validityDateCp);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			// this.validDate = validityDateCp;

		}

		this.shopName = shopName;
		this.shopAddress = shopAddress;

		// this.validDate = validDate;
		// if (validDate != null) {
		// String validDateString = formatterDate.format(validDate);
		// this.validDate = formatterDate.parse(validDateString);
		// }
		if (shopNameCp != null && !shopNameCp.equalsIgnoreCase("")) {
			this.shopName = shopNameCp;
		} else {
			this.shopName = shopName;
		}
		if (shopAddressCp != null && !shopAddressCp.equalsIgnoreCase("")) {
			this.shopAddress = shopAddressCp;

		} else {
			this.shopAddress = shopAddress;
		}

		// this.transportationAllowance = transportationAllowance;

		if (transportationAllowanceCp) {

			this.transportationAllowance = "あり";
		} else {
			this.transportationAllowance = "なし";
		}

		this.idCandidate = idCandidate;

		this.gender = gender;
		if (this.gender == null) {
			this.gender = "";
		}
		this.candidateAddress = candidateAddress;
		if (this.candidateAddress == null) {
			this.candidateAddress = "";
		}
		this.candidateAddressKatakana = candidateAddressKatakanaCp;
		if (this.candidateAddressKatakana == null) {
			this.candidateAddressKatakana = "";
		}
		if (candidatePhoneCp == null) {
			this.candidatePhone = candidatePhone;
		} else {
			this.candidatePhone = candidatePhoneCp;
		}
		if (this.candidatePhone == null) {
			this.candidatePhone = "";
		}
		this.candidateFax = candidateFax;
		if (this.candidateFax == null) {
			this.candidateFax = "";
		}
		this.candidatePreference = candidatePreference;
		if (this.candidatePreference == null) {
			this.candidatePreference = "";
		}
		this.staffComment = staffComment;
		if (this.staffComment == null) {
			this.staffComment = "";
		}
		this.candidateDocument = candidateDocument;
		if (this.candidateDocument == null) {
			this.candidateDocument = "";
		}
		this.shopProgress = shopProgress;
		if (this.shopProgress.equalsIgnoreCase("hired")) {
			this.shopProgress = "採用";
		}
		if (this.shopProgress == null) {
			this.shopProgress = "";
		}
		this.age = 0;
		System.out.println("--------appliedDate-------------------:" + appliedDate);
		System.out.println("--------birthDate-------------------:" + this.birthDate);
		if (this.birthDate != null) {
			this.age = calculateAge(this.birthDate);
		}
		System.out.println("--------this.age-------------------:" + this.age);

		this.paymentDate = "blank";
		if (employTypeCp != null) {
			this.employType = employTypeCp;
		} else {
			this.employType = "アルバイト";
		}
		this.numberStaff = "2";
		this.reference = "blank";
		this.numberOfTime = "4";
		this.workingTimeDetails = "なし";
		this.dayOff = "週休二日制";
		this.insurance = "雇用保険";
		this.othersDetails = "blank";
		this.staffHired = "１名";
		this.selectionDetail = "面接1回";
		// private static final String total_approved_amount = "blank"; Total amount of
		// that company need to pay to us (Confirmed amount)

		if (staffName == null || staffName.equalsIgnoreCase("")) {
			this.staffName = "三枝周";
		} else {
			this.staffName = staffName;
		}
		this.paidHoliday = "入社半年経過後10日";
		// if (totalApprovedAmount == 0) {
		// this.totalApprovedAmount = "blank";
		// } else {
		// this.totalApprovedAmount = Double.toString(totalApprovedAmount);
		// }

		this.totalApprovedAmount = "blank";
		this.idCompany = idCompany;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getCasePrice() {
		return casePrice;
	}

	public void setCasePrice(String casePrice) {
		this.casePrice = casePrice;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getCandidateKatakana() {
		return candidateKatakana;
	}

	public void setCandidateKatakana(String candidateKatakana) {
		this.candidateKatakana = candidateKatakana;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyPhoneNumber() {
		return companyPhoneNumber;
	}

	public void setCompanyPhoneNumber(String companyPhoneNumber) {
		this.companyPhoneNumber = companyPhoneNumber;
	}

	public String getTraningPeriod() {
		return traningPeriod;
	}

	public void setTraningPeriod(String traningPeriod) {
		this.traningPeriod = traningPeriod;
	}

	public String getEducationHistory() {
		return educationHistory;
	}

	public void setEducationHistory(String educationHistory) {
		this.educationHistory = educationHistory;
	}

	public String getCompanyContractPeriod() {
		return companyContractPeriod;
	}

	public void setCompanyContractPeriod(String companyContractPeriod) {
		this.companyContractPeriod = companyContractPeriod;
	}

	public String getResponsiblePerson() {
		return responsiblePerson;
	}

	public void setResponsiblePerson(String responsiblePerson) {
		this.responsiblePerson = responsiblePerson;
	}

	public String getCompanyFax() {
		return companyFax;
	}

	public void setCompanyFax(String companyFax) {
		this.companyFax = companyFax;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getRequiredJlpt() {
		return requiredJlpt;
	}

	public void setRequiredJlpt(String requiredJlpt) {
		this.requiredJlpt = requiredJlpt;
	}

	public Double getHourlyWage() {
		return hourlyWage;
	}

	public void setHourlyWage(Double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

	public String getRequiredDuration() {
		return requiredDuration;
	}

	public void setRequiredDuration(String requiredDuration) {
		this.requiredDuration = requiredDuration;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopAddress() {
		return shopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	public String getTransportationAllowance() {
		return transportationAllowance;
	}

	public void setTransportationAllowance(String transportationAllowance) {
		this.transportationAllowance = transportationAllowance;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCandidateAddress() {
		return candidateAddress;
	}

	public void setCandidateAddress(String candidateAddress) {
		this.candidateAddress = candidateAddress;
	}

	public String getCandidateAddressKatakana() {
		return candidateAddressKatakana;
	}

	public void setCandidateAddressKatakana(String candidateAddressKatakana) {
		this.candidateAddressKatakana = candidateAddressKatakana;
	}

	public String getCandidatePhone() {
		return candidatePhone;
	}

	public void setCandidatePhone(String candidatePhone) {
		this.candidatePhone = candidatePhone;
	}

	public String getCandidateFax() {
		return candidateFax;
	}

	public void setCandidateFax(String candidateFax) {
		this.candidateFax = candidateFax;
	}

	public String getCandidatePreference() {
		return candidatePreference;
	}

	public void setCandidatePreference(String candidatePreference) {
		this.candidatePreference = candidatePreference;
	}

	public String getStaffComment() {
		return staffComment;
	}

	public void setStaffComment(String staffComment) {
		this.staffComment = staffComment;
	}

	public String getCandidateDocument() {
		return candidateDocument;
	}

	public void setCandidateDocument(String candidateDocument) {
		this.candidateDocument = candidateDocument;
	}

	public String getNearestStationName() {
		return nearestStationName;
	}

	public void setNearestStationName(String nearestStationName) {
		this.nearestStationName = nearestStationName;
	}

	public String getPaymentdate() {
		return paymentDate;
	}

	public String getEmploytype() {
		return employType;
	}

	public String getNumberstaff() {
		return numberStaff;
	}

	public String getReference() {
		return reference;
	}

	public String getNumberoftime() {
		return numberOfTime;
	}

	public String getWorkingtimedetails() {
		return workingTimeDetails;
	}

	public String getDayoff() {
		return dayOff;
	}

	public String getInsurance() {
		return insurance;
	}

	public String getOthersdetails() {
		return othersDetails;
	}

	public String getStaffhired() {
		return staffHired;
	}

	public String getSelectiondetail() {
		return selectionDetail;
	}

	public String getPaidholiday() {
		return paidHoliday;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getEmployType() {
		return employType;
	}

	public void setEmployType(String employType) {
		this.employType = employType;
	}

	public String getNumberStaff() {
		return numberStaff;
	}

	public void setNumberStaff(String numberStaff) {
		this.numberStaff = numberStaff;
	}

	public String getTotalApprovedAmount() {
		return totalApprovedAmount;
	}

	public void setTotalApprovedAmount(String totalApprovedAmount) {
		this.totalApprovedAmount = totalApprovedAmount;
	}

	public String getNumberOfTime() {
		return numberOfTime;
	}

	public void setNumberOfTime(String numberOfTime) {
		this.numberOfTime = numberOfTime;
	}

	public String getWorkingTimeDetails() {
		return workingTimeDetails;
	}

	public void setWorkingTimeDetails(String workingTimeDetails) {
		this.workingTimeDetails = workingTimeDetails;
	}

	public String getDayOff() {
		return dayOff;
	}

	public void setDayOff(String dayOff) {
		this.dayOff = dayOff;
	}

	public String getOthersDetails() {
		return othersDetails;
	}

	public void setOthersDetails(String othersDetails) {
		this.othersDetails = othersDetails;
	}

	public String getStaffHired() {
		return staffHired;
	}

	public void setStaffHired(String staffHired) {
		this.staffHired = staffHired;
	}

	public String getSelectionDetail() {
		return selectionDetail;
	}

	public void setSelectionDetail(String selectionDetail) {
		this.selectionDetail = selectionDetail;
	}

	public String getPaidHoliday() {
		return paidHoliday;
	}

	public void setPaidHoliday(String paidHoliday) {
		this.paidHoliday = paidHoliday;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public String getShopProgress() {
		return shopProgress;
	}

	public void setShopProgress(String shopProgress) {
		this.shopProgress = shopProgress;
	}

	public int getIdCandidate() {
		return idCandidate;
	}

	public void setIdCandidate(int idCandidate) {
		this.idCandidate = idCandidate;
	}

	public int getIdJob() {
		return idJob;
	}

	public void setIdJob(int idJob) {
		this.idJob = idJob;
	}

	public String getJobCreatedDate() {
		return jobCreatedDate;
	}

	public void setJobCreatedDate(String jobCreatedDate) {
		this.jobCreatedDate = jobCreatedDate;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getAppliedDate() {
		return appliedDate;
	}

	public void setAppliedDate(Date appliedDate) {
		this.appliedDate = appliedDate;
	}

	public Date getStartWorkingDate() {
		return startWorkingDate;
	}

	public void setStartWorkingDate(Date startWorkingDate) {
		this.startWorkingDate = startWorkingDate;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	public int getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(int idCompany) {
		this.idCompany = idCompany;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	// if (birthDate != null) {
	// DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
	// int d1 = Integer.parseInt(formatter.format(birthDate));
	// LocalDate localDate = LocalDate.now();
	// int d2 = Integer.parseInt(formatter.format(localDate));
	// this.age = (d2 - d1) / 10000;
	//
	// }

}