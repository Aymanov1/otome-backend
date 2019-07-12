package com.hrdatabank.mtproject.entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

// TODO: Auto-generated Javadoc
/**
 * The Class Shop_.
 */
@StaticMetamodel(Shop.class)

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
public class Shop_ {
	
	/** The id shop. */
	public static volatile SingularAttribute<Shop, Integer> idShop;
	
	/** The company. */
	public static volatile SingularAttribute<Shop, Company> company;
	
	/** The nearest station. */
	public static volatile SingularAttribute<Shop, NearestStation> nearestStation;
	
	/** The name shop. */
	public static volatile SingularAttribute<Shop, String> nameShop;
	
	/** The address shop. */
	public static volatile SingularAttribute<Shop, String> addressShop;

}