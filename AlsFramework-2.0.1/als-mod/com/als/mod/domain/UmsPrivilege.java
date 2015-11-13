package com.als.mod.domain;

import com.als.frm.comm.dto.Table;

/**
 * UmsPrivilege entity. @author MyEclipse Persistence Tools
 */
@Table(keyColumnName = "id", tableName = "ums_privilege")
public class UmsPrivilege extends com.als.mod.bas.BasEntity implements
		java.io.Serializable {

	// Fields

	private String id;
	private String roleId;
	private String transCode;
	private String remark;
	private String createRealName;
	private String createUserName;
	private String createDate;
	private String createTime;
	private String lastModifyRealName;
	private String lastModifyUserName;
	private String lastModifyDate;
	private String lastModifyTime;
	private String lastApproveOpiton;

	// Constructors

	/** default constructor */
	public UmsPrivilege() {
	}

	/** minimal constructor */
	public UmsPrivilege(String id) {
		this.id = id;
	}

	/** full constructor */
	public UmsPrivilege(String id, String roleId, String transCode,
			String remark, String createRealName, String createUserName,
			String createDate, String createTime, String lastModifyRealName,
			String lastModityUserName, String lastModifyDate,
			String lastModifyTime, String lastApproveOpiton) {
		this.id = id;
		this.roleId = roleId;
		this.transCode = transCode;
		this.remark = remark;
		this.createRealName = createRealName;
		this.createUserName = createUserName;
		this.createDate = createDate;
		this.createTime = createTime;
		this.lastModifyRealName = lastModifyRealName;
		this.lastModifyUserName = lastModityUserName;
		this.lastModifyDate = lastModifyDate;
		this.lastModifyTime = lastModifyTime;
		this.lastApproveOpiton = lastApproveOpiton;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getTransCode() {
		return this.transCode;
	}

	public void setTransCode(String transCode) {
		this.transCode = transCode;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreateRealName() {
		return this.createRealName;
	}

	public void setCreateRealName(String createRealName) {
		this.createRealName = createRealName;
	}

	public String getCreateUserName() {
		return this.createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getLastModifyRealName() {
		return this.lastModifyRealName;
	}

	public void setLastModifyRealName(String lastModifyRealName) {
		this.lastModifyRealName = lastModifyRealName;
	}

	public String getLastModifyUserName() {
		return this.lastModifyUserName;
	}

	public void setLastModifyUserName(String lastModifyUserName) {
		this.lastModifyUserName = lastModifyUserName;
	}

	public String getLastModifyDate() {
		return this.lastModifyDate;
	}

	public void setLastModifyDate(String lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}

	public String getLastModifyTime() {
		return this.lastModifyTime;
	}

	public void setLastModifyTime(String lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public String getLastApproveOpiton() {
		return this.lastApproveOpiton;
	}

	public void setLastApproveOpiton(String lastApproveOpiton) {
		this.lastApproveOpiton = lastApproveOpiton;
	}

}