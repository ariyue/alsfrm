package com.als.frm.bas.dao.jdbc;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.als.frm.bas.dao.IBasDAO;
import com.als.frm.bas.dao.Operator;
import com.als.frm.bas.dao.OrderType;
import com.als.frm.bas.dao.TableParser;
import com.als.frm.bas.dao.dialect.Dialect;
import com.als.frm.comm.dto.Pagination;
import com.als.frm.comm.util.BeanUtil;
import com.als.frm.comm.util.ConvertUtil;
import com.als.frm.ex.DaoException;
import com.als.frm.spr.SpringContextUtil;
@Repository("jdbcBasDAOSupport")
public class JdbcBasDAOSupport<T> implements IBasDAO<T>{

	@Autowired
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	@Autowired
	private SimpleJdbcDaoSupport simpleJdbcDaoSupport;
	
	public SimpleJdbcTemplate getSimpleJdbcTemplate() {
		return simpleJdbcTemplate;
	}
	
	public SimpleJdbcDaoSupport getSimpleJdbcDaoSupport() {
		return simpleJdbcDaoSupport;
	}

	public void setSimpleJdbcDaoSupport(
			SimpleJdbcDaoSupport simpleJdbcDaoSupport) {
		this.simpleJdbcDaoSupport = simpleJdbcDaoSupport;
	}

	
	//@Autowired
	private Dialect dialect;
	
	private Dialect getDialect(){
		if (this.dialect == null){
			return (Dialect) SpringContextUtil.getBean("dialect");
		}
		return dialect;
	}
	
	@Override
	public T delete(T entity) {
		String[] entityDef = TableParser.getEntityDef(entity);
		String tableName = entityDef[0];
		String keyColumnName = entityDef[1];
		String keyPropertyName = ConvertUtil
				.convert2PropertyName(keyColumnName);
		/*String sql = "delete from " + tableName + " where " + keyColumnName
				+ "=:" + keyPropertyName + "";*/
		
		StringBuffer sqlBuffer =new StringBuffer("delete from " + tableName + " where 1=1");
		Field[] fields = entity.getClass().getDeclaredFields();
		int size = fields.length;
		String fieldName = "";
		String columnName = "";
		try {
			for (int i = 0; i < size; i++) {

				Field field = fields[i];
				field.setAccessible(true); // 这句使我们可以访问似有成员变量
				fieldName = field.getName();
				columnName = ConvertUtil.convert2ColumnName(fieldName);
				Object value = field.get(entity);
				if (!fieldName.equals("serialVersionUID") && value != null
						//&& !keyColumnName.equals(columnName)
						) {
					
					sqlBuffer.append(" and " + columnName + " =:" + fieldName + "");
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("框架错误：自动组装insert的sql语句出错!");
		} 
		this.simpleJdbcTemplate.update(sqlBuffer.toString(),
				new BeanPropertySqlParameterSource(entity));
		return entity;
	}

	@Override
	public T insert(T entity) {

		String tableName = TableParser.getEntityDef(entity)[0];
		SimpleJdbcInsert insertActor = getSimpleJdbcInsert();
		insertActor.setTableName(tableName);
		insertActor.execute(new BeanPropertySqlParameterSource(entity));
		/*try {
			
		} catch (Exception e) {
			throw new Exception("插入数据库出错");
		}*/
		return entity;
	}

	@Override
	public T update(T entity) {
		String[] entityDef = TableParser.getEntityDef(entity);
		String tableName = entityDef[0];
		String keyColumnName = entityDef[1];

		StringBuffer sqlBuffer = new StringBuffer();
		try {
			String keyPropertyName = ConvertUtil
					.convert2PropertyName(keyColumnName);
			Object keyColumnValue = BeanUtil.getFieldValueInAllSuper(entity,
					ConvertUtil.convert2PropertyName(keyPropertyName));
			if (keyColumnValue == null) {
				throw new RuntimeException("框架错误：无法根据主键[" + keyPropertyName
						+ "]进行单条数据的更新,因为其值为null!");
			}
			sqlBuffer.append("update " + tableName + " set ");
			Field[] fields = entity.getClass().getDeclaredFields();
			int size = fields.length;

			boolean needAnd = false;
			String fieldName = "";
			String columnName = "";
			for (int i = 0; i < size; i++) {

				Field field = fields[i];
				field.setAccessible(true); // 这句使我们可以访问似有成员变量
				fieldName = field.getName();
				columnName = ConvertUtil.convert2ColumnName(fieldName);
				Object value = field.get(entity);
				if (!fieldName.equals("serialVersionUID") && value != null
						&& !keyColumnName.equals(columnName)) {
					if (needAnd) {
						sqlBuffer.append(" , ");
					} else {
						needAnd = true;
					}
					sqlBuffer.append(columnName + " =:" + fieldName + "");
				}
			}
			sqlBuffer.append(" WHERE " + keyColumnName + " =:"
					+ keyPropertyName + "");
		} catch (Exception e) {
			throw new RuntimeException("框架错误：自动组装insert的sql语句出错!");
		}
		String sql = sqlBuffer.toString();
		//LogHelper.getLogger().info("执行的sql语句：" + sql);
		//LogHelper.getLogger().info("传入的参数：" + entity.toString());
		this.simpleJdbcTemplate.update(sql,
				new BeanPropertySqlParameterSource(entity));
		return entity;
	}

	@Override
	public void batchInsert(List<T> data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void batchUpdate(List<T> data) {

		
		
	}

	@Override
	public List<T> select(T entity, Map<String, Operator> opMap) {

		return this.select(entity, opMap, null);
	}

	@Override
	public List<T> select(T entity) {
		
		return this.select(entity, null, null);
	}
	
	@Override
	public List<T> select(T entity, Map<String, Operator> opMap,
			String orderField, OrderType od) {
		List orderList = new ArrayList(1);
		orderList.add(new HashMap().put(orderField, od));
		return this.select(entity, opMap, orderList);
	}
	
	@Override
	public List<T> select(T entity, Map<String,Operator> opMap, List<Object[]> orderList) {

		String sql = JdbcSqlGenerator.getInstance().createEntitySelectSql(entity, false, opMap, orderList);
			
			//createSelectSql(entity, false, opMap,null);
		return (List<T>) this.simpleJdbcTemplate.query(sql,
				ParameterizedBeanPropertyRowMapper.newInstance(entity
						.getClass()),
				new BeanPropertySqlParameterSource(entity));
	}
	
	
	@Override
	public Pagination<T> selectPage(T entity, Map<String, Operator> opMap,
			List<Object[]> orderList, Pagination<T> pagination) {
		String sql = JdbcSqlGenerator.getInstance().createEntitySelectSql(entity, false, opMap, orderList);
		int pageSize = pagination.getPageSize();
		String pagingSql = this.getDialect().getLimitString(sql, (pagination.getPageNo() - 1) * pageSize, pageSize);
		List<T> dataList = (List<T>) this.simpleJdbcTemplate.query(pagingSql,
				ParameterizedBeanPropertyRowMapper.newInstance(entity
						.getClass()),
				new BeanPropertySqlParameterSource(entity));

		String countSql = JdbcSqlGenerator.getInstance().createEntitySelectSql(entity, true, opMap, orderList);
		int count = this.simpleJdbcTemplate
				.getNamedParameterJdbcOperations().queryForInt(countSql,
						new BeanPropertySqlParameterSource(entity));
		double totalPage = Math.ceil((double) count / pageSize);

		pagination.setDataList(dataList);
		pagination.setTotal(count);
		pagination.setTotalPage((int) totalPage);
		pagination.setLastPageSize(count % pageSize);
		return pagination;
	}
	
	public SimpleJdbcInsert getSimpleJdbcInsert() {

		return new SimpleJdbcInsert(this.getSimpleJdbcDaoSupport()
				.getJdbcTemplate());
	}

	public SimpleJdbcInsert getSimpleJdbcInsert(String tableName) {
		return new SimpleJdbcInsert(this.getSimpleJdbcDaoSupport()
				.getJdbcTemplate());
	}

	@Override
	public void  batchDeleteById( List<T> data){
		if (data == null || data.size() == 0){
			return;
		}
		
		String[] entityDef = TableParser.getEntityDef(data.get(0));
		String namedSql="delete from " + entityDef[0] + " where "+entityDef[1]+"=:" + entityDef[1];
		this.simpleJdbcTemplate.batchUpdate(namedSql,
				SqlParameterSourceUtils.createBatch(data.toArray()));
		
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public int batchUpdate(String namedSql, List list) {

		this.getSimpleJdbcTemplate().batchUpdate(namedSql,
				SqlParameterSourceUtils.createBatch(list.toArray()));
		return list.size();
	}

	
	@Override
	@SuppressWarnings("deprecation")
	public int update(String namedSql, Map<String, Object> args) {

		return this.getSimpleJdbcTemplate().update(namedSql, args);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public int batchUpdate(String namedSql, T[] entityAry) {

		
		this.getSimpleJdbcTemplate().batchUpdate(namedSql,
				SqlParameterSourceUtils.createBatch(entityAry));
		return entityAry.length;
	}

	@SuppressWarnings("deprecation")
	@Override
	public int batchUpdate(String namedSql, Map[] mapAry) {

		this.getSimpleJdbcTemplate().batchUpdate(namedSql,
				SqlParameterSourceUtils.createBatch(mapAry));
		return mapAry.length;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void batchUpdateBySql(String sql, List<Object[]> parameters) {
		
		this.getSimpleJdbcTemplate().batchUpdate(sql, parameters); 
	}

	@Override
	public T selectOne(T entity) {
		List<T> list = this.select(entity);
		if (list.size() > 0){
			return list.get(0);
		} else {
			//throw new RuntimeException("框架错误：采用selectOne进行查询，未查到指定记录！");
			return null;
		}
	}

	@Override
	public List<Map<String, Object>> select(String sql, Map<String,Object> args) {

		return this.getSimpleJdbcTemplate().queryForList(sql, args);
	}

	@Override
	public Pagination<Map<String, Object>> selectPage(String sql, Map<String, Object> args,
			Pagination<Map<String, Object>> pagination) {
		int pageSize = pagination.getPageSize();
		String pagingSql = this.getDialect().getLimitString(sql, (pagination.getPageNo() - 1) * pageSize, pageSize);
		List<Map<String, Object>> dataList = this.getSimpleJdbcTemplate().queryForList(pagingSql, args);
		pagination.setDataList(dataList);
		
		int index = sql.toUpperCase().indexOf("FROM");
		
		String countSql = "select 1 " + sql.substring(index);
		countSql = "select count('x') from ( " + countSql + ") subview4count";//采用子查询，以防采用group by 时的分页有统计有问题
		int count = this.getSimpleJdbcTemplate().queryForInt(countSql, args);
		double totalPage = Math.ceil((double) count / pageSize);
		
		pagination.setTotal(count);
		pagination.setTotalPage((int) totalPage);
		pagination.setLastPageSize(count % pageSize);
		return pagination;
		
	}
	
	public static void main(String[] args) {
		
		String sql = "select id,menu_name from ums_menu";
		int index = sql.toUpperCase().indexOf("FROM");
		
		String c = "select count('x') " + sql.substring(index);
		System.out.println(c);
		
	}

	@Override
	public Pagination<Map> selectPageMybatis(T entity,
			Map<String, Operator> opMap, List<Object[]> orderList,
			Pagination<Map> pagination) {
		throw new DaoException("请使用mybatisBasDAOSupport进行批量操作！");
	}
	
}
