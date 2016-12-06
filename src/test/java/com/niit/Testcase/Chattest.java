/*package com.niit.Testcase;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.ChatDAO;
import com.niit.model.Chat;

public class Chattest {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit");
		context.refresh();

		ChatDAO chatDAO = (ChatDAO) context.getBean("chatDAO");
		Chat chat = (Chat) context.getBean("chat");

		chat.setChatid(002);
		chat.setChatname("samsung");
		chat.setChatdescription("this is laptop product");
		

		if (chatDAO.saveOrUpdate(chat) == true) {
			System.out.println("product created successfully");
		} else {
			System.out.println("not able to create product");
		}

	}
}
*/