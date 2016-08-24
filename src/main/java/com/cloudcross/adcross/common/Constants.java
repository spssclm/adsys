package com.cloudcross.adcross.common;

public class Constants {
	
	public final static int API_FAIL = 3;     //预检查接口发送参数失败或者媒体审核失败
	public final static int API_REQFAIL = -1; //媒体接口无法访问或者访问受限
	public final static int API_WAIT = 2;	  //媒体接收数据，待审核
	public final static int API_SUCC = 4;	  //媒体审核通过
	
	public final static String MSG_CHECKFAIL = "发送信息预先检查发现错误";
	
	public final static String MR_PARSE_ERROR = "媒体返回内容无法解析，请联系管理员";
	
	public final static String SYS_ERROR = "系统异常，请联系管理员";
	
	//loger model name 模块名
	public static final String API_BAIDU_CUST = "api_baidu_cust";
	public static final String API_BAIDU_AD = "api_baidu_ad";

}
