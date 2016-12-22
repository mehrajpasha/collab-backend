package com.niit.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
public class LoginController {
	@Autowired 
	UserDAO userDAO;
	

	FriendDAO friendDAO;

	@GetMapping("/login/{username}/{password}")
	public ResponseEntity<User> login( @PathVariable("username") String username,@PathVariable("password") String password ,HttpSession session){
		User user = userDAO.authuser(username,password);
		if(user==null)
			{	return null;
	}/*else if(friendDAO.getfriendlist(username)==null){
		session.setAttribute("userLogged", user);
		session.setAttribute("uid", user.getUserid());
		session.setAttribute("username",user.getUsername());
		user.setLoginstatus("o");
		userDAO.saveOrUpdate(user);
		User user1=userDAO.userbyid(user.getUserid());
		return new ResponseEntity<User>(user1,HttpStatus.OK);
	}*/
	else{
		session.setAttribute("userLogged", user);
		session.setAttribute("uid", user.getUserid());
		session.setAttribute("username",user.getUsername());
		user.setStatus('o');
		userDAO.saveOrUpdate(user);
    	/*List<Friend>friend=  friendDAO.setonline(user.getUsername());
    	for(int i=0;i<friend.size();i++){
    		Friend online=friend.get(i);
    		online.setIsonline('o');
    		friendDAO.saveOrUpdate(online);
    	}*/
		User user1=userDAO.userbyid(user.getUserid());
		return new ResponseEntity<User>(user1,HttpStatus.OK);
	}
	}
	
	@PostMapping("/logout")
	public ResponseEntity<User> logout(HttpSession session){
		int uid =  (Integer) session.getAttribute("uid");
		User user = userDAO.userbyid(uid);
		user.setStatus('f');
		userDAO.saveOrUpdate(user);
		List<Friend> friend=friendDAO.setonline(user.getUsername());
		for(int i=0;i<friend.size();i++){
    		Friend online=friend.get(i);
    		online.setIsonline('f');
    		friendDAO.saveOrUpdate(online);
    	}
		session.invalidate();
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
}