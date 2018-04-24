package com.recruitment.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.CellEditEvent;

import com.ejb.dao.ApplicationDao;
import com.ejb.services.ApplicationService;
import com.jpa.entities.Applicant;
import com.jpa.entities.Application;
import com.jpa.entities.Interviewer;

@Named
@RequestScoped
public class ApplicationController {

	@EJB(lookup = "java:/ApplicationService")
	ApplicationService applicationService;
	
	@EJB
	ApplicationDao applicationDao;
	
	private Application application = new Application();
	
	private List<Application> allApplications;
	
	@PostConstruct
	public void init(){
		refreshAllApplications();
	}
	
	private void refreshAllApplications() {
		allApplications = applicationDao.findAll();
	}
	
	public String createApplication(){
		applicationService.addApplication(application);
		allApplications = applicationDao.findAll();
		refreshAllApplications();
		application = new Application();
		return null;
	}
	
	public String deleteApplication(Application app){
		applicationDao.delete(app);
		refreshAllApplications();
		return null;
	}
	

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public List<Application> getAllApplications() {
		return allApplications;
	}

	public void setAllApplications(List<Application> allApplications) {
		this.allApplications = allApplications;
	}
	
	public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        
        for(Application app : allApplications){
        	applicationDao.update(app);
        }
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
	
	
	
}
