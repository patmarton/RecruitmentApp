package com.ejb.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jpa.entities.Interview;

@Stateless
public class InterviewDao extends AbstractDao<Interview, Integer>{
	
	@PersistenceContext
	EntityManager em;

	public InterviewDao(){
		super(Interview.class);
	}
	
	@Override
	public EntityManager em() {
		return em;
	}
	
}

