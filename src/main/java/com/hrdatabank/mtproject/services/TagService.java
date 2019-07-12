package com.hrdatabank.mtproject.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.hrdatabank.mtproject.entities.Tag;
import com.hrdatabank.mtproject.repositories.TagRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class TagService.
 */
@Service
public class TagService {
	/** The tag repository. */
	private static Logger log = LoggerFactory.getLogger(TagService.class);

	/** The tag repository. */
	@Autowired
	private TagRepository tagRepository;

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: TagService.java
	 * 
	 * Sets the tag repository.
	 * @param tagRepository the new tag repository
	 */
	public void setTagRepository(TagRepository tagRepository) {
		this.tagRepository = tagRepository;
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: TagService.java
	 * 
	 * List all tags.
	 * @return the iterable
	 */
	public Iterable<Tag> listAllTags() {
		return tagRepository.findAll();
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: TagService.java
	 * 
	 * Gets the tag by id.
	 * @param id the id
	 * @return the tag by id
	 */
	public Optional<Tag> getTagById(long id) {
		return tagRepository.findById(id);
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: TagService.java
	 * 
	 * Save tag.
	 * @param tag the tag
	 * @return the tag
	 */
	public Tag saveTag(Tag tag) {
		return tagRepository.save(tag);
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: TagService.java
	 * 
	 * this method Delete tag.
	 * @param tag the tag
	 */
	public void deleteTag(Tag tag) {
		tagRepository.delete(tag);
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: TagService.java
	 * 
	 * Gets the tag by tag text.
	 * @param tagText the tag text
	 * @return the tag by tag text
	 */
	public Tag getTagByTagText(String tagText) {
		return tagRepository.getTagByTagText(tagText);
	}

	/**
	 * Copyright (c) 2019 by HRDatabank. All rights reserved.
	 *
	 * @author Aymanov
	 * 
	 * Using JRE: 1.8
	 * 
	 * Project Name: otome-backend
	 * 
	 * Class Name: TagService.java
	 * 
	 * Gets the paginated tags bykeyword.
	 * @param keyword the keyword
	 * @param page the page
	 * @param size the size
	 * @return the paginated tags bykeyword
	 */
	public Page<Tag> getPaginatedTagsBykeyword(String keyword, int page, int size) {
		log.info("-----getPaginatedTagsBykeyword-----------keyword------------------------:  {}", keyword);
		log.info("--------getPaginatedTagsBykeyword--------page------------------------:  {}", page);
		log.info("------getPaginatedTagsBykeyword----------size------------------------:  {}", size);
		return tagRepository.getPaginatedTagsBykeyword(keyword, PageRequest.of(page, size));
	}
}
