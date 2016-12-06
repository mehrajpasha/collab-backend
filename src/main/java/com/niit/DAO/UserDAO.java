package com.niit.DAO;

import java.util.List;

import com.niit.model.User;

public interface UserDAO {
	
	
	public boolean delete(User user);
	public boolean saveOrUpdate(User user);
	public List<User>getUsers();
	public String  getallUsers();
	public User userbyid(int fid);
	public User authuser(String username, String password);
}
