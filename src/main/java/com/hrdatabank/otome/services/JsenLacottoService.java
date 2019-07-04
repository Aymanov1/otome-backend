package com.hrdatabank.otome.services;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import org.springframework.stereotype.Service;

@Service
public class JsenLacottoService implements IJsenLacottoService {

	@Override
	public CompletableFuture<Boolean> importJsenCSV(String fileName) throws IOException {
		return null;
	}

	@Override
	public CompletableFuture<Boolean> importCSVForLacottoJobsWithOpenCsv(String fileName) throws IOException {
		return null;
	}

}
