package com.als.mod.domain;

import com.als.frm.comm.dto.Table;

/**
 * EmlTemplate entity. @author MyEclipse Persistence Tools
 */
@Table(keyColumnName = "id", tableName = "eml_template")
public class EmlTemplate extends com.als.mod.bas.BasEntity implements
		java.io.Serializable {

	// Fields

	private String id;
	private String templateType;
	private String name;
	private String content;

	// Constructors

	/** default constructor */
	public EmlTemplate() {
	}

	/** minimal constructor */
	public EmlTemplate(String id) {
		this.id = id;
	}

	/** full constructor */
	public EmlTemplate(String id, String templateType, String name,
			String content) {
		this.id = id;
		this.templateType = templateType;
		this.name = name;
		this.content = content;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTemplateType() {
		return this.templateType;
	}

	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}