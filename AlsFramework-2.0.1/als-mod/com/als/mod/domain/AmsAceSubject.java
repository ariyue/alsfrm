package com.als.mod.domain;

import com.als.frm.comm.dto.Table;

/**
 * AmsAceSubject entity. @author MyEclipse Persistence Tools
 */
@Table(keyColumnName = "id", tableName = "ams_ace_subject")
public class AmsAceSubject extends com.als.mod.bas.BasEntity implements
		java.io.Serializable {

	// Fields

	private String id;
	private String entitySid;
	private String subjectType;
	private String subjectNo;
	private String subjectName;
	private String currencyCode;
	private String dcFlag;
	private String subjectPno;
	private String remark;
	private String deleteFlag;
	private String aceType;
	private String aceScope;

	// Constructors

	/** default constructor */
	public AmsAceSubject() {
	}

	/** minimal constructor */
	public AmsAceSubject(String id, String subjectType, String subjectNo,
			String subjectName, String currencyCode, String dcFlag,
			String subjectPno) {
		this.id = id;
		this.subjectType = subjectType;
		this.subjectNo = subjectNo;
		this.subjectName = subjectName;
		this.currencyCode = currencyCode;
		this.dcFlag = dcFlag;
		this.subjectPno = subjectPno;
	}

	/** full constructor */
	public AmsAceSubject(String id, String entitySid, String subjectType,
			String subjectNo, String subjectName, String currencyCode,
			String dcFlag, String subjectPno, String remark, String deleteFlag,
			String aceType, String aceScope) {
		this.id = id;
		this.entitySid = entitySid;
		this.subjectType = subjectType;
		this.subjectNo = subjectNo;
		this.subjectName = subjectName;
		this.currencyCode = currencyCode;
		this.dcFlag = dcFlag;
		this.subjectPno = subjectPno;
		this.remark = remark;
		this.deleteFlag = deleteFlag;
		this.aceType = aceType;
		this.aceScope = aceScope;
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

	public String getSubjectType() {
		return this.subjectType;
	}

	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType;
	}

	public String getSubjectNo() {
		return this.subjectNo;
	}

	public void setSubjectNo(String subjectNo) {
		this.subjectNo = subjectNo;
	}

	public String getSubjectName() {
		return this.subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getCurrencyCode() {
		return this.currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getDcFlag() {
		return this.dcFlag;
	}

	public void setDcFlag(String dcFlag) {
		this.dcFlag = dcFlag;
	}

	public String getSubjectPno() {
		return this.subjectPno;
	}

	public void setSubjectPno(String subjectPno) {
		this.subjectPno = subjectPno;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getAceType() {
		return this.aceType;
	}

	public void setAceType(String aceType) {
		this.aceType = aceType;
	}

	public String getAceScope() {
		return this.aceScope;
	}

	public void setAceScope(String aceScope) {
		this.aceScope = aceScope;
	}

}