package com.linda.blog.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linda.blog.dao.UserDAO;
import com.linda.blog.entity.User;
import com.linda.blog.utils.MD5Util;

@Service
public class UserService {
	@Autowired
	private UserDAO userDao;

	public void addUser(User user) throws Exception {
		userDao.addUser(user);
	}

	public void deleteUserById(String id) throws Exception {
		userDao.deleteUserById(id);
	}

	public void updateUser(User user) throws Exception {
		User originUser = userDao.getUserById(user.getUid());
		String username = user.getUsername();
		String password = user.getPassword();
		int role = user.getRole();	
		
		if(StringUtils.isNotBlank(username)) {
			originUser.setUsername(username);
		}
		
		if(StringUtils.isNotBlank(password)) {
			originUser.setPassword(MD5Util.getMD5String(password));
		}

		if(role != 0) {
			originUser.setRole(role);
		}
		
		userDao.updateUser(originUser);
	}

	public User getUserById(String id) throws Exception {
		return userDao.getUserById(id);
	}

	public List<User> getAllUsers() throws Exception {
		return userDao.getUsers();
	}

}
