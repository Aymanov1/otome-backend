package com.hrdatabank.otome.services;

import java.io.IOException;

public interface IJsenLacottoService {

	public String HH_MM = "HH:mm";

	public void importJsenCSV(String fileName) throws IOException;

	public void importCSVForLacottoJobsWithOpenCsv(String fileName) throws IOException;
}
