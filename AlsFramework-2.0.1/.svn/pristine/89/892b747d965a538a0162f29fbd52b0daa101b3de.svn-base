package com.als.frm.cache;

public interface IFrmBasSerialCache {

	/**
	 * 更新缓存	
	 * @param module 模块
	 * @param entitySid 企业简码
	 * @param maxValue 最大值
	 */
	public void updateCache(String module, String entitySid, Long maxValue);
	
	
	/**
	 * 获取
	 * @param module
	 * @param entitySid
	 * @return
	 */
	public Long getCurrentCacheValue(String module, String entitySid);
	
	/**
	 * 服务器启动时或日切时生成新的缓存
	 */
	public void initCache();
	
	
	/**
	 * 删除缓存
	 * @param module
	 * @param entitySid
	 */
	public void removeCache(String module, String entitySid);
}
