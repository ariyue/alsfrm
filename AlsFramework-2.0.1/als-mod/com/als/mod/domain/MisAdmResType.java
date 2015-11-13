package com.als.mod.domain;

import com.als.frm.comm.dto.Table;

/**
 * MisAdmResType entity. @author MyEclipse Persistence Tools
 */
@Table(keyColumnName = "id", tableName = "mis_adm_res_type")
public class MisAdmResType extends com.als.mod.bas.BasEntity implements
		java.io.Serializable {

	// Fields

	private String id;
	private String pid;
	private String name;
	private String remark;
	private Integer idx;
	private String relationship;
	private String entitySid;
	private String topManagerApprove;

	// Constructors

	/** default constructor */
	public MisAdmResType() {
	}

	/** minimal constructor */
	public MisAdmResType(String id, String pid, String name, Integer idx,
			String relationship, String entitySid, String topManagerApprove) {
		this.id = id;
		this.pid = pid;
		this.name = name;
		this.idx = idx;
		this.relationship = relationship;
		this.entitySid = entitySid;
		this.topManagerApprove = topManagerApprove;
	}

	/** full constructor */
	public MisAdmResType(String id, String pid, String name, String remark,
			Integer idx, String relationship, String entitySid,
			String topManagerApprove) {
		this.id = id;
		this.pid = pid;
		this.name = name;
		this.remark = remark;
		this.idx = idx;
		this.relationship = relationship;
		this.entitySid = entitySid;
		this.topManagerApprove = topManagerApprove;
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

	public String getEntitySid() {
		return this.entitySid;
	}

	public void setEntitySid(String entitySid) {
		this.entitySid = entitySid;
	}

	public String getTopManagerApprove() {
		return this.topManagerApprove;
	}

	public void setTopManagerApprove(String topManagerApprove) {
		this.topManagerApprove = topManagerApprove;
	}

}