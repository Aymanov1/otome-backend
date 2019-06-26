package com.hrdatabank.controllers;

import java.io.IOException;

import org.crawler.web.enumeration.CrawlerTypesEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrdatabank.otome.services.JsenLacottoService;
import com.hrdatabank.otome.services.SFTPService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * The Class SFTPController.
 */
@RestController
@RequestMapping("/sftp")
public class SFTPController {

	/** The log. */
	private static Logger log = LoggerFactory.getLogger(SFTPController.class);

	/** The Constant ERROR. */
	private static final String ERROR = "ERROR ";

	@Autowired
	SFTPService sftpService;
	
	/** The host lacotto. */
	@Value("${hostLacotto}")
	private String hostLacotto;

	/** The user lacotto. */
	@Value("${userLacotto}")
	private String userLacotto;

	/** The password lacotto. */
	@Value("${passwordLacotto}")
	private String passwordLacotto;

	/** The path lacotto from. */
	@Value("${pathLacottoFrom}")
	private String pathLacottoFrom;

	/** The path lacotto destination. */
	@Value("${pathLacottoDestination}")
	private String pathLacottoDestination;

	/** The port lacotto. */
	@Value("${portLacotto}")
	private int portLacotto;

	/** The host jsen. */
	@Value("${hostJsen}")
	private String hostJsen;

	/** The user jsen. */
	@Value("${userJsen}")
	private String userJsen;

	/** The password jsen. */
	@Value("${passwordJsen}")
	private String passwordJsen;

	/** The path jsen from. */
	@Value("${pathJsenFrom}")
	private String pathJsenFrom;

	/** The path jsen destination. */
	@Value("${pathJsenDestination}")
	private String pathJsenDestination;

	/** The port jsen. */
	@Value("${portJsen}")
	private int portJsen;

	@Autowired
	JsenLacottoService jsenLacottoService;

	/**
	 * Download files to server.
	 *
	 * @param serverType
	 *            the server type (LACOTTO-JSEN)
	 * @return the status of downloading from the SFTP/FTP server
	 */
	@ApiOperation(value = " Start retrieving files from SFTP/FTP by crawler type ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success/ OK response"),
			@ApiResponse(code = 401, message = "Unauthorized Action"),
			@ApiResponse(code = 403, message = "Forbidden Action"),
			@ApiResponse(code = 500, message = "Internal Server ERROR ") })
	@GetMapping(path = "/download/{serverType}")
	@CrossOrigin(origins = "http://localhost:4200")
	public String downloadFilesToServer(@PathVariable("serverType") String serverType) {
		if (serverType.equalsIgnoreCase(CrawlerTypesEnum.LACOTTO.toString())) {
			return sftpService.downloadFromServer(hostLacotto, userLacotto, passwordLacotto, portLacotto,
					pathLacottoFrom, pathLacottoDestination);

		} else if (serverType.equalsIgnoreCase(CrawlerTypesEnum.JSEN.toString())) {
			return sftpService.downloadFromFTPServer(hostJsen, userJsen, passwordJsen, pathJsenFrom,
					pathJsenDestination);
		}
		return "it seems there is a problem, please check the log for details";
	}

	@ApiOperation(value = " Start injecting csv files from SFTP/FTP by crawler type to Database")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success/ OK response"),
			@ApiResponse(code = 401, message = "Unauthorized Action"),
			@ApiResponse(code = 403, message = "Forbidden Action"),
			@ApiResponse(code = 500, message = "Internal Server ERROR ") })
	@GetMapping(path = "/inject/{serverType}")
	@CrossOrigin(origins = "http://localhost:4200")
	public String injectFilesToServer(@PathVariable("serverType") String serverType) {
		if (serverType.equalsIgnoreCase(CrawlerTypesEnum.LACOTTO.toString())) {
			try {
				jsenLacottoService.importCSVForLacottoJobsWithOpenCsv("/opt/tomcat/csv/lacotto_job_offer.csv");
				return "Done";
			} catch (IOException e) {
				log.error("error", e);
				return "not Done";
			}

		} else if (serverType.equalsIgnoreCase(CrawlerTypesEnum.JSEN.toString())) {
			try {
				jsenLacottoService.importJsenCSV("/opt/tomcat/csv/mb_works_for_joboty.csv");
				return "Done";
			} catch (IOException e) {
				log.error("error", e);
				return "not Done";
			}
		}
		return "it seems there is a problem, please check the log for details";
	}

}
