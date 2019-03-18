package com.hrdatabank.mtproject.model;

// TODO: Auto-generated Javadoc
/**
 * The Class ShopObject.
 *
 * @author Wala Ben Amor
 * 
 *         Object of Shop Class having only id and name of the Shop
 */
public class ShopObject {

	/** The id shop. */
	private int idShop;
	
	/** The name shop. */
	private String nameShop;

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: Module-core-hr
	 * 
	 * Class Name: ShopObject.java
	 * 
	 * Instantiates a new shop object.
	 * @param idShop the id shop
	 * @param nameShop the name shop
	 */
	public ShopObject(int idShop, String nameShop) {
		super();
		this.idShop = idShop;
		this.nameShop = nameShop;
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
	 * Class Name: ShopObject.java
	 * 
	 * Gets the id shop.
	 * @return the id shop
	 */
	public int getIdShop() {
		return idShop;
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
	 * Class Name: ShopObject.java
	 * 
	 * Sets the id shop.
	 * @param idShop the new id shop
	 */
	public void setIdShop(int idShop) {
		this.idShop = idShop;
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
	 * Class Name: ShopObject.java
	 * 
	 * Gets the name shop.
	 * @return the name shop
	 */
	public String getNameShop() {
		return nameShop;
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
	 * Class Name: ShopObject.java
	 * 
	 * Sets the name shop.
	 * @param nameShop the new name shop
	 */
	public void setNameShop(String nameShop) {
		this.nameShop = nameShop;
	}

}
