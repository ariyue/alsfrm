package com.als.mod.domain;

import com.als.frm.comm.dto.Table;

/**
 * UmsEntityProduct entity. @author MyEclipse Persistence Tools
 */
@Table(keyColumnName = "id", tableName = "ums_entity_product")
public class UmsEntityProduct extends com.als.mod.bas.BasEntity implements
		java.io.Serializable {

	// Fields

	private String id;
	private String entitySid;
	private String productId;
	private String productName;
	private String validStartDate;
	private String validEndDate;
	private String validDateType;
	private String createRealName;
	private String createUserName;
	private String createDate;
	private String createTime;
	private String lastModifyRealName;
	private String lastModifyUserName;
	private String lastModifyDate;
	private String lastModifyTime;
	private String lastApproveOpiton;
	private Integer maxUserCount;

	// Constructors

	/** default constructor */
	public UmsEntityProduct() {
	}

	/** minimal constructor */
	public UmsEntityProduct(String id) {
		this.id = id;
	}

	/** full constructor */
	public UmsEntityProduct(String id, String entitySid, String productId,
			String productName, String validStartDate, String validEndDate,
			String validDateType, String createRealName, String createUserName,
			String createDate, String createTime, String lastModifyRealName,
			String lastModifyUserName, String lastModifyDate,
			String lastModifyTime, String lastApproveOpiton,
			Integer maxUserCount) {
		this.id = id;
		this.entitySid = entitySid;
		this.productId = productId;
		this.productName = productName;
		this.validStartDate = validStartDate;
		this.validEndDate = validEndDate;
		this.validDateType = validDateType;
		this.createRealName = createRealName;
		this.createUserName = createUserName;
		this.createDate = createDate;
		this.createTime = createTime;
		this.lastModifyRealName = lastModifyRealName;
		this.lastModifyUserName = lastModifyUserName;
		this.lastModifyDate = lastModifyDate;
		this.lastModifyTime = lastModifyTime;
		this.lastApproveOpiton = lastApproveOpiton;
		this.maxUserCount = maxUserCount;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEntitySid() {
		return this.entitySid;
	}

	public void setEntitySid(String entitySid) {
		this.entitySid = entitySid;
	}

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getValidStartDate() {
		return this.validStartDate;
	}

	public void setValidStartDate(String validStartDate) {
		this.validStartDate = validStartDate;
	}

	public String getValidEndDate() {
		return this.validEndDate;
	}

	public void setValidEndDate(String validEndDate) {
		this.validEndDate = validEndDate;
	}

	public String getValidDateType() {
		return this.validDateType;
	}

	public void setValidDateType(String validDateType) {
		this.validDateType = validDateType;
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

	public Integer getMaxUserCount() {
		return this.maxUserCount;
	}

	public void setMaxUserCount(Integer maxUserCount) {
		this.maxUserCount = maxUserCount;
	}

}