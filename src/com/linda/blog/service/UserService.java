package com.linda.blog.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linda.blog.dao.UserDAO;
import com.linda.blog.entity.User;
import com.linda.blog.entity.UserList;
import com.linda.blog.entity.UserRole;
import com.linda.blog.utils.MD5Util;

@Service
public class UserService {
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private UserRoleService userRoleService;

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
    
	public List<UserList> searchUserByParam(String param) throws Exception {
		return userDao.searchUserByParam(param);
	}
	public List<UserList> getAllUsers() throws Exception {
		return userDao.getUsers();
	}
	public Map<String,List<UserList>> formatUserList(List<UserList> userList) throws Exception {
		List<UserRole> uroleList = userRoleService.getAllUserRole();
		Map<String,List<UserList>> usersMap = new HashMap<String,List<UserList>>();
		for(UserRole urole: uroleList) {
			List<UserList> tempUserList = new ArrayList<UserList>();
			for(UserList ulist : userList) {
				if(ulist.getRole()==urole.getrId()) {
					tempUserList.add(ulist);
				}
			}
			usersMap.put(urole.getrType(), tempUserList);
		}
		return usersMap;
	}

}
