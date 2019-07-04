package com.hrdatabank.otome.services;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public interface IJsenLacottoService {

	public String HH_MM = "HH:mm";

	public CompletableFuture<Boolean>  importJsenCSV(String fileName) throws IOException;

	public CompletableFuture<Boolean>  importCSVForLacottoJobsWithOpenCsv(String fileName) throws IOException;
}
