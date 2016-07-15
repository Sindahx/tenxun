package com.dffx.dao.impl;

import java.util.ArrayList;

import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import com.dffx.dao.CreateHtml;
import com.dffx.dto.TabHost;

@Service("createHtmlImpl")
public class CreateHtmlImpl implements CreateHtml {

	@Override
	public String createHead() {
		// TODO Auto-generated method stub

		String div = "<div class=\"callout callout-info\">" + "<h4>Hint!</h4>"
				+ "<p>本流程：由 <a href=\"#\" target=\"_blank\"><b>@xxx(xxx)</b></a>  编辑，若发现有误，请及时与他联系，谢谢你的支持！</p>"
				+ "</div>";

		return div;
	}

	@Override
	public String createPointer(String h2, String h1) {
		// TODO Auto-generated method stub
		
		String div = "<section class=\"content-header\">"+
          "<h1>"+h2+"</h1>"+
          "<ol class=\"breadcrumb\">"+
            "<li><a href=\"index.html\"><i class=\"fa fa-dashboard\"></i> 首页</a></li>"+
            "<li>"+h1+"</li>"+
            "<li class=\"active\">"+h2+"</li>"+
          "</ol>"+
        "</section>";
		
		return div;
	}

	@Override
	public String createConterDiv() {
		// TODO Auto-generated method stub
		
		String div="<div class=\"box box-primary animated fadeInRight\" style=\"border:0\">"+
            "<div class=\"nav-tabs-custom\">"+
            "<ul class=\"nav nav-tabs\">"+            
            "</ul>"+
            "<div class=\"tab-content\">"+
            "<div class=\"active tab-pane\" id=\"query\">"+
             "<div class=\"exp-content\">"+              
              "</div>"+
            "</div>"+
          "</div>"+
          "</div>"+
          "</div>";
		
		return div;
	}

	@Override
	public String tabHost(ArrayList<TabHost> list) {
		// TODO Auto-generated method stub
		
		Element ele = new Element(null, "<div>");
		
		ele.append("<li class=\"active\"><a href=\"#"+list.get(0).getTabLink()+"\" data-toggle=\"tab\">"+list.get(0).getTabValue()+"</a></li>");
		
		for (int i = 1; i < list.size(); i++) {
			ele.append("<li class=\"active\"><a href=\"#"+list.get(i).getTabLink()+"\" data-toggle=\"tab\">"+list.get(i).getTabValue()+"</a></li>");
		}
		
		
		
		return null;
	}
	
	

}
