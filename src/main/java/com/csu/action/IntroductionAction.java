package com.csu.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.csu.model.Introduction;
import com.csu.service.IntroductionService;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class IntroductionAction extends ActionSupport{

	private IntroductionService IntroductionService;
	private Introduction introduction;
	
	public IntroductionService getIntroductionService() {
		return IntroductionService;
	}
	public void setIntroductionService(IntroductionService introductionService) {
		IntroductionService = introductionService;
	}
	
	public void AddIntroduction() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		String introduction_info = request.getParameter("introduction_info");
		String introduction_time = request.getParameter("introduction_time");
		String introduction_tittle = request.getParameter("introduction_tittle");
		
		introduction.setIntroductionInfo(introduction_info);
		introduction.setIntroductionTime(introduction_time);
		introduction.setIntroductionTittle(introduction_tittle);
		
		IntroductionService.AddIntroduction(introduction);
		
	}
	
	public void UpdateIntroduction() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		String introduction_id = request.getParameter("introduction_id");
		String introduction_info = request.getParameter("introduction_info");
		String introduction_time = request.getParameter("introduction_time");
		String introduction_tittle = request.getParameter("introduction_tittle");
		
		int iid = Integer.valueOf(introduction_id);
		
		introduction = IntroductionService.QueryIntroduction(iid);
		
		if(introduction == null) {
			out.println("Fail");
			out.flush(); 
			out.close();
			return ;
		}
		
		introduction.setIntroductionInfo(introduction_info);
		introduction.setIntroductionTime(introduction_time);
		introduction.setIntroductionTittle(introduction_tittle);
		
		IntroductionService.UpdateIntroduction(introduction);
		
	}
	
	public void DeleteIntroduction() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		String introduction_id = request.getParameter("introduction_id");
		
		int iid = Integer.valueOf(introduction_id);
		
		introduction = IntroductionService.QueryIntroduction(iid);
		
		if(introduction == null) {
			out.println("Fail");
			out.flush(); 
			out.close();
			return ;
		}
		
		IntroductionService.DeleteIntroduction(introduction);
		
	}
	
	public void QueryIntroduction() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		String introduction_id = request.getParameter("introduction_id");
		
		int iid = Integer.valueOf(introduction_id);
		
		introduction = IntroductionService.QueryIntroduction(iid);
		
		if(introduction == null) {
			out.println("Fail");
			out.flush(); 
			out.close();
			return ;
		}
		
		JSONObject jo = JSONObject.fromObject(introduction);
		
		out.println(jo.toString());
		out.flush(); 
		out.close();
		return ;
		
	}
	
	public void QueryAllIntroduction() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		List<Introduction> IntroductionList = IntroductionService.GetAllIntroduction();
		
		JSONArray ja = JSONArray.fromObject(IntroductionList);
		
		out.println(ja.toString());
        out.flush(); 
        out.close();
		
	}
	
	public void QueryAllIntroductionByPageSize() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		String rows = request.getParameter("rows");
		String page = request.getParameter("page");
		
		int row = Integer.valueOf(rows);		
		int PageSize = Integer.valueOf(page);
		
		List<Introduction> IntroductionList = IntroductionService.GetAllIntroductionByPageSize(row, PageSize);
		
		JSONArray ja = JSONArray.fromObject(IntroductionList);
		
		out.println(ja.toString());
        out.flush(); 
        out.close();
		
	}
	
	public void CountIntroduction() throws Exception{
		
		ServletActionContext.getResponse().setContentType("text/html; charset=utf-8");
		HttpServletRequest request= ServletActionContext.getRequest();
		
		//返回结果
		PrintWriter out = null;
		out = ServletActionContext.getResponse().getWriter();
		
		int cnt = IntroductionService.CountIntroduction();
		
		JSONObject jo = new JSONObject();
		
		jo.put("cnt", cnt);
		
		out.println(jo.toString());
        out.flush(); 
        out.close();
		
	}
	
}
