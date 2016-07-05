package com.dffx.service;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.dffx.util.SystemPath;

public class BaseClass {

	public Document getHtmlIndex() {

		
		String path = SystemPath.getCurrentPath();
		File in = new File(path + "index.html");
		Document doc = null;

		try {
			doc = Jsoup.parse(in, "UTF-8", "");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return doc;
	}

}
