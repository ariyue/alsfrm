package com.als.mod.domain;

import java.util.Date;

import com.als.frm.comm.dto.Table;

/**
 * OaLeave entity. @author MyEclipse Persistence Tools
 */

@Table(keyColumnName = "id", tableName = "oa_leave")
public class OaLeave extends com.als.mod.bas.BasEntity implements
		java.io.Serializable {

	// Fields

	private long id;
	private String processInstanceId;
	private String userId;
	private Date startTime;
	private Date endTime;
	private String leaveType;
	private String reason;
	private Date applyTime;
	private Date realityStartTime;
	private Date realityEndTime;

	// Constructors

	/** default constructor */
	public OaLeave() {
	}

	/** minimal constructor */
	public OaLeave(long id, String userId, Date startTime, Date endTime,
			Date applyTime, Date realityStartTime, Date realityEndTime) {
		this.id = id;
		this.userId = userId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.applyTime = applyTime;
		this.realityStartTime = realityStartTime;
		this.realityEndTime = realityEndTime;
	}

	/** full constructor */
	public OaLeave(long id, String processInstanceId, String userId,
			Date startTime, Date endTime, String leaveType, String reason,
			Date applyTime, Date realityStartTime, Date realityEndTime) {
		this.id = id;
		this.processInstanceId = processInstanceId;
		this.userId = userId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.leaveType = leaveType;
		this.reason = reason;
		this.applyTime = applyTime;
		this.realityStartTime = realityStartTime;
		this.realityEndTime = realityEndTime;
	}

	// Property accessors

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProcessInstanceId() {
		return this.processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getLeaveType() {
		return this.leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getApplyTime() {
		return this.applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public Date getRealityStartTime() {
		return this.realityStartTime;
	}

	public void setRealityStartTime(Date realityStartTime) {
		this.realityStartTime = realityStartTime;
	}

	public Date getRealityEndTime() {
		return this.realityEndTime;
	}

	public void setRealityEndTime(Date realityEndTime) {
		this.realityEndTime = realityEndTime;
	}

}