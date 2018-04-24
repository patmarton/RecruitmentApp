package com.recruitment.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.ejb.dao.InterviewerDao;
import com.ejb.services.InterviewerService;
import com.jpa.entities.Interviewer;

@Named
@RequestScoped
public class InterviewerController {

	@EJB
	InterviewerService interviewerService;
	
	@EJB
	InterviewerDao interviewerDao;
	
	private Interviewer interviewer = new Interviewer();
	
	private List<Interviewer> allInterviewers;
	private List<Interviewer> filteredInterviewers;
	
	public List<Interviewer> getFilteredInterviewers() {
		return filteredInterviewers;
	}

	public void setFilteredInterviewers(List<Interviewer> filteredInterviewers) {
		this.filteredInterviewers = filteredInterviewers;
	}

	@PostConstruct
	public void init(){
		refreshAllInterviewers();
	}
	
	public String createInterviewer(){
		interviewerService.addInterviewer(interviewer);
		refreshAllInterviewers();
		interviewer = new Interviewer();
		return null;
	}
	
	public String deleteInterviewer(Interviewer in){
		interviewerService.deleteInterviewer(in);
		interviewerDao.delete(in);
		refreshAllInterviewers();
		return null;
	}


	private void refreshAllInterviewers() {
		allInterviewers = interviewerDao.findAll();
	}
	

	public Interviewer getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(Interviewer interviewer) {
		this.interviewer = interviewer;
	}

	public List<Interviewer> getallInterviewers() {
		return allInterviewers;
	}

	public void setallInterviewers(List<Interviewer> allInterviewers) {
		this.allInterviewers = allInterviewers;
	}
	
}
