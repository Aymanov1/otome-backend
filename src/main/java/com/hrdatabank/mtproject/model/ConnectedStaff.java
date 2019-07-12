package com.hrdatabank.mtproject.model;

// TODO: Auto-generated Javadoc
/**
 * The Class ConnectedStaff.
 */
public class ConnectedStaff {

	/** The company id. */
	private int companyId;
	
	/** The id staff. */
	private int idStaff;
	
	/** The super admin. */
	private boolean superAdmin;

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: Module-core-hr
	 * 
	 * Class Name: ConnectedStaff.java
	 * 
	 * Instantiates a new connected staff.
	 * @param companyId the company id
	 * @param idStaff the id staff
	 * @param superAdmin the super admin
	 */
	public ConnectedStaff(int companyId, int idStaff, boolean superAdmin) {
		super();
		this.companyId = companyId;
		this.idStaff = idStaff;
		this.superAdmin = superAdmin;
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
	 * Class Name: ConnectedStaff.java
	 * 
	 * Gets the company id.
	 * @return the company id
	 */
	public int getCompanyId() {
		return companyId;
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
	 * Class Name: ConnectedStaff.java
	 * 
	 * Sets the company id.
	 * @param companyId the new company id
	 */
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
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
	 * Class Name: ConnectedStaff.java
	 * 
	 * Gets the id staff.
	 * @return the id staff
	 */
	public int getIdStaff() {
		return idStaff;
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
	 * Class Name: ConnectedStaff.java
	 * 
	 * Sets the id staff.
	 * @param idStaff the new id staff
	 */
	public void setIdStaff(int idStaff) {
		this.idStaff = idStaff;
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
	 * Class Name: ConnectedStaff.java
	 * 
	 * Gets the super admin.
	 * @return the super admin
	 */
	public boolean getSuperAdmin() {
		return superAdmin;
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
	 * Class Name: ConnectedStaff.java
	 * 
	 * Sets the super admin.
	 * @param superAdmin the new super admin
	 */
	public void setSuperAdmin(boolean superAdmin) {
		this.superAdmin = superAdmin;
	}

}
