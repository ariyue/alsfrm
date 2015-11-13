package com.als.frm.bas.dao;

import java.util.List;
import java.util.Map;

import com.als.frm.comm.dto.Pagination;

public interface IBasDAOFacade<T> {

	//jdbc---------------------------------
	/**
	 * 采用JDBC单表操入
	 */
	public T insert(T entity);

	/**
	 * 采用jdbc单表更新
	 * @param entity
	 * @return
	 */
	T update(T entity);
	
	/**
	 * 采用jdbc单表更新
	 * @param namedSql
	 * @param args
	 * @return
	 */
	int update(String namedSql, Map<String, Object> args);

	/**
	 * 采用jdbc单表删除
	 * @param entity
	 * @return
	 */
	T delete(T entity);

	/**
	 * 采用jdbc单表查询
	 * @param entity
	 * @return
	 */
	List<T> select(T entity);
	
	T selectOne(T entity);
	
	List<T> select(T entity, Map<String,Operator> opMap, List<Object[]> orderList);
	Pagination<T> selectPageByJdbc(T entity, Map<String, Operator> opMap, List<Object[]> orderList, Pagination<T> pagination);
	
	/**
	 * 批量更新表数据(包括批量新增、修改、删除)
	 * 
	 * @param namedSql
	 *            　采用named的sql,如：update user_ys set role = :role where userId =
	 *            :userId
	 * @param list
	 *            要更新列表,数据条可以是实体BEAN，也可以是map
	 * @return 更新的记录数
	 */
	@SuppressWarnings("unchecked")
	int batchUpdate(String namedSql, List list);

	/**
	 * 批量更新表数据(包括批量新增、修改、删除)
	 * 
	 * @param namedSql
	 *            采用named的sql,如：update user_ys set role = :role where userId =
	 *            :userId
	 * @param entityAry
	 *            多条实体的数组
	 * @return 更新的记录数
	 */
	int batchUpdate(String namedSql, T[] entityAry);
	
	

	/**
	 * 批量更新表数据(包括批量新增、修改、删除)
	 * 
	 * @param namedSql
	 *            采用named的sql,如：update user_ys set role = :role where userId =
	 *            :userId
	 * @param mapAry
	 *            多条Map的数组
	 * @return 更新的记录数
	 */
	int batchUpdate(String namedSql, Map[] mapAry);
	
	/**
	 * 采用jdbc的批量更新
	 * @param sql 例如："insert into user(id,name)values(?,?)"
	 * @param parameters 参数列表
	 * 
	 * 用法：
	   String sql = "insert into user(id,name)values(?,?)";  
        List<Object[]> parameters = new ArrayList<Object[]>();  
        for (User u : users) {  
            parameters.add(new Object[] { u.getId(), u.getName() });  
        }  
        batchUpdateBySql(sql, parameters);  
	 */
	void batchUpdateBySql(String sql, List<Object[]> parameters);
	//jdbc end --------------------------------
	
	//mybatis---------------------------------
	public T insertByMybatis(T entity);

	T updateByMybatis(T entity);

	T deleteByMybatis(T entity);

	List<T> selectByMybatis(T entity);
	List<T> selectByMybatis(T entity, Map<String,Operator> opMap, List<Object[]> orderList);
	Pagination<T> selectPageByMybatis(T entity, Map<String, Operator> opMap, List<Object[]> orderList, Pagination<T> pagination);
	Pagination<Map> selectPageMapByMybatis(T entity, Map<String, Operator> opMap, List<Object[]> orderList, Pagination<Map> pagination);

	//mybatis end --------------------------------
	
	 /**
	  * 采用jdbc查询
	  * @param sql 例如：select id,menu_name from ums_menu where menu_type=:type and pid=:pid
	  * @param args 参数 
	  * @return
	  */
	 List<Map<String, Object>> select(String sql, Map<String,Object> args);
	 
	 Pagination<Map<String, Object>> selectPage(String sql, Map<String, Object> args,
				Pagination<Map<String, Object>> pagination);
}
