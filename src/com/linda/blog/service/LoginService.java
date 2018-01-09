package com.linda.blog.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linda.blog.dao.LoginDAO;
import com.linda.blog.utils.MD5Util;

@Service
public class LoginService {
	@Autowired
	private LoginDAO loginDao;
	
	public boolean login(String name,String password) throws Exception {
		if(StringUtils.isNotBlank(name) && StringUtils.isNotBlank(password)) {
			password = MD5Util.getMD5String(password);
			return loginDao.login(name, password);
		}
		return false;
		
	}
}
