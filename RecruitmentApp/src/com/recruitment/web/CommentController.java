package com.recruitment.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.CellEditEvent;

import com.ejb.dao.CommentDao;
import com.ejb.services.CommentService;
import com.jpa.entities.Applicant;
import com.jpa.entities.Comment;
import com.jpa.entities.Interviewer;

@Named
@RequestScoped
public class CommentController {

	//@EJB
	//CommentService commentService;
	
	@EJB
	CommentDao commentDao;
	
	@PostConstruct
	public void init(){
		initComment();
		refreshAllComments();
		
	}
	
	private void initComment(){
		comment = new Comment();
		comment.setInterviewer(new Interviewer());
		comment.setApplicant(new Applicant());
		
		
	}
	
	private void refreshAllComments() {
		allComments = commentDao.findAll();
	}
	
	private Comment comment;
	
	private List<Comment> allComments;
	
	public String createComment(){
		//commentService.addComment(comment);
		//allComments = commentDao.findAll();
		commentDao.create(comment);
		refreshAllComments();
		initComment();
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
	
	public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        
        for(Comment comment : allComments){
        	commentDao.update(comment);
        }
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
	
	
}
