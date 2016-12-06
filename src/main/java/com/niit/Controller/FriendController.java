package com.niit.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.DAO.FriendDAO;
import com.niit.DAO.UserDAO;
import com.niit.model.Friend;
import com.niit.model.User;

@RestController
public class FriendController {

	@Autowired
	private FriendDAO friendDAO;
	
	@Autowired
	private User user;
	
	@Autowired
	private Friend friend;
	
	@Autowired
	private UserDAO userDAO;
	
	@GetMapping("/getnonfrnds")
	public List<User> getallnonfrnds()
	{
		return friendDAO.getmynonfriends();
		
	}
	
	@PostMapping("/sendreq/{fid}")
	public void sendfrndrequest(@PathVariable("fid") String fid,HttpSession session)
	{
		String uid=(String) session.getAttribute("username");
		friend.setUserid(uid);
		friend.setFriendid(fid);
		friend.setStatus('n');
		friendDAO.saveOrUpdate(friend);
		//User user=userDAO.userbyid(fid);
		//user.setStatus("Y");
		//userDAO.saveOrUpdate(user);
	}
	@GetMapping("/myfriends")
	public ResponseEntity<List<Friend>> myfriends(HttpSession session){
		String uid=(String) session.getAttribute("username");
		List<Friend> myfriends =friendDAO.getmyfriends(uid);
		return new ResponseEntity<List<Friend>>(myfriends,HttpStatus.OK);
	}
	@PostMapping("accept/{fid}")
	public void acceptrequest(@PathVariable("fid") String fid,HttpSession session){
		
		String uid=(String) session.getAttribute("username");
		Friend friend=friendDAO.acceptrequest(fid, uid);
		friend.setStatus('a');
		friendDAO.saveOrUpdate(friend);
		Friend friend1=new Friend();
		friend1.setUserid(uid);
		friend1.setFriendid(fid);
		friend1.setStatus('a');
		friendDAO.saveOrUpdate(friend1);
	}
	@PostMapping("/reject/{fid}")
	public void rejectrequest(@PathVariable("fid") String fid,HttpSession session){
		String uid=(String) session.getAttribute("username");
		Friend friend=friendDAO.acceptrequest(fid, uid);
		friend.setStatus('r');
		friendDAO.saveOrUpdate(friend);
	}
	@PostMapping("/unfriend/{fid}")
	public void unfriend(@PathVariable("fid") String fid,HttpSession session){
		String uid=(String) session.getAttribute("username");
		Friend friend=friendDAO.acceptrequest(uid, fid);
		friend.setStatus('u');
		friendDAO.saveOrUpdate(friend);
		Friend friend1=friendDAO.acceptrequest(fid, uid);
		friend1.setStatus('u');
		friendDAO.saveOrUpdate(friend1);
	}
}
