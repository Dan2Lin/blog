package com.linda.blog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="comments")
public class Comment {
	private String cid;
	private String aid;
	private String name;
	private String content;
	private String parent_id;
	
	@Id
	@Column(name = "cid", nullable = false, length = 32, unique = true)
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@GeneratedValue(generator = "generator")
	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}
	@Column(name = "aid", nullable = false)
	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}
	@Column(name = "username", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "content", nullable = false)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	@Column(name = "parent_id", nullable = true)
	public String getParent_id() {
		return parent_id;
	}

	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}

	public Comment(String cid, String aid, String name, String content, String parent_id) {
		super();
		this.cid = cid;
		this.aid = aid;
		this.name = name;
		this.content = content;
		this.parent_id = parent_id;
	}

	public Comment() {
		super();
	}

}
