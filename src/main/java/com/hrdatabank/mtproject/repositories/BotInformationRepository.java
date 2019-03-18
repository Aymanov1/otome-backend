package com.hrdatabank.mtproject.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.hrdatabank.mtproject.entities.BotInformation;

/**
 * The Interface BotInformationRepository.
 */
@Repository
@RepositoryRestResource
public interface BotInformationRepository extends JpaRepository<BotInformation, Serializable> {

	/************ ignore list for Line *******************/

	@Query(value = "SELECT b.* FROM bot_information b INNER JOIN user_information c ON (b.id_bot_information = c.id_bot_information) WHERE "
			+ "c.candidatefb = FALSE and c.guest=FALSE and ((b.status =1 and "
			+ "(to_timestamp(to_char(b.ask_for_language_date , 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))) "
			+ "or (b.status=2 and "
			+ "(to_timestamp(to_char(b.ask_for_station_date , 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))))", nativeQuery = true)
	public List<BotInformation> getList1BotInformation();

	@Query(value = "SELECT b.* FROM bot_information b INNER JOIN user_information c ON (b.id_bot_information = c.id_bot_information) WHERE "
			+ "c.candidatefb = FALSE and c.guest=FALSE and (b.status =7 and "
			+ " (to_timestamp(to_char(b.ask_how_was_it_date , 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24')) or"
			+ " (b.status=26 and "
			+ "(to_timestamp(to_char(b.ask_for_applying_other_jobs_date , 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))))", nativeQuery = true)
	public List<BotInformation> getList5BotInformation();

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

	@Query(value = "SELECT b.* FROM bot_information b INNER JOIN user_information c ON (b.id_bot_information = c.id_bot_information) WHERE"
			+ " c.candidatefb = FALSE and c.guest=FALSE and b.status=31 and "
			+ "(to_timestamp(to_char(b.ask_for_not_fixing_date , 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))", nativeQuery = true)
	public List<BotInformation> getList7BotInformation();

	@Query(value = "SELECT b.* FROM bot_information b INNER JOIN user_information c ON (b.id_bot_information = c.id_bot_information) WHERE "
			+ "c.candidatefb = FALSE and c.guest=FALSE and b.status=27 and"
			+ " (to_timestamp(to_char(b.ask_for_reason_date , 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))", nativeQuery = true)
	public List<BotInformation> getList8BotInformation();

	@Query(value = "SELECT b.* FROM bot_information b INNER JOIN user_information c ON (b.id_bot_information = c.id_bot_information) WHERE "
			+ "c.candidatefb = FALSE and c.guest=FALSE and b.status=30 and "
			+ "(to_timestamp(to_char(b.ask_shop_how_was_interview_date, 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))", nativeQuery = true)
	public List<BotInformation> getList9BotInformation();

	/******* story 46, station incomplete search for Line ********/

	@Query(value = "SELECT b.* FROM bot_information b INNER JOIN user_information c ON (b.id_bot_information = c.id_bot_information) WHERE "
			+ "c.candidatefb = FALSE and c.guest=FALSE and b.status=3 and "
			+ "(to_timestamp(to_char(b.similar_station_date, 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))", nativeQuery = true)
	public List<BotInformation> getStationIncompleteSearchBotInformation();

	@Query(value = "SELECT b.* FROM bot_information b INNER JOIN user_information c ON (b.id_bot_information = c.id_bot_information) WHERE "
			+ "c.candidatefb = FALSE and c.guest=FALSE and b.status=4 and "
			+ "(to_timestamp(to_char(b.choose_station_date, 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))", nativeQuery = true)
	public List<BotInformation> getTimeIncompleteSearchBotInformation();

	@Query(value = "SELECT b.* FROM bot_information b INNER JOIN user_information c ON (b.id_bot_information = c.id_bot_information) WHERE "
			+ "c.candidatefb = FALSE and c.guest=FALSE and b.status=5 and "
			+ "(to_timestamp(to_char(b.choose_time_date, 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))", nativeQuery = true)
	public List<BotInformation> getCategoryIncompleteSearchBotInformation();

	/************ ignore list for Messenger *******************/

	@Query(value = "SELECT b.* FROM bot_information b INNER JOIN user_information c ON (b.id_bot_information = c.id_bot_information) WHERE "
			+ "c.candidatefb = TRUE and c.guest=FALSE and ((b.status =1 and "
			+ "(to_timestamp(to_char(b.ask_for_language_date , 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))) "
			+ "or (b.status=2 and "
			+ "(to_timestamp(to_char(b.ask_for_station_date , 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))))", nativeQuery = true)
	public List<BotInformation> getMessengerList1BotInformation();

	@Query(value = "SELECT b.* FROM bot_information b INNER JOIN user_information c ON (b.id_bot_information = c.id_bot_information) WHERE "
			+ "c.candidatefb = TRUE and c.guest=FALSE and (b.status =7 and "
			+ " (to_timestamp(to_char(b.ask_how_was_it_date , 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24')) or"
			+ " (b.status=26 and "
			+ "(to_timestamp(to_char(b.ask_for_applying_other_jobs_date , 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))))", nativeQuery = true)
	public List<BotInformation> getMessengerList5BotInformation();

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

	@Query(value = "SELECT b.* FROM bot_information b INNER JOIN user_information c ON (b.id_bot_information = c.id_bot_information) WHERE"
			+ " c.candidatefb = TRUE and c.guest=FALSE and b.status=31 and "
			+ "(to_timestamp(to_char(b.ask_for_not_fixing_date , 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))", nativeQuery = true)
	public List<BotInformation> getMessengerList7BotInformation();

	@Query(value = "SELECT b.* FROM bot_information b INNER JOIN user_information c ON (b.id_bot_information = c.id_bot_information) WHERE "
			+ "c.candidatefb = TRUE and c.guest=FALSE and b.status=27 and"
			+ " (to_timestamp(to_char(b.ask_for_reason_date , 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))", nativeQuery = true)
	public List<BotInformation> getMessengerList8BotInformation();

	@Query(value = "SELECT b.* FROM bot_information b INNER JOIN user_information c ON (b.id_bot_information = c.id_bot_information) WHERE "
			+ "c.candidatefb = TRUE and c.guest=FALSE and b.status=30 and "
			+ "(to_timestamp(to_char(b.ask_shop_how_was_interview_date, 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))", nativeQuery = true)
	public List<BotInformation> getMessengerList9BotInformation();

	/******* story 46, station incomplete search for Messenger ********/

	@Query(value = "SELECT b.* FROM bot_information b INNER JOIN user_information c ON (b.id_bot_information = c.id_bot_information) WHERE "
			+ "c.candidatefb = TRUE and c.guest=FALSE and b.status=3 and "
			+ "(to_timestamp(to_char(b.similar_station_date, 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))", nativeQuery = true)
	public List<BotInformation> getMessengerStationIncompleteSearchBotInformation();

	@Query(value = "SELECT b.* FROM bot_information b INNER JOIN user_information c ON (b.id_bot_information = c.id_bot_information) WHERE "
			+ "c.candidatefb = TRUE and c.guest=FALSE and b.status=4 and "
			+ "(to_timestamp(to_char(b.choose_station_date, 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))", nativeQuery = true)
	public List<BotInformation> getMessengerTimeIncompleteSearchBotInformation();

	@Query(value = "SELECT b.* FROM bot_information b INNER JOIN user_information c ON (b.id_bot_information = c.id_bot_information) WHERE "
			+ "c.candidatefb = TRUE and c.guest=FALSE and b.status=5 and "
			+ "(to_timestamp(to_char(b.choose_time_date, 'yyyy-MM-dd HH24'), 'yyyy-MM-dd HH24') + interval '1' hour = to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24'),'yyyy-MM-dd HH24'))", nativeQuery = true)
	public List<BotInformation> getMessengerCategoryIncompleteSearchBotInformation();

	/************* ignore search ************/

	@Query(value = "SELECT b.id_bot_information FROM bot_information b INNER JOIN user_information c ON (b.id_bot_information = c.id_bot_information) WHERE "
			+ "c.candidatefb = FALSE and b.status=2 and "
			+ "(to_timestamp(to_char(b.ask_for_station_date, 'yyyy-MM-dd HH24:MI'), 'yyyy-MM-dd HH24:MI') + interval '60' minute <= to_timestamp(to_char(CURRENT_TIMESTAMP, 'yyyy-MM-dd HH24:MI'),'yyyy-MM-dd HH24:MI'))", nativeQuery = true)
	public List<Integer> getSearchIgnoreBotInformation();

}
