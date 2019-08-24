package com.csu.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.csu.model.Time;
import com.csu.service.TimeService;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TimeAction extends ActionSupport{
	
	private TimeService TimeService;
	private Time time = new Time();
	
	public TimeService getTimeService() {
		return TimeService;
	}
	public void setTimeService(TimeService timeService) {
		TimeService = timeService;
	}

	public void AddTime() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		String time_name = request.getParameter("time_name");
		
		TimeService.AddTime(time);
		
	}
	
	public void UpdateTime() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		String time_name = request.getParameter("time_name");
		String time_id = request.getParameter("time_id");
		
		int tid = Integer.valueOf(time_id);
		
		time = TimeService.QueryTime(tid);
		
		if(time == null) {
			out.println("Fail");
			out.flush(); 
			out.close();
			return ;
		}
		
		time.setTimeName(time_name);
		
		TimeService.UpdateTime(time);
		
	}
	
	public void DeleteTime() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		String time_id = request.getParameter("time_id");
		
		int tid = Integer.valueOf(time_id);
		
		time = TimeService.QueryTime(tid);
		
		if(time == null) {
			out.println("Fail");
			out.flush(); 
			out.close();
			return ;
		}
		
		TimeService.DeleteTime(time);
		
	}
	
	public void QueryTime() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		String time_id = request.getParameter("time_id");
		
		int tid = Integer.valueOf(time_id);
		
		time = TimeService.QueryTime(tid);
		
		if(time == null) {
			out.println("Fail");
			out.flush(); 
			out.close();
			return ;
		}
		
		JSONObject jo = JSONObject.fromObject(time);
		
		out.println(jo.toString());
		out.flush(); 
		out.close();
		return ;
	}
	
	public void QueryAllTime() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		String rows = request.getParameter("rows");
		String page = request.getParameter("page");
		
		int row = Integer.valueOf(rows);		
		int PageSize = Integer.valueOf(page);
		
		List<Time> TimeList = TimeService.QueryAllTime(row, PageSize);
		
		JSONArray ja = JSONArray.fromObject(TimeList);
		
		out.println(ja.toString());
        out.flush(); 
        out.close();
	}
	

}
