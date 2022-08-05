package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.AccountBean;
import com.bean.ExpenseBean;

@Repository
public class ExpenceDao {

	@Autowired
	JdbcTemplate stmt;

	public List<ExpenseBean> getcategory(int userId) {
		List<ExpenseBean> data = stmt.query("select * from categories where userid =? or userid = 3;",
				new BeanPropertyRowMapper<ExpenseBean>(ExpenseBean.class), new Object[] { userId });
		return data;
	}

	public List<ExpenseBean> getAccountType(int userId) {
		List<ExpenseBean> data = stmt.query("select a.accounttypeid,a.acc_type from accounttypes a where a.userid=?",
				new BeanPropertyRowMapper<ExpenseBean>(ExpenseBean.class), new Object[] { userId });
		return data;
	}

	public List<ExpenseBean> getSubcategoryByCatid(int catid,int userId) {
		List<ExpenseBean> subcategory = stmt.query("select * from subcategories s,categories c where s.userid=c.userid and s.userid = ? and s.catid =?",
				new BeanPropertyRowMapper<ExpenseBean>(ExpenseBean.class), new Object[] {userId, catid });
		return subcategory;

	}

	public List<ExpenseBean> addExpence(ExpenseBean expenseBean, Integer newBalence) {
		stmt.update(
				"insert into expense (exp_name,exp_loc,exp_amount,exp_date,exp_time,catid,subcatid,accountid,accounttypeid,userid) values(?,?,?,?,?,?,?,?,?,?)",
				expenseBean.getExp_name(), expenseBean.getExp_loc(), expenseBean.getExp_amount(),
				expenseBean.getExp_date(), expenseBean.getExp_time(), expenseBean.getCatid(), expenseBean.getSubcatid(),
				expenseBean.getAccountid(), expenseBean.getAccountTypeid(), expenseBean.getUserid());
		stmt.update("update  accounts set newbalance = ? where userid = ? and accountid = ? ", newBalence,
				expenseBean.getUserid(), expenseBean.getAccountid());
		List<ExpenseBean> expenseList = stmt.query(
				"SELECT   e.expenseid,e.exp_loc, e.exp_name, e.exp_amount,e.exp_date, e.exp_time, c.cat_name, a.acc_name,a.acc_balance,a.newbalance,a.acc_no, at.acc_type, s.subcat_name FROM expense e,accounts a,categories c,subcategories s,accounttypes at ,users u  where a.accountid=e.accountid and e.catid=c.catid and e.subcatid=s.subcatid and e.accounttypeid=at.accounttypeid and e.userid =u.userid=at.userid and u.userid = ? ORDER BY  e.expenseid DESC LIMIT 1",
				new BeanPropertyRowMapper<ExpenseBean>(ExpenseBean.class), new Object[] { expenseBean.getUserid() });
		return expenseList;
	}

	public AccountBean getBalance(ExpenseBean expenseBean) {
		AccountBean newbalance = stmt.queryForObject(
				"select newbalance from accounts where userid = ? and accountid = ?",
				new BeanPropertyRowMapper<AccountBean>(AccountBean.class),
				new Object[] { expenseBean.getUserid(), expenseBean.getAccountid() });
		return newbalance;

	}

	public List<ExpenseBean> expenseList(int userId) {
		List<ExpenseBean> expenseList = stmt.query(
				"select  e.expenseid,e.exp_loc, e.exp_name, e.exp_amount,e.exp_date, e.exp_time, c.cat_name, a.acc_name, a.acc_no, at.acc_type, s.subcat_name from categories c,accounts a,accounttypes at,expense e,subcategories s, users u where e.catid=c.catid and e.subcatid=s.subcatid and e.accountid=a.accountid and e.accounttypeid=at.accounttypeid and e.userid =u.userid=at.userid  and u.userid =  ? ",
				new BeanPropertyRowMapper<ExpenseBean>(ExpenseBean.class), new Object[] { userId });
		return expenseList;
	}
	
	
	public List<ExpenseBean> getExpenseByCategory(int userId) {
		List<ExpenseBean> expenseList = stmt.query("select e.exp_amount, c.cat_name from categories c,expense e where  c.catid = e.catid and e.userid=? group by e.catid",new BeanPropertyRowMapper<ExpenseBean>(ExpenseBean.class), new Object[] { userId });
		return expenseList;
		
	}

}
