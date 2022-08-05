package com.bean;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class AccountBean implements Serializable {
	private Integer accountid;
	@NotBlank(message = "Enter Account Name")
	private String acc_name;
	@NotNull(message = "Enter Account Number")
	private Long acc_no;
	@NotNull(message = "Add Payment Mode")
	private Integer accounttypeid;
	@NotNull(message = "Enter Account Balance")
	@Min(message = "Plese Enter valid Ammount", value = 1)
	private Integer acc_balance;
	private Integer userid;
	private Integer newbalance;

	public Integer getNewbalance() {
		return newbalance;
	}

	public void setNewbalance(Integer newbalance) {
		this.newbalance = newbalance;
	}

	public Integer getAccountid() {
		return accountid;
	}

	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}

	public String getAcc_name() {
		return acc_name;
	}

	public void setAcc_name(String acc_name) {
		this.acc_name = acc_name;
	}

	public Long getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(Long acc_no) {
		this.acc_no = acc_no;
	}

	public Integer getAccounttypeid() {
		return accounttypeid;
	}

	public void setAccounttypeid(Integer accounttypeid) {
		this.accounttypeid = accounttypeid;
	}

	public Integer getAcc_balance() {
		return acc_balance;
	}

	public void setAcc_balance(Integer acc_balance) {
		this.acc_balance = acc_balance;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		
		return this.newbalance+" ";
	}
}
