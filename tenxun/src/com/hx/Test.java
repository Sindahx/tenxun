package com.hx;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test {

	public static void main(String[] sgrs) {

		String path = new Test().getCurrentPath();

//		System.err.println(path);
		File in = new File(path + "index.html");

		try {
			Document doc = Jsoup.parse(in, "UTF-8", "");
			
			Elements ele = doc.getElementsByClass("sidebar-menu");
			
//			Element element = new Element();
//			
//			element.append(html)
			
			
			
			ele.append("<li class=\"header\">测试项目</li> ");
			
			
			wrint(path+"test.html", doc.toString());
			
			System.err.println(doc.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getCurrentPath() {
		// 取得根目录路径
		String rootPath = getClass().getResource("/").getFile().toString();
		// 当前目录路径
		String currentPath1 = getClass().getResource(".").getFile().toString();
		String currentPath2 = getClass().getResource("").getFile().toString();
		// 当前目录的上级目录路径
		String parentPath = getClass().getResource("../").getFile().toString();

		String parentPath2 = getClass().getResource("../").getFile().toString();

		File file = new File(new File(rootPath).getParent());

		String path = file.getParent().toString();

		path = path.endsWith("\\") ? path : path + "\\";

		return path;

	}
	
    public static void wrint(String path,String content) {  
//        String xml = "";  
        byte[] bytexml = content.getBytes();  
          
        try {  
            OutputStream os = new FileOutputStream(new File(path));
            os.write(bytexml);  
            os.flush();  
            os.close();  
        } catch (FileNotFoundException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }  
}  
	
