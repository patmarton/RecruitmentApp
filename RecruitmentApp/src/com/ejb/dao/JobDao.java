package com.ejb.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jpa.entities.Job;

@Stateless
public class JobDao extends AbstractDao<Job, Integer>{
	
	@PersistenceContext
	EntityManager em;

	public JobDao(){
		super(Job.class);
	}
	
	@Override
	public EntityManager em() {
		return em;
	}
	
}

