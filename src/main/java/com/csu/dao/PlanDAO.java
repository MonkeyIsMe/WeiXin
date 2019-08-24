package com.csu.dao;

import java.util.List;

import com.csu.model.Plan;

public interface PlanDAO {
	
	public void addPlan(Plan plan);
	
	public void deletePlan(Plan plan);
	
	public void updatePlan(Plan plan);
	
	public Plan queryPlan(int id);
	
	public List<Plan> GetAllPlan();
	
	public List<Plan> GetAllPlanByPageSize(int row,int PageSize);
	
	public int CountPlan();
	
}
