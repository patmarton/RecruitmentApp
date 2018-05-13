package com.recruitment.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.CellEditEvent;

import com.ejb.dao.InterviewDao;
import com.ejb.services.InterviewService;
import com.jpa.entities.Applicant;
import com.jpa.entities.Interview;
import com.jpa.entities.Interviewer;
import com.jpa.entities.Job;

@Named
@RequestScoped
public class InterviewController {

//	@EJB(lookup = "java:/InterviewService")
//	InterviewService interviewService;
//	
	@EJB
	InterviewDao interviewDao;
	
	@PostConstruct
	public void init(){
		refreshAllInterviews();
		initInterview();
	}

	private void initInterview() {
		interview = new Interview();
		interview.setInterviewer(new Interviewer());
		interview.setJob(new Job());
		interview.setApplicant(new Applicant());
	}
	
	private void refreshAllInterviews() {
		allInterviews = interviewDao.findAll();
	}
	
	private Interview interview;
	
	private List<Interview> allInterviews;
	
	public String createInterview(){
		//interviewService.addInterview(interview);
		interviewDao.create(interview);
		refreshAllInterviews();
		initInterview();
		return null;
	}
	
	public String deleteInterview(Interview interview){
		interviewDao.delete(interview);
		refreshAllInterviews();
		return null;
	}
	

	public Interview getInterview() {
		return interview;
	}

	public void setInterview(Interview interview) {
		this.interview = interview;
	}

	public List<Interview> getAllInterviews() {
		return allInterviews;
	}

	public void setAllInterviews(List<Interview> allInterviews) {
		this.allInterviews = allInterviews;
	}
	
	public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        
        for(Interview in : allInterviews){
        	interviewDao.update(in);
        }
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
	
	
}
