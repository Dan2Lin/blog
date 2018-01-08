package com.linda.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linda.blog.dao.ArticleDAO;
import com.linda.blog.entity.Article;

@Service
public class ArticleService {
	@Autowired
	private ArticleDAO articleDao;

	public List<Article> getArticles() throws Exception {
		return articleDao.getArticles();
	}

	public Article getArticleById(String aid) throws Exception {
		return articleDao.getArticleById(aid);
	}

	public List<Article> getArticlesByType(String tId) throws Exception {
		return articleDao.getArticlesByType(tId);
	}

	public void addArticle(Article article) throws Exception {
		articleDao.addArticle(article);
	}

	public void deleteArticleById(String aid) throws Exception {
		articleDao.deleteArticleById(aid);
	}

	public void updateArticle(Article article) throws Exception {
		articleDao.updateArticle(article);
	}
}
