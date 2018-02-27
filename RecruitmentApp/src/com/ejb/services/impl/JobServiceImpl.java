package com.ejb.services.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.services.JobService;
import com.jpa.entities.Job;

@Stateless
public class JobServiceImpl implements JobService {

	@PersistenceContext(name = "RecruitmentApp")
	private EntityManager em;

	@Override
	public void addJob(Job job) {

		em.persist(job);

	}
}