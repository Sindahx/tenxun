package com.dffx.webservice.action.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dffx.dto.H1Meun;
import com.dffx.dto.WebBaseRespose;
import com.dffx.service.add.AddMeunList;
import com.dffx.webservice.WebConstansCode;
import com.dffx.webservice.action.Add;


@Controller
public class AddImpl implements Add {

	@Autowired
	private AddMeunList addmeunlist;
	
	@RequestMapping(value="/test",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getTest(String itemName,String address){
		
		String str = addmeunlist.addH1Meun(itemName,address);
		
		return str;
	}

	@RequestMapping("/addMeun")
	@ResponseBody
	public String addMeunList(String itemName,String address) {
		// TODO Auto-generated method stub
		String str = addmeunlist.addH1Meun(itemName,address);
		
		return str;
	}

	@RequestMapping("/setId")
	@ResponseBody
	public String setMeunId() {
		// TODO Auto-generated method stub
		addmeunlist.setMeunId();
		return "success";
	}
	
	
	
}
