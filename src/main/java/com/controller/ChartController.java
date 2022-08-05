package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bean.ExpenseBean;
import com.bean.UserBean;
import com.dao.ExpenceDao;

@Controller
public class ChartController {

	@Autowired
	ExpenceDao expenseDao;

	@GetMapping("/mycharts")
	public String myChart(Model model,HttpSession session) {
		UserBean user=(UserBean) session.getAttribute("user");
		int userId = user.getUserId();
		List<ExpenseBean> expense = expenseDao.getExpenseByCategory(userId);
		model.addAttribute("expense", expense);//name , totalprice 
		return "MyChart";
	}
}
