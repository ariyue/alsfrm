package com.als.mod.domain;

import com.als.frm.comm.dto.Table;

/**
 * FrmSwfHis entity. @author MyEclipse Persistence Tools
 */
@Table(keyColumnName = "id", tableName = "frm_swf_his")
public class FrmSwfHis extends com.als.mod.bas.BasEntity implements
		java.io.Serializable {

	// Fields

	private String id;
	private String taskId;
	private String processInstId;
	private String bizId;
	private String bizName;
	private String applyUserId;
	private String applyUserName;
	private String applyDate;
	private String applyTime;
	private String applyMenuTransCode;
	private String nodeName;
	private String nodeAction;
	private String remark;
	
	private String ownerId;
	
	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	private String ownerName;
	
	public String getNodeActionType() {
		return nodeActionType;
	}

	public void setNodeActionType(String nodeActionType) {
		this.nodeActionType = nodeActionType;
	}

	private String nodeActionType;

	// Constructors

	/** default constructor */
	public FrmSwfHis() {
	}

	/** minimal constructor */
	public FrmSwfHis(String id) {
		this.id = id;
	}

	/** full constructor */
	public FrmSwfHis(String id, String taskId, String processInstId,
			String bizId, String bizName, String applyUserId,
			String applyUserName, String applyDate, String applyTime,
			String applyMenuTransCode, String nodeName, String nodeAction,
			String remark) {
		this.id = id;
		this.taskId = taskId;
		this.processInstId = processInstId;
		this.bizId = bizId;
		this.bizName = bizName;
		this.applyUserId = applyUserId;
		this.applyUserName = applyUserName;
		this.applyDate = applyDate;
		this.applyTime = applyTime;
		this.applyMenuTransCode = applyMenuTransCode;
		this.nodeName = nodeName;
		this.nodeAction = nodeAction;
		this.remark = remark;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTaskId() {
		return this.taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getProcessInstId() {
		return this.processInstId;
	}

	public void setProcessInstId(String processInstId) {
		this.processInstId = processInstId;
	}

	public String getBizId() {
		return this.bizId;
	}

	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	public String getBizName() {
		return this.bizName;
	}

	public void setBizName(String bizName) {
		this.bizName = bizName;
	}

	public String getApplyUserId() {
		return this.applyUserId;
	}

	public void setApplyUserId(String applyUserId) {
		this.applyUserId = applyUserId;
	}

	public String getApplyUserName() {
		return this.applyUserName;
	}

	public void setApplyUserName(String applyUserName) {
		this.applyUserName = applyUserName;
	}

	public String getApplyDate() {
		return this.applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	public String getApplyTime() {
		return this.applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	public String getApplyMenuTransCode() {
		return this.applyMenuTransCode;
	}

	public void setApplyMenuTransCode(String applyMenuTransCode) {
		this.applyMenuTransCode = applyMenuTransCode;
	}

	public String getNodeName() {
		return this.nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getNodeAction() {
		return this.nodeAction;
	}

	public void setNodeAction(String nodeAction) {
		this.nodeAction = nodeAction;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}