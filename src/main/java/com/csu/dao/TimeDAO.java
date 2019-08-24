package com.csu.dao;

import java.util.List;

import com.csu.model.Time;

public interface TimeDAO {
	
	public void addTime(Time time);
	
	public void deleteTime(Time time);
	
	public void UpdateTime(Time time);
	
	public Time queryTime(int id);
	
	public List<Time> QueryAllTimeByPageSize(int row,int PageSize);
	
	public List<Time> QueryAllTime();
	
	public int CountTime();
}
