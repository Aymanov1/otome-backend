package com.hrdatabank.mtproject.specifications;

// TODO: Auto-generated Javadoc
/**
 * The Class SearchCriteria.
 *
 * @param <T> the generic type
 */
public class SearchCriteria<T> {
	
	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: SearchCriteria.java
	 * 
	 * Instantiates a new search criteria.
	 * @param key the key
	 * @param operation the operation
	 * @param value the value
	 */
	public SearchCriteria(T key, String operation, T value) {
		super();
		this.key = key;
		this.operation = operation;
		this.value = value;
	}
	
	/** The key. */
	private T key;
	
	/** The operation. */
	private String operation;
	
	/** The value. */
	private T value;
	
	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: SearchCriteria.java
	 * 
	 * Gets the key.
	 * @return the key
	 */
	public T getKey() {
		return key;
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
	 * Class Name: SearchCriteria.java
	 * 
	 * Sets the key.
	 * @param key the new key
	 */
	public void setKey(T key) {
		this.key = key;
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
	 * Class Name: SearchCriteria.java
	 * 
	 * Gets the operation.
	 * @return the operation
	 */
	public String getOperation() {
		return operation;
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
	 * Class Name: SearchCriteria.java
	 * 
	 * Sets the operation.
	 * @param operation the new operation
	 */
	public void setOperation(String operation) {
		this.operation = operation;
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
	 * Class Name: SearchCriteria.java
	 * 
	 * Gets the value.
	 * @return the value
	 */
	public T getValue() {
		return value;
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
	 * Class Name: SearchCriteria.java
	 * 
	 * Sets the value.
	 * @param value the new value
	 */
	public void setValue(T value) {
		this.value = value;
	}
}
