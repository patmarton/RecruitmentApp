package com.ejb.services.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ejb.services.CommentService;
import com.jpa.entities.Comment;

@Stateless
public class CommentServiceImpl implements CommentService {

	@PersistenceContext(name = "RecruitmentApp")
	private EntityManager em;

	@Override
	public void addComment(Comment com) {

		em.persist(com);

	}
}