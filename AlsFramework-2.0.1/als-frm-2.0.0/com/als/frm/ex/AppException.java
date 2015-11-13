package com.als.frm.ex;

import java.io.Serializable;

import com.als.frm.comm.dto.ExceptionInfoVO;
import com.als.frm.comm.util.LogHelper;


/**
 * 框架异常基类（action层抛出或其它末定义的异常抛出）
 * @author Administrator
 *
 */
public class AppException extends RuntimeException implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private ExceptionInfoVO exceptionInfoVO;
	private Throwable cause;
	public AppException(){
		super();
		ExceptionInfoVO vo = ExceptionInfoBuilder.build();
		this.setExceptionInfoVO(vo);
		LogHelper.writeInLog(this);
	}
	
	public AppException(String msg){
		super(msg);
		ExceptionInfoVO vo = ExceptionInfoBuilder.build(msg);
		this.setExceptionInfoVO(vo);	
		LogHelper.writeInLog(this);
	}
	
	
	public AppException(String code, Object[] params){
		super(code);
		ExceptionInfoVO vo = ExceptionInfoBuilder.build(code, params);
		this.setExceptionInfoVO(vo);
		
		LogHelper.error(vo.getMsg(), this);
		
	}
	
	public AppException(String msg, Throwable cause){
		super(msg, cause);
		this.cause = cause;
		ExceptionInfoVO vo = ExceptionInfoBuilder.build(msg);
		this.setExceptionInfoVO(vo);		
		LogHelper.writeInLog(this);
	}
	
	public AppException(String msg, String code){
		super(msg);
		ExceptionInfoVO vo = ExceptionInfoBuilder.build(msg, code);
		this.setExceptionInfoVO(vo);	
		LogHelper.writeInLog(this);
	}
	
	public AppException(String msg, String code, Throwable cause){
		super(msg);
		this.cause = cause;
		ExceptionInfoVO vo = ExceptionInfoBuilder.build(msg, code, cause);
		this.setExceptionInfoVO(vo);	
		LogHelper.writeInLog(this);
	}
	
	public AppException(String msg, String code, String userId){
		super(msg);
		ExceptionInfoVO vo = ExceptionInfoBuilder.build(msg, code, userId);
		this.setExceptionInfoVO(vo);
		LogHelper.writeInLog(this);
	}
	
	public AppException(String msg, String code, String userId, Throwable cause){
		super(msg);
		this.cause = cause;
		ExceptionInfoVO vo = ExceptionInfoBuilder.build(msg, code, userId, cause);
		this.setExceptionInfoVO(vo);
		LogHelper.writeInLog(this);
	}
	
	public ExceptionInfoVO getExceptionInfoVO() {
		return exceptionInfoVO;
	}

	public void setExceptionInfoVO(ExceptionInfoVO exceptionInfoVO) {
		this.exceptionInfoVO = exceptionInfoVO;
	}

	
	public Throwable getCause() {
		return cause;
	}

	public void setCause(Throwable cause) {
		this.cause = cause;
	}
}
