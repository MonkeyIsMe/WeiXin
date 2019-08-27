package com.csu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Formatter;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.ParseException;
import org.dom4j.DocumentException;
import org.omg.PortableServer.Servant;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import net.sf.json.JSONObject;
import com.csu.po.AccessToken;
import com.csu.util.CheckUtil;
import com.csu.util.MessageUtil;
import com.csu.util.WeixinUtil;

import net.sf.json.JSONObject;

public class LocationServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}
	
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		
        String nonce_str = create_nonce_str();
        String timestamp = create_timestamp();
        String signature = "";
        String jsapi_ticket = getJSApiTicket();
        String url = "http://134.175.105.160/WeiXin/wx.do";
    	String str = "jsapi_ticket=" + jsapi_ticket +
                "&noncestr=" + nonce_str +
                "&timestamp=" + timestamp +
                "&url=" + url;
    	
    	try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(str.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	JSONObject jo = new JSONObject();
    	jo.put("nonce_str", nonce_str);
    	jo.put("timestamp", nonce_str);
    	jo.put("jsapi_ticket", jsapi_ticket);
    	jo.put("signature", signature);
    	jo.put("url", url);
    	
    	out.print(jo.toString());
		out.flush(); 
		out.close();
		
	}
	
    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
	
    private static String create_nonce_str() {
        return UUID.randomUUID().toString();
    }
    
    private static String create_timestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }
	
    public static String sendGet(String url, String charset, int timeout)
    {
      String result = "";
      try
      {
        URL u = new URL(url);
        try
        {
          URLConnection conn = u.openConnection();
          conn.connect();
          conn.setConnectTimeout(timeout);
          BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));
          String line="";
          while ((line = in.readLine()) != null)
          {
           
            result = result + line;
          }
          in.close();
        } catch (IOException e) {
          return result;
        }
      }
      catch (MalformedURLException e)
      {
        return result;
      }
     System.out.println(result);
      return result;
    }
    
    public static String getJSApiTicket(){ 
        //获取token
    	
    	WeixinUtil wu = new WeixinUtil();
    	AccessToken token = null;
		try {
			token = wu.getAccessToken();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        //String acess_token = JsapiTicketUtil.getAccessToken();
        //System.out.println("token = " + token);
        String urlStr = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+token.getToken()+"&type=jsapi";  
        String backData= LocationServlet.sendGet(urlStr, "utf-8", 10000);  
        String ticket = (String) JSONObject.fromObject(backData).get("ticket");  
        return  ticket;  
           
    }  
    

    
	
}
