package com.als.ums.module.ums.biz;

import java.util.List;
import java.util.Map;

import com.als.mod.domain.UmsEntityProduct;

public interface UmsEntityProductBIZ {

	
	/**
	 * 获取已开通的模块列表
	 * @param entitySid
	 * @return
	 */
	List<Map<String, Object>> getOpendProducts(String entitySid);
	
	/**
	 * 获取已开通可用的模块列表（即未过期）
	 * @param entitySid
	 * @return
	 */
	List<Map<String, Object>> getEnableProducts(String entitySid);
	
	/**
	 * 获取未开通的模块列表
	 * @param entitySid
	 * @return
	 */
	List<Map<String, Object>> getUnOpendProducts(String entitySid);
	
	
	
	
	UmsEntityProduct addEntity(UmsEntityProduct entity);
	
	UmsEntityProduct updateEntity(UmsEntityProduct entity);
	
	UmsEntityProduct removeEntity(UmsEntityProduct entity);
	
}
