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
	private String aId; // articleId
	private String title;
	private String tId; // article type
	private Date publishTime;
	private String content;
	private int pageview;

	@Id
	@Column(name = "aId", nullable = false, length = 32, unique = true)
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@GeneratedValue(generator = "generator")
	public String getaId() {
		return aId;
	}

	public void setaId(String aId) {
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
	public String gettId() {
		return tId;
	}

	public void settId(String tId) {
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

	public Article(String aId, String title, String tId, Date publishTime, String content, int pageview) {
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