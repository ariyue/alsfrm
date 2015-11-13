package com.als.mod.domain;

import com.als.frm.comm.dto.Table;

/**
 * UmsCustInfo entity. @author MyEclipse Persistence Tools
 */
@Table(keyColumnName = "id", tableName = "ums_cust_info")
public class UmsCustInfo extends com.als.mod.bas.BasEntity implements
		java.io.Serializable {

	// Fields

	private String id;
	private UmsUser umsUser;
	private String remark;
	private String mobile;
	private String email;
	private String phone;
	private String birthday;
	private String interest;

	// Constructors

	/** default constructor */
	public UmsCustInfo() {
	}

	/** minimal constructor */
	public UmsCustInfo(String id, UmsUser umsUser) {
		this.id = id;
		this.umsUser = umsUser;
	}

	/** full constructor */
	public UmsCustInfo(String id, UmsUser umsUser, String remark,
			String mobile, String email, String phone, String birthday,
			String interest) {
		this.id = id;
		this.umsUser = umsUser;
		this.remark = remark;
		this.mobile = mobile;
		this.email = email;
		this.phone = phone;
		this.birthday = birthday;
		this.interest = interest;
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

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getInterest() {
		return this.interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

}