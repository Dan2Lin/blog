package com.linda.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linda.blog.dao.UserRoleDAO;
import com.linda.blog.entity.UserRole;

@Service
public class UserRoleService {
	@Autowired
	private UserRoleDAO userRoleDao;
	public List<UserRole> getAllUserRole(){
		return userRoleDao.getAllUserRole();
	}
}
