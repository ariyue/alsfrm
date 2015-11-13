package com.als.frm.comm.dto;

import java.io.Serializable;
import java.util.Map;

import com.als.mod.bas.BaseVO;


/**
 * 采用ajax请求时的转向
 * @author Vincent
 *
 */
public class RstRedirect extends BaseVO implements Serializable {
	
	/**
	 * 路径
	 */
	private String path;
	
	/**
	 * 参数
	 */
	private Map<String, String> params;

	
	public Map<String, String> getParams() {
		return params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
