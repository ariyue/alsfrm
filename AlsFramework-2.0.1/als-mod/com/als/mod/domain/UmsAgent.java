package com.als.mod.domain;

import com.als.frm.comm.dto.Table;

/**
 * UmsAgent entity. @author MyEclipse Persistence Tools
 */
@Table(keyColumnName = "id", tableName = "ums_agent")
public class UmsAgent extends com.als.mod.bas.BasEntity implements
		java.io.Serializable {

	// Fields

	private String id;
	private UmsUser umsUser;
	private String birthday;
	private String email;
	private String phone;
	private String agentLevel;

	// Constructors

	/** default constructor */
	public UmsAgent() {
	}

	/** minimal constructor */
	public UmsAgent(String id, UmsUser umsUser) {
		this.id = id;
		this.umsUser = umsUser;
	}

	/** full constructor */
	public UmsAgent(String id, UmsUser umsUser, String birthday, String email,
			String phone, String agentLevel) {
		this.id = id;
		this.umsUser = umsUser;
		this.birthday = birthday;
		this.email = email;
		this.phone = phone;
		this.agentLevel = agentLevel;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UmsUser getUmsUser() {
		return this.umsUser;
	}

	public void setUmsUser(UmsUser umsUser) {
		this.umsUser = umsUser;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAgentLevel() {
		return this.agentLevel;
	}

	public void setAgentLevel(String agentLevel) {
		this.agentLevel = agentLevel;
	}

}