package com.hrdatabank.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.net.ftp.FTPClient;
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
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

// TODO: Auto-generated Javadoc
/**
 * The Class SFTPController.
 */
@RestController
@RequestMapping("/sftp")
public class SFTPController {

	/** The log. */
	private static Logger log = LoggerFactory.getLogger(SFTPController.class);

	/** The Constant ERROR. */
	private final static String ERROR = "ERROR ";

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
	@GetMapping(path = "/download/{serverType}")
	@CrossOrigin(origins = "http://localhost:4200")
	public String downloadFilesToServer(@PathVariable("serverType") String serverType) {
		if (serverType.equalsIgnoreCase(CrawlerTypesEnum.LACOTTO.toString())) {
			return downloadFromServer(hostLacotto, userLacotto, passwordLacotto, portLacotto, pathLacottoFrom,
					pathLacottoDestination);

		} else if (serverType.equalsIgnoreCase(CrawlerTypesEnum.JSEN.toString())) {
			return downloadFromFTPServer(hostJsen, userJsen, passwordJsen, pathJsenFrom, pathJsenDestination);
		}
		return "it seems there is a problem, please check the log for details";
	}

	@GetMapping(path = "/inject/{serverType}")
	@CrossOrigin(origins = "http://localhost:4200")
	public String injectFilesToServer(@PathVariable("serverType") String serverType) {
		if (serverType.equalsIgnoreCase(CrawlerTypesEnum.LACOTTO.toString())) {
			try {
				jsenLacottoService.importCSVForLacottoJobsWithOpenCsv("/opt/tomcat/csv/lacotto_job_offer.csv");
				return "Done";
			} catch (IOException e) {
				e.printStackTrace();
				return "not Done";
			}

		} else if (serverType.equalsIgnoreCase(CrawlerTypesEnum.JSEN.toString())) {
			try {
				jsenLacottoService.importJsenCSV("/opt/tomcat/csv/mb_works_for_joboty.csv");
				return "Done";
			} catch (IOException e) {
				e.printStackTrace();
				return "not Done";
			}
		}
		return "it seems there is a problem, please check the log for details";
	}

	/**
	 * Download from FTP server.
	 *
	 * @param host
	 *            the host of sftp server
	 * @param user
	 *            the user of sftp server
	 * @param password
	 *            the password of sftp server
	 * @param pathRemote
	 *            the path remote of the downloaded file
	 * @param pathLocal
	 *            the path local of the destination of the downloaded file
	 * @return the status of downloading from the SFTP/FTP server
	 */
	private String downloadFromFTPServer(String host, String user, String password, String pathRemote,
			String pathLocal) {
		FTPClient client = new FTPClient();
		String statusOfDownloading = "";
		FileOutputStream fos = null;

		try {
			client.connect(host);
			client.login(user, password);

			// Fetch file from server
			File downloadFile1 = new File(pathLocal + pathRemote);
			OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));

			boolean success = client.retrieveFile(pathRemote, outputStream1);
			outputStream1.close();
			if (success) {
				log.info("File #1 has been downloaded successfully.{}", "");
			}
			statusOfDownloading = "Download done successfully  ";
		} catch (IOException e) {
			log.error(ERROR, e);
			statusOfDownloading = "It seems there is a problem, please check the log for details";
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
				client.disconnect();

			} catch (IOException e) {
				log.error(ERROR, e);
			}
		}
		return statusOfDownloading;
	}

	/**
	 * Download from server.
	 *
	 * @param host
	 *            the host of sftp server
	 * @param user
	 *            the user of sftp server
	 * @param password
	 *            the password of sftp server
	 * @param pathRemote
	 *            the path remote of the downloaded file
	 * @param pathLocal
	 *            the path local of the destination of the downloaded file
	 * @return the status of downloading from the SFTP/FTP server
	 */
	private static String downloadFromServer(String host, String user, String password, int port, String pathRemote,
			String pathLocal) {
		JSch jsch = new JSch();
		Session session = null;
		try {
			session = jsch.getSession(user, host, port);
			session.setConfig("StrictHostKeyChecking", "no");
			session.setPassword(password);
			session.connect();

			Channel channel = session.openChannel("sftp");
			channel.connect();
			ChannelSftp sftpChannel = (ChannelSftp) channel;
			sftpChannel.get(pathRemote, pathLocal);
			log.info("download done successfully");
			sftpChannel.exit();

			session.disconnect();

			unzip(pathLocal + "lacotto_job_offer.zip", pathLocal);
			log.info("Unzip done successfully");
			return "Downloading and Unzipping done successfully  ";
		} catch (JSchException | SftpException e) {
			log.error(ERROR, e);
		}
		return "It seems there is a problem, please check the log for details";
	}

	private static void unzip(String zipFilePath, String destDir) {
		File dir = new File(destDir);
		// create output directory if it doesn't exist
		if (!dir.exists())
			dir.mkdirs();
		// buffer for read and write data to file
		byte[] buffer = new byte[1024];
		try (FileInputStream fis = new FileInputStream(zipFilePath); ZipInputStream zis = new ZipInputStream(fis);) {

			ZipEntry ze = zis.getNextEntry();

			while (ze != null) {
				String fileName = ze.getName();
				File newFile = new File(destDir + File.separator + fileName);
				log.info("Unzipping to {}", newFile.getAbsolutePath());
				// create directories for sub directories in zip
				new File(newFile.getParent()).mkdirs();
				try (FileOutputStream fos = new FileOutputStream(newFile)) {
					int len;
					while ((len = zis.read(buffer)) > 0) {
						fos.write(buffer, 0, len);
					}

					// close this ZipEntry
					zis.closeEntry();
					ze = zis.getNextEntry();
				}
			}
			// close last ZipEntry
			zis.closeEntry();

		} catch (IOException e) {
			log.error(ERROR, e);
		}

	}

}
