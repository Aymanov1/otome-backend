package com.hrdatabank.mtproject.entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

// TODO: Auto-generated Javadoc
/**
 * The Class Tag_.
 */
@StaticMetamodel(Tag.class)

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
public class Tag_ {

	/** The tag text. */
	public static volatile SingularAttribute<Tag, String> tagText;
	
	/** The id tag. */
	public static volatile SingularAttribute<Tag, Integer> idTag;

}
