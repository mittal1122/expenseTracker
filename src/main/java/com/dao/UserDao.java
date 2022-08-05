package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.LoginBean;
import com.bean.UserBean;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate stmt;

	public void addUser(UserBean user) {
		stmt.update("insert into users(firstname,lastname,email,password,mobileNo,gender,usertype) values(?,?,?,?,?,?,?)",
				user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(),user.getMobileNo(), user.getGender(),
				user.getUserType());

	}

	public List<UserBean> getAllUsers() {
		List<UserBean> users = stmt.query("select * from users", new BeanPropertyRowMapper<UserBean>(UserBean.class));
		return users;

	}

	public void deleteUser(int userId) {
		stmt.update("delete from users where userid = ?", userId);

	}

	public UserBean getUserByUserId(int userId) {
		UserBean user = stmt.queryForObject("select * from where userid= ?",
				new BeanPropertyRowMapper<UserBean>(UserBean.class), new Object[] { userId });
		return user;
	}

	public void updateUser(UserBean user) {
		stmt.update("update users set firstname = ?, lastname = ?, wh");
	}

	public UserBean authenticate(LoginBean login) {
		UserBean user = null;
		System.out.println(login.getEmail());
		System.out.println(login.getPassword());
		try {
		user = stmt.queryForObject("select * from users where email = ? and password = ? ",
				new BeanPropertyRowMapper<UserBean>(UserBean.class),
				new Object[] { login.getEmail(), login.getPassword() });
		}catch(Exception e) {
			System.out.println("Invalid Email Password");
		}
		return user;
		}
}
