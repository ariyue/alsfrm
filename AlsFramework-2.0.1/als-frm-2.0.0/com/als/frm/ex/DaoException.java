package com.als.frm.ex;

import java.io.Serializable;


/**
 * 数据操作层异常(用在DAO层抛出的异常)
 * @author Administrator
 *
 */
public class DaoException extends AppException implements Serializable {

	private static final long serialVersionUID = 1L;
	public DaoException(){
		super();
	}
	
	public DaoException(String msg){
		super(msg);		
	}
	
	public DaoException(String msg, Throwable cause){
		super(msg, cause);		
	}
	
	public DaoException(String msg, String code){
		super(msg, code);		
	}
	
	public DaoException(String msg, String code, Throwable cause){
		super(msg, code, cause);		
	}
	
	public DaoException(String msg, String code, String userId){
		super(msg, code, userId);		
	}
	
	public DaoException(String msg, String code, String userId, Throwable cause){
		super(msg, code, userId, cause);	
	}
}
