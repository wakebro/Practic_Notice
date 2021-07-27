package com.wakebro.app.entity;

import java.sql.Date;

public class Notice {
	private int no;
	private String id;
	private String title;
	private String content;
	private Date date;
	
	public Notice() {
	}
	
	public Notice(int no, String id, String title, String content, Date date) {
		this.no = no;
		this.id = id;
		this.title = title;
		this.content = content;
		this.date = date;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
