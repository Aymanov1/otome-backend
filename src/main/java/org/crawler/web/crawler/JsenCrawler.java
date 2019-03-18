package org.crawler.web.crawler;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.crawler.web.initializer.JsenInitializer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hrdatabank.otome.domain.JobOtome;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.parser.HtmlParseData;

public class JsenCrawler extends AbstractCrawler {
	/** The Constant logger. */
	private static final Logger LOGGER = LoggerFactory.getLogger(BaitoruCrawler.class);
	private DateFormat dateFormat = new SimpleDateFormat("hh:mm");

	@Override
	public void visit(Page page) {
		String url = page.getWebURL().getURL();
		shopName = "";
		jobImgUrl = "";
		jobUrl = "";
		jobType = "";
		jobDescription = "";
		positionName = "";
		jobAddress = "";
		wage = "";
		transportation = false;

		jobId = "";
		categoryName = "";
		shopName = "";

		minHoursPerDay = "";
		minWorkingDays = "";
		if (page.getParseData() instanceof HtmlParseData) {

			/****************************
			 * JobUrl && JobId
			 *******************************/

			// Element jobLink = e.select("a").first();
			// jobUrl = jobLink.attr("href");
			// System.out.println("jobURL " + jobUrl);
			// jobId = getJobId(jobLink.attr("href"));
			// System.out.println("jobId " + jobId);
			/***************************
			 * Crawling Job Details
			 *****************************/
			try {
				Document docJobDetail = Jsoup.connect(url).get();
				/****************************
				 * Job URL
				 *******************************/
				jobUrl = url;
				LOGGER.info("jobUrl {}" + jobUrl);
				/**************************** JobType *******************************/
				try {
					Element typeElem = docJobDetail.selectFirst("div.detail-basicInfo").select("dd").first()
							.selectFirst("span");
					if (typeElem.ownText().contains("正"))
						jobType = typeElem.ownText();
					else
						jobType = "";
					LOGGER.info("jobType {}" + jobType);
				} catch (NullPointerException ex) {

					jobType = "";
				}
				/**************************** Img *******************************/
				try {
					Element imgElem = docJobDetail.selectFirst("figure").selectFirst("img");
					jobImgUrl = "https:" + imgElem.attr("src");
					LOGGER.info("jobImgUrl {}" + jobImgUrl);
				} catch (NullPointerException ex) {
					LOGGER.error(ex.getMessage());
					jobImgUrl = "";
				}
				/**************************** ShopName *******************************/
				try {
					Element shopNameElem = docJobDetail.selectFirst("h1.u-font-l");
					shopName = shopNameElem.ownText();
					LOGGER.info("shopName {}" + shopName);

				} catch (NullPointerException ex) {
					shopName = "";
				}
				/**************************** PositionName *******************************/
				try {
					Element positionNameElem = docJobDetail.select("dd.p-detail-table-content").get(0).selectFirst("p");
					positionName = positionNameElem.ownText().replace("：", "");
					LOGGER.info("positionName {}" + positionName);

				} catch (IndexOutOfBoundsException ex) {
					positionName = "";
				}
				/**************************** Wage *******************************/
				Element wageElem = null;
				try {
					wageElem = docJobDetail.selectFirst("em.u-text-emphasis-1");
					LOGGER.info("wage  = {}" + wageElem.ownText().split("〜")[0].replaceAll("[^0-9]", ""));
					if (Integer
							.valueOf(getSmallestWage(wageElem.ownText().split("〜")[0].replaceAll("[^0-9]", ""))) < 100)
						wage = getSmallestWage(wageElem.ownText().split("〜")[0].replaceAll("[^0-9]", "")) + "";
					else
						wage = getSmallestWage(wageElem.ownText().split("〜")[0].replaceAll("[^0-9]", ""));
					LOGGER.info("wage = {}" + wage);

				} catch (NullPointerException ex) {
					wage = "";
					LOGGER.info("wage = {}" + wage);

				} catch (Exception e2) {
					wage = wageElem.ownText().split("〜")[0].replaceAll("[^0-9]", "");
				}
				/****************************
				 * Work Shifts
				 *******************************/
				try {
					Element shiftElem = docJobDetail.selectFirst("div.p-detail-content").select("dl.p-detail-table")
							.get(2).selectFirst("dd.p-detail-table-content").selectFirst("p");
					// shifts = getWorkShifts(shiftElem.ownText());
					String shift = shiftElem.ownText();
					String[] parts = shift.split(" ");
					String part1 = parts[0];

					DateFormat format = new SimpleDateFormat("hh:mm");
					try {
						startTime = dateFormat.parse(
								new Timestamp(format.parse(part1.split("分〜")[0].toString().replace("時", ":")).getTime())
										.toString().split(" ")[1]);

						finishTime = dateFormat.parse(
								new Timestamp(format.parse(part1.split("分〜")[1].toString().replace("時", ":")).getTime())
										.toString().split(" ")[1]);

						LOGGER.info("startTime {}" + startTime);
						LOGGER.info("finishTime {}" + finishTime);

					} catch (ParseException e) {
						// startTime = "00:00:00.0";
						// finishTime = "24:00:00.0";
						// System.out.println("startTime" + startTime);
						// System.out.println("finishTime" + finishTime);
						shiftElem = docJobDetail.selectFirst("div.p-detail-main-info").select("div.p-detail-content")
								.select("dl.p-detail-table").get(2).selectFirst("dd.p-detail-table-content")
								.selectFirst("p");
						LOGGER.info("shift : {}" + shiftElem.ownText());
						String start = StringUtils.substringBefore(shiftElem.ownText(), "〜");
						String end = StringUtils.substringAfter(shiftElem.ownText(), "〜");

						final String regex = "([0-2]?\\d)";

						final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
						final Matcher matcher = pattern.matcher(start);
						final Matcher matcher1 = pattern.matcher(end);

						List<String> listStartTime = new ArrayList<String>();
						List<String> listFinishTime = new ArrayList<String>();

						while (matcher.find()) {
							LOGGER.info("startTime: {}" + matcher.group(0));
							listStartTime.add(matcher.group(0));

						}
						while (matcher1.find()) {
							LOGGER.info("finishTime: " + matcher1.group(0));
							listFinishTime.add(matcher1.group(0));

						}

						try {
							startTime = dateFormat.parse(listStartTime.get(0) + ":00:00.0");
							finishTime = dateFormat.parse(listFinishTime.get(0) + ":00:00.0");
							LOGGER.info("start" + start);
							LOGGER.info("end" + end);
						} catch (ParseException e1) {
							e1.printStackTrace();
						}

					}

				} catch (NullPointerException ex) {
					LOGGER.error(ex.getMessage());
				}
				/****************************
				 * min working hours days Shifts
				 *******************************/
				try {
					Element shiftElem = docJobDetail.selectFirst("div.p-detail-content").select("dl.p-detail-table")
							.get(2).selectFirst("dd.p-detail-table-content").selectFirst("p");
					String shift = shiftElem.ownText();
					String[] parts = shift.split(" ");

					try {
						String part2 = parts[2];
						minHoursPerDay = part2.substring(part2.indexOf("日") + 1, part2.indexOf("時間"));
						LOGGER.info("minHoursPerDay" + minHoursPerDay);

					} catch (Exception e) {
						minHoursPerDay = "none";
					}

					try {
						String part3 = parts[3];
						minWorkingDays = part3.substring(part3.indexOf("週") + 1, part3.indexOf("日"));
						LOGGER.info("minWorkingDays" + minWorkingDays);

					} catch (Exception e) {
						minWorkingDays = "none";
					}

				} catch (NullPointerException ex) {

				}
				/*****************************
				 * Job Description
				 *******************************/
				try {

					Element jobDetailElem = docJobDetail.selectFirst("div.js-expand-target");
					jobDescription = jobDetailElem.ownText();
					LOGGER.info("jobDescription" + jobDescription);

				} catch (NullPointerException ex) {

					jobDescription = "";
				}
				/**************************** Transportation *******************************/
				try {
					Element jobTransportationElem = docJobDetail.selectFirst("div.p-detail-main-tag")
							.select("ul.p-detail-table-tags").select("li").get(0);
					transportation = jobTransportationElem.ownText().contains("支給");
					if (!jobTransportationElem.ownText().contains("支給")) {
						jobTransportationElem = docJobDetail.selectFirst("div.p-detail-main-tag")
								.select("ul.p-detail-table-tags").select("li").get(1);
						transportation = jobTransportationElem.ownText().contains("支給");

						if (!transportation) {
							jobTransportationElem = docJobDetail.selectFirst("div.p-detail-main-tag")
									.select("ul.p-detail-table-tags").select("li").get(2);
							transportation = jobTransportationElem.ownText().contains("支給");
							if (!transportation) {
								jobTransportationElem = docJobDetail.selectFirst("div.p-detail-main-tag")
										.select("ul.p-detail-table-tags").select("li").get(3);
								transportation = jobTransportationElem.ownText().contains("支給");
								if (!transportation) {
									try {
										jobTransportationElem = docJobDetail.selectFirst("div.p-detail-main-tag")
												.select("ul.p-detail-table-tags").select("li").get(4);
										transportation = jobTransportationElem.ownText().contains("支給");
										if (!transportation) {
											jobTransportationElem = docJobDetail.selectFirst("div.p-detail-main-tag")
													.select("ul.p-detail-table-tags").select("li").get(5);
											transportation = jobTransportationElem.ownText().contains("支給");
											LOGGER.info("transportation" + transportation);

										}
										LOGGER.info("transportation" + transportation);

									} catch (IndexOutOfBoundsException e) {
										LOGGER.error("ERROR {} " + transportation);
									}
								}
								LOGGER.info("transportation {} " + transportation);
							}
							LOGGER.info("transportation {} " + transportation);
						}
						LOGGER.info("transportation {} " + transportation);
					}

				} catch (NullPointerException ex) {
					LOGGER.error("ERROR {}" + ex.getMessage());
				}

				/****************************
				 * Street Address
				 *******************************/
				try {
					jobAddress = "";
					jobAddress = docJobDetail.select("dd.p-detail-table-content").get(4).select("div").get(1).ownText();
					LOGGER.info("jobAddress {}" + jobAddress);

				} catch (Exception ex) {
					jobAddress = docJobDetail.select("dl.p-detail-table-company").select("dd.p-detail-table-content")
							.select("div").get(1).ownText();
					LOGGER.info("jobAddress {}" + jobAddress);

				}
			} catch (IOException e1) {
				LOGGER.info(" {}" + e1.getMessage());
			}
			/****************************** END *********************************/
			save();

		}
	}

	@Override
	public void save() {
		if (startTime != null && finishTime != null && !jobAddress.equals("")) {
			jobDetail = new JobOtome(shopName, jobImgUrl, jobUrl, categoryName, jobDescription, positionName,
					jobAddress, wage, minHoursPerDay, minWorkingDays, startTime, finishTime, transportation);
			JsenInitializer.getInstance().getJobDetails().add(jobDetail);
		}
	}

	/**
	 * This method return smallest wage from collection of wages given
	 */
	private String getSmallestWage(String wage) {
		List<Integer> numbers = new ArrayList<>();
		String number = "";
		for (int i = 0; i < wage.length(); i++) {
			if (NumberUtils.isNumber(String.valueOf(wage.charAt(i)))) {
				number += wage.charAt(i);
			} else if (wage.charAt(i) != ',' && !number.equals("")) {
				numbers.add(Integer.parseInt(number));
				number = "";
			}
		}
		numbers.forEach((a) -> {
		});

		return String.valueOf(Collections.min(numbers));
	}
}
