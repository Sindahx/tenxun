package com.dffx.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 拦截器，检查用户的权限，如果没有则拦截其访问
 * @author tongyicheng
 *
 */
public class AuthInterceptor implements HandlerInterceptor {
	private static final Logger logger=Logger.getLogger(AuthInterceptor.class);
	private  List<String>registerUrls;//注入允许通过的url，登录前
	
	public List<String> getRegisterUrls() {
		return registerUrls;
	}

	public void setRegisterUrls(List<String> registerUrls) {
		this.registerUrls = registerUrls;
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object obj, Exception e)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

//	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 在调用controller方法之前拦截
	 * @param request 获得请求的url信息
	 */
//	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object obj) throws Exception {
		
		String uri=request.getRequestURI();//获取请求的uri
		uri=uri.substring(uri.indexOf("/", 1)+1);//截取uri的后面一部分
		String[] resturl=uri.split("/");//如果是rest风格的请求方式由于参数是url的一部分,所以url是不固定的，因此要截取掉参数那一部分后的值作为url
		uri=resturl[0]+"/"+resturl[1];
		if(resturl.length >= 3){
			uri+="/"+resturl[2];
		}
		
		logger.info(uri);
		//beforeLoginUrls中存取登录前不需要被拦截的url如登录url，验证用户url
		if(registerUrls.contains(uri)){
			return true;
		}
		
		return false;
	}

	

}