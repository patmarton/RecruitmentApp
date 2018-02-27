package com.ejb.services.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.services.PreviousApplicantService;
import com.jpa.entities.PreviousApplicant;

@Stateless
public class PreviousApplicantServiceImpl implements PreviousApplicantService {

	@PersistenceContext(name = "RecruitmentApp")
	private EntityManager em;

	@Override
	public void addPreviousApplicant(PreviousApplicant app) {

		em.persist(app);

	}
}