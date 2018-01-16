package com.linda.blog.entity;

//import java.sql.Date;

import java.util.Date;
public class ArticleList {
	private String aId; // articleId
	private String title;
	private String tId; // article type
	private Date publishTime;
	private String content;
	private int pageview;
	private String articleTypeName;
	
	public String getaId() {
		return aId;
	}
	public void setaId(String aId) {
		this.aId = aId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String gettId() {
		return tId;
	}
	public void settId(String tId) {
		this.tId = tId;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPageview() {
		return pageview;
	}
	public void setPageview(int pageview) {
		this.pageview = pageview;
	}
	public String getArticleTypeName() {
		return articleTypeName;
	}
	public void setArticleTypeName(String articleTypeName) {
		this.articleTypeName = articleTypeName;
	}
	public ArticleList(String aId, String title, String tId, Date publishTime, String content, int pageview,
			String articleTypeName) {
		super();
		this.aId = aId;
		this.title = title;
		this.tId = tId;
		this.publishTime = publishTime;
		this.content = content;
		this.pageview = pageview;
		this.articleTypeName = articleTypeName;
	}
	public ArticleList() {
		super();
	}
	
}
