package com.oakscode.spring.dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

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

public class AdminDaoImpl implements AdminDao {

	private JdbcTemplate jdbcTemplate;

	public AdminDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate() {

		// insert
		String sql = "INSERT INTO contact (name, email, address, telephone)" + " VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql, "vishnu", "vishnu@email.com", "pattambi", "1234567");

	}

	@Override
	public void insert(Signup p) {

		Date dt = new Date();

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(dt);

		// insert
		String sql = "INSERT INTO user (fname, lname, con, email) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql, p.getFname(), p.getLname(), currentTime, p.getEmail());

	}

	@Override
	public String insert_user(final Signup p) {

		Date dt = new Date();

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		final String currentTime = sdf.format(dt);

		// insert
		final String sql = "INSERT INTO user (fname, lname, con, email) VALUES (?, ?, ?, ?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement ps = con.prepareStatement(sql, new String[] { "id" });
				ps.setString(1, p.getFname());
				ps.setString(2, p.getLname());
				ps.setString(3, currentTime);
				ps.setString(4, p.getEmail());

				return ps;
			}
		}, keyHolder);

		System.out.println("key------------->" + keyHolder.getKey());

		return keyHolder.getKey().toString();

	}

	@Override
	public int insert_credential(Credential c) {

		Date dt = new Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(dt);

		// insert
		String sql = "INSERT INTO credential (id_user, username, password, datetime, ucode, active) VALUES (?, ?, ?, ?, ?, ?)";
		int i = jdbcTemplate.update(sql, c.getId_user(), c.getUsername(), c.getPassword(), currentTime, 2, 1);

		return i;

	}

	@Override
	public int logincheck(login l) {

		String sql = "select ucode from credential where username='" + l.getUsername() + "' and password = '"
				+ l.getPassword() + "';";

		List li = jdbcTemplate.query(sql, new RowMapper<Credential>() {
			public Credential mapRow(ResultSet rs, int row) throws SQLException {
				Credential c = new Credential();
				c.setUcode(rs.getInt(1));
				return c;
			}
		});
		Iterator<Credential> it = li.iterator();
		while (it.hasNext()) {
			Credential c = (Credential) it.next();

			System.out.println(c.getUcode() + "-------------list");
			return c.getUcode();

		}

		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List list_user(int id) {

		String sql = "select id_user,fname,lname,bio,con,phone,email from user where id_user = '" + id + "';";

		List<User> li = jdbcTemplate.query(sql, new RowMapper<User>() {
			public User mapRow(ResultSet rs, int row) throws SQLException {

				User u = new User();
				u.setId_user(rs.getInt("id_user"));
				u.setFname(rs.getString("fname"));
				u.setLname(rs.getString("lname"));
				u.setBio(rs.getString("bio"));
				u.setPhone(rs.getString("phone"));
				u.setEmail(rs.getString("email"));
				u.setCon(rs.getString("con"));

				return u;
			}
		});

		return li;
	}

	@Override
	public int get_id_user(String u, String p) {

		String sql = "select id_user from credential where username='" + u + "' and password = '" + p + "';";

		List li = jdbcTemplate.query(sql, new RowMapper<Credential>() {
			public Credential mapRow(ResultSet rs, int row) throws SQLException {
				Credential c = new Credential();
				c.setUcode(rs.getInt("id_user"));
				return c;
			}
		});
		Iterator<Credential> it = li.iterator();
		while (it.hasNext()) {
			Credential c = (Credential) it.next();

			System.out.println(c.getUcode() + "-------------user_id");
			return c.getUcode();

		}
		return 0;
	}

	@Override
	public List<User> list_user() {
		String sql = "select id_user,fname,lname,bio,con,phone,email from user ;";

		List<User> li = jdbcTemplate.query(sql, new RowMapper<User>() {
			public User mapRow(ResultSet rs, int row) throws SQLException {

				User u = new User();
				u.setId_user(rs.getInt("id_user"));
				u.setFname(rs.getString("fname"));
				u.setLname(rs.getString("lname"));
				u.setBio(rs.getString("bio"));
				u.setPhone(rs.getString("phone"));
				u.setEmail(rs.getString("email"));

				return u;
			}
		});

		return li;
	}

	@Override
	public List<Credential> list_credential(int id) {

		String sql = "select id_cred, id_user, ucode, username, password, datetime, active from credential where id_user = '"
				+ id + "';";

		List<Credential> li = jdbcTemplate.query(sql, new RowMapper<Credential>() {
			public Credential mapRow(ResultSet rs, int row) throws SQLException {

				Credential c = new Credential();
				c.setId_cred(rs.getString("id_cred"));
				c.setId_user(rs.getString("id_user"));
				c.setUcode(rs.getInt("ucode"));
				c.setUsername(rs.getString("username"));
				c.setPassword(rs.getString("password"));
				c.setDatetime(rs.getString("datetime"));
				c.setActive(rs.getInt("active"));

				return c;
			}
		});

		return li;
	}

	@Override
	public int update_user(User u) {
		String sql = "update user set fname='" + u.getFname() + "', lname='" + u.getLname() + "', bio='" + u.getBio()
				+ "', phone='" + u.getPhone() + "', email='" + u.getEmail() + "', image_path='" + u.getImage_path()
				+ "' where id_user=" + u.getId_user() + "";
		return jdbcTemplate.update(sql);
	}

	@Override
	public int upload_user_image(UploadFile uploadFile, int id_user) {

//		String sql = "INSERT INTO files_upload (file_name, file_data) VALUES (?, ?)";
//		int i = jdbcTemplate.update(sql,uploadFile.getFileName(),uploadFile.getData());

		String sql = "UPDATE  user SET image=? WHERE id_user=?";
		int i = jdbcTemplate.update(sql, uploadFile.getData(), id_user);

		return i;
	}

	@Override
	public List<UploadFile> list_files() {
		String sql = "select upload_id,file_name,file_data from files_upload ";

		List<UploadFile> li = jdbcTemplate.query(sql, new RowMapper<UploadFile>() {
			public UploadFile mapRow(ResultSet rs, int row) throws SQLException {

				UploadFile u = new UploadFile();
				u.setFileName(rs.getString("file_name"));
				u.setData(rs.getBytes("file_data"));

				return u;
			}
		});

		return li;
	}

	@Override
	public Blob get_user_image(int id) {

		String query = "select image from user where id_user=?";

		Blob photo = jdbcTemplate.queryForObject(query, new Object[] { id }, Blob.class);

		return photo;
	}

	@Override
	public int[] delete_user(int id) {

		String[] sqlArray = { "DELETE FROM user WHERE id_user =" + id, "DELETE FROM credential WHERE id_user =" + id, };

		int[] updateCounts = jdbcTemplate.batchUpdate(sqlArray);

		return updateCounts;
	}

	@Override
	public int update_credential(Credential c) {

		Date dt = new Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(dt);

		// insert
		String sql = "UPDATE credential SET datetime ='" + currentTime + "',username='" + c.getUsername()
				+ "', password='" + c.getPassword() + "' WHERE id_user=" + c.getId_user() + "";
		int i = jdbcTemplate.update(sql);

		return i;

	}

	@Override
	public int insert_main_category(Maincategory m) {

		String slug = m.getTitle();
		slug = slug.toLowerCase();
		slug = slug.replace(" ", "");
		m.setSlug(slug);

		Date dt = new Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(dt);

		// insert
		String sql = "INSERT INTO maincategory (id_user, title, active, priority, con,slug) VALUES (?, ?, ?, ?, ?, ?)";
		int i = jdbcTemplate.update(sql, m.getId_user(), m.getTitle(), m.getActive(), m.getPriority(), currentTime,
				m.getSlug());

		return i;
	}

	@Override
	public List<Maincategory> list_maincategory() {

		String sql = "select b.id_mc,b.id_user,b.title,b.slug,b.priority,b.active,b.con,(select count(a.id_mc) from subcategory a where a.id_mc = b.id_mc) as countsc from maincategory b;";

		List<Maincategory> li = jdbcTemplate.query(sql, new RowMapper<Maincategory>() {
			public Maincategory mapRow(ResultSet rs, int row) throws SQLException {

				Maincategory m = new Maincategory();

				m.setId_mc(rs.getInt("id_mc"));
				m.setId_user(rs.getInt("id_user"));
				m.setTitle(rs.getString("title"));
				m.setActive(rs.getInt("active"));
				m.setCon(rs.getString("con"));
				m.setPriority(rs.getInt("priority"));
				m.setCountsc(rs.getInt("countsc"));
				m.setSlug(rs.getString("slug"));

				return m;
			}
		});

		return li;
	}

	@Override
	public int insert_sub_category(Subcategory s) {

		String slug = s.getTitle();
		slug = slug.toLowerCase();
		slug = slug.replace(" ", "");
		s.setSlug(slug);

		Date dt = new Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(dt);

		// insert
		String sql = "INSERT INTO subcategory (id_mc, id_user, title, active, priority, con, slug) VALUES (?, ?, ?, ?, ?, ?, ?)";
		int i = jdbcTemplate.update(sql, s.getId_mc(), s.getId_user(), s.getTitle(), s.getActive(), s.getPriority(),
				currentTime, s.getSlug());

		return i;
	}

	@Override
	public int insert_blogentry(final Blogentry b) {
		Date dt = new Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		final String currentTime = sdf.format(dt);

		boolean bo;

		String query = "INSERT INTO blogentry (des, id_sc, id_user, title, con, body, active, id_userliked, cover) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

		System.out.println(b.getDesc());
		bo = jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

				ps.setString(1, b.getDesc());
				ps.setInt(2, b.getId_sc());
				ps.setInt(3, b.getId_user());
				ps.setString(4, b.getTitle());
				ps.setString(5, currentTime);
				ps.setString(6, b.getBody());
				ps.setInt(7, b.getActive());
				ps.setInt(8, b.getId_userliked());
				ps.setBytes(9, b.getCover());

				return ps.execute();

			}
		});

		// insert
//		String sql = "INSERT INTO blogentry (desc, id_sc, id_user, title, con, body, active, id_userliked, cover) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
//		int i = jdbcTemplate.update(sql,b.getDesc(),b.getId_sc(), b.getId_user(), b.getTitle(), currentTime, b.getBody(),b.getActive(),b.getId_userliked(),b.getCover());
//
		return 0;

	}

	@Override
	public List<Subcategory> list_subcategory(int id) {

		String sql = "select id_mc,id_sc,id_user,title,active,priority,con,slug,(select count(b.id_sc) from blogentry b where b.id_sc=a.id_sc) as blogs from subcategory a where a.id_mc="
				+ id + "";

		List<Subcategory> li = jdbcTemplate.query(sql, new RowMapper<Subcategory>() {
			public Subcategory mapRow(ResultSet rs, int row) throws SQLException {

				Subcategory s = new Subcategory();

				s.setId_sc(rs.getInt("id_sc"));
				s.setId_user(rs.getInt("id_user"));
				s.setTitle(rs.getString("title"));
				s.setActive(rs.getInt("active"));
				s.setCon(rs.getString("con"));
				s.setPriority(rs.getInt("priority"));
				s.setId_mc(rs.getInt("id_mc"));
				s.setBlogs(rs.getInt("blogs"));
				s.setSlug(rs.getString("slug"));

				return s;
			}
		});

		return li;

	}

	@Override
	public int[] delete_subcategory(int id) {

		String[] sqlArray = { "DELETE FROM subcategory WHERE id_sc =" + id, };

		int[] updateCounts = jdbcTemplate.batchUpdate(sqlArray);

		return updateCounts;

	}

	@Override
	public int[] delete_maincategory(int id) {

		String[] sqlArray = { "DELETE FROM maincategory WHERE id_mc =" + id, };

		int[] updateCounts = jdbcTemplate.batchUpdate(sqlArray);

		return updateCounts;

	}

	@Override
	public List<Blogentry> list_blog(int id) {

		String sql = "SELECT a.id_be,a.id_sc,a.id_user,a.title,a.con,a.body,a.active,a.id_userliked,a.cover,a.priority,a.des,(SELECT slug FROM subcategory b WHERE b.id_sc = a.id_sc) as sc_slug from blogentry a where a.id_sc="
				+ id + "";

		List<Blogentry> li = jdbcTemplate.query(sql, new RowMapper<Blogentry>() {
			public Blogentry mapRow(ResultSet rs, int row) throws SQLException {

				Blogentry s = new Blogentry();
				s.setId_be(rs.getInt("id_be"));
				s.setId_sc(rs.getInt("id_sc"));
				s.setId_user(rs.getInt("id_user"));
				s.setTitle(rs.getString("title"));
				s.setActive(rs.getInt("active"));
				s.setCon(rs.getString("con"));
				s.setBody(rs.getString("body"));
				s.setId_userliked(rs.getInt("id_userliked"));
				s.setPriority(rs.getInt("priority"));
				s.setDesc(rs.getString("des"));
				s.setSc_slug(rs.getString("sc_slug"));

				String sDate1 = s.getCon();

				try {
					DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					Date today;
					today = format.parse(sDate1);

					DateFormat year = new SimpleDateFormat("yyyy");
					DateFormat day = new SimpleDateFormat("dd");
					SimpleDateFormat f = new SimpleDateFormat("MMM");

					s.setMonth(f.format(today));
					s.setDay(day.format(today));
					s.setYear(year.format(today));

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return s;
			}
		});

		return li;

	}

	@Override
	public int[] delete_blogentry(int id_be) {

		String[] sqlArray = { "DELETE FROM blogentry WHERE id_be =" + id_be, };

		int[] updateCounts = jdbcTemplate.batchUpdate(sqlArray);

		return updateCounts;

	}

	@Override
	public List<Blogentry> list_blog_toedit(int id_be) {

		String sql = "SELECT  a.id_be,a.id_sc,a.id_user,a.title,a.con,a.body,a.active,a.id_userliked,a.des,c.title AS mc_title,c.slug AS mc_slug FROM blogentry a JOIN subcategory b ON a.id_sc =b.id_sc JOIN maincategory c ON b.id_mc =c.id_mc where a.id_be="
				+ id_be + "";

		List<Blogentry> li = jdbcTemplate.query(sql, new RowMapper<Blogentry>() {
			public Blogentry mapRow(ResultSet rs, int row) throws SQLException {

				Blogentry s = new Blogentry();
				s.setId_be(rs.getInt("id_be"));
				s.setId_sc(rs.getInt("id_sc"));
				s.setId_user(rs.getInt("id_user"));
				s.setTitle(rs.getString("title"));
				s.setActive(rs.getInt("active"));
				s.setCon(rs.getString("con"));
				s.setBody(rs.getString("body"));
				s.setId_userliked(rs.getInt("id_userliked"));
				s.setDesc(rs.getString("des"));
				s.setMc_title(rs.getString("mc_title"));
				s.setMc_slug(rs.getString("mc_slug"));
				
				String sDate1 = s.getCon();

				try {
					DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					Date today;
					today = format.parse(sDate1);

					DateFormat year = new SimpleDateFormat("yyyy");
					DateFormat day = new SimpleDateFormat("dd");
					SimpleDateFormat f = new SimpleDateFormat("MMM");

					s.setMonth(f.format(today));
					s.setDay(day.format(today));
					s.setYear(year.format(today));

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

				return s;
			}
		});

		return li;

	}

	@Override
	public int update_blogentry(Blogentry b) {
		Date dt = new Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(dt);

		String sql = "UPDATE  blogentry SET title=?,con=?,body=?,cover=?,des=? WHERE id_be=?";
		int i = jdbcTemplate.update(sql, b.getTitle(), currentTime, b.getBody(), b.getCover(), b.getDesc(),
				b.getId_be());
		// String sql="update blogentry set title
		// ='"+b.getTitle()+"',con='"+currentTime+"',body="+b.getBody()+",cover="+b.getCover()+"
		// where id_be="+b.getId_be()+"";
		// return jdbcTemplate.update(sql);
		return i;

	}

	@Override
	public int maincategory_slug_check(String s) {

		String sql = "select id_mc from maincategory where slug='" + s + "'";

		List<Maincategory> li = jdbcTemplate.query(sql, new RowMapper<Maincategory>() {
			public Maincategory mapRow(ResultSet rs, int row) throws SQLException {

				Maincategory m = new Maincategory();
				m.setId_mc(rs.getInt(1));
				return m;
			}
		});

		Iterator<Maincategory> it = li.iterator();
		while (it.hasNext()) {
			Maincategory c = (Maincategory) it.next();

			System.out.println(c.getId_mc() + "-------------get id mc list");
			return c.getId_mc();

		}

		return 0;
	}

	@Override
	public List<Menu> list_menu(int id) {

		String sql = "select id_mc,id_sc,id_user,title,active,priority,con,slug,(select count(b.id_sc) from blogentry b where b.id_sc=a.id_sc) as blogs,(SELECT slug FROM maincategory b \n"
				+ "WHERE b.id_mc=a.id_mc) AS mc_slug from subcategory a where a.id_mc=" + id + "";

		List<Menu> li = jdbcTemplate.query(sql, new RowMapper<Menu>() {
			public Menu mapRow(ResultSet rs, int row) throws SQLException {

				Menu s = new Menu();

				s.setId_sc(rs.getInt("id_sc"));
				s.setId_user(rs.getInt("id_user"));
				s.setTitle(rs.getString("title"));
				s.setActive(rs.getInt("active"));
				s.setCon(rs.getString("con"));
				s.setPriority(rs.getInt("priority"));
				s.setId_mc(rs.getInt("id_mc"));
				s.setBlogs(rs.getInt("blogs"));
				s.setSlug(rs.getString("slug"));
				s.setMc_slug(rs.getString("mc_slug"));
				s.setPost(list_blog(s.getId_sc()));

				return s;
			}
		});

		return li;

	}

	@Override
	public int blog_check(String s) {

		String sql = "select id_be from blogentry where id_be='" + s + "'";

		List<Blogentry> li = jdbcTemplate.query(sql, new RowMapper<Blogentry>() {
			public Blogentry mapRow(ResultSet rs, int row) throws SQLException {

				Blogentry m = new Blogentry();
				m.setId_be(rs.getInt(1));
				return m;
			}
		});

		Iterator<Blogentry> it = li.iterator();
		while (it.hasNext()) {
			Blogentry c = (Blogentry) it.next();

			return c.getId_be();

		}

		return 0;
	}

	@Override
	public Blob get_thumb_image(int id) {

		String query = "select cover from blogentry where id_be=?";

		Blob photo = jdbcTemplate.queryForObject(query, new Object[] { id }, Blob.class);

		return photo;
	}

	@Override
	public int update_mc_priority(int id, String value) {

		String sql = "UPDATE maincategory SET priority=? where id_mc=?";

		return jdbcTemplate.update(sql, value, id);
	}

	@Override
	public int update_sc_priority(int id, String value) {

		String sql = "UPDATE subcategory SET priority=? where id_sc=?";

		return jdbcTemplate.update(sql, value, id);
	}

	@Override
	public List<Blogentry> list_blog_mc(int id) {

		String sql = "SELECT b.id_be,b.id_sc,b.id_user,b.title,b.con,b.body,b.active,b.id_userliked,b.cover,b.priority,b.des,(SELECT slug FROM subcategory sc WHERE sc.id_sc = b.id_sc) as sc_slug from blogentry b where b.id_sc in (SELECT id_sc FROM subcategory s WHERE s.id_mc="
				+ id + ")";

		List<Blogentry> li = jdbcTemplate.query(sql, new RowMapper<Blogentry>() {
			public Blogentry mapRow(ResultSet rs, int row) throws SQLException {

				Blogentry s = new Blogentry();
				s.setId_be(rs.getInt("id_be"));
				s.setId_sc(rs.getInt("id_sc"));
				s.setId_user(rs.getInt("id_user"));
				s.setTitle(rs.getString("title"));
				s.setActive(rs.getInt("active"));
				s.setCon(rs.getString("con"));
				s.setBody(rs.getString("body"));
				s.setId_userliked(rs.getInt("id_userliked"));
				s.setPriority(rs.getInt("priority"));
				s.setDesc(rs.getString("des"));
				s.setSc_slug(rs.getString("sc_slug"));

				String sDate1 = s.getCon();

				try {
					DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					Date today;
					today = format.parse(sDate1);

					DateFormat year = new SimpleDateFormat("yyyy");
					DateFormat day = new SimpleDateFormat("dd");
					SimpleDateFormat f = new SimpleDateFormat("MMM");

					s.setMonth(f.format(today));
					s.setDay(day.format(today));
					s.setYear(year.format(today));

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return s;
			}
		});

		return li;

	}

	@Override
	public int sc_check(String s) {

		String sql = "select id_sc from subcategory where slug='" + s + "'";

		List<Subcategory> li = jdbcTemplate.query(sql, new RowMapper<Subcategory>() {
			public Subcategory mapRow(ResultSet rs, int row) throws SQLException {

				Subcategory m = new Subcategory();
				m.setId_sc(rs.getInt(1));
				return m;
			}
		});

		Iterator<Subcategory> it = li.iterator();
		while (it.hasNext()) {
			Subcategory c = (Subcategory) it.next();

			return c.getId_sc();

		}

		return 0;
	}

	@Override
	public List<Blogentry> list_blog_recent() {

		String sql = "SELECT  a.id_be,a.id_sc,a.id_user,a.title,a.con,a.body,a.active,a.id_userliked,a.des,c.title AS mc_title,c.slug AS mc_slug ,b.slug AS sc_slug FROM blogentry a JOIN subcategory b ON a.id_sc =b.id_sc JOIN maincategory c ON b.id_mc =c.id_mc  ORDER BY a.id_be DESC";
		List<Blogentry> li = jdbcTemplate.query(sql, new RowMapper<Blogentry>() {
			public Blogentry mapRow(ResultSet rs, int row) throws SQLException {

				Blogentry s = new Blogentry();
			
				s.setId_be(rs.getInt("id_be"));
				s.setTitle(rs.getString("title"));
				s.setCon(rs.getString("con"));
				s.setDesc(rs.getString("des"));
				s.setMc_slug(rs.getString("mc_slug"));
				s.setSc_slug(rs.getString("sc_slug"));

				String sDate1 = s.getCon();

				try {
					DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					Date today;
					today = format.parse(sDate1);

					DateFormat year = new SimpleDateFormat("yyyy");
					DateFormat day = new SimpleDateFormat("dd");
					SimpleDateFormat f = new SimpleDateFormat("MMM");

					s.setMonth(f.format(today));
					s.setDay(day.format(today));
					s.setYear(year.format(today));

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return s;
			}
		});

		return li;

	}

	@Override
	public int update_be_priority(int id, String value) {

		String sql = "UPDATE blogentry SET priority=? where id_be=?";

		return jdbcTemplate.update(sql, value, id);
	}

	@Override
	public List<Blogentry> list_blog_default(int id) {


		String sql = "SELECT b.id_be,b.id_sc,b.id_user,b.title,b.con,b.body,b.active,b.id_userliked,b.cover,b.priority,b.des,(SELECT slug FROM subcategory sc WHERE sc.id_sc = b.id_sc AND sc.priority=1) AS sc_slug FROM blogentry b WHERE b.priority=1 AND b.id_sc IN (SELECT id_sc FROM subcategory s WHERE s.priority=1 AND s.id_mc ="
				+ id + ")";

		List<Blogentry> li = jdbcTemplate.query(sql, new RowMapper<Blogentry>() {
			public Blogentry mapRow(ResultSet rs, int row) throws SQLException {

				Blogentry s = new Blogentry();
				s.setId_be(rs.getInt("id_be"));
				s.setId_sc(rs.getInt("id_sc"));
				s.setId_user(rs.getInt("id_user"));
				s.setTitle(rs.getString("title"));
				s.setActive(rs.getInt("active"));
				s.setCon(rs.getString("con"));
				s.setBody(rs.getString("body"));
				s.setId_userliked(rs.getInt("id_userliked"));
				s.setPriority(rs.getInt("priority"));
				s.setDesc(rs.getString("des"));
				s.setSc_slug(rs.getString("sc_slug"));

				String sDate1 = s.getCon();

				try {
					DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					Date today;
					today = format.parse(sDate1);

					DateFormat year = new SimpleDateFormat("yyyy");
					DateFormat day = new SimpleDateFormat("dd");
					SimpleDateFormat f = new SimpleDateFormat("MMM");

					s.setMonth(f.format(today));
					s.setDay(day.format(today));
					s.setYear(year.format(today));

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				return s;
			}
		});

		return li;

	
	}

	@Override
	public List<Defaultoption> list_defaultoption(String Key_code) {

		String sql = "SELECT key_code ,key_name,key_value,icon FROM defaultoption where key_code='"+Key_code+"'";

		List<Defaultoption> li = jdbcTemplate.query(sql, new RowMapper<Defaultoption>() {
			public Defaultoption mapRow(ResultSet rs, int row) throws SQLException {

				Defaultoption u = new Defaultoption();
				u.setKey_code(rs.getString("key_code"));
				u.setKey_name(rs.getString("key_name"));
				u.setKey_value(rs.getString("key_value"));
				u.setIcon(rs.getString("icon"));
			

				return u;
			}
		});

		return li;
	}

	@Override
	public List<Defaultoption> list_defaultoption() {


		String sql = "SELECT key_code ,key_name,key_value,icon FROM defaultoption";

		List<Defaultoption> li = jdbcTemplate.query(sql, new RowMapper<Defaultoption>() {
			public Defaultoption mapRow(ResultSet rs, int row) throws SQLException {

				Defaultoption u = new Defaultoption();
				u.setKey_code(rs.getString("key_code"));
				u.setKey_name(rs.getString("key_name"));
				u.setKey_value(rs.getString("key_value"));
				u.setIcon(rs.getString("icon"));
			

				return u;
			}
		});

		return li;
	
	}

	@Override
	public int insert_defaultoption(final Defaultoption d) {
	


		String query = "INSERT INTO defaultoption(key_code,key_name,key_value,icon) VALUES(?, ?, ?, ?)";

		boolean bo = jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {
			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

				ps.setString(1, d.getKey_code());
				ps.setString(2, d.getKey_name());
				ps.setString(3, d.getKey_value());
				ps.setString(4, d.getIcon());
	

				return ps.execute();

			}
		});

		// insert
//		String sql = "INSERT INTO blogentry (desc, id_sc, id_user, title, con, body, active, id_userliked, cover) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
//		int i = jdbcTemplate.update(sql,b.getDesc(),b.getId_sc(), b.getId_user(), b.getTitle(), currentTime, b.getBody(),b.getActive(),b.getId_userliked(),b.getCover());
//
		return 0;

	}

	@Override
	public int[] delete_defaultoption(String id) {

		String[] sqlArray = { "DELETE FROM defaultoption WHERE  key_name ='" + id+"'" };

		int[] updateCounts = jdbcTemplate.batchUpdate(sqlArray);

		return updateCounts;

	}


}
