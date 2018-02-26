package com.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "comment")
public class Comment {

	
	@TableGenerator(name = "comment_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1, pkColumnValue = "comment_gen")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "comment_gen")
	private int commentId;
	
	@Column(name= "comment")
	private String comment;
	
	@Column(name= "interviewer")
	private int interviewer; // FK from interviewer table
	
	@Column(name= "applicant")
	private int applicant; // FK from applicant table

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

	public int getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(int interviewer) {
		this.interviewer = interviewer;
	}

	public int getApplicant() {
		return applicant;
	}

	public void setApplicant(int applicant) {
		this.applicant = applicant;
	}
	
	
	
	
}