package com.linda.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.linda.blog.entity.ArticleType;
import com.linda.blog.service.ArticleTypeService;

@Controller
@RequestMapping("/articleType")
public class ArticleTypeController {
	@Autowired
	private ArticleTypeService articleTypeService;

	@RequestMapping("/getAllArticleType")
	@ResponseBody
	public List<ArticleType> getAllArticleType() {
		return articleTypeService.getAllArticleType();
	}
}
