//package com.hrdatabank.mtproject.services;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.stereotype.Service;
//
//import com.hrdatabank.mtproject.entities.Company;
//import com.hrdatabank.mtproject.entities.CompanyObject;
//import com.hrdatabank.mtproject.model.AtsDetail;
//import com.hrdatabank.mtproject.model.CompanyDto;
//import com.hrdatabank.mtproject.repositories.CompanyRepository;
//
///**
// * The Class CompanyService.
// */
//@Service
//public class CompanyService {
//
////	/** The company repository. */
////	@Autowired
////	private CompanyRepository companyRepository;
////
////	/**
////	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
////	 *
////	 * @author yassine amira
////	 * 
////	 *         Using JRE: 1.8
////	 * 
////	 *         Project Name: Module-core-hr
////	 * 
////	 *         Class Name: CompanyService.java
////	 * 
////	 *         Sets the company repository.
////	 * @param companyRepository
////	 *            the new company repository
////	 */
////	public void setCompanyRepository(CompanyRepository companyRepository) {
////		this.companyRepository = companyRepository;
////	}
////
////	/**
////	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
////	 *
////	 * @author yassine amira
////	 * 
////	 *         Using JRE: 1.8
////	 * 
////	 *         Project Name: Module-core-hr
////	 * 
////	 *         Class Name: CompanyService.java
////	 * 
////	 *         List all companies.
////	 * @param page
////	 *            the page
////	 * @param size
////	 *            the size
////	 * @return the page
////	 */
////	public Page<Company> listAllCompanies(int page, int size) {
////		return companyRepository.findAll(PageRequest.of(page, size));
////	}
////
////	/**
////	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
////	 *
////	 * @author yassine amira
////	 * 
////	 *         Using JRE: 1.8
////	 * 
////	 *         Project Name: Module-core-hr
////	 * 
////	 *         Class Name: CompanyService.java
////	 * 
////	 *         Gets the company by id.
////	 * @param id
////	 *            the id
////	 * @return the company by id
////	 */
////	public Optional<Company> getCompanyById(long id) {
////		return companyRepository.findById(id);
////	}
////
////	/**
////	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
////	 *
////	 * @author yassine amira
////	 * 
////	 *         Using JRE: 1.8
////	 * 
////	 *         Project Name: Module-core-hr
////	 * 
////	 *         Class Name: CompanyService.java
////	 * 
////	 *         Gets the company by login id.
////	 * @param login_Id
////	 *            the login id
////	 * @return the company by login id
////	 */
////	public Company getCompanyByLoginId(String loginId) {
////		return companyRepository.findByLoginIdCompany(loginId);
////	}
////
////	/**
////	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
////	 *
////	 * @author yassine amira
////	 * 
////	 *         Using JRE: 1.8
////	 * 
////	 *         Project Name: Module-core-hr
////	 * 
////	 *         Class Name: CompanyService.java
////	 * 
////	 *         Save company.
////	 * @param company
////	 *            the company
////	 * @return the company
////	 */
////	public Company saveCompany(Company company) {
////		return companyRepository.save(company);
////	}
////
////	/**
////	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
////	 *
////	 * @author yassine amira
////	 * 
////	 *         Using JRE: 1.8
////	 * 
////	 *         Project Name: Module-core-hr
////	 * 
////	 *         Class Name: CompanyService.java
////	 * 
////	 *         this method Delete company.
////	 * @param idSalon
////	 *            the id salon
////	 */
////	public void deleteCompany(long idSalon) {
////		companyRepository.deleteById(idSalon);
////	}
////
////	/**
////	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
////	 *
////	 * @author yassine amira
////	 * 
////	 *         Using JRE: 1.8
////	 * 
////	 *         Project Name: Module-core-hr
////	 * 
////	 *         Class Name: CompanyService.java
////	 * 
////	 *         Find by name company.
////	 * @param name
////	 *            the name
////	 * @return the company
////	 */
////	public Company findByNameCompany(String name) {
////		return companyRepository.findByNameCompany(name);
////	}
////
////	/**
////	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
////	 *
////	 * @author yassine amira
////	 * 
////	 *         Using JRE: 1.8
////	 * 
////	 *         Project Name: Module-core-hr
////	 * 
////	 *         Class Name: CompanyService.java
////	 * 
////	 *         List all companies by keyword paginated.
////	 * @param page
////	 *            the page
////	 * @param size
////	 *            the size
////	 * @param keyword
////	 *            the keyword
////	 * @return the page
////	 */
////	public Page<Company> listAllCompaniesByKeywordPaginated(int page, int size, String keyword) {
////
////		return companyRepository.listAllCompaniesByKeywordPaginated(PageRequest.of(page, size), keyword);
////	}
////
////	/**
////	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
////	 *
////	 * @author yassine amira
////	 * 
////	 *         Using JRE: 1.8
////	 * 
////	 *         Project Name: Module-core-hr
////	 * 
////	 *         Class Name: CompanyService.java
////	 * 
////	 *         Gets the all companies.
////	 * @return the all companies
////	 */
////	public List<Company> getAllCompanies() {
////		return companyRepository.findAll();
////	}
////
////	/**
////	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
////	 *
////	 * @author yassine amira
////	 * 
////	 *         Using JRE: 1.8
////	 * 
////	 *         Project Name: Module-core-hr
////	 * 
////	 *         Class Name: CompanyService.java
////	 * 
////	 *         Gets the all companies objects.
////	 * @return the all companies objects
////	 */
////	public List<CompanyObject> getAllCompaniesObjects() {
////		return companyRepository.getAllCompaniesObjects();
////	}
////
////	/**
////	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
////	 *
////	 * @author yassine amira
////	 * 
////	 *         Using JRE: 1.8
////	 * 
////	 *         Project Name: Module-core-hr
////	 * 
////	 *         Class Name: CompanyService.java
////	 * 
////	 *         Gets the company object by id.
////	 * @param id
////	 *            the id
////	 * @return the company object by id
////	 */
////	public CompanyObject getCompanyObjectById(int id) {
////		return companyRepository.getCompanyObjectById(id);
////	}
////
////	/**
////	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
////	 *
////	 * @author yassine amira
////	 * 
////	 *         Using JRE: 1.8
////	 * 
////	 *         Project Name: Module-core-hr
////	 * 
////	 *         Class Name: CompanyService.java
////	 * 
////	 *         Gets the ats detail.
////	 * @param idCompany
////	 *            the id company
////	 * @return the ats detail
////	 */
////	public AtsDetail getAtsDetail(int idCompany) {
////		return companyRepository.getAtsDetail(idCompany);
////	}
////
////	/**
////	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
////	 *
////	 * @author wmhamdi
////	 * 
////	 *         Using JRE: 1.8
////	 * 
////	 *         Project Name: Module-core-hr
////	 * 
////	 *         Class Name: CompanyService.java
////	 * 
////	 *         Gets names companys
////	 * @param idCompany
////	 *            the id company
////	 * @return the list of name company
////	 */
////	public List<CompanyDto> getCompanyName() {
////		return companyRepository.getAllCompanyName();
////	}
//
//}
