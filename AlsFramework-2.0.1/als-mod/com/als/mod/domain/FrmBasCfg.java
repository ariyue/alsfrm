package com.als.mod.domain;

import com.als.frm.comm.dto.Table;

/**
 * FrmBasCfg entity. @author MyEclipse Persistence Tools
 */
@Table(keyColumnName = "id", tableName = "frm_bas_cfg")
public class FrmBasCfg extends com.als.mod.bas.BasEntity implements
		java.io.Serializable {

	// Fields

	private String id;
	private String code;
	private String name;
	private String val;
	private String remark;
	private String entitySid;

	// Constructors

	public String getEntitySid() {
		return entitySid;
	}

	public void setEntitySid(String entitySid) {
		this.entitySid = entitySid;
	}

	/** default constructor */
	public FrmBasCfg() {
	}

	/** minimal constructor */
	public FrmBasCfg(String id) {
		this.id = id;
	}

	/** full constructor */
	public FrmBasCfg(String id, String code, String name, String val,
			String remark) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.val = val;
		this.remark = remark;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVal() {
		return this.val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}