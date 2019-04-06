package com.mahesh.Model;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class User {

	// @Size(min = 2, message = "Mobile is required")
	private String mobile;
	// @Size(min = 2, message = "Address is required")
	private String address;
	 @Size(min = 2, message = "username is required")
	private String userName;
	 @Size(min = 2, message = "password is required")
	private String passWord;
	// @Size(min = 2, message = "Designation is required")
	private String designation;
	// @Min(value = 2, message = "adminOrUser is required")
	private int adminOruser;
	// @Min(value = 2, message = "id is required minimum 2 size")
	private int id;
	private boolean aprv;

	public boolean getAprv() {
		return aprv;
	}

	public void setAprv(boolean aprv) {
		this.aprv = aprv;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getAdminOruser() {
		return adminOruser;
	}

	public void setAdminOruser(int adminOruser) {
		this.adminOruser = adminOruser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User(long mob, String mobile, String address, String userName, String passWord, String designation,
			int adminOruser, int id, boolean aprv) {
		super();
		this.mobile = mobile;
		this.address = address;
		this.userName = userName;
		this.passWord = passWord;
		this.designation = designation;
		this.adminOruser = adminOruser;
		this.id = id;
		this.aprv = aprv;
	}

	@Override
	public String toString() {
		return "User [mobile=" + mobile + ", address=" + address + ", userName=" + userName + ", passWord=" + passWord
				+ ", designation=" + designation + ", adminOruser=" + adminOruser + ", id=" + id + ", aprv=" + aprv
				+ "]";
	}

}
