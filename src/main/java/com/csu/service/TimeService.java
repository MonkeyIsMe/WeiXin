package com.csu.service;

import java.util.List;

import com.csu.model.Time;

public interface TimeService {
	
	public void AddTime(Time time);
	
	public void DeleteTime(Time time);
	
	public void UpdateTime(Time time);
	
	public Time QueryTime(int id);
	
	public List<Time> QueryAllTimeByPageSize(int row,int PageSize);
	
	public List<Time> QueryAllTime();
	
	public int CountTime();
}
