package com.csu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.json.JSONObject;

@Entity
@Table(name="tab_plan")
public class Plan {
	
	@Id
	@Column(name="plan_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int PlanId;
	
	@Column(name="plan_info")
	private String PlanInfo;
	
	@Column(name="time_id")
	private int TimeId;
	
	@Column(name="plan_tittle")
	private String PlanTittle;

	@Column(name="company_name")
	private String CompanyName;
	
	public int getPlanId() {
		return PlanId;
	}

	public void setPlanId(int planId) {
		PlanId = planId;
	}

	public String getPlanInfo() {
		return PlanInfo;
	}

	public void setPlanInfo(String planInfo) {
		PlanInfo = planInfo;
	}

	public int getTimeId() {
		return TimeId;
	}

	public void setTimeId(int timeId) {
		TimeId = timeId;
	}

	public String getPlanTittle() {
		return PlanTittle;
	}

	public void setPlanTittle(String planTittle) {
		PlanTittle = planTittle;
	}
	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	
	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("PlanId", this.PlanId);
		jo.put("PlanInfo", this.PlanInfo);
		jo.put("TimeId", this.TimeId);
		jo.put("PlanTittle", this.PlanTittle);
		jo.put("CompanyName", this.CompanyName);
		return jo;
	}
	
	public String toString() {
		return this.toJSON().toString(); 
	}
	
}
