package org.crawler.web.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LogEvents implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idLogException;
	private String exceptionSource;
	private String exceptionReason;
	private String url;

	public LogEvents() {
		super();
	}

	public LogEvents(String exceptionSource, String exceptionReason, String url) {
		super();
		this.exceptionSource = exceptionSource;
		this.exceptionReason = exceptionReason;
		this.url = url;
	}

	public int getIdLogException() {
		return idLogException;
	}

	public void setIdLogException(int idLogException) {
		this.idLogException = idLogException;
	}

	public String getExceptionSource() {
		return exceptionSource;
	}

	public void setExceptionSource(String exceptionSource) {
		this.exceptionSource = exceptionSource;
	}

	public String getExceptionReason() {
		return exceptionReason;
	}

	public void setExceptionReason(String exceptionReason) {
		this.exceptionReason = exceptionReason;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "LogException [exceptionSource=" + exceptionSource + ", exceptionReason=" + exceptionReason + ", url="
				+ url + "]";
	}

}
