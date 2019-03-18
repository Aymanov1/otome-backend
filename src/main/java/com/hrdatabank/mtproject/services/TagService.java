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

@Service
public class TagService {
	/** The tag repository. */
	private static Logger log = LoggerFactory.getLogger(TagService.class);

	@Autowired
	private TagRepository tagRepository;

	public void setTagRepository(TagRepository tagRepository) {
		this.tagRepository = tagRepository;
	}

	public Iterable<Tag> listAllTags() {
		return tagRepository.findAll();
	}

	public Optional<Tag> getTagById(long id) {
		return tagRepository.findById(id);
	}

	public Tag saveTag(Tag tag) {
		return tagRepository.save(tag);
	}

	public void deleteTag(Tag tag) {
		tagRepository.delete(tag);
	}

	public Tag getTagByTagText(String tagText) {
		return tagRepository.getTagByTagText(tagText);
	}

	public Page<Tag> getPaginatedTagsBykeyword(String keyword, int page, int size) {
		log.info("-----getPaginatedTagsBykeyword-----------keyword------------------------:  {}", keyword);
		log.info("--------getPaginatedTagsBykeyword--------page------------------------:  {}", page);
		log.info("------getPaginatedTagsBykeyword----------size------------------------:  {}", size);
		return tagRepository.getPaginatedTagsBykeyword(keyword, PageRequest.of(page, size));
	}
}
