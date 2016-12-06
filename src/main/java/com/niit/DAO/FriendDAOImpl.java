package com.niit.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Friend;
import com.niit.model.User;

public class FriendDAOImpl implements FriendDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private FriendDAO friendDAO;
	
	
	public FriendDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public boolean saveOrUpdate(Friend friend){
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(friend);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	
	} 
	@Transactional
	public boolean delete(Friend friend)
	    {     
		try {
			sessionFactory.getCurrentSession().delete(friend);
			return true;
		}
		 catch (Exception e){
			e.printStackTrace();
		
		return false;
		}
	}
	
	@Transactional
	public List<User> getmynonfriends(){
		
		String hql="from User where status='N'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<User>list=query.list();
		if(list==null)
		{
			return null;
		}
		else
		{
			return  list;
		}
	}

	@Transactional
	public Friend acceptrequest(String uid,String fid) {
	String hql="from Friend where userid='"+uid+"' and friendid='"+fid+"'";
	Query query  =sessionFactory.getCurrentSession().createQuery(hql);
	List<Friend> list=query.list();
	if(list==null)
	{
		return null;
	}
	else
	{
		return  list.get(0);
	}
	}

	@Transactional
	public List<Friend> getmyfriends(String uid) {
		String hql="from Friend where userid="+uid;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Friend> list=query.list();
		return list;
	}

	@Transactional
	public List<Friend> acceptedfriends(String uid) {
		String hql="from Friend where userid='"+uid+"' and status='a'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Friend> list=query.list();
		return list;
	}

}