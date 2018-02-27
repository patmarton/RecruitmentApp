package com.ejb.services.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.services.ApplicantService;
import com.jpa.entities.Applicant;

@Stateless
public class ApplicantServiceImpl implements ApplicantService {

	@PersistenceContext(name = "RecruitmentApp")
	private EntityManager em;

	@Override
	public void addApplicant(Applicant app) {

		em.persist(app);

	}
}