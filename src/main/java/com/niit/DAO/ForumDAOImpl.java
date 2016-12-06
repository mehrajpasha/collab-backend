package com.niit.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.niit.model.Forum;


	@Repository
	public class ForumDAOImpl implements ForumDAO {
		
		@Autowired
		private SessionFactory sessionFactory;
		
		@Autowired
		private ForumDAO forumDAO;
		
		
		public ForumDAOImpl(SessionFactory sessionFactory){
			this.sessionFactory = sessionFactory;
		}
		
		@Transactional
		public boolean saveOrUpdate(Forum Forum){
			try {
				sessionFactory.getCurrentSession().saveOrUpdate(Forum);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		
		} 
		@Transactional
		public boolean delete(Forum Forum)
		    {     
			try {
				sessionFactory.getCurrentSession().delete(Forum);
				return true;
			}
			 catch (Exception e){
				e.printStackTrace();
			
			return false;
			}
		}
		
		@Transactional
		public List<Forum>getForum()
		{
			List<Forum>list=sessionFactory.getCurrentSession().createCriteria(Forum.class).list();
			return list;
		}
		@Transactional
		public String  getallForum() 
		{
			List<Forum> list=forumDAO.getForum();
			Gson gson=new Gson();
			String data=gson.toJson(list);
			return data;
		}

		@Transactional
		public Forum forumbyid(int id) {
			String hql="from Forum where forumid="+id;
			Query query= sessionFactory.getCurrentSession().createQuery(hql);
			Forum listForum=(Forum) query.uniqueResult();
			return listForum;
		}

		
		
		
	}