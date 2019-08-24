package com.csu.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.csu.model.User;
import com.csu.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class UserAction extends ActionSupport{
	
	private UserService UserService;
	private User user = new User();
	
	public UserService getUserService() {
		return UserService;
	}
	public void setUserService(UserService userService) {
		UserService = userService;
	}
	
	public void AddUser() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		String user_number = request.getParameter("user_number");
		String user_phone = request.getParameter("user_phone");
		String user_appid = request.getParameter("user_appid");
		String user_role = request.getParameter("user_role");
		String user_company = request.getParameter("user_company");
		String user_name = request.getParameter("user_name");
		
		user.setUserAppid(user_appid);
		user.setUserNumber(user_number);
		user.setUserPhone(user_phone);
		user.setUserRole(user_role);
		user.setUserCompany(user_company);
		user.setUserName(user_name);
		
		UserService.AddUser(user);
	}
	
	public void QueryAllUser() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		List<User> UserList = UserService.GetAllUser();
		
		JSONArray ja = JSONArray.fromObject(UserList);
		
		out.println(ja.toString());
        out.flush(); 
        out.close();
	}
	
	public void UpdateUser() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		String user_number = request.getParameter("user_number");
		String user_phone = request.getParameter("user_phone");
		String user_appid = request.getParameter("user_appid");
		String user_role = request.getParameter("user_role");
		String user_company = request.getParameter("user_company");
		String user_name = request.getParameter("user_name");
		String user_id = request.getParameter("user_id");
		
		int uid = Integer.valueOf(user_id);
		
		user = UserService.QueryUser(uid);
		
		if(user == null) {
			out.println("Fail");
			out.flush(); 
			out.close();
			return ;
		}
				
		user.setUserAppid(user_appid);
		user.setUserNumber(user_number);
		user.setUserPhone(user_phone);
		user.setUserRole(user_role);
		user.setUserCompany(user_company);
		user.setUserName(user_name);
		
		UserService.UpdateUser(user);
	}
	
	public void DeleteUser() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		String user_id = request.getParameter("user_id");
		
		int uid = Integer.valueOf(user_id);
		
		user = UserService.QueryUser(uid);
		
		if(user == null) {
			out.println("Fail");
			out.flush(); 
			out.close();
			return ;
		}
		
		UserService.DeleteUser(user);
	}
	
	public void QueryUser() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		String user_id = request.getParameter("user_id");
		
		int uid = Integer.valueOf(user_id);
		
		user = UserService.QueryUser(uid);
		
		if(user == null) {
			out.println("Fail");
			out.flush(); 
			out.close();
			return ;
		}
		
		JSONObject jo = JSONObject.fromObject(user);
		
		out.println(jo.toString());
		out.flush(); 
		out.close();
		return ;
	}
	
	public void QueryUserByNumber() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		String user_number = request.getParameter("user_number");
		
		
		user = UserService.QueryUserByNumber(user_number);
		
		if(user == null) {
			out.println("Fail");
			out.flush(); 
			out.close();
			return ;
		}
		
		JSONObject jo = JSONObject.fromObject(user);
		
		out.println(jo.toString());
		out.flush(); 
		out.close();
		return ;
	}
	
}
