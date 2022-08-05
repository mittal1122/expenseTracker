package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.AccountBean;
import com.bean.ExpenseBean;
import com.bean.UserBean;
import com.dao.ExpenceDao;

@Controller
public class ExpenceController {

	@Autowired
	ExpenceDao expDao;

	@GetMapping("/expense")
	public String getExpence(HttpSession session, Model model, @ModelAttribute("expenseBean") ExpenseBean expenseBean) {
		UserBean user = (UserBean) session.getAttribute("user");
		model.addAttribute("expenseBean", expenseBean);
		if (user == null) {
			return "Login";
		} else {

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			System.out.println("dtf : " + dtf.format(now));

			String s = dtf.format(now);
			String date = s.substring(0, 10);
			String time = s.substring(11, 19);
			expenseBean.setExp_date(date);
			expenseBean.setExp_time(time);
			int userId = user.getUserId();
			List<ExpenseBean> category = expDao.getcategory(userId);
			System.out.println("category List ::" + category);
			model.addAttribute("category", category);
			List<ExpenseBean> AccountType = expDao.getAccountType(userId);
			model.addAttribute("AccountType", AccountType);
			model.addAttribute("expenseBean", expenseBean);
			return "AddExpense";
		}

	}

	@PostMapping("/expense")
	public String addExpence(HttpSession session, Model model,
			@ModelAttribute("expenseBean") @Valid ExpenseBean expenseBean, BindingResult result) {
		UserBean user = (UserBean) session.getAttribute("user");

		if (user == null) {
			return "Login";
		} else {
			if (result.hasErrors()) {
				model.addAttribute("expenseBean", expenseBean);
				return "AddExpense";
			} else {
				try {
				int userId = user.getUserId();
				expenseBean.setUserid(userId);
				AccountBean newbalance = expDao.getBalance(expenseBean);
				Integer exp_amount = expenseBean.getExp_amount();
				Integer newBalence = (newbalance.getNewbalance() - exp_amount);
				List<ExpenseBean> expenseList = expDao.addExpence(expenseBean, newBalence);

				System.out.println("expenseList :: addExpense  : "+expenseList.get(0).getAcc_name());
				
				System.out.println("getAcc_name :: addExpense  : "+expenseList.get(0).getAcc_name());
				System.out.println("getAcc_type :: addExpense  : "+expenseList.get(0).getAcc_type());
				System.out.println("getCat_name :: addExpense  : "+expenseList.get(0).getCat_name());
				System.out.println("getExp_date :: addExpense  : "+expenseList.get(0).getExp_date());
				System.out.println("getExp_loc :: addExpense  : "+expenseList.get(0).getExp_loc());
				System.out.println("getExp_name :: addExpense  : "+expenseList.get(0).getExp_name());
				System.out.println("getExp_time :: addExpense  : "+expenseList.get(0).getExp_time());
				System.out.println("getSubcat_name :: addExpense  : "+expenseList.get(0).getSubcat_name());
				System.out.println("getNewbalanse :: addExpense  : "+expenseList.get(0).getNewbalance());
				System.out.println("getAcc_balance :: addExpense  : "+expenseList.get(0).getAcc_balance());
//				System.out.println("getCatid :: addExpense  : "+expenseList.get(0).getCatid());
				System.out.println("getExp_amount :: addExpense  : "+expenseList.get(0).getExp_amount());
				System.out.println("getExpenseid :: addExpense  : "+expenseList.get(0).getExpenseid());
//				System.out.println("getSubcatid :: addExpense  : "+expenseList.get(0).getSubcatid());
//				System.out.println("getUserid :: addExpense  : "+expenseList.get(0).getUserid());
			
				
				System.out.println("newbalance :: addExpense(AccountBean)  : "+newbalance);
				
				FileOutputStream f;
				
					f = new FileOutputStream("Statement.txt");
				  
				  ObjectOutputStream oos =new  ObjectOutputStream(f);
				System.out.println(expenseList);
				  oos.writeObject(expenseList); 
				  oos.writeObject(expenseList);
				  oos.close();
				  
				  
				  //reading
				  FileInputStream fileIn = new FileInputStream("Statement.txt");
				  ObjectInputStream ois = new ObjectInputStream(fileIn);
				  ArrayList<ExpenseBean> e2 = (ArrayList<ExpenseBean>) ois.readObject();
				  ois.close();
				  
				  System.out.println("ArrayList<ExpenseBean>  : "+e2);
				 
				 
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  
				 
				

				return "redirect:/expense";
			}

		}

	}

	private ObjectOutputStream ObjectOutputStream(FileOutputStream fileOutputStream) {
	
		return null;
	}

	@GetMapping("/expenselist")
	public String expenceList(HttpSession session, Model model, ExpenseBean expenseBean) {
		UserBean user = (UserBean) session.getAttribute("user");
		if (user == null) {
			return "Login";
		} else {

			int userId = user.getUserId();
			List<ExpenseBean> expenseList = expDao.expenseList(userId);
			System.out.println("expenseList List ::" + expenseList);
			model.addAttribute("expenseList", expenseList);

			return "ExpenseList";
		}

	}

	@GetMapping("/viewexpense")
	public String expenceadminList(@RequestParam("userid") int userId, Model model, ExpenseBean expenseBean) {

		List<ExpenseBean> expenseList = expDao.expenseList(userId);
		System.out.println("expenseList List ::" + expenseList);
		model.addAttribute("expenseList", expenseList);

		return "ExpenseList";
	}

}
