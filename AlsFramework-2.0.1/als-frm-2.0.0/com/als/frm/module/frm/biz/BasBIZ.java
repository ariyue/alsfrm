package com.als.frm.module.frm.biz;

import java.util.Map;

import com.als.frm.comm.dto.AppData;
import com.als.frm.comm.dto.Pagination;
import com.als.mod.bas.BasEntity;

/**
 * 基本的BIZ
 * @author Administrator
 *
 */
public interface BasBIZ {

	BasEntity addEntity (BasEntity entity);
	BasEntity modifyEntity (BasEntity entity);
	BasEntity removeEntity (BasEntity entity);
	int removeEntitiesByIds(String ids);
	BasEntity saveEntity(BasEntity entity, String newIdValue);
	
	/**
	 * 采用jdbc查询,一般在grid控件中使用
	 * @param appData
	 * @param sql,数据库sql语名，不得含有where子句
	 * @return
	 */
	public Pagination<Map<String, Object>> queryPageList(AppData appData, String sql);
}
