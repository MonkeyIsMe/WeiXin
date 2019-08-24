package com.csu.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.csu.model.Role;
import com.csu.service.RoleService;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class RoleAction extends ActionSupport{
	
	private RoleService RoleService;
	private Role role = new Role();
	
	public RoleService getRoleService() {
		return RoleService;
	}
	
	public void setRoleService(RoleService roleService) {
		RoleService = roleService;
	}



	public void AddRole() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		String role_name = request.getParameter("role_name");
		String role_info = request.getParameter("role_info");
		
		role.setroleName(role_name);
		role.setroleInfo(role_info);
		
		RoleService.AddRole(role);
		
	}
	
	public void DeleteRole() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		String role_id = request.getParameter("role_id");
		
		int rid = Integer.valueOf(role_id);
		
		role = RoleService.QueryRole(rid);
		
		if(role == null) {
			out.println("Fail");
			out.flush(); 
			out.close();
			return ;
		}
		
		RoleService.DeleteRole(role);
		
	}
	
	public void UpdateRole() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		String role_id = request.getParameter("role_id");
		String role_name = request.getParameter("role_name");
		String role_info = request.getParameter("role_info");
		

		
		int rid = Integer.valueOf(role_id);
		
		role = RoleService.QueryRole(rid);
		
		if(role == null) {
			out.println("Fail");
			out.flush(); 
			out.close();
			return ;
		}
		
		role.setroleName(role_name);
		role.setroleInfo(role_info);
		
		RoleService.UpdateRole(role);
		
	}
	
	public void QueryRole() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		String role_id = request.getParameter("role_id");
		
		int rid = Integer.valueOf(role_id);
		
		role = RoleService.QueryRole(rid);
		
		if(role == null) {
			out.println("Fail");
			out.flush(); 
			out.close();
			return ;
		}
		
		JSONObject jo = JSONObject.fromObject(role);
		
		out.println(jo.toString());
		out.flush(); 
		out.close();
		return ;
	}
	
	public void QueryAllRoleByPageSize() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		String rows = request.getParameter("rows");
		String page = request.getParameter("page");
		
		int row = Integer.valueOf(rows);		
		int PageSize = Integer.valueOf(page);
		
		List<Role> RoleList = RoleService.QueryAllRoleByPageSize(row, PageSize);
		
		JSONArray ja = JSONArray.fromObject(RoleList);
		
		out.println(ja.toString());
        out.flush(); 
        out.close();
	}
	
	public void CountRole() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		int cnt = RoleService.CountRole();
		
		JSONObject jo = new JSONObject();
		jo.put("cnt", cnt);
		
		out.println(jo.toString());
        out.flush(); 
        out.close();
	}
	
	public void QueryAllRole() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		List<Role> RoleList = RoleService.QueryAllRole();
		
		JSONArray ja = JSONArray.fromObject(RoleList);
		
		out.println(ja.toString());
        out.flush(); 
        out.close();
	}
	
}
