package com.ejb.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jpa.entities.Interviewer;

@Stateless
public class InterviewerDao extends AbstractDao<Interviewer, Integer>{
	
	@PersistenceContext
	EntityManager em;

	public InterviewerDao(){
		super(Interviewer.class);
	}
	
	@Override
	public EntityManager em() {
		return em;
	}
	
}

