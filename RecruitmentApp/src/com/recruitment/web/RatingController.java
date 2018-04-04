package com.recruitment.web;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.ejb.dao.RatingDao;
import com.ejb.services.RatingService;
import com.jpa.entities.Rating;

@Named
@RequestScoped
public class RatingController {

	@EJB
	RatingService ratingService;
	
	@EJB
	RatingDao ratingDao;
	
	private Rating rating = new Rating();
	
	private List<Rating> allRatings;
	
	public String createJob(){
		ratingService.addRating(rating);
		allRatings = ratingDao.findAll();
		rating = new Rating();
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
	
}
