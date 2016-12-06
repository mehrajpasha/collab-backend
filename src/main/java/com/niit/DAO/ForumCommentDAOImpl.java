package com.niit.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Forumcomment;

@Repository(value="forumCommentDAOImpl")
public class ForumCommentDAOImpl implements ForumCommentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	public ForumCommentDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public boolean saveOrUpdate(Forumcomment forumcomment) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(forumcomment);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Transactional
	public boolean delete(Forumcomment forumcomment) {
		try {
			sessionFactory.getCurrentSession().delete(forumcomment);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Transactional
	public List<Forumcomment> list(int fid) {
		Criteria c=sessionFactory.getCurrentSession().createCriteria(Forumcomment.class);
		c.add(Restrictions.eq("fid", fid));
		List<Forumcomment> list=c.list();
		return list;
	}

}