package com.hrdatabank.mtproject.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.hrdatabank.mtproject.entities.BotInformation;

// TODO: Auto-generated Javadoc
/**
 * The Interface BotInformationRepository.
 */
@Repository
@RepositoryRestResource
public interface BotInformationRepository extends JpaRepository<BotInformation, Serializable> {

	/**
	 * ********** ignore list for Line ******************.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationRepository.java
	 * 
	 * Gets the list 1 bot information.
	 * @return the list 1 bot information
	 */

	@Query(value = "SELECT b.* FROM bot_information b INNER JOIN user_information c ON (b.id_bot_information = c.id_bot_information) WHERE "
			+ "c.candidatefb = FALSE and c.guest=FALSE and ((b.status =1 and "
			+ "(to_timestamp(to_char(b.ask_for_language_date , 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))) "
			+ "or (b.status=2 and "
			+ "(to_timestamp(to_char(b.ask_for_station_date , 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))))", nativeQuery = true)
	public List<BotInformation> getList1BotInformation();

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationRepository.java
	 * 
	 * Gets the list 5 bot information.
	 * @return the list 5 bot information
	 */
	@Query(value = "SELECT b.* FROM bot_information b INNER JOIN user_information c ON (b.id_bot_information = c.id_bot_information) WHERE "
			+ "c.candidatefb = FALSE and c.guest=FALSE and (b.status =7 and "
			+ " (to_timestamp(to_char(b.ask_how_was_it_date , 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24')) or"
			+ " (b.status=26 and "
			+ "(to_timestamp(to_char(b.ask_for_applying_other_jobs_date , 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))))", nativeQuery = true)
	public List<BotInformation> getList5BotInformation();

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationRepository.java
	 * 
	 * Gets the list 6 bot information.
	 * @return the list 6 bot information
	 */
	@Query(value = "SELECT b.* FROM bot_information b INNER JOIN user_information c ON (b.id_bot_information = c.id_bot_information) WHERE "
			+ "(c.candidatefb = FALSE) and c.guest=FALSE and ((b.status=19 and "
			+ "(to_timestamp(to_char(b.ask_candidate_how_was_interview_date , 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))) or "
			+ "(b.status=29 and "
			+ "(to_timestamp(to_char(b.how_was_the_work_date , 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))) or "
			+ "(b.status=28 and "
			+ "(to_timestamp(to_char(b.ask_for_when_start_working , 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))) or "
			+ "(b.status=24 and "
			+ "(to_timestamp(to_char(b.ask_for_result_date_candidate , 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))) or "
			+ "(b.status=22 and "
			+ "(to_timestamp(to_char(b.ask_for_when_is_the_result_date , 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))) or "
			+ "(b.status=14 and "
			+ "(to_timestamp(to_char(b.ask_for_set_interview , 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))) or "
			+ "(b.status=15 and "
			+ "(to_timestamp(to_char(b.ask_for_when_interview_date , 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))))", nativeQuery = true)
	public List<BotInformation> getList6BotInformation();

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationRepository.java
	 * 
	 * Gets the list 7 bot information.
	 * @return the list 7 bot information
	 */
	@Query(value = "SELECT b.* FROM bot_information b INNER JOIN user_information c ON (b.id_bot_information = c.id_bot_information) WHERE"
			+ " c.candidatefb = FALSE and c.guest=FALSE and b.status=31 and "
			+ "(to_timestamp(to_char(b.ask_for_not_fixing_date , 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))", nativeQuery = true)
	public List<BotInformation> getList7BotInformation();

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationRepository.java
	 * 
	 * Gets the list 8 bot information.
	 * @return the list 8 bot information
	 */
	@Query(value = "SELECT b.* FROM bot_information b INNER JOIN user_information c ON (b.id_bot_information = c.id_bot_information) WHERE "
			+ "c.candidatefb = FALSE and c.guest=FALSE and b.status=27 and"
			+ " (to_timestamp(to_char(b.ask_for_reason_date , 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))", nativeQuery = true)
	public List<BotInformation> getList8BotInformation();

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationRepository.java
	 * 
	 * Gets the list 9 bot information.
	 * @return the list 9 bot information
	 */
	@Query(value = "SELECT b.* FROM bot_information b INNER JOIN user_information c ON (b.id_bot_information = c.id_bot_information) WHERE "
			+ "c.candidatefb = FALSE and c.guest=FALSE and b.status=30 and "
			+ "(to_timestamp(to_char(b.ask_shop_how_was_interview_date, 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))", nativeQuery = true)
	public List<BotInformation> getList9BotInformation();

	/**
	 * ***** story 46, station incomplete search for Line *******.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationRepository.java
	 * 
	 * Gets the station incomplete search bot information.
	 * @return the station incomplete search bot information
	 */

	@Query(value = "SELECT b.* FROM bot_information b INNER JOIN user_information c ON (b.id_bot_information = c.id_bot_information) WHERE "
			+ "c.candidatefb = FALSE and c.guest=FALSE and b.status=3 and "
			+ "(to_timestamp(to_char(b.similar_station_date, 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))", nativeQuery = true)
	public List<BotInformation> getStationIncompleteSearchBotInformation();

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationRepository.java
	 * 
	 * Gets the time incomplete search bot information.
	 * @return the time incomplete search bot information
	 */
	@Query(value = "SELECT b.* FROM bot_information b INNER JOIN user_information c ON (b.id_bot_information = c.id_bot_information) WHERE "
			+ "c.candidatefb = FALSE and c.guest=FALSE and b.status=4 and "
			+ "(to_timestamp(to_char(b.choose_station_date, 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))", nativeQuery = true)
	public List<BotInformation> getTimeIncompleteSearchBotInformation();

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationRepository.java
	 * 
	 * Gets the category incomplete search bot information.
	 * @return the category incomplete search bot information
	 */
	@Query(value = "SELECT b.* FROM bot_information b INNER JOIN user_information c ON (b.id_bot_information = c.id_bot_information) WHERE "
			+ "c.candidatefb = FALSE and c.guest=FALSE and b.status=5 and "
			+ "(to_timestamp(to_char(b.choose_time_date, 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))", nativeQuery = true)
	public List<BotInformation> getCategoryIncompleteSearchBotInformation();

	/**
	 * ********** ignore list for Messenger ******************.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationRepository.java
	 * 
	 * Gets the messenger list 1 bot information.
	 * @return the messenger list 1 bot information
	 */

	@Query(value = "SELECT b.* FROM bot_information b INNER JOIN user_information c ON (b.id_bot_information = c.id_bot_information) WHERE "
			+ "c.candidatefb = TRUE and c.guest=FALSE and ((b.status =1 and "
			+ "(to_timestamp(to_char(b.ask_for_language_date , 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))) "
			+ "or (b.status=2 and "
			+ "(to_timestamp(to_char(b.ask_for_station_date , 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))))", nativeQuery = true)
	public List<BotInformation> getMessengerList1BotInformation();

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationRepository.java
	 * 
	 * Gets the messenger list 5 bot information.
	 * @return the messenger list 5 bot information
	 */
	@Query(value = "SELECT b.* FROM bot_information b INNER JOIN user_information c ON (b.id_bot_information = c.id_bot_information) WHERE "
			+ "c.candidatefb = TRUE and c.guest=FALSE and (b.status =7 and "
			+ " (to_timestamp(to_char(b.ask_how_was_it_date , 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24')) or"
			+ " (b.status=26 and "
			+ "(to_timestamp(to_char(b.ask_for_applying_other_jobs_date , 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))))", nativeQuery = true)
	public List<BotInformation> getMessengerList5BotInformation();

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationRepository.java
	 * 
	 * Gets the messenger list 6 bot information.
	 * @return the messenger list 6 bot information
	 */
	@Query(value = "SELECT b.* FROM bot_information b INNER JOIN user_information c ON (b.id_bot_information = c.id_bot_information) WHERE "
			+ "(c.candidatefb = TRUE) and c.guest=FALSE and ((b.status=19 and "
			+ "(to_timestamp(to_char(b.ask_candidate_how_was_interview_date , 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))) or "
			+ "(b.status=29 and "
			+ "(to_timestamp(to_char(b.how_was_the_work_date , 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))) or "
			+ "(b.status=28 and "
			+ "(to_timestamp(to_char(b.ask_for_when_start_working , 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))) or "
			+ "(b.status=24 and "
			+ "(to_timestamp(to_char(b.ask_for_result_date_candidate , 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))) or "
			+ "(b.status=22 and "
			+ "(to_timestamp(to_char(b.ask_for_when_is_the_result_date , 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))) or "
			+ "(b.status=14 and "
			+ "(to_timestamp(to_char(b.ask_for_set_interview , 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))) or "
			+ "(b.status=15 and "
			+ "(to_timestamp(to_char(b.ask_for_when_interview_date , 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))))", nativeQuery = true)
	public List<BotInformation> getMessengerList6BotInformation();

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationRepository.java
	 * 
	 * Gets the messenger list 7 bot information.
	 * @return the messenger list 7 bot information
	 */
	@Query(value = "SELECT b.* FROM bot_information b INNER JOIN user_information c ON (b.id_bot_information = c.id_bot_information) WHERE"
			+ " c.candidatefb = TRUE and c.guest=FALSE and b.status=31 and "
			+ "(to_timestamp(to_char(b.ask_for_not_fixing_date , 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))", nativeQuery = true)
	public List<BotInformation> getMessengerList7BotInformation();

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationRepository.java
	 * 
	 * Gets the messenger list 8 bot information.
	 * @return the messenger list 8 bot information
	 */
	@Query(value = "SELECT b.* FROM bot_information b INNER JOIN user_information c ON (b.id_bot_information = c.id_bot_information) WHERE "
			+ "c.candidatefb = TRUE and c.guest=FALSE and b.status=27 and"
			+ " (to_timestamp(to_char(b.ask_for_reason_date , 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))", nativeQuery = true)
	public List<BotInformation> getMessengerList8BotInformation();

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationRepository.java
	 * 
	 * Gets the messenger list 9 bot information.
	 * @return the messenger list 9 bot information
	 */
	@Query(value = "SELECT b.* FROM bot_information b INNER JOIN user_information c ON (b.id_bot_information = c.id_bot_information) WHERE "
			+ "c.candidatefb = TRUE and c.guest=FALSE and b.status=30 and "
			+ "(to_timestamp(to_char(b.ask_shop_how_was_interview_date, 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))", nativeQuery = true)
	public List<BotInformation> getMessengerList9BotInformation();

	/**
	 * ***** story 46, station incomplete search for Messenger *******.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationRepository.java
	 * 
	 * Gets the messenger station incomplete search bot information.
	 * @return the messenger station incomplete search bot information
	 */

	@Query(value = "SELECT b.* FROM bot_information b INNER JOIN user_information c ON (b.id_bot_information = c.id_bot_information) WHERE "
			+ "c.candidatefb = TRUE and c.guest=FALSE and b.status=3 and "
			+ "(to_timestamp(to_char(b.similar_station_date, 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))", nativeQuery = true)
	public List<BotInformation> getMessengerStationIncompleteSearchBotInformation();

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationRepository.java
	 * 
	 * Gets the messenger time incomplete search bot information.
	 * @return the messenger time incomplete search bot information
	 */
	@Query(value = "SELECT b.* FROM bot_information b INNER JOIN user_information c ON (b.id_bot_information = c.id_bot_information) WHERE "
			+ "c.candidatefb = TRUE and c.guest=FALSE and b.status=4 and "
			+ "(to_timestamp(to_char(b.choose_station_date, 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))", nativeQuery = true)
	public List<BotInformation> getMessengerTimeIncompleteSearchBotInformation();

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationRepository.java
	 * 
	 * Gets the messenger category incomplete search bot information.
	 * @return the messenger category incomplete search bot information
	 */
	@Query(value = "SELECT b.* FROM bot_information b INNER JOIN user_information c ON (b.id_bot_information = c.id_bot_information) WHERE "
			+ "c.candidatefb = TRUE and c.guest=FALSE and b.status=5 and "
			+ "(to_timestamp(to_char(b.choose_time_date, 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))", nativeQuery = true)
	public List<BotInformation> getMessengerCategoryIncompleteSearchBotInformation();

	/**
	 * *********** ignore search ***********.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: BotInformationRepository.java
	 * 
	 * Gets the search ignore bot information.
	 * @return the search ignore bot information
	 */

	@Query(value = "SELECT b.id_bot_information FROM bot_information b INNER JOIN user_information c ON (b.id_bot_information = c.id_bot_information) WHERE "
			+ "c.candidatefb = FALSE and b.status=2 and "
			+ "(to_timestamp(to_char(b.ask_for_station_date, 'yyyy-MM-dd HH24:MI'), 'yyyy-MM-dd HH24:MI') + interval '60' minute <= to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24:MI'),'yyyy-MM-dd HH24:MI'))", nativeQuery = true)
	public List<Integer> getSearchIgnoreBotInformation();

}
