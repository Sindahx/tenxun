package com.dffx.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class SystemPath {

	public static String getCurrentPath() {

		String rootPath = System.getProperty("user.dir"); // 显示的是%Tomcat_Home%/bin

		File file = new File(rootPath);

		String path = file.getParent().toString();

		path = path.endsWith("\\") ? path : path + "\\";

		return path+"webapps/Dome_test_1/";

	}

	public static void wrint(String path, String content) {
		// String xml = "";
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

	public static boolean wrint1(String path, String content) {
		String FileContent = content;
		try {
			FileOutputStream fos = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			osw.write(FileContent);
			osw.flush();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
