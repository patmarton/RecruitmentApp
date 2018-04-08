package com.recruitment.web;

import java.util.List;

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
	
	public String createInterviewer(){
		interviewerService.addInterviewer(interviewer);
		allInterviewers = interviewerDao.findAll();
		interviewer = new Interviewer();
		return null;
	}
	

	public Interviewer getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(Interviewer interviewer) {
		this.interviewer = interviewer;
	}

	public List<Interviewer> getAllInterviewers() {
		return allInterviewers;
	}

	public void setAllInterviewers(List<Interviewer> allInterviewers) {
		this.allInterviewers = allInterviewers;
	}
	
}
