package com.hrdatabank.mtproject.specifications;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.hrdatabank.mtproject.entities.NearestStation;

// TODO: Auto-generated Javadoc
/**
 * The Class NearestStationSpec.
 */
public class NearestStationSpec implements Specification<NearestStation> {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The criteria. */
	private SearchCriteria criteria;

	/* (non-Javadoc)
	 * @see org.springframework.data.jpa.domain.Specification#toPredicate(javax.persistence.criteria.Root, javax.persistence.criteria.CriteriaQuery, javax.persistence.criteria.CriteriaBuilder)
	 */
	@Override
	public Predicate toPredicate(Root<NearestStation> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

		if (criteria.getOperation().equalsIgnoreCase(">")) {
			return builder.greaterThanOrEqualTo(root.<String>get((String) criteria.getKey()),
					criteria.getValue().toString());
		} else if (criteria.getOperation().equalsIgnoreCase("<")) {
			return builder.lessThanOrEqualTo(root.<String>get((String) criteria.getKey()),
					criteria.getValue().toString());
		} else if (criteria.getOperation().equalsIgnoreCase("OR")) {
			List<Predicate> predicates = new ArrayList<Predicate>();

			for (String param : (List<String>) criteria.getKey()) {
				predicates.add(builder.like(root.<String>get(param), "%" + criteria.getValue() + "%"));

			}

			return builder.or(predicates.toArray(new Predicate[predicates.size()]));

		} else if (criteria.getOperation().equalsIgnoreCase("<>")) {

			List<Integer> lsut = (List<Integer>) criteria.getValue();

			return root.<String>get((String) criteria.getKey()).in(lsut);

		} else if (criteria.getOperation().equalsIgnoreCase(":")) {
			if (root.get((String) criteria.getKey()).getJavaType() == String.class) {
				return builder.like(root.<String>get((String) criteria.getKey()), "%" + criteria.getValue() + "%");
			} else {
				return builder.equal(root.get((String) criteria.getKey()), criteria.getValue());
			}
			// }else if (criteria.getOperation().equalsIgnoreCase("Join")) {
			//
			// final Subquery<Long> relationQuery = query.subquery(Long.class);
			// final Root<NearestStationBotInformationRelation> relation =
			// relationQuery.from(NearestStationBotInformationRelation.class);
			// final Join<NearestStationBotInformationRelation, NearestStation> notes =
			// relation.join("nearestStation");
			// relationQuery.select(notes.<Long>
			// get("nearestStationBotInformationRelationPK"));
			//// relationQuery.where(builder.equal(relation.<Long>
			// get("nearestStationBotInformationRelationPK")));
			//
			// return cb.in(builder.get("noteId")).value(personQuery);
			// }
			//

		}

		return null;
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: NearestStationSpec.java
	 * 
	 * Instantiates a new nearest station spec.
	 * @param criteria the criteria
	 */
	public NearestStationSpec(SearchCriteria criteria) {
		super();
		this.criteria = criteria;
	}
}
