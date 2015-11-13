package com.als.frm.module.frm.biz;

import java.util.Map;

import com.als.frm.comm.dto.AppData;
import com.als.frm.comm.dto.Pagination;

public interface FrmBasSerialBIZ {

	/**
	 * 获取所有主键策略列表
	 * @return
	 */
	Pagination<Map<String, Object>>  getSerialList(AppData appData);
	
	/**
	 * 获取主键策略Item列表
	 * @return
	 */
	Pagination<Map<String, Object>>  getSerialItemList(AppData appData);
	
	
	/**
	 * 保存主键策略
	 * @return
	 */
	Pagination<Map<String, Object>>  saveSerial(AppData appData);
	
	/**
	 * 更新最大缓存值
	 * @param itemId
	 */
	public void updateItemMaxValue(AppData appData);
	
	/**
	 * 保存主键策略
	 * @return
	 */
	Pagination<Map<String, Object>>  removeSerial(AppData appData);
}
