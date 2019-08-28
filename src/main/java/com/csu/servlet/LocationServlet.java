package com.csu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
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
		String url = req.getParameter("url");
        String nonce_str = generateNonceStr();
        String timestamp = String.valueOf(create_timestamp());
        
        String jsapi_ticket = getJSApiTicket();
        //String url = "http://134.175.105.160/WeiXin/location.html?nsukey=hQiVVcjYasljGZisS61djz3dhxnWegcDNUbvt%2BlQM7O3bgRDGdce%2BTJ9jzw9R%2Bb3WIiLmFh04L66gxFcxQkxgUcaflRjGYZcJ9CozN%2FMmSR7rEEOgieKx8Y6xvfZxjJdRvTjifZO3rtKm8osnIMMQNUz9Oitk72%2FKHFkUel7YZ875Ez%2F3DoeFVzKeXT4NCj59dNCZa%2BVWZg23YWK7%2BOLEw%3D%3D";
    	String str = "jsapi_ticket=" + jsapi_ticket +
                "&noncestr=" + nonce_str +
                "&timestamp=" + timestamp +
                "&url=" + url;
    	String signature = getSign(timestamp, nonce_str,jsapi_ticket, url);
    	JSONObject jo = new JSONObject();
    	jo.put("nonce_str", nonce_str);
    	jo.put("timestamp", timestamp);
    	jo.put("jsapi_ticket", jsapi_ticket);
    	jo.put("signature", signature);
    	
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
	
    public static String generateNonceStr() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
    }
    
    private static long create_timestamp() {
        return System.currentTimeMillis()/1000;
    }
	
    
    public static String getJSApiTicket() throws ParseException, IOException{ 
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
        System.out.println("token = " + token.getToken());
        String urlStr = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+token.getToken()+"&type=jsapi";  
        JSONObject jsonObject = null;
        JSONObject backData= LocationServlet.doGetStr(urlStr);  
        String ticket = (String) JSONObject.fromObject(backData).get("ticket");
        System.out.println("ticket = "+ ticket);
        return  ticket;  
           
    }  
    
	public static JSONObject doGetStr(String url) throws ParseException, IOException{
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		JSONObject jsonObject = null;
		HttpResponse httpResponse = client.execute(httpGet);
		HttpEntity entity = httpResponse.getEntity();
		if(entity != null){
			String result = EntityUtils.toString(entity,"UTF-8");
			jsonObject = JSONObject.fromObject(result);
		}
		return jsonObject;
	}
    
	public static String getSign(String timestamp,String noncestr,String jsapi_ticket,String url){

		String arr[] =new String[] {"jsapi_ticket="+jsapi_ticket,"noncestr="+noncestr,"timestamp="+timestamp,"url="+url};
		Arrays.sort(arr);//字典序排序
    	String str = "";
		str = arr[0]+"&"+arr[1]+"&"+arr[2]+"&"+arr[3];
	    //System.out.println(str);
		String mParms = null;//sha1加密
	    MessageDigest digest = null;
	    try {
	      digest = java.security.MessageDigest.getInstance("SHA");
	    } catch (NoSuchAlgorithmException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    digest.update(str.getBytes());
	    byte messageDigest[] = digest.digest();
	    // Create Hex String
	    StringBuffer hexString = new StringBuffer();
	    for (int i = 0; i < messageDigest.length; i++) {
	      String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
	      if (shaHex.length() < 2) {
	        hexString.append(0);
	      }
	      hexString.append(shaHex);
	    }
	    mParms = hexString.toString();
	    	return mParms;
	    }
	
	
	public static String byteToStr(byte[] byteArray){
		String str = "";
		for(int i=0;i<byteArray.length;i++){
			str += byteToHexStr(byteArray[i]); 		
		}
		return str;
	}
	 
	
	public static String byteToHexStr(byte mbyte){
		char[] Digit = {'1','2','3','4','5','6','7','8','9','0','A','B','C','D','E','F'};
		char[] tempArr = new char[2];
		tempArr[0] = Digit[(mbyte >>> 4) & 0X0F]; 
		tempArr[1] = Digit[mbyte & 0X0F]; 
		 String s = new String(tempArr); 
		 return s; 
		
	}

    
	
}
