package com.linda.blog.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "article")
public class Article {
	private int aId; // articleId
	private String title;
	private int tId; // article type
	private Date publishTime;
	private String content;
	private int pageview;

	@Id
	@Column(name = "aId", nullable = false, length = 32, unique = true)
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@GeneratedValue(generator = "generator")
	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	@Column(name = "title", nullable = false)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "tId", nullable = false)
	public int getType() {
		return tId;
	}

	public void setType(int tId) {
		this.tId = tId;
	}

	@Column(name = "publishTime", nullable = false)
	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	@Column(name = "content", nullable = false)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "pageview", nullable = false)
	public int getPageview() {
		return pageview;
	}

	public void setPageview(int pageview) {
		this.pageview = pageview;
	}

	public Article(int aId, String title, int tId, Date publishTime, String content, int pageview) {
		super();
		this.aId = aId;
		this.title = title;
		this.tId = tId;
		this.publishTime = publishTime;
		this.content = content;
		this.pageview = pageview;
	}

	public Article() {
		super();
	}

}