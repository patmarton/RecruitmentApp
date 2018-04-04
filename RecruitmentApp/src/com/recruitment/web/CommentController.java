package com.recruitment.web;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.ejb.dao.CommentDao;
import com.ejb.services.CommentService;
import com.jpa.entities.Comment;

@Named
@RequestScoped
public class CommentController {

	@EJB
	CommentService commentService;
	
	@EJB
	CommentDao commentDao;
	
	private Comment comment = new Comment();
	
	private List<Comment> allComments;
	
	public String createComment(){
		commentService.addComment(comment);
		allComments = commentDao.findAll();
		comment = new Comment();
		return null;
	}
	

	public Comment getCommentn() {
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
