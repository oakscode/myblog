package com.oakscode.spring.model;

public class Subcategory {

	private int id_sc;
	private int id_mc;
	private int id_user;
	private String title;
	private int active;
	private int priority;
	private String con;
	private int blogs;
	private String slug;
	
	
	

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public int getBlogs() {
		return blogs;
	}

	public void setBlogs(int blogs) {
		this.blogs = blogs;
	}

	public int getId_sc() {
		return id_sc;
	}

	public void setId_sc(int id_sc) {
		this.id_sc = id_sc;
	}

	public int getId_mc() {
		return id_mc;
	}

	public void setId_mc(int id_mc) {
		this.id_mc = id_mc;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getCon() {
		return con;
	}

	public void setCon(String con) {
		this.con = con;
	}

}
