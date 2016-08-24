package com.cloudcross.adcross.mediaapi;

public class MediaReturn {

	private String response;
	private String status;
	private String refuseReason;
	private String request;

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRefuseReason() {
		return refuseReason;
	}

	public void setRefuseReason(String refuseReason) {
		this.refuseReason = refuseReason;
	}
	
	public String toString() {
		return "mediaReturn\n[status]=>" + status + "\n[response]=> " + response + "\n[refuseReason]=> " + refuseReason;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}
}
