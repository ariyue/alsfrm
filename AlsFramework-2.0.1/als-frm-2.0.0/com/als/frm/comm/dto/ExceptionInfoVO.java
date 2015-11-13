package com.als.frm.comm.dto;

import java.io.Serializable;

public class ExceptionInfoVO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID，用于标识哪个用护遇到的错误
	 */
	private String userId; 
	
	/**
	 * 哪个类出错
	 */
	private String className;
	
	/**
	 * 哪个方法出错
	 */
	private String methodName;
	
	/**
	 * 哪一行出错
	 */
	private Integer lineNumber;
	
	/**
	 * 异常码(国际化时将根据异常码)
	 */
	private String code;
	
	/**
	 * 异常简要信息（开发人员自定义的信息）
	 */
	private String msg;
	
	/**
	 * 异常详细描述（程序中抛出的原始异常信息）
	 */
	private Throwable cause;
	
	/**
	 * 出错时间
	 */
	private String time;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		className = (className == null) ? "UnknownClassName" : className;
		this.className = className;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		methodName = (methodName == null) ? "UnknownMethodName" : methodName;
		this.methodName = methodName;
	}
	public Integer getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(Integer lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	/**
	 * 输出简要信息
	 * @return
	 */
	public String getShortInfo(){
		StringBuffer sb = new StringBuffer();
		sb.append("----------------------------AliceFramework错误信息--------------------------------------------------------------------------------------------\n");
		sb.append("出 错 类：" + this.getClassName() + "\n");
		sb.append("出错方法：" + this.getMethodName() + "\n");
		sb.append("出 错 行：" + this.getLineNumber()+ "\n");
		sb.append("出错时间：" + this.getTime()+ "\n");
		sb.append("错误代码：" + this.getCode() + "\n");
		sb.append("错误信息：" + this.getMsg() + "\n");
		sb.append("----------------------------AliceFramework错误信息 end----------------------------------------------------------------------------------------\n");
		return sb.toString();
	}
	
	/**
	 * 输出完整信息
	 * @return
	 */
	public String getInfo(){
		StringBuffer sb = new StringBuffer();
		sb.append("----------------------------AliceFramework错误信息--------------------------------------------------------------------------------------------\n");
		sb.append("操作用户：" + this.getUserId() + "\n");
		sb.append("出 错 类：" + this.getClassName() + "\n");
		sb.append("出错方法：" + this.getMethodName() + "\n");
		sb.append("出 错 行：" + this.getLineNumber()+ "\n");
		sb.append("出错时间：" + this.getTime()+ "\n");
		sb.append("错误代码：" + this.getCode() + "\n");
		sb.append("错误信息：" + this.getMsg() + "\n");
		sb.append("详细错误：" + this.getCause() + "\n");
		sb.append("----------------------------AliceFramework错误信息 end----------------------------------------------------------------------------------------\n");
		return sb.toString();
	}
	public Throwable getCause() {
		return cause;
	}
	public void setCause(Throwable cause) {
		this.cause = cause;
	}
	
	
}
