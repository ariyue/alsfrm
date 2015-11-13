package com.als.frm.ex;

import java.io.Serializable;

/**
 * 数据连接异常
 * @author Administrator
 *
 */
public class ConnectionException extends DaoException implements Serializable{

	private static final long serialVersionUID = 1L;
	public ConnectionException(){
		super();
	}
	
	public ConnectionException(String msg){
		super(msg);		
	}
	
	public ConnectionException(String msg, Throwable cause){
		super(msg, cause);		
	}
	
	public ConnectionException(String msg, String code){
		super(msg, code);		
	}
	
	public ConnectionException(String msg, String code, Throwable cause){
		super(msg, code, cause);		
	}
	
	public ConnectionException(String msg, String code, String userId){
		super(msg, code, userId);		
	}
	
	public ConnectionException(String msg, String code, String userId, Throwable cause){
		super(msg, code, userId, cause);	
	}
}
