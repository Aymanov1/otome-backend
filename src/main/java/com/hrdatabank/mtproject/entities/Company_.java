package com.hrdatabank.mtproject.entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

// TODO: Auto-generated Javadoc
/**
 * The Class Company_.
 */
@StaticMetamodel(Company.class)

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
public class Company_ {
	
	/** The id company. */
	public static volatile SingularAttribute<Company, Integer> idCompany;
	
	/** The name company. */
	public static volatile SingularAttribute<Company, String> nameCompany;

}