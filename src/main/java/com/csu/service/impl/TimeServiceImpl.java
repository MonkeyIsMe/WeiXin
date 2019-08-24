package com.csu.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.csu.dao.TimeDAO;
import com.csu.model.Time;
import com.csu.service.TimeService;

@Transactional
public class TimeServiceImpl implements TimeService{

	private TimeDAO td;
	
	
	public TimeDAO getTd() {
		return td;
	}

	public void setTd(TimeDAO td) {
		this.td = td;
	}

	public void AddTime(Time time) {
		// TODO Auto-generated method stub
		td.addTime(time);
	}

	public void DeleteTime(Time time) {
		// TODO Auto-generated method stub
		td.deleteTime(time);
	}

	public void UpdateTime(Time time) {
		// TODO Auto-generated method stub
		td.UpdateTime(time);
	}

	public Time QueryTime(int id) {
		// TODO Auto-generated method stub
		return td.queryTime(id);
	}

	public List<Time> QueryAllTime(int row, int PageSize) {
		// TODO Auto-generated method stub
		return td.QueryAllTime(row, PageSize);
	}

}
