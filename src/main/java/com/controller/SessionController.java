package com.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.LoginBean;
import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class SessionController {
	
	@Autowired
	UserDao userDao;
	
	@GetMapping("/signup")
	public String signup(UserBean user,Model model) {
		model.addAttribute("user", user);
		return "Signup";
	}
	
	@PostMapping("/saveuser")
	public String saveUser(@ModelAttribute("user") @Valid UserBean user,BindingResult result, Model model) {
		System.out.println(result);
		if (result.hasErrors()) { // true or false
			model.addAttribute("user", user);
			
			return "Signup";
		} else {
			user.setUserType("customer");
			userDao.addUser(user);
			model.addAttribute("msg","Signup done..");
			return "Login";
		}
	}

	@GetMapping("/login")
	public String login() {
		return "Login";
	}
	
	@PostMapping("/login")
	public String authenticate(LoginBean login,Model model,HttpSession session) {
		
		UserBean user = userDao.authenticate(login);
		System.out.println(user);
		if(user == null) {
			model.addAttribute("msg", "InvalidCredentials");
			return "Login";
		}else if (user.getUserType().equals("customer")) {
			session.setAttribute("user", user);
			return "Home";
		} else if (user.getUserType().equals("admin")) {
			session.setAttribute("user", user);
			return "Dashboard";
		} else {
			model.addAttribute("msg", "Please Contact Admin");
			return "Login";
		}
	}
	
	@GetMapping("/logout")
	public String logout (HttpSession session) {
		session.invalidate();
		return "Login";
	}

}
