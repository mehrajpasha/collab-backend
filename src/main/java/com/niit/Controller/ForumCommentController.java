package com.niit.Controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.DAO.ForumCommentDAO;
import com.niit.model.Forumcomment;



@RestController
public class ForumCommentController {

	@Autowired
	private ForumCommentDAO forumCommentDAO;
	
	@PostMapping(value="/commentforum/{fid}")
	public ResponseEntity<Forumcomment> forumcomment(@RequestBody Forumcomment forumcomment,HttpSession session,@PathVariable("fid") int fid){
		int uid=(Integer) session.getAttribute("uid");
		forumcomment.setFid(fid);
		forumcomment.setUserid(uid);
		forumcomment.setCommenttime(new Date());
		forumCommentDAO.saveOrUpdate(forumcomment);
		return new ResponseEntity<Forumcomment>(forumcomment,HttpStatus.OK);
		
	}
	
	@GetMapping(value="/getforumcomment/{fid}")
	public ResponseEntity<List<Forumcomment>> getcomment(@PathVariable("fid") int fid){
		List<Forumcomment> comments =forumCommentDAO.list(fid);
		return new ResponseEntity<List<Forumcomment>>(comments,HttpStatus.OK);
	}
}