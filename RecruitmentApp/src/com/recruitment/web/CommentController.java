package com.recruitment.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.ejb.dao.CommentDao;
import com.ejb.services.CommentService;
import com.jpa.entities.Applicant;
import com.jpa.entities.Comment;

@Named
@RequestScoped
public class CommentController {

	@EJB
	CommentService commentService;
	
	@EJB
	CommentDao commentDao;
	
	@PostConstruct
	public void init(){
		refreshAllComments();
	}
	
	private void refreshAllComments() {
		allComments = commentDao.findAll();
	}
	
	private Comment comment = new Comment();
	
	private List<Comment> allComments;
	
	public String createComment(){
		commentService.addComment(comment);
		allComments = commentDao.findAll();
		refreshAllComments();
		comment = new Comment();
		return null;
	}
	
	public String deleteComment(Comment comment){
		commentDao.delete(comment);
		refreshAllComments();
		return null;
	}
	
	

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public List<Comment> getAllComments() {
		return allComments;
	}

	public void setAllComments(List<Comment> allComments) {
		this.allComments = allComments;
	}
	
}
