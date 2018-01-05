package com.linda.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.linda.blog.entity.Article;
import com.linda.blog.service.ArticleService;

@Controller
@RequestMapping("/article")
public class ArticleController {
	@Autowired
	private ArticleService articleService;

	@RequestMapping("/getArticles")
	@ResponseBody
	public List<Article> getArticles() {
		return articleService.getArticles();
	}

	@RequestMapping("/getArticleById")
	@ResponseBody
	public Article getArticleById(int aid) {
		return articleService.getArticleById(aid);
	}

	@RequestMapping("/getArticlesByType")
	@ResponseBody
	public List<Article> getArticlesByType(int tId) {
		return articleService.getArticlesByType(tId);
	}

	@RequestMapping("/addArticle")
	@ResponseBody
	public void addArticle(Article article) {
		articleService.addArticle(article);
	}

	@RequestMapping("/deleteArticleById")
	@ResponseBody
	public void deleteArticleById(int aid) {
		articleService.deleteArticleById(aid);
	}

	@RequestMapping("/updateArticle")
	@ResponseBody
	public void updateArticle(Article article) {
		articleService.updateArticle(article);
	}
}
