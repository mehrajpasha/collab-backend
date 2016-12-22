package com.niit.DAO;

import java.util.List;

import com.niit.model.Friend;
import com.niit.model.User;

public interface FriendDAO {

	
	public List<User> getmynonfriends();
	public boolean saveOrUpdate(Friend friend);
	public boolean delete(Friend friend);
	/*public Friend acceptrequest(String uid,String fid);
	public List<Friend> getmyfriends(String uid);
	public List<Friend> acceptedfriends(String uid);*/
	
	public List<Friend> getfriendlist(String uid);
	public List<Friend> getrequestlist(String uid);
	public List<Friend> setonline(String uid);
	public List<Friend> getonlinefriends(String uid);
	public Friend newrequest(String uid,String fid);
}
