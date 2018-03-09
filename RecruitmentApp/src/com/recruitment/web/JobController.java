package com.recruitment.web;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.ejb.dao.JobDao;
import com.ejb.services.JobService;
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
	
	public String createJob(){
		jobService.addJob(job);
		alljobs = jobDao.findAll();
		job = new Job();
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
	
}
