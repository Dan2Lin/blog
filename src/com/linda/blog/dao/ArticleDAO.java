package com.linda.blog.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.linda.blog.entity.Article;

@Repository
public class ArticleDAO {
	@Resource
	private SessionFactory sessionFactory;

	@SuppressWarnings("unused")
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
    
	@SuppressWarnings("unchecked")
	public List<Article> getArticles(){
		return (List<Article>)this.getSession().createCriteria(Article.class).list();
	}
	
	public Article getArticleById(int aid) {
		return (Article)this.getSession().createQuery("from Article where id = ?").setParameter(0, aid).uniqueResult();
	}
	
	public void addArticle(Article article) {
		this.getSession().save(article);
	}
	
	public void updateArticle(Article article) {
		this.getSession().update(article);
	}
	
	public void deleteArticleById(int aid) {
		this.getSession().createQuery("delete Article where aId = ?").setParameter(0, aid).executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	public List<Article> getArticlesByType(int tId){
		return (List<Article>)this.getSession().createQuery("from Article where tid = ?").setParameter(0, tId).list();
	}
}
