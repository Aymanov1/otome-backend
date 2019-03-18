package com.hrdatabank.mtproject.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.hrdatabank.mtproject.entities.Chat;

/**
 * The Interface ChatRepository.
 */
@Repository
@RepositoryRestResource
public interface ChatRepository extends JpaRepository<Chat, Serializable> {

}
