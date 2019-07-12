package org.crawler.web.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The Class LogEvents.
 */
@Entity
public class LogEvents implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id log exception. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idLogException;

	/** The exception source. */
	private String exceptionSource;

	/** The exception reason. */
	private String exceptionReason;

	/** The url. */
	private String url;

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: LogEvents.java
	 * 
	 *         Instantiates a new log events.
	 */
	public LogEvents() {
		super();
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: LogEvents.java
	 * 
	 *         Instantiates a new log events.
	 * @param exceptionSource
	 *            the exception source
	 * @param exceptionReason
	 *            the exception reason
	 * @param url
	 *            the url
	 */
	public LogEvents(String exceptionSource, String exceptionReason, String url) {
		super();
		this.exceptionSource = exceptionSource;
		this.exceptionReason = exceptionReason;
		this.url = url;
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: LogEvents.java
	 * 
	 *         Gets the id log exception.
	 * @return the id log exception
	 */
	public int getIdLogException() {
		return idLogException;
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: LogEvents.java
	 * 
	 *         Sets the id log exception.
	 * @param idLogException
	 *            the new id log exception
	 */
	public void setIdLogException(int idLogException) {
		this.idLogException = idLogException;
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: LogEvents.java
	 * 
	 *         Gets the exception source.
	 * @return the exception source
	 */
	public String getExceptionSource() {
		return exceptionSource;
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: LogEvents.java
	 * 
	 *         Sets the exception source.
	 * @param exceptionSource
	 *            the new exception source
	 */
	public void setExceptionSource(String exceptionSource) {
		this.exceptionSource = exceptionSource;
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: LogEvents.java
	 * 
	 *         Gets the exception reason.
	 * @return the exception reason
	 */
	public String getExceptionReason() {
		return exceptionReason;
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: LogEvents.java
	 * 
	 *         Sets the exception reason.
	 * @param exceptionReason
	 *            the new exception reason
	 */
	public void setExceptionReason(String exceptionReason) {
		this.exceptionReason = exceptionReason;
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: LogEvents.java
	 * 
	 *         Gets the url.
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: LogEvents.java
	 * 
	 *         Sets the url.
	 * @param url
	 *            the new url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LogException [exceptionSource=" + exceptionSource + ", exceptionReason=" + exceptionReason + ", url="
				+ url + "]";
	}

}
