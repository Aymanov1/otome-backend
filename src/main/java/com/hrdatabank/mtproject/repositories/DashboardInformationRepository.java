package com.hrdatabank.mtproject.repositories;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.hrdatabank.mtproject.entities.DashboardInformation;

@Repository
@RepositoryRestResource
public interface DashboardInformationRepository extends JpaRepository<DashboardInformation, Serializable> {

	@Query(value = "select count(di) from DashboardInformation di where di.status ='Search' and to_char(di.dateOfSet , 'yyyy-MM-dd') = :date")
	public int findSearchingJob(@Param("date") String date);

	@Query(value = "select count(di) from DashboardInformation di where di.status ='Suggested' and to_char(di.dateOfSet , 'yyyy-MM-dd') = :date")
	public int findSuggestedSearchs(@Param("date") String date);

	@Query(value = "select count(di) from DashboardInformation di where di.status ='Failed' and to_char(di.dateOfSet , 'yyyy-MM-dd') = :date")
	public int findFailedSearchs(@Param("date") String date);

	@Query(value = "select count(di) from DashboardInformation di where di.status ='OpenApply' and to_char(di.dateOfSet , 'yyyy-MM-dd') = :date")
	public int findOpenApplypage(@Param("date") String date);

	@Query(value = "select di from DashboardInformation di where di.status='Ignored' and di.dateOfSet=:date and di.idCandidate =:id")
	public DashboardInformation findIgnoredDashboardInformationByIdCandidateAndDate(@Param("date") Date date,
			@Param("id") int id);

}