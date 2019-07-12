package com.hrdatabank.mtproject.model;

// TODO: Auto-generated Javadoc
/**
 * The Class AtsDetail.
 */
public class AtsDetail {

	/** The login id. */
	private String loginId;
	
	/** The password. */
	private String password;
	
	/** The ats status. */
	private String atsStatus;

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: Module-core-hr
	 * 
	 * Class Name: AtsDetail.java
	 * 
	 * Gets the password.
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: Module-core-hr
	 * 
	 * Class Name: AtsDetail.java
	 * 
	 * Sets the password.
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: Module-core-hr
	 * 
	 * Class Name: AtsDetail.java
	 * 
	 * Gets the login id.
	 * @return the login id
	 */
	public String getLoginId() {
		return loginId;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: Module-core-hr
	 * 
	 * Class Name: AtsDetail.java
	 * 
	 * Sets the login id.
	 * @param loginId the new login id
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: Module-core-hr
	 * 
	 * Class Name: AtsDetail.java
	 * 
	 * Instantiates a new ats detail.
	 * @param loginId the login id
	 * @param password the password
	 * @param atsStatus the ats status
	 */
	public AtsDetail(String loginId, String password,String atsStatus) {
		super();
		this.loginId = loginId;
		this.password = password;
		this.atsStatus = atsStatus;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: Module-core-hr
	 * 
	 * Class Name: AtsDetail.java
	 * 
	 * Gets the ats status.
	 * @return the ats status
	 */
	public String getAtsStatus() {
		return atsStatus;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: Module-core-hr
	 * 
	 * Class Name: AtsDetail.java
	 * 
	 * Sets the ats status.
	 * @param atsStatus the new ats status
	 */
	public void setAtsStatus(String atsStatus) {
		this.atsStatus = atsStatus;
	}

}
