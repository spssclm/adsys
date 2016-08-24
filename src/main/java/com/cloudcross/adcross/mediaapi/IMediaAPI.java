package com.cloudcross.adcross.mediaapi;

import com.cloudcross.adcross.model.CustBean;

/*
 * 本接口定义系统与媒体接口交互的所有预定义方法
 */
public interface IMediaAPI {

	//添加媒体广告主资质
	MediaReturn addCust(CustBean custbean);
	
	//更新媒体广告主资质
	MediaReturn updateCust(CustBean custbean);
	
	//查询媒体广告主审核状态
	MediaReturn queryCust(CustBean custbean);
	
}
