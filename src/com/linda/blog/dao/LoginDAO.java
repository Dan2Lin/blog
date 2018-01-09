package com.linda.blog.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.linda.blog.entity.User;

@Repository
public class LoginDAO {
	
	@Resource
	private SessionFactory sessionFactory;

	@SuppressWarnings("unused")
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
    public boolean login(String name,String password) throws Exception{
    	User user = (User)this.getSession().createQuery("from User where username = ? and password = ?").setParameter(0, name).setParameter(1, password).uniqueResult();
    	if(null!=user) {
    		return true;
    	}
    	return false;
    }
}
