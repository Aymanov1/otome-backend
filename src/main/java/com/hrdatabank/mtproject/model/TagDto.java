package com.hrdatabank.mtproject.model;

// TODO: Auto-generated Javadoc
/**
 * The Class TagDto.
 */
public class TagDto {
	/** The id job. */
	private int idJob;

	/** The id tag. */
	private int idTag;

	/** The name tag. */
	private String nameTag;

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: TagDto.java
	 * 
	 * Instantiates a new tag dto.
	 * @param idJob the id job
	 * @param idTag the id tag
	 * @param nameTag the name tag
	 */
	public TagDto(int idJob, int idTag, String nameTag) {
		super();
		this.idJob = idJob;
		this.idTag = idTag;
		this.nameTag = nameTag;
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
	 * Class Name: TagDto.java
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
	 * Class Name: TagDto.java
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
	 * Class Name: TagDto.java
	 * 
	 * Gets the id tag.
	 * @return the id tag
	 */
	public int getIdTag() {
		return idTag;
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
	 * Class Name: TagDto.java
	 * 
	 * Sets the id tag.
	 * @param idTag the new id tag
	 */
	public void setIdTag(int idTag) {
		this.idTag = idTag;
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
	 * Class Name: TagDto.java
	 * 
	 * Gets the name tag.
	 * @return the name tag
	 */
	public String getNameTag() {
		return nameTag;
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
	 * Class Name: TagDto.java
	 * 
	 * Sets the name tag.
	 * @param nameTag the new name tag
	 */
	public void setNameTag(String nameTag) {
		this.nameTag = nameTag;
	}

}
