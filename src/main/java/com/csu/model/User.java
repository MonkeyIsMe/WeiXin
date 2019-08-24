package com.csu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.JSONObject;

@Entity
@Table(name="tab_user")
public class User {
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int UserId;
	
	@Column(name="user_number")
	private String UserNumber;
	
	@Column(name="user_phone")
	private String UserPhone;
	
	@Column(name="user_appid")
	private String UserAppid;
	
	@Column(name="user_role")
	private String UserRole;
	
	@Column(name="user_company")
	private String UserCompany;
	
	@Column(name="user_name")
	private String UserName;

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getUserNumber() {
		return UserNumber;
	}

	public void setUserNumber(String userNumber) {
		UserNumber = userNumber;
	}

	public String getUserPhone() {
		return UserPhone;
	}

	public void setUserPhone(String userPhone) {
		UserPhone = userPhone;
	}

	public String getUserAppid() {
		return UserAppid;
	}

	public void setUserAppid(String userAppid) {
		UserAppid = userAppid;
	}

	public String getUserRole() {
		return UserRole;
	}

	public void setUserRole(String userRole) {
		UserRole = userRole;
	}

	public String getUserCompany() {
		return UserCompany;
	}

	public void setUserCompany(String userCompany) {
		UserCompany = userCompany;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}
	
	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("UserId", this.UserId);
		jo.put("UserNumber", this.UserNumber);
		jo.put("UserPhone", this.UserPhone);
		jo.put("UserAppid", this.UserAppid);
		jo.put("UserRole", this.UserRole);
		jo.put("UserCompany", this.UserCompany);
		jo.put("UserName", this.UserName);
		return jo;
	}
	
	public String toString() {
		return this.toJSON().toString(); 
	}
	
}
