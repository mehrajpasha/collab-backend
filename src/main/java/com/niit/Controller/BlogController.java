package com.niit.Controller;

import javax.servlet.http.HttpSession;

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

import com.niit.DAO.BlogDAO;
import com.niit.model.Blog;


@RestController
public class BlogController {
    
	@Autowired
	private BlogDAO blogDAO;
	
	@PostMapping("/pattern")
	public ResponseEntity<Blog> postblog(@RequestBody Blog blog,HttpSession session)
	{
		blog.setB_userid((int) session.getAttribute("uid"));
		System.out.println(blog.getBlogdescription());
		blogDAO.saveOrUpdate(blog);
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}
	
	@GetMapping("/getdata")
	public String getallblogs()
	{
		return blogDAO.getallBlogs();
		
	}
	
	@DeleteMapping("/delblog/{blogid}")
	public ResponseEntity<Blog>deleteblog(Blog blog, @PathVariable("blogid") int id)
	{
		System.out.println("delete");
		blogDAO.delete(blogDAO.blogbyid(id));
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}
	
	@GetMapping("/editblog/{blogid}")
	public Blog updateblog(Blog blogg, @PathVariable("blogid") int id)
	{
		
		blogg=this.blogDAO.blogbyid(id);
		return blogg ;
	}
}
