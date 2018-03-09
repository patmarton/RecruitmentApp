package com.ejb.services.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.dao.JobDao;
import com.ejb.services.JobService;
import com.jpa.entities.Job;

@Stateless
public class JobServiceImpl implements JobService {

	@EJB
	JobDao jobDao;
	
	@Override
	public void addJob(Job job) {
		jobDao.create(job);
	}
}