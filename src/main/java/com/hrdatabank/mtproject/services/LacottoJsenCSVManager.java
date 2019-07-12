package com.hrdatabank.mtproject.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrdatabank.otome.services.JsenLacottoService;
import com.hrdatabank.otome.services.JsenLacottoServiceImple;

// TODO: Auto-generated Javadoc
/**
 * The Class LacottoJsenCSVManager.
 */
@Service
public class LacottoJsenCSVManager {

	/** The jsen lacotto service. */
	@Autowired
	private JsenLacottoService jsenLacottoService;
	
	/** The jsen lacotto service imple. */
	@Autowired
	private JsenLacottoServiceImple jsenLacottoServiceImple;

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: LacottoJsenCSVManager.java
	 * 
	 * this method Import csv stream lacotto.
	 * @param csvDirectoryLacotto the csv directory lacotto
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void importCsvStreamLacotto(String csvDirectoryLacotto) throws IOException {
		jsenLacottoServiceImple.importCSVForLacottoJobsWithOpenCsv(csvDirectoryLacotto);
		// int[] numArr = { 0 };
		// try {
		//
		// Files.newDirectoryStream(Paths.get(csvDirectoryLacotto), path ->
		// path.toString().endsWith(".csv"))
		// .forEach(filePath -> {
		// numArr[0]++;
		// try {
		// jsenLacottoService.importCSVForLacottoJobsWithOpenCsv(filePath.toString());
		// } catch (IOException e1) {
		// e1.printStackTrace();
		// }
		// System.out.println(filePath + " " + numArr[0]);
		// try {
		// Files.delete(filePath);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// });
		//
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author mahdi
	 * 
	 *         method to read all csvs from one directory and import them for J-sen
	 *         jobs
	 * @param csvDirectoryJsen the csv directory jsen
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void importCsvStreamJsen(String csvDirectoryJsen) throws IOException {
		jsenLacottoServiceImple.importJsenCSV(csvDirectoryJsen);

		// try {
		// Files.newDirectoryStream(Paths.get(csvDirectoryJsen), path ->
		// path.toString().endsWith(".csv"))
		// .forEach(filePath -> {
		// System.out.println("---------------filePath----------------:" + filePath);
		// try {
		// System.out.println(filePath.toString());
		// jsenLacottoService.importJsenCSV(filePath.toString());
		// } catch (FileNotFoundException e1) {
		// e1.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		//
		//// try {
		//// Files.delete(filePath);
		//// } catch (IOException e) {
		//// e.printStackTrace();
		//// }
		// });
		//
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
	}

}
