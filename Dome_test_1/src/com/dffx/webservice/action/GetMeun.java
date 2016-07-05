package com.dffx.webservice.action;

import com.dffx.dto.WebBaseRespose;

public interface GetMeun {

	/**
	 * 获取一级菜单
	 * @return
	 */
	public WebBaseRespose getH1Meun();
	
	/**
	 * 获取二级菜单
	 * @param h1Id
	 * @return
	 */
	public WebBaseRespose getH2Meun(String h1Id);
}
