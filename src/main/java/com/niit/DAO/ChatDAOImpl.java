/*package com.niit.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.niit.model.chat;


	@Repository
	public class chatDAOImpl implements chatDAO {
		
		@Autowired
		private SessionFactory sessionFactory;
		
		@Autowired
		private chatDAO chatDAO;
		
		
		public chatDAOImpl(SessionFactory sessionFactory){
			this.sessionFactory = sessionFactory;
		}
		
		@Transactional
		public boolean saveOrUpdate(chat chat){
			try {
				sessionFactory.getCurrentSession().saveOrUpdate(chat);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		
		} 
		@Transactional
		public boolean delete(chat chat)
		    {     
			try {
				sessionFactory.getCurrentSession().delete(chat);
				return true;
			}
			 catch (Exception e){
				e.printStackTrace();
			
			return false;
			}
		}
		
		@Transactional
		public List<chat>getchats()
		{
			List<chat>list=sessionFactory.getCurrentSession().createCriteria(chat.class).list();
			return list;
		}
		@Transactional
		public String  getallchats() 
		{
			List<chat> list=chatDAO.getchats();
			Gson gson=new Gson();
			String data=gson.toJson(list);
			return data;
		}

		@Transactional
		public Chat chatbyid(int id) {
			String hql="from chat where chatid="+id;
			Query query= sessionFactory.getCurrentSession().createQuery(hql);
			chat listchat=(chat) query.uniqueResult();
			return listchat;
		}

		
		
		
	}*/