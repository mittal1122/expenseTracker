package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.AccountBean;
import com.bean.AccountType;

@Repository
public class AccountDao {

	@Autowired
	JdbcTemplate stmt;

	public void addAccount(AccountBean accBean) {
		stmt.update("insert into accounts (acc_name,acc_no,accounttypeid,acc_balance,userid) values(?,?,?,?,?)",
				accBean.getAcc_name(), accBean.getAcc_no(), accBean.getAccounttypeid(), accBean.getAcc_balance(),
				accBean.getUserid());
	}

	public List<AccountType> getData(int userId) {

		List<AccountType> accountType = stmt.query("select * from accounttypes where userid = ?",
				new BeanPropertyRowMapper<AccountType>(AccountType.class), new Object[] { userId });

		return accountType;
	}
	public List<AccountBean> getaccountsByTypeId(int accounttypeid, int userId) {
		List<AccountBean> account = stmt.query("select * from accounts where accounttypeid = ? and userid = ?", new BeanPropertyRowMapper<AccountBean>(AccountBean.class),new Object[] {accounttypeid,userId});
		return account;
	}
}
