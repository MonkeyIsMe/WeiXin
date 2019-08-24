package com.csu.service.impl;

import java.util.List;

import com.csu.dao.PlanDAO;
import com.csu.model.Plan;
import com.csu.service.PlanService;

public class PlanServiceImpl implements PlanService{
	
	private PlanDAO pd;


	public PlanDAO getPd() {
		return pd;
	}

	public void setPd(PlanDAO pd) {
		this.pd = pd;
	}

	public void AddPlan(Plan plan) {
		// TODO Auto-generated method stub
		pd.addPlan(plan);
	}

	public void DeletePlan(Plan plan) {
		// TODO Auto-generated method stub
		pd.deletePlan(plan);
	}

	public void UpdatePlan(Plan plan) {
		// TODO Auto-generated method stub
		pd.updatePlan(plan);
	}

	public Plan QueryPlan(int id) {
		// TODO Auto-generated method stub
		return pd.queryPlan(id);
	}

	public List<Plan> GetAllPlan() {
		// TODO Auto-generated method stub
		return pd.GetAllPlan();
	}
	
	
	
}
