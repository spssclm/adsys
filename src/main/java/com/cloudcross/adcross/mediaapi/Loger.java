package com.cloudcross.adcross.mediaapi;

import org.springframework.beans.factory.annotation.Autowired;

import com.cloudcross.adcross.base.dao.GenericIBatisDao;
import com.cloudcross.adcross.common.Constants;
import com.cloudcross.adcross.model.LogBean;

public class Loger {
	
	@Autowired
	private GenericIBatisDao ibatisDao;
	
	public void saveLog(String model,String operater, String obj,String context,String response,MediaReturn mr){
		
		LogBean logers = new LogBean();
		logers.setUser("1");
		logers.setModel(model);
		logers.setOperater(operater);
		logers.setObj(obj);
		logers.setContext(context);
		logers.setResponse(response);
		
		if (mr!=null) {
			logers.setStatus(mr.getStatus()+"");
			logers.setResponse(mr.getRefuseReason()+":"+response);
		}else {
			logers.setStatus(Constants.API_REQFAIL+"");	
		}
		LogBean logBean = ibatisDao.get("loggerSqlMapper.findLogerId", logers);
		if(logBean!=null){
			logers.setId(logBean.getId());
			ibatisDao.save("loggerSqlMapper.updateLoger", logers);
		}else{
			ibatisDao.save("loggerSqlMapper.insertLoger", logers);
		}
	}
	
}
