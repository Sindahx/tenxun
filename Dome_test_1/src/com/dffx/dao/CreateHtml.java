package com.dffx.dao;

import java.util.ArrayList;

import com.dffx.dto.TabHost;

public interface CreateHtml {
	
	/**
	 * 生成路标
	 * @param h2
	 * @param h1
	 * @return
	 */
	public String createPointer(String h2,String h1);
	
	/**
	 * 生成头
	 * @return
	 */
	public String createHead();
	
	/**
	 * 生成内容div
	 * @return
	 */
	public String createConterDiv();
	
	/**
	 * 生成tab选项卡
	 * @param list
	 * @return
	 */
	public String tabHost(ArrayList<TabHost> list);

}
