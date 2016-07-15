package com.dffx.util.creat;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Generate {
	
	private String url = "jdbc:mysql://192.168.1.123:3306/dffx_db_ifazai";
	private String username = "root";
	private String password = "12345";
	private String driverClass = "com.mysql.jdbc.Driver";
		
	public DatabaseMetaData dbMetaData = null;
	
	/**
	 * 处理表名字符串,前面的dffx_ifazai这一节去掉,并且把下划线的下一个字符变大写，flag为true，表示首字母要大写
	 * @param name
	 * @param flag
	 * @return
	 */
	public static String getTablieName(String name, boolean flag) {
		name = name.toLowerCase();
		String[] nameTemp = name.split("_");
		StringBuffer buffer = new StringBuffer();		
		for (int i = 2; i < nameTemp.length; i++) {
			String head = nameTemp[i].substring(0, 1).toUpperCase();
			String tail = nameTemp[i].substring(1);
			buffer.append(head + tail);
		}
		StringBuffer result = null;
		if (!flag) {
			result = new StringBuffer();
			String head = buffer.substring(0, 1).toLowerCase();
			String tail = buffer.substring(1);
			result.append(head + tail);
			return result.toString();
		}
		return buffer.toString();
	}

	/**
	 * 处理列名字符串，去掉下划线“_”，并且把下划线的下一个字符变大写，flag为true，表示首字母要大写
	 * 
	 * @param name
	 * @param flag
	 * @return
	 */
	public static String getFormatString(String name, boolean flag) {
		name = name.toLowerCase();
		String[] nameTemp = name.split("_");
		StringBuffer buffer = new StringBuffer();
		for (String str : nameTemp) {
			String head = str.substring(0, 1).toUpperCase();
			String tail = str.substring(1);
			buffer.append(head + tail);
		}
		StringBuffer result = null;
		if (!flag) {
			result = new StringBuffer();
			String head = buffer.substring(0, 1).toLowerCase();
			String tail = buffer.substring(1);
			result.append(head + tail);
			return result.toString();
		}
		return buffer.toString();
	}
	
	/** 
     * 把String内容写到文件 
     * @param fileName 
     * @param content 
     */  
	public static void outputToFile(String fileName, String content,String path) {  
        OutputStream os = null;  
        try {  
            os = new FileOutputStream(path+fileName);  
        } catch (FileNotFoundException e1) {  
            e1.printStackTrace();  
        }  
        byte[] b = content.getBytes();  
        try {  
            os.write(b);  
            os.flush();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                os.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
	
	/**
	 * 数据库类型转为java类型
	 * 
	 * @param column
	 * @return
	 */
	public static String getColumnType(String column) {
		String COLUMN_TYPE = null;
		if ("VARCHAR".equals(column)) {
			COLUMN_TYPE = "String";
		} else if ("BIGINT".equals(column)) {
			COLUMN_TYPE = "Long";
		} else if ("DATETIME".equals(column)) {
			COLUMN_TYPE = "Date";
		} else if ("INT".equals(column) || "INT UNSIGNED".equals(column)) {
			COLUMN_TYPE = "Integer";
		} else if ("BIGINT UNSIGNED".equals(column)) {
			COLUMN_TYPE = "Long";
		} else if ("TINYINT UNSIGNED".equals(column)) {
			COLUMN_TYPE = "Integer";
		} else if ("DECIMAL".equals(column) || "FLOAT".equals(column) || "DOUBLE".equals(column)) {
			COLUMN_TYPE = "BigDecimal";
		} else if ("TEXT".equals(column) || "MEDIUMTEXT".equals(column) || "LONGTEXT".equals(column)) {
			COLUMN_TYPE = "String";
		} else if ("TIMESTAMP".equals(column) || "DATE".equals(column) || "DATETIME".equals(column)) {
			COLUMN_TYPE = "Date";
		} else if ("TINYINT".equals(column)) {
			COLUMN_TYPE = "Integer";
		} else if ("DECIMAL UNSIGNED".equals(column)) {
			COLUMN_TYPE = "BigDecimal";
		} else if ("SMALLINT".equals(column)) {
			COLUMN_TYPE = "Integer";
		} else if ("BIT".equals(column)) {
			COLUMN_TYPE = "Integer";
		} else if ("CHAR".equals(column)) {
			COLUMN_TYPE = "String";
		} else if ("VARBINARY".equals(column)) {
			COLUMN_TYPE = "byte";
		} else if ("BLOB".equals(column)) {
			COLUMN_TYPE = "byte";
		}
		return COLUMN_TYPE;
	}
	
	/**
	 * @Description: 获取所以的表
	 * @author: ppt
	 * @date: 2015-3-16 上午10:12:57
	 * @return: void
	 */
	public List<String> getAllTableList() {
		List<String> tableList = new ArrayList<String>();
		try {
			String[] types = { "TABLE" };
			ResultSet rs = dbMetaData.getTables(null, null, "%", types);
			while (rs.next()) {
				String tableName = rs.getString("TABLE_NAME"); // 表名
				tableList.add(tableName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tableList;
	}
	
	public Generate() {
		try {
			Class.forName(driverClass);
			Connection conn = DriverManager.getConnection(url, username, password);
			dbMetaData = conn.getMetaData();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		
		Generate generate = new Generate();
		List<String> tableList = generate.getAllTableList();
		
		
		
		GenerateEntity entity = new GenerateEntity();
		for (String tableName : tableList) {
			entity.getTableColumns(tableName,generate.dbMetaData);
		}
		
		GenerateMybatisRepository mybatis = new GenerateMybatisRepository();
		mybatis.getService(tableList);
		
		GenerateMybatisXml xml = new GenerateMybatisXml();
		for(String tableName : tableList) {
			xml.getTableColumns(tableName,generate.dbMetaData);
		}
		
		GenerateService service = new GenerateService();
		service.getService(tableList);
		
		GenerateServiceImpl serviceImpl = new GenerateServiceImpl();
		serviceImpl.getServiceImpl(tableList);
		
	}
	
}
