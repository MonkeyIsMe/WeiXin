package com.csu.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.csu.model.User;
import com.csu.service.UserService;
import com.csu.servlet.OpeinIdServlet;
import com.csu.util.DateUtil;
import com.csu.util.SmsUtil;
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
		String code = request.getParameter("code");
		String user_role = request.getParameter("user_role");
		String user_company = request.getParameter("user_company");
		String user_name = request.getParameter("user_name");
		String user_password = request.getParameter("user_password");
		
		String openid = OpeinIdServlet.getOpenId(code);
		
		user.setUserAppid(openid);
		user.setUserNumber(user_number);
		user.setUserPhone(user_phone);
		user.setUserRole(user_role);
		user.setUserCompany(user_company);
		user.setUserName(user_name);
		user.setUserPassword(user_password);
		
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
		
		String code = request.getParameter("code");
		String user_phone = request.getParameter("user_phone");
		String ali_code = request.getParameter("ali_code");
		String openid = OpeinIdServlet.getOpenId(code);
		user = UserService.QueryUserByPhone(user_phone);
		HttpSession session  = request.getSession();
		System.out.println(session.getAttribute("code"));
		String checkcode =  (String) session.getAttribute("code");
		if(user == null) {
			out.println("Fail");
			out.flush(); 
			out.close();
			return ;
		}
		else if(ali_code.endsWith(checkcode)) {
			user.setUserPhone(user_phone);
			user.setUserAppid(code);
			user.setUserAppid(openid);
			user.setUserFlag("1");
			
			UserService.UpdateUser(user);
			out.println("Success");
			out.flush(); 
			out.close();
			return ;
		}
		else {
			out.println("WrongCode");
			out.flush(); 
			out.close();
			return ;
		}
				

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
	
	public void QueryAllUserByPageSize() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		String rows = request.getParameter("page");
		String page = request.getParameter("limit");
		
		int row = Integer.valueOf(rows);		
		int PageSize = Integer.valueOf(page);
		
		List<User> UserList = UserService.GetAllUserByPageSize(row, PageSize);
		
		JSONArray ja = JSONArray.fromObject(UserList);
		
		out.println(ja.toString());
        out.flush(); 
        out.close();
	}
	
	public void CountUser() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		int cnt = UserService.CountUser();
		
		JSONObject jo = new JSONObject();
		jo.put("cnt", cnt);
		
		out.println(jo.toString());
        out.flush(); 
        out.close();
	}
	
	public void Login() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		String user_phone = request.getParameter("user_phone");
		String user_code = request.getParameter("user_code");
		
		user = UserService.QueryUserByPhone(user_phone);
		//System.out.println(user_phone);
		//System.out.println(user.toString());
		if(user == null) {
			out.println("NoUser");
			out.flush(); 
			out.close();
			return ;
		}
		else {
			String flag = user.getUserFlag();
			if(flag.endsWith("0")) {
				out.println("NoRegister");
				out.flush(); 
				out.close();
				return ;
			}
			else {
				HttpSession session  = request.getSession();
				String checkcode = (String)session.getAttribute("code");
				if(checkcode.endsWith(user_code)) {
					request.getSession().setAttribute("user_phone", user_phone);
					out.println("Success");
					out.flush(); 
					out.close();
					return ;
				}
				else {
					out.println("WrongCode");
					out.flush(); 
					out.close();
					return ;
				}
			}
		}
		
	}
	
	public void UserIsExist() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		String user_phone = request.getParameter("user_phone");
		
		
		user = UserService.QueryUserByPhone(user_phone);
		
		if(user == null) {
			out.println("Fail");
			out.flush(); 
			out.close();
			return ;
		}
		else {
			out.println("Success");
	        out.flush(); 
	        out.close();
		}
	}
	
	public void SendCode() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		String user_phone = request.getParameter("user_phone");
		SmsUtil su = new SmsUtil();
		
		int code = su.ProduceCode();
		String msg = su.sendSms(user_phone, code, 1);
		JSONObject jo = JSONObject.fromObject(msg);
		String c = String.valueOf(code);
		request.getSession().setAttribute("code", c);
		if(jo.get("Message").equals("OK")) {
			out.println("Success");
			out.flush(); 
			out.close();
		}
		else {
			out.println("Fail");
			out.flush(); 
			out.close();
		}
	}
	
	public void ReadExcel() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		String user_info = request.getParameter("user_info");
		
		JSONArray ja = JSONArray.fromObject(user_info);
		JSONArray add_ja = new JSONArray();
		
		for(int i = 0; i < ja.size(); i ++) {
			
			JSONObject jo = ja.getJSONObject(i);
			
			String user_name = jo.getString("姓名");
			String user_number = jo.getString("学号");
			String user_phone = jo.getString("电话号码");
			String user_year = jo.getString("年份");
			String user_place = jo.getString("所属基地");
			String user_role = jo.getString("角色");
			
			user.setUserCompany(user_place);
			user.setUserRole(user_role);
			user.setUserName(user_name);
			user.setUserNumber(user_number);
			user.setUserPhone(user_phone);
			user.setUserYear(user_year);
			user.setUserFlag("0");
			
			JSONObject add_jo = JSONObject.fromObject(user);
			add_ja.add(add_jo);
		}
		
		List<User> UserList = JSONArray.toList(add_ja,User.class);
		UserService.AddMutiplyUser(UserList);
		
	}

	public void IsLogin() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		HttpSession session  = request.getSession();
		String user_phone = (String)session.getAttribute("user_phone");
		System.out.println("user_phone = " + user_phone);
		if(user_phone == null || user_phone == "" || user_phone.equals("")) {
			out.println("Fail");
			out.flush(); 
			out.close();
		}
		else {
			user = UserService.QueryUserByPhone(user_phone);
			DateUtil du = new DateUtil();
			user.setUserSign(du.GetNowDate());
			UserService.UpdateUser(user);
			out.println("Success");
			out.flush(); 
			out.close();
		}
		
	}
}
