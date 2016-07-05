package com.dffx.service.add.impl;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.dffx.dto.H1Meun;
import com.dffx.dto.H2Meun;
import com.dffx.service.BaseClass;
import com.dffx.service.add.AddMeunList;
import com.dffx.util.SystemPath;

@Service("addmeunlist")
public class AddMeunListImpl extends BaseClass implements AddMeunList {

	@Override
	public String addH1Meun(String itemName, String address) {
		// TODO Auto-generated method stub

		String path = SystemPath.getCurrentPath();

		Document doc = getHtmlIndex();
		boolean wrin = false;
		try {

			Elements ele = doc.getElementsByClass("sidebar-menu");

			ele.append("<li class=\"header\">测试项目</li> ");
			ele.append("<li><a class=\"my_net\" href=\"JavaScript:void(0)\" mynet=\"pages/" + address
					+ ".html\"><i class=\"fa fa-circle-o\"></i>" + itemName + "</a></li>");
			ele.append("");
			// <li><a class="my_net" href="JavaScript:void(0)"
			// mynet="pages/amount-paid.html"><i class="fa fa-circle-o"></i>
			// 支付限额</a></li>
			wrin = SystemPath.wrint1(path + "test.html", doc.toString());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (wrin) {
			return "成功";
		} else {

			return "失败";
		}
	}

	@Override
	public String addH2Meun() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getH1Meun() {
		// TODO Auto-generated method stub

		Document doc = getHtmlIndex();

		List<Object> list = new ArrayList<Object>();

		try {

			Elements ele = doc.getElementsByClass("treeview");

			for (int i = 0; i < ele.size(); i++) {

				H1Meun h1 = new H1Meun();

				Element element = doc.getElementById("treeview_" + i);

				Elements tag = element.getElementsByTag("span");
				String menu = tag.first().text();

				h1.setId("treeview_" + i);
				h1.setValue(menu);
				list.add(h1);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	@Override
	public String setMeunId() {
		// TODO Auto-generated method stub

		String path = SystemPath.getCurrentPath();
		Document doc = getHtmlIndex();
		try {

			Elements ele = doc.getElementsByClass("treeview");

			for (int i = 0; i < ele.size(); i++) {
				Element element = ele.get(i);
				element.attr("id", "treeview_" + i);
			}

			SystemPath.wrint1(path + "test.html", doc.toString());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "成功";
	}

	@Override
	public List<Object> getH2Meun(String h1Id) {
		// TODO Auto-generated method stub
		Document doc = getHtmlIndex();

		List<Object> list = new ArrayList<Object>();
		
		Element element = doc.getElementById(h1Id);
		Elements ele = element.getElementsByClass("my_net");
		
		for (Element element2 : ele) {
			
			H2Meun menu = new H2Meun();
			String value = element2.text();
			String mynet = element2.attr("mynet");
			menu.setMynet(mynet);
			menu.setValue(value);
			list.add(menu);
		}

		return list;
	}

}
