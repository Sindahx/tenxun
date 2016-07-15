package com.dffx.service.add;

import java.util.List;

import com.dffx.dto.H1Meun;

public interface AddMeunList {

	/**
	 * 增加左侧一级菜单
	 * @param itemName
	 * @param address
	 * @return
	 */
	public String addH1Meun(String itemName,String address);
	
	/**
	 * 增加左侧二级菜单
	 * @return
	 */
	public String addH2Meun();
	
	/**
	 * 获取一级菜单
	 * @return
	 */
	public List<Object> getH1Meun();
	
	/**
	 * 获取二级菜单
	 * @param h1Id
	 * @return
	 */
	public List<Object> getH2Meun(String h1Id);
	
	/**
	 * 给菜单增加id属性
	 * @return
	 */
	public String setMeunId();
	
	/**
	 * 增加内容
	 * @return
	 */
	public String addConter();
}
