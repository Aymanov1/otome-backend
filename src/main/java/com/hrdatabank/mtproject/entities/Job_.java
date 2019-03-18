package com.hrdatabank.mtproject.entities;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@StaticMetamodel(Job.class)
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class Job_ {
	public static volatile SingularAttribute<Job, Integer> idJob;
	public static volatile SingularAttribute<Job, String> positionName;
	public static volatile SingularAttribute<Job, Shop> shop;
	public static volatile SingularAttribute<Job, Double> hourlyWage;
	public static volatile SingularAttribute<Job, String> positionCategoryJapanese;
	public static volatile SingularAttribute<Job, String> positionCategoryEnglish;
	public static volatile SingularAttribute<Job, String> interviewType;
	public static volatile SingularAttribute<Job, String> requiredJLPT;
	public static volatile SingularAttribute<Job, String> requiredDurationInJapan;
	public static volatile SingularAttribute<Job, String> jobDetails;
	public static volatile SingularAttribute<Job, String> tagRelationcontents;
	public static volatile SingularAttribute<Job, Boolean> checkedAlgorithm;
	public static volatile SingularAttribute<Job, Boolean> status;
	public static volatile ListAttribute<Job, JobTagRelation> jobTagRelations;

}
