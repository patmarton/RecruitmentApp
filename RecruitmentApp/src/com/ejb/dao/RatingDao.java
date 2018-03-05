package com.ejb.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jpa.entities.Rating;

@Stateless
public class RatingDao extends AbstractDao<Rating, Integer>{
	
	@PersistenceContext
	EntityManager em;

	public RatingDao(){
		super(Rating.class);
	}
	
	@Override
	public EntityManager em() {
		return em;
	}
	
}

