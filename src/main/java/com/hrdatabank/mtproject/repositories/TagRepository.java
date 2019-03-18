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

@Repository
@RepositoryRestResource
public interface TagRepository extends JpaRepository<Tag, Serializable> {

	@Query(value = "Select t from Tag t where lower(t.tagText) like lower(CONCAT('%',:keyword,'%'))")
	public Page<Tag> getPaginatedTagsBykeyword(@Param("keyword") String keyword, Pageable pageable);

	@Query(value = "Select t from Tag t where lower(t.tagText) like lower(:tagText)")
	public Tag getTagByTagText(@Param("tagText") String tagText);

}
