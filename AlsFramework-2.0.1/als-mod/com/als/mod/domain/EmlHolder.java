package com.als.mod.domain;

import com.als.frm.comm.dto.Table;

/**
 * EmlHolder entity. @author MyEclipse Persistence Tools
 */
@Table(keyColumnName = "id", tableName = "eml_holder")
public class EmlHolder extends com.als.mod.bas.BasEntity implements
		java.io.Serializable {

	// Fields

	private String id;
	private String mailId;
	private String mailboxId;
	private String userId;
	private String newFlag;
	private String replyFlag;
	private String tag;
	private String holderType;

	// Constructors

	public String getHolderType() {
		return holderType;
	}

	public void setHolderType(String holderType) {
		this.holderType = holderType;
	}

	/** default constructor */
	public EmlHolder() {
	}

	/** minimal constructor */
	public EmlHolder(String id) {
		this.id = id;
	}

	/** full constructor */
	public EmlHolder(String id, String mailId, String mailboxId, String userId,
			String newFlag, String replyFlag, String tag, String holderType) {
		this.id = id;
		this.mailId = mailId;
		this.mailboxId = mailboxId;
		this.userId = userId;
		this.newFlag = newFlag;
		this.replyFlag = replyFlag;
		this.tag = tag;
		this.holderType = holderType;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMailId() {
		return this.mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getMailboxId() {
		return this.mailboxId;
	}

	public void setMailboxId(String mailboxId) {
		this.mailboxId = mailboxId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNewFlag() {
		return this.newFlag;
	}

	public void setNewFlag(String newFlag) {
		this.newFlag = newFlag;
	}

	public String getReplyFlag() {
		return this.replyFlag;
	}

	public void setReplyFlag(String replyFlag) {
		this.replyFlag = replyFlag;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

}