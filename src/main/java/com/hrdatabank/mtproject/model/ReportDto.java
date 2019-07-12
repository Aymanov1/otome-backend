package com.hrdatabank.mtproject.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.hrdatabank.mtproject.entities.Shop;

// TODO: Auto-generated Javadoc
/**
 * idJob The Class Application.
 */
public class ReportDto {
	
	/** The age. */
	private int age;

	/** The id candidate. */
	private int idCandidate;
	
	/** The id job. */
	private int idJob;
	
	/** The id company. */
	private int idCompany;

	/** The gender. */
	private String gender;
	
	/** The candidate address. */
	private String candidateAddress;
	
	/** The candidate address katakana. */
	private String candidateAddressKatakana;
	
	/** The candidate phone. */
	private String candidatePhone;
	
	/** The candidate fax. */
	private String candidateFax;
	
	/** The candidate preference. */
	private String candidatePreference;
	
	/** The staff comment. */
	private String staffComment;
	
	/** The candidate document. */
	private String candidateDocument;
	
	/** The candidate name. */
	private String candidateName;
	
	/** The candidate katakana. */
	private String candidateKatakana;
	
	/** The case price. */
	private String casePrice;
	
	/** The company name. */
	private String companyName;
	
	/** The company address. */
	private String companyAddress;
	
	/** The company phone number. */
	private String companyPhoneNumber;
	
	/** The traning period. */
	private String traningPeriod;
	
	/** The education history. */
	private String educationHistory;
	
	/** The company contract period. */
	private String companyContractPeriod;
	
	/** The responsible person. */
	private String responsiblePerson;
	
	/** The company fax. */
	private String companyFax;
	
	/** The job name. */
	private String jobName;
	
	/** The position name. */
	private String positionName;
	
	/** The required jlpt. */
	private String requiredJlpt;
	
	/** The required duration. */
	private String requiredDuration;
	
	/** The shop name. */
	private String shopName;
	
	/** The shop address. */
	private String shopAddress;
	
	/** The nearest station name. */
	private String nearestStationName;
	
	/** The job created date. */
	private String jobCreatedDate;
	
	/** The birth date. */
	private Date birthDate;
	
	/** The applied date. */
	private Date appliedDate;
	
	/** The start working date. */
	private Date startWorkingDate;
	
	/** The start time. */
	private Date startTime;
	
	/** The finish time. */
	private Date finishTime;
	
	/** The valid date. */
	private Date validDate;
	
	/** The transportation allowance. */
	private String transportationAllowance;
	
	/** The hourly wage. */
	private Double hourlyWage;
	
	/** The payment date. */
	private String paymentDate;
	
	/** The employ type. */
	private String employType;
	
	/** The number staff. */
	private String numberStaff;
	
	/** The reference. */
	private String reference;
	
	/** The total approved amount. */
	private String totalApprovedAmount;
	// Total amount of
	/** The number of time. */
	// that company need to pay to us (Confirmed amount)
	private String numberOfTime;
	
	/** The working time details. */
	private String workingTimeDetails;
	
	/** The day off. */
	private String dayOff;
	
	/** The insurance. */
	private String insurance;
	
	/** The others details. */
	private String othersDetails;
	
	/** The staff hired. */
	private String staffHired;
	
	/** The selection detail. */
	private String selectionDetail;
	
	/** The staff name. */
	private String staffName;
	
	/** The paid holiday. */
	private String paidHoliday;
	
	/** The shop progress. */
	private String shopProgress;
	
	/** The client name. */
	private String clientName;

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: ReportDto.java
	 * 
	 * Calculate age.
	 * @param dateOfBirth the date of birth
	 * @return the int
	 */
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
	
	/**
	 * ***********.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: ReportDto.java
	 * 
	 * Instantiates a new report dto.
	 * @param candidateName the candidate name
	 * @param candidateNameCp the candidate name cp
	 * @param candidateKatakana the candidate katakana
	 * @param candidateKatakanaCp the candidate katakana cp
	 * @param candidateBirthday the candidate birthday
	 * @param candidateBirthdayCp the candidate birthday cp
	 * @param appliedDate the applied date
	 * @param startWorkingDate the start working date
	 * @param casePrice the case price
	 * @param companyName the company name
	 * @param companyAddress the company address
	 * @param companyPhoneNumber the company phone number
	 * @param traningPeriod the traning period
	 * @param educationHistory the education history
	 * @param companyContractPeriod the company contract period
	 * @param responsiblePerson the responsible person
	 * @param companyFax the company fax
	 * @param shop the shop
	 * @param jobName the job name
	 * @param positionName the position name
	 * @param jobCreatedDate the job created date
	 * @param requiredJlpt the required jlpt
	 * @param startTime the start time
	 * @param finishTime the finish time
	 * @param hourlyWage the hourly wage
	 * @param idJob the id job
	 * @param requiredDuration the required duration
	 * @param validityDateCp the validity date cp
	 * @param shopName the shop name
	 * @param shopAddress the shop address
	 * @param shopProgress the shop progress
	 * @param transportationAllowance the transportation allowance
	 * @param idCandidate the id candidate
	 * @param staffName the staff name
	 * @param gender the gender
	 * @param candidateAddress the candidate address
	 * @param candidateAddressKatakanaCp the candidate address katakana cp
	 * @param candidatePhone the candidate phone
	 * @param candidatePhoneCp the candidate phone cp
	 * @param candidateFax the candidate fax
	 * @param candidatePreference the candidate preference
	 * @param staffComment the staff comment
	 * @param candidateDocument the candidate document
	 * @param idCompany the id company
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
	 * @param companyFaxCp the company fax cp
	 * @param responsiblePersonCp the responsible person cp
	 * @param companyContractPeriodCp the company contract period cp
	 * @param traningPeriodCp the traning period cp
	 * @param educationHistoryCp the education history cp
	 * @param appliedDateCp the applied date cp
	 * @param companyNameCp the company name cp
	 * @param companyAddressCp the company address cp
	 * @param companyPhoneNumberCp the company phone number cp
	 * @param positionNameCp the position name cp
	 * @throws ParseException the parse exception
	 */

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

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: ReportDto.java
	 * 
	 * Gets the client name.
	 * @return the client name
	 */
	public String getClientName() {
		return clientName;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the client name.
	 * @param clientName the new client name
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
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
	 * Class Name: ReportDto.java
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
	 * Class Name: ReportDto.java
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
	 * Class Name: ReportDto.java
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
	 * Class Name: ReportDto.java
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the candidate katakana.
	 * @return the candidate katakana
	 */
	public String getCandidateKatakana() {
		return candidateKatakana;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the candidate katakana.
	 * @param candidateKatakana the new candidate katakana
	 */
	public void setCandidateKatakana(String candidateKatakana) {
		this.candidateKatakana = candidateKatakana;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the company name.
	 * @return the company name
	 */
	public String getCompanyName() {
		return companyName;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the company name.
	 * @param companyName the new company name
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the company address.
	 * @return the company address
	 */
	public String getCompanyAddress() {
		return companyAddress;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the company address.
	 * @param companyAddress the new company address
	 */
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the company phone number.
	 * @return the company phone number
	 */
	public String getCompanyPhoneNumber() {
		return companyPhoneNumber;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the company phone number.
	 * @param companyPhoneNumber the new company phone number
	 */
	public void setCompanyPhoneNumber(String companyPhoneNumber) {
		this.companyPhoneNumber = companyPhoneNumber;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the traning period.
	 * @return the traning period
	 */
	public String getTraningPeriod() {
		return traningPeriod;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the traning period.
	 * @param traningPeriod the new traning period
	 */
	public void setTraningPeriod(String traningPeriod) {
		this.traningPeriod = traningPeriod;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the education history.
	 * @return the education history
	 */
	public String getEducationHistory() {
		return educationHistory;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the education history.
	 * @param educationHistory the new education history
	 */
	public void setEducationHistory(String educationHistory) {
		this.educationHistory = educationHistory;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the company contract period.
	 * @return the company contract period
	 */
	public String getCompanyContractPeriod() {
		return companyContractPeriod;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the company contract period.
	 * @param companyContractPeriod the new company contract period
	 */
	public void setCompanyContractPeriod(String companyContractPeriod) {
		this.companyContractPeriod = companyContractPeriod;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the responsible person.
	 * @return the responsible person
	 */
	public String getResponsiblePerson() {
		return responsiblePerson;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the responsible person.
	 * @param responsiblePerson the new responsible person
	 */
	public void setResponsiblePerson(String responsiblePerson) {
		this.responsiblePerson = responsiblePerson;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the company fax.
	 * @return the company fax
	 */
	public String getCompanyFax() {
		return companyFax;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the company fax.
	 * @param companyFax the new company fax
	 */
	public void setCompanyFax(String companyFax) {
		this.companyFax = companyFax;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the job name.
	 * @return the job name
	 */
	public String getJobName() {
		return jobName;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the job name.
	 * @param jobName the new job name
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
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
	 * Class Name: ReportDto.java
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
	 * Class Name: ReportDto.java
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the required jlpt.
	 * @return the required jlpt
	 */
	public String getRequiredJlpt() {
		return requiredJlpt;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the required jlpt.
	 * @param requiredJlpt the new required jlpt
	 */
	public void setRequiredJlpt(String requiredJlpt) {
		this.requiredJlpt = requiredJlpt;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the hourly wage.
	 * @return the hourly wage
	 */
	public Double getHourlyWage() {
		return hourlyWage;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the hourly wage.
	 * @param hourlyWage the new hourly wage
	 */
	public void setHourlyWage(Double hourlyWage) {
		this.hourlyWage = hourlyWage;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the required duration.
	 * @return the required duration
	 */
	public String getRequiredDuration() {
		return requiredDuration;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the required duration.
	 * @param requiredDuration the new required duration
	 */
	public void setRequiredDuration(String requiredDuration) {
		this.requiredDuration = requiredDuration;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the shop name.
	 * @return the shop name
	 */
	public String getShopName() {
		return shopName;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the shop name.
	 * @param shopName the new shop name
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the shop address.
	 * @return the shop address
	 */
	public String getShopAddress() {
		return shopAddress;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the shop address.
	 * @param shopAddress the new shop address
	 */
	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the transportation allowance.
	 * @return the transportation allowance
	 */
	public String getTransportationAllowance() {
		return transportationAllowance;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the transportation allowance.
	 * @param transportationAllowance the new transportation allowance
	 */
	public void setTransportationAllowance(String transportationAllowance) {
		this.transportationAllowance = transportationAllowance;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the age.
	 * @return the age
	 */
	public int getAge() {
		return age;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the age.
	 * @param age the new age
	 */
	public void setAge(int age) {
		this.age = age;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the gender.
	 * @return the gender
	 */
	public String getGender() {
		return gender;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the gender.
	 * @param gender the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the candidate address.
	 * @return the candidate address
	 */
	public String getCandidateAddress() {
		return candidateAddress;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the candidate address.
	 * @param candidateAddress the new candidate address
	 */
	public void setCandidateAddress(String candidateAddress) {
		this.candidateAddress = candidateAddress;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the candidate address katakana.
	 * @return the candidate address katakana
	 */
	public String getCandidateAddressKatakana() {
		return candidateAddressKatakana;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the candidate address katakana.
	 * @param candidateAddressKatakana the new candidate address katakana
	 */
	public void setCandidateAddressKatakana(String candidateAddressKatakana) {
		this.candidateAddressKatakana = candidateAddressKatakana;
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
	 * Class Name: ReportDto.java
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
	 * Class Name: ReportDto.java
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the candidate fax.
	 * @return the candidate fax
	 */
	public String getCandidateFax() {
		return candidateFax;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the candidate fax.
	 * @param candidateFax the new candidate fax
	 */
	public void setCandidateFax(String candidateFax) {
		this.candidateFax = candidateFax;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the candidate preference.
	 * @return the candidate preference
	 */
	public String getCandidatePreference() {
		return candidatePreference;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the candidate preference.
	 * @param candidatePreference the new candidate preference
	 */
	public void setCandidatePreference(String candidatePreference) {
		this.candidatePreference = candidatePreference;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the staff comment.
	 * @return the staff comment
	 */
	public String getStaffComment() {
		return staffComment;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the staff comment.
	 * @param staffComment the new staff comment
	 */
	public void setStaffComment(String staffComment) {
		this.staffComment = staffComment;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the candidate document.
	 * @return the candidate document
	 */
	public String getCandidateDocument() {
		return candidateDocument;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the candidate document.
	 * @param candidateDocument the new candidate document
	 */
	public void setCandidateDocument(String candidateDocument) {
		this.candidateDocument = candidateDocument;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the nearest station name.
	 * @return the nearest station name
	 */
	public String getNearestStationName() {
		return nearestStationName;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the nearest station name.
	 * @param nearestStationName the new nearest station name
	 */
	public void setNearestStationName(String nearestStationName) {
		this.nearestStationName = nearestStationName;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the paymentdate.
	 * @return the paymentdate
	 */
	public String getPaymentdate() {
		return paymentDate;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the employtype.
	 * @return the employtype
	 */
	public String getEmploytype() {
		return employType;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the numberstaff.
	 * @return the numberstaff
	 */
	public String getNumberstaff() {
		return numberStaff;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the reference.
	 * @return the reference
	 */
	public String getReference() {
		return reference;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the numberoftime.
	 * @return the numberoftime
	 */
	public String getNumberoftime() {
		return numberOfTime;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the workingtimedetails.
	 * @return the workingtimedetails
	 */
	public String getWorkingtimedetails() {
		return workingTimeDetails;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the dayoff.
	 * @return the dayoff
	 */
	public String getDayoff() {
		return dayOff;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the insurance.
	 * @return the insurance
	 */
	public String getInsurance() {
		return insurance;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the othersdetails.
	 * @return the othersdetails
	 */
	public String getOthersdetails() {
		return othersDetails;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the staffhired.
	 * @return the staffhired
	 */
	public String getStaffhired() {
		return staffHired;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the selectiondetail.
	 * @return the selectiondetail
	 */
	public String getSelectiondetail() {
		return selectionDetail;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the paidholiday.
	 * @return the paidholiday
	 */
	public String getPaidholiday() {
		return paidHoliday;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the payment date.
	 * @return the payment date
	 */
	public String getPaymentDate() {
		return paymentDate;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the payment date.
	 * @param paymentDate the new payment date
	 */
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the employ type.
	 * @return the employ type
	 */
	public String getEmployType() {
		return employType;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the employ type.
	 * @param employType the new employ type
	 */
	public void setEmployType(String employType) {
		this.employType = employType;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the number staff.
	 * @return the number staff
	 */
	public String getNumberStaff() {
		return numberStaff;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the number staff.
	 * @param numberStaff the new number staff
	 */
	public void setNumberStaff(String numberStaff) {
		this.numberStaff = numberStaff;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the total approved amount.
	 * @return the total approved amount
	 */
	public String getTotalApprovedAmount() {
		return totalApprovedAmount;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the total approved amount.
	 * @param totalApprovedAmount the new total approved amount
	 */
	public void setTotalApprovedAmount(String totalApprovedAmount) {
		this.totalApprovedAmount = totalApprovedAmount;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the number of time.
	 * @return the number of time
	 */
	public String getNumberOfTime() {
		return numberOfTime;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the number of time.
	 * @param numberOfTime the new number of time
	 */
	public void setNumberOfTime(String numberOfTime) {
		this.numberOfTime = numberOfTime;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the working time details.
	 * @return the working time details
	 */
	public String getWorkingTimeDetails() {
		return workingTimeDetails;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the working time details.
	 * @param workingTimeDetails the new working time details
	 */
	public void setWorkingTimeDetails(String workingTimeDetails) {
		this.workingTimeDetails = workingTimeDetails;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the day off.
	 * @return the day off
	 */
	public String getDayOff() {
		return dayOff;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the day off.
	 * @param dayOff the new day off
	 */
	public void setDayOff(String dayOff) {
		this.dayOff = dayOff;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the others details.
	 * @return the others details
	 */
	public String getOthersDetails() {
		return othersDetails;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the others details.
	 * @param othersDetails the new others details
	 */
	public void setOthersDetails(String othersDetails) {
		this.othersDetails = othersDetails;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the staff hired.
	 * @return the staff hired
	 */
	public String getStaffHired() {
		return staffHired;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the staff hired.
	 * @param staffHired the new staff hired
	 */
	public void setStaffHired(String staffHired) {
		this.staffHired = staffHired;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the selection detail.
	 * @return the selection detail
	 */
	public String getSelectionDetail() {
		return selectionDetail;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the selection detail.
	 * @param selectionDetail the new selection detail
	 */
	public void setSelectionDetail(String selectionDetail) {
		this.selectionDetail = selectionDetail;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the paid holiday.
	 * @return the paid holiday
	 */
	public String getPaidHoliday() {
		return paidHoliday;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the paid holiday.
	 * @param paidHoliday the new paid holiday
	 */
	public void setPaidHoliday(String paidHoliday) {
		this.paidHoliday = paidHoliday;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the reference.
	 * @param reference the new reference
	 */
	public void setReference(String reference) {
		this.reference = reference;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the insurance.
	 * @param insurance the new insurance
	 */
	public void setInsurance(String insurance) {
		this.insurance = insurance;
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
	 * Class Name: ReportDto.java
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
	 * Class Name: ReportDto.java
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
	 * Class Name: ReportDto.java
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
	 * Class Name: ReportDto.java
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
	 * Class Name: ReportDto.java
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
	 * Class Name: ReportDto.java
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the job created date.
	 * @return the job created date
	 */
	public String getJobCreatedDate() {
		return jobCreatedDate;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the job created date.
	 * @param jobCreatedDate the new job created date
	 */
	public void setJobCreatedDate(String jobCreatedDate) {
		this.jobCreatedDate = jobCreatedDate;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the birth date.
	 * @return the birth date
	 */
	public Date getBirthDate() {
		return birthDate;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the birth date.
	 * @param birthDate the new birth date
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
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
	 * Class Name: ReportDto.java
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
	 * Class Name: ReportDto.java
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
	 * Class Name: ReportDto.java
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
	 * Class Name: ReportDto.java
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the start time.
	 * @return the start time
	 */
	public Date getStartTime() {
		return startTime;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the start time.
	 * @param startTime the new start time
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the finish time.
	 * @return the finish time
	 */
	public Date getFinishTime() {
		return finishTime;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the finish time.
	 * @param finishTime the new finish time
	 */
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the valid date.
	 * @return the valid date
	 */
	public Date getValidDate() {
		return validDate;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the valid date.
	 * @param validDate the new valid date
	 */
	public void setValidDate(Date validDate) {
		this.validDate = validDate;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the id company.
	 * @return the id company
	 */
	public int getIdCompany() {
		return idCompany;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the id company.
	 * @param idCompany the new id company
	 */
	public void setIdCompany(int idCompany) {
		this.idCompany = idCompany;
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
	 * Class Name: ReportDto.java
	 * 
	 * Gets the staff name.
	 * @return the staff name
	 */
	public String getStaffName() {
		return staffName;
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
	 * Class Name: ReportDto.java
	 * 
	 * Sets the staff name.
	 * @param staffName the new staff name
	 */
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