package com.als.frm.comm.dto;

import java.io.Serializable;

import com.als.frm.bas.ddl.RstMsgType;
import com.als.mod.bas.BaseVO;


/**
 * 采用ajax请求时返回的信息（用于弹出的信息框)
 * @author Vincent
 *
 */
public class RstMsg extends BaseVO implements Serializable {
	
	/**
	 * 国际化文件中定义的信息码
	 */
	private String msgCode;
	
	public String getMsgCode() {
		return msgCode;
	}

	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}

	public Object[] getMsgParams() {
		return msgParams;
	}

	public void setMsgParams(Object[] msgParams) {
		this.msgParams = msgParams;
	}

	public RstMsgType getMsgType() {
		return msgType;
	}

	public void setMsgType(RstMsgType msgType) {
		this.msgType = msgType;
	}

	/**
	 * 国际化文件中要用到的类型列表
	 */
	private Object[] msgParams;
	
	/**
	 * 返回消息的类型
	 */
	private RstMsgType msgType;
}
