package com.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "applicant")
public class Applicant {

	
	@TableGenerator(name = "applicant_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1, pkColumnValue = "applicant_gen")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "applicant_gen")
	private int applicantId;
	
	@Column(name= "name")
	private String name;
	
	@Column(name= "job")
	private String job; 
	
	@Column(name= "graduation_year")
	private int year;
	
	@Column(name= "university")
	private String university;
	
	@Column(name= "birth_year")
	private int birth_year;

	public int getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
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
	
	
	
	
	
}