package com.csu.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialBlob;

import org.apache.struts2.ServletActionContext;

import com.csu.model.Company;
import com.csu.model.Plan;
import com.csu.model.Time;
import com.csu.service.CompanyService;
import com.csu.service.PlanService;
import com.csu.service.TimeService;
import com.mysql.jdbc.Blob;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class PlanAction extends ActionSupport{
	
	private PlanService PlanService;
	private TimeService TimeService;
	private CompanyService CompanyService;
	private Plan plan = new Plan();
	private Company company = new Company();
	private Time time = new Time();
	
	
	public PlanService getPlanService() {
		return PlanService;
	}

	public void setPlanService(PlanService planService) {
		PlanService = planService;
	}
	public TimeService getTimeService() {
		return TimeService;
	}

	public void setTimeService(TimeService timeService) {
		TimeService = timeService;
	}

	public CompanyService getCompanyService() {
		return CompanyService;
	}

	public void setCompanyService(CompanyService companyService) {
		CompanyService = companyService;
	}

	public void AddPlan() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		String plan_info = request.getParameter("plan_info");
		String time_id = request.getParameter("time_id");
		String plan_tittle = request.getParameter("plan_tittle");
		String company_name = request.getParameter("company_name");
		
				
		plan.setCompanyName(company_name);
		plan.setPlanInfo(plan_info);
		plan.setTimeId(time_id);
		plan.setPlanTittle(plan_tittle);
		
		PlanService.AddPlan(plan);
		
	}
	
	public void DeletePlan() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		String plan_id = request.getParameter("plan_id");

		PlanService.DeletePlan(plan);
	}
	
	public void UpdatePlan() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		String plan_id = request.getParameter("plan_id");
		String plan_info = request.getParameter("plan_info");
		String time_id = request.getParameter("time_id");
		String plan_tittle = request.getParameter("plan_tittle");
		String company_name = request.getParameter("company_name");
		
		int pid = Integer.valueOf(plan_id);
		plan = PlanService.QueryPlan(pid);
		
		
		if(plan == null) {
			out.println("Fail");
			out.flush(); 
			out.close();
			return ;
		}
		
		plan.setPlanInfo(plan_info);
		plan.setTimeId(time_id);
		plan.setPlanTittle(plan_tittle);
		plan.setCompanyName(company_name);
		
		PlanService.UpdatePlan(plan);
		
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
	
	public void QueryAllPlanByPageSize() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		String rows = request.getParameter("page");
		String page = request.getParameter("limit");
		
		int row = Integer.valueOf(rows);		
		int PageSize = Integer.valueOf(page);
		
		List<Plan> PlanList = PlanService.GetAllPlanByPageSize(row, PageSize);
		
		JSONArray ja = JSONArray.fromObject(PlanList);
		out.println(ja.toString());
        out.flush(); 
        out.close();
		
	}
	
	public void CountPlan() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		int cnt = PlanService.CountPlan();
		
		JSONObject jo = new JSONObject();
		
		jo.put("cnt", cnt);
		
		out.println(jo.toString());
        out.flush(); 
        out.close();
		
	}
	
	public void GetByTimeAndCompany() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		String company_id = request.getParameter("company_id");
		String time_id = request.getParameter("time_id");
		
		int cid = Integer.valueOf(company_id);
		company = CompanyService.QueryCompany(cid);
		String company_name = company.getCompanyName();
		
		int tid = Integer.valueOf(time_id);
		time = TimeService.QueryTime(tid);
		String time_name = time.getTimeName();
		
		JSONObject jo = new JSONObject();
		//System.out.println(time_name + " " + company_name);
		List<Plan> PlanList  = PlanService.GetByTimeAndCompanyPlan(time_name, company_name);
		//System.out.println(PlanList.size());
		JSONArray ja = JSONArray.fromObject(PlanList);
		
		out.println(ja.toString());
        out.flush(); 
        out.close();
		
	}
	
	
}
