package com.csu.test;

import java.io.UnsupportedEncodingException;

import com.csu.util.SmsUtil;

public class Main {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		SmsUtil su = new SmsUtil();
		String msg = su.sendSms("13617305586", 123123, 1);
		System.out.println(msg);
	}
	
}
