package com.recruitment.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.CellEditEvent;

import com.ejb.dao.ApplicantDao;
import com.ejb.services.ApplicantService;
import com.jpa.entities.Applicant;
import com.jpa.entities.Interviewer;

@Named
@RequestScoped
public class ApplicantController {

	@EJB
	ApplicantService applicantService;
	
	@EJB
	ApplicantDao applicantDao;
	
	@PostConstruct
	public void init(){
		refreshAllApplicants();
	}
	
	private Applicant app = new Applicant();
	
	private List<Applicant> allApplicants;
	
	public String createApplicant(){
		applicantService.addApplicant(app);
		allApplicants = applicantDao.findAll();
		refreshAllApplicants();
		app = new Applicant();
		return null;
	}
	
	public String deleteApplicant(Applicant app){
		applicantDao.delete(app);
		refreshAllApplicants();
		return null;
	}
	
	private void refreshAllApplicants() {
		allApplicants = applicantDao.findAll();
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
	
	
	public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        
        for(Applicant app : allApplicants){
        	applicantDao.update(app);
        }
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
	
	
}
