package com.csu.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.csu.model.Plan;
import com.csu.service.PlanService;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class PlanAction extends ActionSupport{
	
	private PlanService PlanService;
	private Plan plan = new Plan();
	
	
	public PlanService getPlanService() {
		return PlanService;
	}

	public void setPlanService(PlanService planService) {
		PlanService = planService;
	}



	public void AddPlan() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		String plan_info = request.getParameter("plan_info");
		String plan_time = request.getParameter("plan_time");
		String plan_tittle = request.getParameter("plan_tittle");
		
		plan.setPlanInfo(plan_info);
		plan.setPlanTime(plan_time);
		plan.setPlanTittle(plan_tittle);
		
		PlanService.AddPlan(plan);
		
	}
	
	public void DeletePlan() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		String plan_info = request.getParameter("plan_info");
		String plan_time = request.getParameter("plan_time");
		String plan_tittle = request.getParameter("plan_tittle");
		
		plan.setPlanInfo(plan_info);
		plan.setPlanTime(plan_time);
		plan.setPlanTittle(plan_tittle);
		
		PlanService.AddPlan(plan);
		
	}
	
	public void UpdatePlan() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		String plan_id = request.getParameter("plan_id");
		String plan_info = request.getParameter("plan_info");
		String plan_time = request.getParameter("plan_time");
		String plan_tittle = request.getParameter("plan_tittle");
		
		int pid = Integer.valueOf(plan_id);
		plan = PlanService.QueryPlan(pid);
		
		if(plan == null) {
			out.println("Fail");
			out.flush(); 
			out.close();
			return ;
		}
		
		plan.setPlanInfo(plan_info);
		plan.setPlanTime(plan_time);
		plan.setPlanTittle(plan_tittle);
		
		PlanService.AddPlan(plan);
		
	}
	
	public void QueryPlan() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		String plan_id = request.getParameter("plan_id");
		
		int pid = Integer.valueOf(plan_id);
		
		plan = PlanService.QueryPlan(pid);
		
		if(plan == null) {
			out.println("Fail");
			out.flush(); 
			out.close();
			return ;
		}
		
		JSONObject jo = JSONObject.fromObject(plan);
		
		out.println(jo.toString());
		out.flush(); 
		out.close();
		return ;
		
	}
	
	public void QueryAllPlan() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		List<Plan> PlanList = PlanService.GetAllPlan();
		
		JSONArray ja = JSONArray.fromObject(PlanList);
		out.println(ja.toString());
        out.flush(); 
        out.close();
		
	}
	
}
