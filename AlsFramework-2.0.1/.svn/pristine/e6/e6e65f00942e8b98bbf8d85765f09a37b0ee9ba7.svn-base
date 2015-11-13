package com.als.mod.domain;

import com.als.frm.comm.dto.Table;

/**
 * FrmBasSerial entity. @author MyEclipse Persistence Tools
 */
                                          
@Table(keyColumnName = "id", tableName = "frm_bas_serial")
public class FrmBasSerial extends com.als.mod.bas.BasEntity implements
		java.io.Serializable {

	// Fields

	private String id;
	private String module;
	private String entitySid;
	private Long cacheSize;
	private String prefix;
	private String subfix;

	// Constructors

	/** default constructor */
	public FrmBasSerial() {
	}

	/** minimal constructor */
	public FrmBasSerial(String id, String module, String entitySid) {
		this.id = id;
		this.module = module;
		this.entitySid = entitySid;
	}

	/** full constructor */
	public FrmBasSerial(String id, String module, String entitySid,
			Long maxValue, Long cacheSize, String prefix, String subfix) {
		this.id = id;
		this.module = module;
		this.entitySid = entitySid;
		this.cacheSize = cacheSize;
		this.prefix = prefix;
		this.subfix = subfix;
	}

	// Property accessors

	

	public Long getCacheSize() {
		return cacheSize;
	}

	public void setCacheSize(Long cacheSize) {
		this.cacheSize = cacheSize;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModule() {
		return this.module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getEntitySid() {
		return this.entitySid;
	}

	public void setEntitySid(String entitySid) {
		this.entitySid = entitySid;
	}

	

	public String getPrefix() {
		return this.prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getSubfix() {
		return this.subfix;
	}

	public void setSubfix(String subfix) {
		this.subfix = subfix;
	}

}