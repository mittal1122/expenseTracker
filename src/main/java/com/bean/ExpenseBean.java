package com.bean;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class ExpenseBean implements Serializable{

	private Integer expenseid;
	@NotBlank (message = "Plese Enter Name")
	private String exp_name;
	public Integer getExpenseid() {
		return expenseid;
	}
	public void setExpenseid(Integer expenseid) {
		this.expenseid = expenseid;
	}
	public String getExp_name() {
		return exp_name;
	}
	public void setExp_name(String exp_name) {
		this.exp_name = exp_name;
	}
	public String getExp_loc() {
		return exp_loc;
	}
	public void setExp_loc(String exp_loc) {
		this.exp_loc = exp_loc;
	}
	public Integer getExp_amount() {
		return exp_amount;
	}
	public void setExp_amount(Integer exp_amount) {
		this.exp_amount = exp_amount;
	}
	public String getExp_date() {
		return exp_date;
	}
	public void setExp_date(String exp_date) {
		this.exp_date = exp_date;
	}
	public String getExp_time() {
		return exp_time;
	}
	public void setExp_time(String exp_time) {
		this.exp_time = exp_time;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getCatid() {
		return catid;
	}
	public void setCatid(Integer catid) {
		this.catid = catid;
	}
	public Integer getSubcatid() {
		return subcatid;
	}
	public void setSubcatid(Integer subcatid) {
		this.subcatid = subcatid;
	}
	public Integer getAccountid() {
		return accountid;
	}
	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}
	@NotBlank (message = "Please Enter the Location Where you purchase ")
	private String exp_loc;
	@NotNull (message = "Plese Enter Ammount")
	private Integer exp_amount;
	private String exp_date;
	private String exp_time;
	private Integer userid;
	@NotNull (message = "Plese select Category")
	private Integer catid;
	private String cat_name;
	private String subcat_name;
	public String getSubcat_name() {
		return subcat_name;
	}
	public void setSubcat_name(String subcat_name) {
		this.subcat_name = subcat_name;
	}
	public String getCat_name() {
		return cat_name;
	}
	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}
	public String getAcc_type() {
		return acc_type;
	}
	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}
	@NotNull (message = "Plese select Subcategory")
	private Integer subcatid;
	@NotNull (message = "Plese select Accunt")
	private Integer accountid;
	@NotNull (message = "Plese select Payment Mode")
	private Integer accountTypeid;
	private String acc_type;
	private String acc_name;
	private Integer newbalance;
	private Integer acc_balance;
	public Integer getAcc_balance() {
		return acc_balance;
	}
	public void setAcc_balance(Integer acc_balance) {
		this.acc_balance = acc_balance;
	}
	
	public Integer getNewbalance() {
		return newbalance;
	}
	public void setNewbalance(Integer newbalance) {
		this.newbalance = newbalance;
	}
	public String getAcc_name() {
		return acc_name;
	}
	public void setAcc_name(String acc_name) {
		this.acc_name = acc_name;
	}
	public Integer getAccountTypeid() {
		return accountTypeid;
	}
	public void setAccountTypeid(Integer accountTypeid) {
		this.accountTypeid = accountTypeid;
	}
	
	@Override
	public String toString() {
		
		return this.expenseid +" " +this.acc_name+" "+this.acc_type+" "+this.acc_balance+" "+this.newbalance+" "+this.cat_name+" "+this.exp_date+this.exp_loc+" "+this.exp_name+" "+this.exp_time+" "+this.subcat_name+" "+this.exp_amount+" ";
	}
}
