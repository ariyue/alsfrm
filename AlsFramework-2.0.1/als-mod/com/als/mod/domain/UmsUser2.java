package com.als.mod.domain;

import java.io.Serializable;

import com.als.frm.comm.dto.Table;
import com.als.mod.bas.BasEntity;


@Table(keyColumnName = "user_id", tableName = "ums_user")
public class UmsUser2 extends BasEntity implements Serializable{

	
	private String userId;

	
	private String userName;

	private String password;

	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}