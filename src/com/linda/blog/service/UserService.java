package com.linda.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linda.blog.dao.UserDAO;
import com.linda.blog.entity.User;

@Service
public class UserService {
	@Autowired
	private UserDAO userDao;

	public void addUser(User user) throws Exception{
		userDao.addUser(user);
	}

	public void deleteUserById(int id) {
		userDao.deleteUserById(id);
	}

	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	public User getUserById(int id) {
		return userDao.getUserById(id);

	}

	public List<User> getAllUsers() {
		return userDao.getUsers();

	}

}
