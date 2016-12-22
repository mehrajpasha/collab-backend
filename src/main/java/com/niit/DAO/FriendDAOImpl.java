package com.niit.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Forumcomment;
import com.niit.model.Friend;
import com.niit.model.User;

public class FriendDAOImpl implements FriendDAO {
	
	private static final Object NotLoggedin = null;

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private FriendDAO friendDAO;
	
	@Autowired
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
		
		Criteria c=sessionFactory.getCurrentSession().createCriteria(User.class);
		c.add(Restrictions.eq("loginstatus",NotLoggedin));
		List<User> list=c.list();
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
	
	

@SuppressWarnings({ "rawtypes", "unchecked" })
@Transactional
public Friend newrequest(String uid,String fid) {
	String hql="from Friend where userid='"+uid+"' and friendid='"+fid+"'";
	Query query =sessionFactory.getCurrentSession().createQuery(hql);
	List<Friend> list=query.list();
	if(list==null){
		return null;
	}else{
		return list.get(0);
	}
}

@Transactional
public List<Friend> getfriendlist(String uid) {
	String hql="from Friend where userid='"+uid+"' and status='a'";
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	List<Friend> list = query.list();
	return list;
}

@Transactional
public List<Friend> getrequestlist(String uid) {
	String hql="from Friend where friendid='"+uid+"' and status='n'";
	Query query=sessionFactory.getCurrentSession().createQuery(hql);
	List<Friend> list = query.list();
	return list;
}

@Transactional
public List<Friend> setonline(String uid) {
	String hql="from Friend where userid='"+uid+"' or friendid='"+uid+"'";
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	List<Friend> list=query.list();
	return list;
}

@Transactional
public List<Friend> getonlinefriends(String uid) {
	String hql="from Friend where userid='"+uid+"'and isonline='o' and status='a'";
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	List<Friend> list=query.list();
	return list;
}

}