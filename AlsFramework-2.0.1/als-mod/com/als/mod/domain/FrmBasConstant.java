package com.als.mod.domain;

import com.als.frm.comm.dto.Table;

/**
 * FrmBasConstant entity. @author MyEclipse Persistence Tools
 */
@Table(keyColumnName = "id", tableName = "frm_bas_constant")
public class FrmBasConstant extends com.als.mod.bas.BasEntity implements
		java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String code;
	private String itemCode;
	private String itemText;
	private Integer rowOrder;
	private String entitySid;
	private String remark;

	// Constructors

	/** default constructor */
	public FrmBasConstant() {
	}

	/** minimal constructor */
	public FrmBasConstant(String id) {
		this.id = id;
	}

	/** full constructor */
	public FrmBasConstant(String id, String name, String code, String itemCode,
			String itemText, Integer rowOrder, String entityId, String remark) {
		this.id = id;
		this.name = name;
		this.code = code;
		this.itemCode = itemCode;
		this.itemText = itemText;
		this.rowOrder = rowOrder;
		this.entitySid = entityId;
		this.remark = remark;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getItemCode() {
		return this.itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemText() {
		return this.itemText;
	}

	public void setItemText(String itemText) {
		this.itemText = itemText;
	}

	public Integer getRowOrder() {
		return this.rowOrder;
	}

	public void setRowOrder(Integer rowOrder) {
		this.rowOrder = rowOrder;
	}

	

	public String getEntitySid() {
		return entitySid;
	}

	public void setEntitySid(String entitySid) {
		this.entitySid = entitySid;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}