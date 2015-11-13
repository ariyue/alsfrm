package com.als.frm.ex;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.als.frm.comm.dto.ExceptionInfoVO;
import com.als.frm.comm.util.MessageUtil;

/**
 * 自动获取出错的信息
 * @author Administrator
 *
 */
public class ExceptionInfoBuilder {
		
	public ExceptionInfoBuilder(){
		StackTraceElement stack[] = (new Throwable()).getStackTrace();
		for(int i = 0, len = stack.length; i < len; i ++){
			StackTraceElement s = stack[i];
			System.out.println(s.getClassName());
		}
	}
	
	public ExceptionInfoBuilder(String userId,String errorCode, String errorMsg, String errorDesc){}
	
	public static ExceptionInfoVO build(){
		
		ExceptionInfoVO exceptionInfoVO = new ExceptionInfoVO();
		StackTraceElement stack[] = (new Throwable()).getStackTrace();
		int len = stack.length;
		if (len > 0){
			StackTraceElement s = stack[len - 1];
			//StackTraceElement s = stack[0];
			exceptionInfoVO.setClassName(s.getClassName());
			exceptionInfoVO.setMethodName(s.getMethodName());
			exceptionInfoVO.setLineNumber(Integer.valueOf(s.getLineNumber()+""));
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			f.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
			String time = f.format(new Date());
			exceptionInfoVO.setTime(time);
		}
		
		return exceptionInfoVO;
	}
	
	public static ExceptionInfoVO build(String msg){
		
		ExceptionInfoVO exceptionInfoVO = build();
		exceptionInfoVO.setMsg(msg);
		return exceptionInfoVO;
	}
	
	public static ExceptionInfoVO build(String msg, String code){
		
		ExceptionInfoVO exceptionInfoVO = build(msg);
		exceptionInfoVO.setCode(code);
		return exceptionInfoVO;
	}
	
	public static ExceptionInfoVO build(String msg, String code, String userId){
		
		ExceptionInfoVO exceptionInfoVO = build(msg, code);
		exceptionInfoVO.setUserId(userId);
		return exceptionInfoVO;
	}
	
	
	
	public static ExceptionInfoVO build(String msg, Throwable cause){
		
		ExceptionInfoVO exceptionInfoVO = build();
		exceptionInfoVO.setMsg(msg);
		exceptionInfoVO.setCause(cause);
		return exceptionInfoVO;
	}
	public static ExceptionInfoVO build(String msg, String code, Throwable cause){
		
		ExceptionInfoVO exceptionInfoVO = build(msg);
		exceptionInfoVO.setCode(code);
		exceptionInfoVO.setCause(cause);
		return exceptionInfoVO;
	}
	
	public static ExceptionInfoVO build(String msg, String code, String userId, Throwable cause){
		
		ExceptionInfoVO exceptionInfoVO = build(msg, code);
		exceptionInfoVO.setUserId(userId);
		exceptionInfoVO.setCause(cause);
		return exceptionInfoVO;
	}
	
	public static ExceptionInfoVO build(String code, Object[] params){
		
		ExceptionInfoVO exceptionInfoVO = build();
		String msg = MessageUtil.getMessage(code, params, false);
		exceptionInfoVO.setMsg(msg);
		exceptionInfoVO.setCode(code);
		return exceptionInfoVO;
	}
	
}
