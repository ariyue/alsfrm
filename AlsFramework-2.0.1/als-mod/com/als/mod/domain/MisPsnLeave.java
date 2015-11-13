package com.als.mod.domain;

import com.als.frm.comm.dto.Table;

/**
 * MisPsnLeave entity. @author MyEclipse Persistence Tools
 */
@Table(keyColumnName = "id", tableName = "mis_psn_leave")
public class MisPsnLeave extends com.als.mod.bas.BasEntity implements
		java.io.Serializable {

	// Fields

	private String id;
	private String processInstanceId;
	private String applyRealName;
	private String applyUserId;
	private String applyUnitId;
	private String applyUnitName;
	private String applyDate;
	private String leaveReason;
	private String startDate;
	private String startTime;
	private String endDate;
	private String endTime;
	private Float countDate;
	private String remark;
	private String attachmentBatchId;
	private String leaveType;
	private String deleteFlag;
	private String createUserId;
	private String createUserName;
	private String createEntitySid;
	private String createUnitName;
	private String createUnitId;
	private String createDate;
	private String createTime;
	private String lastModUserId;
	private String lastModUserName;
	private String lastModDate;
	private String lastModTime;

	// Constructors

	/** default constructor */
	public MisPsnLeave() {
	}

	/** minimal constructor */
	public MisPsnLeave(String id, String processInstanceId,
			String applyRealName, String applyUserId, String applyUnitId,
			String applyUnitName, String applyDate, String leaveReason,
			String startDate, String startTime, String endDate, String endTime,
			Float countDate, String leaveType) {
		this.id = id;
		this.processInstanceId = processInstanceId;
		this.applyRealName = applyRealName;
		this.applyUserId = applyUserId;
		this.applyUnitId = applyUnitId;
		this.applyUnitName = applyUnitName;
		this.applyDate = applyDate;
		this.leaveReason = leaveReason;
		this.startDate = startDate;
		this.startTime = startTime;
		this.endDate = endDate;
		this.endTime = endTime;
		this.countDate = countDate;
		this.leaveType = leaveType;
	}

	/** full constructor */
	public MisPsnLeave(String id, String processInstanceId,
			String applyRealName, String applyUserId, String applyUnitId,
			String applyUnitName, String applyDate, String leaveReason,
			String startDate, String startTime, String endDate, String endTime,
			float countDate, String remark, String attachmentBatchId,
			String leaveType, String deleteFlag, String createUserId,
			String createUserName, String createEntitySid,
			String createUnitName, String createUnitId, String createDate,
			String createTime, String lastModUserId, String lastModUserName,
			String lastModDate, String lastModTime) {
		this.id = id;
		this.processInstanceId = processInstanceId;
		this.applyRealName = applyRealName;
		this.applyUserId = applyUserId;
		this.applyUnitId = applyUnitId;
		this.applyUnitName = applyUnitName;
		this.applyDate = applyDate;
		this.leaveReason = leaveReason;
		this.startDate = startDate;
		this.startTime = startTime;
		this.endDate = endDate;
		this.endTime = endTime;
		this.countDate = countDate;
		this.remark = remark;
		this.attachmentBatchId = attachmentBatchId;
		this.leaveType = leaveType;
		this.deleteFlag = deleteFlag;
		this.createUserId = createUserId;
		this.createUserName = createUserName;
		this.createEntitySid = createEntitySid;
		this.createUnitName = createUnitName;
		this.createUnitId = createUnitId;
		this.createDate = createDate;
		this.createTime = createTime;
		this.lastModUserId = lastModUserId;
		this.lastModUserName = lastModUserName;
		this.lastModDate = lastModDate;
		this.lastModTime = lastModTime;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProcessInstanceId() {
		return this.processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public String getApplyRealName() {
		return this.applyRealName;
	}

	public void setApplyRealName(String applyRealName) {
		this.applyRealName = applyRealName;
	}

	public String getApplyUserId() {
		return this.applyUserId;
	}

	public void setApplyUserId(String applyUserId) {
		this.applyUserId = applyUserId;
	}

	public String getApplyUnitId() {
		return this.applyUnitId;
	}

	public void setApplyUnitId(String applyUnitId) {
		this.applyUnitId = applyUnitId;
	}

	public String getApplyUnitName() {
		return this.applyUnitName;
	}

	public void setApplyUnitName(String applyUnitName) {
		this.applyUnitName = applyUnitName;
	}

	public String getApplyDate() {
		return this.applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	public String getLeaveReason() {
		return this.leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	public String getStartDate() {
		return this.startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getStartTime() {
		return this.startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndDate() {
		return this.endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getEndTime() {
		return this.endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Float getCountDate() {
		return this.countDate;
	}

	public void setCountDate(Float countDate) {
		this.countDate = countDate;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAttachmentBatchId() {
		return this.attachmentBatchId;
	}

	public void setAttachmentBatchId(String attachmentBatchId) {
		this.attachmentBatchId = attachmentBatchId;
	}

	public String getLeaveType() {
		return this.leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getCreateUserId() {
		return this.createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateUserName() {
		return this.createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getCreateEntitySid() {
		return this.createEntitySid;
	}

	public void setCreateEntitySid(String createEntitySid) {
		this.createEntitySid = createEntitySid;
	}

	public String getCreateUnitName() {
		return this.createUnitName;
	}

	public void setCreateUnitName(String createUnitName) {
		this.createUnitName = createUnitName;
	}

	public String getCreateUnitId() {
		return this.createUnitId;
	}

	public void setCreateUnitId(String createUnitId) {
		this.createUnitId = createUnitId;
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

	public String getLastModUserId() {
		return this.lastModUserId;
	}

	public void setLastModUserId(String lastModUserId) {
		this.lastModUserId = lastModUserId;
	}

	public String getLastModUserName() {
		return this.lastModUserName;
	}

	public void setLastModUserName(String lastModUserName) {
		this.lastModUserName = lastModUserName;
	}

	public String getLastModDate() {
		return this.lastModDate;
	}

	public void setLastModDate(String lastModDate) {
		this.lastModDate = lastModDate;
	}

	public String getLastModTime() {
		return this.lastModTime;
	}

	public void setLastModTime(String lastModTime) {
		this.lastModTime = lastModTime;
	}

}