package com.hrdatabank.otome.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hrdatabank.otome.domain.NearestStationOtome;

/**
 * The Interface NearestStationOtomeRepository.
 */
@Repository
public interface NearestStationOtomeRepository extends JpaRepository<NearestStationOtome, Serializable> {

	@Query(value = "select ns from NearestStationOtome ns where ns.idNearestStationCD=:idNearestStationCD")
	public NearestStationOtome getNearStationByIdLineCD(@Param("idNearestStationCD") int idNearestStationCD);
}
