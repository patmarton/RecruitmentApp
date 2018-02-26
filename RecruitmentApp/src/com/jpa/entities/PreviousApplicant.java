package com.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "previousapplicant")
public class PreviousApplicant {

	
	@TableGenerator(name = "previousapplicant_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1, pkColumnValue = "previousapplicant_gen")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "previousapplicant_gen")
	private int previousApplicantId;
	
	@Column(name= "name")
	private String name;
	
	@Column(name= "job")
	private String job; // Job they applied for in the past
	
	@Column(name= "graduation_year")
	private int year;
	
	@Column(name= "university")
	private String university;
	
	@Column(name= "birth_year")
	private int birth_year; 
	
	@Column(name= "stage")
	private String stage; //Stage of previous application (e.g. Not hired, Rejected)
	
	@Column(name= "reason")
	private String reason; //Reason of the stage (e.g. Low score on test)

	public int getPreviousApplicantId() {
		return previousApplicantId;
	}

	public void setPreviousApplicantId(int previousApplicantId) {
		this.previousApplicantId = previousApplicantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public int getBirth_year() {
		return birth_year;
	}

	public void setBirth_year(int birth_year) {
		this.birth_year = birth_year;
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
	
	
	
	
}