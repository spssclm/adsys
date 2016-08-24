package com.cloudcross.adcross.model;

import java.util.Date;
/* 该类实现日志记录字段
 * 目前支持接口发送日志、排期修改
 */
public class LogBean {

	private Long id;
	private String model;
	private String operater;
	private String obj;
	private String user;
	private String context;
	private String status;
	private Date updated;
	private String response;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getOperater() {
		return operater;
	}
	public void setOperater(String operater) {
		this.operater = operater;
	}
	public String getObj() {
		return obj;
	}
	public void setObj(String obj) {
		this.obj = obj;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}

}
