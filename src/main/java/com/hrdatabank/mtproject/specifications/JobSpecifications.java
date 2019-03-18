package com.hrdatabank.mtproject.specifications;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.hrdatabank.mtproject.entities.Company_;
import com.hrdatabank.mtproject.entities.Job;
import com.hrdatabank.mtproject.entities.Job_;
import com.hrdatabank.mtproject.entities.NearestStation_;
import com.hrdatabank.mtproject.entities.Shop_;

public class JobSpecifications {

	/**
	 * @author wala ben Amor
	 * 
	 *         Method to get find Jobs By idCompany Critiria Filter
	 */
	public static Specification<Job> findJobsByCritiriaCompanyIdWithOr(List<Integer> companiesIds) {
		return new Specification<Job>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Job> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				final Collection<Predicate> predicates = new ArrayList<>();
				if (!companiesIds.isEmpty()) {

					for (int idCompany : companiesIds) {
						final Predicate idCompanyPredicate = root.join(Job_.shop).get(Shop_.company)
								.get(Company_.idCompany).in(idCompany);

						predicates.add(idCompanyPredicate);
					}
				} else {
					System.out.println("----companiesIds-----------IS NULL----WWWWalaÏß-----------");

				}
				query.distinct(true);
				return cb.or(predicates.toArray(new Predicate[predicates.size()]));

			}

		};
	}

	/****************************************/
	private static String getContainsLikePattern(String searchTerm) {
		if (searchTerm == null || searchTerm.isEmpty()) {
			return "%";
		} else {
			return "%" + searchTerm.toLowerCase() + "%";
		}
	}

	/***************************************/
	/**
	 * @author wala ben Amor
	 * 
	 *         Method to find Jobs by ShopId With Or between all ids
	 */
	public static Specification<Job> findJobsByCritiriaShopIdWithOr(List<Integer> shopsIds) {
		return new Specification<Job>() {
			@Override
			public Predicate toPredicate(Root<Job> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				final Collection<Predicate> predicates = new ArrayList<>();
				if (shopsIds != null && !shopsIds.isEmpty()) {
					for (int idShop : shopsIds) {
						final Predicate idShopPredicate = root.join(Job_.shop).get(Shop_.idShop).in(idShop);

						predicates.add(idShopPredicate);
					}
				}
				return cb.or(predicates.toArray(new Predicate[predicates.size()]));

			}

		};
	}

	/***************************************/
	/**
	 * @author wala ben Amor
	 * 
	 *         Method to find Jobs by PositionName With Or between all positions
	 */
	public static Specification<Job> findJobsByCritiriaPositionNameWithOr(List<String> jobPositionsList) {
		return new Specification<Job>() {
			@Override
			public Predicate toPredicate(Root<Job> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				final Collection<Predicate> predicates = new ArrayList<>();
				if (!jobPositionsList.isEmpty() && jobPositionsList != null) {
					for (String jobPosition : jobPositionsList) {

						// final Predicate idCompanyPredicate =
						// cb.equal(cb.lower(root.get(Company_.idCompany)),
						// idCompany);

						final Predicate positionNamePredicate = cb.like(cb.lower(root.get(Job_.positionName)),
								getContainsLikePattern(jobPosition));

						predicates.add(positionNamePredicate);
					}
				}
				query.distinct(true);
				return cb.or(predicates.toArray(new Predicate[predicates.size()]));

			}

		};
	}

	/***************************************/
	/**
	 * @author wala ben Amor
	 * 
	 *         Method to get find Jobs ByCritiria With And between all fields
	 */
	public static Specification<Job> findJobsByCritiriaWithAnd(String nearStation, String wageMin, String wageMax,
			String category, String interviewType, String jlpt, String duration, String freeText,
			String checkedJobsStatus, String publicPrivateJobsStatus) {
		return new Specification<Job>() {
			@Override
			public Predicate toPredicate(Root<Job> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				final Collection<Predicate> predicates = new ArrayList<>();
				/*******/

				final Predicate affiliatePredicate = cb.notLike(cb.lower(root.get(Job_.interviewType)), "affiliate");

				predicates.add(affiliatePredicate);

				/*******************/
				if (!StringUtils.isEmpty(checkedJobsStatus) && !checkedJobsStatus.equalsIgnoreCase("All")) {
					final Predicate checkedJobsStatusPredicate = cb.isTrue(root.get(Job_.checkedAlgorithm));
					predicates.add(checkedJobsStatusPredicate);
				}
				/*******************/
				if (!StringUtils.isEmpty(publicPrivateJobsStatus) && !publicPrivateJobsStatus.equalsIgnoreCase("All")) {
					if (publicPrivateJobsStatus.equals("Private")) {
						final Predicate publicPrivatePredicate = cb.isFalse(root.get(Job_.status));
						predicates.add(publicPrivatePredicate);
					} else if (publicPrivateJobsStatus.equals("Public")) {
						final Predicate publicPrivatePredicate = cb.isTrue(root.get(Job_.status));
						predicates.add(publicPrivatePredicate);
					}

				}
				/*******************/
				if (!StringUtils.isEmpty(nearStation)) {
					final Predicate nearStationPredicate = cb.like(cb
							.lower(root.join(Job_.shop).get(Shop_.nearestStation).get(NearestStation_.japaneseStation)),
							getContainsLikePattern(nearStation));
					predicates.add(nearStationPredicate);
				}
				if ((wageMin != null && !wageMin.equals("null") && !StringUtils.isEmpty(wageMin))
						&& (wageMax != null && !wageMax.equals("null") && !StringUtils.isEmpty(wageMax))) {
					final Collection<Predicate> wagePredicates = new ArrayList<>();
					final Predicate wageMaxPredicate = cb.lessThanOrEqualTo(root.get(Job_.hourlyWage),
							Double.parseDouble(wageMax));
					wagePredicates.add(wageMaxPredicate);
					final Predicate wageMinPredicate = cb.greaterThanOrEqualTo(root.get(Job_.hourlyWage),
							Double.parseDouble(wageMin));
					wagePredicates.add(wageMinPredicate);
					final Predicate wagwPredicate = cb
							.and(wagePredicates.toArray(new Predicate[wagePredicates.size()]));
					predicates.add(wagwPredicate);
				} else if ((wageMin != null && !StringUtils.isEmpty(wageMin) && !wageMin.equals("null"))
						&& (wageMax == null || wageMax.equals("null") || StringUtils.isEmpty(wageMax))) {

					final Predicate wageMinPredicate = cb.greaterThanOrEqualTo(root.get(Job_.hourlyWage),
							Double.parseDouble(wageMin));
					predicates.add(wageMinPredicate);
				} else if ((StringUtils.isEmpty(wageMin) || wageMin.equals("null") || wageMin != null)
						&& (!StringUtils.isEmpty(wageMax) && !wageMax.equals("null") && wageMax != null)) {

					final Predicate wageMaxPredicate = cb.lessThanOrEqualTo(root.get(Job_.hourlyWage),
							Double.parseDouble(wageMax));
					predicates.add(wageMaxPredicate);
				}
				/*********************/
				if (!StringUtils.isEmpty(category)) {

					final Predicate categoryPredicate = cb.like(cb.lower(root.get(Job_.positionCategoryEnglish)),
							getContainsLikePattern(category));
					predicates.add(categoryPredicate);
				}
				/*******/
				if (!StringUtils.isEmpty(interviewType) && !interviewType.equalsIgnoreCase("affiliate")) {
					final Predicate interviewTypePredicate = cb.like(cb.lower(root.get(Job_.interviewType)),
							getContainsLikePattern(interviewType));

					predicates.add(interviewTypePredicate);
				}

				/*******/
				if (!StringUtils.isEmpty(jlpt)) {
					final Predicate jlptPredicate = cb.like(cb.lower(root.get(Job_.requiredJLPT)),
							getContainsLikePattern(jlpt));

					predicates.add(jlptPredicate);
				}

				/*******************/
				if (!StringUtils.isEmpty(duration)) {
					final Predicate durationPredicate = cb.like(cb.lower(root.get(Job_.requiredDurationInJapan)),
							getContainsLikePattern(duration));
					predicates.add(durationPredicate);
				}
				/******************
				 * FIRST*TEST***FREETEXT*****WITH***TAG
				 ************************/
				final Collection<Predicate> freeTextPredicates = new ArrayList<>();
				if (!StringUtils.isEmpty(freeText)) {
					final Collection<Predicate> freeTexPredicates = new ArrayList<>();
					final Predicate freeTextPredicate1 = cb.like(cb.lower(root.get(Job_.requiredDurationInJapan)),
							getContainsLikePattern(freeText));
					freeTexPredicates.add(freeTextPredicate1);
					/***************/
					final Predicate freeTextPredicate2 = cb.like(cb.lower(root.get(Job_.requiredJLPT)),
							getContainsLikePattern(freeText));
					freeTexPredicates.add(freeTextPredicate2);
					/***************/
					final Predicate freeTextPredicate3 = cb.like(cb.lower(root.get(Job_.positionName)),
							getContainsLikePattern(freeText));
					freeTexPredicates.add(freeTextPredicate3);
					/***************/

					final Predicate freeTextPredicate4 = cb.like(cb.lower(root.get(Job_.positionCategoryJapanese)),
							getContainsLikePattern(freeText));
					freeTexPredicates.add(freeTextPredicate4);
					/***************/
					final Predicate freeTextPredicate5 = cb.like(cb.lower(root.get(Job_.positionCategoryEnglish)),
							getContainsLikePattern(freeText));
					freeTexPredicates.add(freeTextPredicate5);
					/***************/
					final Predicate freeTextPredicate6 = cb.like(cb.lower(root.get(Job_.interviewType)),
							getContainsLikePattern(freeText));
					freeTexPredicates.add(freeTextPredicate6);
					/***************/
					final Predicate freeTextPredicate7 = cb.like(
							cb.lower(root.join(Job_.shop).get(Shop_.company).get(Company_.nameCompany)),
							getContainsLikePattern(freeText));
					freeTexPredicates.add(freeTextPredicate7);
					/***************/
					final Predicate freeTextPredicate8 = cb.like(cb.lower(root.join(Job_.shop).get(Shop_.nameShop)),
							getContainsLikePattern(freeText));
					freeTexPredicates.add(freeTextPredicate8);
					/***************/
					final Predicate freeTextPredicate9 = cb.like(cb.lower(root.join(Job_.shop).get(Shop_.addressShop)),
							getContainsLikePattern(freeText));
					freeTexPredicates.add(freeTextPredicate9);
					/***************/
					final Predicate freeTextPredicate10 = cb.like(cb.lower(root.get(Job_.jobDetails)),
							getContainsLikePattern(freeText));
					freeTexPredicates.add(freeTextPredicate10);
					/***************/
					try {
						final Predicate freeTextPredicate11 = root.get(Job_.idJob).in(Integer.parseInt(freeText));
						freeTexPredicates.add(freeTextPredicate11);
					} catch (NumberFormatException e) {
						// not an integer!
						System.out.println("---------freeText-----not an integer!--****-----------");
					}
					/******************************
					 * TAGGGGGGGG
					 ****************************************************/
					/***************/
					final Predicate tagPredicate = cb.like(cb.lower(root.get(Job_.tagRelationcontents)),
							getContainsLikePattern(freeText));
					freeTexPredicates.add(tagPredicate);
					/*********************************************************************************/
					/*******************************************************/
					final Predicate freeTexPredicate = cb
							.or(freeTexPredicates.toArray(new Predicate[freeTexPredicates.size()]));
					predicates.add(freeTexPredicate);
				}
				/************************************************************/
				query.distinct(true);
				return cb.and(predicates.toArray(new Predicate[predicates.size()]));

			}

		};
	}

}
