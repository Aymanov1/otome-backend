package org.crawler.web.crawler;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import org.apache.commons.lang.math.NumberUtils;
import org.crawler.web.domain.LogEvents;
import org.crawler.web.enumeration.CrawlerTypesEnum;
import org.crawler.web.initializer.BaitoruInitializer;
import org.joda.time.LocalTime;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hrdatabank.otome.domain.JobOtome;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.parser.HtmlParseData;

/**
 * The Class BaitoruCrawler.
 * 
 * @author Hanios
 */
public class BaitoruCrawler extends AbstractCrawler {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory.getLogger(BaitoruCrawler.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.crawler.web.crawler.AbstractCralwer#visit(edu.uci.ics.crawler4j.crawler.
	 * Page)
	 */
	@Override
	public void visit(Page page) {
		String url = page.getWebURL().getURL();
		String domain = page.getWebURL().getDomain();
		categoryName = getCategoryNameFromUrl(url);

		if (page.getParseData() instanceof HtmlParseData) {
			HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
			String htmlContent = htmlParseData.getHtml();
			Document doc = Jsoup.parse(htmlContent);
			Elements elements = doc.select("article.list-jobListDetail");
			elements.forEach(e -> {
				/**************************** ImageUrl *******************************/
				imageURLExtractor(e);

				/**************************** JobUrl && JobId *******************************/

				Element jobLink = jobURLExtractor(e);
				/*************************** Crawling Job Details *****************************/
				try {
					Document docJobDetail = Jsoup.connect("https://www." + domain + jobLink.attr("href")).get();
					/**************************** JobType *******************************/
					jobTypeExtractor(url, docJobDetail);

					/********************* job detail id **********************/
					jobDetailIDExtractor(url, docJobDetail);
					/**************************** ShopName *******************************/
					shopNameExtractor(url, docJobDetail);
					/**************************** PositionName *******************************/
					positionNameExtractor(url, docJobDetail);
					/**************************** Wage *******************************/
					Element wageElem = null;
					wageExtractor(url, docJobDetail, wageElem);
					/**************************** Work Shifts *******************************/
					workShiftsExtractor(url, docJobDetail);
					/***************************** Job Description *******************************/
					jobDescriptionExtractor(url, docJobDetail);
					/**************************** Transportation *******************************/
					transportationExtractor(url, docJobDetail);
					/**************************** Street Address *******************************/
					streetAddressExtractor(url, docJobDetail);
				} catch (IOException e1) {
					logger.error("ERROR {}", e1);
				}
				/****************************** END *********************************/
				save();
			});
		}
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: BaitoruCrawler.java
	 * 
	 *         this method Transportation extractor.
	 * @param url
	 *            the url
	 * @param docJobDetail
	 *            the doc job detail
	 */
	private void transportationExtractor(String url, Document docJobDetail) {
		try {
			Element jobTransportationElem = docJobDetail.selectFirst("div.detail-recruitInfo").select("dl.dl06").first()
					.selectFirst("p");
			transportation = jobTransportationElem.ownText().contains("支給");
		} catch (NullPointerException ex) {
			BaitoruInitializer.getInstance().getLogExceptions()
					.add(new LogEvents("Job transportation does not exist in job url", jobUrl, url));
			logger.error("Job transportation does not exist in job url {}", jobUrl);
			transportation = false;
		}
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: BaitoruCrawler.java
	 * 
	 *         this method Job description extractor.
	 * @param url
	 *            the url
	 * @param docJobDetail
	 *            the doc job detail
	 */
	private void jobDescriptionExtractor(String url, Document docJobDetail) {
		try {
			Element jobDetailElem = docJobDetail.selectFirst("div.detail-recruitInfo").select("dl.dl01").first()
					.selectFirst("p");
			jobDescription = jobDetailElem.ownText();
		} catch (NullPointerException ex) {
			BaitoruInitializer.getInstance().getLogExceptions()
					.add(new LogEvents("Job description does not exist in job url", jobUrl, url));
			logger.error("Job description does not exist in job url {}", jobUrl);
			jobDescription = "";
		}
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: BaitoruCrawler.java
	 * 
	 *         this method Street address extractor.
	 * @param url
	 *            the url
	 * @param docJobDetail
	 *            the doc job detail
	 */
	private void streetAddressExtractor(String url, Document docJobDetail) {
		try {
			jobAddress = "";
			jobAddress = docJobDetail.selectFirst("div.detail-basicInfo").select("dl.dl04.js-detailAccordion")
					.select("dd").first().select("dl.js-da-target").select("dd").select("ul").select("li").first()
					.ownText();

		} catch (NullPointerException ex) {
			BaitoruInitializer.getInstance().getLogExceptions()
					.add(new LogEvents("Job address does not exist in job url", jobUrl, url));
			logger.error("Job Type does not exist in job url {}", jobUrl);
			jobAddress = "";
		}
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: BaitoruCrawler.java
	 * 
	 *         this method Work shifts extractor.
	 * @param url
	 *            the url
	 * @param docJobDetail
	 *            the doc job detail
	 */
	private void workShiftsExtractor(String url, Document docJobDetail) {
		try {
			Element shiftElem = docJobDetail.selectFirst("div.detail-basicInfo").select("dl.dl03").first()
					.selectFirst("em");
			shifts = getWorkShifts(shiftElem.ownText());
		} catch (NullPointerException ex) {
			BaitoruInitializer.getInstance().getLogExceptions()
					.add(new LogEvents("Job shift does not exist in job url", jobUrl, url));
			logger.error("Job shift does not exist in job url {}", jobUrl);
			shifts.clear();
		}
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: BaitoruCrawler.java
	 * 
	 *         this method Wage extractor.
	 * @param url
	 *            the url
	 * @param docJobDetail
	 *            the doc job detail
	 * @param wageElem
	 *            the wage elem
	 */
	private void wageExtractor(String url, Document docJobDetail, Element wageElem) {
		try {
			wageElem = docJobDetail.selectFirst("div.detail-basicInfo").select("dl.dl02").first().selectFirst("em");
			wage = getSmallestWage(wageElem.ownText());
		} catch (NullPointerException ex) {
			BaitoruInitializer.getInstance().getLogExceptions()
					.add(new LogEvents("Job wage elem does not exist in job url", jobUrl, url));
			logger.error("Job wage elem does not exist in job url {}", jobUrl);
			wage = "";
		} catch (Exception e2) {
			wage = wageElem.ownText();
		}
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: BaitoruCrawler.java
	 * 
	 *         this method Position name extractor.
	 * @param url
	 *            the url
	 * @param docJobDetail
	 *            the doc job detail
	 */
	private void positionNameExtractor(String url, Document docJobDetail) {
		try {
			Element positionNameElem = docJobDetail.selectFirst("div.detail-basicInfo").select("dl.dl01").first()
					.selectFirst("em");
			positionName = positionNameElem.ownText();
		} catch (NullPointerException ex) {
			BaitoruInitializer.getInstance().getLogExceptions()
					.add(new LogEvents("Job position name does not exist in job url", jobUrl, url));
			logger.error("Job position name does not exist in job url {}", jobUrl);
			positionName = "";
		}
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: BaitoruCrawler.java
	 * 
	 *         this method Shop name extractor.
	 * @param url
	 *            the url
	 * @param docJobDetail
	 *            the doc job detail
	 */
	private void shopNameExtractor(String url, Document docJobDetail) {
		try {
			Element shopNameElem = docJobDetail.selectFirst("div.detail-entryInfo").select("dl.dl01").first()
					.selectFirst("p");
			shopName = shopNameElem.ownText();
		} catch (NullPointerException ex) {
			BaitoruInitializer.getInstance().getLogExceptions()
					.add(new LogEvents("Job shop name does not exist in job url", jobUrl, url));
			logger.error("Job shop name does not exist in job url {}", jobUrl);
			shopName = "";
		}
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: BaitoruCrawler.java
	 * 
	 *         this method Job detail ID extractor.
	 * @param url
	 *            the url
	 * @param docJobDetail
	 *            the doc job detail
	 */
	private void jobDetailIDExtractor(String url, Document docJobDetail) {
		try {
			Element typeElem = docJobDetail.getElementById("link_job_entry_pc_detail_all_1").select("a").first();
			jobDetailId = typeElem.attr("href");
			jobDetailId = jobDetailId.substring(35, jobDetailId.length() - 1);
		} catch (NullPointerException ex) {
			BaitoruInitializer.getInstance().getLogExceptions()
					.add(new LogEvents("Job detail does not exist in job url", jobUrl, url));
			logger.error("Job detail does not exist in job url {}", jobUrl);
			jobDetailId = "";
		}
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: BaitoruCrawler.java
	 * 
	 *         this method Job type extractor.
	 * @param url
	 *            the url
	 * @param docJobDetail
	 *            the doc job detail
	 */
	private void jobTypeExtractor(String url, Document docJobDetail) {
		try {
			Element typeElem = docJobDetail.selectFirst("div.detail-basicInfo").select("dd").first()
					.selectFirst("span");
			if (typeElem.ownText().contains("正")) {
				jobType = typeElem.ownText();
			} else
				jobType = "";

		} catch (NullPointerException ex) {
			BaitoruInitializer.getInstance().getLogExceptions()
					.add(new LogEvents("Job image does not exist in job url", jobUrl, url));
			logger.error("Job image does not exist in job url {}", jobUrl);
			jobType = "";
		}
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: BaitoruCrawler.java
	 * 
	 *         Job URL extractor.
	 * @param e
	 *            the e
	 * @return the element
	 */
	private Element jobURLExtractor(Element e) {
		Element jobLink = e.select("a").first();
		jobUrl = jobLink.attr("href");
		jobId = getJobId(jobLink.attr("href"));
		return jobLink;
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: BaitoruCrawler.java
	 * 
	 *         this method Image URL extractor.
	 * @param e
	 *            the e
	 */
	private void imageURLExtractor(Element e) {
		try {
			jobImgUrl = "";
			Element Imagediv = e.selectFirst("p");
			System.out.println("Imagediv" + Imagediv);
			Element jobImg = Imagediv.select("img").first();
			String jobImgUrl1 = jobImg.attr("data-replaceimage");
			jobImgUrl = jobImgUrl1.replaceAll("//image-cdn.baitoru.com", "");

		} catch (NullPointerException ex) {
			logger.error("image url does not exist in job url {}", jobUrl);
			jobImgUrl = "";
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.crawler.web.crawler.AbstractCralwer#save()
	 */
	@Override
	public void save() {
		if (!shifts.isEmpty()) {
			startTime = shifts.get(0);
			finishTime = shifts.get(1);
			if (!jobType.contains("正")) {
				jobDetail = new JobOtome(shopName, jobImgUrl, jobId, jobUrl, jobType, jobDescription, positionName,
						jobAddress, wage, transportation, startTime, finishTime);
				jobDetail.setPositionCategoryEnglish(categoryName);
				jobDetail.setPositionCategoryJapanese(BaitoruInitializer.getInstance().getJobMap().get(categoryName));
				try {
					jobDetail.setLongitude(0.0);
					jobDetail.setLatitude(0.0);
					jobDetail.setAffiliateType(CrawlerTypesEnum.BAITORU.name());
					DateFormat dateFormat = new SimpleDateFormat("hh:mm");
					getWorkTimeEnWorkTimeJP(dateFormat.format(startTime), dateFormat.format(finishTime), jobDetail);
				} catch (ParseException e) {
					logger.error("ERROR {}", e);
				}
				logger.error("Job Adresss latitude langitude {}", jobDetail);

				BaitoruInitializer.getInstance().getJobDetails().add(jobDetail);
			}

		}
	}

	/**
	 * This method return jobId from a given url.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: BaitoruCrawler.java
	 * 
	 *         Gets the job id.
	 * @param url
	 *            the url
	 * @return the job id
	 */
	private String getJobId(String url) {

		int startIndex = url.indexOf("job");
		int endIndex = url.length();
		return url.substring(startIndex, endIndex - 1);
	}

	/**
	 * This method return smallest wage from collection of wages given.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: BaitoruCrawler.java
	 * 
	 *         Gets the smallest wage.
	 * @param wage
	 *            the wage
	 * @return the smallest wage
	 */
	private String getSmallestWage(String wage) {
		List<Integer> numbers = new ArrayList<>();
		String number = "";
		StringBuilder builder = new StringBuilder(number);
		for (int i = 0; i < wage.length(); i++) {
			if (NumberUtils.isNumber(String.valueOf(wage.charAt(i)))) {
				builder.append(wage.charAt(i));
			} else if (wage.charAt(i) != ',' && !builder.toString().equals("")) {
				numbers.add(Integer.parseInt(builder.toString()));
				builder = new StringBuilder(number);
			}
		}

		return String.valueOf(Collections.min(numbers));
	}

	/**
	 * This method return list of work shifts by providing shifts String.
	 *
	 * @author Hanios
	 * @param shiftString
	 *            the shift string
	 * @return list of {@link Date}s
	 */
	private List<Date> getWorkShifts(String shiftString) {
		List<Date> shiftTimes = new ArrayList<>();
		String shiftTime = "";
		StringBuilder builder = new StringBuilder(shiftTime);
		for (int i = 0; i < shiftString.length(); i++) {
			if (NumberUtils.isNumber(String.valueOf(shiftString.charAt(i)))) {
				builder.append(shiftString.charAt(i));
			} else if (shiftString.charAt(i) == ':') {
				builder.append(shiftString.charAt(i));
			} else if (shiftString.charAt(i) == '～' || shiftString.charAt(i) == '、') {
				shiftTimes.add(new LocalTime(builder.toString()).toDateTimeToday().toDate());
				builder = new StringBuilder(shiftTime);
			}
		}

		if (!builder.toString().equals(""))
			shiftTimes.add(new LocalTime(builder.toString()).toDateTimeToday().toDate());
		return shiftTimes;
	}

	/**
	 * This method return jobCategory from a given url.
	 *
	 * @author Hanios
	 * @param url
	 *            the url
	 * @return categorie of the url
	 */
	private String getCategoryNameFromUrl(String url) {
		return retrieveCategory(url);
	}

	/**
	 * This Method retrive the category from a provided url.
	 *
	 * @author Hanios
	 * @param url
	 *            the url
	 * @return categorie of the url
	 */
	private String retrieveCategory(String url) {
		HashMap<String, String> mapCategory = new HashMap<>();
		BaitoruInitializer.getInstance().initializeJobMap(mapCategory);
		List<String> result4 = mapCategory.values().stream().collect(Collectors.toList());
		url = url.replace("https://www.baitoru.com/", "");
		String[] afterJList = url.split("/");
		afterJList = Arrays.copyOfRange(afterJList, 1, afterJList.length);
		List<String> list = Arrays.asList(afterJList);
		AtomicReference<String> category = new AtomicReference<>("");
		result4.forEach(u -> list.forEach(e -> {
			if (e.trim().contains(u))
				category.set(u);
		}));
		return category.get();
	}

}