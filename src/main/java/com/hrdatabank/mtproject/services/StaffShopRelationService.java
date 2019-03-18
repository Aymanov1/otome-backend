package com.hrdatabank.mtproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.hrdatabank.mtproject.entities.StaffShopRelation;
import com.hrdatabank.mtproject.entities.StaffShopRelationPK;
import com.hrdatabank.mtproject.model.ShopObject;
import com.hrdatabank.mtproject.repositories.StaffShopRelationRepository;

/**
 * The Class StaffShopRelationService.
 */
@Service
public class StaffShopRelationService {

	/** The staff shop relation repository. */
	@Autowired
	private StaffShopRelationRepository staffShopRelationRepository;

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: StaffShopRelationService.java
	 * 
	 *         List all staff shop relations.
	 * @return the list
	 */
	public List<StaffShopRelation> listAllStaffShopRelations() {
		return staffShopRelationRepository.findAll();
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: StaffShopRelationService.java
	 * 
	 *         Gets the staff shop relation by PK.
	 * @param staffShopRelationPK
	 *            the staff shop relation PK
	 * @return the staff shop relation by PK
	 */
	public Optional<StaffShopRelation> getStaffShopRelationByPK(StaffShopRelationPK staffShopRelationPK) {
		return staffShopRelationRepository.findById(staffShopRelationPK);
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: StaffShopRelationService.java
	 * 
	 *         Save staff shop relation.
	 * @param staffShopRelation
	 *            the staff shop relation
	 * @return the staff shop relation
	 */
	public StaffShopRelation saveStaffShopRelation(StaffShopRelation staffShopRelation) {
		return staffShopRelationRepository.saveAndFlush(staffShopRelation);
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: StaffShopRelationService.java
	 * 
	 *         this method Delete staff shop relation.
	 * @param staffShopRelationPK
	 *            the staff shop relation PK
	 */
	public void deleteStaffShopRelation(StaffShopRelationPK staffShopRelationPK) {
		staffShopRelationRepository.deleteById(staffShopRelationPK);
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: StaffShopRelationService.java
	 * 
	 *         Gets the all staff shop relations by keyword paginated.
	 * @param page
	 *            the page
	 * @param size
	 *            the size
	 * @param keyword
	 *            the keyword
	 * @return the all staff shop relations by keyword paginated
	 */
	public Page<StaffShopRelation> getAllStaffShopRelationsByKeywordPaginated(int page, int size, String keyword) {
		return staffShopRelationRepository.getAllStaffShopRelationsByKeywordPaginated(PageRequest.of(page, size),
				keyword);
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: StaffShopRelationService.java
	 * 
	 *         Gets the all staff shop relations by id staff.
	 * @param idStaff
	 *            the id staff
	 * @return the all staff shop relations by id staff
	 */
	public List<StaffShopRelation> getAllStaffShopRelationsByIdStaff(int idStaff) {
		return staffShopRelationRepository.getAllStaffShopRelationsByIdStaff(idStaff);
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: StaffShopRelationService.java
	 * 
	 *         Gets the staff shop relation by id shop id staff.
	 * @param idShop
	 *            the id shop
	 * @param idStaff
	 *            the id staff
	 * @return the staff shop relation by id shop id staff
	 */
	public StaffShopRelation getStaffShopRelationByIdShopIdStaff(int idShop, int idStaff) {
		return staffShopRelationRepository.getStaffShopRelationByIdShopIdStaff(idShop, idStaff);
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: StaffShopRelationService.java
	 * 
	 *         Gets the all shop staff by id company by name paginated.
	 * @param page
	 *            the page
	 * @param size
	 *            the size
	 * @param idCompany
	 *            the id company
	 * @param name
	 *            the name
	 * @return the all shop staff by id company by name paginated
	 */
	public Page<StaffShopRelation> getAllShopStaffByIdCompanyByNamePaginated(int page, int size, int idCompany,
			String name) {
		return staffShopRelationRepository.getAllShopStaffByIdCompanyByNamePaginated(PageRequest.of(page, size),
				idCompany, name);
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: StaffShopRelationService.java
	 * 
	 *         Gets the all staff shop relations by keyword paginated integer.
	 * @param page
	 *            the page
	 * @param size
	 *            the size
	 * @param keyword
	 *            the keyword
	 * @return the all staff shop relations by keyword paginated integer
	 */
	public Page<Integer> getAllStaffShopRelationsByKeywordPaginatedInteger(int page, int size, String keyword) {
		return staffShopRelationRepository.getAllStaffShopRelationsByKeywordPaginatedInteger(PageRequest.of(page, size),
				keyword);
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: StaffShopRelationService.java
	 * 
	 *         Gets the manage progress staff shop relations by id staff.
	 * @param idStaff
	 *            the id staff
	 * @param idCompany
	 *            the id company
	 * @return the manage progress staff shop relations by id staff
	 */
	public List<ShopObject> getManageProgressStaffShopRelationsByIdStaff(int idStaff, int idCompany) {
		return staffShopRelationRepository.getManageProgressStaffShopRelationsByIdStaff(idStaff, idCompany);
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: StaffShopRelationService.java
	 * 
	 *         Gets the manage job staff shop relations by id staff.
	 * @param idStaff
	 *            the id staff
	 * @param idCompany
	 *            the id company
	 * @return the manage job staff shop relations by id staff
	 */
	public List<ShopObject> getManageJobStaffShopRelationsByIdStaff(int idStaff, int idCompany) {
		return staffShopRelationRepository.getManageJobStaffShopRelationsByIdStaff(idStaff, idCompany);
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: StaffShopRelationService.java
	 * 
	 *         Gets the manage shop staff shop relations by id staff.
	 * @param idStaff
	 *            the id staff
	 * @param idCompany
	 *            the id company
	 * @return the manage shop staff shop relations by id staff
	 */
	public List<ShopObject> getManageShopStaffShopRelationsByIdStaff(int idStaff, int idCompany) {
		return staffShopRelationRepository.getManageShopStaffShopRelationsByIdStaff(idStaff, idCompany);
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: StaffShopRelationService.java
	 * 
	 *         Gets the manage authority staff shop relations by id staff.
	 * @param idStaff
	 *            the id staff
	 * @return the manage authority staff shop relations by id staff
	 */
	public List<ShopObject> getManageAuthorityStaffShopRelationsByIdStaff(int idStaff) {
		return staffShopRelationRepository.getManageAuthorityStaffShopRelationsByIdStaff(idStaff);
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: StaffShopRelationService.java
	 * 
	 *         Gets the manage authority staff shop relations by id staff and id
	 *         company.
	 * @param idStaff
	 *            the id staff
	 * @param idCompany
	 *            the id company
	 * @return the manage authority staff shop relations by id staff and id company
	 */
	public List<ShopObject> getManageAuthorityStaffShopRelationsByIdStaffAndIdCompany(int idStaff, int idCompany) {
		return staffShopRelationRepository.getManageAuthorityStaffShopRelationsByIdStaffAndIdCompany(idStaff,
				idCompany);
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: StaffShopRelationService.java
	 * 
	 *         Gets the full authority staff shop relations by id staff.
	 * @param idStaff
	 *            the id staff
	 * @param idCompany
	 *            the id company
	 * @return the full authority staff shop relations by id staff
	 */
	public List<ShopObject> getFullAuthorityStaffShopRelationsByIdStaff(int idStaff, int idCompany) {
		return staffShopRelationRepository.getFullAuthorityStaffShopRelationsByIdStaff(idStaff, idCompany);
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: StaffShopRelationService.java
	 * 
	 *         Gets the manage authority staff shop relations by id company.
	 * @param idStaff
	 *            the id staff
	 * @param idCompany
	 *            the id company
	 * @return the manage authority staff shop relations by id company
	 */
	public List<ShopObject> getManageAuthorityStaffShopRelationsByIdCompany(int idStaff, int idCompany) {
		return staffShopRelationRepository.getManageAuthorityStaffShopRelationsByIdCompany(idStaff, idCompany);
	}

}
