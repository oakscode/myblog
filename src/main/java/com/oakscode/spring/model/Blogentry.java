package com.oakscode.spring.model;

public class Blogentry {

	private int id_be;
	private int id_sc;
	private int id_user;
	private int id_userliked;
	private String title;
	private String con;
	private String body;
	private int active;
	private int priority;
	private byte[] cover;
	
	private String day;
	private String month;
	private String year;
	private String desc;
	private String sc_slug;
	
	private String mc_title;
	private String mc_slug;
	
	
	
	
	

	public String getMc_title() {
		return mc_title;
	}

	public void setMc_title(String mc_title) {
		this.mc_title = mc_title;
	}

	public String getMc_slug() {
		return mc_slug;
	}

	public void setMc_slug(String mc_slug) {
		this.mc_slug = mc_slug;
	}

	public String getSc_slug() {
		return sc_slug;
	}

	public void setSc_slug(String sc_slug) {
		this.sc_slug = sc_slug;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public byte[] getCover() {
		return cover;
	}

	public void setCover(byte[] cover) {
		this.cover = cover;
	}

	public int getId_be() {
		return id_be;
	}

	public void setId_be(int id_be) {
		this.id_be = id_be;
	}

	public int getId_sc() {
		return id_sc;
	}

	public void setId_sc(int id_sc) {
		this.id_sc = id_sc;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public int getId_userliked() {
		return id_userliked;
	}

	public void setId_userliked(int id_userliked) {
		this.id_userliked = id_userliked;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCon() {
		return con;
	}

	public void setCon(String con) {
		this.con = con;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

}
