package com.hrdatabank.mtproject.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrdatabank.otome.services.JsenLacottoService;

@Service
public class LacottoJsenCSVManager {

	@Autowired
	private JsenLacottoService jsenLacottoService;

	public void importCsvStreamLacotto(String csvDirectoryLacotto) throws IOException {
		jsenLacottoService.importCSVForLacottoJobsWithOpenCsv(csvDirectoryLacotto);
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
	 * @author mahdi
	 * 
	 *         method to read all csvs from one directory and import them for J-sen
	 *         jobs
	 * @throws IOException
	 */
	public void importCsvStreamJsen(String csvDirectoryJsen) throws IOException {
		jsenLacottoService.importJsenCSV(csvDirectoryJsen);

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
