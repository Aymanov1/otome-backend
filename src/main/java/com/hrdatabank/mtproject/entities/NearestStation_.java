package com.hrdatabank.mtproject.entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@StaticMetamodel(NearestStation.class)
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class NearestStation_ {
	public static volatile SingularAttribute<NearestStation, String> japaneseStation;

}