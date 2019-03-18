package com.hrdatabank.otome.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.hrdatabank.otome.domain.ConfigCrawler;

/**
 * The Interface JobOtomeRepository.
 */
@Repository
@RepositoryRestResource
public interface ConfigCrawlerRepository extends JpaRepository<ConfigCrawler, Long> {
	
	
}
