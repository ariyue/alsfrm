package com.als.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.context.MessageSource;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.als.frm.bas.ddl.RstMsgType;
import com.als.frm.bas.ddl.RstType;
import com.als.frm.comm.dto.AppData;
import com.als.frm.comm.dto.ExceptionInfoVO;
import com.als.frm.comm.dto.RstData;
import com.als.frm.comm.dto.RstMsg;
import com.als.frm.comm.util.LogHelper;
import com.als.frm.comm.util.MessageUtil;
import com.als.frm.ex.AppException;
import com.als.lcs.LicenseVerifier;
import com.als.web.action.rst.MsgRst;
import com.als.web.action.rst.RstBuilder;

public class WebDispatcher extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		request.setCharacterEncoding("UTF-8");  
		String lookResult[] = ActionLooker.look(request);
		String value = lookResult[1];
		if(value!=null&&!value.equals(""))
		{
			
			
			
			String valueclass=value.substring(0, value.lastIndexOf("."));//取得类型字符串 com.yht.action.haha
			String valuemethod=value.substring(value.lastIndexOf(".")+1);//取得方法名     
			try {
				runMode();
				Class clazz=Class.forName(valueclass);
				
				//加载上下文----------------------
				ActionContext context = new ActionContext();
				context.setRequest(request);
				context.setResponse(response);
				context.setServletContext(this.getServletContext());
				Method md =clazz.getMethod("setActionContext", ActionContext.class);
				Object o=clazz.newInstance();//根据类型和方法名字符串进行调用
				md.invoke(o, context);
				//加载上下文----------------------
				
				//原来的，现在都改成只有AppData
				//Method method=clazz.getMethod(valuemethod, HttpServletRequest.class,HttpServletResponse.class);
				//Object obj=method.invoke(o, request,response);
				
				// TODO 从request中获取并生成AppData数据
				AppData appData = new AppData();
				//通过session取得----
				appData.setUnitId("sdev");
				appData.setUnitName("软件开发部");
				appData.setUserId("Vincent");
				appData.setUserName("陈卓");
				//通过session取得 end----
				//获取requeest参数列表
				Map map = request.getParameterMap();
		        for(Iterator iter = map.entrySet().iterator();iter.hasNext();){ 
		            Map.Entry element = (Map.Entry)iter.next(); 
		            String key = String.valueOf(element.getKey());
		            appData.setValue(key, request.getParameter(key));
		          }
		        
		        //验证session及其它用户权限验证
		        SecurityChecker sc = SecurityChecker.getInstance();
		        sc.check(appData);
		        //验证session及其它用户权限验证 end
		        
				response.setContentType("application/x-json");
				request.setCharacterEncoding( "utf-8" );
				response.setCharacterEncoding( "utf-8" );
				try {
					
					  // 处理前------
			        md =clazz.getMethod("preHandle", AppData.class);
			        md.invoke(o, appData);
			        // 处理前 end------
			        
			        
					Method method=clazz.getMethod(valuemethod, AppData.class);
					
					Object result = method.invoke(o, appData);
					
					//处理结果
					RstBuilder.build(request, response, result);
					/*PrintWriter out = response.getWriter();
					
					RstData rstData = new RstData();
					rstData.setResult(result);
					rstData.setCode(rstData.CODE_4_RIGHT);
					JSONObject resultJSON = new JSONObject();// 构建一个JSONObject

					resultJSON.accumulate("resultData", rstData);
					response.setContentType("application/x-json");// 需要设置ContentType
																	// 为"application/x-json"
					out.println(resultJSON.toString());// 向客户端输出JSONObject字符串
					out.flush();
					out.close();*/
				} catch (Exception e) {
					//response.setStatus(300);
		            if (e instanceof NoSuchMethodException){
		            	//String errorMsg = "AlsFramework的mvc反射时找不到方法\""+actionInfoVo.getMethod()+"\"，可能原因：1 请确认BaseWeb只能是进行一维续承！ 2.配置aliceweb.xml文件时指定包、类、方法名时有误。";
		            	//this.buildReturnString(response, "1", ExceptionCode.SYS_NO_SUCH_METHOD, errorMsg, "");
		            	
		            	//String errMsg = this.generalI18nMsg("err.sys.10008", new Object[]{clazz.getName(),valuemethod});
		            	//LogHelper.error(errMsg, e);
		            	//this.buildReturnString(response, "1", "err.sys.10008", errMsg, "");
		            	
		            	this.buildErrorRst(request, response, "err.sys.10008", new Object[]{clazz.getName(),valuemethod});
		                return;
		            }
		            InvocationTargetException targetException = (InvocationTargetException) e;
		            if(targetException.getTargetException() instanceof AppException)
		            {
		                AppException ex = (AppException) targetException.getTargetException();
		                ExceptionInfoVO exvo  = ex.getExceptionInfoVO();
		                String errorMsg = exvo.getMsg();
		            	//this.buildReturnString(response, "1", exvo.getCode(), errorMsg, "");
		            	String code = exvo.getCode();
		            	
		            	this.buildErrorRst(request, response, errorMsg, code);
		                return;
		            }
		            
		            //未捕获的异常
		            Exception ex = (Exception) targetException.getTargetException();
		            String sysErrCode = "";
		            if(ex instanceof IOException)
		    		{
		            	sysErrCode = "err.sys.10005";
		    		}
		    		else if(ex instanceof NullPointerException)
		    		{
		    			sysErrCode = "err.sys.10003";
		    		}
		    		else if(ex instanceof ClassNotFoundException)
		    		{
		    			sysErrCode = "err.sys.10006";
		    		}
		    		else if(ex instanceof NumberFormatException)
		    		{
		    			sysErrCode = "err.sys.10002";
		    		}
		    		else
		    		{
		    			sysErrCode = "err.sys.10004";
		    		}
		            String errMsg = this.generalI18nMsg(sysErrCode, new Object[]{});
		            this.buildErrorRst(request, response, errMsg + "\r\n" +  ex.getMessage()+ "\r\n更多错误信息请查看后台日志。", "err");
		            LogHelper.writeInLog(ex);
				}
	            
	            
	            
				/*if(obj!=null)
				{
					request.getRequestDispatcher((String)result).forward(request, response);
				}*/
			} catch (Exception e) {
	            if(e instanceof AppException)
	            {
	                ExceptionInfoVO exvo  = ((AppException)e).getExceptionInfoVO();
	                String errorMsg = exvo.getMsg();
	            	//this.buildReturnString(response, "1", exvo.getCode(), errorMsg, "");
	            	
	            	this.buildErrorRst(request, response, errorMsg, exvo.getCode());
	                return;
	            }else {
	            	this.buildErrorRst(request, response, e.getMessage(), "err");
	            	return;
	            }
			}
		} else {
			String url = lookResult[0];
			String actionName = url.split("/")[0];
			String methodName = url.split("/")[1];
			String errMsg = this.generalI18nMsg("err.als.03000", new Object[]{actionName,methodName});
			LogHelper.error(errMsg , new AppException());
        	//this.buildReturnString(response, "1", "err.als.03000", errMsg, "");
        	
        	this.buildErrorRst(request, response, "err.als.03000", new Object[]{actionName,methodName});
            return;
		}
	}
	
	
	private void buildErrorRst(HttpServletRequest request, HttpServletResponse response, String msgCode,Object[] msgParams){
		
		RstMsg rstMsg = new RstMsg();
		rstMsg.setMsgCode(msgCode);
		rstMsg.setMsgParams(msgParams);
		//'info','warning','error'
		RstMsgType tp = RstMsgType.error;
		if (msgCode.indexOf("warning")  == 0){
			tp = RstMsgType.warning;
		} else if(msgCode.indexOf("info")  == 0){
			tp = RstMsgType.info;
		} 
		rstMsg.setMsgType(tp);
		MsgRst r = new MsgRst();
		r.build(request, response, rstMsg);
	}
	
	private void buildErrorRst(HttpServletRequest request, HttpServletResponse response, String msgStr, String code){
		
		PrintWriter out;
		try {
			out = response.getWriter();
			RstData rstData = new RstData();
			
			RstMsgType tp = RstMsgType.error;
			if (code.indexOf("warning")  == 0){
				tp = RstMsgType.warning;
			} else if(code.indexOf("info")  == 0){
				tp = RstMsgType.info;
			} 
			rstData.setRstType(RstType.msgWin);
			JSONObject resultJSON = new JSONObject();// 构建一个JSONObject
			Map newRst = new HashMap(2);
			newRst.put("msg", msgStr);
			newRst.put("winType", tp);
			rstData.setResult(newRst);
			resultJSON.accumulate("resultData", rstData);
			response.setContentType("application/x-json");// 需要设置ContentType
			// 为"application/x-json"
			out.println(resultJSON.toString());// 向客户端输出JSONObject字符串
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void init(ServletConfig config) throws ServletException {
	    super.init(config);
	    SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
	      config.getServletContext());
	}
	
	public String generalI18nMsg(String key, Object[] params) {
		//不在采用直接获取bean的方式，通过统一接口MessageUtil进行国际化20151026
		//MessageSource messageSource = (MessageSource) this.getBean("messageSource");
		//return "【"+ key +"】" + messageSource.getMessage(key, params, Locale.CHINESE);
		return MessageUtil.getMessage(key, params, false);
	}
	
	public Object getBean(String beanName) {
		ServletContext application =this.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(application);
		return context.getBean(beanName);
	}
	
	static class CharsetGen{
		private String charset;
		public String getContentType() {
			return contentType;
		}
		private String contentType;
		
		private static  CharsetGen instance;
		private CharsetGen(ServletContext application){
			if(charset == null){
				charset = System.getProperty("encode");
			}
			contentType = "text/html;charset=" + charset;
		}
		public String getCharset(){
			return this.charset;
		}
		public static CharsetGen getInstance(ServletContext application){
			if (instance == null){
				instance = new CharsetGen(application);
			}
			return instance;
		}
		
		
	} 
	
	/**
	 * 运行模式
	 */
	private void runMode(){
		List<String> args3 = ManagementFactory.getRuntimeMXBean().getInputArguments();
		boolean isDebug = false;
		for (String arg : args3) {
		  if (arg.startsWith("-Xrunjdwp") || arg.startsWith("-agentlib:jdwp")) {
		    isDebug = true;
		    break;
		  }
		}
		if (isDebug){
			LicenseVerifier v = new LicenseVerifier();
			//v.check();
		    System.out.println("debuging...xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.........");
		   // System.exit(0);
		}else {
		    System.out.println("running....xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx........");
		}
	}

}
