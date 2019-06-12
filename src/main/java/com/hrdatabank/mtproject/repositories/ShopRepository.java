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

import com.hrdatabank.mtproject.entities.Shop;
import com.hrdatabank.mtproject.model.ShopObject;

/**
 * The Interface ShopRepository.
 */
@Repository
@RepositoryRestResource
public interface ShopRepository extends JpaRepository<Shop, Serializable> {

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: ShopRepository.java
	 * 
	 *         Find by name shop.
	 * @param nameShop
	 *            the name shop
	 * @return the shop
	 */
	@Query(value = "select s from Shop s where lower(s.nameShop) like lower(:nameShop)")
	public Shop findByNameShop(@Param("nameShop") String nameShop);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: ShopRepository.java
	 * 
	 *         Find by name shop and by address.
	 * @param nameShop
	 *            the name shop
	 * @param addressShop
	 *            the address shop
	 * @return the shop
	 */
	@Query(value = "select s from Shop s where lower(s.nameShop) like lower(:nameShop) and lower(s.addressShop) like lower(:addressShop) ")
	public Shop findByNameShopAndByAddress(@Param("nameShop") String nameShop,
			@Param("addressShop") String addressShop);

	@Query(value = "select s from Shop s where lower(s.nameShop) like lower(:nameShop) and lower(s.addressShop) like lower(:addressShop) ")
	public List<Shop> findListShopByNameShopAndByAddress(@Param("nameShop") String nameShop,
			@Param("addressShop") String addressShop);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: ShopRepository.java
	 * 
	 *         Find all shops by keyword paginated.
	 * @param pageable
	 *            the pageable
	 * @param keyword
	 *            the keyword
	 * @return the page
	 */
	@Query(value = "SELECT s from Shop s where ((lower(s.company.nameCompany) NOT like lower('テスト会社')) and (lower(s.nameShop) like lower(CONCAT('%',:keyword,'%')) or (lower(s.company.nameCompany) like lower(CONCAT('%',:keyword,'%'))) or (lower(s.addressShop) like lower(CONCAT('%',:keyword,'%'))))) ORDER BY s.company.idCompany ASC, s.idShop ASC ", countQuery = "SELECT COUNT(*) from Shop s where (lower(s.company.nameCompany) NOT like lower('テスト会社')) and  (lower(s.nameShop) like lower(CONCAT('%',:keyword,'%')) or (lower(s.company.nameCompany) like lower(CONCAT('%',:keyword,'%')))  or (lower(s.addressShop) like lower(CONCAT('%',:keyword,'%'))))")
	public Page<Shop> findAllShopsByKeywordPaginated(Pageable pageable, @Param("keyword") String keyword);

	@Query(value = "SELECT s from Shop s where ((lower(s.company.nameCompany) NOT like lower('テスト会社')) and (lower(s.nameShop) like lower(CONCAT('%',:keyword,'%')) or (lower(s.company.nameCompany) like lower(CONCAT('%',:keyword,'%'))) or (lower(s.addressShop) like lower(CONCAT('%',:keyword,'%'))))) ORDER BY s.company.idCompany ASC, s.idShop ASC ", countQuery = "SELECT COUNT(*) from Shop s where (lower(s.company.nameCompany) NOT like lower('テスト会社')) and  (lower(s.nameShop) like lower(CONCAT('%',:keyword,'%')) or (lower(s.company.nameCompany) like lower(CONCAT('%',:keyword,'%')))  or (lower(s.addressShop) like lower(CONCAT('%',:keyword,'%'))))")
	public List<Shop> findAllShopsByKeyword(@Param("keyword") String keyword);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: ShopRepository.java
	 * 
	 *         Gets the all shops by id company.
	 * @param idCompany
	 *            the id company
	 * @return the all shops by id company
	 */
	@Query("Select s from Shop s where s.company.idCompany=:idCompany")
	public List<Shop> getAllShopsByIdCompany(@Param("idCompany") int idCompany);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: ShopRepository.java
	 * 
	 *         Gets the shop by id CSV shop.
	 * @param idShopCSV
	 *            the id shop CSV
	 * @return the shop by id CSV shop
	 */
	@Query("Select s from Shop s where lower(s.idShopCSV) like lower(:idShopCSV)")
	public Shop getShopByIdCSVShop(@Param("idShopCSV") String idShopCSV);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: ShopRepository.java
	 * 
	 *         Gets the all shops objects.
	 * @return the all shops objects
	 */
	@Query("Select NEW com.hrdatabank.mtproject.model.ShopObject(s.idShop, s.nameShop) from Shop s")
	public List<ShopObject> getAllShopsObjects();

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: ShopRepository.java
	 * 
	 *         Gets the all shops objects by id company.
	 * @param idCompany
	 *            the id company
	 * @return the all shops objects by id company
	 */
	@Query("Select NEW com.hrdatabank.mtproject.model.ShopObject(s.idShop, s.nameShop) from Shop s where s.company.idCompany=:idCompany")
	public List<ShopObject> getAllShopsObjectsByIdCompany(@Param("idCompany") int idCompany);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: ShopRepository.java
	 * 
	 *         Gets the shop by id shop and id company.
	 * @param idCompany
	 *            the id company
	 * @param idShop
	 *            the id shop
	 * @return the shop by id shop and id company
	 */
	@Query("Select s from Shop s where s.company.idCompany=:idCompany and s.idShop=:idShop")
	public Shop getShopByIdShopAndIdCompany(@Param("idCompany") int idCompany, @Param("idShop") int idShop);

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author yassine amira
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: ShopRepository.java
	 * 
	 *         Gets the all shops by id company by name paginated.
	 * @param pageable
	 *            the pageable
	 * @param idCompany
	 *            the id company
	 * @param name
	 *            the name
	 * @return the all shops by id company by name paginated
	 */
	@Query(value = "Select s from Shop s where s.company.idCompany=:idCompany and ((lower(s.nameShop) like lower(CONCAT('%',:name,'%'))) or (lower(s.addressShop) like lower(CONCAT('%',:name,'%')))) ORDER BY s.company.idCompany ASC, s.idShop ASC", countQuery = "Select COUNT(*) from Shop s where s.company.idCompany=:idCompany and ((lower(s.nameShop) like lower(CONCAT('%',:name,'%')))  or (lower(s.addressShop) like lower(CONCAT('%',:name,'%'))))")
	public Page<Shop> getAllShopsByIdCompanyByNamePaginated(Pageable pageable, @Param("idCompany") int idCompany,
			@Param("name") String name);

	@Query(value = "select * from shop s where position (lower(:nameShop) in lower(s.name_shop)) > 0 and position (lower(:addressShop) in lower(s.address_shop)) > 0 ", nativeQuery = true)
	public List<Shop> findListShopByNameShopAndByAddress_Position(@Param("nameShop") String nameShop,
			@Param("addressShop") String addressShop);

	@Query(value = "select * from shop s where (lower(:addressShop) in lower(s.address_shop)) > 0 ", nativeQuery = true)
	public List<Shop> findListShopByAddress_Position(@Param("addressShop") String addressShop);

}
