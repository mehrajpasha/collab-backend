package com.niit.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.niit.model.Blog;


	@Repository
	public class BlogDAOImpl implements BlogDAO {
		
		@Autowired
		private SessionFactory sessionFactory;
		
		@Autowired
		private BlogDAO blogDAO;
		
		
		public BlogDAOImpl(SessionFactory sessionFactory){
			this.sessionFactory = sessionFactory;
		}
		
		@Transactional
		public boolean saveOrUpdate(Blog blog){
			try {
				sessionFactory.getCurrentSession().saveOrUpdate(blog);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		
		} 
		@Transactional
		public boolean delete(Blog blog)
		    {     
			try {
				sessionFactory.getCurrentSession().delete(blog);
				return true;
			}
			 catch (Exception e){
				e.printStackTrace();
			
			return false;
			}
		}
		
		@Transactional
		public List<Blog>getBlogs()
		{
			List<Blog>list=sessionFactory.getCurrentSession().createCriteria(Blog.class).list();
			return list;
		}
		@Transactional
		public String  getallBlogs() 
		{
			List<Blog> list=blogDAO.getBlogs();
			Gson gson=new Gson();
			String data=gson.toJson(list);
			return data;
		}

		@Transactional
		public Blog blogbyid(int id) {
			String hql="from Blog where blogid="+id;
			Query query= sessionFactory.getCurrentSession().createQuery(hql);
			Blog listblog=(Blog) query.uniqueResult();
			return listblog;
		}

		
		
		
	}