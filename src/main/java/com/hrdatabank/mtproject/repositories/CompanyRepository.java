package com.hrdatabank.mtproject.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.hrdatabank.mtproject.entities.Company;
import com.hrdatabank.mtproject.entities.CompanyObject;
import com.hrdatabank.mtproject.model.AtsDetail;
import com.hrdatabank.mtproject.model.CompanyDto;

/**
 * The Interface CompanyRepository.
 */
@Repository
@RepositoryRestResource
public interface CompanyRepository extends JpaRepository<Company, Serializable> {

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: CompanyRepository.java
	 * 
	 *         Find by name company.
	 * @param name
	 *            the name
	 * @return the company
	 */
	@Query(value = "select c from Company c where c.nameCompany =:name")
	public Company findByNameCompany(@Param("name") String name);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: CompanyRepository.java
	 * 
	 *         Find by login id company.
	 * @param loginId
	 *            the login id
	 * @return the company
	 */
	@Query(value = "select c from Company c where c.loginId =:loginId")
	public Company findByLoginIdCompany(@Param("loginId") String loginId);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: CompanyRepository.java
	 * 
	 *         List all companies by keyword paginated.
	 * @param pageable
	 *            the pageable
	 * @param keyword
	 *            the keyword
	 * @return the page
	 */
	@Query(value = "SELECT c from Company c where lower(c.nameCompany) like lower(CONCAT('%',:keyword,'%')) order by c.idCompany ", countQuery = "SELECT COUNT(*) from  Company c  where lower(c.nameCompany) like lower(CONCAT('%',:keyword,'%'))")
	public Page<Company> listAllCompaniesByKeywordPaginated(Pageable pageable, @Param("keyword") String keyword);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: CompanyRepository.java
	 * 
	 *         Gets the all companies objects.
	 * @return the all companies objects
	 */
	@Query("Select NEW com.hrdatabank.mtproject.entities.CompanyObject(c.idCompany, c.nameCompany,c.description, c.phoneNumber,c.addressCompany,c.emailCompany,c.logoCompany) from Company c")
	List<CompanyObject> getAllCompaniesObjects();

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: CompanyRepository.java
	 * 
	 *         Gets the company object by id.
	 * @param idCompany
	 *            the id company
	 * @return the company object by id
	 */
	@Query(value = "select  NEW com.hrdatabank.mtproject.entities.CompanyObject(c.idCompany, c.nameCompany,c.description, c.phoneNumber,c.addressCompany,c.emailCompany,c.logoCompany,c.paymentCycle ,c.companyFax ,c.responsiblePerson ,c.companyContractPeriod ,c.traningPeriod ,c.educationHistory )from Company c where c.idCompany=:idCompany")
	public CompanyObject getCompanyObjectById(@Param("idCompany") int idCompany);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: CompanyRepository.java
	 * 
	 *         Gets the ats detail.
	 * @param idCompany
	 *            the id company
	 * @return the ats detail
	 */
	@Query(value = "select  NEW com.hrdatabank.mtproject.model.AtsDetail(c.loginId,c.password,c.atsStatus) from Company c where c.idCompany =:idCompany")
	public AtsDetail getAtsDetail(@Param("idCompany") int idCompany);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author wmhamdi
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: CompanyRepository.java
	 * 
	 *         Gets list comapany name.
	 * 
	 */
	@Query(value = "select  NEW com.hrdatabank.mtproject.model.AtsDetail(c.loginId,c.password,c.atsStatus) from Company c where c.idCompany =:idCompany")
	public AtsDetail getAllCompany();

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author wmhamdi
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: CompanyRepository.java
	 * 
	 *         Find by name company.
	 * 
	 * @return list Name company
	 */
	@Query(value = "Select NEW com.hrdatabank.mtproject.model.CompanyDto(c.idCompany,c.nameCompany ) from Company c ")
	public List<CompanyDto> getAllCompanyName();

}
