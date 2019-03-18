package org.crawler.web.crawler;

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
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.hrdatabank.otome.domain.JobOtome;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.url.WebURL;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractCralwer.
 * 
 * @author Hanios
 */
public abstract class AbstractCrawler extends WebCrawler {

	/** The Constant MORNING. */
	static final String MORNING = "morning";

	/** The Constant AFTERNOON. */
	static final String AFTERNOON = "afternoon";

	/** The Constant EVENING. */
	static final String EVENING = "evening";

	/** The Constant NIGHT. */
	static final String NIGHT = "night";

	/** The job detail. */
	protected JobOtome jobDetail;

	/** The job id. */
	protected String jobId;

	/** The job url. */
	protected String jobUrl;

	/** The job img url. */
	protected String jobImgUrl;

	/** The category name. */
	protected String categoryName;

	/** The job type. */
	protected String jobType;

	/** The job description. */
	protected String jobDescription;

	/** The shop name. */
	protected String shopName;

	/** The position name. */
	protected String positionName;

	/** The job address. */
	protected String jobAddress;

	/** The job detail id. */
	protected String jobDetailId;

	/** The transportation. */
	protected boolean transportation;

	/** The wage. */
	protected String wage;

	/** The start time. */
	protected Date startTime;

	/** The finish time. */
	protected Date finishTime;

	/** The shifts. */
	protected List<Date> shifts;

	/** The min hours per day. */
	protected String minHoursPerDay;

	/** The min working days. */
	protected String minWorkingDays;

	/**
	 * Instantiates a new abstract cralwer.
	 */
	public AbstractCrawler() {
		shifts = new ArrayList<>();
		startTime = new Date();
		finishTime = new Date();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uci.ics.crawler4j.crawler.WebCrawler#shouldVisit(edu.uci.ics.crawler4j.
	 * crawler.Page, edu.uci.ics.crawler4j.url.WebURL)
	 */
	@Override
	public boolean shouldVisit(Page referringPage, WebURL url) {
		return true;
	}

	/**
	 * This function is called when a page is fetched and ready to be processed by
	 * your program.
	 *
	 * @author Hanios
	 * @param page
	 *            the page
	 */
	@Override
	public abstract void visit(Page page);

	/**
	 * This method saves job data into list.
	 * 
	 * @author Hanios
	 */
	public abstract void save();

	/**
	 * Gets the langitude and latitude.
	 * 
	 * @author Hanios
	 * @param address
	 *            the address
	 * @return the langitude and latitude
	 * @throws JSONException
	 *             the JSON exception
	 */
	public JSONObject getLangitudeAndLatitude(String address) throws JSONException {

		String baseURL = "https://maps.googleapis.com/maps/api/geocode/json?address=" + address
				+ "&key=AIzaSyD3hVjS3xWGj1VVdOQvEqgBOPMTb6Ft8Uk";

		RestTemplate rest = new RestTemplate();
		rest.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));

		ResponseEntity<String> response = rest.exchange(baseURL, HttpMethod.GET, null, String.class);

		JSONObject jsonObj = new JSONObject(response.getBody());
		JSONArray jsonarr = jsonObj.getJSONArray("results");
		String jsonZeroRst = jsonObj.getString("status");
		return !jsonZeroRst.equals("ZERO_RESULTS")
				? jsonarr.getJSONObject(0).getJSONObject("geometry").getJSONObject("location")
				: null;
	}

	/**
	 * Gets the work time en work time JP.
	 *
	 * @author Hanios
	 * @param startWorkingTime
	 *            the start working time
	 * @param finishWorkingTime
	 *            the finish working time
	 * @param job
	 *            the job
	 * @return the work time en work time JP
	 * @throws ParseException
	 *             the parse exception
	 */
	public void getWorkTimeEnWorkTimeJP(String startWorkingTime, String finishWorkingTime, JobOtome job)
			throws ParseException {
		DateFormat formatter = new SimpleDateFormat("HH:mm");
		String finishTimeEnglishToSet = "";
		String finishTimeJapaneseToSet = "";
		if (finishWorkingTime != "" && finishWorkingTime != null) {
			Date finishWorkingTimeDate = formatter.parse(finishWorkingTime);
			job.setFinishTime(finishWorkingTimeDate);
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
			dateFormat.format(date);
			if ((finishWorkingTimeDate.before(dateFormat.parse("05:00")))
					|| (finishWorkingTimeDate.equals(dateFormat.parse("05:00")))
					|| ((finishWorkingTimeDate.before(dateFormat.parse("20:00")))
							|| (finishWorkingTimeDate.before(dateFormat.parse("24:00"))))
					|| ((finishWorkingTimeDate.equals(dateFormat.parse("20:00")))
							|| (finishWorkingTimeDate.equals(dateFormat.parse("24:00"))))) {
				finishTimeEnglishToSet = NIGHT;
				finishTimeJapaneseToSet = "夜勤";
			}
			if ((finishWorkingTimeDate.before(dateFormat.parse("10:00")))
					|| (finishWorkingTimeDate.equals(dateFormat.parse("10:00")))) {
				if (finishTimeEnglishToSet.equals("")) {
					finishTimeEnglishToSet = MORNING;
					finishTimeJapaneseToSet = "学校前";
				} else {
					finishTimeEnglishToSet = finishTimeEnglishToSet + " and " + MORNING;
					finishTimeJapaneseToSet = finishTimeJapaneseToSet + " and " + "学校前";
				}
			}
			if (((finishWorkingTimeDate.before(dateFormat.parse("16:00")))
					|| (finishWorkingTimeDate.before(dateFormat.parse("24:00"))))
					|| ((finishWorkingTimeDate.equals(dateFormat.parse("16:00")))
							|| (finishWorkingTimeDate.equals(dateFormat.parse("24:00"))))) {
				if (finishTimeEnglishToSet.equals("")) {
					finishTimeEnglishToSet = AFTERNOON;
					finishTimeJapaneseToSet = "学校後";
				} else {
					finishTimeEnglishToSet = finishTimeEnglishToSet + " and " + AFTERNOON;
					finishTimeJapaneseToSet = finishTimeJapaneseToSet + " and " + "学校後";
				}
			}
			if (((finishWorkingTimeDate.before(dateFormat.parse("20:00")))
					|| (finishWorkingTimeDate.before(dateFormat.parse("24:00"))))
					|| ((finishWorkingTimeDate.equals(dateFormat.parse("20:00")))
							|| (finishWorkingTimeDate.equals(dateFormat.parse("24:00"))))) {
				if (finishTimeEnglishToSet.equals("")) {
					finishTimeEnglishToSet = EVENING;
					finishTimeJapaneseToSet = "学校後";
				} else {
					finishTimeEnglishToSet = finishTimeEnglishToSet + " and " + EVENING;
					finishTimeJapaneseToSet = finishTimeJapaneseToSet + " and " + "学校後";
				}
			}
		}
		String startTimeEnglishToSet = "";
		String startTimeJapaneseToSet = "";
		if (startWorkingTime != "" && startWorkingTime != null) {
			Date startWorkingTimeDate = formatter.parse(startWorkingTime);
			job.setStartTime(startWorkingTimeDate);

			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
			dateFormat.format(date);

			if (((startWorkingTimeDate.after(dateFormat.parse("06:00")))
					&& (startWorkingTimeDate.before(dateFormat.parse("10:00"))))
					|| (startWorkingTimeDate.equals(dateFormat.parse("06:00")))) {
				startTimeEnglishToSet = MORNING;
				startTimeJapaneseToSet = "学校前";
			}
			if (((startWorkingTimeDate.after(dateFormat.parse("10:00")))
					&& (startWorkingTimeDate.before(dateFormat.parse("16:00"))))
					|| (startWorkingTimeDate.equals(dateFormat.parse("10:00")))) {
				if (startTimeEnglishToSet.equals("")) {
					startTimeEnglishToSet = AFTERNOON;
					startTimeJapaneseToSet = "学校後";
				} else {
					startTimeEnglishToSet = startTimeEnglishToSet + " and " + AFTERNOON;
					startTimeJapaneseToSet = startTimeJapaneseToSet + " and " + "学校後";
				}
			}
			if (((startWorkingTimeDate.after(dateFormat.parse("16:00")))
					&& (startWorkingTimeDate.before(dateFormat.parse("20:00"))))
					|| (startWorkingTimeDate.equals(dateFormat.parse("16:00")))) {
				if (startTimeEnglishToSet.equals("")) {
					startTimeEnglishToSet = EVENING;
					startTimeJapaneseToSet = "夜勤";
				} else {
					startTimeEnglishToSet = startTimeEnglishToSet + " and " + EVENING;
					startTimeJapaneseToSet = startTimeJapaneseToSet + " and " + "夜勤";
				}
			}

			if (((startWorkingTimeDate.after(dateFormat.parse("20:00")))
					&& (startWorkingTimeDate.before(dateFormat.parse("5:00"))))
					|| (startWorkingTimeDate.equals(dateFormat.parse("20:00")))) {
				if (startTimeEnglishToSet.equals("")) {
					startTimeEnglishToSet = NIGHT;
					startTimeJapaneseToSet = "夜勤";
				} else {
					startTimeEnglishToSet = startTimeEnglishToSet + " and " + NIGHT;
					startTimeJapaneseToSet = startTimeJapaneseToSet + " and " + "夜勤";
				}
			}
			if (finishWorkingTime != "" && finishWorkingTime != null) {
				Date finishWorkingTimeDate = formatter.parse(finishWorkingTime);
				if ((startWorkingTimeDate.equals(dateFormat.parse("00:00")))
						&& (finishWorkingTimeDate.equals(dateFormat.parse("00:00")))) {
					job.setWorkTimeEnglish("morning and afternoon and evening and night");
					job.setWorkTimeJapanese("学校前 and 夜勤 and 学校後");
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
							if (startTimeEnglishToSet.contains(MORNING) && finishTimeEnglishToSet.contains(MORNING)) {
								startTimeEnglishToSet = startTimeEnglishToSet.replace(MORNING, "");
								startTimeJapaneseToSet = startTimeJapaneseToSet.replace("学校前", "");
							}
							if (startTimeEnglishToSet.contains(AFTERNOON)
									&& finishTimeEnglishToSet.contains(AFTERNOON)) {
								startTimeEnglishToSet = startTimeEnglishToSet.replace(AFTERNOON, "");
								startTimeJapaneseToSet = startTimeJapaneseToSet.replace("学校後", "");
							}
							if (startTimeEnglishToSet.contains(EVENING) && finishTimeEnglishToSet.contains(EVENING)) {
								startTimeEnglishToSet = startTimeEnglishToSet.replace(EVENING, "");
								startTimeJapaneseToSet = startTimeJapaneseToSet.replace("夜勤", "");
							}

							if (startTimeEnglishToSet.contains(NIGHT) && finishTimeEnglishToSet.contains(NIGHT)) {
								startTimeEnglishToSet = startTimeEnglishToSet.replace(NIGHT, "");
								startTimeJapaneseToSet = startTimeJapaneseToSet.replace("夜勤", "");
							}
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
				if (workTimeEnglish.indexOf("and  and", 1) > -1) {
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
	}
}
