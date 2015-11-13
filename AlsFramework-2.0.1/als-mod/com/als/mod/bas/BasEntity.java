package com.als.mod.bas;

import java.io.Serializable;


public  abstract class  BasEntity  implements Serializable{

  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String createRealName;
	private String createUserName;
	private String createDate;
	private String createTime;
	private String lastModifyRealName;
	private String lastModifyUserName;
	private String lastModifyDate;
	private String lastModifyTime;
	private String lastApproveOpiton;
	
	public String getCreateRealName() {
		return createRealName;
	}
	public void setCreateRealName(String createRealName) {
		this.createRealName = createRealName;
	}
	public String getCreateUserName() {
		return createUserName;
	}
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getLastModifyRealName() {
		return lastModifyRealName;
	}
	public void setLastModifyRealName(String lastModifyRealName) {
		this.lastModifyRealName = lastModifyRealName;
	}
	public String getLastModityUserName() {
		return lastModifyUserName;
	}
	public void setLastModityUserName(String lastModityUserName) {
		this.lastModifyUserName = lastModityUserName;
	}
	public String getLastModifyDate() {
		return lastModifyDate;
	}
	public void setLastModifyDate(String lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}
	public String getLastModifyTime() {
		return lastModifyTime;
	}
	public void setLastModifyTime(String lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}
	public String getLastApproveOpiton() {
		return lastApproveOpiton;
	}
	public void setLastApproveOpiton(String lastApproveOpiton) {
		this.lastApproveOpiton = lastApproveOpiton;
	}
	
}
