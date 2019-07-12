package com.hrdatabank.mtproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrdatabank.mtproject.entities.CandidateAdminRelation;
import com.hrdatabank.mtproject.entities.Memo;
import com.hrdatabank.mtproject.repositories.MemoRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class MemoService.
 */
@Service
public class MemoService {

	/** The memo repository. */
	@Autowired
	private MemoRepository memoRepository;

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: MemoService.java
	 * 
	 *         Sets the memo repository.
	 * @param memoRepository
	 *            the new memo repository
	 */
	public void setMemoRepository(MemoRepository memoRepository) {
		this.memoRepository = memoRepository;
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: MemoService.java
	 * 
	 *         List all memos.
	 * @return the iterable
	 */
	public Iterable<Memo> listAllMemos() {
		return memoRepository.findAll();
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: MemoService.java
	 * 
	 *         Gets the memo by id.
	 * @param id
	 *            the id
	 * @return the memo by id
	 */
	public Optional<Memo> getMemoById(long id) {
		return memoRepository.findById(id);
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: MemoService.java
	 * 
	 *         Save memo.
	 * @param memo
	 *            the memo
	 * @return the memo
	 */
	public Memo saveMemo(Memo memo) {
		return memoRepository.save(memo);
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: MemoService.java
	 * 
	 *         List memos by candidate admin relation.
	 * @param candidateAdminRelation
	 *            the candidate admin relation
	 * @return the list
	 */
	public List<Memo> listMemosByCandidateAdminRelation(CandidateAdminRelation candidateAdminRelation) {
		return memoRepository.listMemosByCandidateAdminRelation(candidateAdminRelation);
	}

	/**
	 * Copyright (c) 2018 by HRDatabank. All rights reserved.
	 *
	 * @author Hanios
	 * 
	 *         Using JRE: 1.8
	 * 
	 *         Project Name: Module-core-hr
	 * 
	 *         Class Name: MemoService.java
	 * 
	 *         List memos by id candidate.
	 * @param idCandidate
	 *            the id candidate
	 * @return the list
	 */
	public List<Memo> listMemosByIdCandidate(int idCandidate) {
		return memoRepository.listMemosByIdCandidate(idCandidate);
	}

}
