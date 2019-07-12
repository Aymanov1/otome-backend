package com.hrdatabank.mtproject.repositories;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.hrdatabank.mtproject.entities.Tag;

// TODO: Auto-generated Javadoc
/**
 * The Interface TagRepository.
 */
@Repository
@RepositoryRestResource
public interface TagRepository extends JpaRepository<Tag, Serializable> {

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: TagRepository.java
	 * 
	 * Gets the paginated tags bykeyword.
	 * @param keyword the keyword
	 * @param pageable the pageable
	 * @return the paginated tags bykeyword
	 */
	@Query(value = "Select t from Tag t where lower(t.tagText) like lower(CONCAT('%',:keyword,'%'))")
	public Page<Tag> getPaginatedTagsBykeyword(@Param("keyword") String keyword, Pageable pageable);

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: TagRepository.java
	 * 
	 * Gets the tag by tag text.
	 * @param tagText the tag text
	 * @return the tag by tag text
	 */
	@Query(value = "Select t from Tag t where lower(t.tagText) like lower(:tagText)")
	public Tag getTagByTagText(@Param("tagText") String tagText);

}
