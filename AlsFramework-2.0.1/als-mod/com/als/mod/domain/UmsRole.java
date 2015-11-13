package com.als.mod.domain;

import com.als.frm.comm.dto.Table;

/**
 * UmsRole entity. @author MyEclipse Persistence Tools
 */
@Table(keyColumnName = "id", tableName = "ums_role")
public class UmsRole extends com.als.mod.bas.BasEntity implements
		java.io.Serializable {

	// Fields

	private String id;
	private String roleName;
	private String roleType;
	private String remark;
	private String entitySid;
	private String createRealName;
	private String createUserName;
	private String createDate;
	private String createTime;
	private String lastModifyRealName;
	private String lastModifyUserName;
	private String lastModifyDate;
	private String lastModifyTime;
	private String lastApproveOption;
	public String getLastApproveOption() {
		return lastApproveOption;
	}

	public void setLastApproveOption(String lastApproveOption) {
		this.lastApproveOption = lastApproveOption;
	}

	private Integer rowOrder;

	// Constructors

	/** default constructor */
	public UmsRole() {
	}

	/** minimal constructor */
	public UmsRole(String id) {
		this.id = id;
	}

	/** full constructor */
	public UmsRole(String id, String roleName, String roleType, String remark,
			String entityId, String createRealName, String createUserName,
			String createDate, String createTime, String lastModifyRealName,
			String lastModifyUserName, String lastModifyDate,
			String lastModifyTime, String lastApproveOption, Integer rowOrder) {
		this.id = id;
		this.roleName = roleName;
		this.roleType = roleType;
		this.remark = remark;
		this.entitySid = entityId;
		this.createRealName = createRealName;
		this.createUserName = createUserName;
		this.createDate = createDate;
		this.createTime = createTime;
		this.lastModifyRealName = lastModifyRealName;
		this.lastModifyUserName = lastModifyUserName;
		this.lastModifyDate = lastModifyDate;
		this.lastModifyTime = lastModifyTime;
		this.lastApproveOption = lastApproveOption;
		this.rowOrder = rowOrder;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleType() {
		return this.roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getEntitySid() {
		return this.entitySid;
	}

	public void setEntitySid(String entityId) {
		this.entitySid = entityId;
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



	public Integer getRowOrder() {
		return this.rowOrder;
	}

	public void setRowOrder(Integer rowOrder) {
		this.rowOrder = rowOrder;
	}

}