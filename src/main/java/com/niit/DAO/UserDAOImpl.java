package com.niit.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.niit.model.User;


	@Repository
	public class UserDAOImpl implements UserDAO {
		
		@Autowired
		private SessionFactory sessionFactory;
		
	   @Autowired
	   UserDAO userDAO;
		
		@Autowired
		public UserDAOImpl(SessionFactory sessionFactory){
			this.sessionFactory = sessionFactory;
		}
		
		@Transactional
		public boolean saveOrUpdate(User user){
			try {
				sessionFactory.getCurrentSession().saveOrUpdate(user);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		
		} 
		@Transactional
		public boolean delete(User user)
		    {     
			try {
				sessionFactory.getCurrentSession().delete(user);
				return true;
			}
			 catch (Exception e){
				e.printStackTrace();
			
			return false;
			}
		}
		
		@Transactional
		public List<User>getUsers()
		{
			List<User>list=sessionFactory.getCurrentSession().createCriteria(User.class).list();
			return list;
		}
		@Transactional
		public String  getallUsers() 
		{
			List<User> list=userDAO.getUsers();
			Gson gson=new Gson();
			String data=gson.toJson(list);
			return data;
		}

		@Transactional
		public User userbyid(int id) {
			String hql="from User where userid="+id;
			Query query= sessionFactory.getCurrentSession().createQuery(hql);
			List<User>list= query.list();
			
			if(list==null)
			{
				return null;
			}
			else
			{
				return list.get(0);
			}
		}

		@SuppressWarnings({ "rawtypes", "deprecation", "unchecked" })
		@Transactional
		public User authuser(String username, String password) {
			String hql="from User where username= "+"'"+username+"'"+"and password= "+"'"+password+"'";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			List<User>list=query.list();
			if(list==null)
			{
				return null;
			}
			else
			{
				return list.get(0);
			}
		}
		
		@Transactional
		public User profileof(String username) {
			String hql="from User where username='"+username+"'";
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			List<User>list= query.list();
			
			if(list==null)
			{
				return null;
			}
			else
			{
				return list.get(0);
			}
		
		
		}
	}
