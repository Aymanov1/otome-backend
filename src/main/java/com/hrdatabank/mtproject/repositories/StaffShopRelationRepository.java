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

import com.hrdatabank.mtproject.entities.StaffShopRelation;
import com.hrdatabank.mtproject.model.ShopObject;

/**
 * The Interface StaffShopRelationRepository.
 */
@Repository
@RepositoryRestResource
public interface StaffShopRelationRepository extends JpaRepository<StaffShopRelation, Serializable> {

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: StaffShopRelationRepository.java
	 * 
	 *         Gets the all staff shop relations by keyword paginated.
	 * @param pageable
	 *            the pageable
	 * @param keyword
	 *            the keyword
	 * @return the all staff shop relations by keyword paginated
	 */
	@Query(value = "SELECT ssr from StaffShopRelation ssr where lower(ssr.staff.staffName) like lower(CONCAT('%',:keyword,'%'))  or lower(ssr.shop.nameShop) like lower(CONCAT('%',:keyword,'%'))", countQuery = "SELECT COUNT(*) from  StaffShopRelation ssr where lower(ssr.staff.staffName) like lower(CONCAT('%',:keyword,'%'))  or lower(ssr.shop.nameShop) like lower(CONCAT('%',:keyword,'%'))")
	public Page<StaffShopRelation> getAllStaffShopRelationsByKeywordPaginated(Pageable pageable,
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
	 *         Class Name: StaffShopRelationRepository.java
	 * 
	 *         Gets the all staff shop relations by id staff.
	 * @param idStaff
	 *            the id staff
	 * @return the all staff shop relations by id staff
	 */
	@Query(value = "SELECT ssr from StaffShopRelation ssr where (ssr.staffShopRelationPK.idStaff =:idStaff) ", countQuery = "SELECT COUNT(*) from  StaffShopRelation ssr where (ssr.staffShopRelationPK.idStaff =:idStaff)")
	public List<StaffShopRelation> getAllStaffShopRelationsByIdStaff(@Param("idStaff") int idStaff);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: StaffShopRelationRepository.java
	 * 
	 *         Gets the staff shop relation by id shop id staff.
	 * @param idShop
	 *            the id shop
	 * @param idStaff
	 *            the id staff
	 * @return the staff shop relation by id shop id staff
	 */
	@Query(value = "SELECT ssr from StaffShopRelation ssr where (ssr.staffShopRelationPK.idStaff =:idStaff and ssr.staffShopRelationPK.idShop =:idShop) ", countQuery = "SELECT COUNT(*) from  StaffShopRelation ssr where (ssr.staffShopRelationPK.idStaff =:idStaff and ssr.staffShopRelationPK.idShop =:idShop)")
	public StaffShopRelation getStaffShopRelationByIdShopIdStaff(@Param("idShop") int idShop,
			@Param("idStaff") int idStaff);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: StaffShopRelationRepository.java
	 * 
	 *         Gets the all shop staff by id company by name paginated.
	 * @param pageable
	 *            the pageable
	 * @param idCompany
	 *            the id company
	 * @param name
	 *            the name
	 * @return the all shop staff by id company by name paginated
	 */
	@Query(value = "Select s from StaffShopRelation s where s.shop.company.idCompany=:idCompany and lower(s.shop.nameShop) like lower(CONCAT('%',:name,'%'))", countQuery = "Select COUNT(*) from StaffShopRelation s where s.shop.company.idCompany=:idCompany and lower(s.shop.nameShop) like lower(CONCAT('%',:name,'%'))")
	public Page<StaffShopRelation> getAllShopStaffByIdCompanyByNamePaginated(Pageable pageable,
			@Param("idCompany") int idCompany, @Param("name") String name);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: StaffShopRelationRepository.java
	 * 
	 *         Gets the all staff shop relations by keyword paginated integer.
	 * @param pageable
	 *            the pageable
	 * @param keyword
	 *            the keyword
	 * @return the all staff shop relations by keyword paginated integer
	 */
	@Query(value = "SELECT ssr.staffShopRelationPK.idStaff from StaffShopRelation ssr where lower(ssr.staff.staffName) like lower(CONCAT('%',:keyword,'%'))  or lower(ssr.shop.nameShop) like lower(CONCAT('%',:keyword,'%')) GROUP BY ssr.staffShopRelationPK.idStaff", countQuery = "SELECT COUNT(*) from  StaffShopRelation ssr where lower(ssr.staff.staffName) like lower(CONCAT('%',:keyword,'%'))  or lower(ssr.shop.nameShop) like lower(CONCAT('%',:keyword,'%'))")
	public Page<Integer> getAllStaffShopRelationsByKeywordPaginatedInteger(Pageable pageable,
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
	 *         Class Name: StaffShopRelationRepository.java
	 * 
	 *         Gets the manage progress staff shop relations by id staff.
	 * @param idStaff
	 *            the id staff
	 * @param idCompany
	 *            the id company
	 * @return the manage progress staff shop relations by id staff
	 */
	@Query(value = "SELECT NEW com.hrdatabank.mtproject.model.ShopObject(ssr.staffShopRelationPK.idShop, ssr.shop.nameShop) from StaffShopRelation ssr where ssr.staffShopRelationPK.idStaff =:idStaff and ssr.shop.company.idCompany =:idCompany  and ssr.manageProgress = TRUE", countQuery = "SELECT COUNT(*) from StaffShopRelation ssr where ssr.staffShopRelationPK.idStaff =:idStaff and ssr.shop.company.idCompany =:idCompany  and ssr.manageProgress = TRUE")
	public List<ShopObject> getManageProgressStaffShopRelationsByIdStaff(@Param("idStaff") int idStaff,
			@Param("idCompany") int idCompany);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: StaffShopRelationRepository.java
	 * 
	 *         Gets the manage job staff shop relations by id staff.
	 * @param idStaff
	 *            the id staff
	 * @param idCompany
	 *            the id company
	 * @return the manage job staff shop relations by id staff
	 */
	@Query(value = "SELECT NEW com.hrdatabank.mtproject.model.ShopObject(ssr.staffShopRelationPK.idShop, ssr.shop.nameShop) from StaffShopRelation ssr where ssr.staffShopRelationPK.idStaff =:idStaff and ssr.shop.company.idCompany =:idCompany and ssr.manageJob = TRUE", countQuery = "SELECT COUNT(*) from StaffShopRelation ssr where ssr.staffShopRelationPK.idStaff =:idStaff and ssr.shop.company.idCompany =:idCompany and ssr.manageJob = TRUE")
	public List<ShopObject> getManageJobStaffShopRelationsByIdStaff(@Param("idStaff") int idStaff,
			@Param("idCompany") int idCompany);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: StaffShopRelationRepository.java
	 * 
	 *         Gets the manage shop staff shop relations by id staff.
	 * @param idStaff
	 *            the id staff
	 * @param idCompany
	 *            the id company
	 * @return the manage shop staff shop relations by id staff
	 */
	@Query(value = "SELECT NEW com.hrdatabank.mtproject.model.ShopObject(ssr.staffShopRelationPK.idShop, ssr.shop.nameShop) from StaffShopRelation ssr where ssr.staffShopRelationPK.idStaff =:idStaff and ssr.shop.company.idCompany =:idCompany  and ssr.manageShop = TRUE", countQuery = "SELECT COUNT(*) from StaffShopRelation ssr where ssr.staffShopRelationPK.idStaff =:idStaff and ssr.shop.company.idCompany =:idCompany  and ssr.manageShop = TRUE")
	public List<ShopObject> getManageShopStaffShopRelationsByIdStaff(@Param("idStaff") int idStaff,
			@Param("idCompany") int idCompany);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: StaffShopRelationRepository.java
	 * 
	 *         Gets the manage authority staff shop relations by id staff and id
	 *         company.
	 * @param idStaff
	 *            the id staff
	 * @param idCompany
	 *            the id company
	 * @return the manage authority staff shop relations by id staff and id company
	 */
	@Query(value = "SELECT NEW com.hrdatabank.mtproject.model.ShopObject(ssr.staffShopRelationPK.idShop, ssr.shop.nameShop) from StaffShopRelation ssr where ssr.staffShopRelationPK.idStaff =:idStaff and ssr.shop.company.idCompany =:idCompany  and ssr.manageAuthority = TRUE", countQuery = "SELECT COUNT(*) from StaffShopRelation ssr where ssr.staffShopRelationPK.idStaff =:idStaff and ssr.shop.company.idCompany =:idCompany  and ssr.manageAuthority = TRUE")
	public List<ShopObject> getManageAuthorityStaffShopRelationsByIdStaffAndIdCompany(@Param("idStaff") int idStaff,
			@Param("idCompany") int idCompany);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: StaffShopRelationRepository.java
	 * 
	 *         Gets the manage authority staff shop relations by id staff.
	 * @param idStaff
	 *            the id staff
	 * @return the manage authority staff shop relations by id staff
	 */
	@Query(value = "SELECT NEW com.hrdatabank.mtproject.model.ShopObject(ssr.staffShopRelationPK.idShop, ssr.shop.nameShop) from StaffShopRelation ssr where ssr.staffShopRelationPK.idStaff =:idStaff and ssr.manageAuthority = TRUE", countQuery = "SELECT COUNT(*) from StaffShopRelation ssr where ssr.staffShopRelationPK.idStaff =:idStaff and ssr.manageAuthority = TRUE")
	public List<ShopObject> getManageAuthorityStaffShopRelationsByIdStaff(@Param("idStaff") int idStaff);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: StaffShopRelationRepository.java
	 * 
	 *         Gets the full authority staff shop relations by id staff.
	 * @param idStaff
	 *            the id staff
	 * @param idCompany
	 *            the id company
	 * @return the full authority staff shop relations by id staff
	 */
	@Query(value = "SELECT NEW com.hrdatabank.mtproject.model.ShopObject(ssr.staffShopRelationPK.idShop, ssr.shop.nameShop) from StaffShopRelation ssr where ssr.staffShopRelationPK.idStaff =:idStaff and ssr.shop.company.idCompany =:idCompany  and ssr.authorizedShop = TRUE", countQuery = "SELECT COUNT(*) from StaffShopRelation ssr where ssr.staffShopRelationPK.idStaff =:idStaff and ssr.shop.company.idCompany =:idCompany  and ssr.authorizedShop = TRUE")
	public List<ShopObject> getFullAuthorityStaffShopRelationsByIdStaff(@Param("idStaff") int idStaff,
			@Param("idCompany") int idCompany);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: StaffShopRelationRepository.java
	 * 
	 *         Gets the manage authority staff shop relations by id company.
	 * @param idStaff
	 *            the id staff
	 * @param idCompany
	 *            the id company
	 * @return the manage authority staff shop relations by id company
	 */
	@Query(value = "SELECT NEW com.hrdatabank.mtproject.model.ShopObject(ssr.staffShopRelationPK.idShop, ssr.shop.nameShop) from StaffShopRelation ssr where ssr.staffShopRelationPK.idStaff =:idStaff and ssr.staff.company.idCompany =:idCompany and ssr.shop.company.idCompany =:idCompany  and ssr.manageAuthority = TRUE", countQuery = "SELECT COUNT(*) from StaffShopRelation ssr where ssr.staffShopRelationPK.idStaff =:idStaff and ssr.staff.company.idCompany =:idCompany and ssr.shop.company.idCompany =:idCompany  and ssr.manageAuthority = TRUE")
	public List<ShopObject> getManageAuthorityStaffShopRelationsByIdCompany(@Param("idStaff") int idStaff,
			@Param("idCompany") int idCompany);

}
