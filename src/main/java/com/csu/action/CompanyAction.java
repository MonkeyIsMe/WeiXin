package com.csu.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.csu.model.Company;
import com.csu.service.CompanyService;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class CompanyAction extends ActionSupport{

	private CompanyService CompanyService;
	private Company company = new Company();
	
	public void AddCompany() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		String company_name = request.getParameter("company_name");
		String company_info = request.getParameter("company_info");
		
		company.setCompanyInfo(company_info);
		company.setCompanyName(company_name);
		
		CompanyService.AddCompany(company);
	}
	
	public void UpdateCompany() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		String company_name = request.getParameter("company_name");
		String company_info = request.getParameter("company_info");
		String company_id = request.getParameter("company_id");
		
		int cid = Integer.valueOf(company_id);
		
		company = CompanyService.QueryCompany(cid);
		
		if(company == null) {
			out.println("Fail");
			out.flush(); 
			out.close();
			return ;
		}
		
		company.setCompanyInfo(company_info);
		company.setCompanyName(company_name);
		
		CompanyService.UpdateCompany(company);
	}
	
	public void QueryCompany() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		String company_id = request.getParameter("company_id");
		
		int cid = Integer.valueOf(company_id);
		
		company = CompanyService.QueryCompany(cid);
		
		if(company == null) {
			out.println("Fail");
			out.flush(); 
			out.close();
			return ;
		}
		
		JSONObject jo = JSONObject.fromObject(company);
		
		out.println(jo.toString());
		out.flush(); 
		out.close();
		return ;
		
	}
	
	public void DeleteCompany() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		String company_id = request.getParameter("company_id");
		
		int cid = Integer.valueOf(company_id);
		
		company = CompanyService.QueryCompany(cid);
		
		if(company == null) {
			out.println("Fail");
			out.flush(); 
			out.close();
			return ;
		}
		
		CompanyService.DeleteCompany(company);
		
	}
	
	public void QueryAllCompanyByPageSize() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		String rows = request.getParameter("rows");
		String page = request.getParameter("page");
		
		int row = Integer.valueOf(rows);		
		int PageSize = Integer.valueOf(page);
		
		List<Company> CompanyList = CompanyService.QueryAllCompanyByPageSize(row, PageSize);
		
		JSONArray ja = JSONArray.fromObject(CompanyList);
		
		out.println(ja.toString());
        out.flush(); 
        out.close();
		
	}
	
	public void QueryAllCompany() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		
		List<Company> CompanyList = CompanyService.QueryAllCompany();
		
		JSONArray ja = JSONArray.fromObject(CompanyList);
		
		out.println(ja.toString());
        out.flush(); 
        out.close();
		
	}
	
	public void CountCompany() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		int cnt = CompanyService.CountCompany();
		
		JSONObject jo = new JSONObject();
		
		jo.put("cnt",cnt);
		
		out.println(jo.toString());
        out.flush(); 
        out.close();
		
	}
}
