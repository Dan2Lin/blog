package com.linda.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linda.blog.dao.ArticleDAO;
import com.linda.blog.entity.Article;
import com.linda.blog.entity.ArticleList;
import com.linda.blog.entity.Comment;

@Service
public class ArticleService {
	@Autowired
	private ArticleDAO articleDao;

	public List<ArticleList> getArticles() throws Exception {
		return articleDao.getArticles();
	}
	public List<ArticleList> searchArticles(String searchInput) throws Exception {
		return articleDao.searchArticles(searchInput);
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
	public void addComment(Comment comment) throws Exception {
		articleDao.addComment(comment);
	}
	
	public List<Comment> getCommentList(String aid) throws Exception {
		return articleDao.getCommentList(aid);
	}
}
