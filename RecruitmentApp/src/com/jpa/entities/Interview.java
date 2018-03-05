package com.jpa.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "interview")
public class Interview {

	
	@TableGenerator(name = "interview_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1, pkColumnValue = "interview_gen")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "interview_gen")
	private int interviewId;
	
	@ManyToOne
	@JoinColumn(name="interviewerId")
	private Interviewer interviewer;
	
	@ManyToOne
	@JoinColumn(name="applicantId")
	private Applicant applicant;
	
	@ManyToOne
	@JoinColumn(name="jobId")
	private Job job;
	
	@Column(name= "date")
	private Date date;
	
	@Column(name= "description")
	private String description;

	public int getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(int interviewId) {
		this.interviewId = interviewId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Interviewer getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(Interviewer interviewer) {
		this.interviewer = interviewer;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
	
	
	
	
	
	
	
}
