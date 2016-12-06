package com.niit.DAO;

import java.util.List;

import com.niit.model.Blog;

public interface BlogDAO {

	public boolean delete(Blog blog);
	public boolean saveOrUpdate(Blog blog);
	public List<Blog>getBlogs();
	public String  getallBlogs();
	public Blog blogbyid(int id);
	
}
