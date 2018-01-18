package com.linda.blog.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

import com.linda.blog.entity.Article;
import com.linda.blog.entity.ArticleList;

@Repository
public class ArticleDAO {
	@Resource
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
    
	@SuppressWarnings("unchecked")
	public List<ArticleList> getArticles() throws Exception {
		String sql = "select a.title,a.publishTime,a.content,b.typeContent as articleTypeName from article a ,articletype b where a.tId = b.tId";  
		List<ArticleList> alist = (List<ArticleList>) this.getSession().createSQLQuery(sql)  
		    .addScalar("title", StandardBasicTypes.STRING)  
		    .addScalar("publishTime", StandardBasicTypes.DATE)  
		    .addScalar("content", StandardBasicTypes.STRING)  
		    .addScalar("articleTypeName", StandardBasicTypes.STRING)  
		    .setResultTransformer(Transformers.aliasToBean(ArticleList.class)).list();  
		return alist;
	}
	@SuppressWarnings("unchecked")
	public List<ArticleList> searchArticles(String param) throws Exception {
		String sql = "SELECT * FROM (select a.title,a.publishTime,a.content,b.typeContent as articleTypeName from article a ,articletype b where a.tId = b.tId) AS alldata where title like '%"+param+"%' or articleTypeName LIKE '%"+param+"%'";  
		List<ArticleList> alist = (List<ArticleList>) this.getSession().createSQLQuery(sql)  
		    .addScalar("title", StandardBasicTypes.STRING)  
		    .addScalar("publishTime", StandardBasicTypes.DATE)  
		    .addScalar("content", StandardBasicTypes.STRING)  
		    .addScalar("articleTypeName", StandardBasicTypes.STRING)  
		    .setResultTransformer(Transformers.aliasToBean(ArticleList.class)).list();  
		return alist;
	}
	
	public Article getArticleById(String aid) throws Exception {
		return (Article)this.getSession().createQuery("from Article where id = ?").setParameter(0, aid).uniqueResult();
	}
	
	public void addArticle(Article article) throws Exception {
		this.getSession().save(article);
	}
	
	public void updateArticle(Article article) throws Exception {
		this.getSession().update(article);
	}
	
	public void deleteArticleById(String aid) throws Exception {
		this.getSession().createQuery("delete Article where aId = ?").setParameter(0, aid).executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	public List<Article> getArticlesByType(String tId) throws Exception {
		return (List<Article>)this.getSession().createQuery("from Article where tid = ?").setParameter(0, tId).list();
	}
}
