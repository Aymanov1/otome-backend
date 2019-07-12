package com.hrdatabank.mtproject.model;

import java.util.Date;

import com.hrdatabank.mtproject.entities.BotInformation;

// TODO: Auto-generated Javadoc
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
	
	/** The user line id. */
	private String userLineId;
	
	/** The first name FB. */
	private String firstNameFB;
	
	/** The last name FB. */
	private String lastNameFB;
	
	/** The time zone FB. */
	private String timeZoneFB;
	
	/** The local FB. */
	private String localFB;
	
	/** The id user FB. */
	private String idUserFB;
	
	/** The candidate FB. */
	private boolean candidateFB;
	
	/** The pending bot. */
	private boolean pendingBot;
	
	/** The register date. */
	private Date registerDate;
	
	/** The guest. */
	private boolean guest;

	/** The birthday. */
	private Date birthday;
	
	/** The bot information. */
	private BotInformation botInformation;

	/** **************. */
	private String nearestStation;
	
	/** The workable time. */
	private String workableTime;

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: CandidateDto.java
	 * 
	 *         Instantiates a new candidate dto.
	 * @param idCandidate            the id candidate
	 * @param idBotInformation            the id bot information
	 * @param languageBot            the language bot
	 * @param userName            the user name
	 * @param phone            the phone
	 * @param jLPT            the j LPT
	 * @param durationInJapan            the duration in japan
	 * @param email            the email
	 * @param profilePicture            the profile picture
	 * @param birthday            the birthday
	 * @param candidateFB the candidate FB
	 * @param userNameKatakana the user name katakana
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
	
	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: CandidateDto.java
	 * 
	 * Instantiates a new candidate dto.
	 * @param idCandidate the id candidate
	 * @param idBotInformation the id bot information
	 * @param languageBot the language bot
	 * @param userName the user name
	 * @param phone the phone
	 * @param jLPT the j LPT
	 * @param durationInJapan the duration in japan
	 * @param email the email
	 * @param profilePicture the profile picture
	 * @param birthday the birthday
	 * @param candidateFB the candidate FB
	 * @param userNameKatakana the user name katakana
	 * @param guest the guest
	 */
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
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author rihabkallel
	 * 
	 *         constructor for recommendation
	 * @param idUser the id user
	 * @param idBotInformation the id bot information
	 * @param languageBot the language bot
	 * @param userName the user name
	 * @param phone the phone
	 * @param jLPT the j LPT
	 * @param durationInJapan the duration in japan
	 * @param email the email
	 * @param profilePicture the profile picture
	 * @param userLineId the user line id
	 * @param firstNameFB the first name FB
	 * @param lastNameFB the last name FB
	 * @param timeZoneFB the time zone FB
	 * @param localFB the local FB
	 * @param idUserFB the id user FB
	 * @param birthday the birthday
	 * @param registerDate the register date
	 * @param candidateFB the candidate FB
	 * @param botInformation the bot information
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

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: CandidateDto.java
	 * 
	 * Instantiates a new candidate dto.
	 * @param idUser the id user
	 * @param userLineId the user line id
	 * @param idUserFB the id user FB
	 * @param isCandidateFB the is candidate FB
	 * @param language the language
	 */
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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
	 * @author Hanios
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

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: CandidateDto.java
	 * 
	 * Checks if is candidate FB.
	 * @return true, if is candidate FB
	 */
	public boolean isCandidateFB() {
		return candidateFB;
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
	 * Class Name: CandidateDto.java
	 * 
	 * Sets the candidate FB.
	 * @param candidateFB the new candidate FB
	 */
	public void setCandidateFB(boolean candidateFB) {
		this.candidateFB = candidateFB;
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
	 * Class Name: CandidateDto.java
	 * 
	 * Gets the bot information.
	 * @return the bot information
	 */
	public BotInformation getBotInformation() {
		return botInformation;
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
	 * Class Name: CandidateDto.java
	 * 
	 * Sets the bot information.
	 * @param botInformation the new bot information
	 */
	public void setBotInformation(BotInformation botInformation) {
		this.botInformation = botInformation;
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
	 * Class Name: CandidateDto.java
	 * 
	 * Gets the register date.
	 * @return the register date
	 */
	public Date getRegisterDate() {
		return registerDate;
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
	 * Class Name: CandidateDto.java
	 * 
	 * Sets the register date.
	 * @param registerDate the new register date
	 */
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
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
	 * Class Name: CandidateDto.java
	 * 
	 * Gets the user line id.
	 * @return the user line id
	 */
	public String getUserLineId() {
		return userLineId;
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
	 * Class Name: CandidateDto.java
	 * 
	 * Sets the user line id.
	 * @param userLineId the new user line id
	 */
	public void setUserLineId(String userLineId) {
		this.userLineId = userLineId;
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
	 * Class Name: CandidateDto.java
	 * 
	 * Gets the first name FB.
	 * @return the first name FB
	 */
	public String getFirstNameFB() {
		return firstNameFB;
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
	 * Class Name: CandidateDto.java
	 * 
	 * Sets the first name FB.
	 * @param firstNameFB the new first name FB
	 */
	public void setFirstNameFB(String firstNameFB) {
		this.firstNameFB = firstNameFB;
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
	 * Class Name: CandidateDto.java
	 * 
	 * Gets the last name FB.
	 * @return the last name FB
	 */
	public String getLastNameFB() {
		return lastNameFB;
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
	 * Class Name: CandidateDto.java
	 * 
	 * Sets the last name FB.
	 * @param lastNameFB the new last name FB
	 */
	public void setLastNameFB(String lastNameFB) {
		this.lastNameFB = lastNameFB;
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
	 * Class Name: CandidateDto.java
	 * 
	 * Gets the time zone FB.
	 * @return the time zone FB
	 */
	public String getTimeZoneFB() {
		return timeZoneFB;
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
	 * Class Name: CandidateDto.java
	 * 
	 * Sets the time zone FB.
	 * @param timeZoneFB the new time zone FB
	 */
	public void setTimeZoneFB(String timeZoneFB) {
		this.timeZoneFB = timeZoneFB;
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
	 * Class Name: CandidateDto.java
	 * 
	 * Gets the local FB.
	 * @return the local FB
	 */
	public String getLocalFB() {
		return localFB;
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
	 * Class Name: CandidateDto.java
	 * 
	 * Sets the local FB.
	 * @param localFB the new local FB
	 */
	public void setLocalFB(String localFB) {
		this.localFB = localFB;
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
	 * Class Name: CandidateDto.java
	 * 
	 * Gets the id user FB.
	 * @return the id user FB
	 */
	public String getIdUserFB() {
		return idUserFB;
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
	 * Class Name: CandidateDto.java
	 * 
	 * Sets the id user FB.
	 * @param idUserFB the new id user FB
	 */
	public void setIdUserFB(String idUserFB) {
		this.idUserFB = idUserFB;
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
	 * Class Name: CandidateDto.java
	 * 
	 * Gets the user name katakana.
	 * @return the user name katakana
	 */
	public String getUserNameKatakana() {
		return userNameKatakana;
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
	 * Class Name: CandidateDto.java
	 * 
	 * Sets the user name katakana.
	 * @param userNameKatakana the new user name katakana
	 */
	public void setUserNameKatakana(String userNameKatakana) {
		this.userNameKatakana = userNameKatakana;
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
	 * Class Name: CandidateDto.java
	 * 
	 * Gets the nearest station.
	 * @return the nearest station
	 */
	public String getNearestStation() {
		return nearestStation;
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
	 * Class Name: CandidateDto.java
	 * 
	 * Sets the nearest station.
	 * @param nearestStation the new nearest station
	 */
	public void setNearestStation(String nearestStation) {
		this.nearestStation = nearestStation;
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
	 * Class Name: CandidateDto.java
	 * 
	 * Gets the workable time.
	 * @return the workable time
	 */
	public String getWorkableTime() {
		return workableTime;
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
	 * Class Name: CandidateDto.java
	 * 
	 * Sets the workable time.
	 * @param workableTime the new workable time
	 */
	public void setWorkableTime(String workableTime) {
		this.workableTime = workableTime;
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
	 * Class Name: CandidateDto.java
	 * 
	 * Instantiates a new candidate dto.
	 * @param idUser the id user
	 * @param userName the user name
	 * @param userNameKatakana the user name katakana
	 * @param phone the phone
	 * @param jLPT the j LPT
	 * @param durationInJapan the duration in japan
	 * @param email the email
	 * @param profilePicture the profile picture
	 * @param userLineId the user line id
	 * @param firstNameFB the first name FB
	 * @param lastNameFB the last name FB
	 * @param timeZoneFB the time zone FB
	 * @param localFB the local FB
	 * @param idUserFB the id user FB
	 * @param candidateFB the candidate FB
	 * @param registerDate the register date
	 * @param birthday the birthday
	 * @param pendingBot the pending bot
	 * @param nearestStation the nearest station
	 * @param workableTime the workable time
	 */
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

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: CandidateDto.java
	 * 
	 * Checks if is pending bot.
	 * @return true, if is pending bot
	 */
	public boolean isPendingBot() {
		return pendingBot;
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
	 * Class Name: CandidateDto.java
	 * 
	 * Sets the pending bot.
	 * @param pendingBot the new pending bot
	 */
	public void setPendingBot(boolean pendingBot) {
		this.pendingBot = pendingBot;
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
	 * Class Name: CandidateDto.java
	 * 
	 * Instantiates a new candidate dto.
	 * @param idUser the id user
	 * @param idBotInformation the id bot information
	 * @param languageBot the language bot
	 * @param userName the user name
	 * @param userNameKatakana the user name katakana
	 * @param phone the phone
	 * @param jLPT the j LPT
	 * @param durationInJapan the duration in japan
	 * @param email the email
	 * @param profilePicture the profile picture
	 * @param userLineId the user line id
	 * @param firstNameFB the first name FB
	 * @param lastNameFB the last name FB
	 * @param timeZoneFB the time zone FB
	 * @param localFB the local FB
	 * @param idUserFB the id user FB
	 * @param candidateFB the candidate FB
	 * @param pendingBot the pending bot
	 * @param registerDate the register date
	 * @param birthday the birthday
	 * @param botInformation the bot information
	 * @param nearestStation the nearest station
	 * @param workableTime the workable time
	 */
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
	
	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: CandidateDto.java
	 * 
	 * Checks if is guest.
	 * @return true, if is guest
	 */
	public boolean isGuest() {
		return guest;
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
	 * Class Name: CandidateDto.java
	 * 
	 * Sets the guest.
	 * @param guest the new guest
	 */
	public void setGuest(boolean guest) {
		this.guest = guest;
	}

}
