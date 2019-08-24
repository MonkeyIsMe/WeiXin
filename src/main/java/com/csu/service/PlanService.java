package com.csu.service;

import java.util.List;

import com.csu.model.Plan;

public interface PlanService {
	
	public void AddPlan(Plan plan);
	
	public void DeletePlan(Plan plan);
	
	public void UpdatePlan(Plan plan);
	
	public Plan QueryPlan(int id);
	
	public List<Plan> GetAllPlan();
	
}
