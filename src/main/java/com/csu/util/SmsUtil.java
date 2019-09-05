package com.csu.util;

import java.util.Random;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

public class SmsUtil {
	
    public static final int START = 100000;   //定义范围开始数字
    public static final int END = 999999; //定义范围结束数字
	
    private static final String regionId = PropertyUtil.getProperty("config","smsRegionId");
    private static final String accessKeyId = PropertyUtil.getProperty("config","smsAccessKeyId");
    private static final String accessSecret = PropertyUtil.getProperty("config","smsAccessSecret");
    private static final String domain = PropertyUtil.getProperty("config","smsDomain");
    private static final String version = PropertyUtil.getProperty("config","smsVersion");
    private static final String action = PropertyUtil.getProperty("config","smsAction");
    private static final String smsSignNameRegister = "计算机门户注册";
    private static final String smsTemplateCodeRegister = PropertyUtil.getProperty("config","smsTemplateCodeRegister");
    private static final String smsSignNameFind = PropertyUtil.getProperty("config","smsSignNameFind");
    private static final String smsTemplateCodeFind = PropertyUtil.getProperty("config","smsTemplateCodeFind");

    public static String sendSms(String phone,int code,int smsType){
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain(domain);
        request.setVersion(version);
        request.setAction(action);
        request.putQueryParameter("RegionId", regionId);
        request.putQueryParameter("PhoneNumbers", phone);
        if(smsType==1){//1为注册，2为找回
            request.putQueryParameter("SignName", smsSignNameRegister);
            request.putQueryParameter("TemplateCode", smsTemplateCodeRegister);
        }else{
            request.putQueryParameter("SignName", smsSignNameFind);
            request.putQueryParameter("TemplateCode", smsTemplateCodeFind);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",code);
        request.putQueryParameter("TemplateParam", jsonObject.toJSONString());
        try {
            CommonResponse response = client.getCommonResponse(request);
//            System.out.println(response.getData());
            return response.getData();

        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int ProduceCode(){
    	
    	Random random = new Random();
    	int number = random.nextInt(END - START + 1) + START;
    	return number;
    }

}
