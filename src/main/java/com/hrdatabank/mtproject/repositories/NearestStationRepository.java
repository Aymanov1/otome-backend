package com.hrdatabank.mtproject.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.hrdatabank.mtproject.entities.NearestStation;
import com.hrdatabank.mtproject.model.NearestStationDto;

/**
 * The Interface NearestStationRepository.
 */
@Repository
@RepositoryRestResource
public interface NearestStationRepository
		extends JpaRepository<NearestStation, Serializable>, JpaSpecificationExecutor<NearestStation> {

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: NearestStationRepository.java
	 * 
	 *         Find nearest station by station.
	 * @param station
	 *            the station
	 * @param pageable
	 *            the pageable
	 * @return the page
	 */
	@Query("SELECT ns FROM NearestStation ns where lower(ns.japaneseRomajiStation) like lower(CONCAT('%',:station,'%')) or lower(ns.japaneseHiraganaStation) like lower(CONCAT('%',:station,'%')) or lower(ns.japaneseKatakanaStation) like lower(CONCAT('%',:station,'%'))  or lower(ns.japaneseStation) like lower(CONCAT('%',:station,'%'))")
	public Page<NearestStation> findNearestStationByStation(@Param("station") String station, Pageable pageable);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: NearestStationRepository.java
	 * 
	 *         Gets the near station by id line CD.
	 * @param idNearestStationCD
	 *            the id nearest station CD
	 * @return the near station by id line CD
	 */
	@Query(value = "select ns from NearestStation ns where ns.idNearestStationCD=:idNearestStationCD")
	public NearestStation getNearStationByIdLineCD(@Param("idNearestStationCD") int idNearestStationCD);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: NearestStationRepository.java
	 * 
	 *         Find near station by id.
	 * @param id
	 *            the id
	 * @return the nearest station
	 */
	@Query("SELECT a FROM NearestStation a where a.idNearestStation = :id")
	public NearestStation findNearStationById(@Param("id") int id);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: NearestStationRepository.java
	 * 
	 *         Find station by name and line.
	 * @param station
	 *            the station
	 * @param line
	 *            the line
	 * @return the nearest station
	 */
	@Query("SELECT ns FROM NearestStation ns where (lower(ns.japaneseRomajiStation) like lower(:station) or lower(ns.japaneseHiraganaStation) like lower(:station) or lower(ns.japaneseKatakanaStation) like lower(:station)  or lower(ns.japaneseStation) like lower(:station)) and (lower(ns.lineStation.lineNameJapanese) like lower(:line) or lower(ns.lineStation.lineNameKatakana) like lower(:line))")
	public NearestStation findStationByNameAndLine(@Param("station") String station, @Param("line") String line);

	@Query("SELECT ns FROM NearestStation ns where ns.lineStation.idLineStation=:idLineStation  ")
	public List<NearestStation> findStationByLineID(@Param("idLineStation") int idLineStation);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: NearestStationRepository.java
	 * 
	 *         Find near station by id nearest station CD.
	 * @param id
	 *            the id
	 * @return the nearest station
	 */
	@Query(value = "SELECT n FROM NearestStation n where ( n.idNearestStation IN :listIDStation  or  :listIDStation IS null  ) ORDER BY  n.idNearestStation ASC ", countQuery = "SELECT COUNT(n) FROM NearestStation n where ( n.idNearestStation IN :listIDStation  or  :listIDStation IS null  ) ")
	public Page<NearestStation> getPageNearestStation(Pageable pageable,
			@Param("listIDStation") List<Integer> listIDStation);

	@Query(value = "SELECT n FROM NearestStation n where ( n.idNearestStation IN :listIDStation  or  :listIDStation IS null  ) ORDER BY  n.idNearestStation ASC ", countQuery = "SELECT COUNT(n) FROM NearestStation n where ( n.idNearestStation IN :listIDStation  or  :listIDStation IS null  ) ")
	public List<NearestStation> getAllNearestStation(@Param("listIDStation") List<Integer> listIDStation);

	@Query("SELECT a FROM NearestStation a where a.idNearestStationCD = :id")
	public NearestStation findNearStationByIdNearestStationCD(@Param("id") int id);

	@Query(value = "SELECT n.* from nearest_station n where lower(n.japanese_station) like lower(CONCAT('%',:station,'%')) or abs(cast( GREATEST(length(:station),length(n.japanese_station)) -levenshtein( lower(:station),lower(n.japanese_station)) as float))/GREATEST(length(:station),length(n.japanese_station))*100 >40 or lower(n.japanese_hiragana_station) like lower(CONCAT('%',:station,'%'))   or abs(cast( GREATEST(length(:station), length(n.japanese_hiragana_station))- levenshtein(lower(:station),n.japanese_hiragana_station)as float))/GREATEST(length(:station),length(n.japanese_hiragana_station))*100>40 or lower(n.japanese_katakana_station) like lower(CONCAT('%',:station,'%') ) or   abs(cast( GREATEST(length(:station),length(n.japanese_katakana_station))-levenshtein(lower(:station),lower(n.japanese_katakana_station))as float))/GREATEST(length(:station),length(n.japanese_katakana_station))*100>40 or lower(n.japanese_romaji_station) like lower(CONCAT('%',:station,'%') ) or  abs(cast(GREATEST(length(:station), length(n.japanese_romaji_station))-levenshtein( lower(:station),n.japanese_romaji_station) as  float))/GREATEST(length(:station),length(n.japanese_romaji_station)) *100>40 GROUP BY   n.id_nearest_station ORDER BY GREATEST(abs(cast(GREATEST(length(:station), length(n.japanese_romaji_station))-levenshtein( lower(:station),n.japanese_romaji_station) as  float))/GREATEST(length(:station),length(n.japanese_romaji_station)) *100,abs(cast( GREATEST(length(:station), length(n.japanese_hiragana_station))- levenshtein(lower(:station),n.japanese_hiragana_station)as float))/GREATEST(length(:station),length(n.japanese_hiragana_station))*100,abs(cast( GREATEST(length(:station),length(n.japanese_station)) -levenshtein( lower(:station),lower(n.japanese_station)) as float))/GREATEST(length(:station),length(n.japanese_station))*100,abs(cast( GREATEST(length(:station),length(n.japanese_katakana_station))-levenshtein(lower(:station),lower(n.japanese_katakana_station))as float))/GREATEST(length(:station),length(n.japanese_katakana_station))*100) desc ,    ?#{#pageable} ", nativeQuery = true, countQuery = "SELECT count(n.*) from  nearest_station n  where lower(n.japanese_station) like lower(CONCAT('%',:station,'%')) or abs(cast( GREATEST(length(:station),length(n.japanese_station)) -levenshtein( lower(:station),lower(n.japanese_station)) as float))/GREATEST(length(:station),length(n.japanese_station))*100 >40 or lower(n.japanese_hiragana_station) like lower(CONCAT('%',:station,'%'))   or abs(cast( GREATEST(length(:station), length(n.japanese_hiragana_station))- levenshtein(lower(:station),n.japanese_hiragana_station)as float))/GREATEST(length(:station),length(n.japanese_station))*100>40 or lower(n.japanese_katakana_station) like lower(CONCAT('%',:station,'%') ) or   abs(cast( GREATEST(length(:station),length(n.japanese_katakana_station))-levenshtein(lower(:station),lower(n.japanese_katakana_station))as float))/GREATEST(length(:station),length(n.japanese_station))*100>40 or lower(n.japanese_romaji_station) like lower(CONCAT('%',:station,'%') ) or  abs(cast(GREATEST(length(:station), length(n.japanese_romaji_station))-levenshtein( lower(:station),n.japanese_romaji_station) as  float))/GREATEST(length(:station),length(n.japanese_station)) *100>40 GROUP BY   n.id_nearest_station ORDER BY GREATEST(abs(cast(GREATEST(length(:station), length(n.japanese_romaji_station))-levenshtein( lower(:station),n.japanese_romaji_station) as  float))/GREATEST(length(:station),length(n.japanese_station)) *100,abs(cast( GREATEST(length(:station), length(n.japanese_hiragana_station))- levenshtein(lower(:station),n.japanese_hiragana_station)as float))/GREATEST(length(:station),length(n.japanese_station))*100,abs(cast( GREATEST(length(:station),length(n.japanese_station)) -levenshtein( lower(:station),lower(n.japanese_station)) as float))/GREATEST(length(:station),length(n.japanese_station))*100,abs(cast( GREATEST(length(:station),length(n.japanese_katakana_station))-levenshtein(lower(:station),lower(n.japanese_katakana_station))as float))/GREATEST(length(:station),length(n.japanese_station))*100) desc ,  ?#{#pageable}  ")
	public Page<NearestStation> findNearestStationByStationLevenshtein(@Param("station") String station,
			Pageable pageable);

	@Query("SELECT n FROM NearestStation n where n.latitudeStation = :latitude and n.longitudeStation = :longitude")
	public NearestStation getNearestStationByLatitudeAndLongitude(@Param("latitude") Double latitude,
			@Param("longitude") Double longitude);

	/************** Query for group message, stations list *************/
	@Query("SELECT NEW com.hrdatabank.mtproject.model.NearestStationDto(n.idNearestStation, COUNT(r.nearestStationBotInformationRelationPK.idNearestStation), COUNT(DISTINCT r.nearestStationBotInformationRelationPK.idBotInformation), n.addressStation,"
			+ "n.lineStation.lineNameJapanese , n.japaneseStation, n.japaneseRomajiStation) "
			+ "FROM NearestStationBotInformationRelation r RIGHT JOIN r.nearestStation n "
			+ "where (n.idNearestStation IN :listIDStation or :listIDStation IS null) "
			+ "and (to_timestamp(to_char(r.nearestStationBotInformationRelationPK.searchDate, 'yyyy-MM-dd'), 'yyyy-MM-dd')   >= to_timestamp(:dateFrom , 'yyyy-MM-dd') )"
			+ "and (to_timestamp(to_char(r.nearestStationBotInformationRelationPK.searchDate, 'yyyy-MM-dd'), 'yyyy-MM-dd')  <=  to_timestamp(:dateTo , 'yyyy-MM-dd')  )"
			+ "and ((lower(n.japaneseStation) like lower(CONCAT('%',:keyword,'%')) and length(n.japaneseStation) >= length(:keyword)) "
			+ "or (lower(n.japaneseKatakanaStation) like lower(CONCAT('%',:keyword,'%')) and length(n.japaneseKatakanaStation) >= length(:keyword)) "
			+ "or (lower(n.japaneseHiraganaStation) like lower(CONCAT('%',:keyword,'%')) and length(n.japaneseHiraganaStation) >= length(:keyword)) "
			+ "or (lower(n.japaneseRomajiStation) like lower(CONCAT('%',:keyword,'%')) and length(n.japaneseRomajiStation) >= length(:keyword)) "
			+ "or (lower(n.lineStation.lineNameJapanese) like lower(CONCAT('%',:keyword,'%')) and length(n.lineStation.lineNameJapanese) >= length(:keyword)) "
			+ "or (lower(n.lineStation.lineNameKatakana) like lower(CONCAT('%',:keyword,'%')) and length(n.lineStation.lineNameKatakana) >= length(:keyword))) "
			+ "GROUP BY n.idNearestStation,n.lineStation.lineNameJapanese  ORDER BY COUNT(r.nearestStationBotInformationRelationPK.idNearestStation) DESC")
	public Page<NearestStationDto> getPageNearestStationForGroupMessage(Pageable pageable,
			@Param("listIDStation") List<Integer> listIDStation, @Param("keyword") String keyword,
			@Param("dateFrom") String dateFrom, @Param("dateTo") String dateTo);

	@Query(value = "SELECT COUNT(n.idNearestStation) FROM NearestStationBotInformationRelation r LEFT JOIN r.nearestStation n GROUP BY n.idNearestStation, n.lineStation.lineNameJapanese")
	public long testGroupMessageStation();

	@Query(value = "SELECT COUNT(DISTINCT r.nearestStationBotInformationRelationPK.idBotInformation) FROM NearestStationBotInformationRelation r where (r.nearestStationBotInformationRelationPK.idNearestStation IN :idStations)")
	public long getCandidateNumberForGroupMessage(@Param("idStations") List<Integer> idStations);

}
