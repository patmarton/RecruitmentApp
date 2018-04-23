package com.recruitment.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.ejb.dao.InterviewDao;
import com.ejb.services.InterviewService;
import com.jpa.entities.Applicant;
import com.jpa.entities.Interview;

@Named
@RequestScoped
public class InterviewController {

	@EJB(lookup = "java:/InterviewService")
	InterviewService interviewService;
	
	@EJB
	InterviewDao interviewDao;
	
	@PostConstruct
	public void init(){
		refreshAllInterviews();
	}
	
	private void refreshAllInterviews() {
		allInterviews = interviewDao.findAll();
	}
	
	private Interview interview = new Interview();
	
	private List<Interview> allInterviews;
	
	public String createInterview(){
		interviewService.addInterview(interview);
		allInterviews = interviewDao.findAll();
		refreshAllInterviews();
		interview = new Interview();
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
	
}
