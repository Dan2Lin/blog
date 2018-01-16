package com.linda.blog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.linda.blog.entity.Article;
import com.linda.blog.entity.ArticleList;
import com.linda.blog.entity.Result;
import com.linda.blog.service.ArticleService;
import com.linda.blog.utils.GenerateUniqueID;
import com.linda.blog.utils.JSONUtil;
import com.linda.blog.utils.SysConstant;

@Controller
@RequestMapping("/article")
public class ArticleController {
	@Autowired
	private ArticleService articleService;

	@RequestMapping("/getArticles")
	@ResponseBody
	public Object getArticles() throws Exception{
		Result result = null;
		Map<String,Object> data = new HashMap<String,Object>();
		try {
			List<ArticleList> articleList =  articleService.getArticles();
			data.put("articles", articleList);
			data.put("articleCount",articleList.size());
			result = new Result(SysConstant.STATE_SUCCESS,"getArticles success",data);
		} catch (Exception e) {
			result = new Result(SysConstant.STATE_FAILURE,"getArticles failure",data);
			e.printStackTrace();
		}
		return JSONUtil.toJSON(result);
	}

	@RequestMapping("/getArticleById")
	@ResponseBody
	public Object getArticleById(String aid) throws Exception {
		Result result = null;
		Map<String,Object> data = new HashMap<String,Object>();
		if(StringUtils.isNotBlank(aid)) {
			try {
				Article article = articleService.getArticleById(aid);
				if(null == article) {
					data.put("article",null);
					result = new Result(SysConstant.STATE_FAILURE,"article not exsit",data);
				}else {
					data.put("article",article);
					result = new Result(SysConstant.STATE_SUCCESS,"getArticles success",data);
				}
			} catch (Exception e) {
				data.put("article",null);
				result = new Result(SysConstant.STATE_FAILURE,"getArticles failure",data);
				e.printStackTrace();
			}
		}else {
			data.put("article", null);
			result = new Result(SysConstant.STATE_FAILURE,"articleId can't be null",data);
		}
		return JSONUtil.toJSON(result);
		
	}

	@RequestMapping("/getArticlesByType")
	@ResponseBody
	public Object getArticlesByType(String tId) throws Exception {
		Result result = null;
		Map<String,Object> data = new HashMap<String,Object>();
		try {
			 List<Article> articleList = articleService.getArticlesByType(tId);
			 data.put("Articles", articleList);
			 data.put("ArticlesCount", articleList.size());
			 result = new Result(SysConstant.STATE_SUCCESS,"getArticlesByType Success",data);
		} catch (Exception e) {
			result = new Result(SysConstant.STATE_FAILURE,"getArticlesByType failure",data);
			e.printStackTrace();
		}
		return JSONUtil.toJSON(result);
	}

	@RequestMapping("/addArticle")
	@ResponseBody
	public Object addArticle(@RequestBody Article article) throws Exception {
		Result result = null;
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("article", null);
		article.setaId(GenerateUniqueID.generateArticleId());
		try {
			articleService.addArticle(article);
			result = new Result(SysConstant.STATE_SUCCESS, "add article success", data);
		} catch (Exception e) {
			result = new Result(SysConstant.STATE_FAILURE, "add article failure", data);
			e.printStackTrace();
		}
		return JSONUtil.toJSON(result);
	}

	@RequestMapping("/deleteArticleById")
	@ResponseBody
	public Object deleteArticleById(String aid) throws Exception {	
		Result result = null;
		if(StringUtils.isNotBlank(aid)) {
			result = new Result(SysConstant.STATE_FAILURE, "article id is null", null);
		}else {
			try {
				articleService.deleteArticleById(aid);
				result = new Result(SysConstant.STATE_SUCCESS, "delete article success", null);
			}catch(Exception e) {
				result = new Result(SysConstant.STATE_FAILURE, "delete article failure", null);
				e.printStackTrace();
			}	
		}
		return JSONUtil.toJSON(result);
	}

	@RequestMapping("/updateArticle")
	@ResponseBody
	public Object updateArticle(@RequestBody Article article) throws Exception {
		Result result = null;
		if(article == null) {
			result = new Result(SysConstant.STATE_FAILURE, "article can't be null when you update the article", null);
		}else {
			try {
				articleService.updateArticle(article);
				result = new Result(SysConstant.STATE_SUCCESS, "update article success", null);
			}catch (Exception e) {
				result = new Result(SysConstant.STATE_FAILURE, "update article failure", null);
				e.printStackTrace();
				
			}
		}
		return JSONUtil.toJSON(result);	
	}
}
