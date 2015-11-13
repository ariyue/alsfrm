package com.als.mod.domain;

import com.als.frm.comm.dto.Table;

/**
 * EmlSetting entity. @author MyEclipse Persistence Tools
 */
@Table(keyColumnName = "id", tableName = "eml_setting")
public class EmlSetting extends com.als.mod.bas.BasEntity implements
		java.io.Serializable {

	// Fields

	private String id;
	private String userId;
	private String skinId;
	private String remindSound;
	private String layout;

	// Constructors

	/** default constructor */
	public EmlSetting() {
	}

	/** minimal constructor */
	public EmlSetting(String id) {
		this.id = id;
	}

	/** full constructor */
	public EmlSetting(String id, String userId, String skinId,
			String remindSound, String layout) {
		this.id = id;
		this.userId = userId;
		this.skinId = skinId;
		this.remindSound = remindSound;
		this.layout = layout;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSkinId() {
		return this.skinId;
	}

	public void setSkinId(String skinId) {
		this.skinId = skinId;
	}

	public String getRemindSound() {
		return this.remindSound;
	}

	public void setRemindSound(String remindSound) {
		this.remindSound = remindSound;
	}

	public String getLayout() {
		return this.layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

}