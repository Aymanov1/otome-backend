package com.hrdatabank.otome;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TerminateBean {

	private static Logger log = LoggerFactory.getLogger(TerminateBean.class);
	/** The description. */
	@Value("${spring.datasource1.username}")
	String username;

	/** The description. */
	@Value("${spring.datasource1.password}")
	String password;

	/** The url database. */
	@Value("${spring.datasource1.url}")
	String urlDatabase;

	/** The path backup. */
	@Value("${path.backup}")
	String pathBackup;

	@PreDestroy
	public void onDestroy() throws Exception {
		log.info("Spring Container is destroyed!");
		// create a backup in case of accident
		try {
			executeCommands();
		} catch (IOException | InterruptedException e1) {
			log.error("error in backup : '{}'", e1);
		}

	}

	/**
	 * Execute commands using bash. execude a temporary script from java interface
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws InterruptedException
	 *             the interrupted exception
	 */
	public void executeCommands() throws IOException, InterruptedException {

		File tempScript = createTempScript();
		try {
			ProcessBuilder pb = new ProcessBuilder("bash", tempScript.toString());
			pb.inheritIO();
			Process process = pb.start();
			process.waitFor();
		} finally {
			tempScript.delete();
		}
	}

	/**
	 * Creates the temp script. the temp script is used to create a backup of
	 * database in case of accident; using pg_dump for postgresql database
	 *
	 * @return the file
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public File createTempScript() throws IOException {
		File tempScript = File.createTempFile("script", null);

		Writer streamWriter = new OutputStreamWriter(new FileOutputStream(tempScript));
		PrintWriter printWriter = new PrintWriter(streamWriter);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		String dateString = format.format(new Date());
		printWriter.println("#!/bin/bash");
		printWriter.println(" PGPASSWORD=\"" + password + "\" pg_dump -U " + username + " "
				+ urlDatabase.substring(urlDatabase.lastIndexOf('/') + 1) + " > " + pathBackup + "" + dateString
				+ ".sql");

		printWriter.close();

		return tempScript;
	}
}