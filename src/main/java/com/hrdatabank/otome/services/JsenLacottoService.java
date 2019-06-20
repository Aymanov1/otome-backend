package com.hrdatabank.otome.services;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hrdatabank.otome.domain.Company;
import com.hrdatabank.otome.domain.Job;
import com.hrdatabank.otome.domain.Shop;
import com.hrdatabank.otome.repositories.JobRepository;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

@Service
public class JsenLacottoService {
	private static final Logger logger = LoggerFactory.getLogger(JsenLacottoService.class);

	private static final String SIX_OCLOCK = "06:00";
	private static final String SEVEN_OCLOCK = "07:00";
	private static final String TWELVE_OCLOCK = "12:00";
	private static final String TEN_OCLOCK_PM = "22:00";
	private static final String ONE_OCLOCK_PM = "13:00";
	private static final String MIDNIGHT_AM = "00:00";
	private static final String MIDNIGHT_PM = "24:00";
	private static final String HH_MM = "HH:mm";
	private static final String NIGHT_SHIFT = "Night Shift";
	private static final String BEFORE_SCHOOL = "Before School";
	private static final String AFTER_SCHOOL = "After School";
	private static final String BEFORESCHOOL_NIGHTSHIFT_AFTERSCHOOL_EN = "Before School and Night Shift and After School";
	private static final String BEFORESCHOOL_NIGHTSHIFT_AFTERSCHOOL_JP = "学校前 and 夜勤 and 学校後";
	private static final String NIGHT_SCHOOL = "Night School";

	@Autowired
	private JobService jobService;
	@Autowired
	private ShopService shopService;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private JobRepository jobRepository;

	/**
	 * 
	 * @author mahdi
	 * 
	 *         method to import jsen jobs from single csv file
	 * 
	 * @param filePath
	 *            path of the csv directory
	 * @throws IOException
	 * 
	 * 
	 */
	public long importJsenCSV(String fileName) throws IOException {

		long startTime = System.currentTimeMillis();
		long elapsedTime = 0;

		CSVParser csvParser = new CSVParserBuilder().withSeparator(',').build();

		CSVReader reader = new CSVReaderBuilder(new FileReader(fileName)).withCSVParser(csvParser).withSkipLines(1)
				.build();

		String[] nextLine = null;

		try {
			/******************************/
			Company company = companyService.findByNameCompany("テスト会社");
			if (company == null) {
				company = new Company();
				company.setPhoneNumber("03-6893-4086");
				company.setEmailCompany("apply_joboty@willgroup.co.jp");
				company.setNameCompany("テスト会社");
				company.setAddressCompany("東京都新宿区新宿三丁目1番24号 京王新宿三丁目ビル3階");
				company = new Company();// companyService.saveCompany(company);
			}
			/***********************/

			int savedJob = 0;
			int skippedJob = 0;
			int oldShop = 0;

			int numLine = 0;

			int reason_salary_type = 0;
			int reason_category_job = 0;
			int reason_start_finish_time = 0;
			int reason_job_url_null = 0;
			int reason_id_job_detail_null = 0;
			int reason_shop_null = 0;

			try (Writer writer = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream("/home/heni/Téléchargements/file.txt"), "utf-8"))) {
				writer.write("/*****************************************************************************/ \n");

				List<Job> listBatchJobs = new ArrayList<>();
				while ((nextLine = reader.readNext()) != null) {

					String reason_to_skip = "";
					if (nextLine != null) {
						numLine++;
						logger.info("*******************************************");

						reason_to_skip = reason_to_skip + numLine + " ---::";
						List<Job> listJobs = null;
						Job job = new Job();
						Shop shop = new Shop();
						boolean skipJob = false;

						String idJobDetail = nextLine[0];
						logger.info("-------------idJobDetail-----------------:" + idJobDetail);
						String shopName = nextLine[3];
						logger.info("---------------shopName---------------:" + shopName);
						String prefecture = nextLine[6];
						logger.info("-------------prefecture-----------------:" + prefecture);
						String addresse_2 = nextLine[9];
						logger.info("---------------addresse_2---------------:" + addresse_2);
						String addresse_3 = nextLine[10];
						logger.info("------------addresse_3------------------:" + addresse_3);
						String shopAddresse; // = {address_2}+{address_3}
						String latitude = nextLine[11];
						logger.info("-----------latitude-------------------:" + latitude);
						String longitude = nextLine[12];
						logger.info("-------------longitude-----------------:" + longitude);
						String jobTitle = nextLine[24];
						logger.info("------------jobTitle------------------:" + jobTitle);
						String jobDetail_1 = nextLine[25];
						logger.info("---------------jobDetail_1---------------:" + jobDetail_1);
						String voice = nextLine[27];
						logger.info("---------------voice---------------:" + voice);
						String jobDetail_2 = nextLine[30];
						logger.info("------------jobDetail_2------------------:" + jobDetail_2);
						String nearestStation = nextLine[14];
						logger.info("--------------nearestStation----------------:" + nearestStation);
						String jobDetail;
						String categoryCode = nextLine[28];
						logger.info("-------------categoryCode-----------------:" + categoryCode);
						String positionName = nextLine[29];
						logger.info("-------------positionName-----------------:" + positionName);
						String salaryType = nextLine[32];
						logger.info("------------salaryType------------------:" + salaryType);
						String hourlyWage = nextLine[33];
						logger.info("--------------hourlyWage----------------:" + hourlyWage);
						String workTime = nextLine[34];
						logger.info("--------------workTime----------------:" + workTime);
						String imageUrl = nextLine[96];
						logger.info("-----------imageUrl-------------------:" + imageUrl);
						String gladForeigner = nextLine[110];
						logger.info("-------------gladForeigner-----------------:" + gladForeigner);
						String jobUrl = nextLine[111];
						logger.info("------------jobUrl------------------:" + jobUrl);

						if (idJobDetail != null && !idJobDetail.equals("")) {

							job.setIdJobDetail(idJobDetail);
						}

						if (shopName != null && !shopName.equals("")) {
							shop.setNameShop(shopName);
						}

						shopAddresse = addresse_2 + " " + addresse_3;

						if (shopAddresse != null && !shopAddresse.equals("")) {
							shop.setAddressShop(shopAddresse);
						}

						if (latitude != null && !latitude.equals("")) {
							shop.setLatitude(Double.parseDouble(latitude));
						}

						if (longitude != null && !longitude.equals("")) {
							shop.setLongitude(Double.parseDouble(longitude));
						}

						jobDetail = "＜タイトル＞ \n" + jobTitle + "\n \n" + "＜概要＞ \n" + jobDetail_1 + "\n \n" + "＜仕事内容＞ \n"
								+ jobDetail_2 + "\n \n" + "＜アクセス＞ \n" + nearestStation + "\n \n" + "＜みんなの声・フリーアピール＞ \n"
								+ voice;

						if (jobDetail != null && !jobDetail.equals("")) {
							job.setJobDetails(jobDetail);
						}

						if (imageUrl != null && !imageUrl.equals("")) {
							job.setPictureJob(imageUrl);
						}

						if (prefecture != null && !prefecture.equals("")) {
							job.setPrefecture(prefecture);
						}

						if (positionName != null && !positionName.equals("")) {
							job.setPositionName(positionName);
						}

						if (salaryType == null || salaryType.equals("") || !salaryType.equals("時給")) {
							skipJob = true;
							reason_to_skip = reason_to_skip + "/" + "from salary type";
							reason_salary_type++;
						}

						if (gladForeigner == null || gladForeigner.equals("") || !gladForeigner.equals("1")) {
							job.setAffiliateType("j-sen");
						} else if (gladForeigner.equals("1")) {
							job.setAffiliateType("j-sen(special)");
						}

						logger.info("*****categoryCode********** " + categoryCode);

						if (categoryCode != null && !categoryCode.equals("")) {
							String positionCategoryEnglish = "";
							String positionCategoryJapanese = "";

							if (categoryCode.equals("46") || categoryCode.equals("47") || categoryCode.equals("1")
									|| categoryCode.equals("2") || categoryCode.equals("3") || categoryCode.equals("4")
									|| categoryCode.equals("5") || categoryCode.equals("6") || categoryCode.equals("7")
									|| categoryCode.equals("8") || categoryCode.equals("9") || categoryCode.equals("10")
									|| categoryCode.equals("11") || categoryCode.equals("12")
									|| categoryCode.equals("13") || categoryCode.equals("14")
									|| categoryCode.equals("15") || categoryCode.equals("16")
									|| categoryCode.equals("17") || categoryCode.equals("18")
									|| categoryCode.equals("19") || categoryCode.equals("20")
									|| categoryCode.equals("21") || categoryCode.equals("128")
									|| categoryCode.equals("129")) {
								positionCategoryEnglish = "Other type";
								positionCategoryJapanese = "その他";

								job.setPositionCategoryEnglish(positionCategoryEnglish);
								job.setPositionCategoryJapanese(positionCategoryJapanese);
							} else if (categoryCode.equals("69") || categoryCode.equals("70")
									|| categoryCode.equals("71") || categoryCode.equals("72")
									|| categoryCode.equals("73") || categoryCode.equals("74")
									|| categoryCode.equals("75") || categoryCode.equals("76")
									|| categoryCode.equals("77") || categoryCode.equals("78")
									|| categoryCode.equals("79") || categoryCode.equals("80")
									|| categoryCode.equals("81") || categoryCode.equals("82")
									|| categoryCode.equals("83") || categoryCode.equals("84")
									|| categoryCode.equals("85") || categoryCode.equals("86")
									|| categoryCode.equals("87") || categoryCode.equals("88")
									|| categoryCode.equals("89") || categoryCode.equals("90")
									|| categoryCode.equals("91") || categoryCode.equals("92")
									|| categoryCode.equals("93") || categoryCode.equals("94")
									|| categoryCode.equals("95") || categoryCode.equals("96")
									|| categoryCode.equals("97") || categoryCode.equals("98")
									|| categoryCode.equals("99")) {
								positionCategoryEnglish = "Restaurant";
								positionCategoryJapanese = "レストラン";

								job.setPositionCategoryEnglish(positionCategoryEnglish);
								job.setPositionCategoryJapanese(positionCategoryJapanese);
							} else if (categoryCode.equals("100") || categoryCode.equals("101")
									|| categoryCode.equals("102") || categoryCode.equals("103")) {
								positionCategoryEnglish = "Store";
								positionCategoryJapanese = "スーパー/コンビニ";

								job.setPositionCategoryEnglish(positionCategoryEnglish);
								job.setPositionCategoryJapanese(positionCategoryJapanese);
							} else if (categoryCode.equals("131") || categoryCode.equals("155")) {
								positionCategoryEnglish = "Cleaning";
								positionCategoryJapanese = "そうじ";

								job.setPositionCategoryEnglish(positionCategoryEnglish);
								job.setPositionCategoryJapanese(positionCategoryJapanese);
							} else if (categoryCode.equals("141") || categoryCode.equals("142")
									|| categoryCode.equals("150") || categoryCode.equals("151")
									|| categoryCode.equals("139") || categoryCode.equals("140")
									|| categoryCode.equals("156") || categoryCode.equals("157")
									|| categoryCode.equals("158") || categoryCode.equals("159")
									|| categoryCode.equals("160") || categoryCode.equals("161")
									|| categoryCode.equals("162") || categoryCode.equals("163")
									|| categoryCode.equals("164") || categoryCode.equals("165")
									|| categoryCode.equals("166")) {
								positionCategoryEnglish = "Factory";
								positionCategoryJapanese = "工場こうじょう";

								job.setPositionCategoryEnglish(positionCategoryEnglish);
								job.setPositionCategoryJapanese(positionCategoryJapanese);
							} else if (categoryCode.equals("171") || categoryCode.equals("172")
									|| categoryCode.equals("173")) {
								positionCategoryEnglish = "Health Care";
								positionCategoryJapanese = "介護かいご";

								job.setPositionCategoryEnglish(positionCategoryEnglish);
								job.setPositionCategoryJapanese(positionCategoryJapanese);
							} else {
								skipJob = true;
								reason_to_skip = reason_to_skip + "/" + "from category job 1 --> num category: "
										+ categoryCode;
								reason_category_job++;
							}

						} else {
							skipJob = true;
							reason_to_skip = reason_to_skip + "/" + "from category job 2 --> num category : "
									+ categoryCode;
							reason_category_job++;
						}

						// if (!skipJob) {
						// job.setPositionCategoryEnglish(positionCategoryEnglish);
						// job.setPositionCategoryJapanese(positionCategoryJapanese);
						// }

						Pattern pattern = Pattern.compile("([0-9]+)(時)([0-9]+)");
						Matcher m = pattern.matcher(workTime);
						Matcher m_2 = pattern.matcher(workTime);
						int i = 0;
						String startWorkingTime = "";
						String finishWorkingTime = "";

						while (m.find()) {
							logger.info("********** Found **********");
							if (i == 0) {
								logger.info("Condition 1111111");
								startWorkingTime = m.group(1) + ":" + m.group(3);
							} else if (i == 1) {
								logger.info("Condition 2222222");
								finishWorkingTime = m.group(1) + ":" + m.group(3);
							}
							i++;

						}

						if (!m_2.find()) {
							logger.info("Not Found 000000000000");
							startWorkingTime = "00:00";
							finishWorkingTime = "23:59";
						}

						DateFormat formatter = new SimpleDateFormat(HH_MM);
						if (!startWorkingTime.equals("") && !finishWorkingTime.equals("")) {

							Date startWorkingTimeDate = formatter.parse(startWorkingTime);
							Date finishWorkingTimeDate = formatter.parse(finishWorkingTime);

							if (startWorkingTimeDate != null && finishWorkingTimeDate != null) {
								job.setStartWorkingTime(startWorkingTimeDate);
								job.setFinishWorkingTime(finishWorkingTimeDate);
							}

							job = setWorkTimeEnglishJapanese(job, startWorkingTime, finishWorkingTime);

						} else {
							skipJob = true;
							reason_to_skip = reason_to_skip + "/" + "from start and finish time";
							reason_start_finish_time++;
						}

						if (!hourlyWage.equals("") && hourlyWage != null) {
							job.setHourlyWage(Double.parseDouble(hourlyWage));
						}

						if (!jobUrl.equals("") && jobUrl != null) {
							job.setJobURL(jobUrl);
						} else {
							skipJob = true;
							reason_to_skip = reason_to_skip + "/" + "from jobUrl is null";
							reason_job_url_null++;
						}

						if (idJobDetail == null) {
							skipJob = true;
							reason_to_skip = reason_to_skip + "/" + "from idJobDetail is null";
							reason_id_job_detail_null++;
						} else {
							listJobs = jobService.getCheckedJsenJobsByIdJobDetail(idJobDetail);

							if (!listJobs.isEmpty() && !skipJob) {

								Job checkedJob = listJobs.get(0);

								checkedJob.setAffiliateType(job.getAffiliateType());
								checkedJob.setJobDetails(job.getJobDetails());
								checkedJob.setPictureJob(job.getPictureJob());
								checkedJob.setPrefecture(job.getPrefecture());
								checkedJob.setPositionName(job.getPositionName());

								checkedJob.setPositionCategoryEnglish(job.getPositionCategoryEnglish());
								checkedJob.setPositionCategoryJapanese(job.getPositionCategoryJapanese());
								checkedJob.setStartWorkingTime(job.getStartWorkingTime());
								checkedJob.setFinishWorkingTime(job.getFinishWorkingTime());

								checkedJob.setWorkTimeEnglish(job.getWorkTimeEnglish());
								checkedJob.setWorkTimeJapanese(job.getWorkTimeJapanese());

								checkedJob.setHourlyWage(job.getHourlyWage());
								checkedJob.setJobURL(job.getJobURL());

								job = checkedJob;
							}
						}
						/*********************/
						// テスト会社

						/****************************/
						if (shopName != "" && shopAddresse != "") {

							// List<Shop> shops =
							shopService.findListShopByNameShopAndByAddress(shopName, shopAddresse);
							List<Shop> shops = shopService.findListShopByNameShopAndByAddress(shopName, shopAddresse);

							if (!shops.isEmpty()) {

								shop = shops.get(0);
								oldShop++;
								logger.info("An old shop : " + shop.getNameShop());
							}
						} else {
							skipJob = true;
							reason_to_skip = reason_to_skip + "/" + "from shop is null" + "/n";
							reason_shop_null++;
						}

						if (!skipJob) {
							savedJob++;
							shop = shopService.saveShop(shop);
							job.setShop(shop);
							/***** DEFAULTS PARAMS **************************/
							job.setJobType("short");
							job.setNumberStaffNeeded(0);
							job.setInterviewType("affiliate");
							job.setStatus(true);
							job.setCasePrice("0");

							listBatchJobs.add(job);

							logger.info("*******************************************");
							logger.info(" ****** Saved job : " + job.getIdJobDetail() + " ****** Total of Saved jobs :"
									+ savedJob);

							logger.info("*******************************************");

						} else {

							skippedJob++;
							logger.info(" ****** Skipped job : " + job.getIdJobDetail()
									+ " ****** Total of Skipped jobs :" + skippedJob);
							logger.info("Reason of Skipping job : " + reason_to_skip);
							logger.info("Percentage of reasons : ");
							writer.write(reason_to_skip + "\n");

						}
					}
				}

				jobRepository.saveAll(listBatchJobs);
				listBatchJobs = null;
				long stopTime = System.currentTimeMillis();
				elapsedTime = stopTime - startTime;
				System.out.println("*******elapsedTime********* " + elapsedTime + " ********elapsedTime******** ");

			}

			logger.info("----TOTAL---------Lines jobs-------------------:" + numLine);
			logger.info("----TOTAL----------Skipped job-------------------:" + skippedJob);
			logger.info("----TOTAL----------Saved job-------------------:" + savedJob + "\n");

			logger.info("*****************reason_category_job_frequence*********** " + reason_category_job + "\n");
			logger.info("*****************reason_id_job_detail_null_frequence*********** " + reason_id_job_detail_null
					+ "\n");
			logger.info("*****************reason_job_url_null_frequence*********** " + reason_job_url_null + "\n");
			logger.info("*****************reason_salary_type_frequence*********** " + reason_salary_type + "\n");
			logger.info("*****************reason_shop_null_frequence*********** " + reason_shop_null + "\n");
			logger.info("*****************reason_start_finish_time*********** " + reason_start_finish_time + "\n");

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		reader.close();

		return elapsedTime;

	}

	public String convertFullWidthToHalfWidth(String str) {
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

	/**
	 * 
	 * @param job
	 * @param startWorkingTime
	 * @param finishWorkingTime
	 * @return
	 * @throws ParseException
	 */
	public Job setWorkTimeEnglishJapanese(Job job, String startWorkingTime, String finishWorkingTime)
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

	/********************/
	public boolean checkJobsURL(String jobURL) throws IOException {
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

	public void importCSVForLacottoJobsWithOpenCsv(String fileName) throws IOException {

		// CSVReader reader = new CSVReader(new FileReader(fileName));
		CSVParser csvParser = new CSVParserBuilder().withSeparator(',').build();

		CSVReader reader = new CSVReaderBuilder(new FileReader(fileName)).withCSVParser(csvParser).withSkipLines(1)
				.build();
		String[] nextLine = null;

		System.out.println("-------------fileName----------------------:" + fileName);

		int i = 0;
		/************************/

		Job job = new Job();
		Shop shop = new Shop();
		int oldShop = 0;
		DateFormat formatter = new SimpleDateFormat(HH_MM);
		String jobDetail = "";
		String shopName = "";
		String addressShop = null;
		boolean skipJob = false;
		int skippedJobs = 0;
		int savedJobs = 0;
		int j = 0;
		List<String> urlExpired = new ArrayList<String>();
		List<String> urlNOTExpired = new ArrayList<String>();
		List<Integer> numberOfRowsSkipped = new ArrayList<Integer>();
		List<String> reasonOfRowsSkipped = new ArrayList<String>();

		List<Integer> numberOfRowsSaved = new ArrayList<Integer>();

		int nb_skipOccupationCodeNotFound = 0;
		int nb_skipOccupationCodeNull = 0;
		int nb_skipOccupationCodeException = 0;
		int nb_skipIdEmploymentNotFound = 0;
		int nb_skipIdEmploymentEmpty = 0;
		int nb_skipIdEmploymentException = 0;
		int nb_skipHourlyWageNotFound = 0;
		int nb_skipHourlyWageException = 0;
		int nb_skipSalaryTypeId_1 = 0;
		int nb_skipSalaryTypeIdException = 0;
		int nb_skipLongitudeAndLatitudeNull = 0;
		int nb_skipLongitudeAndLatitudeException = 0;
		int nb_skipAddressShopNull = 0;
		int nb_skipLongitudeOrLatitudeNull = 0;
		int nb_skipColumnAddressNull = 0;
		int nb_skipAddressException = 0;
		int nb_skipWorkTimeNull = 0;
		int nb_skipStartOrFinishTimeNull = 0;
		int nb_skipStartAndFinishTimeException_1 = 0;
		int nb_skipStartAndFinishTimeException_2 = 0;
		int nb_skipIdJobDetailNull = 0;
		int nb_skipJobExpired = 0;
		int nb_skipUrlNull = 0;
		int nb_skipShopNameOrAddressShopNull = 0;
		/*******************************************/
		Company company = companyService.findByNameCompany("テスト会社");
		if (company == null) {
			company = new Company();
			company.setPhoneNumber("03-6893-4086");
			company.setEmailCompany("apply_joboty@willgroup.co.jp");
			company.setNameCompany("テスト会社");
			company.setAddressCompany("東京都新宿区新宿三丁目1番24号 京王新宿三丁目ビル3階");
			company = companyService.saveCompany(company);
		}

		String reason_to_skip = "Log investigation skip \n\n";
		/******************************************/

		List<Job> listBatchJobs = new ArrayList<>();

		while ((nextLine = reader.readNext()) != null) {

			i++;

			if (nextLine[0] != null && !nextLine[0].equals("")) {

				try {
					jobDetail = nextLine[0];
					logger.info("-----------jobDetail----0------------:{}", nextLine[0]);
				} catch (Exception e) {
					logger.info("------************CATCH***0***********---------------");
					e.printStackTrace();
				}
			}

			if (nextLine[1] != null && !nextLine[1].equals("")) {

				try {
					logger.info("-----------occupation_ids----------------:{} aaaaaaaaa", nextLine[1]);
					String occupationIds = nextLine[1];
					occupationIds = convertFullWidthToHalfWidth(occupationIds);
					if (occupationIds.contains("[") && occupationIds.contains("]")) {
						occupationIds = occupationIds.substring(1, occupationIds.length() - 1);
						logger.info("-----------occupationIds----------------:{} bbbbbbbbb", occupationIds);
					}

					String[] tempArray = null;
					if (occupationIds.length() != 0) {

						if (occupationIds.contains(",")) {

							/* delimiter */
							String delimiter = ",";

							/* given string will be split by the argument delimiter provided. */
							tempArray = occupationIds.split(delimiter);

						} else {
							tempArray = new String[1];
							tempArray[0] = occupationIds;
						}
					}
					String positionCategoryEnglish = null;
					String positionCategoryJapanese = null;
					String positionName = null;
					/* print substrings */
					int occupationCode = 0;
					for (int z = 0; z < tempArray.length; z++) {
						logger.info(tempArray[z] + "zzzzzzzzzzz");
						String occupationIdString = tempArray[z];
						if (occupationIdString.contains(" ")) {
							occupationIdString = occupationIdString.replace(" ", "");
						}
						logger.info("*********occupationIdString************  cccccccccccc : " + occupationIdString);
						int occupationId = Integer.parseInt(occupationIdString);
						logger.info("*********occupationId************  dddddddddddd : " + occupationId);

						if (occupationId == 1 || occupationId == 2 || occupationId == 3 || occupationId == 4
								|| occupationId == 5 || occupationId == 6 || occupationId == 8) {
							//
							logger.info("-----------food----------------:{}", occupationId);
							if (occupationId == 1) {
								positionName = "レストラン";
							}
							if (occupationId == 2) {
								positionName = "ファーストフード";
							}
							if (occupationId == 3) {
								positionName = "カフェ";
							}
							if (occupationId == 4) {
								positionName = "居酒屋・バー";
							}
							if (occupationId == 5) {
								positionName = "キッチン";
							}
							if (occupationId == 6) {
								positionName = "デリバリー";
							}
							if (occupationId == 8) {
								positionName = "フード系その他";
							}
							positionCategoryEnglish = "Restaurant";
							positionCategoryJapanese = "レストラン";
							logger.info("----------------break----occupationId-------------:{}", occupationId);
							break;
						} else if (occupationId == 10) {
							logger.info("-----------store----------------:{}", occupationId);
							// store
							positionName = "コンビニ";
							positionCategoryEnglish = "Store";
							positionCategoryJapanese = "スーパー/コンビニ";
							logger.info("----------------break----occupationId-------------:{}", occupationId);
							break;
						} else if (occupationId == 31) {
							logger.info("-----------cleaning----------------:{}", occupationId);
							// cleaning
							positionName = "清掃・ハウスクリーニング";
							positionCategoryEnglish = "Cleaning";
							positionCategoryJapanese = "そうじ";
							logger.info("----------------break----occupationId-------------:{}", occupationId);
							break;
						} else if (occupationId == 69 || occupationId == 72 || occupationId == 77 || occupationId == 78
								|| occupationId == 79) {
							logger.info("-----------factory----------------:{}", occupationId);
							// factory
							if (occupationId == 69) {
								positionName = "倉庫作業";
							}
							if (occupationId == 72) {
								positionName = "仕分け・梱包・在庫管理";
							}
							if (occupationId == 77) {
								positionName = "製造スタッフ";
							}
							if (occupationId == 78) {
								positionName = "組立・組み付け・加工";
							}
							if (occupationId == 79) {
								positionName = "食品製造スタッフ";
							}
							positionCategoryEnglish = "Factory";
							positionCategoryJapanese = "工場こうじょう";
							logger.info("----------------break----occupationId-------------:{}", occupationId);
							break;
						} else if (occupationId == 22 || occupationId == 124 || occupationId == 126) {
							logger.info("-----------Other type----------------:{}", occupationId);
							// others
							/*******************************************/
							if (occupationId == 22) {
								positionName = "モデル・エキストラ";
							}
							if (occupationId == 124) {
								positionName = "美容師アシスタント";
							}
							if (occupationId == 126) {
								positionName = "美容部員・ビューティアドバイザー";
							}

							/*****************************************/
							positionCategoryEnglish = "Other type";
							positionCategoryJapanese = "その他";
							logger.info("----------------break----occupationId-------------:{}", occupationId);
							occupationCode = occupationId;
							break;
						}

					}

					if (positionCategoryEnglish != null && positionCategoryJapanese != null && positionName != null) {
						job.setPositionCategoryEnglish(positionCategoryEnglish);
						job.setPositionCategoryJapanese(positionCategoryJapanese);
						job.setPositionName(positionName);

					} else {
						skipJob = true;
						logger.info("--SKIP BECAUSE OF--------occupationId---1-------:{}", skipJob);
						reason_to_skip += " // occupationId---1 ::: occupation code --> " + occupationCode;
						nb_skipOccupationCodeNotFound++;
						reasonOfRowsSkipped.add("Line number: " + i + "------occupationId--");
					}

				} catch (Exception e) {
					skipJob = true;
					logger.info("--CATCH------SKIP BECAUSE OF--------occupationId----2-------------");
					reason_to_skip += " // occupationId---1 ::: occupation code --> catch exception ";
					nb_skipOccupationCodeException++;
					reasonOfRowsSkipped.add("Line number: " + i + "------catch in occupationId");
					e.printStackTrace();
				}
			} else {
				skipJob = true;
				logger.info("---SKIP BECAUSE OF--------occupationId-----2-----------:{}", skipJob);
				reason_to_skip += " // occupationId---1 ::: occupation code --> null ";
				nb_skipOccupationCodeNull++;
				reasonOfRowsSkipped.add("Line number: " + i + "------nextLine null in occupationId");
			}

			if (nextLine[2] != null && !nextLine[2].equals("")) {
				/***************************************************************/
				try {

					String employmentTypeIds = nextLine[2];
					employmentTypeIds = convertFullWidthToHalfWidth(employmentTypeIds);

					if (employmentTypeIds.contains("[") && employmentTypeIds.contains("]")) {
						employmentTypeIds = employmentTypeIds.substring(1, employmentTypeIds.length() - 1);
					}
					String[] tempArray = null;
					logger.info("------------------------employmentTypeIds---------------------------------:{}",
							employmentTypeIds);
					employmentTypeIds = employmentTypeIds.replaceAll("\\s+", "");
					if (employmentTypeIds.length() != 0) {

						if (employmentTypeIds.contains(",")) {
							String delimiter = ",";
							tempArray = employmentTypeIds.split(delimiter);

						} else {
							tempArray = new String[1];
							tempArray[0] = employmentTypeIds;
						}

						logger.info("------------------------tempArray.length---------------------------------:{}",
								tempArray.length);
						boolean threeOrFourOrEmptyFound = false;
						for (int z = 0; z < tempArray.length; z++) {
							logger.info(tempArray[z]);
							String id = tempArray[z];
							if (id.contains(" ")) {
								id = id.replace(" ", "");
							}
							int idEmploy = Integer.parseInt(id);
							if (idEmploy == 3) {
								threeOrFourOrEmptyFound = true;
							}
							if (idEmploy == 4) {
								threeOrFourOrEmptyFound = true;
							}
						}
						logger.info("----idEmployment--------threeOrFourOrEmptyFound--------:{}",
								threeOrFourOrEmptyFound);
						if (!threeOrFourOrEmptyFound) {
							skipJob = true;
							// int lineSkipped = roundUp(i / 20) + 1;
							reason_to_skip += " // idEmployment 3 not found";
							nb_skipIdEmploymentNotFound++;
							reasonOfRowsSkipped.add("Line number: " + i + "------idEmployment 3/4 not found");
							logger.info("-----SKIP BECAUSE OF--------idEmployment------:{}", skipJob);
						}

					}
					/****************************************************************************/

				} catch (Exception e) {
					skipJob = true;
					logger.info("----******CATCH***---SKIP BECAUSE OF--------idEmployment------");
					reason_to_skip += " //  idEmployment";
					nb_skipIdEmploymentException++;
					reasonOfRowsSkipped.add("Line number: " + i + "------catch idEmployment");
					e.printStackTrace();
				}
			}
			if (nextLine[3] != null && !nextLine[3].equals("")) {
				try {
					/************************************************/

					String jobFeatureIds = nextLine[3];
					jobFeatureIds = convertFullWidthToHalfWidth(jobFeatureIds);

					logger.info("-----------jobFeatureIds----------------:{}", jobFeatureIds);
					if (jobFeatureIds.contains("[") && jobFeatureIds.contains("]")) {
						jobFeatureIds = jobFeatureIds.substring(1, jobFeatureIds.length() - 1);
					}
					String[] tempArray = null;
					if (jobFeatureIds.length() != 0) {

						if (jobFeatureIds.contains(",")) {
							String delimiter = ",";
							tempArray = jobFeatureIds.split(delimiter);

						} else {
							tempArray = new String[1];
							tempArray[0] = jobFeatureIds;
						}
					}

					boolean oneFound = false;
					if (tempArray != null) {
						for (int z = 0; z < tempArray.length; z++) {
							String id = tempArray[z];
							if (id.contains(" ")) {
								id = id.replace(" ", "");
							}
							int idFeature = Integer.parseInt(id);
							if (idFeature == 1) {
								oneFound = true;
							}
						}
					}
					if (oneFound) {
						shop.setTransportationAllowance(true);
					} else {
						shop.setTransportationAllowance(false);
					}
					logger.info("-----------jobFeatureIds-----oneFound-----------:{}", oneFound);

				} catch (Exception e) {
					logger.info("------************CATCH****TRANSPORTATION*************---------------");
					e.printStackTrace();
				}
			}
			if (nextLine[4] != null && !nextLine[4].equals("") && !skipJob) {
				try {
					logger.info("------************try***4***********---------------", nextLine[5]);
				} catch (Exception e) {
					logger.info("------************CATCH***4***********---------------");
					e.printStackTrace();
				}
			}
			if (nextLine[5] != null && !nextLine[5].equals("") && !skipJob) {
				try {
					logger.info("------************try***5***********---------------", nextLine[6]);
				} catch (Exception e) {
					logger.info("------************CATCH***5***********---------------");
					e.printStackTrace();
				}
			}
			if (nextLine[6] != null && !nextLine[6].equals("") && !skipJob) {
				try {
					shopName = nextLine[6];
					logger.info("-----------shopName--NEW--1------------:{}", shopName);
				} catch (Exception e) {
					logger.info("------************CATCH***6***********---------------");
					e.printStackTrace();
				}

			}
			if (nextLine[7] != null && !nextLine[7].equals("") && !skipJob) {
				try {
					shopName = nextLine[7];
					logger.info("-----------shopName--NEW--2------------:{}", shopName);
				} catch (Exception e) {
					logger.info("------************CATCH***7***********---------------");
					e.printStackTrace();
				}

			}
			if (nextLine[8] != null && !nextLine[8].equals("") && !skipJob) {
				try {
					jobDetail = nextLine[8];
					logger.info("-----------jobDetail---PART 2--2-----------:{}", jobDetail);
				} catch (Exception e) {
					logger.info("------************CATCH***8***********---------------");
					e.printStackTrace();
				}

			}

			if (nextLine[9] != null && !nextLine[9].equals("") && !skipJob) {
				try {
					logger.info("------************try***9***********---------------", nextLine[9]);
				} catch (Exception e) {
					logger.info("------************CATCH***9***********---------------");
					e.printStackTrace();
				}
			}

			if (nextLine[10] != null && !nextLine[10].equals("")) {
				// salary //11 ******************* {hourly_wage}
				/**************************** Wage *******************************/
				try {

					String str = nextLine[10];
					str = convertFullWidthToHalfWidth(str);
					str = str.replace(",", "");

					logger.info("----*************-----hourly_wage--***************--------:{}", str);

					// str = str.replaceAll("[^-?0-9]+", " ");
					// logger.info(Arrays.asList(str.trim().split(" ")));
					// logger.info(Arrays.asList(str.trim().split(" ")).get(0));
					// List<String> listofWage = Arrays.asList(str.trim().split(" "));
					// List<Integer> listofWageInteger = new ArrayList<Integer>();
					// for (String s : listofWage)
					// listofWageInteger.add(Integer.valueOf(s));
					// findMinMax(listofWageInteger);
					String regex = "\\d+";
					// compiling regex
					Pattern p = Pattern.compile(regex);
					// Matcher object
					Matcher m = p.matcher(str);
					// initialize MAX = 0
					BigInteger Min = BigInteger.valueOf(2000);
					boolean hourlyWageFound = false;
					// loop over matcher
					while (m.find()) {
						// convert numeric string to BigIntegr
						BigInteger num = new BigInteger(m.group());
						System.out.println("-------------num----------------:" + num);
						// compare num with MAX, update MAX if num > MAX
						if ((num.compareTo(Min) <= 0) && (num.intValue() >= 780)) {
							hourlyWageFound = true;
							Min = num;
							System.out.println("----------Min--------------:" + Min);
						}

					}

					logger.info("-----HourlyWage---hourlyWageFound---***********************---------------:{}",
							hourlyWageFound);
					if (hourlyWageFound) {
						job.setHourlyWage((double) Min.intValue());
						logger.info("-----HourlyWage------(double) Min.intValue()----------------:{}",
								job.getHourlyWage());
					} else {
						skipJob = true;

						reason_to_skip += " // hourlyWage not found";
						nb_skipHourlyWageNotFound++;
						reasonOfRowsSkipped.add("Line number: " + i + "------hourlyWage not found");

						logger.info("-----SKIP BECAUSE OF-------hourlyWage--not---Found----:{}", skipJob);
					}
				} catch (Exception ex) {
					skipJob = true;
					reason_to_skip += " // catch hourlyWage Exception";
					nb_skipHourlyWageException++;
					reasonOfRowsSkipped.add("Line number: " + i + "------catch hourlyWage");
					logger.info("--CATCH---SKIP BECAUSE OF-------hourlyWage---------:{}", ex);
					ex.printStackTrace();
				}

			}
			if (nextLine[11] != null && !nextLine[11].equals("")) {
				// salary_type_id //12 ************only import if it is "1"
				try {

					String salaryTypeId = nextLine[11];
					salaryTypeId = convertFullWidthToHalfWidth(salaryTypeId);
					logger.info("-----------salaryTypeId----------------:{}", salaryTypeId);
					if (!salaryTypeId.contains("1")) {
						skipJob = true;

						reason_to_skip += " // salaryTypeId not contain 1 ";
						nb_skipSalaryTypeId_1++;
						reasonOfRowsSkipped.add("Line number: " + i + "------salaryTypeId not contain 1");

						logger.info("-----SKIP BECAUSE OF-------salaryTypeId--not--contain---1---:{}", skipJob);
					}

				} catch (Exception e) {
					skipJob = true;
					reason_to_skip += " // catch salaryTypeId Exception";
					nb_skipSalaryTypeIdException++;
					reasonOfRowsSkipped.add("Line number: " + i + "------catch salaryTypeId");
					logger.info("-*************CATCH****----SKIP BECAUSE OF---salaryTypeId----:{}", skipJob);
					e.printStackTrace();
				}
			}

			if (nextLine[12] != null && !nextLine[12].equals("") && !skipJob) {
				try {
					// AREA : there is some treatment
					// Word after "【勤務地】" → put to {shop_address}
					// Word after "【面接地／登録地】" → put to {interview_venue}

					logger.info("-----all-----address----AAAAAAAAAAAAAAAAA-------:{}", nextLine[12]);
					String addressToFound = nextLine[12];
					addressToFound = addressToFound.replace("\n", "").replace("\r", "");
					logger.info("-----all-----address----ZZZZZZZZZZZZZZ-------:{}", addressToFound);
					if (addressToFound.contains("【勤務地】")) {
						/* delimiter */
						String delimiterAddress = "【勤務地】";
						String[] addrs = addressToFound.split(delimiterAddress);
						String add = addrs[1];
						logger.info("----------add-----------:{}", add);
						if (add.contains("【面接地／登録地】")) {
							String delimiterInterVenue = "【面接地／登録地】";
							String[] addrsInterVenue = add.split(delimiterInterVenue);
							String addShop = addrsInterVenue[0];
							String interviewVenueShop = addrsInterVenue[1];
							logger.info("----------addShop-----------:{}", addShop);
							logger.info("----------interviewVenueShop-----------:{}", interviewVenueShop);
							if (addShop.endsWith("\"")) {
								addShop = addShop.substring(0, addShop.length() - 1);
							}
							shop.setAddressShop(addShop);
							shop.setInterviewVenue(interviewVenueShop);
							addressShop = addShop;
						} else {
							if (add.endsWith("\"")) {
								add = add.substring(0, add.length() - 1);
							}
							shop.setAddressShop(add);
							addressShop = add;
						}

					} else {
						if (addressToFound.contains("【面接地／登録地】")) {
							addressToFound = addressToFound.replace("【面接地／登録地】", "");
						}
						if (addressToFound.endsWith("\"")) {
							addressToFound = addressToFound.substring(0, addressToFound.length() - 1);
						}
						addressShop = addressToFound;

						shop.setAddressShop(addressShop);

					}

					if (addressShop != null) {
						try {
							logger.info("-----------AddressShop----------------:{}", addressShop);
							// List<Shop> shopsByAddress = shopService.findListShopByAddress(addressShop);
							List<Shop> shopsByAddress = null;
							try {
								shopsByAddress = shopService.findListShopByAddress(addressShop);
							} catch (Exception e) {
								shopsByAddress = new ArrayList<>();
							}
							if (shopsByAddress.isEmpty()) {
								JSONObject latLong = getLangitudeAndLatitude(addressShop);
								if (latLong != null) {
									shop.setLatitude(latLong.getDouble("lat"));
									shop.setLongitude(latLong.getDouble("lng"));
								} else {
									skipJob = true;
									reason_to_skip += " // json Latitude and Longitude are null ";
									nb_skipLongitudeAndLatitudeNull++;
									reasonOfRowsSkipped
											.add("Line number: " + i + "------json Latitude and Longitude are null");

									logger.info("------SKIP BECAUSE OF----address-shop--1----:{}", skipJob);

								}
							} else {
								Shop shopSameAddress = shopsByAddress.get(0);
								Double latitude = shopSameAddress.getLatitude();
								Double longitude = shopSameAddress.getLongitude();
								shop.setLatitude(latitude);
								shop.setLongitude(longitude);
							}
							/**************************/

						} catch (Exception e) {
							skipJob = true;
							reason_to_skip += " // catch Latitude and Longitude Exception ";
							nb_skipLongitudeAndLatitudeException++;
							reasonOfRowsSkipped.add("Line number: " + i + "------catch Latitude and Longitude");

							logger.info("**CATCH------SKIP BECAUSE OF----address-shop----***:{}", skipJob);
							e.printStackTrace();
						}
					} else {
						// SKIP THIS JOB ?
						// ASK ALISON

						skipJob = true;
						reason_to_skip += " // address shop is null ";
						nb_skipAddressShopNull++;
						reasonOfRowsSkipped.add("Line number: " + i + "------address shop is null");

						logger.info("------SKIP BECAUSE OF----address-shop---2---:{}", skipJob);
					}
					if (shop.getLatitude() == null || shop.getLongitude() == null) {
						skipJob = true;
						reason_to_skip += " // Latitude or Longitude is null";
						nb_skipLongitudeOrLatitudeNull++;
						reasonOfRowsSkipped.add("Line number: " + i + "------Latitude or Longitude is null");

						logger.info("------SKIP BECAUSE OF----address-shop---3---:{}", skipJob);
					}

				} catch (Exception e) {
					skipJob = true;
					reason_to_skip += " // catch address ";
					nb_skipAddressException++;
					reasonOfRowsSkipped.add("Line number: " + i + "------catch address");

					logger.info("------************CATCH***---SKIP BECAUSE OF----address-shop------:{}", skipJob);
					e.printStackTrace();
				}
			} else {
				skipJob = true;
				reason_to_skip += " // column address is null ";
				nb_skipColumnAddressNull++;
				reasonOfRowsSkipped.add("Line number: " + i + "------column address is null");
				logger.info("------SKIP BECAUSE OF----address-shop--4----:{}", skipJob);
			}

			if (nextLine[13] != null && !nextLine[13].equals("") && !skipJob) {
				try {
					logger.info("------************try***13***********---------------", nextLine[13]);
				} catch (Exception e) {
					logger.info("------************CATCH***13***********---------------");
					e.printStackTrace();
				}
			}
			if (nextLine[14] != null && !nextLine[14].equals("") && !skipJob) {
				try {
					logger.info("------************try***14***********---------------", nextLine[14]);
				} catch (Exception e) {
					logger.info("------************CATCH***14***********---------------");
					e.printStackTrace();
				}

			}
			if (nextLine[15] != null && !nextLine[15].equals("") && !skipJob) {
				try {
					// work_hours //16 ******************* {start_time} and {finish_time}
					logger.info("-----------WorkTimeEnglish----NOT COMPLETED--------------------------------------:");
					/******************************/
					/**************************** Work Shifts *******************************/
					/**************************************************/
					String workHours = nextLine[15];

					/*************************/
					String startTime = null;
					String finishTime = null;
					String hoursStart = null;
					String minutesStart = null;
					String hoursFinish = null;
					String minutesFinish = null;

					logger.info(
							"--------------------------------------------BEFORE----UTF8-----------------------------------------");
					logger.info(workHours);
					// ０ １ ２ ３ ４ ５ ６ ７ ８ ９

					workHours = convertFullWidthToHalfWidth(workHours);

					logger.info(
							"-----------------------------------AFTER------------UTF8---------------------------------------------");
					logger.info(workHours);

					// ～
					if (workHours.contains("〜") || workHours.contains("～")) {
						if (workHours.contains("～")) {
							logger.info("-------REPLACE--------～ by 〜----------------------");
							workHours = workHours.replace("～", "〜");

						}
						int index = 0;

						boolean matcherFoundBefore = false;
						boolean matcherFoundAfter = false;
						while (((index = (workHours.indexOf('〜', index) + 1)) > 0)
								&& (!matcherFoundBefore || !matcherFoundAfter)) {
							matcherFoundBefore = false;
							matcherFoundAfter = false;

							if (workHours.contains("：")) {
								workHours = workHours.replace("：", ":");
							}
							logger.info("---------index-----------:{}", index);
							String beforeDelim = null;
							String afterDelim = null;
							if (index - 7 >= 0) {
								beforeDelim = workHours.substring(index - 7, index - 1);
								logger.info("--------------beforeDelim---1-------:{}", beforeDelim);
							} else {
								beforeDelim = workHours.substring(0, index - 1);
								logger.info("--------------beforeDelim---2-------:{}", beforeDelim);
							}

							int indexOfbreakLine = workHours.indexOf('\n', index);
							if (indexOfbreakLine == -1) {
								indexOfbreakLine = workHours.length();
							}
							System.out.println("-----------indexOfbreakLine----------------:" + indexOfbreakLine);
							if (index + 7 > indexOfbreakLine) {
								afterDelim = workHours.substring(index, indexOfbreakLine);
								logger.info("-------------afterDelim----1------:{}", afterDelim);
							} else {
								afterDelim = workHours.substring(index, index + 7);

								logger.info("--------------afterDelim---2-------:{}", afterDelim);
							}

							// 16時00分
							// number+"時"+number+"分"
							// final String regex = "([0-9]?\\d:[0-9]\\d)";

							// Condition 1
							final String regexConditionOne = "([0-9]+時[0-9]+分)";

							// Condition 2
							// 翌4時00分
							final String regexConditionTwo = "(翌[0-9]+時[0-9]+分)";

							// Condition 3
							// 22：00
							final String regexConditionTree = "([0-9]+:[0-9]+)";

							final Pattern patternConditionOne = Pattern.compile(regexConditionOne, Pattern.MULTILINE);
							final Pattern patternConditionTwo = Pattern.compile(regexConditionTwo, Pattern.MULTILINE);
							final Pattern patternConditionTree = Pattern.compile(regexConditionTree, Pattern.MULTILINE);
							/*******************/
							if (beforeDelim != null || afterDelim != null) {
								final Matcher matcherBeforeDelimC1 = patternConditionOne.matcher(beforeDelim);
								final Matcher matcherAfterDelimC1 = patternConditionOne.matcher(afterDelim);
								final Matcher matcherAfterDelimC2 = patternConditionTwo.matcher(afterDelim);
								/**************/
								final Matcher matcherBeforeDelimC3 = patternConditionTree.matcher(beforeDelim);
								final Matcher matcherAfterDelimC3 = patternConditionTree.matcher(afterDelim);

								while (matcherBeforeDelimC1.find()) {
									startTime = matcherBeforeDelimC1.group(0);
									logger.info("-----startTime-----CONDITION----1---------------:{}", startTime);
									hoursStart = startTime.substring(0, startTime.indexOf('時'));
									minutesStart = startTime.substring(startTime.indexOf('時') + 1,
											startTime.indexOf('分'));
									logger.info("--------------------hoursStart------------------:{}", hoursStart);
									logger.info("------------------minutesStart--------------------:{}", minutesStart);
									startTime = hoursStart + ":" + minutesStart;
									matcherFoundBefore = true;
									break;
								}
								while (matcherAfterDelimC1.find()) {

									finishTime = matcherAfterDelimC1.group(0);
									logger.info("----finishTime-----CONDITION----1--------------------:{}", finishTime);

									hoursFinish = finishTime.substring(0, finishTime.indexOf('時'));
									minutesFinish = finishTime.substring(finishTime.indexOf('時') + 1,
											finishTime.indexOf('分'));
									logger.info("--------------------hoursFinish-------c1-----------:{}", hoursFinish);
									logger.info("------------------minutesFinish------c1--------------:{}",
											minutesFinish);
									finishTime = hoursFinish + ":" + minutesFinish;
									matcherFoundAfter = true;
									break;
								}
								while (matcherAfterDelimC2.find()) {
									// 翌4時00分
									finishTime = matcherAfterDelimC2.group(0);
									logger.info("------finishTime------CONDITION----2--------------------:{}",
											finishTime);

									hoursFinish = finishTime.substring(finishTime.indexOf('翌') + 1,
											finishTime.indexOf('時'));
									minutesFinish = finishTime.substring(finishTime.indexOf('時') + 1,
											finishTime.indexOf('分'));
									logger.info("--------------------hoursFinish-------c2-----------:{}", hoursFinish);
									logger.info("------------------minutesFinish--------c2------------:{}",
											minutesFinish);
									finishTime = "0" + hoursFinish + ":" + minutesFinish;
									matcherFoundAfter = true;
									break;
								}
								/***********************/
								while (matcherBeforeDelimC3.find()) {
									startTime = matcherBeforeDelimC3.group(0);
									logger.info("--------CONDITION----3-------startTime--------:{}", startTime);
									if (startTime.length() == 4) {
										startTime = "0" + startTime;

									}
									matcherFoundBefore = true;
									break;
								}
								while (matcherAfterDelimC3.find()) {

									finishTime = matcherAfterDelimC3.group(0);
									logger.info("---------CONDITION---3------finishTime--------:{}", finishTime);
									matcherFoundAfter = true;
									break;
								}
								logger.info("---*********---------matcherFoundBefore-----*********----------:{}",
										matcherFoundBefore);
								logger.info("---*********---------matcherFoundAfter-----*********----------:{}",
										matcherFoundAfter);
								/********************/

							}
						}
					} else {
						logger.info("------------------CONDITION---5--------------------------------------");
						if (workHours.contains("24時間")) {
							startTime = "00:00";
							finishTime = "23:59";

						}
					}

					logger.info("----------startTime-------------:{}", startTime);
					logger.info("----------finishTime-------------:{}", finishTime);
					try {

						if (startTime != null && finishTime != null) {
							if (finishTime.equalsIgnoreCase("24:00")) {
								finishTime = "00:00";
							}
							Date startWorkingTimeDate = formatter.parse(startTime);
							job.setStartWorkingTime(startWorkingTimeDate);
							Date finishWorkingTimeDate = formatter.parse(finishTime);
							job.setFinishWorkingTime(finishWorkingTimeDate);

							logger.info(
									"---------------startTime != null && finishTime != null-------------------------");
							job = setWorkTimeEnglishJapanese(job, startTime, finishTime);
							logger.info("------------job.getWorkTimeEnglish()---------------------------:"
									+ job.getWorkTimeEnglish());
							logger.info(
									"--------				reader.readNext();\n"
											+ "----job.getWorkTimeJapanese()---------------------------:{}",
									job.getWorkTimeJapanese());

							if (job.getWorkTimeEnglish() == null || job.getWorkTimeJapanese() == null) {
								skipJob = true;

								reason_to_skip += " // WorkTimeEnglish == null or WorkTimeJapanese == null";
								nb_skipWorkTimeNull++;
								reasonOfRowsSkipped.add("Line number: " + i
										+ "------WorkTimeEnglish == null or WorkTimeJapanese == null");

								logger.info(
										"----------SKIP BECAUSE OF------WorkTimeEnglish == null--||-----WorkTimeJapanese == null------------------:{}",
										skipJob);
							}
						} else {
							skipJob = true;
							reason_to_skip += " // startTime == null or finishTime == null";
							nb_skipStartOrFinishTimeNull++;
							reasonOfRowsSkipped
									.add("Line number: " + i + "------startTime == null or finishTime == null");
							logger.info(
									"--------SKIP BECAUSE OF-------startTime == null || finishTime == null-----------------:{}",
									skipJob);
						}
					} catch (Exception e) {
						skipJob = true;
						reason_to_skip += " // catch 1 startTime and finishTime ";
						nb_skipStartAndFinishTimeException_1++;
						reasonOfRowsSkipped.add("Line number: " + i + "------catch 1 startTime and finishTime");
						logger.info("-----****CATCH**--------SKIP BECAUSE OF----START----FINISH----TIME--------:{}",
								skipJob);
						e.printStackTrace();
					}
					/***********************************************************************/
				} catch (Exception e) {
					skipJob = true;
					reason_to_skip += " // catch 2 startTime and finishTime";
					nb_skipStartAndFinishTimeException_2++;
					reasonOfRowsSkipped.add("Line number: " + i + "------catch 2 startTime and finishTime");
					logger.info(
							"------************CATCH**-------SKIP BECAUSE OF---**START*********FINISH********************----:{}",
							skipJob);
					e.printStackTrace();
				}
			}
			if (nextLine[16] != null && !nextLine[16].equals("") && !skipJob) {
				try {

					jobDetail = nextLine[16];
					logger.info("-----------jobDetail--NEW---3-----------:{}", jobDetail);
				} catch (Exception e) {
					logger.info("------************CATCH***16***********---------------");
					e.printStackTrace();
				}

			}
			if (nextLine[17] != null && !nextLine[17].equals("") && !skipJob) {
				try {
					logger.info("------************try***17***********---------------");
				} catch (Exception e) {
					logger.info("------************CATCH***17***********---------------");
					e.printStackTrace();
				}
			}
			if (nextLine[18] != null && !nextLine[18].equals("") && !skipJob) {
				try {
					logger.info("------************try***18***********---------------");
				} catch (Exception e) {
					logger.info("------************CATCH***18***********---------------");
					e.printStackTrace();
				}
			}

			if (nextLine[19] != null && !nextLine[19].equals("") && !skipJob) {
				try {

					// image //20 ******************{image_url}
					if (nextLine[19] != null && !nextLine[19].equals("")) {
						String imgUrl = nextLine[19];
						logger.info("-----------PictureJob----1------------:{}", imgUrl);
						imgUrl = imgUrl.replaceAll("[\n\r]", "");
						job.setPictureJob(imgUrl);
						logger.info("-----------PictureJob----2------------:{}", imgUrl);
					} else {
						job.setPictureJob(null);
					}
				} catch (Exception e) {
					logger.info("------************CATCH***20***********---------------");
					e.printStackTrace();
				}
			}
			/********************/
			job.setJobDetails(jobDetail);
			/**************************/
			shop.setCompany(company);
			shop.setEmailShop("apply_joboty@willgroup.co.jp");

			/*************************/

			logger.info("************* nextLine[20] *************" + nextLine[20]);

			try {

				// String EndColubmn = nextLine[20].substring(0, nextLine[20].indexOf('\n'));
				// String startColubmnofNextLine =
				// nextLine[20].substring(nextLine[20].indexOf('\n') + 1,
				// nextLine[20].length());
				//
				// logger.info("-----***************------JobURL----1--******************----------:{}",
				// EndColubmn);

				List<Job> listJobs = null;
				if (nextLine[20] != null && !nextLine[20].equals("")) {
					String url = nextLine[20];
					url = url.replaceAll("[\n\r]", "");
					job.setJobURL(url);
					logger.info("-----------JobURL----2------------:{}", url);

					String regexUrl = "\\d+";
					// compiling regex
					Pattern pUrl = Pattern.compile(regexUrl);
					// Matcher object
					Matcher mUrl = pUrl.matcher(url);
					String idJobDetail = null;
					while (mUrl.find()) {
						idJobDetail = mUrl.group();
						job.setIdJobDetail(idJobDetail);
						break;
					}
					System.out.println(
							"------**************----idJobDetail----********************--------------:" + idJobDetail);
					try {
						listJobs = jobService.getCheckedLacottoJobsByIdJobDetail(idJobDetail);
					} catch (Exception exception) {
						listJobs = new ArrayList<>();
					}

					if (idJobDetail == null) {

						skipJob = true;
						// int lineSkipped = roundUp(i / 20);
						reason_to_skip += " // idJobDetail is null ";
						nb_skipIdJobDetailNull++;
						reasonOfRowsSkipped.add("Line number: " + i + "------idJobDetail is null");

						logger.info("----------------SKIP BECAUSE OF-----idJobDetail--is--NULL-----:{}", skipJob);
					} else if (!listJobs.isEmpty()) {
						Job checkedJob = listJobs.get(0);
						System.out.println("Checked Lacotto Job {----IdJobDetail----} " + checkedJob.getIdJobDetail());

						checkedJob.setPositionCategoryEnglish(job.getPositionCategoryEnglish());
						checkedJob.setPositionCategoryJapanese(job.getPositionCategoryJapanese());
						checkedJob.setPositionName(job.getPositionName());
						checkedJob.setHourlyWage(job.getHourlyWage());
						checkedJob.setStartWorkingTime(job.getStartWorkingTime());
						checkedJob.setFinishWorkingTime(job.getFinishWorkingTime());
						checkedJob.setPictureJob(job.getPictureJob());
						checkedJob.setJobDetails(job.getJobDetails());
						checkedJob.setJobURL(job.getJobURL());
						job = checkedJob;
					}
					boolean expiredJob = false;
					if (url != "" && url != null) {
						if (!skipJob) {
							expiredJob = checkJobsURL(url);
						}
					}
					logger.info("-----------JobURL----2-----EXPIRE ----OR-------NOT----:{}", expiredJob);
					if (expiredJob) {
						logger.info("-----------------------------------------------------");
						logger.info("-----------------------------------------------------");
						logger.info("-------------------expiredJob----------------------------------:{}", url);
						logger.info("-----------------------------------------------------");
						logger.info("-----------------------------------------------------");
						urlExpired.add(url);
						skipJob = true;
						// int lineSkipped = roundUp(i / 20);
						reason_to_skip += " // job is expired ";
						nb_skipJobExpired++;
						reasonOfRowsSkipped.add("Line number: " + i + "------job is expired");

						logger.info("----------------SKIP BECAUSE OF----Job-is--expired-------:{}", skipJob);
					} else {
						urlNOTExpired.add(url);

					}
				} else {
					skipJob = true;
					// int lineSkipped = roundUp(i / 20);
					reason_to_skip += " // url is null ";
					nb_skipUrlNull++;
					reasonOfRowsSkipped.add("Line number: " + i + "------url is null");
					logger.info("----------------SKIP BECAUSE OF----the url----:{}", skipJob);
				}

				/***********************************/
				/***** DEFAULTS PARAMS **************************/
				job.setJobType("short");
				job.setNumberStaffNeeded(0);
				job.setInterviewType("affiliate");
				job.setAffiliateType("lacotto");
				job.setStatus(true);
				job.setCasePrice("0");
				/*****************************/
				/*****************************************/
				logger.info("----qqqqqqqqqqqq------shopName-----------qqqqqq-------------------------:{}", shopName);
				logger.info("-----ssssssss-----addressShop-------------sssssssssss-------------------------:{}",
						addressShop);
				if (shopName != "" && addressShop != null) {
					// List<Shop> shops = shopService.findListShopByNameShopAndByAddress(shopName,
					// addressShop);
					List<Shop> shops = null;
					try {
						shops = shopService.findListShopByNameShopAndByAddress(shopName, addressShop);
					} catch (Exception e) {
						shops = new ArrayList<>();
					}
					if (!shops.isEmpty()) {

						shop = shops.get(0);
						oldShop = oldShop + 1;
					} else {
						shop.setNameShop(shopName);
					}
				} else {
					skipJob = true;
					reason_to_skip += " // shopName == '' or addressShop == null ";
					nb_skipShopNameOrAddressShopNull++;
					reasonOfRowsSkipped.add("Line number: " + i + "------shopName == '' or addressShop == null");
					logger.info("----------------SKIP BECAUSE OF---shopName == '' || addressShop == null---:{}",
							skipJob);
				}

				/*************************************/
				if (!skipJob) {
					logger.info("------------START---SAVE---JOB----------------");

					// if( !listJobs.isEmpty()) {
					// System.out.println("Checked Job 1111111111111");
					// job = listJobs.get(0);
					// }
					System.out.println("shooooooooooop =" + shop.getAddressShop());
					shop = shopService.saveShop(shop);
					job.setShop(shop);
					jobService.saveJob(job);
					listBatchJobs.add(job);

					logger.info("--------------JOB---SAVED-----------------------");
					savedJobs = savedJobs + 1;
					// int lineSaved = roundUp(i / 20);
					numberOfRowsSaved.add(i);

					/****************/

				} else {
					skippedJobs = skippedJobs + 1;
					// int lineSkipped = roundUp(i / 20);
					numberOfRowsSkipped.add(i);
					reason_to_skip += "*** Line : " + i + "*** \n";
					// writer.write(reason_to_skip + "\n");
				}

				// SAVE SHOP MISSED *************************
				job = new Job();
				jobDetail = "";
				// jobDetail = jobDetail + startColubmnofNextLine;
				// j = 1;

				shop = new Shop();

				shopName = "";
				addressShop = null;
				skipJob = false;
				logger.info("-----------END--LINE--------------:{}", i);

				logger.info(
						"----------*****************************************************************************---------------------");
				logger.info(
						"----------*********************************-------REBELOTEEEEEEEE-----*******************************---------------------");
				logger.info(
						"----------*******************************************************************************---------------------");

			} catch (Exception e) {
				skippedJobs = skippedJobs + 1;

				logger.info("---------------*********************************************-----------------------");
				logger.info("---------------*************CATCH*****************---------------------");
				logger.info("-----------------******************------------------------");
				e.printStackTrace();

				logger.info("-----------------**********************************-------------------------");
				logger.info("----------------*******************************************-------------------------");
				logger.info("--------*******************************************************--------");
			}

		}

		logger.info("--------------------EXPIRED URL----LIST---------------------------:{}", urlExpired.size());

		logger.info("---------------NOT-----EXPIRED URL------LIST-------------------------:{}", urlNOTExpired.size());

		logger.info("-----------END--FILEEEEEE------oldShop--------:{}", oldShop);
		logger.info("-----------END--FILEEEEEE------savedJobs--------:{}", savedJobs);
		logger.info("-----------END--FILEEEEEE------skippedJobs--------:{}", skippedJobs);

		for (int rowSaved : numberOfRowsSaved) {
			logger.info("-----ROWS----SAVED-number---------------------:{}", rowSaved);
		}
		logger.info("----****************************************----------------");
		for (int rowSkipped : numberOfRowsSkipped) {
			logger.info("-----ROWS----SKIPPED-number---------------------:{}", rowSkipped);
		}
		logger.info("---------------REASONS---OF---ROWS----SKIPPED-----------------:{}", reasonOfRowsSkipped.size());
		for (String reason : reasonOfRowsSkipped) {
			logger.info("-----REASON---OF---SKIP--------------------------:{}", reason);
		}

		jobRepository.saveAll(listBatchJobs);
		listBatchJobs = null;
		reader.close();

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
	 * @param address
	 *            the address
	 * @return the langitude and latitude
	 * @throws JSONException
	 *             the JSON exception
	 */
	/**************************************************/
	/**************************************************/

	public JSONObject getLangitudeAndLatitude(String address) throws JSONException {

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

}
