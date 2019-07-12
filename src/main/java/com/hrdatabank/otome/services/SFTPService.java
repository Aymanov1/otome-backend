package com.hrdatabank.otome.services;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

/**
 * The Class SFTPService.
 */
@Service
public class SFTPService {
	/** The Constant LOGGER. */
	private static final Logger log = LoggerFactory.getLogger(SFTPService.class);

	/** The Constant ERROR. */
	private static final String ERROR = "ERROR ";

	/**
	 * Download from FTP server.
	 *
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: SFTPService.java
	 * 
	 *         Download from FTP server.
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
	public String downloadFromFTPServer(String host, String user, String password, String pathRemote,
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
	 * @author Aymanov
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: otome-backend
	 * 
	 *         Class Name: SFTPService.java
	 * 
	 *         Download from server.
	 * @param host
	 *            the host of sftp server
	 * @param user
	 *            the user of sftp server
	 * @param password
	 *            the password of sftp server
	 * @param port
	 *            the port
	 * @param pathRemote
	 *            the path remote of the downloaded file
	 * @param pathLocal
	 *            the path local of the destination of the downloaded file
	 * @return the status of downloading from the SFTP/FTP server
	 */
	public String downloadFromServer(String host, String user, String password, int port, String pathRemote,
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
			log.info("download done successfully {}", "");
			sftpChannel.exit();

			session.disconnect();

			unzip(pathLocal + "lacotto_job_offer.zip", pathLocal);
			log.info("Unzip done successfully {}", "");
			return "Downloading and Unzipping done successfully  ";
		} catch (JSchException | SftpException e) {
			log.error(ERROR, e);
		}
		return "It seems there is a problem, please check the log for details";
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
	 *         Class Name: SFTPService.java
	 * 
	 *         this method Unzip.
	 * @param zipFilePath
	 *            the zip file path
	 * @param destDir
	 *            the dest dir
	 */
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
