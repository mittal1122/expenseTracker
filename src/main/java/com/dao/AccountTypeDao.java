package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.AccountType;

@Repository
public class AccountTypeDao {

	@Autowired
	JdbcTemplate stmt;
	
	public void addaccountType(AccountType accoutTypeBean) {
		
		stmt.update("insert into accounttypes (acc_type,userid) values(?,?)",accoutTypeBean.getAcc_type(),accoutTypeBean.getUserid());
		
	}
}
