package com.als.mod.domain;

import com.als.frm.comm.dto.Table;

/**
 * UmsUserInfo entity. @author MyEclipse Persistence Tools
 */
@Table(keyColumnName = "id", tableName = "ums_user_info")
public class UmsUserInfo extends com.als.mod.bas.BasEntity implements
		java.io.Serializable {

	// Fields

	private String id;
	private UmsUser umsUser;
	private String phone;
	private String mobile;

	// Constructors

	/** default constructor */
	public UmsUserInfo() {
	}

	/** minimal constructor */
	public UmsUserInfo(String id, UmsUser umsUser) {
		this.id = id;
		this.umsUser = umsUser;
	}

	/** full constructor */
	public UmsUserInfo(String id, UmsUser umsUser, String phone, String mobile) {
		this.id = id;
		this.umsUser = umsUser;
		this.phone = phone;
		this.mobile = mobile;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UmsUser getUmsUser() {
		return this.umsUser;
	}

	public void setUmsUser(UmsUser umsUser) {
		this.umsUser = umsUser;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}