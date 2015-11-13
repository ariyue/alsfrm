package com.als.mod.domain;

import com.als.frm.comm.dto.Table;

/**
 * AmsAceCfgItem entity. @author MyEclipse Persistence Tools
 */
@Table(keyColumnName = "id", tableName = "ams_ace_cfg_item")
public class AmsAceCfgItem extends com.als.mod.bas.BasEntity implements
		java.io.Serializable {

	// Fields

	private String id;
	private String cfgId;
	private String subjectNoKey;
	private String subjectNoMeid;
	private String subjectNameKey;
	private String subjectNameMeid;
	private String currencyCodeKey;
	private String currencyCodeMeid;
	private String amountKey;
	private String amountMeid;
	private String dcFlag;
	private String summaryKey;
	private String summaryMeid;

	// Constructors

	/** default constructor */
	public AmsAceCfgItem() {
	}

	/** minimal constructor */
	public AmsAceCfgItem(String id, String cfgId, String dcFlag) {
		this.id = id;
		this.cfgId = cfgId;
		this.dcFlag = dcFlag;
	}

	/** full constructor */
	public AmsAceCfgItem(String id, String cfgId, String subjectNoKey,
			String subjectNoMeid, String subjectNameKey,
			String subjectNameMeid, String currencyCodeKey,
			String currencyCodeMeid, String amountKey, String amountMeid,
			String dcFlag, String summaryKey, String summaryMeid) {
		this.id = id;
		this.cfgId = cfgId;
		this.subjectNoKey = subjectNoKey;
		this.subjectNoMeid = subjectNoMeid;
		this.subjectNameKey = subjectNameKey;
		this.subjectNameMeid = subjectNameMeid;
		this.currencyCodeKey = currencyCodeKey;
		this.currencyCodeMeid = currencyCodeMeid;
		this.amountKey = amountKey;
		this.amountMeid = amountMeid;
		this.dcFlag = dcFlag;
		this.summaryKey = summaryKey;
		this.summaryMeid = summaryMeid;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCfgId() {
		return this.cfgId;
	}

	public void setCfgId(String cfgId) {
		this.cfgId = cfgId;
	}

	public String getSubjectNoKey() {
		return this.subjectNoKey;
	}

	public void setSubjectNoKey(String subjectNoKey) {
		this.subjectNoKey = subjectNoKey;
	}

	public String getSubjectNoMeid() {
		return this.subjectNoMeid;
	}

	public void setSubjectNoMeid(String subjectNoMeid) {
		this.subjectNoMeid = subjectNoMeid;
	}

	public String getSubjectNameKey() {
		return this.subjectNameKey;
	}

	public void setSubjectNameKey(String subjectNameKey) {
		this.subjectNameKey = subjectNameKey;
	}

	public String getSubjectNameMeid() {
		return this.subjectNameMeid;
	}

	public void setSubjectNameMeid(String subjectNameMeid) {
		this.subjectNameMeid = subjectNameMeid;
	}

	public String getCurrencyCodeKey() {
		return this.currencyCodeKey;
	}

	public void setCurrencyCodeKey(String currencyCodeKey) {
		this.currencyCodeKey = currencyCodeKey;
	}

	public String getCurrencyCodeMeid() {
		return this.currencyCodeMeid;
	}

	public void setCurrencyCodeMeid(String currencyCodeMeid) {
		this.currencyCodeMeid = currencyCodeMeid;
	}

	public String getAmountKey() {
		return this.amountKey;
	}

	public void setAmountKey(String amountKey) {
		this.amountKey = amountKey;
	}

	public String getAmountMeid() {
		return this.amountMeid;
	}

	public void setAmountMeid(String amountMeid) {
		this.amountMeid = amountMeid;
	}

	public String getDcFlag() {
		return this.dcFlag;
	}

	public void setDcFlag(String dcFlag) {
		this.dcFlag = dcFlag;
	}

	public String getSummaryKey() {
		return this.summaryKey;
	}

	public void setSummaryKey(String summaryKey) {
		this.summaryKey = summaryKey;
	}

	public String getSummaryMeid() {
		return this.summaryMeid;
	}

	public void setSummaryMeid(String summaryMeid) {
		this.summaryMeid = summaryMeid;
	}

}