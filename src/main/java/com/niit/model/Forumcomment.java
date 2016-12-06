package com.niit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Forumcomment {

	@Id
	@GeneratedValue
	private int id;
	private int userid;
	private int fid;
	@Column(name="comments")
	private String comment;
	private Date commenttime;
	public int getId() {
		return id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getCommenttime() {
		return commenttime;
	}
	public void setCommenttime(Date commenttime) {
		this.commenttime = commenttime;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}