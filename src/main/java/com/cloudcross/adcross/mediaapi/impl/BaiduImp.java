package com.cloudcross.adcross.mediaapi.impl;

import java.util.Map;

import com.cloudcross.adcross.common.Constants;
import com.cloudcross.adcross.mediaapi.IMediaAPI;
import com.cloudcross.adcross.mediaapi.MediaReturn;
import com.cloudcross.adcross.mediaapi.service.BaiduService;
import com.cloudcross.adcross.model.CustBean;
import com.cloudcross.adcross.mediaapi.Loger;

/*
 * 该类实现百度接口的业务处理
 */
public class BaiduImp implements IMediaAPI {

	private BaiduService baiduService;
	private Loger loger;
	
	private static final String API_VERSION = "v1";
	
	private static final String ADDADV = "/advertiser/add";
	private static final String UPDATEADV = "/advertiser/update";
	private static final String GETADVSTATUS = "/advertiser/queryQualification";
	
	private static final String ADDAD = "/creative/add";
	private static final String UPDATEAD = "/creative/update";
	private static final String GETADSTATUS = "/creative/queryAuditState";
	
	@Override
	public MediaReturn addCust(CustBean custbean) {
		
		MediaReturn mr = null;
		
		String url = custbean.getAdxApi()+API_VERSION+ADDADV;
		String requestStr = null;
		String responseStr = null;
		
		try {
			Map<String, Object> custReqMap = baiduService.getCustReqBody(custbean);
			requestStr = (custReqMap.get("requestBody")).toString();
			boolean result = Boolean.parseBoolean(custReqMap.get("result").toString());
			if (result) {
				responseStr = baiduService.post(url, requestStr); 
				mr = baiduService.parseCustAPIandAuditInfo(responseStr);
			}else {
				mr.setRefuseReason(Constants.MSG_CHECKFAIL);
				mr.setRequest(Constants.MSG_CHECKFAIL+":"+requestStr);
			}
		} catch (Exception e) {
			responseStr = e.getMessage();
			mr = null;
		}
		
		loger.saveLog(Constants.API_BAIDU_CUST, "addAdv", custbean.getCustomerId().toString(), requestStr, responseStr, mr);
		return mr;
	}


	@Override
	public MediaReturn updateCust(CustBean custbean) {
		
		MediaReturn mr = null;
		
		String url = custbean.getAdxApi()+API_VERSION+UPDATEADV;
		String requestStr = null;
		String responseStr = null;
		
		try {
			Map<String, Object> custReqMap = baiduService.getCustReqBody(custbean);
			requestStr = (custReqMap.get("requestBody")).toString();
			boolean result = Boolean.parseBoolean(custReqMap.get("result").toString());
			if (result) {
				responseStr = baiduService.post(url, requestStr); 
				mr = baiduService.parseCustAPIandAuditInfo(responseStr);
			}else {
				mr.setRefuseReason(Constants.MSG_CHECKFAIL);
				mr.setRequest(Constants.MSG_CHECKFAIL+":"+requestStr);
			}
		} catch (Exception e) {
			responseStr = e.getMessage();
			mr = null;
		}
		loger.saveLog(Constants.API_BAIDU_CUST, "updateAdv", custbean.getCustomerId().toString(), requestStr, responseStr, mr);
		return mr;
	}

	@Override
	public MediaReturn queryCust(CustBean custbean) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	public static void main(String[] args) {
//		BaiduImp bi = new BaiduImp();
//		bi.addCust(custbean);
//	}

}
