package com.niit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.niit.DAO.ForumDAO;
import com.niit.model.Forum;


@RestController
public class ForumController {
    
	@Autowired
	private ForumDAO forumDAO;
	
	@PostMapping("/postforum")
	public ResponseEntity<Forum> postforum(@RequestBody Forum forum)
	{
		System.out.println(forum.getForumdesc());
		forumDAO.saveOrUpdate(forum);
		return new ResponseEntity<Forum>(forum,HttpStatus.OK);
	}
	
	@GetMapping("/getforum")
	public String getallforums()
	{
		return forumDAO.getallForum();
		
	}
	
	@DeleteMapping("/delforum/{forumid}")
	public ResponseEntity<Forum>deleteforum(Forum forum, @PathVariable("forumid") int id)
	{
		System.out.println("delete");
		forumDAO.delete(forumDAO.forumbyid(id));
		return new ResponseEntity<Forum>(forum,HttpStatus.OK);
	}
	
	@GetMapping("/editforum/{forumid}")
	public Forum updateforum(Forum forumm, @PathVariable("blogid") int id)
	{
		
		forumm=this.forumDAO.forumbyid(id);
		return forumm ;
	}
	@GetMapping(value="/individualforum/{id}")
	public ResponseEntity<Forum> individualforum(@PathVariable("id") int id){
		Forum forum=forumDAO.forumbyid(id);
		return new ResponseEntity<Forum>(forum,HttpStatus.OK);
	}
}
