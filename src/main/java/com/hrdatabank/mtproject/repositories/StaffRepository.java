package com.hrdatabank.mtproject.repositories;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.hrdatabank.mtproject.entities.Staff;
import com.hrdatabank.mtproject.model.ConnectedStaff;

/**
 * The Interface StaffRepository.
 */
@Repository
@RepositoryRestResource
public interface StaffRepository extends JpaRepository<Staff, Serializable> {

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: StaffRepository.java
	 * 
	 *         Find staff by username.
	 * @param username
	 *            the username
	 * @return the optional
	 */
	@Query("select u from Staff u  where u.email=:email")
	public Optional<Staff> findStaffByUsername(@Param("email") String username);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: StaffRepository.java
	 * 
	 *         Find staff by email.
	 * @param username
	 *            the username
	 * @return the staff
	 */
	@Query("select u from Staff u  where u.email=:email")
	public Staff findStaffByEmail(@Param("email") String username);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: StaffRepository.java
	 * 
	 *         Gets the staffs not having yet relations with sops paginated.
	 * @param pageable
	 *            the pageable
	 * @param keyword
	 *            the keyword
	 * @return the staffs not having yet relations with sops paginated
	 */
	@Query(value = "SELECT s from Staff s where (lower(s.staffName) like lower(CONCAT('%',:keyword,'%')) and s.staffShopRelations IS EMPTY)", countQuery = "SELECT COUNT(*) from  Staff s where (lower(s.staffName) like lower(CONCAT('%',:keyword,'%')) and s.staffShopRelations IS EMPTY)")
	public Page<Staff> getStaffsNotHavingYetRelationsWithSopsPaginated(Pageable pageable,
			@Param("keyword") String keyword);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: StaffRepository.java
	 * 
	 *         Gets the all staffs by keyword paginated.
	 * @param pageable
	 *            the pageable
	 * @param keyword
	 *            the keyword
	 * @return the all staffs by keyword paginated
	 */
	@Query(value = "SELECT s from Staff s where lower(s.staffName) like lower(CONCAT('%',:keyword,'%'))", countQuery = "SELECT COUNT(*) from  Staff s where lower(s.staffName) like lower(CONCAT('%',:keyword,'%'))")
	public Page<Staff> getAllStaffsByKeywordPaginated(Pageable pageable, @Param("keyword") String keyword);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: StaffRepository.java
	 * 
	 *         Find connected staff by email.
	 * @param username
	 *            the username
	 * @return the connected staff
	 */
	@Query("select NEW com.hrdatabank.mtproject.model.ConnectedStaff(u.company.idCompany, u.idUser, superStaff) from Staff u  where u.email=:email ")
	public ConnectedStaff findConnectedStaffByEmail(@Param("email") String username);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Wala ben Amor
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: StaffRepository.java
	 * 
	 *         Gets the all staffs by keyword paginated.
	 * @param pageable
	 *            the pageable
	 * @param keyword
	 *            the keyword * @param idCompany the idCompany
	 * @return the all staffs by keyword paginated
	 */
	@Query(value = "SELECT s from Staff s where (lower(s.staffName) like lower(CONCAT('%',:keyword,'%'))) and (s.company.idCompany=:idCompany)", countQuery = "SELECT COUNT(*) from  Staff s where (lower(s.staffName) like lower(CONCAT('%',:keyword,'%'))) and (s.company.idCompany=:idCompany)")
	public Page<Staff> getAllStaffListByIdCompanyPaginated(Pageable pageable, @Param("keyword") String keyword,
			@Param("idCompany") int idCompany);

}
