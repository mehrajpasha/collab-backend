package com.niit.DAO;

import java.util.List;

import com.niit.model.Forumcomment;

public interface ForumCommentDAO {

	public boolean saveOrUpdate(Forumcomment forumcomment);
	public boolean delete(Forumcomment forumcomment);
	public List<Forumcomment> list(int fid);
}