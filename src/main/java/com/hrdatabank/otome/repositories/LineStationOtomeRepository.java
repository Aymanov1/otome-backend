package com.hrdatabank.otome.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrdatabank.otome.domain.LineStationOtome;

/**
 * The Interface LineStationOtomeRepository.
 */
@Repository
public interface LineStationOtomeRepository extends JpaRepository<LineStationOtome, Long> {

}
