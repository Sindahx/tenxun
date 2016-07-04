package com.dffx.servlet;

public class DataSourceInstances {
	public static  String Business = "dataSourceBusiness";
	public static  String Message  = "dataSourceMessage";
	
	public static void setInstances(String business,String message)
	{
         Business = business;
         Message  = message;
	}
    
	public static String[] getInstances()
	{
		  String ins[] = {Business,Message};		 
		  return ins;
    }
	

	
	
	
}
