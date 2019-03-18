package com.hrdatabank.mtproject.entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@StaticMetamodel(JobTagRelation.class)
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class JobTagRelation_ {

	public static volatile SingularAttribute<JobTagRelation, Tag> tag;
	public static volatile SingularAttribute<JobTagRelation, Job> job;

}
