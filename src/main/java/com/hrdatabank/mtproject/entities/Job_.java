package com.hrdatabank.mtproject.entities;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

// TODO: Auto-generated Javadoc
/**
 * The Class Job_.
 */
@StaticMetamodel(Job.class)

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Builder

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Data

/* (non-Javadoc)
 * @see java.lang.Object#hashCode()
 */
@EqualsAndHashCode(callSuper = false)
public class Job_ {
	
	/** The id job. */
	public static volatile SingularAttribute<Job, Integer> idJob;
	
	/** The position name. */
	public static volatile SingularAttribute<Job, String> positionName;
	
	/** The shop. */
	public static volatile SingularAttribute<Job, Shop> shop;
	
	/** The hourly wage. */
	public static volatile SingularAttribute<Job, Double> hourlyWage;
	
	/** The position category japanese. */
	public static volatile SingularAttribute<Job, String> positionCategoryJapanese;
	
	/** The position category english. */
	public static volatile SingularAttribute<Job, String> positionCategoryEnglish;
	
	/** The interview type. */
	public static volatile SingularAttribute<Job, String> interviewType;
	
	/** The required JLPT. */
	public static volatile SingularAttribute<Job, String> requiredJLPT;
	
	/** The required duration in japan. */
	public static volatile SingularAttribute<Job, String> requiredDurationInJapan;
	
	/** The job details. */
	public static volatile SingularAttribute<Job, String> jobDetails;
	
	/** The tag relationcontents. */
	public static volatile SingularAttribute<Job, String> tagRelationcontents;
	
	/** The checked algorithm. */
	public static volatile SingularAttribute<Job, Boolean> checkedAlgorithm;
	
	/** The status. */
	public static volatile SingularAttribute<Job, Boolean> status;
	
	/** The job tag relations. */
	public static volatile ListAttribute<Job, JobTagRelation> jobTagRelations;

}
