package com.hrdatabank.mtproject.model;

import java.util.Date;

import com.hrdatabank.mtproject.entities.BotInformation;

/**
 * The Class CandidateDto.
 */
public class CandidateDto {

	/** The id user. */
	private int idUser;

	/** The id bot information. */
	private int idBotInformation;

	/** The language bot. */
	private String languageBot;

	/** The user name. */
	private String userName;

	/** The user name Katakana. */
	protected String userNameKatakana;

	/** The phone. */
	private String phone;

	/** The j LPT. */
	private String jLPT;

	/** The duration in japan. */
	private String durationInJapan;

	/** The email. */
	private String email;

	/** The profile picture. */
	private String profilePicture;
	private String userLineId;
	private String firstNameFB;
	private String lastNameFB;
	private String timeZoneFB;
	private String localFB;
	private String idUserFB;
	private boolean candidateFB;
	private boolean pendingBot;
	private Date registerDate;
	private boolean guest;

	/** The birthday. */
	private Date birthday;
	private BotInformation botInformation;

	/*****************/
	private String nearestStation;
	private String workableTime;

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: CandidateDto.java
	 * 
	 *         Instantiates a new candidate dto.
	 * @param idCandidate
	 *            the id candidate
	 * @param idBotInformation
	 *            the id bot information
	 * @param languageBot
	 *            the language bot
	 * @param userName
	 *            the user name
	 * @param phone
	 *            the phone
	 * @param jLPT
	 *            the j LPT
	 * @param durationInJapan
	 *            the duration in japan
	 * @param email
	 *            the email
	 * @param profilePicture
	 *            the profile picture
	 * @param birthday
	 *            the birthday
	 */
	public CandidateDto(int idCandidate, int idBotInformation, String languageBot, String userName, String phone,
			String jLPT, String durationInJapan, String email, String profilePicture, Date birthday,
			boolean candidateFB, String userNameKatakana) {
		super();
		System.out.println("*************************************" + idBotInformation);
		System.out.println("*************************************" + languageBot);

		System.out.println("*************************************" + idCandidate);
		System.out.println("*************************************" + userName);
		System.out.println("*************************************" + phone);
		System.out.println("*************************************" + jLPT);
		System.out.println("*************************************" + durationInJapan);
		System.out.println("*************************************" + birthday);

		this.setIdUser(idCandidate);
		this.languageBot = languageBot;
		this.userName = userName;
		this.phone = phone;
		this.jLPT = jLPT;
		this.durationInJapan = durationInJapan;
		this.birthday = birthday;
		this.idBotInformation = idBotInformation;
		this.email = email;
		this.profilePicture = profilePicture;
		this.candidateFB = candidateFB;
		this.userNameKatakana = userNameKatakana;
	}
	public CandidateDto(int idCandidate, int idBotInformation, String languageBot, String userName, String phone,
			String jLPT, String durationInJapan, String email, String profilePicture, Date birthday,
			boolean candidateFB, String userNameKatakana,boolean guest) {
		super();
		System.out.println("*************************************" + idBotInformation);
		System.out.println("*************************************" + languageBot);

		System.out.println("*************************************" + idCandidate);
		System.out.println("*************************************" + userName);
		System.out.println("*************************************" + phone);
		System.out.println("*************************************" + jLPT);
		System.out.println("*************************************" + durationInJapan);
		System.out.println("*************************************" + birthday);

		this.setIdUser(idCandidate);
		this.languageBot = languageBot;
		this.userName = userName;
		this.phone = phone;
		this.jLPT = jLPT;
		this.durationInJapan = durationInJapan;
		this.birthday = birthday;
		this.idBotInformation = idBotInformation;
		this.email = email;
		this.profilePicture = profilePicture;
		this.candidateFB = candidateFB;
		this.userNameKatakana = userNameKatakana;
		this.guest=guest;
	}
	/**
	 * @author rihabkallel
	 * 
	 *         constructor for recommendation
	 * 
	 * @param idUser
	 * @param idBotInformation
	 * @param languageBot
	 * @param userName
	 * @param phone
	 * @param jLPT
	 * @param durationInJapan
	 * @param email
	 * @param profilePicture
	 * @param userLineId
	 * @param firstNameFB
	 * @param lastNameFB
	 * @param timeZoneFB
	 * @param localFB
	 * @param idUserFB
	 * @param birthday
	 * @param registerDate
	 * @param candidateFB
	 * @param botInformation
	 */
	public CandidateDto(int idUser, int idBotInformation, String languageBot, String userName, String phone,
			String jLPT, String durationInJapan, String email, String profilePicture, String userLineId,
			String firstNameFB, String lastNameFB, String timeZoneFB, String localFB, String idUserFB, Date birthday,
			Date registerDate, boolean candidateFB, BotInformation botInformation) {
		super();
		this.idUser = idUser;
		this.idBotInformation = idBotInformation;
		this.languageBot = languageBot;
		this.userName = userName;
		this.phone = phone;
		this.jLPT = jLPT;
		this.durationInJapan = durationInJapan;
		this.email = email;
		this.profilePicture = profilePicture;
		this.userLineId = userLineId;
		this.firstNameFB = firstNameFB;
		this.lastNameFB = lastNameFB;
		this.timeZoneFB = timeZoneFB;
		this.localFB = localFB;
		this.idUserFB = idUserFB;
		this.birthday = birthday;
		this.setRegisterDate(registerDate);
		this.candidateFB = candidateFB;
		this.setBotInformation(botInformation);

	}

	public CandidateDto(int idUser, String userLineId, String idUserFB, boolean isCandidateFB, String language) {

		this.idUser = idUser;
		this.userLineId = userLineId;
		this.idUserFB = idUserFB;
		this.languageBot = language;
		this.candidateFB = isCandidateFB;

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
	 *         Class Name: CandidateDto.java
	 * 
	 *         Gets the language bot.
	 * @return the language bot
	 */
	public String getLanguageBot() {
		return languageBot;
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
	 *         Class Name: CandidateDto.java
	 * 
	 *         Sets the language bot.
	 * @param languageBot
	 *            the new language bot
	 */
	public void setLanguageBot(String languageBot) {
		this.languageBot = languageBot;
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
	 *         Class Name: CandidateDto.java
	 * 
	 *         Gets the user name.
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
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
	 *         Class Name: CandidateDto.java
	 * 
	 *         Sets the user name.
	 * @param userName
	 *            the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
	 *         Class Name: CandidateDto.java
	 * 
	 *         Gets the phone.
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
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
	 *         Class Name: CandidateDto.java
	 * 
	 *         Sets the phone.
	 * @param phone
	 *            the new phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
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
	 *         Class Name: CandidateDto.java
	 * 
	 *         Gets the j LPT.
	 * @return the j LPT
	 */
	public String getjLPT() {
		return jLPT;
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
	 *         Class Name: CandidateDto.java
	 * 
	 *         Sets the j LPT.
	 * @param jLPT
	 *            the new j LPT
	 */
	public void setjLPT(String jLPT) {
		this.jLPT = jLPT;
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
	 *         Class Name: CandidateDto.java
	 * 
	 *         Gets the duration in japan.
	 * @return the duration in japan
	 */
	public String getDurationInJapan() {
		return durationInJapan;
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
	 *         Class Name: CandidateDto.java
	 * 
	 *         Sets the duration in japan.
	 * @param durationInJapan
	 *            the new duration in japan
	 */
	public void setDurationInJapan(String durationInJapan) {
		this.durationInJapan = durationInJapan;
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
	 *         Class Name: CandidateDto.java
	 * 
	 *         Gets the birthday.
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
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
	 *         Class Name: CandidateDto.java
	 * 
	 *         Sets the birthday.
	 * @param birthday
	 *            the new birthday
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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
	 *         Class Name: CandidateDto.java
	 * 
	 *         Gets the id user.
	 * @return the id user
	 */
	public int getIdUser() {
		return idUser;
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
	 *         Class Name: CandidateDto.java
	 * 
	 *         Sets the id user.
	 * @param idUser
	 *            the new id user
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
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
	 *         Class Name: CandidateDto.java
	 * 
	 *         Gets the id bot information.
	 * @return the id bot information
	 */
	public int getIdBotInformation() {
		return idBotInformation;
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
	 *         Class Name: CandidateDto.java
	 * 
	 *         Sets the id bot information.
	 * @param idBotInformation
	 *            the new id bot information
	 */
	public void setIdBotInformation(int idBotInformation) {
		this.idBotInformation = idBotInformation;
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
	 *         Class Name: CandidateDto.java
	 * 
	 *         Gets the email.
	 * @return the email
	 */
	public String getEmail() {
		return email;
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
	 *         Class Name: CandidateDto.java
	 * 
	 *         Sets the email.
	 * @param email
	 *            the new email
	 */
	public void setEmail(String email) {
		this.email = email;
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
	 *         Class Name: CandidateDto.java
	 * 
	 *         Gets the profile picture.
	 * @return the profile picture
	 */
	public String getProfilePicture() {
		return profilePicture;
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
	 *         Class Name: CandidateDto.java
	 * 
	 *         Sets the profile picture.
	 * @param profilePicture
	 *            the new profile picture
	 */
	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public boolean isCandidateFB() {
		return candidateFB;
	}

	public void setCandidateFB(boolean candidateFB) {
		this.candidateFB = candidateFB;
	}

	public BotInformation getBotInformation() {
		return botInformation;
	}

	public void setBotInformation(BotInformation botInformation) {
		this.botInformation = botInformation;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getUserLineId() {
		return userLineId;
	}

	public void setUserLineId(String userLineId) {
		this.userLineId = userLineId;
	}

	public String getFirstNameFB() {
		return firstNameFB;
	}

	public void setFirstNameFB(String firstNameFB) {
		this.firstNameFB = firstNameFB;
	}

	public String getLastNameFB() {
		return lastNameFB;
	}

	public void setLastNameFB(String lastNameFB) {
		this.lastNameFB = lastNameFB;
	}

	public String getTimeZoneFB() {
		return timeZoneFB;
	}

	public void setTimeZoneFB(String timeZoneFB) {
		this.timeZoneFB = timeZoneFB;
	}

	public String getLocalFB() {
		return localFB;
	}

	public void setLocalFB(String localFB) {
		this.localFB = localFB;
	}

	public String getIdUserFB() {
		return idUserFB;
	}

	public void setIdUserFB(String idUserFB) {
		this.idUserFB = idUserFB;
	}

	public String getUserNameKatakana() {
		return userNameKatakana;
	}

	public void setUserNameKatakana(String userNameKatakana) {
		this.userNameKatakana = userNameKatakana;
	}

	public String getNearestStation() {
		return nearestStation;
	}

	public void setNearestStation(String nearestStation) {
		this.nearestStation = nearestStation;
	}

	public String getWorkableTime() {
		return workableTime;
	}

	public void setWorkableTime(String workableTime) {
		this.workableTime = workableTime;
	}

	public CandidateDto(int idUser, String userName, String userNameKatakana, String phone, String jLPT,
			String durationInJapan, String email, String profilePicture, String userLineId, String firstNameFB,
			String lastNameFB, String timeZoneFB, String localFB, String idUserFB, boolean candidateFB,
			Date registerDate, Date birthday, boolean pendingBot, String nearestStation, String workableTime) {
		super();
		this.idUser = idUser;
		this.userName = userName;
		this.userNameKatakana = userNameKatakana;
		this.phone = phone;
		this.jLPT = jLPT;
		this.durationInJapan = durationInJapan;
		this.email = email;
		this.profilePicture = profilePicture;
		this.userLineId = userLineId;
		this.firstNameFB = firstNameFB;
		this.lastNameFB = lastNameFB;
		this.timeZoneFB = timeZoneFB;
		this.localFB = localFB;
		this.idUserFB = idUserFB;
		this.candidateFB = candidateFB;
		this.registerDate = registerDate;
		this.birthday = birthday;
		this.pendingBot = pendingBot;
		this.nearestStation = nearestStation;
		this.workableTime = workableTime;
	}

	public boolean isPendingBot() {
		return pendingBot;
	}

	public void setPendingBot(boolean pendingBot) {
		this.pendingBot = pendingBot;
	}

	public CandidateDto(int idUser, int idBotInformation, String languageBot, String userName, String userNameKatakana,
			String phone, String jLPT, String durationInJapan, String email, String profilePicture, String userLineId,
			String firstNameFB, String lastNameFB, String timeZoneFB, String localFB, String idUserFB,
			boolean candidateFB, boolean pendingBot, Date registerDate, Date birthday, BotInformation botInformation,
			String nearestStation, String workableTime) {
		super();
		this.idUser = idUser;
		this.idBotInformation = idBotInformation;
		this.languageBot = languageBot;
		this.userName = userName;
		this.userNameKatakana = userNameKatakana;
		this.phone = phone;
		this.jLPT = jLPT;
		this.durationInJapan = durationInJapan;
		this.email = email;
		this.profilePicture = profilePicture;
		this.userLineId = userLineId;
		this.firstNameFB = firstNameFB;
		this.lastNameFB = lastNameFB;
		this.timeZoneFB = timeZoneFB;
		this.localFB = localFB;
		this.idUserFB = idUserFB;
		this.candidateFB = candidateFB;
		this.pendingBot = pendingBot;
		this.registerDate = registerDate;
		this.birthday = birthday;
		this.botInformation = botInformation;
		this.nearestStation = nearestStation;
		this.workableTime = workableTime;
	}
	public boolean isGuest() {
		return guest;
	}
	public void setGuest(boolean guest) {
		this.guest = guest;
	}

}
