package com.als.frm.ex;

import java.io.Serializable;

import com.als.frm.comm.dto.ExceptionInfoVO;
import com.als.frm.comm.util.LogHelper;


/**
 * 业务层异常（spring事务在这层进行控制）
 * @author Administrator
 *
 */
public class BizException extends AppException implements Serializable {

	private static final long serialVersionUID = 1L;
	public BizException(){
		super();
	}
	
	public BizException(String msg){
		super(msg);		
	}
	
	public BizException(String msg, Throwable cause){
		super(msg, cause);		
	}
	
	public BizException(String msg, String code){
		super(msg, code);		
	}
	
	public BizException(String msg, String code, Throwable cause){
		super(msg, code, cause);		
	}
	
	public BizException(String msg, String code, String userId){
		super(msg, code, userId);		
	}
	
	public BizException(String msg, String code, String userId, Throwable cause){
		super(msg, code, userId, cause);	
	}
	
	public BizException(String code, Object[] params){
		super(code);
		ExceptionInfoVO vo = ExceptionInfoBuilder.build(code, params);
		this.setExceptionInfoVO(vo);
		
		LogHelper.error(vo.getMsg(), this);
		
	}
}
