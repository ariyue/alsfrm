package com.als.mod.domain;

import com.als.frm.comm.dto.Table;

/**
 * FrmBizRule entity. @author MyEclipse Persistence Tools
 */
@Table(keyColumnName = "id", tableName = "frm_biz_rule")
public class FrmBizRule extends com.als.mod.bas.BasEntity implements
		java.io.Serializable {

	// Fields

	private String id;
	private String ruleName;
	private String processCode;
	private String entitySid;
	private String expression;
	private String expressionDesc;
	private String createDate;
	private String createTime;
	private String createUserName;
	private String createRealName;

	// Constructors

	/** default constructor */
	public FrmBizRule() {
	}

	/** minimal constructor */
	public FrmBizRule(String id, String ruleName, String processCode,
			String entitySid, String expression, String expressionDesc) {
		this.id = id;
		this.ruleName = ruleName;
		this.processCode = processCode;
		this.entitySid = entitySid;
		this.expression = expression;
		this.expressionDesc = expressionDesc;
	}

	/** full constructor */
	public FrmBizRule(String id, String ruleName, String processCode,
			String entitySid, String expression, String expressionDesc,
			String createDate, String createTime, String createUserName,
			String createRealName) {
		this.id = id;
		this.ruleName = ruleName;
		this.processCode = processCode;
		this.entitySid = entitySid;
		this.expression = expression;
		this.expressionDesc = expressionDesc;
		this.createDate = createDate;
		this.createTime = createTime;
		this.createUserName = createUserName;
		this.createRealName = createRealName;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRuleName() {
		return this.ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public String getProcessCode() {
		return this.processCode;
	}

	public void setProcessCode(String processCode) {
		this.processCode = processCode;
	}

	public String getEntitySid() {
		return this.entitySid;
	}

	public void setEntitySid(String entitySid) {
		this.entitySid = entitySid;
	}

	public String getExpression() {
		return this.expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public String getExpressionDesc() {
		return this.expressionDesc;
	}

	public void setExpressionDesc(String expressionDesc) {
		this.expressionDesc = expressionDesc;
	}

	public String getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateUserName() {
		return this.createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getCreateRealName() {
		return this.createRealName;
	}

	public void setCreateRealName(String createRealName) {
		this.createRealName = createRealName;
	}

}