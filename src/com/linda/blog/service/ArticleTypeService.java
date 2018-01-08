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
    
   public List<ArticleType> getAllArticleType() throws Exception{
	   return articleTypeDao.getAllArticleType();
   }
   
   public ArticleType getArticleTypeById(String id) throws Exception {
		return articleTypeDao.getArticleTypeById(id);
	}

	public void addArticleType(ArticleType articleType) throws Exception {
		articleTypeDao.addArticleType(articleType);
	}

	public void updateArticleType(ArticleType articleType)throws Exception {
		articleTypeDao.updateArticleType(articleType);
	}

	public void deleteArticleTypeById(String id) throws Exception {
		articleTypeDao.deleteArticleTypeById(id);
	}
}
