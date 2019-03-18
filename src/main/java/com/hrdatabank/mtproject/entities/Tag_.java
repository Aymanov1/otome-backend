package com.hrdatabank.mtproject.entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@StaticMetamodel(Tag.class)
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class Tag_ {

	public static volatile SingularAttribute<Tag, String> tagText;
	public static volatile SingularAttribute<Tag, Integer> idTag;

}
