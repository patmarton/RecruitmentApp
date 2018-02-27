package com.ejb.services.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.services.InterviewerService;
import com.jpa.entities.Interviewer;

@Stateless
public class InterviewerServiceImpl implements InterviewerService {

	@PersistenceContext(name = "RecruitmentApp")
	private EntityManager em;

	@Override
	public void addInterviewer(Interviewer in) {

		em.persist(in);

	}
}