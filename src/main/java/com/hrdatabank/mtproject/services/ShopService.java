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
//import com.hrdatabank.mtproject.entities.Shop;
//import com.hrdatabank.mtproject.model.ShopObject;
//import com.hrdatabank.mtproject.repositories.ShopRepository;
//
///**
// * The Class ShopService.
// */
//@Service
//public class ShopService {
//
//	/** The shop repository. */
//	@Autowired
//	private ShopRepository shopRepository;
//
//	/**
//	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
//	 *
//	 * @author Hanios
//	 * 
//	 *         Using JRE: 1.8
//	 * 
//	 *         Project Name: Module-core-hr
//	 * 
//	 *         Class Name: ShopService.java
//	 * 
//	 *         Sets the shop repository.
//	 * @param shopRepository
//	 *            the new shop repository
//	 */
//	public void setShopRepository(ShopRepository shopRepository) {
//		this.shopRepository = shopRepository;
//	}
//
//	/**
//	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
//	 *
//	 * @author Hanios
//	 * 
//	 *         Using JRE: 1.8
//	 * 
//	 *         Project Name: Module-core-hr
//	 * 
//	 *         Class Name: ShopService.java
//	 * 
//	 *         List paginated shops.
//	 * @param page
//	 *            the page
//	 * @param size
//	 *            the size
//	 * @return the page
//	 */
//	public Page<Shop> listPaginatedShops(int page, int size) {
//		return shopRepository.findAll(PageRequest.of(page, size));
//	}
//
//	/**
//	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
//	 *
//	 * @author Hanios
//	 * 
//	 *         Using JRE: 1.8
//	 * 
//	 *         Project Name: Module-core-hr
//	 * 
//	 *         Class Name: ShopService.java
//	 * 
//	 *         Gets the shop by id.
//	 * @param id
//	 *            the id
//	 * @return the shop by id
//	 */
//	public Optional<Shop> getShopById(long id) {
//		return shopRepository.findById(id);
//	}
//
//	/**
//	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
//	 *
//	 * @author Hanios
//	 * 
//	 *         Using JRE: 1.8
//	 * 
//	 *         Project Name: Module-core-hr
//	 * 
//	 *         Class Name: ShopService.java
//	 * 
//	 *         Gets the shop by id CSV shop.
//	 * @param id
//	 *            the id
//	 * @return the shop by id CSV shop
//	 */
//	public Shop getShopByIdCSVShop(String id) {
//		return shopRepository.getShopByIdCSVShop(id);
//	}
//
//	/**
//	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
//	 *
//	 * @author Hanios
//	 * 
//	 *         Using JRE: 1.8
//	 * 
//	 *         Project Name: Module-core-hr
//	 * 
//	 *         Class Name: ShopService.java
//	 * 
//	 *         Save shop.
//	 * @param shop
//	 *            the shop
//	 * @return the shop
//	 */
//	public Shop saveShop(Shop shop) {
//		return shopRepository.save(shop);
//	}
//
//	/**
//	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
//	 *
//	 * @author Hanios
//	 * 
//	 *         Using JRE: 1.8
//	 * 
//	 *         Project Name: Module-core-hr
//	 * 
//	 *         Class Name: ShopService.java
//	 * 
//	 *         this method Delete shop.
//	 * @param idShop
//	 *            the id shop
//	 */
//	public void deleteShop(long idShop) {
//		shopRepository.deleteById(idShop);
//	}
//
//	/**
//	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
//	 *
//	 * @author Hanios
//	 * 
//	 *         Using JRE: 1.8
//	 * 
//	 *         Project Name: Module-core-hr
//	 * 
//	 *         Class Name: ShopService.java
//	 * 
//	 *         List all shops.
//	 * @return the list
//	 */
//	public List<Shop> listAllShops() {
//		return shopRepository.findAll();
//	}
//
//	/**
//	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
//	 *
//	 * @author Hanios
//	 * 
//	 *         Using JRE: 1.8
//	 * 
//	 *         Project Name: Module-core-hr
//	 * 
//	 *         Class Name: ShopService.java
//	 * 
//	 *         List all shops objects.
//	 * @return the list
//	 */
//	public List<ShopObject> listAllShopsObjects() {
//		return shopRepository.getAllShopsObjects();
//	}
//
//	/**
//	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
//	 *
//	 * @author Hanios
//	 * 
//	 *         Using JRE: 1.8
//	 * 
//	 *         Project Name: Module-core-hr
//	 * 
//	 *         Class Name: ShopService.java
//	 * 
//	 *         Find by name shop.
//	 * @param name
//	 *            the name
//	 * @return the shop
//	 */
//	public Shop findByNameShop(String name) {
//		return shopRepository.findByNameShop(name);
//	}
//
//	/**
//	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
//	 *
//	 * @author Hanios
//	 * 
//	 *         Using JRE: 1.8
//	 * 
//	 *         Project Name: Module-core-hr
//	 * 
//	 *         Class Name: ShopService.java
//	 * 
//	 *         Find by name shop and by address.
//	 * @param nameShop
//	 *            the name shop
//	 * @param addressShop
//	 *            the address shop
//	 * @return the shop
//	 */
//	public Shop findByNameShopAndByAddress(String nameShop, String addressShop) {
//		return shopRepository.findByNameShopAndByAddress(nameShop, addressShop);
//	}
//
//	public List<Shop> findListShopByNameShopAndByAddress(String nameShop, String addressShop) {
//		return shopRepository.findListShopByNameShopAndByAddress(nameShop, addressShop);
//	}
//
//	/**
//	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
//	 *
//	 * @author Hanios
//	 * 
//	 *         Using JRE: 1.8
//	 * 
//	 *         Project Name: Module-core-hr
//	 * 
//	 *         Class Name: ShopService.java
//	 * 
//	 *         List paginated shops keyword.
//	 * @param page
//	 *            the page
//	 * @param size
//	 *            the size
//	 * @param keyword
//	 *            the keyword
//	 * @return the page
//	 */
//	public Page<Shop> listPaginatedShopsKeyword(int page, int size, String keyword) {
//		return shopRepository.findAllShopsByKeywordPaginated(PageRequest.of(page, size), keyword);
//	}
//
//	public List<Shop> findAllShopsByKeyword(String keyword) {
//		return shopRepository.findAllShopsByKeyword(keyword);
//	}
//
//	/**
//	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
//	 *
//	 * @author Hanios
//	 * 
//	 *         Using JRE: 1.8
//	 * 
//	 *         Project Name: Module-core-hr
//	 * 
//	 *         Class Name: ShopService.java
//	 * 
//	 *         Gets the all shops by id company.
//	 * @param idCompany
//	 *            the id company
//	 * @return the all shops by id company
//	 */
//	public List<Shop> getAllShopsByIdCompany(int idCompany) {
//		return shopRepository.getAllShopsByIdCompany(idCompany);
//	}
//
//	/**
//	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
//	 *
//	 * @author Hanios
//	 * 
//	 *         Using JRE: 1.8
//	 * 
//	 *         Project Name: Module-core-hr
//	 * 
//	 *         Class Name: ShopService.java
//	 * 
//	 *         Gets the all shops objects by id company.
//	 * @param idCompany
//	 *            the id company
//	 * @return the all shops objects by id company
//	 */
//	public List<ShopObject> getAllShopsObjectsByIdCompany(int idCompany) {
//		return shopRepository.getAllShopsObjectsByIdCompany(idCompany);
//	}
//
//	/**
//	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
//	 *
//	 * @author Hanios
//	 * 
//	 *         Using JRE: 1.8
//	 * 
//	 *         Project Name: Module-core-hr
//	 * 
//	 *         Class Name: ShopService.java
//	 * 
//	 *         Gets the shop by id shop and id company.
//	 * @param idCompany
//	 *            the id company
//	 * @param idShop
//	 *            the id shop
//	 * @return the shop by id shop and id company
//	 */
//	public Shop getShopByIdShopAndIdCompany(int idCompany, int idShop) {
//		return shopRepository.getShopByIdShopAndIdCompany(idCompany, idShop);
//	}
//
//	/**
//	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
//	 *
//	 * @author Hanios
//	 * 
//	 *         Using JRE: 1.8
//	 * 
//	 *         Project Name: Module-core-hr
//	 * 
//	 *         Class Name: ShopService.java
//	 * 
//	 *         Gets the all shops by id company by name paginated.
//	 * @param page
//	 *            the page
//	 * @param size
//	 *            the size
//	 * @param idCompany
//	 *            the id company
//	 * @param name
//	 *            the name
//	 * @return the all shops by id company by name paginated
//	 */
//	public Page<Shop> getAllShopsByIdCompanyByNamePaginated(int page, int size, int idCompany, String name) {
//		return shopRepository.getAllShopsByIdCompanyByNamePaginated(PageRequest.of(page, size), idCompany, name);
//
//	}
//
//	public List<Shop> findListShopByNameShopAndByAddress_Position(String shopName, String shopAddresse) {
//		return shopRepository.findListShopByNameShopAndByAddress_Position(shopName, shopAddresse);
//	}
//
//	public List<Shop> findListShopByAddress_Position(String addressShop) {
//		return shopRepository.findListShopByAddress_Position(addressShop);
//	}
//}
