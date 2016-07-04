package com.dffx.dto;

import java.util.List;


public class WebBaseRespose{
	private Integer ask;//成功应答
	private Integer errorCode;//应答码
	private String errorMessage;//应答信息
	
	private List<Object> resultCode;// 返回数据
	

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public Integer getAsk() {
		return ask;
	}
	public void setAsk(Integer ask) {
		this.ask = ask;
	}

//	public Map<Object, Object> getResultCode() {
//		return resultCode;
//	}
//
//	public void setResultCode(Map<Object, Object> resultCode) {
//		this.resultCode = resultCode;
//	}

	

	public List<Object> getResultCode() {
		return resultCode;
	}

	public void setResultCode(List<Object> resultCode) {
		this.resultCode = resultCode;
	}
	
	
	
}
