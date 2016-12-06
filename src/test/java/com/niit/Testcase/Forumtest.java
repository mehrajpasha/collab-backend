package com.niit.Testcase;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.ForumDAO;
import com.niit.model.Forum;

public class Forumtest {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit");
		context.refresh();

		ForumDAO forumDAO = (ForumDAO) context.getBean("forumDAO");
		Forum forum = (Forum) context.getBean("forum");

		forum.setForumid(002);
		forum.setForumname("samsung");
		forum.setForumdesc("this is laptop product");
		

		if (forumDAO.saveOrUpdate(forum) == true) {
			System.out.println("product created successfully");
		} else {
			System.out.println("not able to create product");
		}

	}
}
