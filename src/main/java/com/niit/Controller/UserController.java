package com.niit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.DAO.UserDAO;
import com.niit.model.User;

@RestController
public class UserController {
	@Autowired
	private UserDAO userDAO;
	
	@PostMapping("/postuser")
	public ResponseEntity<User>senduserdetails(@RequestBody User user)
	{
		System.out.println(user.getUsername());
		user.setStatus("N");
		userDAO.saveOrUpdate(user);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
}
