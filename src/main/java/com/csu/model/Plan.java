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
	
	@Column(name="plan_time")
	private String PlanTime;
	
	@Column(name="plan_tittle")
	private String PlanTittle;

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

	public String getPlanTime() {
		return PlanTime;
	}

	public void setPlanTime(String planTime) {
		PlanTime = planTime;
	}

	public String getPlanTittle() {
		return PlanTittle;
	}

	public void setPlanTittle(String planTittle) {
		PlanTittle = planTittle;
	}
	
	public JSONObject toJSON() {
		JSONObject jo = new JSONObject();
		jo.put("PlanId", this.PlanId);
		jo.put("PlanInfo", this.PlanInfo);
		jo.put("PlanTime", this.PlanTime);
		jo.put("PlanTittle", this.PlanTittle);
		return jo;
	}
	
	public String toString() {
		return this.toJSON().toString(); 
	}
	
}
