package com.hrdatabank.otome.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import com.hrdatabank.otome.domain.JobOtome;
import com.hrdatabank.otome.model.JobDto;
import com.hrdatabank.otome.repositories.JobOtomeReactiveRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;

/**
 * The Class JobOtomeServiceImpl.
 */
@CacheConfig(cacheNames = { "jobOtomes" })
@Service
@Transactional
public class JobOtomeServiceImpl implements JobReactiveService {

	/** The job otome reactive repository. */
	@Autowired
	private JobOtomeReactiveRepository jobOtomeReactiveRepository;

	/** The transaction template. */
	@Autowired
	private TransactionTemplate transactionTemplate;

	/** The jdbc scheduler. */
	@Autowired
	@Qualifier("jdbcScheduler")
	private Scheduler jdbcScheduler;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hrdatabank.otome.services.JobReactiveService#findById(long)
	 */
	@Override
	public Mono<Optional<JobOtome>> findById(long id) {
		return Mono.defer(() -> Mono.just(this.jobOtomeReactiveRepository.findById(id))).subscribeOn(jdbcScheduler);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hrdatabank.otome.services.JobReactiveService#findAll()
	 */
	@Cacheable
	@Override
	public Flux<JobOtome> findAll() {
		return Flux.defer(() -> Flux.fromIterable(this.jobOtomeReactiveRepository.findAll()))
				.subscribeOn(jdbcScheduler);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hrdatabank.otome.services.JobReactiveService#save(com.hrdatabank.otome.
	 * domain.JobOtome)
	 */
	@CachePut
	@Override
	public Mono<JobOtome> save(JobOtome job) {
		return Mono.fromCallable(() -> transactionTemplate.execute(status -> {
			return jobOtomeReactiveRepository.save(job);
		})).subscribeOn(jdbcScheduler);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hrdatabank.otome.services.JobReactiveService#deleteById(java.lang.Long)
	 */
	@Override
	@CacheEvict(allEntries = true)
	public Mono<Void> deleteById(Long id) {
		jobOtomeReactiveRepository.deleteById(id);
		return Mono.empty();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hrdatabank.otome.services.JobReactiveService#findAllJobDTO()
	 */
	@Override
	@Cacheable
	public Flux<JobDto> findAllJobDTO() {
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return Flux.defer(() -> Flux.fromIterable(this.jobOtomeReactiveRepository.getAllJobsByDto()))
				.subscribeOn(jdbcScheduler);

	}

}
