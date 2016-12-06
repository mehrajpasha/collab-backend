package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Blog {
	@Id
	@GeneratedValue
	private int blogid;
	private String blogname;
	private String blogdescription;
	private int b_userid;
	private String blogtime;
	public int getBlogid() {
		return blogid;
	}
	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}
	public String getBlogname() {
		return blogname;
	}
	public void setBlogname(String blogname) {
		this.blogname = blogname;
	}
	public String getBlogdescription() {
		return blogdescription;
	}
	public void setBlogdescription(String blogdescription) {
		this.blogdescription = blogdescription;
	}
	public int getB_userid() {
		return b_userid;
	}
	public void setB_userid(int b_userid) {
		this.b_userid = b_userid;
	}
	public String getBlogtime() {
		return blogtime;
	}
	public void setBlogtime(String blogtime) {
		this.blogtime = blogtime;
	}
	
	

}
