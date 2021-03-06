package com.csu.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.csu.dao.PlanDAO;
import com.csu.model.Plan;
import com.csu.service.PlanService;

@Transactional
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

	public List<Plan> GetAllPlanByPageSize(int row, int PageSize) {
		// TODO Auto-generated method stub
		return pd.GetAllPlanByPageSize(row, PageSize);
	}

	public int CountPlan() {
		// TODO Auto-generated method stub
		return pd.CountPlan();
	}

	public List<Plan> GetByTimeAndCompanyPlan(String time_name, String company_name) {
		// TODO Auto-generated method stub
		return pd.GetByTimeAndCompanyPlan(time_name, company_name);
	}
	
	
	
}
