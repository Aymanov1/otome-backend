package com.hrdatabank.mtproject.entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@StaticMetamodel(Shop.class)
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class Shop_ {
	public static volatile SingularAttribute<Shop, Integer> idShop;
	public static volatile SingularAttribute<Shop, Company> company;
	public static volatile SingularAttribute<Shop, NearestStation> nearestStation;
	public static volatile SingularAttribute<Shop, String> nameShop;
	public static volatile SingularAttribute<Shop, String> addressShop;

}