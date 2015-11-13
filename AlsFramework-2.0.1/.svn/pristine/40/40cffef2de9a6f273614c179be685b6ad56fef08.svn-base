package com.als.web.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.als.frm.bas.LookupProvider;
import com.als.frm.comm.dto.AppData;

public interface IBasAction {

	/**
	 * 获取spring的bean
	 * @param beanName
	 * @return
	 */
	public Object getBean(String beanName);
	
	public LookupProvider getLookupProvider();
	
	/**
	 * 生成国际化信息
	 * @param key
	 * @param params
	 * @return
	 */
	public String generalI18nMsg(String key,Object[] params);
	
	/**
	 * 通用单表分页查询，用于grid
	 * @param appData 页面传入的参数
	 * @param bo bo全名，如:com.als.mod.domain.UmsEntity
	 * @return
	 */
	public Object lookupPage(AppData appData, String  boName);
	
	/**
	 * 处理前执行
	 * @param appData
	 */
	public void preHandle(AppData appData);
	
	public Object showMsg(String msg);
	
	
	public Object query(AppData appData);
	
	public Object command(AppData appData);
	
	//public Object queryEntity(AppData appData);
}
