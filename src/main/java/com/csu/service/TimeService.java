package com.csu.service;

import java.util.List;

import com.csu.model.Time;

public interface TimeService {
	
	public void AddTime(Time time);
	
	public void DeleteTime(Time time);
	
	public void UpdateTime(Time time);
	
	public Time QueryTime(int id);
	
	public List<Time> QueryAllTime(int row,int PageSize);
}
