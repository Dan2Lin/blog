package com.linda.blog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "articleType")
public class ArticleType {
	private String tId;
	private String typeContent;

	@Id
	@Column(name = "tId", nullable = false, length = 32, unique = true)
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@GeneratedValue(generator = "generator")
	public String getTypeId() {
		return tId;
	}

	public void setTypeId(String tId) {
		this.tId = tId;
	}

	@Column(name = "typeContent", nullable = false)
	public String getTypeContent() {
		return typeContent;
	}

	public void setTypeContent(String typeContent) {
		this.typeContent = typeContent;
	}

	public ArticleType(String tId, String typeContent) {
		super();
		this.tId = tId;
		this.typeContent = typeContent;
	}

	public ArticleType() {
		super();
	}

}
