package com.hrdatabank.otome.services;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public interface IJsenLacottoService {

	public String HH_MM = "HH:mm";

	public void  importJsenCSV(String fileName) throws IOException;

	public void  importCSVForLacottoJobsWithOpenCsv(String fileName) throws IOException;
}
