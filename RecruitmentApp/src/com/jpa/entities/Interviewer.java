package com.jpa.entities;

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
@Table(name = "interviewer")
public class Interviewer {

	
	@TableGenerator(name = "interviewer_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1, pkColumnValue = "interviewer_gen")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "interviewer_gen")
	private int interviewerId;
	
	@OneToMany(mappedBy = "interviewer")
	private List<Comment> comments;
	
	@OneToMany(mappedBy = "interviewer")
	private List<Rating> ratings;
	
	@OneToMany(mappedBy = "interviewer")
	private List<Interview> interviews;
	

	@Column(name= "name")
	private String name;
	
	@Column(name= "job")
	private String job;
	
	@Column(name= "position")
	private String position;
	
	@Column(name= "doag")
	private int doag; //Security level of the employee
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	
	public String getJob(){
		return this.job;
	}
	
	public void setJob(String Job){
		this.job = Job;
	}
	
	public String getPosition(){
		return this.position;
	}
	
	public void setPosition(String position){
		this.position = position;
	}
	
	public int getDoag(){
		return this.doag;
	}
	
	public void setDoag(int doag){
		this.doag = doag;
	}

	public int getInterviewerId() {
		return interviewerId;
	}

	public void setInterviewerId(int interviewerId) {
		this.interviewerId = interviewerId;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public List<Interview> getInterviews() {
		return interviews;
	}

	public void setInterviews(List<Interview> interviews) {
		this.interviews = interviews;
	}

	
	
	
	
	
}
