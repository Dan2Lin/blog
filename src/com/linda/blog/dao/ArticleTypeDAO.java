package com.linda.blog.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.linda.blog.entity.ArticleType;

@Repository
public class ArticleTypeDAO {
	@Resource
	private SessionFactory sessionFactory;

	@SuppressWarnings("unused")
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	@SuppressWarnings("unchecked")
	public List<ArticleType> getAllArticleType(){
		return (List<ArticleType>)this.sessionFactory.getCurrentSession().createCriteria(ArticleType.class).list();
	}
}
