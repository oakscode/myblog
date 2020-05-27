package com.oakscode.spring.controller;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.oakscode.spring.dao.AdminDao;
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
import com.oakscode.spring.validation.LoginValidation;

@Controller
public class HomeController {

	private static final Logger logger = Logger.getLogger(HomeController.class);

	@Autowired
	private AdminDao dao;

	@RequestMapping(value = "/links")
	public ModelAndView test(HttpServletResponse response) throws IOException {

		return new ModelAndView("links");
	}
	@RequestMapping(value = "/404")
	public ModelAndView notfount(HttpServletResponse response) throws IOException {

		return new ModelAndView("404");
	}

	@RequestMapping(value = "/home")
	public ModelAndView gethome(HttpSession session, HttpServletResponse response) throws IOException {

		System.out.println("session 1:" + session.getAttribute("username"));
		System.out.println("session 2:" + session.getAttribute("password"));

		return new ModelAndView("home");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/dashboard")
	public ModelAndView getdashboard(HttpSession session, HttpServletResponse response) throws IOException {

		ModelAndView mv = new ModelAndView();

		String u = (String) session.getAttribute("username");
		String p = (String) session.getAttribute("password");

		System.out.println(u + "-------Session");

		if (u.equals(null)) {

			mv = getlogin(response);
		} else {
			int id_user = dao.get_id_user(u, p);

			List<User> li = dao.list_user(id_user);

			Iterator<User> it = li.iterator();

			while (it.hasNext()) {
				User user = (User) it.next();

				System.out.println(user.getFname());
				System.out.println(user.getLname());
				System.out.println(user.getCon());
				System.out.println(user.getId_user());

				session.setAttribute("fname", user.getFname());
				session.setAttribute("lname", user.getLname());
				session.setAttribute("id_user", user.getId_user());

			}
			HashMap<String, List<User>> hm = new HashMap<String, List<User>>();
			hm.put("user", li);
			mv = new ModelAndView("dashboard");
			mv.addObject("list", hm);

			// mv = new ModelAndView("dashboard");
		}
		return mv;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView getlogin(HttpServletResponse response) throws IOException {
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/logout")
	public ModelAndView getlogout(HttpSession session, HttpServletResponse response) throws IOException {

		try {
			session.invalidate();
			System.out.println("[info]Session invalidate successfully");
		} catch (IllegalStateException e) {
			System.out.println("[warn]Session not invalidate successfully");
		}

		return getlogin(response);
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView getsignup(HttpServletResponse response) throws IOException {
		return new ModelAndView("signup");
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView getsignup_post(HttpServletResponse response, @ModelAttribute("user") Signup u)
			throws IOException, SQLException {

		try {
			String key = dao.insert_user(u);
			Credential c = new Credential();

			c.setId_user(key);
			c.setUsername(u.getUsername());
			c.setPassword(u.getPassword());
			int i = dao.insert_credential(c);

			System.out.println(i + "<--User Registration Successfully");

		} catch (Exception e) {

			System.out.println("insert user Exception");
		}
		return new ModelAndView("signup");
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView postlogin(HttpSession session, HttpServletResponse response, @ModelAttribute("login") login l)
			throws IOException {

		ModelAndView mv = new ModelAndView();

		int i = dao.logincheck(l);

		switch (i) {

		case 1:
			session.setAttribute("username", l.getUsername());
			session.setAttribute("password", l.getPassword());
			mv = getdashboard(session, response);

			break;

		case 2:
			session.setAttribute("username", l.getUsername());
			session.setAttribute("password", l.getPassword());
			mv = gethome(session, response);
			break;

		default:
			mv = getlogin(response);
			break;
		}

		return mv;
	}

	@RequestMapping(value = "/admin_user_mngt")
	public ModelAndView getadmin_user_mngt(HttpSession session, HttpServletResponse response) throws IOException {

		ModelAndView mv;

		String u = (String) session.getAttribute("username");
		String p = (String) session.getAttribute("password");

		int id_user = dao.get_id_user(u, p);

		List<User> li = dao.list_user(id_user);
		List<User> li2 = dao.list_user();

		HashMap<String, List<User>> hm = new HashMap<String, List<User>>();

		hm.put("user", li);
		hm.put("users", li2);

		mv = new ModelAndView("admin_user_mngt");
		mv.addObject("list", hm);

		return mv;
	}

	@RequestMapping(value = "/admin_user_update", method = RequestMethod.GET)
	public ModelAndView getadmin_user_update(@RequestParam int id, HttpSession session, HttpServletResponse response)
			throws IOException {

		System.out.println("user update id : " + id);

		ModelAndView mv;

		String u = (String) session.getAttribute("username");
		String p = (String) session.getAttribute("password");

		int id_user = dao.get_id_user(u, p);

		List<User> li = dao.list_user(id_user);

		List<User> li2 = dao.list_user(id);
		List<Credential> li3 = dao.list_credential(id);

		HashMap<String, List<?>> hm = new HashMap<String, List<?>>();

		hm.put("user", li);
		hm.put("useredit", li2);
		hm.put("credential", li3);

		mv = new ModelAndView("admin_user_update");
		mv.addObject("list", hm);

		return mv;
	}

	@RequestMapping(value = "/admin_user_update", method = RequestMethod.POST)
	public ModelAndView getadmin_user_update_post(@RequestParam("file") CommonsMultipartFile[] file,
			HttpSession session, HttpServletResponse response, @ModelAttribute("User") User u) throws IOException {

		if (file != null && file.length > 0) {
			for (CommonsMultipartFile aFile : file) {

				System.out.println("Saving file: " + aFile.getOriginalFilename());

				UploadFile uploadFile = new UploadFile();
				uploadFile.setFileName(aFile.getOriginalFilename());
				uploadFile.setData(aFile.getBytes());
				dao.upload_user_image(uploadFile, u.getId_user());
				u.setImage_path(aFile.getOriginalFilename());
			}
		}

		dao.update_user(u);
		u.show();

		ModelAndView mv;

		String un = (String) session.getAttribute("username");
		String pd = (String) session.getAttribute("password");

		int id_user = dao.get_id_user(un, pd);

		List<User> li = dao.list_user(id_user);
		List<User> li2 = dao.list_user(u.getId_user());
		List<Credential> li3 = dao.list_credential(u.getId_user());

		HashMap<String, List<?>> hm = new HashMap<String, List<?>>();

		hm.put("user", li);
		hm.put("useredit", li2);
		hm.put("credential", li3);

		mv = new ModelAndView("admin_user_update");
		mv.addObject("list", hm);

		return mv;
	}

	@RequestMapping(value = "/get_user_image/{id}")
	public void imagebyid(HttpServletResponse response, @PathVariable("id") int id) throws IOException, SQLException {

		ModelAndView mv = new ModelAndView();
		response.setContentType("image/jpeg");

		Blob ph = dao.get_user_image(id);

		byte[] bytes = ph.getBytes(1, (int) ph.length());
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, response.getOutputStream());

	}
	
	@RequestMapping(value = "/get_thumb_image/{id}")
	public void getthumbimage(HttpServletResponse response, @PathVariable("id") int id) throws IOException, SQLException {

		ModelAndView mv = new ModelAndView();
		response.setContentType("image/jpeg");

		Blob ph = dao.get_thumb_image(id);

		byte[] bytes = ph.getBytes(1, (int) ph.length());
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, response.getOutputStream());

	}

	@RequestMapping(value = "admin_user_delete")
	public ModelAndView admin_user_delete(HttpSession session, HttpServletResponse response, @RequestParam int id)
			throws IOException, SQLException {

		ModelAndView mv = new ModelAndView();

		System.out.println("-----------------admin_user_delete");
		int[] status = dao.delete_user(id);

		System.out.println("User batch delete : " + status.toString());

		mv = getadmin_user_mngt(session, response);

		return mv;
	}

	@RequestMapping(value = "admin_cred_update")
	public ModelAndView admin_cred_update(HttpSession session, HttpServletResponse response,
			@ModelAttribute("Credential") Credential c) throws IOException, SQLException {

		ModelAndView mv = new ModelAndView();

		int i = dao.update_credential(c);

		int id = Integer.parseInt(c.getId_user());

		mv = getadmin_user_update(id, session, response);

		return mv;
	}

	@RequestMapping(value = "/admin_add_main_cat", method = RequestMethod.GET)
	public ModelAndView get_admin_add_main_cat(HttpServletResponse response, HttpSession session) throws IOException {

		ModelAndView mv = new ModelAndView("admin_add_main_cat");

		String u = (String) session.getAttribute("username");
		String p = (String) session.getAttribute("password");

		List<User> li = dao.list_user(dao.get_id_user(u, p));
		List<Maincategory> li1 = dao.list_maincategory();

		HashMap<String, List<?>> hm = new HashMap<String, List<?>>();

		hm.put("user", li);
		hm.put("maincategory", li1);
		mv.addObject("list", hm);

		return mv;

	}

	@RequestMapping(value = "/admin_add_main_cat", method = RequestMethod.POST)
	public ModelAndView post_admin_add_main_cat(HttpServletResponse response, HttpSession session,
			@ModelAttribute("Maincategory") Maincategory m) throws IOException {

		ModelAndView mv;

		String u = (String) session.getAttribute("username");
		String p = (String) session.getAttribute("password");

		m.setId_user(dao.get_id_user(u, p));
		m.setActive(1);
		m.setPriority(0);

		int i = dao.insert_main_category(m);

		return get_admin_add_main_cat(response, session);

	}
	//admin_add_defaultoption
	
	@RequestMapping(value = "/admin_add_defaultoption", method = RequestMethod.POST)
	public ModelAndView admin_add_defaultoption(HttpServletResponse response, HttpSession session,
			@ModelAttribute("Defaultoption") Defaultoption d) throws IOException {

		ModelAndView mv;





		int i = dao.insert_defaultoption(d);

		return get_admin_add_main_cat(response, session);

	}

	@RequestMapping(value = "/admin_add_sub_cat", method = RequestMethod.POST)
	public ModelAndView post_admin_add_sub_cat(HttpServletResponse response, HttpSession session,
			@ModelAttribute("Maincategory") Subcategory s) throws IOException {

		String u = (String) session.getAttribute("username");
		String p = (String) session.getAttribute("password");

		s.setId_user(dao.get_id_user(u, p));
		s.setActive(1);
		s.setPriority(0);

		int i = dao.insert_sub_category(s);

		return get_admin_add_main_cat(response, session);

	}

	@RequestMapping(value = "/admin_list_cat", method = RequestMethod.GET)
	public ModelAndView get_admin_list_cat(HttpServletResponse response, HttpSession session) throws IOException {

		ModelAndView mv = new ModelAndView("admin_list_cat");

		String u = (String) session.getAttribute("username");
		String p = (String) session.getAttribute("password");

		List<User> li = dao.list_user(dao.get_id_user(u, p));
		List<Maincategory> li1 = dao.list_maincategory();

		HashMap<String, List<?>> hm = new HashMap<String, List<?>>();

		hm.put("user", li);
		hm.put("maincategory", li1);
		mv.addObject("list", hm);

		return mv;

	}

	@RequestMapping(value = "/admin_list_subcat", method = RequestMethod.GET)
	public ModelAndView get_admin_list_subcat(HttpServletResponse response, HttpSession session,
			@RequestParam("id") int id) throws IOException {

		ModelAndView mv = new ModelAndView("admin_list_subcat");

		String u = (String) session.getAttribute("username");
		String p = (String) session.getAttribute("password");

		List<User> li = dao.list_user(dao.get_id_user(u, p));
		List<Subcategory> li1 = dao.list_subcategory(id);

		HashMap<String, List<?>> hm = new HashMap<String, List<?>>();

		hm.put("user", li);
		hm.put("subcategory", li1);
		mv.addObject("list", hm);

		return mv;

	}

	@RequestMapping(value = "deletesubcat", method = RequestMethod.GET)
	public ModelAndView deletesubcat(HttpSession session, HttpServletResponse response,
			@RequestParam("id_mc") int id_mc, @RequestParam("id_sc") int id_sc) throws IOException, SQLException {

		ModelAndView mv = new ModelAndView();

		int[] status = dao.delete_subcategory(id_sc);

		System.out.println("User batch delete : " + Arrays.toString(status));

		mv = get_admin_list_subcat(response, session, id_mc);

		return mv;
	}

	@RequestMapping(value = "deletemaincat", method = RequestMethod.GET)
	public ModelAndView deletemaincat(HttpSession session, HttpServletResponse response, @RequestParam("id") int id)
			throws IOException, SQLException {

		ModelAndView mv = new ModelAndView();

		int[] status = dao.delete_maincategory(id);

		System.out.println("User batch delete : " + Arrays.toString(status));

		mv = get_admin_list_cat(response, session);

		return mv;
	}
	//deletedefaultoption
	@RequestMapping(value = "deletedefaultoption", method = RequestMethod.GET)
	public ModelAndView deletedefaultoption(HttpSession session, HttpServletResponse response, @RequestParam("id") String id)
			throws IOException, SQLException {

		ModelAndView mv = new ModelAndView();

		int[] status = dao.delete_defaultoption(id);


		mv = admin_edit_defaultoption(response, session);

		return mv;
	}

	// =================================blog Entry===============================


	@RequestMapping(value = "/blogentry", method = RequestMethod.GET)
	public ModelAndView get_blogentry(HttpServletResponse response, HttpSession session,
			@RequestParam("id_sc") int id_sc) throws IOException {

		ModelAndView mv = new ModelAndView("admin_blogentry");

		String u = (String) session.getAttribute("username");
		String p = (String) session.getAttribute("password");

		List<User> li = dao.list_user(dao.get_id_user(u, p));

		HashMap<String, List<?>> hm = new HashMap<String, List<?>>();

		hm.put("user", li);
		mv.addObject("list", hm);
		mv.addObject("id_sc", id_sc);

		return mv;

	}

	@RequestMapping(value = "/blogentry", method = RequestMethod.POST)
	public ModelAndView post_blogentry(@RequestParam("file") CommonsMultipartFile[] file, HttpServletResponse response,
			HttpSession session, @ModelAttribute("Blogentry") Blogentry b,@RequestParam("desc") String desc) throws IOException {

		ModelAndView mv = new ModelAndView("admin_blogentry");

		String u = (String) session.getAttribute("username");
		String p = (String) session.getAttribute("password");

		b.setActive(1);
		b.setId_user(dao.get_id_user(u, p));
		b.setId_userliked(0);

		if (file != null && file.length > 0) {
			for (CommonsMultipartFile aFile : file) {

				System.out.println("Saving file: " + aFile.getOriginalFilename());
				b.setCover(aFile.getBytes());
			}
		}
		dao.insert_blogentry(b);
		

		mv = get_blogentry(response, session, b.getId_sc());

		return mv;

	}

	@RequestMapping(value = "/admin_list_blog", method = RequestMethod.GET)
	public ModelAndView get_admin_list_blog(HttpServletResponse response, HttpSession session,
			@RequestParam("id") int id) throws IOException {

		ModelAndView mv = new ModelAndView("admin_list_blog");

		String u = (String) session.getAttribute("username");
		String p = (String) session.getAttribute("password");

		List<User> li = dao.list_user(dao.get_id_user(u, p));
		List<Blogentry> li1 = dao.list_blog(id);

		HashMap<String, List<?>> hm = new HashMap<String, List<?>>();

		hm.put("user", li);
		hm.put("blogs", li1);
		mv.addObject("list", hm);

		return mv;

	}

	@RequestMapping(value = "/deletepost", method = RequestMethod.GET)
	public ModelAndView deletepost(HttpServletResponse response, HttpSession session, @RequestParam("id_sc") int id_sc,
			@RequestParam("id_be") int id_be) throws IOException {
		ModelAndView mv;

		int[] status = dao.delete_blogentry(id_be);

		return mv = get_admin_list_blog(response, session, id_sc);

	}

	// editblog
	@RequestMapping(value = "/editblog", method = RequestMethod.GET)
	public ModelAndView editblog(HttpServletResponse response, HttpSession session, @RequestParam("id_sc") int id_sc,
			@RequestParam("id_be") int id_be) throws IOException {

		ModelAndView mv = new ModelAndView("admin_edit_blobentry");

		String u = (String) session.getAttribute("username");
		String p = (String) session.getAttribute("password");

		List<User> li = dao.list_user(dao.get_id_user(u, p));
		List<Blogentry> li2 = dao.list_blog_toedit(id_be);

		HashMap<String, List<?>> hm = new HashMap<String, List<?>>();

		hm.put("user", li);
		hm.put("post", li2);
		mv.addObject("list", hm);

		return mv;

	}

	@RequestMapping(value = "/editblog", method = RequestMethod.POST)
	public ModelAndView post_editblog(@RequestParam("file") CommonsMultipartFile[] file, HttpServletResponse response,
			HttpSession session, @ModelAttribute("Blogentry") Blogentry b) throws IOException {

		ModelAndView mv = new ModelAndView("editblog");

		String u = (String) session.getAttribute("username");
		String p = (String) session.getAttribute("password");

		b.setActive(1);
		b.setId_user(dao.get_id_user(u, p));
		b.setId_userliked(0);

		if (file != null && file.length > 0) {
			for (CommonsMultipartFile aFile : file) {

				System.out.println("Saving file: " + aFile.getOriginalFilename());
				b.setCover(aFile.getBytes());
			}
		}

		dao.update_blogentry(b);

		mv = editblog(response, session, b.getId_sc(), b.getId_be());
		logger.info("Blog Update Successfully");
		return mv;

	}
	@RequestMapping(value = "/admin_edit_priority", method = RequestMethod.GET)
	public ModelAndView editpriority(HttpServletResponse response, HttpSession session) throws IOException {

		ModelAndView mv = new ModelAndView("admin_edit_priority");

		String u = (String) session.getAttribute("username");
		String p = (String) session.getAttribute("password");

		List<User> li = dao.list_user(dao.get_id_user(u, p));
		List<Maincategory> li1 = dao.list_maincategory();

		HashMap<String, List<?>> hm = new HashMap<String, List<?>>();

		hm.put("user", li);
		hm.put("maincategory", li1);
		mv.addObject("list", hm);

		return mv;

	}
	//
	@RequestMapping(value = "/admin_edit_defaultoption", method = RequestMethod.GET)
	public ModelAndView admin_edit_defaultoption(HttpServletResponse response, HttpSession session) throws IOException {

		ModelAndView mv = new ModelAndView("admin_edit_defaultoption");

		String u = (String) session.getAttribute("username");
		String p = (String) session.getAttribute("password");

		List<User> li = dao.list_user(dao.get_id_user(u, p));
		List<Defaultoption> li1 = dao.list_defaultoption();

		HashMap<String, List<?>> hm = new HashMap<String, List<?>>();

		hm.put("user", li);
		hm.put("defaultoption", li1);
		mv.addObject("list", hm);

		return mv;

	}
	
	@RequestMapping("/updatepriority")
	@ResponseBody
	   public String empsdfloyeeForm(@RequestParam("id") int id,@RequestParam("value") String value) {
		   
		
		dao.update_mc_priority(id, value);
		   
	      return "Main category("+id+") priority updated to :"+value;
	   }

	@RequestMapping("/updatesubpriority")
	@ResponseBody
	   public String updatesubpriority(@RequestParam("id") int id,@RequestParam("value") String value) {
		   
		
		dao.update_sc_priority(id, value);
		   
	      return "Sub category("+id+") priority updated to :"+value;
	   }
	//updatebepriority
	@RequestMapping("/updatebepriority")
	@ResponseBody
	   public String updatebepriority(@RequestParam("id") int id,@RequestParam("value") String value) {
		   
		
		dao.update_be_priority(id, value);
		   
	      return "Sub category("+id+") priority updated to :"+value;
	   }

	// =================================Client Side========================

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getindex(HttpServletResponse response) {

		ModelAndView mv;

		List<Maincategory> li = dao.list_maincategory();
		List<Blogentry>    li2= dao.list_blog_recent();
		HashMap<String, List<?>> hm = new HashMap<String, List<?>>();

		hm.put("maincategory", li);
		hm.put("thumb",li2);
		mv = new ModelAndView("index");
		mv.addObject("list", hm);

		return mv;
	}
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView getabout(HttpServletResponse response) {

		ModelAndView mv;

		List<Maincategory> li = dao.list_maincategory();
		List<Defaultoption> li2 = dao.list_defaultoption("connect");

		HashMap<String, List<?>> hm = new HashMap<String, List<?>>();

		hm.put("maincategory", li);
		hm.put("connect", li2);

		mv = new ModelAndView("about");
		mv.addObject("list", hm);

		return mv;
	}

	@RequestMapping(value = "/{url}", method = RequestMethod.GET)
	public ModelAndView getblog(HttpServletResponse response, @PathVariable("url") String url) {


		ModelAndView mv = null;
		// ===Split
		String s1 = url;
		String[] words = s1.split("-");
		
		//new dispatching
		int slugcount = words.length;
		
		if(slugcount ==1 || slugcount ==2 ||slugcount ==3) {
			
			if (slugcount == 1) { //side menu return
				
				if (dao.maincategory_slug_check(words[0]) > 0) {
					
					List<Maincategory> li = dao.list_maincategory();
					List<Menu> li2 = dao.list_menu(dao.maincategory_slug_check(words[0]));
					List<Blogentry> li3 = dao.list_blog_default(dao.maincategory_slug_check(words[0]));
					List<Blogentry> li4 = dao.list_blog_recent();
					List<Defaultoption> li5 = dao.list_defaultoption("connect");
 					
					HashMap<String, List<?>> hm = new HashMap<String, List<?>>();

					hm.put("maincategory", li);
					hm.put("menu", li2);
					hm.put("blog", li3);
					hm.put("recent", li4);
					hm.put("connect", li5);
					mv = new ModelAndView("blog");
					mv.addObject("list", hm);
					mv.addObject("mainslug", words[0]);
					
				}
			}
			else if(slugcount == 2) { 
				if (dao.sc_check(words[1])>0) {
					
					List<Maincategory> li = dao.list_maincategory();
					List<Menu> li2 = dao.list_menu(dao.maincategory_slug_check(words[0]));
					List<Blogentry> li3 = dao.list_blog(dao.sc_check(words[1]));
					
					List<Blogentry> li4 = dao.list_blog_recent();
					
					HashMap<String, List<?>> hm = new HashMap<String, List<?>>();

					hm.put("maincategory", li);
					hm.put("menu", li2);
					hm.put("blog", li3);
					hm.put("recent", li4);
					mv = new ModelAndView("blog");
					mv.addObject("list", hm);
					mv.addObject("mainslug", words[0]);
					
				}
			}
			else if(slugcount == 3) { 
				if (dao.blog_check(words[2])>0) {
					
					List<Maincategory> li = dao.list_maincategory();
					List<Menu> li2 = dao.list_menu(dao.maincategory_slug_check(words[0]));
					List<Blogentry> li3 = dao.list_blog_toedit(dao.blog_check(words[2]));
					List<Blogentry> li4 = dao.list_blog_recent();
					List<Defaultoption> li5 = dao.list_defaultoption("connect");
					
					
					HashMap<String, List<?>> hm = new HashMap<String, List<?>>();

					hm.put("maincategory", li);
					hm.put("menu", li2);
					hm.put("blog", li3);
					hm.put("recent", li4);
					hm.put("connect", li5);
					mv = new ModelAndView("blog");
					mv.addObject("list", hm);
					mv.addObject("mainslug", words[0]);
					
				} 
			}

			
			
			
		}else {
			mv = new ModelAndView("404");
			
		}

		return mv;
	
	}
    
}
