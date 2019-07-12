package com.hrdatabank.mtproject.entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

// TODO: Auto-generated Javadoc
/**
 * The Class NearestStation_.
 */
@StaticMetamodel(NearestStation.class)

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
public class NearestStation_ {
	
	/** The japanese station. */
	public static volatile SingularAttribute<NearestStation, String> japaneseStation;

}