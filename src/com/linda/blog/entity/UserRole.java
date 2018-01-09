package com.linda.blog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
public class UserRole {
	private int rId;
	private String rType;
	private String rName;

	@Id
	@Column(name = "rId", nullable = false, unique = true)
	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	@Column(name = "rType", nullable = false)
	public String getrType() {
		return rType;
	}

	public void setrType(String rType) {
		this.rType = rType;
	}

	@Column(name = "rName", nullable = false)
	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

	public UserRole(int rId, String rType, String rName) {
		super();
		this.rId = rId;
		this.rType = rType;
		this.rName = rName;
	}

	public UserRole() {
		super();
	}

}
