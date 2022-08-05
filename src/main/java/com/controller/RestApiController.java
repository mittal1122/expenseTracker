package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bean.AccountBean;
import com.bean.ExpenseBean;
import com.bean.UserBean;
import com.dao.AccountDao;
import com.dao.ExpenceDao;

@RestController
public class RestApiController {

	@Autowired
	ExpenceDao expdao;

	@Autowired
	AccountDao accDao;

	@GetMapping("/subcategory")
	public List<ExpenseBean> subcategoryByCatid(@RequestParam("catid") int catid, HttpSession session) {
		System.out.println("catid" + catid);
		UserBean user = (UserBean) session.getAttribute("user");
		int userId = user.getUserId();
		List<ExpenseBean> subCategory = expdao.getSubcategoryByCatid(catid, userId);
		System.out.println("subCategory" + subCategory);
		return subCategory;

	}

	@GetMapping("/accountsbytype")
	public List<AccountBean> accountsByType(@RequestParam("accounttypeid") int accounttypeid, HttpSession session) {
		System.out.println("accounttypeid : Rest api : " + accounttypeid);
		UserBean user = (UserBean) session.getAttribute("user");
		int userId = user.getUserId();
		List<AccountBean> accounts = accDao.getaccountsByTypeId(accounttypeid, userId);
		System.out.println("accounts : Rest api : " + accounts);
		return accounts;

	}
}
