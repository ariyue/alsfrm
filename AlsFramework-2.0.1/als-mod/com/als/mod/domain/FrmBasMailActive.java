package com.als.mod.domain;

import com.als.frm.comm.dto.Table;

/**
 * FrmBasMailActive entity. @author MyEclipse Persistence Tools
 */
@Table(keyColumnName = "id", tableName = "frm_bas_mail_active")
public class FrmBasMailActive extends com.als.mod.bas.BasEntity implements
		java.io.Serializable {

	// Fields

	private String id;
	private String code;
	private String createDate;

	// Constructors

	/** default constructor */
	public FrmBasMailActive() {
	}

	/** minimal constructor */
	public FrmBasMailActive(String id, String code) {
		this.id = id;
		this.code = code;
	}

	/** full constructor */
	public FrmBasMailActive(String id, String code, String createDate) {
		this.id = id;
		this.code = code;
		this.createDate = createDate;
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

	public String getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

}