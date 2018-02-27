package com.ejb.services.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.services.RatingService;
import com.jpa.entities.Rating;

@Stateless
public class RatingServiceImpl implements RatingService {

	@PersistenceContext(name = "RecruitmentApp")
	private EntityManager em;

	@Override
	public void addRating(Rating rtg) {

		em.persist(rtg);

	}
}