package com.als.frm.bas;

import java.util.List;
import java.util.Map;

import com.als.frm.comm.dto.Pagination;

public interface BasDAO<T>{

	/**
	 * insert record by jdbc for single table.
	 * 
	 * @param entity
	 * @return
	 */
	T insert(T entity);

	/**
	 * update record by jdbc for single table
	 * 
	 * @param entity
	 * @return
	 */
	T update(T entity);
	
	/**
	 * 更新(用于非泛型，采用jdbc进行)
	 * @param sql
	 * @param args
	 * @return
	 */
	int update(String sql, Object... args);

	/**
	 * delete record by jdbc for single table
	 * 
	 * @param entity
	 *            only need primary key
	 * @return
	 */
	T delete(T entity);

	/**
	 * select all by jdbc for entity condition
	 * 
	 * @param entity
	 * @return
	 */
	List<T> select(T entity);
	
	
	List select(String sql, Class clazz, Object ... args);
	
	List<Map<String, Object>> selectForList(String sql, Object ... args);
	
	/**
	 * 
	 * @param namedSql 例如："SELECT id,nick FROM user WHERE user_name=:userName AND password=:pwd";
	 * @param clazz
	 * @param args Map参数，与namedSql相对应。如：map.put("userName","Vincent"); map.put("pwd","123456");
	 * @return
	 */
	List select(String namedSql, Class clazz,Map args);
	
	Object selectForObject(String sql, Class clazz, Object ... args);
	
	/**
	 * 查询，返回整型，如查记录数
	 * @param sql 例如："select count(*) from user"
	 * @param args
	 * @return
	 */
	int selectForInt(String sql, Object ... args);
	
	/**
	 * 查出一条数据，一般是根据主键进行查，也可能根据其它条件进行查询
	 * @param entity
	 * @return　一条记录或null
	 */
	T selectOne(T entity);

	/**
	 * 
	 * @param entity
	 * @param autoMatch
	 *            autoMatch自动匹配为true时,采用like进行查询
	 * @return
	 */
	List<T> select(T entity, boolean autoMatch);

	/**
	 * 单表分页查询(如果涉及到多表，请使用ibatis进行查询
	 * 
	 * @param entity
	 * @param pagination
	 *            分页Bean,必须传入查询页码,每页记录数
	 * @return
	 */
	Pagination<T> selectByPagination(T entity, Pagination<T> pagination);

	/**
	 * 
	 * @param entity
	 * @param pagination
	 * @param autoMatch
	 *            autoMatch自动匹配为true时,采用like进行查询
	 * @return
	 */
	Pagination<T> selectByPagination(T entity, Pagination<T> pagination,
			boolean autoMatch);

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

	/**
	 * ibatis查询
	 * 
	 * @param statementId
	 *            sqlmap中的Id,由命称空间和查询ID组合成
	 * @param params
	 * @return
	 */
	//List lookup(String statementId, Map params);
	
	/**
	 * 采用ibatis查询单条数据
	 * @param statementId
	 * @param params
	 * @return
	 */
	//Map lookupOne(String statementId, Map params);

	/**
	 * ibatis分页查询
	 * 
	 * @param statementName
	 *            　查询的语句id
	 * @param sizeStatementName
	 *            查询总记录总的查询语句id
	 * @param params
	 * @param pagination
	 * @return
	 */
	//Pagination lookupByPagination(String statementName,
	//		String sizeStatementName, Map params, Pagination pagination);

}
