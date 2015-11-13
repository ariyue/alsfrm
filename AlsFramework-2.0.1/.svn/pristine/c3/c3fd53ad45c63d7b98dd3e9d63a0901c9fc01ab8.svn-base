package com.als.frm.bas;

import java.util.List;
import java.util.Map;

import com.als.frm.bas.dao.Operator;
import com.als.frm.comm.dto.Pagination;



/**
 * 采用ibatis的查询
 * @author Vincent
 *
 */
public interface ILookupProvider {
	
	
	/**
	 * 查询
	 * @param entity 查询实体BO及设置查询条件
	 * @param opMap 查询条件的操作符
	 * @param orderList 排列字段列表
	 * @return
	 */
	public List lookup(Object entity, Map<String, Operator> opMap,
			List<Object[]> orderList);
	
	/**
	 * 查询
	 * @param entity 查询实体BO及设置查询条件
	 * @param opMap 查询条件的操作符
	 * @return
	 */
	public List lookup(Object entity, Map<String, Operator> opMaporderList);
	
	/**
	 * 分页查询
	 * @param entity
	 * @param opMap
	 * @param orderList
	 * @param pagination
	 * @return
	 */
	public Pagination lookupPage(Object entity, Map<String, Operator> opMap,
			List<Object[]> orderList, Pagination pagination);
}
