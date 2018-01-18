package com.linda.blog.entity;

public class UserList {
	private String uid;
	private String username;
	private int role; // 1: super admin 2:amdin 3:common user
	private String password;
	private int rId;
	private String rType;
	private String rName;

	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public String getrType() {
		return rType;
	}
	public void setrType(String rType) {
		this.rType = rType;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public UserList(String uid, String username, int role, String password, int rId, String rType, String rName) {
		super();
		this.uid = uid;
		this.username = username;
		this.role = role;
		this.password = password;
		this.rId = rId;
		this.rType = rType;
		this.rName = rName;
	}
	public UserList() {
		super();
	}
	
}
