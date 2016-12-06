package com.niit.DAO;

import java.util.List;

import com.niit.model.Forum;

public interface ForumDAO {

	public boolean delete(Forum forum);
	public boolean saveOrUpdate(Forum forum);
	public List<Forum>getForum();
	public String  getallForum();
	public Forum forumbyid(int id);
	
}
