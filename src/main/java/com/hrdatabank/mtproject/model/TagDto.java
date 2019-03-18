package com.hrdatabank.mtproject.model;

public class TagDto {
	/** The id job. */
	private int idJob;

	/** The id tag. */
	private int idTag;

	/** The name tag. */
	private String nameTag;

	public TagDto(int idJob, int idTag, String nameTag) {
		super();
		this.idJob = idJob;
		this.idTag = idTag;
		this.nameTag = nameTag;
	}

	public int getIdJob() {
		return idJob;
	}

	public void setIdJob(int idJob) {
		this.idJob = idJob;
	}

	public int getIdTag() {
		return idTag;
	}

	public void setIdTag(int idTag) {
		this.idTag = idTag;
	}

	public String getNameTag() {
		return nameTag;
	}

	public void setNameTag(String nameTag) {
		this.nameTag = nameTag;
	}

}
