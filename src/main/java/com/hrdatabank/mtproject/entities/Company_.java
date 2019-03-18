package com.hrdatabank.mtproject.entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@StaticMetamodel(Company.class)
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class Company_ {
	public static volatile SingularAttribute<Company, Integer> idCompany;
	public static volatile SingularAttribute<Company, String> nameCompany;

}