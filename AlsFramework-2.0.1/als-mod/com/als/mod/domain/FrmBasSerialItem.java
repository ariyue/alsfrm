package com.als.mod.domain;

import com.als.frm.comm.dto.Table;

/**
 * FrmBasSerialItem entity. @author MyEclipse Persistence Tools
 */
@Table(keyColumnName = "id", tableName = "frm_bas_serial_item")
public class FrmBasSerialItem extends com.als.mod.bas.BasEntity implements
		java.io.Serializable {

	// Fields

	private String id;
	private Long maxValue;

	// Constructors

	/** default constructor */
	public FrmBasSerialItem() {
	}

	/** full constructor */
	public FrmBasSerialItem(String id, Long maxValue) {
		this.id = id;
		this.maxValue = maxValue;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getMaxValue() {
		return this.maxValue;
	}

	public void setMaxValue(Long maxValue) {
		this.maxValue = maxValue;
	}

}