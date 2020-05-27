package com.oakscode.spring.dao;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import com.oakscode.spring.model.Blogentry;
import com.oakscode.spring.model.Credential;
import com.oakscode.spring.model.Defaultoption;
import com.oakscode.spring.model.Maincategory;
import com.oakscode.spring.model.Menu;
import com.oakscode.spring.model.Signup;
import com.oakscode.spring.model.Subcategory;
import com.oakscode.spring.model.UploadFile;
import com.oakscode.spring.model.User;
import com.oakscode.spring.model.login;

public interface AdminDao {
	
	public void saveOrUpdate();
	
	public void insert(Signup p);
	
	public String insert_user(Signup p) throws SQLException;
	public int insert_main_category(Maincategory m);
	public int insert_sub_category(Subcategory s);
	public int insert_credential(Credential c) throws SQLException;
	public int insert_blogentry(Blogentry b);
	public int insert_defaultoption(Defaultoption d);
	
	public int update_credential(Credential c);
	public int update_user(User u);
	public int upload_user_image(UploadFile uploadFile,int id_user);
	public int update_mc_priority(int id,String value);
	public int update_sc_priority(int id,String value);
	public int update_be_priority(int id,String value);
	
	public int logincheck(login l);
	public int maincategory_slug_check(String s);
	public int blog_check(String s);
	public int sc_check(String s);
	
	public List<User> list_user(int id);
	public List<User> list_user();
	public List<Credential> list_credential(int id);
	public List<UploadFile> list_files();
	public List<Maincategory> list_maincategory();
	public List<Subcategory> list_subcategory(int id);
	public List<Blogentry> list_blog(int id);
	public List<Blogentry> list_blog_toedit(int id_be);
	public List<Blogentry> list_blog_mc(int id);
	public List<Blogentry> list_blog_recent();
	public List<Blogentry> list_blog_default(int id);
	public List<Menu> list_menu(int id_sc);
	
	public List<Defaultoption> list_defaultoption(String Key_code);
	public List<Defaultoption> list_defaultoption();
	
	

	public int get_id_user(String u, String p);
	public Blob get_user_image(int id);
	public Blob get_thumb_image(int id);
	
	public int[] delete_user(int id);
	public int[] delete_subcategory(int id);
	public int[] delete_maincategory(int id);
	public int[] delete_blogentry(int id_be);
	public int[] delete_defaultoption(String id);

	public int update_blogentry(Blogentry b);

	
	
	
	
	

	
	


}
