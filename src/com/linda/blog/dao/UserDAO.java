package com.linda.blog.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.linda.blog.entity.User;

@Repository
public class UserDAO {
	@Resource
	private SessionFactory sessionFactory;

	@SuppressWarnings("unused")
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public User getUserById(int id) {
		return (User) this.getSession().createQuery("from User where id = ?").setParameter(0, id).uniqueResult();
	}

	public void addUser(User user) throws Exception {
		this.getSession().save(user);
	}

	public void updateUser(User user) {
		this.getSession().update(user);
	}

	public void deleteUserById(int id) {
		this.getSession().createQuery("delete User where id = ?").setParameter(0, id).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		return (List<User>) this.getSession().createCriteria(User.class).list();
	}
}