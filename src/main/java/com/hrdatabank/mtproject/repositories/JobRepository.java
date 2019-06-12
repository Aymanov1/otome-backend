package com.hrdatabank.mtproject.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hrdatabank.mtproject.entities.Job;
import com.hrdatabank.mtproject.model.JobDto;

/**
 * The Interface JobRepository.
 */
@Repository
public interface JobRepository extends JpaRepository<Job, Serializable>, JpaSpecificationExecutor<Job> {

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobRepository.java
	 * 
	 *         Find by all fields by distance.
	 * @param workType
	 *            the work type
	 * @param WorkTime
	 *            the work time
	 * @param lat
	 *            the lat
	 * @param lng
	 *            the lng
	 * @return the list
	 */
	@Query(value = "SELECT DISTINCT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=1) and (lower(j.position_category_english) like lower(CONCAT('%',:workType,'%')) or lower(j.position_category_japanese) like lower(CONCAT('%',:workType,'%'))) and (lower(j.work_time_english) like lower(CONCAT('%',:WorkTime,'%')) or lower(j.work_time_japanese) like lower(CONCAT('%',:WorkTime,'%')))", nativeQuery = true)
	public List<Integer> findByAllFieldsByDistance(@Param("workType") String workType,
			@Param("WorkTime") String WorkTime, @Param("lat") double lat, @Param("lng") double lng);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobRepository.java
	 * 
	 *         Find by time by distance.
	 * @param WorkTime
	 *            the work time
	 * @param lat
	 *            the lat
	 * @param lng
	 *            the lng
	 * @return the list
	 */
	@Query(value = "SELECT DISTINCT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=1) and (lower(j.work_time_english) like lower(CONCAT('%',:WorkTime,'%')) or lower(j.work_time_japanese) like lower(CONCAT('%',:WorkTime,'%')))", nativeQuery = true)
	public List<Integer> findByTimeByDistance(@Param("WorkTime") String WorkTime, @Param("lat") double lat,
			@Param("lng") double lng);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobRepository.java
	 * 
	 *         Find by type by distance.
	 * @param workType
	 *            the work type
	 * @param lat
	 *            the lat
	 * @param lng
	 *            the lng
	 * @return the list
	 */
	@Query(value = "SELECT DISTINCT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=1) and (lower(j.position_category_english) like lower(CONCAT('%',:workType,'%')) or lower(j.position_category_japanese) like lower(CONCAT('%',:workType,'%')))", nativeQuery = true)
	public List<Integer> findByTypeByDistance(@Param("workType") String workType, @Param("lat") double lat,
			@Param("lng") double lng);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobRepository.java
	 * 
	 *         Find all opened jobs by distance.
	 * @param lat
	 *            the lat
	 * @param lng
	 *            the lng
	 * @return the list
	 */
	@Query(value = "SELECT DISTINCT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=1)", nativeQuery = true)
	public List<Integer> findAllOpenedJobsByDistance(@Param("lat") double lat, @Param("lng") double lng);

	/**
	 * **************************************************************************************.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobRepository.java
	 * 
	 *         Find by area or station.
	 * @param station
	 *            the station
	 * @param pageable
	 *            the pageable
	 * @return the page
	 */
	@Query(value = "SELECT DISTINCT(j) FROM Job j where lower(j.shop.addressShop) like lower(CONCAT('%',:station,'%')) or lower(j.shop.nearestStation.japaneseRomajiStation) like lower(CONCAT('%',:station,'%')) or lower(j.shop.nearestStation.japaneseHiraganaStation) like lower(CONCAT('%',:station,'%')) or lower(j.shop.nearestStation.japaneseKatakanaStation) like lower(CONCAT('%',:station,'%')) or lower(j.shop.nearestStation.japaneseStation) like lower(CONCAT('%',:station,'%'))", countQuery = "SELECT count(*) FROM Job j where lower(j.shop.addressShop) like lower(CONCAT('%',:address,'%')) or lower(j.shop.nearestStation.japaneseRomajiStation) like lower(CONCAT('%',:station,'%')) or lower(j.shop.nearestStation.japaneseHiraganaStation) like lower(CONCAT('%',:station,'%')) or lower(j.shop.nearestStation.japaneseKatakanaStation) like lower(CONCAT('%',:station,'%')) or lower(j.shop.nearestStation.japaneseStation) like lower(CONCAT('%',:station,'%'))")
	public Page<Job> findByAreaOrStation(@Param("station") String station, Pageable pageable);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobRepository.java
	 * 
	 *         Find by station.
	 * @param station
	 *            the station
	 * @param pageable
	 *            the pageable
	 * @return the page
	 */
	@Query(value = "SELECT DISTINCT(j) FROM Job j where lower(j.shop.nearestStation.japaneseRomajiStation) like lower(CONCAT('%',:station,'%')) or lower(j.shop.nearestStation.japaneseHiraganaStation) like lower(CONCAT('%',:station,'%')) or lower(j.shop.nearestStation.japaneseKatakanaStation) like lower(CONCAT('%',:station,'%'))  or lower(j.shop.nearestStation.japaneseStation) like lower(CONCAT('%',:station,'%'))", countQuery = "SELECT count(*) FROM Job j where lower(j.shop.nearestStation.japaneseRomajiStation) like lower(CONCAT('%',:station,'%')) or lower(j.shop.nearestStation.japaneseHiraganaStation) like lower(CONCAT('%',:station,'%')) or lower(j.shop.nearestStation.japaneseKatakanaStation) like lower(CONCAT('%',:station,'%'))  or lower(j.shop.nearestStation.japaneseStation) like lower(CONCAT('%',:station,'%'))")
	public Page<Job> findByStation(@Param("station") String station, Pageable pageable);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobRepository.java
	 * 
	 *         Find stations.
	 * @param station
	 *            the station
	 * @param pageable
	 *            the pageable
	 * @return the page
	 */
	@Query(value = "SELECT n.* from  nearest_station n where lower(n.japanese_station) like lower(CONCAT('%',:station,'%')) or abs(cast( GREATEST(length(:station),length(n.japanese_station)) -levenshtein( lower(:station),lower(n.japanese_station)) as float))/GREATEST(length(:station),length(n.japanese_station))*100 >40 or lower(n.japanese_hiragana_station) like lower(CONCAT('%',:station,'%'))   or abs(cast( GREATEST(length(:station), length(n.japanese_hiragana_station))- levenshtein(lower(:station),n.japanese_hiragana_station)as float))/GREATEST(length(:station),length(n.japanese_hiragana_station))*100>40 or lower(n.japanese_katakana_station) like lower(CONCAT('%',:station,'%') ) or   abs(cast( GREATEST(length(:station),length(n.japanese_katakana_station))-levenshtein(lower(:station),lower(n.japanese_katakana_station))as float))/GREATEST(length(:station),length(n.japanese_katakana_station))*100>40 or lower(n.japanese_romaji_station) like lower(CONCAT('%',:station,'%') ) or  abs(cast(GREATEST(length(:station), length(n.japanese_romaji_station))-levenshtein( lower(:station),n.japanese_romaji_station) as  float))/GREATEST(length(:station),length(n.japanese_romaji_station)) *100>40 GROUP BY   n.id_nearest_station ORDER BY GREATEST(abs(cast(GREATEST(length(:station), length(n.japanese_romaji_station))-levenshtein( lower(:station),n.japanese_romaji_station) as  float))/GREATEST(length(:station),length(n.japanese_romaji_station)) *100,abs(cast( GREATEST(length(:station), length(n.japanese_hiragana_station))- levenshtein(lower(:station),n.japanese_hiragana_station)as float))/GREATEST(length(:station),length(n.japanese_hiragana_station))*100,abs(cast( GREATEST(length(:station),length(n.japanese_station)) -levenshtein( lower(:station),lower(n.japanese_station)) as float))/GREATEST(length(:station),length(n.japanese_station))*100,abs(cast( GREATEST(length(:station),length(n.japanese_katakana_station))-levenshtein(lower(:station),lower(n.japanese_katakana_station))as float))/GREATEST(length(:station),length(n.japanese_katakana_station))*100) desc ,    ?#{#pageable} ", nativeQuery = true, countQuery = "SELECT count(n.*) from  nearest_station n  where lower(n.japanese_station) like lower(CONCAT('%',:station,'%')) or abs(cast( GREATEST(length(:station),length(n.japanese_station)) -levenshtein( lower(:station),lower(n.japanese_station)) as float))/GREATEST(length(:station),length(n.japanese_station))*100 >40 or lower(n.japanese_hiragana_station) like lower(CONCAT('%',:station,'%'))   or abs(cast( GREATEST(length(:station), length(n.japanese_hiragana_station))- levenshtein(lower(:station),n.japanese_hiragana_station)as float))/GREATEST(length(:station),length(n.japanese_station))*100>40 or lower(n.japanese_katakana_station) like lower(CONCAT('%',:station,'%') ) or   abs(cast( GREATEST(length(:station),length(n.japanese_katakana_station))-levenshtein(lower(:station),lower(n.japanese_katakana_station))as float))/GREATEST(length(:station),length(n.japanese_station))*100>40 or lower(n.japanese_romaji_station) like lower(CONCAT('%',:station,'%') ) or  abs(cast(GREATEST(length(:station), length(n.japanese_romaji_station))-levenshtein( lower(:station),n.japanese_romaji_station) as  float))/GREATEST(length(:station),length(n.japanese_station)) *100>40 GROUP BY   n.id_nearest_station ORDER BY GREATEST(abs(cast(GREATEST(length(:station), length(n.japanese_romaji_station))-levenshtein( lower(:station),n.japanese_romaji_station) as  float))/GREATEST(length(:station),length(n.japanese_station)) *100,abs(cast( GREATEST(length(:station), length(n.japanese_hiragana_station))- levenshtein(lower(:station),n.japanese_hiragana_station)as float))/GREATEST(length(:station),length(n.japanese_station))*100,abs(cast( GREATEST(length(:station),length(n.japanese_station)) -levenshtein( lower(:station),lower(n.japanese_station)) as float))/GREATEST(length(:station),length(n.japanese_station))*100,abs(cast( GREATEST(length(:station),length(n.japanese_katakana_station))-levenshtein(lower(:station),lower(n.japanese_katakana_station))as float))/GREATEST(length(:station),length(n.japanese_station))*100) desc ,  ?#{#pageable}  ")
	public Page<Job> findStations(@Param("station") String station, Pageable pageable);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobRepository.java
	 * 
	 *         Find all jobs by keyword paginated.
	 * @param pageable
	 *            the pageable
	 * @param keyword
	 *            the keyword
	 * @return the page
	 */
	@Query(value = "SELECT j from Job j where (lower(j.interviewType) NOT like lower('affiliate')) and ((lower(j.shop.nameShop) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.shop.company.nameCompany) like lower(CONCAT('%',:keyword,'%'))) or (CAST(j.idJob as text) like CONCAT('%',:keyword,'%')) or (lower(j.shop.addressShop) like lower(CONCAT('%',:keyword,'%')))) ORDER BY j.shop.company.idCompany ASC, j.idJob ASC", countQuery = "SELECT COUNT(*) from Job j where (lower(j.interviewType) NOT like lower('affiliate')) and  ((lower(j.shop.nameShop) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.shop.company.nameCompany) like lower(CONCAT('%',:keyword,'%')))  or (CAST(j.idJob as text) like CONCAT('%',:keyword,'%')) or (lower(j.shop.addressShop) like lower(CONCAT('%',:keyword,'%'))))")
	public Page<Job> findAllJobsByKeywordPaginated(Pageable pageable, @Param("keyword") String keyword);

	@Query(value = "SELECT j from Job j where (j.status = :publicStatus) and  (lower(j.interviewType) NOT like lower('affiliate')) and ((CAST(j.idJob as text) like CONCAT('%',:keyword,'%')) or (lower(j.shop.nameShop) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.shop.company.nameCompany) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.shop.addressShop) like lower(CONCAT('%',:keyword,'%')))) ORDER BY j.shop.company.idCompany ASC, j.idJob ASC", countQuery = "SELECT COUNT(*) from Job j where (j.status = :publicStatus) and  (lower(j.interviewType) NOT like lower('affiliate')) and  ((CAST(j.idJob as text) like CONCAT('%',:keyword,'%')) or (lower(j.shop.nameShop) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.shop.company.nameCompany) like lower(CONCAT('%',:keyword,'%')))  or (lower(j.shop.addressShop) like lower(CONCAT('%',:keyword,'%'))))")
	public Page<Job> findAllPublicOrPrivateJobsByKeywordPaginated(Pageable pageable, @Param("keyword") String keyword,
			@Param("publicStatus") boolean publicStatus);

	@Query(value = "SELECT j from Job j where (j.checkedAlgorithm = TRUE ) and (lower(j.interviewType) NOT like lower('affiliate')) and ((CAST(j.idJob as text) like CONCAT('%',:keyword,'%')) or (lower(j.shop.nameShop) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.shop.company.nameCompany) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.shop.addressShop) like lower(CONCAT('%',:keyword,'%')))) ORDER BY j.shop.company.idCompany ASC, j.idJob ASC", countQuery = "SELECT COUNT(*) from Job j where (j.checkedAlgorithm = TRUE ) and (lower(j.interviewType) NOT like lower('affiliate')) and  ((CAST(j.idJob as text) like CONCAT('%',:keyword,'%')) or (lower(j.shop.nameShop) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.shop.company.nameCompany) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.shop.addressShop) like lower(CONCAT('%',:keyword,'%'))))")
	public Page<Job> findAllCheckedAlgorithmJobsByKeywordPaginated(Pageable pageable, @Param("keyword") String keyword);

	@Query(value = "SELECT j from Job j where (j.status = :publicStatus) and (j.checkedAlgorithm = TRUE ) and (lower(j.interviewType) NOT like lower('affiliate')) and ((CAST(j.idJob as text) like CONCAT('%',:keyword,'%')) or (lower(j.shop.nameShop) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.shop.company.nameCompany) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.shop.addressShop) like lower(CONCAT('%',:keyword,'%')))) ORDER BY j.shop.company.idCompany ASC, j.idJob ASC", countQuery = "SELECT COUNT(*) from Job j where (j.status = :publicStatus) and  (j.checkedAlgorithm = TRUE ) and (lower(j.interviewType) NOT like lower('affiliate')) and  ((CAST(j.idJob as text) like CONCAT('%',:keyword,'%')) or (lower(j.shop.nameShop) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.shop.company.nameCompany) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.shop.addressShop) like lower(CONCAT('%',:keyword,'%'))))")
	public Page<Job> findAllPublicPrivateCheckedJobsByKeywordPaginated(Pageable pageable,
			@Param("keyword") String keyword, @Param("publicStatus") boolean publicStatus);

	/*****************************************/
	/********** FILTERED BY NEARSTATION ***********************/
	/**********************************************/
	@Query(value = "SELECT j from Job j where (lower(j.interviewType) NOT like lower('affiliate')) and ((lower(j.shop.nameShop) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.shop.company.nameCompany) like lower(CONCAT('%',:keyword,'%'))) or (CAST(j.idJob as text) like CONCAT('%',:keyword,'%')) or (lower(j.shop.addressShop) like lower(CONCAT('%',:keyword,'%')))) and ((lower(j.shop.nearestStation.japaneseStation) like lower(CONCAT('%',:stationFilter,'%'))) or (lower(j.shop.nearestStation.japaneseKatakanaStation) like lower(CONCAT('%',:stationFilter,'%'))) or (lower(j.shop.nearestStation.japaneseHiraganaStation) like lower(CONCAT('%',:stationFilter,'%'))) or (lower(j.shop.nearestStation.japaneseRomajiStation) like lower(CONCAT('%',:stationFilter,'%')))) ORDER BY j.shop.company.idCompany ASC, j.idJob ASC", countQuery = "SELECT COUNT(*) from Job j where (lower(j.interviewType) NOT like lower('affiliate')) and  ((lower(j.shop.nameShop) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.shop.company.nameCompany) like lower(CONCAT('%',:keyword,'%')))  or (CAST(j.idJob as text) like CONCAT('%',:keyword,'%')) or (lower(j.shop.addressShop) like lower(CONCAT('%',:keyword,'%'))))  and ((lower(j.shop.nearestStation.japaneseStation) like lower(CONCAT('%',:stationFilter,'%'))) or (lower(j.shop.nearestStation.japaneseKatakanaStation) like lower(CONCAT('%',:stationFilter,'%'))) or (lower(j.shop.nearestStation.japaneseHiraganaStation) like lower(CONCAT('%',:stationFilter,'%'))) or (lower(j.shop.nearestStation.japaneseRomajiStation) like lower(CONCAT('%',:stationFilter,'%')))) ")
	public Page<Job> findAllJobsByKeywordPaginatedFiltredNearStation(Pageable pageable,
			@Param("keyword") String keyword, @Param("stationFilter") String stationFilter);

	@Query(value = "SELECT j from Job j where (j.status = :publicStatus) and  (lower(j.interviewType) NOT like lower('affiliate')) and ((CAST(j.idJob as text) like CONCAT('%',:keyword,'%')) or (lower(j.shop.nameShop) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.shop.company.nameCompany) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.shop.addressShop) like lower(CONCAT('%',:keyword,'%'))))  and ((lower(j.shop.nearestStation.japaneseStation) like lower(CONCAT('%',:stationFilter,'%'))) or (lower(j.shop.nearestStation.japaneseKatakanaStation) like lower(CONCAT('%',:stationFilter,'%'))) or (lower(j.shop.nearestStation.japaneseHiraganaStation) like lower(CONCAT('%',:stationFilter,'%'))) or (lower(j.shop.nearestStation.japaneseRomajiStation) like lower(CONCAT('%',:stationFilter,'%'))))  ORDER BY j.shop.company.idCompany ASC, j.idJob ASC", countQuery = "SELECT COUNT(*) from Job j where (j.status = :publicStatus) and  (lower(j.interviewType) NOT like lower('affiliate')) and  ((CAST(j.idJob as text) like CONCAT('%',:keyword,'%')) or (lower(j.shop.nameShop) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.shop.company.nameCompany) like lower(CONCAT('%',:keyword,'%')))  or (lower(j.shop.addressShop) like lower(CONCAT('%',:keyword,'%'))))  and ((lower(j.shop.nearestStation.japaneseStation) like lower(CONCAT('%',:stationFilter,'%'))) or (lower(j.shop.nearestStation.japaneseKatakanaStation) like lower(CONCAT('%',:stationFilter,'%'))) or (lower(j.shop.nearestStation.japaneseHiraganaStation) like lower(CONCAT('%',:stationFilter,'%'))) or (lower(j.shop.nearestStation.japaneseRomajiStation) like lower(CONCAT('%',:stationFilter,'%')))) ")
	public Page<Job> findAllPublicOrPrivateJobsByKeywordPaginatedFiltredNearStation(Pageable pageable,
			@Param("keyword") String keyword, @Param("publicStatus") boolean publicStatus,
			@Param("stationFilter") String stationFilter);

	@Query(value = "SELECT j from Job j where (j.checkedAlgorithm = TRUE ) and (lower(j.interviewType) NOT like lower('affiliate')) and ((CAST(j.idJob as text) like CONCAT('%',:keyword,'%')) or (lower(j.shop.nameShop) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.shop.company.nameCompany) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.shop.addressShop) like lower(CONCAT('%',:keyword,'%'))))  and ((lower(j.shop.nearestStation.japaneseStation) like lower(CONCAT('%',:stationFilter,'%'))) or (lower(j.shop.nearestStation.japaneseKatakanaStation) like lower(CONCAT('%',:stationFilter,'%'))) or (lower(j.shop.nearestStation.japaneseHiraganaStation) like lower(CONCAT('%',:stationFilter,'%'))) or (lower(j.shop.nearestStation.japaneseRomajiStation) like lower(CONCAT('%',:stationFilter,'%'))))  ORDER BY j.shop.company.idCompany ASC, j.idJob ASC", countQuery = "SELECT COUNT(*) from Job j where (j.checkedAlgorithm = TRUE ) and (lower(j.interviewType) NOT like lower('affiliate')) and  ((CAST(j.idJob as text) like CONCAT('%',:keyword,'%')) or (lower(j.shop.nameShop) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.shop.company.nameCompany) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.shop.addressShop) like lower(CONCAT('%',:keyword,'%'))))  and ((lower(j.shop.nearestStation.japaneseStation) like lower(CONCAT('%',:stationFilter,'%'))) or (lower(j.shop.nearestStation.japaneseKatakanaStation) like lower(CONCAT('%',:stationFilter,'%'))) or (lower(j.shop.nearestStation.japaneseHiraganaStation) like lower(CONCAT('%',:stationFilter,'%'))) or (lower(j.shop.nearestStation.japaneseRomajiStation) like lower(CONCAT('%',:stationFilter,'%')))) ")
	public Page<Job> findAllCheckedAlgorithmJobsByKeywordPaginatedFiltredNearStation(Pageable pageable,
			@Param("keyword") String keyword, @Param("stationFilter") String stationFilter);

	@Query(value = "SELECT j from Job j where (j.status = :publicStatus) and (j.checkedAlgorithm = TRUE ) and (lower(j.interviewType) NOT like lower('affiliate')) and ((CAST(j.idJob as text) like CONCAT('%',:keyword,'%')) or (lower(j.shop.nameShop) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.shop.company.nameCompany) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.shop.addressShop) like lower(CONCAT('%',:keyword,'%'))))  and ((lower(j.shop.nearestStation.japaneseStation) like lower(CONCAT('%',:stationFilter,'%'))) or (lower(j.shop.nearestStation.japaneseKatakanaStation) like lower(CONCAT('%',:stationFilter,'%'))) or (lower(j.shop.nearestStation.japaneseHiraganaStation) like lower(CONCAT('%',:stationFilter,'%'))) or (lower(j.shop.nearestStation.japaneseRomajiStation) like lower(CONCAT('%',:stationFilter,'%')))) ORDER BY j.shop.company.idCompany ASC, j.idJob ASC", countQuery = "SELECT COUNT(*) from Job j where (j.status = :publicStatus) and  (j.checkedAlgorithm = TRUE ) and (lower(j.interviewType) NOT like lower('affiliate')) and  ((CAST(j.idJob as text) like CONCAT('%',:keyword,'%')) or (lower(j.shop.nameShop) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.shop.company.nameCompany) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.shop.addressShop) like lower(CONCAT('%',:keyword,'%'))))  and ((lower(j.shop.nearestStation.japaneseStation) like lower(CONCAT('%',:stationFilter,'%'))) or (lower(j.shop.nearestStation.japaneseKatakanaStation) like lower(CONCAT('%',:stationFilter,'%'))) or (lower(j.shop.nearestStation.japaneseHiraganaStation) like lower(CONCAT('%',:stationFilter,'%'))) or (lower(j.shop.nearestStation.japaneseRomajiStation) like lower(CONCAT('%',:stationFilter,'%')))) ")
	public Page<Job> findAllPublicPrivateCheckedJobsByKeywordPaginatedFiltredNearStation(Pageable pageable,
			@Param("keyword") String keyword, @Param("publicStatus") boolean publicStatus,
			@Param("stationFilter") String stationFilter);

	/*****************************************/
	/*********************************/
	/**********************************************/

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobRepository.java
	 * 
	 *         Find all jobs by keyword paginated method two.
	 * @param pageable
	 *            the pageable
	 * @param keyword
	 *            the keyword
	 * @return the page
	 */
	@Query(value = "SELECT j FROM Job j")
	public Page<Object> findAllJobsByKeywordPaginatedMethodTwo(Pageable pageable, @Param("keyword") String keyword);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobRepository.java
	 * 
	 *         Find all opened jobs.
	 * @return the list
	 */
	@Query(value = "SELECT DISTINCT(j) FROM Job j where j.status = TRUE", countQuery = "SELECT count(*) FROM Job j where j.status = TRUE")
	public List<Job> findAllOpenedJobs();

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobRepository.java
	 * 
	 *         Gets the jobs by shop and company.
	 * @param idShop
	 *            the id shop
	 * @param idCompany
	 *            the id company
	 * @return the jobs by shop and company
	 */
	@Query(value = "SELECT j FROM Job j where j.shop.idShop=:idShop and j.shop.company.idCompany=:idCompany")
	public List<Job> getJobsByShopAndCompany(@Param("idShop") int idShop, @Param("idCompany") int idCompany);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobRepository.java
	 * 
	 *         Gets the jobs by shop.
	 * @param idShop
	 *            the id shop
	 * @return the jobs by shop
	 */
	@Query(value = "SELECT j FROM Job j where j.shop.idShop=:idShop")
	public List<Job> getJobsByShop(@Param("idShop") int idShop);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobRepository.java
	 * 
	 *         Find all jobs by keyword and id company.
	 * @param pageable
	 *            the pageable
	 * @param idCompany
	 *            the id company
	 * @param keyword
	 *            the keyword
	 * @return the page
	 */
	@Query(value = "SELECT j from Job j where j.shop.company.idCompany=:idCompany and ((lower(j.shop.nameShop) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.positionName) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.shop.addressShop) like lower(CONCAT('%',:keyword,'%')))) ORDER BY j.shop.company.idCompany ASC, j.idJob ASC", countQuery = "SELECT COUNT(*) from Job j where j.shop.company.idCompany=:idCompany and ((lower(j.shop.nameShop) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.positionName) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.shop.addressShop) like lower(CONCAT('%',:keyword,'%'))))")
	public Page<Job> findAllJobsByKeywordAndIdCompany(Pageable pageable, @Param("idCompany") int idCompany,
			@Param("keyword") String keyword);

	@Query(value = "SELECT j from Job j where j.shop.company.idCompany=:idCompany and (j.status = :publicStatus) and ((lower(j.shop.nameShop) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.positionName) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.shop.addressShop) like lower(CONCAT('%',:keyword,'%')))) ORDER BY j.shop.company.idCompany ASC, j.idJob ASC", countQuery = "SELECT COUNT(*) from Job j where j.shop.company.idCompany=:idCompany and (j.status = :publicStatus) and ((lower(j.shop.nameShop) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.positionName) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.shop.addressShop) like lower(CONCAT('%',:keyword,'%'))))")
	public Page<Job> findAllPublicOrPrivateJobsByKeywordAndIdCompany(Pageable pageable,
			@Param("idCompany") int idCompany, @Param("keyword") String keyword,
			@Param("publicStatus") boolean publicStatus);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobRepository.java
	 * 
	 *         Find all jobs by keyword and id shop.
	 * @param pageable
	 *            the pageable
	 * @param idShop
	 *            the id shop
	 * @param keyword
	 *            the keyword
	 * @return the page
	 */
	@Query(value = "SELECT j from Job j where j.shop.idShop=:idShop and ((lower(j.shop.nameShop) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.positionName) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.shop.addressShop) like lower(CONCAT('%',:keyword,'%')))) ORDER BY j.shop.company.idCompany ASC, j.idJob ASC", countQuery = "SELECT COUNT(*) from Job j where j.shop.idShop=:idShop and  ( (lower(j.shop.nameShop) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.positionName) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.shop.addressShop) like lower(CONCAT('%',:keyword,'%'))))")
	public Page<Job> findAllJobsByKeywordAndIdShop(Pageable pageable, @Param("idShop") int idShop,
			@Param("keyword") String keyword);

	@Query(value = "SELECT j from Job j where j.shop.idShop=:idShop and (j.status = :publicStatus) and ((lower(j.shop.nameShop) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.positionName) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.shop.addressShop) like lower(CONCAT('%',:keyword,'%')))) ORDER BY j.shop.company.idCompany ASC, j.idJob ASC", countQuery = "SELECT COUNT(*) from Job j where j.shop.idShop=:idShop and (j.status = :publicStatus) and  ( (lower(j.shop.nameShop) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.positionName) like lower(CONCAT('%',:keyword,'%'))) or (lower(j.shop.addressShop) like lower(CONCAT('%',:keyword,'%'))))")
	public Page<Job> findAllPublicOrPrivateJobsByKeywordAndIdShop(Pageable pageable, @Param("idShop") int idShop,
			@Param("keyword") String keyword, @Param("publicStatus") boolean publicStatus);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobRepository.java
	 * 
	 *         Gets the job list by id job list and id detail.
	 * @param idJobList
	 *            the id job list
	 * @param idJobDetail
	 *            the id job detail
	 * @return the job list by id job list and id detail
	 */
	@Query(value = "SELECT j FROM Job j where j.idJobList=:idJobList and  j.idJobDetail like lower(:idJobDetail) ")
	public List<Job> getJobListByIdJobListAndIdDetail(@Param("idJobList") int idJobList,
			@Param("idJobDetail") String idJobDetail);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobRepository.java
	 * 
	 *         Gets the job by id job list and id detail.
	 * @param idJobList
	 *            the id job list
	 * @param idJobDetail
	 *            the id job detail
	 * @return the job by id job list and id detail
	 */
	@Query(value = "SELECT j FROM Job j where j.idJobList=:idJobList and  j.idJobDetail like lower(:idJobDetail) ")
	public Job getJobByIdJobListAndIdDetail(@Param("idJobList") int idJobList,
			@Param("idJobDetail") String idJobDetail);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobRepository.java
	 * 
	 *         Gets the job by id job list.
	 * @param idJobList
	 *            the id job list
	 * @return the job by id job list
	 */
	@Query(value = "SELECT j FROM Job j where j.idJobList=:idJobList")
	public List<Job> getJobByIdJobList(@Param("idJobList") int idJobList);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobRepository.java
	 * 
	 *         Gets the jobs affiliate acivated.
	 * @return the jobs affiliate acivated
	 */
	@Query(value = "SELECT j FROM Job j where (lower(j.interviewType) like lower('affiliate'))and j.status = TRUE")
	public List<Job> getJobsAffiliateAcivated();

	@Query(value = "SELECT j FROM Job j where j.affiliateType IS NULL and (lower(j.interviewType) like lower('affiliate'))", countQuery = "SELECT COUNT(j) FROM Job j where j.affiliateType IS NULL and (lower(j.interviewType) like lower('affiliate'))")
	public Page<Job> getAffiliateJobs(Pageable pageable);

	@Query(value = "SELECT COUNT(j) FROM Job j where j.affiliateType IS NULL and (lower(j.interviewType) like lower('affiliate'))")
	public long getCountAffiliateJobs();

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobRepository.java
	 * 
	 *         Gets the job dto by id.
	 * @param idJob
	 *            the id job
	 * @return the job dto by id
	 */
	@Query(value = "SELECT NEW com.hrdatabank.mtproject.model.JobDto(j.idJob,j.shop.idShop,j.shop.company.idCompany,j.shop.nameShop,j.positionName,j.hourlyWage,j.shop.transportationAllowance,j.possibleWorkingDaysPerWeek,j.possibleWorkingHoursPerDay,j.pictureJob,j.requiredJLPT,j.requiredDurationInJapan,j.interviewType,j.shop.interviewVenue,j.shop.addressShop,j.shop.phoneNumber,j.interviewDateJob,j.shop.nearestStation.nearestStationDetail,j.shop.latitude,j.shop.longitude,j.jobDetails,j.finishWorkingTime,j.startWorkingTime,j.idJobDetail, j.jobURL) FROM Job j where j.idJob=:idJob")
	public JobDto getJobDtoById(@Param("idJob") int idJob);

	@Query(value = "SELECT NEW com.hrdatabank.mtproject.model.JobDto(j.idJob, j.shop.idShop, j.shop.company.idCompany, j.shop.nameShop, j.positionName, j.shop.phoneNumber, j.possibleWorkingDaysPerWeek, j.possibleWorkingHoursPerDay, j.hourlyWage, j.pictureJob, j.requiredJLPT, j.requiredDurationInJapan, j.interviewType, j.shop.interviewVenue, j.shop.addressShop, j.interviewDateJob, j.shop.latitude, j.shop.longitude, j.jobDetails, j.finishWorkingTime, j.startWorkingTime, j.jobDetails, j.idJobList, j.idJobDetail, j.jobURL, j.workTimeEnglish, j.workTimeJapanese, j.positionCategoryEnglish, j.positionCategoryJapanese, j.salaryDetail, j.jobType, j.trainingPeriod, j.hourlyWageMemo, j.hourlyWageInTrainingPeriod, j.workTimeDetail, j.numberStaffNeeded, j.salary, j.status, j.openJobDate, j.validJobDate, j.shop.descriptionShop, j.shop.category, j.shop.openTime, j.shop.logoShop, j.shop.userIdLine, j.shop.emailShop, j.shop.phoneNumber, j.shop.applyPhoneNumber, j.shop.reference, j.shop.requirement, j.shop.interviewVenue, j.shop.possiblePhoneTime,j.shop.transportationAllowance, j.shop.company.nameCompany, j.shop.company.logoCompany, j.shop.company.description, j.shop.company.phoneNumber, j.shop.company.addressCompany, j.shop.company.emailCompany)    FROM Job j where j.idJob=:idJob")
	public JobDto getJobDtoByIdForRecommeandation(@Param("idJob") int idJob);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobRepository.java
	 * 
	 *         Gets the jobs affiliate activated.
	 * @return the jobs affiliate activated
	 */
	@Query(value = "SELECT j FROM Job j where (lower(j.interviewType) like lower('affiliate')) and j.status = TRUE")
	public List<Job> getJobsAffiliateActivated();

	@Query(value = "SELECT NEW com.hrdatabank.mtproject.model.JobDto(j.idJob, j.shop.idShop, j.shop.company.idCompany, j.shop.nameShop, j.positionName, j.shop.phoneNumber, j.possibleWorkingDaysPerWeek, j.possibleWorkingHoursPerDay, j.hourlyWage, j.pictureJob, j.requiredJLPT, j.requiredDurationInJapan, j.interviewType, j.shop.interviewVenue, j.shop.addressShop, j.interviewDateJob, j.shop.latitude, j.shop.longitude, j.jobDetails, j.finishWorkingTime, j.startWorkingTime, j.jobDetails, j.idJobList, j.idJobDetail, j.jobURL, j.workTimeEnglish, j.workTimeJapanese, j.positionCategoryEnglish, j.positionCategoryJapanese, j.salaryDetail, j.jobType, j.trainingPeriod, j.hourlyWageMemo, j.hourlyWageInTrainingPeriod, j.workTimeDetail, j.numberStaffNeeded, j.salary, j.status, j.openJobDate, j.validJobDate, j.shop.descriptionShop, j.shop.category, j.shop.openTime, j.shop.logoShop, j.shop.userIdLine, j.shop.emailShop, j.shop.phoneNumber, j.shop.applyPhoneNumber, j.shop.reference, j.shop.requirement, j.shop.interviewVenue, j.shop.possiblePhoneTime,j.shop.transportationAllowance, j.shop.company.nameCompany, j.shop.company.logoCompany, j.shop.company.description, j.shop.company.phoneNumber, j.shop.company.addressCompany, j.shop.company.emailCompany)   FROM Job j where  j.status = :open", countName = "SELECT count(*) FROM Job j  where j.status = :open")
	public Page<JobDto> getJobDtoForRecommendationPaginated(Pageable pageable, @Param("open") boolean open);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Wala ben Amor
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobRepository.java
	 * 
	 *         Gets the jobs affiliate activated.
	 * @return the jobs affiliate activated
	 */
	@Query(value = "SELECT j FROM Job j where (lower(j.interviewType) like lower('affiliate')) and j.status = TRUE  and j.jobURL LIKE CONCAT('%','line','%') ")
	public List<Job> getLineJobsAffiliateActivated(Pageable pageable);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Wala ben Amor
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobRepository.java
	 * 
	 *         Gets the jobs affiliate activated.
	 * @return the jobs affiliate activated
	 */
	@Query(value = "SELECT j FROM Job j where (lower(j.interviewType) like lower('affiliate')) and j.status = TRUE and j.jobURL LIKE CONCAT('%','baitoru','%')")
	public List<Job> getBaitoruJobsAffiliateActivated(Pageable pageable);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Wala ben Amor
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobRepository.java
	 * 
	 *         Gets the jobs affiliate activated.
	 * @return the jobs affiliate activated
	 */
	@Query(value = "SELECT j FROM Job j where (lower(j.interviewType) like lower('affiliate')) and j.status = TRUE and j.jobURL LIKE CONCAT('%','townwork','%')")
	public List<Job> getTownWorkJobsAffiliateActivated(Pageable pageable);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Wala ben Amor
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobRepository.java
	 * 
	 *         Gets the jobs affiliate activated.
	 * @return the jobs affiliate activated
	 */
	@Query(value = "SELECT j FROM Job j where (lower(j.interviewType) like lower('affiliate')) and j.status = TRUE and j.jobURL LIKE CONCAT('%','j-sen','%')")
	public List<Job> getJsenJobsAffiliateActivated(Pageable pageable);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Wala ben Amor
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobRepository.java
	 * 
	 *         count the jobs affiliate activated.
	 * @return the jobs affiliate activated
	 */
	@Query(value = "SELECT count(j) FROM Job j where (lower(j.interviewType) like lower('affiliate')) and j.status = TRUE  and j.jobURL LIKE CONCAT('%','line','%') ")
	public long countLineJobsAffiliateActivated();

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Wala ben Amor
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobRepository.java
	 * 
	 *         count the jobs affiliate activated.
	 * @return the jobs affiliate activated
	 */
	@Query(value = "SELECT count(j) FROM Job j where (lower(j.interviewType) like lower('affiliate')) and j.status = TRUE and j.jobURL LIKE CONCAT('%','baitoru','%')")
	public long countBaitoruJobsAffiliateActivated();

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Wala ben Amor
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobRepository.java
	 * 
	 *         count the jobs affiliate activated.
	 * @return the jobs affiliate activated
	 */
	@Query(value = "SELECT count(j) FROM Job j where (lower(j.interviewType) like lower('affiliate')) and j.status = TRUE and j.jobURL LIKE CONCAT('%','townwork','%')")
	public long countTownWorkJobsAffiliateActivated();

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Wala ben Amor
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobRepository.java
	 * 
	 *         count the jobs affiliate activated.
	 * @return the jobs affiliate activated
	 */
	@Query(value = "SELECT count(j) FROM Job j where (lower(j.interviewType) like lower('affiliate')) and j.status = TRUE and j.jobURL LIKE CONCAT('%','j-sen','%')")
	public long countJsenJobsAffiliateActivated();

	/**
	 * ;RESET ALL;DEALLOCATE ALL;CLOSE ALL;UNLISTEN *;SELECT
	 * pg_advisory_unlock_all();DISCARD PLANS;DISCARD TEMP;
	 */

	@Query(value = "SET SESSION AUTHORIZATION DEFAULT;", nativeQuery = true)
	public void setSessionAuthorizationQuery();

	@Query(value = "RESET ALL;", nativeQuery = true)
	public void resetAllQuery();

	@Query(value = "DEALLOCATE ALL", nativeQuery = true)
	public void deallocateAllQuery();

	@Query(value = "CLOSE ALL", nativeQuery = true)
	public void closeAllQuery();

	@Query(value = "UNLISTEN *", nativeQuery = true)
	public void unlistenQuery();

	@Query(value = "SELECT pg_advisory_unlock_all()", nativeQuery = true)
	public void selectPGAdvisoryQuery();

	@Query(value = "DISCARD PLANS", nativeQuery = true)
	public void discardPlansQuery();

	@Query(value = "DISCARD TEMP", nativeQuery = true)
	public void discardTempQuery();

	/******************** search job queries ******************/
	@Query(value = "SELECT COUNT(*) from setseed(:seed)", nativeQuery = true)
	public void randomSeed(@Param("seed") double seed);

	/******* normal jobs waitcall first ********/

	@Query(value = "SELECT  j.id_job FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and j.interview_type != 'affiliate' and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm))   GROUP BY   j.id_job ORDER BY  j.interview_type asc, RANDOM() asc, ?#{#pageable}  ", nativeQuery = true, countQuery = "SELECT COUNT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and j.interview_type != 'affiliate' and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) ")
	public Page<Integer> findAllNormalOpenedJobsByDistance(@Param("lat") double lat, @Param("lng") double lng,
			Pageable pageable, @Param("maxKm") int maxKm, @Param("idCandidate") int idCandidate);

	@Query(value = "SELECT  j.id_job FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and j.interview_type != 'affiliate' and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.work_time_english) like lower(CONCAT('%',:WorkTime,'%')) or lower(j.work_time_japanese) like lower(CONCAT('%',:WorkTime,'%')))  GROUP BY   j.id_job ORDER BY  j.interview_type asc, RANDOM() asc, ?#{#pageable}  ", nativeQuery = true, countQuery = "SELECT COUNT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type != 'affiliate' and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.work_time_english) like lower(CONCAT('%',:WorkTime,'%')) or lower(j.work_time_japanese) like lower(CONCAT('%',:WorkTime,'%'))) ")
	public Page<Integer> findNormalJobsByTimeByDistance(@Param("WorkTime") String WorkTime, @Param("lat") double lat,
			@Param("lng") double lng, Pageable pageable, @Param("maxKm") int maxKm,
			@Param("idCandidate") int idCandidate);

	@Query(value = "SELECT  j.id_job FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and j.interview_type != 'affiliate' and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.position_category_english) like lower(CONCAT('%',:workType,'%')) or lower(j.position_category_japanese) like lower(CONCAT('%',:workType,'%')))  GROUP BY   j.id_job ORDER BY  j.interview_type asc, RANDOM() asc, ?#{#pageable} ", nativeQuery = true, countQuery = "SELECT COUNT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type != 'affiliate' and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.position_category_english) like lower(CONCAT('%',:workType,'%')) or lower(j.position_category_japanese) like lower(CONCAT('%',:workType,'%'))) ")
	public Page<Integer> findNormalJobsByTypeByDistance(@Param("workType") String workType, @Param("lat") double lat,
			@Param("lng") double lng, Pageable pageable, @Param("maxKm") int maxKm,
			@Param("idCandidate") int idCandidate);

	@Query(value = "SELECT  j.id_job FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and j.interview_type != 'affiliate' and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.position_category_english) like lower(CONCAT('%',:workType,'%')) or lower(j.position_category_japanese) like lower(CONCAT('%',:workType,'%'))) and (lower(j.work_time_english) like lower(CONCAT('%',:WorkTime,'%')) or lower(j.work_time_japanese) like lower(CONCAT('%',:WorkTime,'%')))  GROUP BY   j.id_job ORDER BY  j.interview_type asc, RANDOM() asc, ?#{#pageable} ", nativeQuery = true, countQuery = "SELECT COUNT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type != 'affiliate' and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.position_category_english) like lower(CONCAT('%',:workType,'%')) or lower(j.position_category_japanese) like lower(CONCAT('%',:workType,'%'))) and (lower(j.work_time_english) like lower(CONCAT('%',:WorkTime,'%')) or lower(j.work_time_japanese) like lower(CONCAT('%',:WorkTime,'%')))   ")
	public Page<Integer> findNormalJobsByAllFieldsByDistance(@Param("workType") String workType,
			@Param("WorkTime") String WorkTime, @Param("lat") double lat, @Param("lng") double lng, Pageable pageable,
			@Param("maxKm") int maxKm, @Param("idCandidate") int idCandidate);

	/******* normal jobs random ********/

	@Query(value = "SELECT  j.id_job FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type != 'affiliate' and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm))   GROUP BY   j.id_job ORDER BY RANDOM() asc, ?#{#pageable}  ", nativeQuery = true, countQuery = "SELECT COUNT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type != 'affiliate' and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) ")
	public Page<Integer> findRandomNormalOpenedJobsByDistance(@Param("lat") double lat, @Param("lng") double lng,
			Pageable pageable, @Param("maxKm") int maxKm, @Param("idCandidate") int idCandidate);

	@Query(value = "SELECT  j.id_job FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type != 'affiliate' and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.work_time_english) like lower(CONCAT('%',:WorkTime,'%')) or lower(j.work_time_japanese) like lower(CONCAT('%',:WorkTime,'%')))  GROUP BY   j.id_job ORDER BY  RANDOM() asc, ?#{#pageable}  ", nativeQuery = true, countQuery = "SELECT COUNT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type != 'affiliate' and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.work_time_english) like lower(CONCAT('%',:WorkTime,'%')) or lower(j.work_time_japanese) like lower(CONCAT('%',:WorkTime,'%'))) ")
	public Page<Integer> findRandomNormalJobsByTimeByDistance(@Param("WorkTime") String WorkTime,
			@Param("lat") double lat, @Param("lng") double lng, Pageable pageable, @Param("maxKm") int maxKm,
			@Param("idCandidate") int idCandidate);

	@Query(value = "SELECT  j.id_job FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type != 'affiliate' and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.position_category_english) like lower(CONCAT('%',:workType,'%')) or lower(j.position_category_japanese) like lower(CONCAT('%',:workType,'%')))  GROUP BY   j.id_job ORDER BY RANDOM() asc, ?#{#pageable} ", nativeQuery = true, countQuery = "SELECT COUNT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type != 'affiliate' and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.position_category_english) like lower(CONCAT('%',:workType,'%')) or lower(j.position_category_japanese) like lower(CONCAT('%',:workType,'%'))) ")
	public Page<Integer> findRandomNormalJobsByTypeByDistance(@Param("workType") String workType,
			@Param("lat") double lat, @Param("lng") double lng, Pageable pageable, @Param("maxKm") int maxKm,
			@Param("idCandidate") int idCandidate);

	@Query(value = "SELECT  j.id_job FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type != 'affiliate' and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.position_category_english) like lower(CONCAT('%',:workType,'%')) or lower(j.position_category_japanese) like lower(CONCAT('%',:workType,'%'))) and (lower(j.work_time_english) like lower(CONCAT('%',:WorkTime,'%')) or lower(j.work_time_japanese) like lower(CONCAT('%',:WorkTime,'%')))  GROUP BY   j.id_job ORDER BY RANDOM() asc, ?#{#pageable} ", nativeQuery = true, countQuery = "SELECT COUNT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type != 'affiliate' and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.position_category_english) like lower(CONCAT('%',:workType,'%')) or lower(j.position_category_japanese) like lower(CONCAT('%',:workType,'%'))) and (lower(j.work_time_english) like lower(CONCAT('%',:WorkTime,'%')) or lower(j.work_time_japanese) like lower(CONCAT('%',:WorkTime,'%')))   ")
	public Page<Integer> findRandomNormalJobsByAllFieldsByDistance(@Param("workType") String workType,
			@Param("WorkTime") String WorkTime, @Param("lat") double lat, @Param("lng") double lng, Pageable pageable,
			@Param("maxKm") int maxKm, @Param("idCandidate") int idCandidate);

	/******* normal checked jobs ********/

	@Query(value = "SELECT  j.id_job FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type != 'affiliate' and j.status = TRUE and j.checked_algorithm = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm))   GROUP BY   j.id_job ORDER BY RANDOM () asc, ?#{#pageable}  ", nativeQuery = true, countQuery = "SELECT COUNT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type != 'affiliate' and j.checked_algorithm = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) ")
	public Page<Integer> findAllCheckedJobsByDistance(@Param("lat") double lat, @Param("lng") double lng,
			Pageable pageable, @Param("maxKm") int maxKm, @Param("idCandidate") int idCandidate);

	@Query(value = "SELECT  j.id_job FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type != 'affiliate' and j.status = TRUE and j.checked_algorithm = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.work_time_english) like lower(CONCAT('%',:WorkTime,'%')) or lower(j.work_time_japanese) like lower(CONCAT('%',:WorkTime,'%')))  GROUP BY   j.id_job ORDER BY RANDOM () asc, ?#{#pageable}  ", nativeQuery = true, countQuery = "SELECT COUNT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type != 'affiliate' and j.checked_algorithm = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.work_time_english) like lower(CONCAT('%',:WorkTime,'%')) or lower(j.work_time_japanese) like lower(CONCAT('%',:WorkTime,'%'))) ")
	public Page<Integer> findCheckedJobsByTimeByDistance(@Param("WorkTime") String WorkTime, @Param("lat") double lat,
			@Param("lng") double lng, Pageable pageable, @Param("maxKm") int maxKm,
			@Param("idCandidate") int idCandidate);

	@Query(value = "SELECT  j.id_job FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type != 'affiliate' and j.status = TRUE and j.checked_algorithm = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.position_category_english) like lower(CONCAT('%',:workType,'%')) or lower(j.position_category_japanese) like lower(CONCAT('%',:workType,'%')))  GROUP BY   j.id_job ORDER BY RANDOM () asc, ?#{#pageable} ", nativeQuery = true, countQuery = "SELECT COUNT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type != 'affiliate' and j.checked_algorithm = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.position_category_english) like lower(CONCAT('%',:workType,'%')) or lower(j.position_category_japanese) like lower(CONCAT('%',:workType,'%'))) ")
	public Page<Integer> findCheckedJobsByTypeByDistance(@Param("workType") String workType, @Param("lat") double lat,
			@Param("lng") double lng, Pageable pageable, @Param("maxKm") int maxKm,
			@Param("idCandidate") int idCandidate);

	@Query(value = "SELECT  j.id_job FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type != 'affiliate' and j.status = TRUE and j.checked_algorithm = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.position_category_english) like lower(CONCAT('%',:workType,'%')) or lower(j.position_category_japanese) like lower(CONCAT('%',:workType,'%'))) and (lower(j.work_time_english) like lower(CONCAT('%',:WorkTime,'%')) or lower(j.work_time_japanese) like lower(CONCAT('%',:WorkTime,'%')))  GROUP BY   j.id_job ORDER BY RANDOM () asc, ?#{#pageable} ", nativeQuery = true, countQuery = "SELECT COUNT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type != 'affiliate' and j.checked_algorithm = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.position_category_english) like lower(CONCAT('%',:workType,'%')) or lower(j.position_category_japanese) like lower(CONCAT('%',:workType,'%'))) and (lower(j.work_time_english) like lower(CONCAT('%',:WorkTime,'%')) or lower(j.work_time_japanese) like lower(CONCAT('%',:WorkTime,'%')))   ")
	public Page<Integer> findCheckedJobsByAllFieldsByDistance(@Param("workType") String workType,
			@Param("WorkTime") String WorkTime, @Param("lat") double lat, @Param("lng") double lng, Pageable pageable,
			@Param("maxKm") int maxKm, @Param("idCandidate") int idCandidate);

	/******* affiliate jobs with type ********/

	@Query(value = "SELECT  j.id_job FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate' and j.jobURL LIKE CONCAT('%',:type,'%') and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm))  GROUP BY   j.id_job ORDER BY RANDOM ()   desc, ?#{#pageable} ", nativeQuery = true, countQuery = "SELECT COUNT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate' and j.jobURL LIKE CONCAT('%',:type,'%') and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) ")
	public Page<Integer> findAllFirstAffiliateOpenedJobsByDistance(@Param("lat") double lat, @Param("lng") double lng,
			@Param("type") String type, Pageable pageable, @Param("maxKm") int maxKm,
			@Param("idCandidate") int idCandidate, @Param("hiddenTypes") List<String> hiddenTypes);

	@Query(value = "SELECT  j.id_job FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate' and j.jobURL LIKE CONCAT('%',:type,'%') and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.work_time_english) like lower(CONCAT('%',:WorkTime,'%')) or lower(j.work_time_japanese) like lower(CONCAT('%',:WorkTime,'%')))  GROUP BY   j.id_job ORDER BY RANDOM ()   desc, ?#{#pageable} ", nativeQuery = true, countQuery = "SELECT COUNT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate' and j.jobURL LIKE CONCAT('%',:type,'%') and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.work_time_english) like lower(CONCAT('%',:WorkTime,'%')) or lower(j.work_time_japanese) like lower(CONCAT('%',:WorkTime,'%'))) ")
	public Page<Integer> findFirstAffiliateJobsByTimeByDistance(@Param("WorkTime") String WorkTime,
			@Param("lat") double lat, @Param("lng") double lng, @Param("type") String type, Pageable pageable,
			@Param("maxKm") int maxKm, @Param("idCandidate") int idCandidate,
			@Param("hiddenTypes") List<String> hiddenTypes);

	@Query(value = "SELECT  j.id_job FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate' and j.jobURL LIKE CONCAT('%',:type,'%') and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.position_category_english) like lower(CONCAT('%',:workType,'%')) or lower(j.position_category_japanese) like lower(CONCAT('%',:workType,'%')))  GROUP BY   j.id_job ORDER BY RANDOM ()   desc, ?#{#pageable} ", nativeQuery = true, countQuery = "SELECT COUNT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate' and j.jobURL LIKE CONCAT('%',:type,'%') and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.position_category_english) like lower(CONCAT('%',:workType,'%')) or lower(j.position_category_japanese) like lower(CONCAT('%',:workType,'%')))  ")
	public Page<Integer> findFirstAffiliateJobsByTypeByDistance(@Param("workType") String workType,
			@Param("lat") double lat, @Param("lng") double lng, @Param("type") String type, Pageable pageable,
			@Param("maxKm") int maxKm, @Param("idCandidate") int idCandidate,
			@Param("hiddenTypes") List<String> hiddenTypes);

	@Query(value = "SELECT  j.id_job FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate' and j.jobURL LIKE CONCAT('%',:type,'%') and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.position_category_english) like lower(CONCAT('%',:workType,'%')) or lower(j.position_category_japanese) like lower(CONCAT('%',:workType,'%'))) and (lower(j.work_time_english) like lower(CONCAT('%',:WorkTime,'%')) or lower(j.work_time_japanese) like lower(CONCAT('%',:WorkTime,'%')))  GROUP BY   j.id_job ORDER BY RANDOM ()   desc, ?#{#pageable} ", nativeQuery = true, countQuery = "SELECT COUNT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate' and j.jobURL LIKE CONCAT('%',:type,'%') and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.position_category_english) like lower(CONCAT('%',:workType,'%')) or lower(j.position_category_japanese) like lower(CONCAT('%',:workType,'%'))) and (lower(j.work_time_english) like lower(CONCAT('%',:WorkTime,'%')) or lower(j.work_time_japanese) like lower(CONCAT('%',:WorkTime,'%')))")
	public Page<Integer> findFirstAffiliateJobsByAllFieldsByDistance(@Param("workType") String workType,
			@Param("WorkTime") String WorkTime, @Param("lat") double lat, @Param("lng") double lng,
			@Param("type") String type, Pageable pageable, @Param("maxKm") int maxKm,
			@Param("idCandidate") int idCandidate, @Param("hiddenTypes") List<String> hiddenTypes);

	/******* affiliate jobs without type ********/

	@Query(value = "SELECT  j.id_job FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate' and j.jobURL NOT LIKE CONCAT('%',:type,'%') and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm))  GROUP BY   j.id_job ORDER BY RANDOM ()   desc, ?#{#pageable} ", nativeQuery = true, countQuery = "SELECT COUNT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate' and j.jobURL LIKE CONCAT('%',:type,'%') and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) ")
	public Page<Integer> findAllRestAffiliateOpenedJobsByDistance(@Param("lat") double lat, @Param("lng") double lng,
			@Param("type") String type, Pageable pageable, @Param("maxKm") int maxKm,
			@Param("idCandidate") int idCandidate, @Param("hiddenTypes") List<String> hiddenTypes);

	@Query(value = "SELECT  j.id_job FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate' and j.jobURL NOT LIKE CONCAT('%',:type,'%') and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.work_time_english) like lower(CONCAT('%',:WorkTime,'%')) or lower(j.work_time_japanese) like lower(CONCAT('%',:WorkTime,'%')))  GROUP BY   j.id_job ORDER BY RANDOM ()   desc, ?#{#pageable} ", nativeQuery = true, countQuery = "SELECT COUNT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate' and j.jobURL NOT LIKE CONCAT('%',:type,'%') and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.work_time_english) like lower(CONCAT('%',:WorkTime,'%')) or lower(j.work_time_japanese) like lower(CONCAT('%',:WorkTime,'%'))) ")
	public Page<Integer> findRestAffiliateJobsByTimeByDistance(@Param("WorkTime") String WorkTime,
			@Param("lat") double lat, @Param("lng") double lng, @Param("type") String type, Pageable pageable,
			@Param("maxKm") int maxKm, @Param("idCandidate") int idCandidate,
			@Param("hiddenTypes") List<String> hiddenTypes);

	@Query(value = "SELECT  j.id_job FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate' and j.jobURL NOT LIKE CONCAT('%',:type,'%') and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.position_category_english) like lower(CONCAT('%',:workType,'%')) or lower(j.position_category_japanese) like lower(CONCAT('%',:workType,'%')))  GROUP BY   j.id_job ORDER BY RANDOM ()   desc, ?#{#pageable} ", nativeQuery = true, countQuery = "SELECT COUNT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate' and j.jobURL NOT LIKE CONCAT('%',:type,'%') and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.position_category_english) like lower(CONCAT('%',:workType,'%')) or lower(j.position_category_japanese) like lower(CONCAT('%',:workType,'%')))  ")
	public Page<Integer> findRestAffiliateJobsByTypeByDistance(@Param("workType") String workType,
			@Param("lat") double lat, @Param("lng") double lng, @Param("type") String type, Pageable pageable,
			@Param("maxKm") int maxKm, @Param("idCandidate") int idCandidate,
			@Param("hiddenTypes") List<String> hiddenTypes);

	@Query(value = "SELECT  j.id_job FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate' and j.jobURL NOT LIKE CONCAT('%',:type,'%') and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.position_category_english) like lower(CONCAT('%',:workType,'%')) or lower(j.position_category_japanese) like lower(CONCAT('%',:workType,'%'))) and (lower(j.work_time_english) like lower(CONCAT('%',:WorkTime,'%')) or lower(j.work_time_japanese) like lower(CONCAT('%',:WorkTime,'%')))  GROUP BY   j.id_job ORDER BY RANDOM ()   desc, ?#{#pageable} ", nativeQuery = true, countQuery = "SELECT COUNT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate' and j.jobURL NOT LIKE CONCAT('%',:type,'%') and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.position_category_english) like lower(CONCAT('%',:workType,'%')) or lower(j.position_category_japanese) like lower(CONCAT('%',:workType,'%'))) and (lower(j.work_time_english) like lower(CONCAT('%',:WorkTime,'%')) or lower(j.work_time_japanese) like lower(CONCAT('%',:WorkTime,'%')))")
	public Page<Integer> findRestAffiliateJobsByAllFieldsByDistance(@Param("workType") String workType,
			@Param("WorkTime") String WorkTime, @Param("lat") double lat, @Param("lng") double lng,
			@Param("type") String type, Pageable pageable, @Param("maxKm") int maxKm,
			@Param("idCandidate") int idCandidate, @Param("hiddenTypes") List<String> hiddenTypes);

	/******* affiliate jobs random ********/

	@Query(value = "SELECT  j.id_job FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate'  and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm))  GROUP BY   j.id_job ORDER BY RANDOM ()   desc, ?#{#pageable} ", nativeQuery = true, countQuery = "SELECT COUNT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate'  and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) ")
	public Page<Integer> findRandomAffiliateOpenedJobsByDistance(@Param("lat") double lat, @Param("lng") double lng,
			Pageable pageable, @Param("maxKm") int maxKm, @Param("idCandidate") int idCandidate,
			@Param("hiddenTypes") List<String> hiddenTypes);

	@Query(value = "SELECT  j.id_job FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate'  and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.work_time_english) like lower(CONCAT('%',:WorkTime,'%')) or lower(j.work_time_japanese) like lower(CONCAT('%',:WorkTime,'%')))  GROUP BY   j.id_job ORDER BY RANDOM ()   desc, ?#{#pageable} ", nativeQuery = true, countQuery = "SELECT COUNT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate'  and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.work_time_english) like lower(CONCAT('%',:WorkTime,'%')) or lower(j.work_time_japanese) like lower(CONCAT('%',:WorkTime,'%'))) ")
	public Page<Integer> findRandomAffiliateJobsByTimeByDistance(@Param("WorkTime") String WorkTime,
			@Param("lat") double lat, @Param("lng") double lng, Pageable pageable, @Param("maxKm") int maxKm,
			@Param("idCandidate") int idCandidate, @Param("hiddenTypes") List<String> hiddenTypes);

	@Query(value = "SELECT  j.id_job FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate'  and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.position_category_english) like lower(CONCAT('%',:workType,'%')) or lower(j.position_category_japanese) like lower(CONCAT('%',:workType,'%')))  GROUP BY   j.id_job ORDER BY RANDOM ()   desc, ?#{#pageable} ", nativeQuery = true, countQuery = "SELECT COUNT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate'  and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.position_category_english) like lower(CONCAT('%',:workType,'%')) or lower(j.position_category_japanese) like lower(CONCAT('%',:workType,'%')))  ")
	public Page<Integer> findRandomAffiliateJobsByTypeByDistance(@Param("workType") String workType,
			@Param("lat") double lat, @Param("lng") double lng, Pageable pageable, @Param("maxKm") int maxKm,
			@Param("idCandidate") int idCandidate, @Param("hiddenTypes") List<String> hiddenTypes);

	@Query(value = "SELECT  j.id_job FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate'  and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.position_category_english) like lower(CONCAT('%',:workType,'%')) or lower(j.position_category_japanese) like lower(CONCAT('%',:workType,'%'))) and (lower(j.work_time_english) like lower(CONCAT('%',:WorkTime,'%')) or lower(j.work_time_japanese) like lower(CONCAT('%',:WorkTime,'%')))  GROUP BY   j.id_job ORDER BY RANDOM ()   desc, ?#{#pageable} ", nativeQuery = true, countQuery = "SELECT COUNT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate'  and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.position_category_english) like lower(CONCAT('%',:workType,'%')) or lower(j.position_category_japanese) like lower(CONCAT('%',:workType,'%'))) and (lower(j.work_time_english) like lower(CONCAT('%',:WorkTime,'%')) or lower(j.work_time_japanese) like lower(CONCAT('%',:WorkTime,'%')))")
	public Page<Integer> findRandomAffiliateJobsByAllFieldsByDistance(@Param("workType") String workType,
			@Param("WorkTime") String WorkTime, @Param("lat") double lat, @Param("lng") double lng, Pageable pageable,
			@Param("maxKm") int maxKm, @Param("idCandidate") int idCandidate,
			@Param("hiddenTypes") List<String> hiddenTypes);

	/******* affiliate jobs lowest wage first ********/

	@Query(value = "SELECT  j.id_job FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate' and j.joburl LIKE CONCAT('%',:type,'%') and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm))  ORDER BY j.hourly_wage asc, ?#{#pageable} ", nativeQuery = true, countQuery = "SELECT COUNT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate' and j.joburl LIKE CONCAT('%',:type,'%') and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) ")
	public Page<Integer> findLowestWageAffiliateJobsByDistance(@Param("lat") double lat, @Param("lng") double lng,
			@Param("type") String type, Pageable pageable, @Param("maxKm") int maxKm,
			@Param("idCandidate") int idCandidate, @Param("hiddenTypes") List<String> hiddenTypes);

	@Query(value = "SELECT  j.id_job FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate' and j.joburl LIKE CONCAT('%',:type,'%') and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.work_time_english) like lower(CONCAT('%',:WorkTime,'%')) or lower(j.work_time_japanese) like lower(CONCAT('%',:WorkTime,'%')))   ORDER BY j.hourly_wage asc, ?#{#pageable} ", nativeQuery = true, countQuery = "SELECT COUNT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate' and j.joburl LIKE CONCAT('%',:type,'%') and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.work_time_english) like lower(CONCAT('%',:WorkTime,'%')) or lower(j.work_time_japanese) like lower(CONCAT('%',:WorkTime,'%'))) ")
	public Page<Integer> findLowestWageAffiliateJobsByTimeByDistance(@Param("WorkTime") String WorkTime,
			@Param("lat") double lat, @Param("lng") double lng, @Param("type") String type, Pageable pageable,
			@Param("maxKm") int maxKm, @Param("idCandidate") int idCandidate,
			@Param("hiddenTypes") List<String> hiddenTypes);

	@Query(value = "SELECT  j.id_job FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate' and j.joburl LIKE CONCAT('%',:type,'%') and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.position_category_english) like lower(CONCAT('%',:workType,'%')) or lower(j.position_category_japanese) like lower(CONCAT('%',:workType,'%')))  ORDER BY j.hourly_wage asc, ?#{#pageable} ", nativeQuery = true, countQuery = "SELECT COUNT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate' and j.joburl LIKE CONCAT('%',:type,'%') and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.position_category_english) like lower(CONCAT('%',:workType,'%')) or lower(j.position_category_japanese) like lower(CONCAT('%',:workType,'%')))  ")
	public Page<Integer> findLowestWageAffiliateJobsByTypeByDistance(@Param("workType") String workType,
			@Param("lat") double lat, @Param("lng") double lng, @Param("type") String type, Pageable pageable,
			@Param("maxKm") int maxKm, @Param("idCandidate") int idCandidate,
			@Param("hiddenTypes") List<String> hiddenTypes);

	@Query(value = "SELECT  j.id_job FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate' and j.joburl LIKE CONCAT('%',:type,'%') and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.position_category_english) like lower(CONCAT('%',:workType,'%')) or lower(j.position_category_japanese) like lower(CONCAT('%',:workType,'%'))) and (lower(j.work_time_english) like lower(CONCAT('%',:WorkTime,'%')) or lower(j.work_time_japanese) like lower(CONCAT('%',:WorkTime,'%')))  ORDER BY j.hourly_wage asc, ?#{#pageable} ", nativeQuery = true, countQuery = "SELECT COUNT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate' and j.joburl LIKE CONCAT('%',:type,'%') and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.position_category_english) like lower(CONCAT('%',:workType,'%')) or lower(j.position_category_japanese) like lower(CONCAT('%',:workType,'%'))) and (lower(j.work_time_english) like lower(CONCAT('%',:WorkTime,'%')) or lower(j.work_time_japanese) like lower(CONCAT('%',:WorkTime,'%')))")
	public Page<Integer> findLowestWageAffiliateJobsByAllFieldsByDistance(@Param("workType") String workType,
			@Param("WorkTime") String WorkTime, @Param("lat") double lat, @Param("lng") double lng,
			@Param("type") String type, Pageable pageable, @Param("maxKm") int maxKm,
			@Param("idCandidate") int idCandidate, @Param("hiddenTypes") List<String> hiddenTypes);

	/******* affiliate jobs lowest wage first not type ********/

	@Query(value = "SELECT  j.id_job FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate' and j.joburl NOT LIKE CONCAT('%',:type,'%') and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm))  ORDER BY j.hourly_wage asc, ?#{#pageable} ", nativeQuery = true, countQuery = "SELECT COUNT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate' and j.joburl NOT LIKE CONCAT('%',:type,'%') and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) ")
	public Page<Integer> findRestLowestWageAffiliateJobsByDistance(@Param("lat") double lat, @Param("lng") double lng,
			@Param("type") String type, Pageable pageable, @Param("maxKm") int maxKm,
			@Param("idCandidate") int idCandidate, @Param("hiddenTypes") List<String> hiddenTypes);

	@Query(value = "SELECT  j.id_job FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate' and j.joburl NOT LIKE CONCAT('%',:type,'%') and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.work_time_english) like lower(CONCAT('%',:WorkTime,'%')) or lower(j.work_time_japanese) like lower(CONCAT('%',:WorkTime,'%')))   ORDER BY j.hourly_wage asc, ?#{#pageable} ", nativeQuery = true, countQuery = "SELECT COUNT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate' and j.joburl NOT LIKE CONCAT('%',:type,'%') and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.work_time_english) like lower(CONCAT('%',:WorkTime,'%')) or lower(j.work_time_japanese) like lower(CONCAT('%',:WorkTime,'%'))) ")
	public Page<Integer> findRestLowestWageAffiliateJobsByTimeByDistance(@Param("WorkTime") String WorkTime,
			@Param("lat") double lat, @Param("lng") double lng, @Param("type") String type, Pageable pageable,
			@Param("maxKm") int maxKm, @Param("idCandidate") int idCandidate,
			@Param("hiddenTypes") List<String> hiddenTypes);

	@Query(value = "SELECT  j.id_job FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate' and j.joburl NOT LIKE CONCAT('%',:type,'%') and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.position_category_english) like lower(CONCAT('%',:workType,'%')) or lower(j.position_category_japanese) like lower(CONCAT('%',:workType,'%')))  ORDER BY j.hourly_wage asc, ?#{#pageable} ", nativeQuery = true, countQuery = "SELECT COUNT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate' and j.joburl NOT LIKE CONCAT('%',:type,'%') and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.position_category_english) like lower(CONCAT('%',:workType,'%')) or lower(j.position_category_japanese) like lower(CONCAT('%',:workType,'%')))  ")
	public Page<Integer> findRestLowestWageAffiliateJobsByTypeByDistance(@Param("workType") String workType,
			@Param("lat") double lat, @Param("lng") double lng, @Param("type") String type, Pageable pageable,
			@Param("maxKm") int maxKm, @Param("idCandidate") int idCandidate,
			@Param("hiddenTypes") List<String> hiddenTypes);

	@Query(value = "SELECT  j.id_job FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate' and j.joburl NOT LIKE CONCAT('%',:type,'%') and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.position_category_english) like lower(CONCAT('%',:workType,'%')) or lower(j.position_category_japanese) like lower(CONCAT('%',:workType,'%'))) and (lower(j.work_time_english) like lower(CONCAT('%',:WorkTime,'%')) or lower(j.work_time_japanese) like lower(CONCAT('%',:WorkTime,'%')))  ORDER BY j.hourly_wage asc, ?#{#pageable} ", nativeQuery = true, countQuery = "SELECT COUNT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  j.interview_type = 'affiliate' and j.joburl NOT LIKE CONCAT('%',:type,'%') and (j.affiliate_type NOT IN :hiddenTypes) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.position_category_english) like lower(CONCAT('%',:workType,'%')) or lower(j.position_category_japanese) like lower(CONCAT('%',:workType,'%'))) and (lower(j.work_time_english) like lower(CONCAT('%',:WorkTime,'%')) or lower(j.work_time_japanese) like lower(CONCAT('%',:WorkTime,'%')))")
	public Page<Integer> findRestLowestWageAffiliateJobsByAllFieldsByDistance(@Param("workType") String workType,
			@Param("WorkTime") String WorkTime, @Param("lat") double lat, @Param("lng") double lng,
			@Param("type") String type, Pageable pageable, @Param("maxKm") int maxKm,
			@Param("idCandidate") int idCandidate, @Param("hiddenTypes") List<String> hiddenTypes);

	/*********** sukiya jobs **************/

	@Query(value = "SELECT j.id_job FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  (s.name_shop LIKE CONCAT('%','すき家','%') or s.name_shop LIKE CONCAT('%','すきや','%') or s.name_shop LIKE CONCAT('%','Sukiya','%') ) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=5)  ORDER BY  (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371) asc, ?#{#pageable}  ", nativeQuery = true, countQuery = "SELECT COUNT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  (s.name_shop LIKE CONCAT('%','すき家','%') or s.name_shop LIKE CONCAT('%','すきや','%') or s.name_shop LIKE CONCAT('%','Sukiya','%') ) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=5) ")
	public Page<Integer> findAllSukiyaOpenedJobsByDistance(@Param("lat") double lat, @Param("lng") double lng,
			Pageable pageable, @Param("idCandidate") int idCandidate);

	@Query(value = "SELECT j.id_job FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  (j.shop.name_shop LIKE CONCAT('%','すき家','%') or j.shop.name_shop LIKE CONCAT('%','すきや','%') or j.shop.name_shop LIKE CONCAT('%','Sukiya','%') ) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=10) and (lower(j.work_time_english) like lower(CONCAT('%',:WorkTime,'%')) or lower(j.work_time_japanese) like lower(CONCAT('%',:WorkTime,'%')))  GROUP BY   j.id_job ORDER BY   j.id_job asc, RANDOM() asc, ?#{#pageable}  ", nativeQuery = true, countQuery = "SELECT COUNT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  (j.shop.name_shop LIKE CONCAT('%','すき家','%') or j.shop.name_shop LIKE CONCAT('%','すきや','%') or j.shop.name_shop LIKE CONCAT('%','Sukiya','%') ) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=10) and (lower(j.work_time_english) like lower(CONCAT('%',:WorkTime,'%')) or lower(j.work_time_japanese) like lower(CONCAT('%',:WorkTime,'%'))) ")
	public Page<Integer> findAllSukiyaOpenedJobsByDistanceAndTime(@Param("WorkTime") String WorkTime,
			@Param("lat") double lat, @Param("lng") double lng, Pageable pageable,
			@Param("idCandidate") int idCandidate);

	@Query(value = "SELECT j.id_job FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  (j.shop.name_shop LIKE CONCAT('%','すき家','%') or j.shop.name_shop LIKE CONCAT('%','すきや','%') or j.shop.name_shop LIKE CONCAT('%','Sukiya','%') ) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=10) and (lower(j.position_category_english) like lower(CONCAT('%',:workType,'%')) or lower(j.position_category_japanese) like lower(CONCAT('%',:workType,'%')))  GROUP BY   j.id_job ORDER BY  j.id_job asc, RANDOM() asc, ?#{#pageable} ", nativeQuery = true, countQuery = "SELECT COUNT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  (j.shop.name_shop LIKE CONCAT('%','すき家','%') or j.shop.name_shop LIKE CONCAT('%','すきや','%') or j.shop.name_shop LIKE CONCAT('%','Sukiya','%') ) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=10) and (lower(j.position_category_english) like lower(CONCAT('%',:workType,'%')) or lower(j.position_category_japanese) like lower(CONCAT('%',:workType,'%'))) ")
	public Page<Integer> findAllSukiyaOpenedJobsByDistanceAndType(@Param("workType") String workType,
			@Param("lat") double lat, @Param("lng") double lng, Pageable pageable,
			@Param("idCandidate") int idCandidate);

	@Query(value = "SELECT j.id_job FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  (j.shop.name_shop LIKE CONCAT('%','すき家','%') or j.shop.name_shop LIKE CONCAT('%','すきや','%') or j.shop.name_shop LIKE CONCAT('%','Sukiya','%') ) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=10) and (lower(j.position_category_english) like lower(CONCAT('%',:workType,'%')) or lower(j.position_category_japanese) like lower(CONCAT('%',:workType,'%'))) and (lower(j.work_time_english) like lower(CONCAT('%',:WorkTime,'%')) or lower(j.work_time_japanese) like lower(CONCAT('%',:WorkTime,'%')))  GROUP BY   j.id_job ORDER BY  j.id_job asc, RANDOM() asc, ?#{#pageable} ", nativeQuery = true, countQuery = "SELECT COUNT(j.id_job) FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc WHERE jc.id_candidate = :idCandidate) and  (j.shop.name_shop LIKE CONCAT('%','すき家','%') or j.shop.name_shop LIKE CONCAT('%','すきや','%') or j.shop.name_shop LIKE CONCAT('%','Sukiya','%') ) and j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=10) and (lower(j.position_category_english) like lower(CONCAT('%',:workType,'%')) or lower(j.position_category_japanese) like lower(CONCAT('%',:workType,'%'))) and (lower(j.work_time_english) like lower(CONCAT('%',:WorkTime,'%')) or lower(j.work_time_japanese) like lower(CONCAT('%',:WorkTime,'%')))   ")
	public Page<Integer> findAllSukiyaOpenedJobsByDistanceAndTypeAndTime(@Param("workType") String workType,
			@Param("WorkTime") String WorkTime, @Param("lat") double lat, @Param("lng") double lng, Pageable pageable,
			@Param("idCandidate") int idCandidate);

	/*********** Close/ delete jobs **************/

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Awatef Houaoui
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobRepository.java
	 * 
	 *         DELETE all unused jobs
	 */
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM job j WHERE (j.interview_type = 'affiliate' and j.status = FALSE and j.id_job NOT IN (SELECT jc.id_job FROM job_candidate_relation jc) and j.id_job NOT IN (SELECT bi.id_job FROM bot_information_search_log bi))", nativeQuery = true)
	public void deleteAllUnusedJobs();

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Awatef Houaoui
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobRepository.java
	 * 
	 *         Set the status of the given jobs type FALSE
	 * @param jobType
	 *            the job type
	 */
	@Transactional
	@Modifying
	@Query(value = "UPDATE Job SET status = FALSE WHERE interview_type = 'affiliate' and affiliate_type =:jobType", nativeQuery = true)
	public void closeJobsByType(@Param("jobType") String jobType);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Awatef Houaoui
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobRepository.java
	 * 
	 *         Get list of all types of affiliate jobs
	 * @return list of job types
	 */
	@Query(value = "SELECT DISTINCT affiliate_type FROM Job WHERE interview_type = 'affiliate'", nativeQuery = true)
	public List<String> getAllTypesOfAffiliateJobs();

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Awatef Houaoui
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobRepository.java
	 * 
	 *         Get list of all affiliate jobs
	 * @return list of job
	 */
	@Query(value = "SELECT j FROM Job j WHERE (j.interviewType = 'affiliate' AND j.affiliateType =:type AND j.prefecture =:area)")
	public List<Job> getAllAffiliateJobs(@Param("type") String type, @Param("area") String area);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Awatef Houaouiaffiliate_type
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobRepository.java
	 * 
	 *         Get list of all Normal jobs
	 * @return list of job
	 */
	@Query(value = "SELECT j FROM Job j WHERE (j.interviewType != 'affiliate' AND j.shop.company.nameCompany =:name)")
	public List<Job> getAllNormalJobs(@Param("name") String name);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Awatef Houaoui
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobRepository.java
	 * 
	 *         Get list of all Areas of affiliate jobs
	 * @return list of job Areas
	 */
	@Query(value = "SELECT DISTINCT prefecture FROM Job WHERE interview_type = 'affiliate'", nativeQuery = true)
	public List<String> getAllAreasOfAffiliateJobs();

	/*********** Method for Otome Bot API **************/

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Awatef Houaoui
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: JobRepository.java
	 * 
	 *         Get Jobs By Station And Job Category
	 * @return list of jobs
	 */
	@Query(value = "SELECT j.* FROM Job j INNER JOIN Shop s ON j.id_shop = s.id_shop WHERE j.status = TRUE and (acos(sin(RADIANS(:lat)) * sin(RADIANS(s.latitude)) + cos(RADIANS(:lat)) * cos(RADIANS(s.latitude)) * cos(RADIANS(s.longitude) - (RADIANS(:lng)))) * 6371 <=(:maxKm)) and (lower(j.position_category_english) like lower(CONCAT('%',:positionCategory,'%')) or lower(j.position_category_japanese) like lower(CONCAT('%',:positionCategory,'%'))) GROUP BY j.id_job, ?#{#pageable}", nativeQuery = true)
	public Page<Job> getJobsByStationAndJobCategory(@Param("positionCategory") String positionCategory,
			@Param("lat") double lat, @Param("lng") double lng, @Param("maxKm") int maxKm, Pageable pageable);
	
	@Query(value = "SELECT j FROM Job j where (lower(j.interviewType) like lower('affiliate')) and j.status = TRUE and j.idJobDetail =:idJobDetail and j.jobURL LIKE CONCAT('%','j-sen','%')")
    public List<Job> getCheckedJsenJobsByIdJobDetail(@Param("idJobDetail") String idJobDetail);
	
	/**
     * Lacotto jobs
     *
     * @param idJobDetail
     * @return
     */
    @Query(value = "SELECT j FROM Job j where (lower(j.interviewType) like lower('affiliate')) and j.status = TRUE and j.idJobDetail =:idJobDetail and j.jobURL LIKE CONCAT('%','lacotto','%')")
    public List<Job> getCheckedLacottoJobsByIdJobDetail(@Param("idJobDetail") String idJobDetail);

}
