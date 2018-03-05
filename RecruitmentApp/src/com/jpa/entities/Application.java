package com.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "Application")
public class Application {

	
	@TableGenerator(name = "application_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1, pkColumnValue = "application_gen")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "application_gen")
	private int applicationId;
	
	@ManyToOne
	@JoinColumn(name="applicantId")
	private Applicant applicant;
	
	@ManyToOne
	@JoinColumn(name="jobId")
	private Job job;
	
	@Column(name= "stage")
	private String stage;
	
	@Column(name= "reason")
	private String reason;
	
	@Column(name="others")
	private String others;

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
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