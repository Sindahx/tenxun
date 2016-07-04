package com.dffx.webservice.action.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dffx.service.add.AddMeunList;
import com.dffx.webservice.action.Add;


@Controller
public class AddImpl implements Add {

	@Autowired
	private AddMeunList addmeunlist;
	
	@RequestMapping(value="/test",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getTest(){
		
		String str = addmeunlist.addH1Meun();
		
		return str;
	}

	@RequestMapping("/addMeun")
	@ResponseBody
	public String addMeunList() {
		// TODO Auto-generated method stub
		String str = addmeunlist.addH1Meun();
		
		return str;
	}
	
}
