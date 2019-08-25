package com.csu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.JSONObject;

@Entity
@Table(name="tab_role")
public class Role {
	
	@Id
	@Column(name="role_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleId;
	
	@Column(name="role_name")
	private String roleName;
	
	@Column(name="role_info")
	private String roleInfo;


	
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleInfo() {
		return roleInfo;
	}

	public void setRoleInfo(String roleInfo) {
		this.roleInfo = roleInfo;
	}

	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("roleId", this.roleId);
		jo.put("roleName", this.roleName);
		jo.put("roleInfo", this.roleInfo);
		return jo;
	}
	
	public String toString() {
		return this.toJSON().toString(); 
	}
	
}
