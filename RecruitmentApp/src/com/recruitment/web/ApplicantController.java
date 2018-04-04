package com.recruitment.web;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.ejb.dao.ApplicantDao;
import com.ejb.services.ApplicantService;
import com.jpa.entities.Applicant;

@Named
@RequestScoped
public class ApplicantController {

	@EJB
	ApplicantService applicantService;
	
	@EJB
	ApplicantDao applicantDao;
	
	private Applicant app = new Applicant();
	
	private List<Applicant> allApplicants;
	
	public String createApplicant(){
		applicantService.addApplicant(app);
		allApplicants = applicantDao.findAll();
		app = new Applicant();
		return null;
	}
	

	public Applicant getApplicant() {
		return app;
	}

	public void setApplicant(Applicant app) {
		this.app = app;
	}

	public List<Applicant> getAllApplicants() {
		return allApplicants;
	}

	public void setAllApplicants(List<Applicant> allApplicants) {
		this.allApplicants = allApplicants;
	}
	
}
