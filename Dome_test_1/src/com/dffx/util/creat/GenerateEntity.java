package com.dffx.util.creat;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.DriverManager;
//import java.sql.Connection;
//import java.util.ArrayList;
//import java.util.List;

/**
 * 生成实体类
 * @author huangxing
 *
 */
public class GenerateEntity {

//	private String url = "jdbc:mysql://192.168.1.123:3306/dffx_db_ifazai";
//	private String username = "root";
//	private String password = "12345";
//	private String driverClass = "com.mysql.jdbc.Driver";
//	private DatabaseMetaData dbMetaData = null;
	private String packageName = "com.csair.test.dto;";
	private String path = "E:\\office\\com\\Entity\\";

	/**
	 * @Description: 获取表对应的所有列
	 * @author: ppt
	 * @date: 2015-3-16 上午10:13:17
	 * @param tableName
	 * @return: void
	 */
	public void getTableColumns(String tableName,DatabaseMetaData dbMetaData) {
		try {
			String ACCESS_DOMAIN = "private";
			ResultSet resultSet = dbMetaData.getColumns(null, null, tableName, "%");
			while (resultSet.next()) {
				ResultSet resultSetColumn = dbMetaData.getColumns(null, null, tableName, null);
				// String className = getFormatString(tableName, true);
				String className = Generate.getTablieName(tableName, true);
				StringBuffer header = new StringBuffer("package " + packageName + "\n\n");
				StringBuffer footer = new StringBuffer();
				StringBuffer contentBuffer = new StringBuffer();
				contentBuffer.append("public class " + className + "{\n");
				while (resultSetColumn.next()) {
					contentBuffer.append("\t" + ACCESS_DOMAIN + " ");
					String columnType = resultSetColumn.getString("TYPE_NAME");
					String COLUMN_TYPE = getColumnType(columnType);
					if ("Date".equals(COLUMN_TYPE)) {
						header.append("import java.util.Date;\n");
					}
					contentBuffer.append(COLUMN_TYPE + " ");
					String columnName = resultSetColumn.getString("COLUMN_NAME");
					String remark = resultSetColumn.getString("REMARKS");
					columnName = Generate.getFormatString(columnName, false);
					footer.append(getSetGenerater(columnName, COLUMN_TYPE));
					contentBuffer.append(columnName + ";\t//" + remark + "\n");
				}
				contentBuffer.append("\n\n" + footer);
				contentBuffer.append("}");
				header.append("\n");
				header.append(contentBuffer);
				Generate.outputToFile(className + ".java", header.toString(),path);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	public GenerateEntity() {
//		try {
//			Class.forName(driverClass);
//			Connection conn = DriverManager.getConnection(url, username, password);
//			dbMetaData = conn.getMetaData();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

//	/**
//	 * @Description: 获取所以的表
//	 * @author: ppt
//	 * @date: 2015-3-16 上午10:12:57
//	 * @return: void
//	 */
//	public List<String> getAllTableList() {
//		List<String> tableList = new ArrayList<String>();
//		try {
//			String[] types = { "TABLE" };
//			ResultSet rs = dbMetaData.getTables(null, null, "%", types);
//			while (rs.next()) {
//				String tableName = rs.getString("TABLE_NAME"); // 表名
//				tableList.add(tableName);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return tableList;
//	}

	

//	/**
//	 * 把String内容写到文件
//	 * 
//	 * @param fileName
//	 * @param content
//	 */
//	private void outputToFile(String fileName, String content) {
//		OutputStream os = null;
//		try {
//			os = new FileOutputStream(path + fileName);
//		} catch (FileNotFoundException e1) {
//			e1.printStackTrace();
//		}
//		byte[] b = content.getBytes();
//		try {
//			os.write(b);
//			os.flush();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				os.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}

	/**
	 * 数据库类型转为java类型
	 * 
	 * @param column
	 * @return
	 */
	private String getColumnType(String column) {
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

	private String getSetGenerater(String columnName, String columnType) {
		StringBuffer sb = new StringBuffer();
		sb.append("\tpublic " + columnType + " get" + columnName.substring(0, 1).toUpperCase()
				+ columnName.substring(1, columnName.length()) + "() {\n");
		sb.append("\t\treturn " + columnName + ";\n");
		sb.append("\t}\n\n");
		sb.append("\tpublic void set" + columnName.substring(0, 1).toUpperCase() + columnName.substring(1, columnName.length()));
		sb.append("(" + columnType + " " + columnName + ") {\n");
		sb.append("\t\tthis." + columnName + " = " + columnName + ";\n");
		sb.append("\t}\n\n");
		return sb.toString();
	}

//	public static void main(String[] agrs) {
//		GenerateEntity aa = new GenerateEntity();
//		List<String> tableList = aa.getAllTableList();
//		for (String tableName : tableList) {
//			aa.getTableColumns(tableName);
//		}
//		// aa.getTableColumns("REPORT_REQ");
//
//	}

}
