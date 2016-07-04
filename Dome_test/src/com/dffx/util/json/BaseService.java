package com.dffx.util.json;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class BaseService{
   
	private static Logger log = Logger.getLogger(BaseService.class);
	
	
    
    /***
     * 类型装换发送接口
     * @param obj
     * @return
     */
    public static String sendValueAsString(Object obj,String message){
    	String json = null;
    	ObjectMapper mapper = new ObjectMapper();
    	
    	 try {
    		 json = mapper.writeValueAsString(obj);
    		 if(json != null){
    			 json = json.replaceAll("null", "\"\"");
    		 }
//    		 System.err.println(json);
		} catch (JsonGenerationException e) {
			log.error(e.getMessage()+":"+message+":发送bean转换json格式异常");
		} catch (JsonMappingException e) {
			log.error(e.getMessage()+":"+message+":发送bean转换json格式映射bean异常");
		} catch (IOException e) {
			log.error(e.getMessage()+":"+message+":发送bean转换json流异常");
		}
    	 
    	 return json;
    }
  
}
