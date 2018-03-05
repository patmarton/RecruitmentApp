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
@Table(name = "comment")
public class Comment {

	
	@TableGenerator(name = "comment_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1, pkColumnValue = "comment_gen")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "comment_gen")
	private int commentId;
	
	@ManyToOne
	@JoinColumn(name="interviewerId")
	private Interviewer interviewer;
	
	@ManyToOne
	@JoinColumn(name="applicantId")
	private Applicant applicant;
	
	
	@Column(name= "comment")
	private String comment;
	


	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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


	
	
	
	
}