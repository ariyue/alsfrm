package com.als.mod.domain;

import java.math.BigDecimal;

import com.als.frm.comm.dto.Table;

/**
 * AmsBank entity. @author MyEclipse Persistence Tools
 */
@Table(keyColumnName = "id", tableName = "ams_bank")
public class AmsBank extends com.als.mod.bas.BasEntity implements
		java.io.Serializable {

	// Fields

	private String id;
	private String bankType;
	private String bankName;
	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	private String acntNo;
	private String acntName;
	private String openDate;
	private String openTime;
	private String branchCode;
	private String branchName;
	private String branchAddress;
	private String status;
	private String currencyCode;
	private BigDecimal blance;
	private BigDecimal availBlance;
	private String remark;
	private String entitySid;
	

	// Constructors

	/** default constructor */
	public AmsBank() {
	}

	public String getEntitySid() {
		return entitySid;
	}

	public void setEntitySid(String entitySid) {
		this.entitySid = entitySid;
	}

	/** minimal constructor */
	public AmsBank(String id) {
		this.id = id;
	}

	/** full constructor */
	public AmsBank(String id, String bankType, String bankName, String acntNo,
			String acntName, String openDate, String openTime,
			String branchCode, String branchName, String branchAddress,
			String status, String currencyCode, BigDecimal blance,
			BigDecimal availBlance, String remark) {
		this.id = id;
		this.bankType = bankType;
		this.bankName = bankName;
		this.acntNo = acntNo;
		this.acntName = acntName;
		this.openDate = openDate;
		this.openTime = openTime;
		this.branchCode = branchCode;
		this.branchName = branchName;
		this.branchAddress = branchAddress;
		this.status = status;
		this.currencyCode = currencyCode;
		this.blance = blance;
		this.availBlance = availBlance;
		this.remark = remark;
	}

	// Property accessors

	public BigDecimal getBlance() {
		return blance;
	}

	public void setBlance(BigDecimal blance) {
		this.blance = blance;
	}

	public BigDecimal getAvailBlance() {
		return availBlance;
	}

	public void setAvailBlance(BigDecimal availBlance) {
		this.availBlance = availBlance;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}



	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
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

	public String getOpenDate() {
		return this.openDate;
	}

	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}

	public String getOpenTime() {
		return this.openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getBranchCode() {
		return this.branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getBranchName() {
		return this.branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchAddress() {
		return this.branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCurrencyCode() {
		return this.currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}


	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}