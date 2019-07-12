package com.hrdatabank.mtproject.entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

// TODO: Auto-generated Javadoc
/**
 * The Class JobTagRelation_.
 */
@StaticMetamodel(JobTagRelation.class)

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
public class JobTagRelation_ {

	/** The tag. */
	public static volatile SingularAttribute<JobTagRelation, Tag> tag;
	
	/** The job. */
	public static volatile SingularAttribute<JobTagRelation, Job> job;

}
