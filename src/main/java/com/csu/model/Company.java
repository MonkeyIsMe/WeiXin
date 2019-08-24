package com.csu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.JSONObject;

@Entity
@Table(name="tab_company")
public class Company {
	
	@Id
	@Column(name="company_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CompanyId;
	
	@Column(name="company_name")
	private String CompanyName;
	
	@Column(name="conpany_info")
	private String CompanyInfo;

	public int getCompanyId() {
		return CompanyId;
	}

	public void setCompanyId(int companyId) {
		CompanyId = companyId;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public String getCompanyInfo() {
		return CompanyInfo;
	}

	public void setCompanyInfo(String companyInfo) {
		CompanyInfo = companyInfo;
	}
	
	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("CompanyId", this.CompanyId);
		jo.put("CompanyName", this.CompanyName);
		jo.put("CompanyInfo", this.CompanyInfo);
		return jo;
	}
	
	public String toString() {
		return this.toJSON().toString(); 
	}
	
}
