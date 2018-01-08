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
	public List<ArticleType> getAllArticleType() throws Exception {
		return (List<ArticleType>)this.getSession().createCriteria(ArticleType.class).list();
	}
	
	public ArticleType getArticleTypeById(String id) throws Exception {
		return (ArticleType) this.getSession().createQuery("from ArticleType where id = ?").setParameter(0, id).uniqueResult();
	}

	public void addArticleType(ArticleType articleType) throws Exception {
		this.getSession().save(articleType);
	}

	public void updateArticleType(ArticleType articleType)throws Exception {
		this.getSession().update(articleType);
	}

	public void deleteArticleTypeById(String id) throws Exception {
		this.getSession().createQuery("delete ArticleType where id = ?").setParameter(0, id).executeUpdate();
	}
}
