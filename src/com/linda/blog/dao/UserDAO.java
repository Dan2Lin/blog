package com.linda.blog.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

import com.linda.blog.entity.ArticleList;
import com.linda.blog.entity.User;
import com.linda.blog.entity.UserList;

@Repository
public class UserDAO {
	@Resource
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public User getUserById(String id) {
		return (User) this.getSession().createQuery("from User where id = ?").setParameter(0, id).uniqueResult();
	}

	public void addUser(User user) throws Exception {
		this.getSession().save(user);
	}

	public void updateUser(User user)throws Exception {
		this.getSession().update(user);
	}
    @SuppressWarnings("unchecked")
	public List<UserList> searchUserByParam(String param) throws Exception {
    	String sql = "SELECT * FROM (select a.uid,a.username,a.password,a.role,b.rId,b.rType,b.rName from users a ,user_role b where a.role = b.rId) AS alldata where username like '%"+param+"%' or rName LIKE '%"+param+"%'";  
		List<UserList> ulist = (List<UserList>) this.getSession().createSQLQuery(sql)  
			.addScalar("uid", StandardBasicTypes.STRING)  
		    .addScalar("username", StandardBasicTypes.STRING)  
		    .addScalar("password", StandardBasicTypes.STRING)  
		    .addScalar("role", StandardBasicTypes.INTEGER)  
		    .addScalar("rId", StandardBasicTypes.INTEGER)  
		    .addScalar("rType", StandardBasicTypes.STRING)  
		    .addScalar("rName", StandardBasicTypes.STRING)
		    .setResultTransformer(Transformers.aliasToBean(UserList.class)).list();  
		return ulist;
    }
	public void deleteUserById(String id) throws Exception {
		this.getSession().createQuery("delete User where id = ?").setParameter(0, id).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<UserList> getUsers() throws Exception {
		/*return (List<User>) this.getSession().createCriteria(User.class).list();*/
		String sql = "select * from users a,user_role b where a.role = b.rId";
		return this.getSession().createSQLQuery(sql)
				.addScalar("uid", StandardBasicTypes.STRING)  
			    .addScalar("username", StandardBasicTypes.STRING)  
			    .addScalar("password", StandardBasicTypes.STRING)  
			    .addScalar("role", StandardBasicTypes.INTEGER)  
			    .addScalar("rId", StandardBasicTypes.INTEGER)  
			    .addScalar("rType", StandardBasicTypes.STRING)  
			    .addScalar("rName", StandardBasicTypes.STRING)
			    .setResultTransformer(Transformers.aliasToBean(UserList.class)).list(); 
	}
}
