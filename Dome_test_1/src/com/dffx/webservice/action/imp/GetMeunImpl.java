package com.dffx.webservice.action.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dffx.dto.WebBaseRespose;
import com.dffx.service.add.AddMeunList;
import com.dffx.webservice.WebConstansCode;
import com.dffx.webservice.action.GetMeun;

@Controller
public class GetMeunImpl implements GetMeun {

	@Autowired
	private AddMeunList addmeunlist;
	
	@RequestMapping("/getH1Meun")
	@ResponseBody
	public WebBaseRespose getH1Meun(){
		
		WebBaseRespose web = new WebBaseRespose();
		List<Object> list = addmeunlist.getH1Meun();
		web.setAsk(WebConstansCode.ERR_CODE_SUCCESS);
		web.setErrorCode(WebConstansCode.SOAP_OK);
		web.setErrorMessage(WebConstansCode.SOAP_SUCCESS);
		web.setResultCode(list);
		
		return web;
		
	}

	@RequestMapping("/getH2Meun")
	@ResponseBody
	public WebBaseRespose getH2Meun(String h1Id) {
		// TODO Auto-generated method stub
		
		WebBaseRespose web = new WebBaseRespose();
		
		List<Object> list = addmeunlist.getH2Meun(h1Id);
		
		web.setAsk(WebConstansCode.ERR_CODE_SUCCESS);
		web.setErrorCode(WebConstansCode.SOAP_OK);
		web.setErrorMessage(WebConstansCode.SOAP_SUCCESS);
		web.setResultCode(list);
		
		return web;
		
	}

}
