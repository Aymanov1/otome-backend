package com.hrdatabank.mtproject.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.hrdatabank.mtproject.entities.NearestStationBotInformationRelation;

@Repository
@RepositoryRestResource
public interface NearestStationBotInformationRelationRepository
		extends JpaRepository<NearestStationBotInformationRelation, Serializable> {

	@Query("SELECT DISTINCT(n.nearestStationBotInformationRelationPK.idBotInformation) FROM NearestStationBotInformationRelation n where n.nearestStationBotInformationRelationPK.idNearestStation IN :stations "
			+ "and (to_timestamp(to_char( n.nearestStationBotInformationRelationPK.searchDate, 'yyyy-MM-dd'), 'yyyy-MM-dd') >= to_timestamp(:dateFrom , 'yyyy-MM-dd'))"
			+ "and (to_timestamp(to_char( n.nearestStationBotInformationRelationPK.searchDate, 'yyyy-MM-dd'), 'yyyy-MM-dd') <= to_timestamp(:dateTo , 'yyyy-MM-dd'))")
	public List<Integer> getBotInformationListHavingStation(@Param("stations") List<Integer> stations,
			@Param("dateFrom") String dateFrom, @Param("dateTo") String dateTo);

}
