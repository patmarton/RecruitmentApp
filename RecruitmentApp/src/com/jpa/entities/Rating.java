package com.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "rating")
public class Rating {

	
	@TableGenerator(name = "rating_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1, pkColumnValue = "rating_gen")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "rating_gen")
	private int ratingId;
	
	@Column(name= "interviewer")
	private int interviewerId;
	
	@Column(name= "applicant")
	private int applicantId;
	
	//Scores 1-10 or boolean
	
	@Column(name= "communication")
	private int communication;
	
	@Column(name= "skills")
	private int skills;
	
	@Column(name= "test")
	private int test; //score of the test
	
	@Column(name= "recommended")
	private boolean recommended;
	
	@Column(name= "potential")
	private int potential;
	
	
	
	
	public int getRatingId() {
		return ratingId;
	}

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}

	public int getInterviewerId() {
		return interviewerId;
	}

	public void setInterviewerId(int interviewerId) {
		this.interviewerId = interviewerId;
	}

	public int getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}

	public int getCommunication() {
		return communication;
	}

	public void setCommunication(int communication) {
		this.communication = communication;
	}

	public int getSkills() {
		return skills;
	}

	public void setSkills(int skills) {
		this.skills = skills;
	}

	public int getTest() {
		return test;
	}

	public void setTest(int test) {
		this.test = test;
	}

	public boolean isRecommended() {
		return recommended;
	}

	public void setRecommended(boolean recommended) {
		this.recommended = recommended;
	}

	public int getPotential() {
		return potential;
	}

	public void setPotential(int potential) {
		this.potential = potential;
	}


	
}