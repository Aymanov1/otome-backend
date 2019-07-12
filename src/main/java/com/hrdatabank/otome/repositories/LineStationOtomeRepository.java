package com.hrdatabank.otome.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.hrdatabank.otome.domain.LineStationOtome;

/**
 * The Interface LineStationOtomeRepository.
 */
@Repository
@RepositoryRestResource
public interface LineStationOtomeRepository extends JpaRepository<LineStationOtome, Long> {

}
