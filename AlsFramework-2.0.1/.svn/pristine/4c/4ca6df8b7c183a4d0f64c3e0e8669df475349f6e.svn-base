package com.als.frm.comm.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.als.mod.bas.BaseVO;

/**
 * 数据总线
 * @author Vincent
 *
 */
public class AppData extends BaseVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Map map = new HashMap();

	private String transCode;

	private String userId;

	private String userName;
	
	private String userLanguage;
	
	private Integer pageSize;
	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNo() {
		return PageNo;
	}

	public void setPageNo(Integer pageNo) {
		PageNo = pageNo;
	}

	private Integer PageNo;

	

	public String getUserLanguage() {
		return userLanguage;
	}

	public void setUserLanguage(String userLanguage) {
		this.userLanguage = userLanguage;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public String getEntitySid() {
		return entitySid;
	}

	public void setEntitySid(String entitySid) {
		this.entitySid = entitySid;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getUserName() {
		return userName;
	}

	private String entityId;

	private String entitySid;

	private String entityName;

	private String unitId;

	private String unitName;
	
	/**
	 * grid自带SearchBox控件的查询字段
	 */
	private String searchboxKey;
	public String getSearchboxKey() {
		return searchboxKey;
	}

	public void setSearchboxKey(String searchboxKey) {
		this.searchboxKey = searchboxKey;
	}

	public String getSearchboxVal() {
		return searchboxVal;
	}

	public void setSearchboxVal(String searchboxVal) {
		this.searchboxVal = searchboxVal;
	}

	private String searchboxVal;
	
	/**
	 * grid排序字段
	 */
	private String orderField;
	
	public String getOrderField() {
		return orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	private String orderType;

	public Object setValue(Object key, Object value) {
		map.put(key, value);
		if (key.equals(KEY_PAGE_SIZE)){
			this.setPageSize(Integer.valueOf(value.toString()) );
		}
		
		if (key.equals(KEY_PAGE_NO)){
			this.setPageNo(Integer.valueOf(value.toString()) );
		}
		
		if (key.equals(KEY_ORDER_FIELD)){
			this.setOrderField(value.toString());
		}
		
		if (key.equals(KEY_ORDER_TYPE)){
			this.setOrderType(value.toString());
		}
		
		if (key.equals(KEY_SEARCHBOX_KEY)){
			this.setSearchboxKey(value.toString());
		}
		
		if (key.equals(KEY_SEARCHBOX_VAL)){
			this.setSearchboxVal(value.toString());
		}
		return this;
	}

	public Object setValue(Map values) {
		map.putAll(values);
		return this;
	}

	public Object getValue(Object key) {

		return this.getMap().get(key);
	}

	/**
	 * 交易码
	 */
	public static final String KEY_TRANS_CODE = "_trans_code";

	/**
	 * 用户
	 */
	public static final String KEY_USER_ID = "_biz_user_id";

	public static final String KEY_USER_NAME = "_biz_user_name";
	
	public static final String KEY_USER_LANGUAGE = "_biz_user_language";
	
	public static final String KEY_PAGE_SIZE = "rows";
	public static final String KEY_PAGE_NO = "page";

	public static final String KEY_ORDER_FIELD = "orderField";
	public static final String KEY_ORDER_TYPE = "orderType";
	
	public static final String KEY_SEARCHBOX_KEY = "searchboxKey";
	public static final String KEY_SEARCHBOX_VAL = "searchboxVal";
	
	public Map getMap() {

		map.put(KEY_TRANS_CODE, this.getTransCode());
		map.put(KEY_USER_ID, this.getUserId());
		map.put(KEY_USER_NAME, this.getUserName());
		map.put(KEY_USER_LANGUAGE, this.getUserLanguage());
		map.put(KEY_PAGE_SIZE, this.getPageSize());
		map.put(KEY_PAGE_NO, this.getPageNo());
		map.put(KEY_ORDER_FIELD, this.getOrderField());
		map.put(KEY_ORDER_TYPE, this.getOrderType());
		
		map.put(KEY_SEARCHBOX_KEY, this.getSearchboxKey());
		map.put(KEY_SEARCHBOX_VAL, this.getSearchboxVal());
		return map;
	}

	public String getTransCode() {
		return transCode;
	}

	public void setTransCode(String transCode) {
		this.transCode = transCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
