package com.cloudcross.adcross.mediaapi.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.cloudcross.adcross.mediaapi.MediaReturn;
import com.cloudcross.adcross.model.CustBean;
import com.cloudcross.adcross.common.Constants;
import com.cloudcross.adcross.common.utils.LangUtil;
import com.cloudcross.adcross.common.utils.PropertiesUtil;

/*
 * 该类实现百度
 * 1、广告主、创意接口发送参数需要的数据封装
 * 2、具体发送方法POST
 * 3、返回结果的解析
 */
public class BaiduService {

	private static final Logger log = Logger.getLogger(BaiduService.class);

	private static final String ACCEPT = "application/json;charset=utf-8";
	private static final String CONTENT_TYPE = "application/json;charset=utf-8";

	/*
	 * 防呆检查，没有问题则拼接待上传的广告主资质参数信息
	 */
	public Map<String, Object> getCustReqBody(CustBean custBean) {
		
		String status = "";
		String request = "";
		StringBuffer refuseReason = new StringBuffer();
		String Error = "";
		String response = "";		
		
		if(LangUtil.isBlank(custBean.getAdvertiserName())){
			refuseReason.append("广告主名称未设置，");
		}
		if(LangUtil.isBlank(custBean.getCustomerName())){
			refuseReason.append("客户名称未设置，");
		}
		if(LangUtil.isBlank(custBean.getSiteName())){
			refuseReason.append("网站名未设置，");
		}
		if(LangUtil.isBlank(custBean.getSiteUrl())){
			refuseReason.append("网站URL未设置，");
		}
	
		JSONObject jReqBody = new JSONObject();
		
		if("".equals(refuseReason.toString())){ //参数检查通过，开始拼接参数
			
			JSONArray jArray = new JSONArray();
			JSONObject jObject = new JSONObject();
			
			JSONObject joHeader = new JSONObject();
			
			try {
				joHeader.put("dspId", Integer.parseInt(custBean.getDspId()));
				joHeader.put("token", custBean.getToken());
				jReqBody.put("authHeader",joHeader);
				
				jObject.put("advertiserId", custBean.getCustomerId());
				jObject.put("advertiserLiteName",custBean.getAdvertiserName());
				jObject.put("advertiserName", custBean.getCustomerName());
				jObject.put("siteName", custBean.getSiteName());
				jObject.put("siteUrl", custBean.getSiteUrl());
				jObject.put("telephone", custBean.getContactPhone());
				jObject.put("address", custBean.getCompanyAddress());
				jArray.put(jObject);

				jReqBody.put("request",jArray);
				request=jReqBody.toString();
				
			} catch (JSONException e) {
				refuseReason.append(Constants.SYS_ERROR);
				response=" 原始参数: "+ custBean.toString() + " 系统异常错误: " + e.getMessage() +",";
				status = Constants.API_FAIL;
			}
		}else{ //参数检查发现错误
			refuseReason.toString().substring(0, Error.toString().length()-1);
			status = Constants.API_FAIL;
			request = custBean.toString();
		}
		
		Map<String, Object> custReq = new HashMap<String, Object>();
		custReq.put("status",status);
		custReq.put("request",request);
		custReq.put("error",Error);
		custReq.put("response",response);
		
		return custReq;
		
	}

	/*
	 * 实现具体的POST方法
	 */
	public String post(String url, String requestBody) {
		log.info("开始发送，请求接口url:" + url);
		log.info("请求接口参数param:" + requestBody);

		HttpPost httpost = new HttpPost(url);
		httpost.setHeader("Content-Type", CONTENT_TYPE);
		httpost.setHeader("Accept", ACCEPT);
		try {
			StringEntity input = new StringEntity(requestBody, "UTF-8");
			input.setContentType(CONTENT_TYPE);
			httpost.setEntity(input);

			DefaultHttpClient httpclient = new DefaultHttpClient();
			HttpResponse response = httpclient.execute(httpost);
			HttpEntity entity = response.getEntity();
			String body = EntityUtils.toString(entity);
			log.info("请求响应报文：" + body);
			return body;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return e.getMessage() + "接口访问异常，请联系管理员！";
		} finally {
			try {
				httpost.releaseConnection();
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
	}

	/* 该方法用来解析广告主上传接口返回及广告主审核状态查询返回的信息
	 * !!!不能用于广告主上传接口 添加、更新接口返回跟查询的接口返回还是不一样的。
	 * 		下边列出接口可能的返回结果串
	 * 		//API返回成功响应
	 * 			{"status":2,"errors":[{"index":-1,"field":"","code":804,"message":"IP is not in allowed IP set"}],"response":null}
	 * 			{"status":0,"errors":[],"response":[{"advertiserId":135,"advertiserName":"松下盛一装饰（上海）有限公司","advertiserLiteName":"松下盛一","telephone":"15800512181","address:"","siteUrl":"http://pessdsh.panasonic.cn/","siteName":"松下盛一装饰","isWhiteUser":1}]}
	 * 			{"status":0,"errors":[],"response":[{"type":1,"creativeUrl":"http://creative.cloudcross.com/video/27/jpeg/20160712/1468291280678cp1468293056807.jpg","targetUrl":"http://log00.cloudcross.net/baidu_adx_click.jsp?bidid=%%ID%%&ext=%%EXT_DATA%%__cu:http%3A%2F%2Fs.cr-nielsen.com%2Fhat%3F_t%3Dr%26_htsinfo%3DQyYyJjgwMDAwNTU3JjEwMDEwNjk4JjMwMjAxODY3Js6k%26l%3DaHR0cDovL3RvdXBpYW8uaHVpaHVhbG91LmNvbS8_c291cmNldXJsPTQ4NDI2MzE5Mzc2NjM0ODc5Mzk%3D%26_z%3D_%26rnd%3D51566036","landingPage":"http://toupiao.huihualou.com/?sourceurl=4842631937663487939","monitorUrls":["http://s.cr-nielsen.com/hat?_t=i&_htsinfo=SSYyJjgwMDAwNTU3JjEwMDEwNjk4JjMwMjAxODY3Jvac&_z=_&rnd=51566036","http://log00.cloudcross.net/baidu_adx_view.jsp?bidid=%%ID%%&wp=%%PRICE%%&ext=%%EXT_DATA%%"],"height":90,"width":1024,"creativeId":1531,"creativeTradeId":9901,"state":1,"advertiserId":73,"binaryData":null,"frameAgreementNo":null,"refuseReason":null,"adviewType":2,"interactiveStyle":0,"telNo":"","downloadUrl":"","appName":"","appDesc":"","appPackageSize":0.0}]}
	 *		//API审核结果 
	 * 		//审核未通过
	 * 			{"status":0,"errors":[],"response":[{"advertiserId":118,"state":2,"refuseReason":"信息被拒:信息不符|资质被拒:资质拒绝"}]}
	 * 		//审核通过
	 * 			{"status":0,"errors":[],"response":[{"advertiserId":130,"state":0,"refuseReason":null}]}
	 */
	public MediaReturn parseCustAuditInfo(String responseStr) {
		
		MediaReturn mr = new MediaReturn();
		mr.setStatus(Constants.API_WAIT);
		mr.setResponse(responseStr);

		JSONObject resp;//完整的返回串
		JSONArray jaResp;//返回串中的response值(数组)
		JSONObject joResp;//response数组的第一个json对象值
		
		try {
			resp = new JSONObject(responseStr);
			
			if (resp.has("status")) { // 接口有返回状态
				int ApiStatus = resp.getInt("status");
				if (ApiStatus == 0) { // 接口返回成功	
					jaResp = resp.getJSONArray("response");
					joResp = jaResp.getJSONObject(0);

					if(joResp.has("state")){ // 接口返回审核结果
						int AuditState = joResp.getInt("state"); // state审核结果状态
						if (AuditState == 0) { // 0：审核通过
							mr.setStatus(Constants.API_SUCC);
						} else if (AuditState == 1) { // 1:待审核
							mr.setStatus(Constants.API_WAIT);
						} else if (AuditState == 2) { // 2:审核失败
							mr.setStatus(Constants.API_FAIL);
							mr.setRefuseReason(joResp.getString("refuseReason"));
						}
					}else{
						mr.setStatus(Constants.API_FAIL);
						mr.setRefuseReason(Constants.MR_PARSE_ERROR);
					}
				} else if (ApiStatus == 2) {// 接口返回失败，通常为接口直接返回失败信息
					if (resp.getJSONArray("errors") != null) {
						JSONArray jaError = resp.getJSONArray("errors");
						JSONObject joError = jaError.getJSONObject(0);
						String code = String.valueOf(joError.getInt("code"));
						if ("804".equals(code)) {// 当code为804（IP不在设置列表中）时依然为待审核状态
							mr.setStatus(Constants.API_WAIT);
						}else {
							mr.setStatus(Constants.API_FAIL);
							mr.setRefuseReason(PropertiesUtil.getValue("baidu_"+ code));
						}
					}
				}
				//yuan
				System.out.println(mr.toString());
			}else{
				mr.setStatus(Constants.API_FAIL);
				mr.setRefuseReason(Constants.MR_PARSE_ERROR);
				//yuan
				System.out.println(mr.toString());
			}
		} catch (JSONException e) {// 各种json解析异常
			mr.setStatus(Constants.API_FAIL);
			mr.setResponse(responseStr + "=>" + e.toString());
			mr.setRefuseReason(Constants.MR_PARSE_ERROR);
			//yuan
			System.out.println(mr.toString());
		}
		return mr;
	}

	
	public static void main(String[] args) {

		BaiduService bs = new BaiduService();
//		String url = "https://api.es.baidu.com/v1/creative/queryAuditState";
		String responseStr = "";
//		"{\"status1\":0}";
//		"";
//		"{\"status\":0,\"errors\":[],\"response\":[{\"advertiserId\":118,\"state\":2,\"refuseReason\":\"信息被拒:信息不符|资质被拒:资质拒绝\"}]} ";
//		"{\"status\":0,\"errors\":[],\"response\":[{\"advertiserId\":130,\"state\":0,\"refuseReason\":null}]}";
//		"{\"status\":2,\"errors\":[{\"index\":-1,\"field\":\"\",\"code\":804,\"message\":\"IP is not in allowed IP set\"}],\"response\":null}";
//		"{\"status\":2,\"errors\":[{\"index\":-1,\"field\":\"\",\"code\":803,\"message\":\"IP is not in allowed IP set\"}],\"response\":null}";
//		"{\"status\":2,\"errors\"[{\"index\":-1,\"field\":\"\",\"code\":803,\"message\":\"IP is not in allowed IP set\"}],\"response\":null}";
		
		bs.parseCustAuditInfo(responseStr);
	}

}
