package com.als.frm.bas.dao.mybt;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import com.als.frm.bas.dao.Operator;

@Repository("myBatisBasMapper")
public interface MybatisBasMapper<T> {

	@InsertProvider(type = MybatisBasTemplate.class,method = "insert")
	public void insert(T entity);
	
	@UpdateProvider(type = MybatisBasTemplate.class,method = "update")
	public void update(T entity);
	
	@DeleteProvider(type = MybatisBasTemplate.class,method = "delete")
	public void delete(T entity);
	
	/**
	 * 
	 * @param entity 实体 即条件
	 * @param opMap 操作符，key为实体中的属性名，value为操作符
	 * @param orderList 排序列表，期中的Object[]{"EntityFiled", OrderType}
	 * @return
	 */
	//@SelectProvider(type = MybatisBasTemplate.class,method = "get")
	//@ResultMap()
	//List<Map> get(T entity);
	
	/**
	 * 
	 * @param entity 实体 即条件
	 * @param opMap 操作符，key为实体中的属性名，value为操作符
	 * @param orderList 排序列表，期中的Object[]{"EntityFiled", OrderType}
	 * @return
	 */
	//@SelectProvider(type = MybatisBasTemplate.class,method = "findBy")
	//List<Map> findBy(T entity, Map<String,Operator> opMap, List<Object[]> orderList);
	
	@SelectProvider(type = MybatisBasTemplate.class,method = "select")
	List<Map> select(Map params);
	
	/**
	 * 分页时统计分页计录总数
	 * @param params
	 * @return
	 */
	@SelectProvider(type = MybatisBasTemplate.class,method = "selectCount")
	Integer selectCount(Map params);
	
	/**
	 * 查询分页数据
	 * @param params
	 * @return
	 */
	@SelectProvider(type = MybatisBasTemplate.class,method = "selectPage")
	List<Map> selectPage(Map params);
	
	/**
	 * 批量插入数据
	*
	 * @param data
	 * 实体类
	 * @return 主键值
	*/
	public void batchInsert(List<T> data);
	
	
	
	/**
	 * 批量替换数据
	*
	 * @param data
	 * 实体类
	 * @return 主键值
	*/
	public void batchUpdate(List<T> data);
	
	
	
	//List<T> select(T entity);
	
	//List<T> select(T entity, Map<String,Operator> opMap);
	
	//List<T> select(T entity, Map<String,Operator> opMap, String orderField, OrderType od);
	
}
