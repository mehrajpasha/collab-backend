package com.niit.Testcase;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.BlogDAO;
import com.niit.model.Blog;

public class Blogtest {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit");
		context.refresh();

		BlogDAO blogDAO = (BlogDAO) context.getBean("blogDAO");
		Blog blog = (Blog) context.getBean("blog");

		blog.setBlogid(002);
		blog.setBlogname("samsung");
		blog.setBlogdescription("this is laptop product");
		

		if (blogDAO.saveOrUpdate(blog) == true) {
			System.out.println("product created successfully");
		} else {
			System.out.println("not able to create product");
		}

	}
}
