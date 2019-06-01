package com.hrdatabank.controllers;

import java.text.MessageFormat;

import org.crawler.web.enumeration.CrawlerTypesEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

@RestController
@RequestMapping("/sftp")
public class SFTPController {
	private static Logger log = LoggerFactory.getLogger(SFTPController.class);
	/** The description. */
	@Value("${hostLacotto}")
	private String hostLacotto;

	@Value("${userLacotto}")
	private String userLacotto;

	@Value("${passwordLacotto}")
	private String passwordLacotto;

	@Value("${pathLacottoFrom}")
	private String pathLacottoFrom;

	@Value("${pathLacottoDestination}")
	private String pathLacottoDestination;

	@Value("${portLacotto}")
	private int portLacotto;

	@Value("${hostJsen}")
	private String hostJsen;

	@Value("${userJsen}")
	private String userJsen;

	@Value("${passwordJsen}")
	private String passwordJsen;

	@Value("${pathJsenFrom}")
	private String pathJsenFrom;

	@Value("${pathJsenDestination}")
	private String pathJsenDestination;

	@Value("${portJsen}")
	private int portJsen;

	@GetMapping(path = "/download/{serverType}")
	@CrossOrigin(origins = "http://localhost:4200")
	public String downloadFilesToServer(@PathVariable("serverType") String serverType) {
		if (serverType.equalsIgnoreCase(CrawlerTypesEnum.LACOTTO.toString())) {
			return downloadFromServer(hostLacotto, userLacotto, passwordLacotto, portLacotto, pathLacottoFrom,
					pathLacottoDestination);
		} else if (serverType.equalsIgnoreCase(CrawlerTypesEnum.JSEN.toString())) {
			return downloadFromServer(hostJsen, userJsen, passwordJsen, portJsen, pathJsenFrom, pathJsenDestination);
		}
		return "it seems there is a problem, please check the log for details";
	}

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
			log.info("download done successfully  ");
			sftpChannel.exit();

			session.disconnect();
			return "Download done successfully  ";
		} catch (JSchException e) {
			e.printStackTrace();
		} catch (SftpException e) {
			e.printStackTrace();

		}
		return "It seems there is a problem, please check the log for details";
	}
}
