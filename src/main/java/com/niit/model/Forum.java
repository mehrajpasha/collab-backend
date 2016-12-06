package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Forum {
	@Id
	@GeneratedValue
	private int forumid;
	private String forumdesc;
	private String forumname;
	public int getForumid() {
		return forumid;
	}
	public void setForumid(int forumid) {
		this.forumid = forumid;
	}
	public String getForumdesc() {
		return forumdesc;
	}
	public void setForumdesc(String forumdesc) {
		this.forumdesc = forumdesc;
	}
	public String getForumname() {
		return forumname;
	}
	public void setForumname(String forumname) {
		this.forumname = forumname;
	}

}
