package com.oakscode.spring.model;

public class Credential {

	private String id_user;
	private String id_cred;
	private String username;
	private String password;
	private String datetime;
	private int ucode;
	private int active;
	
	
	
	

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getUcode() {
		return ucode;
	}

	public void setUcode(int ucode) {
		this.ucode = ucode;
	}

	public String getId_user() {
		return id_user;
	}

	public void setId_user(String id_user) {
		this.id_user = id_user;
	}

	public String getId_cred() {
		return id_cred;
	}

	public void setId_cred(String id_cred) {
		this.id_cred = id_cred;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

}
