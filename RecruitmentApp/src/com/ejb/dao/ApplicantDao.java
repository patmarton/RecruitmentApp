package com.ejb.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jpa.entities.Applicant;

@Stateless
public class ApplicantDao extends AbstractDao<Applicant, Integer>{
	
	@PersistenceContext
	EntityManager em;

	public ApplicantDao(){
		super(Applicant.class);
	}
	
	@Override
	public EntityManager em() {
		return em;
	}
	
}

