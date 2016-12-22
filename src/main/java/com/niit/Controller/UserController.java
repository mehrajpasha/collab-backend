package com.niit.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
		user.setStatus('N');
		userDAO.saveOrUpdate(user);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	

@GetMapping(value="/users")
public ResponseEntity<List<User>> listuser(){
	System.out.println("list of users");
	List<User> users1 =userDAO.getUsers();
	return new ResponseEntity<List<User>>(users1,HttpStatus.OK);
}
@GetMapping(value="/oneuser")
public ResponseEntity<User> oneuser(HttpSession session){
	String username=(String) session.getAttribute("username");
	User oneuser=userDAO.profileof(username);
	return new ResponseEntity<User>(oneuser,HttpStatus.OK);
}
@PostMapping("/imageUpload")
public void ImageUpload(@RequestBody MultipartFile file,HttpSession session) throws IOException {
	
	String username = (String) session.getAttribute("username"); /*Get Logged in Username*/
	User user=userDAO.profileof(username);					/*Get user object based on username*/
	System.out.println(file.getContentType()+'\n'+file.getName()+'\n'+file.getSize()+'\n'+file.getOriginalFilename());
	user.setImage(file.getBytes());
	userDAO.saveOrUpdate(user);
}

@GetMapping("/profileimage")
public ResponseEntity<User> profileimage(HttpSession session){
	int uid=(Integer) session.getAttribute("uid");
	User user=userDAO.userbyid(uid);
	return new ResponseEntity<User>(user, HttpStatus.OK);
}
	
}
