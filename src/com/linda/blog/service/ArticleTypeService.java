package com.linda.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linda.blog.dao.ArticleTypeDAO;
import com.linda.blog.entity.ArticleType;

@Service
public class ArticleTypeService {
   @Autowired
   private ArticleTypeDAO articleTypeDao;
   
   public List<ArticleType> getAllArticleType(){
	   return articleTypeDao.getAllArticleType();
   }
}
