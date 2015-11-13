package com.als.mod.domain;

import com.als.frm.comm.dto.Table;

/**
 * AmsProject entity. @author MyEclipse Persistence Tools
 */
@Table(keyColumnName = "id", tableName = "ams_project")
public class AmsProject extends com.als.mod.bas.BasEntity implements
		java.io.Serializable {

	// Fields

	private String id;
	private String pid;
	private String name;
	private String remark;
	private Integer idx;
	private String relationship;

	private String entitySid;
	

	// Constructors

	public String getEntitySid() {
		return entitySid;
	}

	public void setEntitySid(String entitySid) {
		this.entitySid = entitySid;
	}

	/** default constructor */
	public AmsProject() {
	}

	/** minimal constructor */
	public AmsProject(String id, String pid, String name, Integer idx,
			String relationship) {
		this.id = id;
		this.pid = pid;
		this.name = name;
		this.idx = idx;
		this.relationship = relationship;
	}

	/** full constructor */
	public AmsProject(String id, String pid, String name, String remark,
			Integer idx, String relationship) {
		this.id = id;
		this.pid = pid;
		this.name = name;
		this.remark = remark;
		this.idx = idx;
		this.relationship = relationship;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPid() {
		return this.pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getIdx() {
		return this.idx;
	}

	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public String getRelationship() {
		return this.relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

}