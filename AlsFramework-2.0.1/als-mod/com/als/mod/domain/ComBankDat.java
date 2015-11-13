package com.als.mod.domain;

import com.als.frm.comm.dto.Table;

/**
 * ComBankDat entity. @author MyEclipse Persistence Tools
 */
@Table(keyColumnName = "id", tableName = "com_bank_dat")
public class ComBankDat extends com.als.mod.bas.BasEntity implements
		java.io.Serializable {

	// Fields

	private String id;
	private String bankNo;
	private String actorType;
	private String bankType;
	private String upActor;
	private String nodeCode;
	private String bankUpActor;
	private String peopleBankCode;
	private String cityCode;
	private String actorName;
	private String actorShortName;
	private String address;
	private String postcode;
	private String telphone;
	private String email;
	private String status;
	private String effectDate;
	private String logoutDate;
	private String updateDatetime;
	private String lastUpdate;
	private String updateCount;
	private String memo;
	private String dnField;
	private String snField;
	private String certStatus;
	private String connectNode;
	private String carryBankCode;
	private String carConNode;
	private String carryFlag;
	private String carryHis;
	private String clsStatus;
	private String clsStatusChgDate;
	private String clsStatusChgTime;

	// Constructors

	/** default constructor */
	public ComBankDat() {
	}

	/** minimal constructor */
	public ComBankDat(String id, String bankNo, String actorType,
			String updateDatetime) {
		this.id = id;
		this.bankNo = bankNo;
		this.actorType = actorType;
		this.updateDatetime = updateDatetime;
	}

	/** full constructor */
	public ComBankDat(String id, String bankNo, String actorType,
			String bankType, String upActor, String nodeCode,
			String bankUpActor, String peopleBankCode, String cityCode,
			String actorName, String actorShortName, String address,
			String postcode, String telphone, String email, String status,
			String effectDate, String logoutDate, String updateDatetime,
			String lastUpdate, String updateCount, String memo, String dnField,
			String snField, String certStatus, String connectNode,
			String carryBankCode, String carConNode, String carryFlag,
			String carryHis, String clsStatus, String clsStatusChgDate,
			String clsStatusChgTime) {
		this.id = id;
		this.bankNo = bankNo;
		this.actorType = actorType;
		this.bankType = bankType;
		this.upActor = upActor;
		this.nodeCode = nodeCode;
		this.bankUpActor = bankUpActor;
		this.peopleBankCode = peopleBankCode;
		this.cityCode = cityCode;
		this.actorName = actorName;
		this.actorShortName = actorShortName;
		this.address = address;
		this.postcode = postcode;
		this.telphone = telphone;
		this.email = email;
		this.status = status;
		this.effectDate = effectDate;
		this.logoutDate = logoutDate;
		this.updateDatetime = updateDatetime;
		this.lastUpdate = lastUpdate;
		this.updateCount = updateCount;
		this.memo = memo;
		this.dnField = dnField;
		this.snField = snField;
		this.certStatus = certStatus;
		this.connectNode = connectNode;
		this.carryBankCode = carryBankCode;
		this.carConNode = carConNode;
		this.carryFlag = carryFlag;
		this.carryHis = carryHis;
		this.clsStatus = clsStatus;
		this.clsStatusChgDate = clsStatusChgDate;
		this.clsStatusChgTime = clsStatusChgTime;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBankNo() {
		return this.bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}

	public String getActorType() {
		return this.actorType;
	}

	public void setActorType(String actorType) {
		this.actorType = actorType;
	}

	public String getBankType() {
		return this.bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	public String getUpActor() {
		return this.upActor;
	}

	public void setUpActor(String upActor) {
		this.upActor = upActor;
	}

	public String getNodeCode() {
		return this.nodeCode;
	}

	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode;
	}

	public String getBankUpActor() {
		return this.bankUpActor;
	}

	public void setBankUpActor(String bankUpActor) {
		this.bankUpActor = bankUpActor;
	}

	public String getPeopleBankCode() {
		return this.peopleBankCode;
	}

	public void setPeopleBankCode(String peopleBankCode) {
		this.peopleBankCode = peopleBankCode;
	}

	public String getCityCode() {
		return this.cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getActorName() {
		return this.actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public String getActorShortName() {
		return this.actorShortName;
	}

	public void setActorShortName(String actorShortName) {
		this.actorShortName = actorShortName;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getTelphone() {
		return this.telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEffectDate() {
		return this.effectDate;
	}

	public void setEffectDate(String effectDate) {
		this.effectDate = effectDate;
	}

	public String getLogoutDate() {
		return this.logoutDate;
	}

	public void setLogoutDate(String logoutDate) {
		this.logoutDate = logoutDate;
	}

	public String getUpdateDatetime() {
		return this.updateDatetime;
	}

	public void setUpdateDatetime(String updateDatetime) {
		this.updateDatetime = updateDatetime;
	}

	public String getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getUpdateCount() {
		return this.updateCount;
	}

	public void setUpdateCount(String updateCount) {
		this.updateCount = updateCount;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getDnField() {
		return this.dnField;
	}

	public void setDnField(String dnField) {
		this.dnField = dnField;
	}

	public String getSnField() {
		return this.snField;
	}

	public void setSnField(String snField) {
		this.snField = snField;
	}

	public String getCertStatus() {
		return this.certStatus;
	}

	public void setCertStatus(String certStatus) {
		this.certStatus = certStatus;
	}

	public String getConnectNode() {
		return this.connectNode;
	}

	public void setConnectNode(String connectNode) {
		this.connectNode = connectNode;
	}

	public String getCarryBankCode() {
		return this.carryBankCode;
	}

	public void setCarryBankCode(String carryBankCode) {
		this.carryBankCode = carryBankCode;
	}

	public String getCarConNode() {
		return this.carConNode;
	}

	public void setCarConNode(String carConNode) {
		this.carConNode = carConNode;
	}

	public String getCarryFlag() {
		return this.carryFlag;
	}

	public void setCarryFlag(String carryFlag) {
		this.carryFlag = carryFlag;
	}

	public String getCarryHis() {
		return this.carryHis;
	}

	public void setCarryHis(String carryHis) {
		this.carryHis = carryHis;
	}

	public String getClsStatus() {
		return this.clsStatus;
	}

	public void setClsStatus(String clsStatus) {
		this.clsStatus = clsStatus;
	}

	public String getClsStatusChgDate() {
		return this.clsStatusChgDate;
	}

	public void setClsStatusChgDate(String clsStatusChgDate) {
		this.clsStatusChgDate = clsStatusChgDate;
	}

	public String getClsStatusChgTime() {
		return this.clsStatusChgTime;
	}

	public void setClsStatusChgTime(String clsStatusChgTime) {
		this.clsStatusChgTime = clsStatusChgTime;
	}

}