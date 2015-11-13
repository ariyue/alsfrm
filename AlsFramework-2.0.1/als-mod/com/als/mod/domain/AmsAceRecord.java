package com.als.mod.domain;

import java.math.BigDecimal;

import com.als.frm.comm.dto.Table;

/**
 * AmsAceRecord entity. @author MyEclipse Persistence Tools
 */
@Table(keyColumnName = "id", tableName = "ams_ace_record")
public class AmsAceRecord extends com.als.mod.bas.BasEntity implements
		java.io.Serializable {

	// Fields

	private String id;
	private String status;
	private String recordDate;
	private String valueDate;
	private String processCode;
	private String bizId;
	private String subjectName;
	private String subjectNo;
	private String dcFlag;
	private String currencyCode;
	private BigDecimal amount;
	private String acntNo;
	private String acntName;
	private String entitySid;
	private String unitRelationship;
	private String createDate;
	private String createTime;
	private String createUserName;
	private String createRealName;
	private String remark;
	private String voucherNo;

	// Constructors

	/** default constructor */
	public AmsAceRecord() {
	}

	/** minimal constructor */
	public AmsAceRecord(String id, String recordDate, String valueDate,
			String processCode, String bizId, String subjectName,
			String subjectNo, String dcFlag, String entitySid) {
		this.id = id;
		this.recordDate = recordDate;
		this.valueDate = valueDate;
		this.processCode = processCode;
		this.bizId = bizId;
		this.subjectName = subjectName;
		this.subjectNo = subjectNo;
		this.dcFlag = dcFlag;
		this.entitySid = entitySid;
	}

	/** full constructor */
	public AmsAceRecord(String id, String status, String recordDate,
			String valueDate, String processCode, String bizId,
			String subjectName, String subjectNo, String dcFlag,
			String currencyCode, BigDecimal amount, String acntNo, String acntName,
			String entitySid, String unitRelationship, String createDate,
			String createTime, String createUserName, String createRealName,
			String remark, String voucherNo) {
		this.id = id;
		this.status = status;
		this.recordDate = recordDate;
		this.valueDate = valueDate;
		this.processCode = processCode;
		this.bizId = bizId;
		this.subjectName = subjectName;
		this.subjectNo = subjectNo;
		this.dcFlag = dcFlag;
		this.currencyCode = currencyCode;
		this.amount = amount;
		this.acntNo = acntNo;
		this.acntName = acntName;
		this.entitySid = entitySid;
		this.unitRelationship = unitRelationship;
		this.createDate = createDate;
		this.createTime = createTime;
		this.createUserName = createUserName;
		this.createRealName = createRealName;
		this.remark = remark;
		this.voucherNo = voucherNo;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRecordDate() {
		return this.recordDate;
	}

	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}

	public String getValueDate() {
		return this.valueDate;
	}

	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
	}

	public String getProcessCode() {
		return this.processCode;
	}

	public void setProcessCode(String processCode) {
		this.processCode = processCode;
	}

	public String getBizId() {
		return this.bizId;
	}

	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	public String getSubjectName() {
		return this.subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectNo() {
		return this.subjectNo;
	}

	public void setSubjectNo(String subjectNo) {
		this.subjectNo = subjectNo;
	}

	public String getDcFlag() {
		return this.dcFlag;
	}

	public void setDcFlag(String dcFlag) {
		this.dcFlag = dcFlag;
	}

	public String getCurrencyCode() {
		return this.currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getAcntNo() {
		return this.acntNo;
	}

	public void setAcntNo(String acntNo) {
		this.acntNo = acntNo;
	}

	public String getAcntName() {
		return this.acntName;
	}

	public void setAcntName(String acntName) {
		this.acntName = acntName;
	}

	public String getEntitySid() {
		return this.entitySid;
	}

	public void setEntitySid(String entitySid) {
		this.entitySid = entitySid;
	}

	public String getUnitRelationship() {
		return this.unitRelationship;
	}

	public void setUnitRelationship(String unitRelationship) {
		this.unitRelationship = unitRelationship;
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

	public String getCreateUserName() {
		return this.createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getCreateRealName() {
		return this.createRealName;
	}

	public void setCreateRealName(String createRealName) {
		this.createRealName = createRealName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getVoucherNo() {
		return this.voucherNo;
	}

	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}

}