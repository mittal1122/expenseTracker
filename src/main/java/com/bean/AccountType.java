package com.bean;

import org.hibernate.validator.constraints.NotBlank;

public class AccountType {

	private Integer accounttypeid;
	@NotBlank (message = "Plese Enter Payment Mode")
	private String acc_type;
	private Integer userid;
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getAccounttypeid() {
		return accounttypeid;
	}
	public void setAccounttypeid(Integer accounttypeid) {
		this.accounttypeid = accounttypeid;
	}
	public String getAcc_type() {
		return acc_type;
	}
	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}
}
