package com.als.frm.cache;

import java.util.List;
import java.util.Map;

import com.als.mod.domain.FrmBasConstant;

public interface IFrmBasConstantCache {

	/**
	 * 更新常量
	 * @param conName
	 * @param entitySid
	 * @param constantList
	 */
	public int updateConstantList(String conName, String entitySid,List constantList);
	
	/**
	 * 获取常量列表
	 * @param conName
	 * @param entitySid
	 * @return
	 */
	public List getConstantList(String conName, String entitySid);
	
	/**
	 * 获取空行设置
	 * @return
	 */
	public FrmBasConstant getBlankLineFrmBasConstant();
	
	/**
	 * 获取指定的常量单行数据
	 * @param itemCode
	 * @param list
	 * @return
	 */
	public Map getConstantByCode(String itemCode, List<Map> list);
	
	/**
	 * 获取常量文字
	 * @param itemCode
	 * @param list
	 * @return
	 */
	public String getText(String itemCode, List<Map> list);
	
	/**
	 * 更新缓存
	 * @param code
	 * @param entitySid
	 * @param itemList
	 */
	public void cacheConstant(String code, String entitySid);
	
	public void initCache();
}
