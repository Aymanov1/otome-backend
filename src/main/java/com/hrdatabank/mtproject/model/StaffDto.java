package com.hrdatabank.mtproject.model;

// TODO: Auto-generated Javadoc
/**
 * The Class StaffDto.
 */
public class StaffDto {
	
	/** The id user. */
	private int idUser;
	
	/** The staff name. */
	private String staffName;
	
	/** The email. */
	private String email;
	
	/** The user name. */
	private String userName;

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: Module-core-hr
	 * 
	 * Class Name: StaffDto.java
	 * 
	 * Gets the id user.
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
	 * Using JRE: 1.8
	 * 
	 * Project Name: Module-core-hr
	 * 
	 * Class Name: StaffDto.java
	 * 
	 * Instantiates a new staff dto.
	 * @param idUser the id user
	 * @param staffName the staff name
	 * @param email the email
	 * @param userName the user name
	 */
	public StaffDto(int idUser, String staffName, String email, String userName) {
		super();
		this.idUser = idUser;
		this.staffName = staffName;
		this.email = email;
		this.userName = userName;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: Module-core-hr
	 * 
	 * Class Name: StaffDto.java
	 * 
	 * Sets the id user.
	 * @param idUser the new id user
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: Module-core-hr
	 * 
	 * Class Name: StaffDto.java
	 * 
	 * Gets the staff name.
	 * @return the staff name
	 */
	public String getStaffName() {
		return staffName;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: Module-core-hr
	 * 
	 * Class Name: StaffDto.java
	 * 
	 * Sets the staff name.
	 * @param staffName the new staff name
	 */
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: Module-core-hr
	 * 
	 * Class Name: StaffDto.java
	 * 
	 * Gets the email.
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
	 * Using JRE: 1.8
	 * 
	 * Project Name: Module-core-hr
	 * 
	 * Class Name: StaffDto.java
	 * 
	 * Sets the email.
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: Module-core-hr
	 * 
	 * Class Name: StaffDto.java
	 * 
	 * Gets the user name.
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
	 * Using JRE: 1.8
	 * 
	 * Project Name: Module-core-hr
	 * 
	 * Class Name: StaffDto.java
	 * 
	 * Sets the user name.
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
