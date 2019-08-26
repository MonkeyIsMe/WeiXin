package com.csu.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csu.util.CheckUtil;

import net.sf.json.JSONObject;

public class OpeinIdServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//System.out.println(req);
		String code = req.getParameter("code");
		//System.out.println("code = " + code);
		String openid = getOpenId(code);
		//System.out.println(openid);
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}
	
	public static String getOpenId(String code) {
		String sendUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxea7cdd5c1ebc8cd3&secret=9592c4b3209e12ee0c8b217abe42ec86&code="
				+ code + "&grant_type=authorization_code";
		try {
			URL url = new URL(sendUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.connect();
			// ��ȡ���ص��ַ�
			InputStream inputStream = connection.getInputStream();
			int size = inputStream.available();
			byte[] bs = new byte[size];
			inputStream.read(bs);
			String message = new String(bs, "UTF-8");
			// ��ȡaccess_token
			//System.out.println(message);
			JSONObject jsonObject = new JSONObject();
			jsonObject = JSONObject.fromObject(message);
			System.out.println(jsonObject.toString());
			//System.out.println("-------------------------");
			//System.out.println("openid:"+jsonObject.getString("openid"));
			//System.out.println("**************************");
			return jsonObject.getString("openid");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

}
