package com.hrdatabank.otome.services;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ift.CellProcessor;

import com.hrdatabank.otome.domain.Job;

public class JsenLacottoUtils {
	private static final Logger logger = LoggerFactory.getLogger(JsenLacottoUtils.class);

	private static String SIX_OCLOCK = "06:00";
	private static String SEVEN_OCLOCK = "07:00";
	private static String TWELVE_OCLOCK = "12:00";
	private static String TEN_OCLOCK_PM = "22:00";
	private static String ONE_OCLOCK_PM = "13:00";
	private static String MIDNIGHT_AM = "00:00";
	private static String MIDNIGHT_PM = "24:00";
	private static String HH_MM = "HH:mm";
	private static String NIGHT_SHIFT = "Night Shift";
	private static String BEFORE_SCHOOL = "Before School";
	private static String AFTER_SCHOOL = "After School";
	private static String BEFORESCHOOL_NIGHTSHIFT_AFTERSCHOOL_EN = "Before School and Night Shift and After School";
	private static String BEFORESCHOOL_NIGHTSHIFT_AFTERSCHOOL_JP = "学校前 and 夜勤 and 学校後";
	private static String NIGHT_SCHOOL = "Night School";

	public static String convertFullWidthToHalfWidth(String str) {
		str = str.replace('０', '0');
		str = str.replace('１', '1');
		str = str.replace('２', '2');
		str = str.replace('３', '3');
		str = str.replace('４', '4');
		str = str.replace('５', '5');
		str = str.replace('６', '6');
		str = str.replace('７', '7');
		str = str.replace('８', '8');
		str = str.replace('９', '9');
		return str;
	}

	public static boolean checkJobsURL(String jobURL) throws IOException {
		boolean jobExpired = false;

		URL u = new URL(jobURL);
		HttpURLConnection huc = (HttpURLConnection) u.openConnection();
		huc.setRequestMethod("GET");
		huc.connect();
		int code = huc.getResponseCode();
		if (code == 404) {
			jobExpired = true;

		}
		return jobExpired;

	}

	/**
	 * ***********************************************.
	 *
	 * @author Wala Ben Amor
	 *
	 *         Using JRE: 1.8
	 *
	 *         Project Name: Module-Web-Admin
	 *
	 *         Class Name: ShopController.java
	 *
	 *         Gets the langitude and latitude.
	 * @param address the address
	 * @return the langitude and latitude
	 * @throws JSONException the JSON exception
	 */
	/**************************************************/
	/**************************************************/

	public static JSONObject getLangitudeAndLatitude(String address) throws JSONException {

		String baseURL = "https://maps.googleapis.com/maps/api/geocode/json?address=" + address
				+ "&key=AIzaSyD3hVjS3xWGj1VVdOQvEqgBOPMTb6Ft8Uk";

		logger.info("***********URL************* :'{}'", baseURL);

		RestTemplate rest = new RestTemplate();
		rest.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));

		ResponseEntity<String> response = rest.exchange(baseURL, HttpMethod.GET, null, String.class);

		JSONObject jsonObj = new JSONObject(response.getBody());
		logger.info("jsonObj : :'{}'", jsonObj.toString());
		JSONArray jsonarr = jsonObj.getJSONArray("results");
		String jsonZeroRst = jsonObj.getString("status");
		if (!jsonZeroRst.equals("ZERO_RESULTS")) {
			logger.info("******************RESPONSE********** : "
					+ jsonarr.getJSONObject(0).getJSONObject("geometry").getJSONObject("location"));

			return jsonarr.getJSONObject(0).getJSONObject("geometry").getJSONObject("location");
		}
		return null;
	}

	public static Job setWorkTimeEnglishJapanese(Job job, String startWorkingTime, String finishWorkingTime)
			throws ParseException {

		/******************************************/
		DateFormat formatter = new SimpleDateFormat(HH_MM);

		String finishTimeEnglishToSet = "";
		String finishTimeJapaneseToSet = "";
		if (finishWorkingTime != "" && finishWorkingTime != null && !finishWorkingTime.equalsIgnoreCase("NULL")) {
			Date finishWorkingTimeDate = formatter.parse(finishWorkingTime);
			// job.setFinishWorkingTime(finishWorkingTimeDate);
			/******************************************/
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat(HH_MM);
			dateFormat.format(date);
			if (((finishWorkingTimeDate.before(dateFormat.parse(SEVEN_OCLOCK))))
					|| (finishWorkingTimeDate.equals(dateFormat.parse(SEVEN_OCLOCK)))
					|| ((finishWorkingTimeDate.before(dateFormat.parse(MIDNIGHT_AM)))
							|| (finishWorkingTimeDate.before(dateFormat.parse(MIDNIGHT_PM))))
					|| ((finishWorkingTimeDate.equals(dateFormat.parse(MIDNIGHT_AM)))
							|| (finishWorkingTimeDate.equals(dateFormat.parse(MIDNIGHT_PM))))) {
				finishTimeEnglishToSet = NIGHT_SHIFT;
				finishTimeJapaneseToSet = "夜勤";
			}
			if (((finishWorkingTimeDate.before(dateFormat.parse(ONE_OCLOCK_PM))))
					|| ((finishWorkingTimeDate.equals(dateFormat.parse(ONE_OCLOCK_PM))))) {
				logger.info(BEFORE_SCHOOL);
				if (finishTimeEnglishToSet.equals("")) {
					finishTimeEnglishToSet = BEFORE_SCHOOL;
					finishTimeJapaneseToSet = "学校前";
				} else {
					finishTimeEnglishToSet = finishTimeEnglishToSet + " and " + BEFORE_SCHOOL;
					finishTimeJapaneseToSet = finishTimeJapaneseToSet + " and " + "学校前";
				}
			}
			if (((finishWorkingTimeDate.before(dateFormat.parse(MIDNIGHT_AM)))
					|| (finishWorkingTimeDate.before(dateFormat.parse(MIDNIGHT_PM))))
					|| ((finishWorkingTimeDate.equals(dateFormat.parse(MIDNIGHT_AM)))
							|| (finishWorkingTimeDate.equals(dateFormat.parse(MIDNIGHT_PM))))) {
				if (finishTimeEnglishToSet.equals("")) {
					finishTimeEnglishToSet = AFTER_SCHOOL;
					finishTimeJapaneseToSet = "学校後";
				} else {
					finishTimeEnglishToSet = finishTimeEnglishToSet + " and " + AFTER_SCHOOL;
					finishTimeJapaneseToSet = finishTimeJapaneseToSet + " and " + "学校後";
				}
			}
		}
		logger.info("/******** Start work time ************/");
		String startTimeEnglishToSet = "";
		String startTimeJapaneseToSet = "";
		if (startWorkingTime != "" && startWorkingTime != null && !startWorkingTime.equalsIgnoreCase("NULL")) {
			Date startWorkingTimeDate = formatter.parse(startWorkingTime);
			// job.setStartWorkingTime(startWorkingTimeDate);

			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat(HH_MM);
			dateFormat.format(date);

			if (((startWorkingTimeDate.after(dateFormat.parse(SIX_OCLOCK)))
					&& (startWorkingTimeDate.before(dateFormat.parse(ONE_OCLOCK_PM))))
					|| ((startWorkingTimeDate.equals(dateFormat.parse(SIX_OCLOCK))))) {
				logger.info(BEFORE_SCHOOL);
				startTimeEnglishToSet = BEFORE_SCHOOL;
				startTimeJapaneseToSet = "学校前";
			}
			if (((startWorkingTimeDate.after(dateFormat.parse(TWELVE_OCLOCK)))
					&& (startWorkingTimeDate.before(dateFormat.parse(MIDNIGHT_AM))))
					|| (startWorkingTimeDate.equals(dateFormat.parse(TWELVE_OCLOCK)))) {
				if (startTimeEnglishToSet.equals("")) {
					startTimeEnglishToSet = AFTER_SCHOOL;
					startTimeJapaneseToSet = "学校後";
				} else {
					startTimeEnglishToSet = startTimeEnglishToSet + " and " + AFTER_SCHOOL;
					startTimeJapaneseToSet = startTimeJapaneseToSet + " and " + "学校後";
				}
			}
			if (((startWorkingTimeDate.after(dateFormat.parse(TEN_OCLOCK_PM)))
					&& (startWorkingTimeDate.before(dateFormat.parse(SEVEN_OCLOCK))))
					|| (startWorkingTimeDate.equals(dateFormat.parse(TEN_OCLOCK_PM)))) {
				if (startTimeEnglishToSet.equals("")) {
					startTimeEnglishToSet = NIGHT_SHIFT;
					startTimeJapaneseToSet = "夜勤";
				} else {
					startTimeEnglishToSet = startTimeEnglishToSet + " and " + NIGHT_SHIFT;
					startTimeJapaneseToSet = startTimeJapaneseToSet + " and " + "夜勤";
				}
			}
			if (finishWorkingTime != "" && finishWorkingTime != null) {
				Date finishWorkingTimeDate = formatter.parse(finishWorkingTime);
				if ((startWorkingTimeDate.equals(dateFormat.parse(MIDNIGHT_AM)))
						&& (finishWorkingTimeDate.equals(dateFormat.parse(MIDNIGHT_AM)))) {
					job.setWorkTimeEnglish(BEFORESCHOOL_NIGHTSHIFT_AFTERSCHOOL_EN);
					job.setWorkTimeJapanese(BEFORESCHOOL_NIGHTSHIFT_AFTERSCHOOL_JP);
				}
			}
			String workTimeEnglish = "";
			String workTimeJapanese = "";
			if (!startTimeEnglishToSet.equals("")) {
				if (startTimeEnglishToSet.equals(finishTimeEnglishToSet)) {
					job.setWorkTimeEnglish(startTimeEnglishToSet);
					job.setWorkTimeJapanese(startTimeJapaneseToSet);
				} else {
					if (!finishTimeEnglishToSet.equals("")) {
						if ((!startTimeEnglishToSet.contains(finishTimeEnglishToSet))) {
							if (startTimeEnglishToSet.contains(BEFORE_SCHOOL)
									&& finishTimeEnglishToSet.contains(BEFORE_SCHOOL)) {
								startTimeEnglishToSet = startTimeEnglishToSet.replace(BEFORE_SCHOOL, "");
								startTimeJapaneseToSet = startTimeJapaneseToSet.replace("学校前", "");
							}
							if (startTimeEnglishToSet.contains(AFTER_SCHOOL)
									&& finishTimeEnglishToSet.contains(AFTER_SCHOOL)) {
								startTimeEnglishToSet = startTimeEnglishToSet.replace(AFTER_SCHOOL, "");
								startTimeJapaneseToSet = startTimeJapaneseToSet.replace("学校後", "");
							}
							if (startTimeEnglishToSet.contains(NIGHT_SCHOOL)
									&& finishTimeEnglishToSet.contains(NIGHT_SCHOOL)) {
								startTimeEnglishToSet = startTimeEnglishToSet.replace(NIGHT_SCHOOL, "");
								startTimeJapaneseToSet = startTimeJapaneseToSet.replace("夜勤", "");
							}
							logger.info("-------startTimeEnglishToSet--****-------------:{}", startTimeEnglishToSet);
							logger.info("--------finishTimeEnglishToSet--****-----------:{}", finishTimeEnglishToSet);

							if (!startTimeEnglishToSet.equals("")) {
								workTimeEnglish = startTimeEnglishToSet + " and " + finishTimeEnglishToSet;
								workTimeJapanese = startTimeJapaneseToSet + " and " + finishTimeJapaneseToSet;

							} else {
								workTimeEnglish = finishTimeEnglishToSet;
								workTimeJapanese = finishTimeJapaneseToSet;
							}
						} else {
							workTimeEnglish = startTimeEnglishToSet;
							workTimeJapanese = startTimeJapaneseToSet;
						}
					} else {
						workTimeEnglish = startTimeEnglishToSet;
						workTimeJapanese = startTimeJapaneseToSet;
					}
				}
			} else {
				if (!finishTimeEnglishToSet.equals("")) {
					workTimeEnglish = finishTimeEnglishToSet;
					workTimeJapanese = finishTimeJapaneseToSet;
				}

			}
			if (workTimeEnglish.contains("and  and")) {
				if (workTimeEnglish.indexOf("and  and") == 1) {
					workTimeEnglish = workTimeEnglish.replace("and  and", "");
					workTimeJapanese = workTimeJapanese.replace("and  and", "");
				} else {
					workTimeEnglish = workTimeEnglish.replace("and  and", "and");
					workTimeJapanese = workTimeJapanese.replace("and  and", "and");
				}
			}
			job.setWorkTimeEnglish(workTimeEnglish);
			job.setWorkTimeJapanese(workTimeJapanese);

		}
		/**********************************/
		if (job.getWorkTimeEnglish() == null && job.getWorkTimeJapanese() == null) {
			if (startWorkingTime != "" && startWorkingTime != null && finishWorkingTime != null
					&& finishWorkingTime != "") {
				logger.info("----------Condition1----------------");

				Date startWorkingTimeDate = formatter.parse(startWorkingTime);
				Date date = new Date();
				SimpleDateFormat dateFormat = new SimpleDateFormat(HH_MM);
				dateFormat.format(date);
				Date finishWorkingTimeDate = formatter.parse(finishWorkingTime);
				/******************************************/
				dateFormat.format(date);
				if (startWorkingTimeDate.before(dateFormat.parse(SIX_OCLOCK))
						&& (finishWorkingTimeDate.after(dateFormat.parse(MIDNIGHT_AM))
								|| finishWorkingTimeDate.after(dateFormat.parse(MIDNIGHT_PM)))) {
					logger.info("----------Condition12----------------");
					job.setWorkTimeEnglish(BEFORESCHOOL_NIGHTSHIFT_AFTERSCHOOL_EN);
					job.setWorkTimeJapanese(BEFORESCHOOL_NIGHTSHIFT_AFTERSCHOOL_JP);
				} else if (startWorkingTimeDate.after(dateFormat.parse(TWELVE_OCLOCK))
						&& (finishWorkingTimeDate.after(dateFormat.parse(MIDNIGHT_AM))
								|| finishWorkingTimeDate.equals(dateFormat.parse(MIDNIGHT_AM))
								|| finishWorkingTimeDate.after(dateFormat.parse(MIDNIGHT_PM)))) {
					logger.info("----------Condition13----------------");
					job.setWorkTimeEnglish("Night Shift and After School");
					job.setWorkTimeJapanese("夜勤 and 学校後");
				}
			}

		}
		/******************************************/
		return job;
	}

	public static CellProcessor[] getProcessors(int nbrColumns) {
		
		List<CellProcessor> lacottoProcessors = new ArrayList<>();

		for (int i = 0; i <= nbrColumns; i++) {
			lacottoProcessors.add(new Optional());
		}
		return lacottoProcessors.stream().toArray(CellProcessor[]::new);
	}

}
