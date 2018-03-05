package com.ejb.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jpa.entities.Application;

@Stateless
public class ApplicationDao extends AbstractDao<Application, Integer>{
	
	@PersistenceContext
	EntityManager em;

	public ApplicationDao(){
		super(Application.class);
	}
	
	@Override
	public EntityManager em() {
		return em;
	}
	
}

