package com.hrdatabank.mtproject.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.hrdatabank.mtproject.entities.AffiliateApplication;

@Repository
@RepositoryRestResource
public interface AffiliateApplicationRepository extends JpaRepository<AffiliateApplication, Serializable> {

	@Query(value = "select af from AffiliateApplication af where af.referrer like  (:referrer)", countQuery = "select count(*)  from AffiliateApplication af where af.referrer like  (:referrer))")
	public AffiliateApplication getAffiliateApplication(@Param("referrer") String referrer);

	@Query(value = "select count(*) from AffiliateApplication af where DATE(af.orderDate) = DATE(CURRENT_DATE)")
	public long getAffiliateApplicationByDate();

}
