package com.als.mod.domain;

import com.als.frm.comm.dto.Table;

/**
 * UmsMenu entity. @author MyEclipse Persistence Tools
 */
@Table(keyColumnName = "id", tableName = "ums_menu")
public class UmsMenu extends com.als.mod.bas.BasEntity implements
		java.io.Serializable {

	// Fields

	private String id;
	private String menuName;
	private String menuLevel;
	private String menuType;
	private String pid;
	private String transCode;
	private Integer rowOrder;
	private String icon;
	private String remark;
	private String menuUrl;
	private String tip;
	private String enableFlag;
	private String createRealName;
	private String createUserName;
	private String createDate;
	private String createTime;
	private String lastModifyRealName;
	private String lastModifyUserName;
	private String lastModifyDate;
	private String lastModifyTime;
	private String lastApproveOption;
	private String leftShowFlag;
	public String getLeftShowFlag() {
		return leftShowFlag;
	}

	public void setLeftShowFlag(String leftShowFlag) {
		this.leftShowFlag = leftShowFlag;
	}

	public String getComplexFlag() {
		return complexFlag;
	}

	public void setComplexFlag(String complexFlag) {
		this.complexFlag = complexFlag;
	}

	private String complexFlag;
	
	
	private String viewNamespace;
	public String getViewNamespace() {
		return viewNamespace;
	}

	public void setViewNamespace(String viewNamespace) {
		this.viewNamespace = viewNamespace;
	}

	private String exeFn;
	public String getExeFn() {
		return exeFn;
	}

	public void setExeFn(String exeFn) {
		this.exeFn = exeFn;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getMenuStyle() {
		return menuStyle;
	}

	public void setMenuStyle(String menuStyle) {
		this.menuStyle = menuStyle;
	}

	private String params;
	private String menuStyle;

	// Constructors

	/** default constructor */
	public UmsMenu() {
	}

	/** minimal constructor */
	public UmsMenu(String id) {
		this.id = id;
	}

	/** full constructor */
	public UmsMenu(String id, String menuName, String menuLevel,
			String menuType, String pid, String transCode, Integer rowOrder,
			String icon, String remark, String menuUrl, String tip,
			String enableFlag, String createRealName, String createUserName,
			String createDate, String createTime, String lastModifyRealName,
			String lastModifyUserName, String lastModifyDate,
			String lastModifyTime, String lastApproveOption, String exeFn, String params, String menuStyle) {
		this.id = id;
		this.menuName = menuName;
		this.menuLevel = menuLevel;
		this.menuType = menuType;
		this.pid = pid;
		this.transCode = transCode;
		this.rowOrder = rowOrder;
		this.icon = icon;
		this.remark = remark;
		this.menuUrl = menuUrl;
		this.tip = tip;
		this.enableFlag = enableFlag;
		this.createRealName = createRealName;
		this.createUserName = createUserName;
		this.createDate = createDate;
		this.createTime = createTime;
		this.lastModifyRealName = lastModifyRealName;
		this.lastModifyUserName = lastModifyUserName;
		this.lastModifyDate = lastModifyDate;
		this.lastModifyTime = lastModifyTime;
		this.lastApproveOption = lastApproveOption;
		
		this.exeFn = exeFn;
		this.params = params;
		this.menuStyle = menuStyle;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuLevel() {
		return this.menuLevel;
	}

	public void setMenuLevel(String menuLevel) {
		this.menuLevel = menuLevel;
	}

	public String getMenuType() {
		return this.menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	public String getPid() {
		return this.pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getTransCode() {
		return this.transCode;
	}

	public void setTransCode(String transCode) {
		this.transCode = transCode;
	}

	public Integer getRowOrder() {
		return this.rowOrder;
	}

	public void setRowOrder(Integer rowOrder) {
		this.rowOrder = rowOrder;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getMenuUrl() {
		return this.menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getTip() {
		return this.tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getEnableFlag() {
		return this.enableFlag;
	}

	public void setEnableFlag(String enableFlag) {
		this.enableFlag = enableFlag;
	}

	public String getCreateRealName() {
		return this.createRealName;
	}

	public void setCreateRealName(String createRealName) {
		this.createRealName = createRealName;
	}

	public String getCreateUserName() {
		return this.createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
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

	public String getLastModifyRealName() {
		return this.lastModifyRealName;
	}

	public void setLastModifyRealName(String lastModifyRealName) {
		this.lastModifyRealName = lastModifyRealName;
	}

	public String getLastModifyUserName() {
		return this.lastModifyUserName;
	}

	public void setLastModifyUserName(String lastModifyUserName) {
		this.lastModifyUserName = lastModifyUserName;
	}

	public String getLastModifyDate() {
		return this.lastModifyDate;
	}

	public void setLastModifyDate(String lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}

	public String getLastModifyTime() {
		return this.lastModifyTime;
	}

	public void setLastModifyTime(String lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public String getLastApproveOption() {
		return this.lastApproveOption;
	}

	public void setLastApproveOption(String lastApproveOption) {
		this.lastApproveOption = lastApproveOption;
	}

}