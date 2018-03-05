package com.ejb.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jpa.entities.Comment;

@Stateless
public class CommentDao extends AbstractDao<Comment, Integer>{
	
	@PersistenceContext
	EntityManager em;

	public CommentDao(){
		super(Comment.class);
	}
	
	@Override
	public EntityManager em() {
		return em;
	}
	
}

