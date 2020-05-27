package com.oakscode.spring.model;

public class User {

	private int id_user;
	private String fname;
	private String lname;
	private String bio;
	private String phone;
	private String email;
	private String con;
	private String image_path;
	private byte[] image;

	public void show() {
		System.out.println("User ID    :" + id_user);
		System.out.println("First name :" + fname);
		System.out.println("Last  name :" + lname);
		System.out.println("bio        :" + bio);
		System.out.println("phone      :" + phone);
		System.out.println("email      :" + email);
		System.out.println("con        :" + con);
		System.out.println("image_path :" + image_path);
		System.out.println("image      :" + image);
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] bs) {
		this.image = bs;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCon() {
		return con;
	}

	public void setCon(String con) {
		this.con = con;
	}

}
