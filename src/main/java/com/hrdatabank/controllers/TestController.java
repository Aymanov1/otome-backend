package com.hrdatabank.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrdatabank.mtproject.services.LacottoJsenCSVManager;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private LacottoJsenCSVManager lacottoJsenCSVManager;
	
	@GetMapping
	public ResponseEntity test() throws IOException {
		//lacottoJsenCSVManager.importCsvStreamLacotto("/home/heni/Vidéos/lacottoCSV/lacotto777.csv");
		//lacottoJsenCSVManager.importCsvStreamJsen("/home/heni/Vidéos/lacottoCSV/j-sen_joboty.csv");
		lacottoJsenCSVManager.importCsvStreamJsen("/home/heni/Vidéos/lacottoCSV/jsencsv/");
		return ResponseEntity.ok().build();
	}

	@GetMapping("/import")
	public void importcsv() throws IOException {
		
		//companyRepository.saveAll(companies);
	}

}
