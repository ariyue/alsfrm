package com.als.frm.ex;

import java.io.Serializable;

import com.als.frm.comm.dto.ExceptionInfoVO;
import com.als.frm.comm.util.LogHelper;

/**
 * 数据访问异常
 * @author Administrator
 *
 */
public class DBAccessException extends DaoException implements Serializable  {

	private static final long serialVersionUID = 1L;
	public DBAccessException(){
		super();
	}
	
	public DBAccessException(String msg){
		super(msg);		
	}
	
	public DBAccessException(String msg, Throwable cause){
		super(msg, cause);		
	}
	
	public DBAccessException(String msg, String code){
		super(msg, code);		
	}
	
	public DBAccessException(String msg, String code, Throwable cause){
		super(msg, code, cause);		
	}
	
	public DBAccessException(String msg, String code, String userId){
		super(msg, code, userId);		
	}
	
	public DBAccessException(String msg, String code, String userId, Throwable cause){
		super(msg, code, userId, cause);	
	}
	
	public DBAccessException(String code, Object[] params){
		super(code);
		ExceptionInfoVO vo = ExceptionInfoBuilder.build(code, params);
		this.setExceptionInfoVO(vo);
		
		LogHelper.error(vo.getMsg(), this);
		
	}
}
