package com.recruitment.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.CellEditEvent;

import com.ejb.dao.RatingDao;
import com.ejb.services.RatingService;
import com.jpa.entities.Applicant;
import com.jpa.entities.Interviewer;
import com.jpa.entities.Rating;

@Named
@RequestScoped
public class RatingController {

	//@EJB
	//RatingService ratingService;
	
	@EJB
	RatingDao ratingDao;
	
	@PostConstruct
	public void init(){
		refreshAllRatings();
		initRating();
	}
	
	private void initRating(){
		rating = new Rating();
		rating.setApplicant(new Applicant());
		rating.setinterviewer(new Interviewer());
	}
	
	private void refreshAllRatings() {
		allRatings = ratingDao.findAll();
	}
	
	
	private Rating rating;
	
	private List<Rating> allRatings;
	
	public String createRating(){
		//ratingService.addRating(rating);
		//allRatings = ratingDao.findAll();
		ratingDao.create(rating);
		refreshAllRatings();
		initRating();
		return null;
	}
	
	public String deleteRating(Rating rating){
		ratingDao.delete(rating);
		refreshAllRatings();
		return null;
	}
	

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public List<Rating> getAllRatings() {
		return allRatings;
	}

	public void setAllRatings(List<Rating> allRatings) {
		this.allRatings = allRatings;
	}
	
	public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        
        for(Rating rating : allRatings){
        	ratingDao.update(rating);
        }
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
	
	
	
}
