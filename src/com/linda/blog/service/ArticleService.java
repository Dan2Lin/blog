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

	public List<Article> getArticles() {
		return articleDao.getArticles();
	}

	public Article getArticleById(int aid) {
		return articleDao.getArticleById(aid);
	}

	public List<Article> getArticlesByType(int tId) {
		return articleDao.getArticlesByType(tId);
	}

	public void addArticle(Article article) {
		articleDao.addArticle(article);
	}

	public void deleteArticleById(int aid) {
		articleDao.deleteArticleById(aid);
	}

	public void updateArticle(Article article) {
		articleDao.updateArticle(article);
	}
}
