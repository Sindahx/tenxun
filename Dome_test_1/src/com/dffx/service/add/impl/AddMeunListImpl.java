package com.dffx.service.add.impl;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.dffx.service.add.AddMeunList;
import com.dffx.util.SystemPath;

@Service("addmeunlist")
public class AddMeunListImpl implements AddMeunList {

	@Override
	public String addH1Meun() {
		// TODO Auto-generated method stub

		String path = SystemPath.getCurrentPath();

		File in = new File(path + "index.html");

		Document doc = null;
		boolean wrin = false;
		try {
			doc = Jsoup.parse(in, "UTF-8", "");

			Elements ele = doc.getElementsByClass("sidebar-menu");

			// Element element = new Element();
			//			
			// element.append(html)

			ele.append("<li class=\"header\">测试项目</li> ");
			ele.append("<li class=\"header\">测试项目2</li> ");
			wrin = SystemPath.wrint1(path + "test.html", doc.toString());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (wrin) {
			return "成功";
		}else{
			
			return "失败";
		}
	}

}
