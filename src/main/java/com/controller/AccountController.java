package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.AccountBean;
import com.bean.AccountType;
import com.bean.UserBean;
import com.dao.AccountDao;
import com.dao.AccountTypeDao;

@Controller
public class AccountController {

	@Autowired
	AccountDao accDao;

	@Autowired
	AccountTypeDao accTypeDao;

	@GetMapping("/accountType")
	public String accountType(AccountType accTypeBean, Model model) {
		model.addAttribute("accountType", accTypeBean);
		System.out.println("call...");
		return "AddAccountType";

	}

	@PostMapping("/accountType")
	public String addAccountType(HttpSession session, @ModelAttribute("accountType") @Valid AccountType accTypeBean,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("accountType", accTypeBean);
			return "AddAccountType";
		} else {
			UserBean user = (UserBean) session.getAttribute("user");
			int userId = user.getUserId();
			accTypeBean.setUserid(userId);
			accTypeDao.addaccountType(accTypeBean);
			return "redirect:/accountType";
		}
	}

	@GetMapping("/accounts")
	public String account(AccountBean account, Model model,HttpSession session) {
		model.addAttribute("account", account);
		
		UserBean user = (UserBean) session.getAttribute("user");
		if(user == null) {
			return "Login";
		}else {
			int userId = user.getUserId();
			List<AccountType>  accType = accDao.getData(userId);
			model.addAttribute("accType", accType);
			System.out.println("call...");
			return "AddAccount";
		}
		

	}

	@PostMapping("/accounts")
	public String addAccount(HttpSession session, @ModelAttribute("account") @Valid AccountBean accBean,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("account", accBean);
			return "AddAccount";
		} else {

			UserBean user = (UserBean) session.getAttribute("user");
			int userId = user.getUserId();
			accBean.setUserid(userId);
			accDao.addAccount(accBean);

			return "redirect:/accounts";
		}

	}
}
