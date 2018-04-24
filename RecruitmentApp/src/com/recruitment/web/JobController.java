package com.recruitment.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.CellEditEvent;

import com.ejb.dao.JobDao;
import com.ejb.services.JobService;
import com.jpa.entities.Applicant;
import com.jpa.entities.Interviewer;
import com.jpa.entities.Job;

@Named
@RequestScoped
public class JobController {

	@EJB
	JobService jobService;
	
	@EJB
	JobDao jobDao;
	
	private Job job = new Job();
	
	private List<Job> alljobs;
	
	@PostConstruct
	public void init(){
		refreshAllJobs();
	}
	
	private void refreshAllJobs() {
		alljobs = jobDao.findAll();
	}
	
	
	
	public String createJob(){
		jobService.addJob(job);
		alljobs = jobDao.findAll();
		refreshAllJobs();
		job = new Job();
		return null;
	}
	
	public String deleteJob(Job job){
		jobDao.delete(job);
		refreshAllJobs();
		return null;
	}
	
	

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public List<Job> getAlljobs() {
		return alljobs;
	}

	public void setAlljobs(List<Job> alljobs) {
		this.alljobs = alljobs;
	}
	
	public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        
        for(Job job : alljobs){
        	jobDao.update(job);
        }
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
	
	
	
}
