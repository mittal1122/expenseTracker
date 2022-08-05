package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class UserController {

	
	@Autowired
	UserDao userdao;
	
	@GetMapping("/userlist")
	public String userList(Model model){
		List<UserBean> user = userdao.getAllUsers();
		model.addAttribute("user",user);
		return "UserList";
	}
	
	@GetMapping("/deleteuser")
	public String deleteUser(@RequestParam("userid") int userId,Model model){
		 userdao.deleteUser(userId);
		
		return "redirect:/userlist";
	}
	
}
