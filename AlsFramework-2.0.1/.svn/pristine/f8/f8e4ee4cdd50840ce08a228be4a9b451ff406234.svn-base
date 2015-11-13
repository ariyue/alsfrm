package com.als.frm.bas;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import com.als.frm.bas.dao.dialect.Dialect;
import com.als.frm.comm.dto.Pagination;
import com.als.frm.comm.dto.Table;
import com.als.frm.comm.util.BeanUtil;
import com.als.frm.comm.util.ConvertUtil;

public class BasDAOImpl<T> implements BasDAO<T> {

	//@Autowired
	//private SqlMapClientTemplate sqlMapClientTemplate;
	
	@Autowired
	private SimpleJdbcDaoSupport simpleJdbcDaoSupport;
	
	//@Autowired
	//private ILookupProvider lookupProvider;
	
	/*public ILookupProvider getLookupProvider() {
		return lookupProvider;
	}

	public void setLookupProvider(ILookupProvider lookupProvider) {
		this.lookupProvider = lookupProvider;
	}*/

	private Dialect dialect;

	public Dialect getDialect() {
		return dialect;
	}

	public void setDialect(Dialect dialect) {
		this.dialect = dialect;
	}

	public SimpleJdbcDaoSupport getSimpleJdbcDaoSupport() {
		return simpleJdbcDaoSupport;
	}

	public void setSimpleJdbcDaoSupport(
			SimpleJdbcDaoSupport simpleJdbcDaoSupport) {
		this.simpleJdbcDaoSupport = simpleJdbcDaoSupport;
	}

	@Autowired
	private SimpleJdbcTemplate simpleJdbcTemplate;

	

	public static void main(String[] args) {

		int t = 11;
		int s = 10;

		double temp = Math.ceil((double) t / s);
		int totalPage = (int) temp;
		System.out.println(totalPage);
	}

	/**
	 * 从Tabel注解中获取参数，目前只有表名，主键字段列名 如果以后要加其它的字段，在返回的字符串数组后面依次加，保证不影响以前的业务
	 */
	private String[] getEntityDef(T entity) {

		Class c = entity.getClass();
		String tableName = "";
		String keyColumnName = "";
		boolean falg = c.isAnnotationPresent(Table.class);
		if (falg) { // 分析是否带有Table注解，此外分析的还少一句不存在时的处理
			Table t = (Table) c.getAnnotation(Table.class);
			tableName = t.tableName();
			keyColumnName = t.keyColumnName();
			return new String[] { tableName, keyColumnName };
		} else {
			throw new RuntimeException("框架错误：" + entity.getClass().getName()
					+ "缺少Table注解");
		}

	}

	@Override
	public T insert(T entity) {

		String tableName = this.getEntityDef(entity)[0];
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

		String[] entityDef = this.getEntityDef(entity);
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
	public List<T> select(T entity) {

		return this.select(entity, false);
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

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<T> select(T entity, boolean autoMatch) {

		String sql = createSelectSql(entity, false, autoMatch);
		return (List<T>) this.simpleJdbcTemplate.query(sql,
				ParameterizedBeanPropertyRowMapper.newInstance(entity
						.getClass()),
				new BeanPropertySqlParameterSource(entity));
	}
	

	/**
	 * 创建查询指令
	 * 
	 * @param entity
	 *            　实体对象
	 * @param only4Count
	 *            　是否保是查记录总数
	 * @return
	 */
	private String createSelectSql(T entity, boolean only4Count,
			boolean autoMatch) {
		String[] entityDef = this.getEntityDef(entity);
		String tableName = entityDef[0];
		String keyColumnName = entityDef[1];

		StringBuffer sqlBuffer = new StringBuffer();
		try {
			String keyPropertyName = ConvertUtil
					.convert2PropertyName(keyColumnName);
			Object keyColumnValue = BeanUtil.getFieldValueInAllSuper(entity,
					keyPropertyName);
			if (only4Count) {
				sqlBuffer.append("select COUNT(id) from " + tableName + " ");
			} else {
				sqlBuffer.append("select * from " + tableName + " ");
			}

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
						&& !value.toString().trim().equals("")) {
					if (needAnd) {
						sqlBuffer.append(" and ");
					} else {
						sqlBuffer.append(" where ");
						needAnd = true;
					}
					if (autoMatch) {
						sqlBuffer.append(columnName + " like :" + fieldName
								+ "");
						field.set(entity, "%" + field.get(entity) + "%");
					} else {
						sqlBuffer.append(columnName + " = :" + fieldName + "");
					}
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("框架错误：自动组装insert的sql语句出错!");
		}
		return sqlBuffer.toString();
	}

	@Override
	public Pagination<T> selectByPagination(T entity, Pagination<T> pagination) {

		return this.selectByPagination(entity, pagination, false);
	}

	@Override
	public Pagination<T> selectByPagination(T entity, Pagination<T> pagination,
			boolean autoMatch) {

		String sql = createSelectSql(entity, false, autoMatch);
		int pageSize = pagination.getPageSize();
		String pagingSql = this.getDialect().getLimitString(sql, (pagination.getPageNo() - 1) * pageSize, pageSize);
		List<T> dataList = (List<T>) this.simpleJdbcTemplate.query(pagingSql,
				ParameterizedBeanPropertyRowMapper.newInstance(entity
						.getClass()),
				new BeanPropertySqlParameterSource(entity));

		String countSql = createSelectSql(entity, true, autoMatch);
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

	@Override
	public T delete(T entity) {

		String[] entityDef = this.getEntityDef(entity);
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
						&& !keyColumnName.equals(columnName)) {
					
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

	@SuppressWarnings("deprecation")
	@Override
	public int batchUpdate(String namedSql, List list) {

		this.simpleJdbcTemplate.batchUpdate(namedSql,
				SqlParameterSourceUtils.createBatch(list.toArray()));
		return list.size();
	}

	@SuppressWarnings("deprecation")
	@Override
	public int batchUpdate(String namedSql, T[] entityAry) {

		this.simpleJdbcTemplate.batchUpdate(namedSql,
				SqlParameterSourceUtils.createBatch(entityAry));
		return entityAry.length;
	}

	@SuppressWarnings("deprecation")
	@Override
	public int batchUpdate(String namedSql, Map[] mapAry) {

		this.simpleJdbcTemplate.batchUpdate(namedSql,
				SqlParameterSourceUtils.createBatch(mapAry));
		return mapAry.length;
	}

	

	public SimpleJdbcInsert getSimpleJdbcInsert() {

		return new SimpleJdbcInsert(this.getSimpleJdbcDaoSupport()
				.getJdbcTemplate());
	}

	public SimpleJdbcInsert getSimpleJdbcInsert(String tableName) {
		return new SimpleJdbcInsert(this.getSimpleJdbcDaoSupport()
				.getJdbcTemplate());
	}

	/*public SqlMapClientTemplate getSqlMapClientTemplate() {
		return sqlMapClientTemplate;
	}

	public void setSqlMapClientTemplate(
			SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}*/

	/*@Override
	public List lookup(String statementId, Map params) {

		return this.lookupProvider.lookup(statementId, params);
	}*/

	/*@Override
	public Pagination lookupByPagination(String statementName,
			String sizeStatementName, Map params, Pagination pagination) {

		return this.lookupProvider.lookupByPagination(statementName, sizeStatementName, params, pagination);
	}

	@Override
	public Map lookupOne(String statementId, Map params) {
		
		return this.lookupProvider.lookupOne(statementId, params);
	}*/

	@Override
	public int update(String sql, Object... args) {

		return this.simpleJdbcTemplate.update(sql, args);
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List select(String sql, Class clazz, Object... args) {
		
		return this.simpleJdbcTemplate.query(sql,  
                ParameterizedBeanPropertyRowMapper.newInstance(clazz), args); 
	}

	@Override
	public int selectForInt(String sql, Object... args) {
		
		return this.simpleJdbcTemplate.queryForInt(sql, args);
	}

	@Override
	public Object selectForObject(String sql, Class clazz, Object... args) {
		return this.simpleJdbcTemplate.queryForObject(sql,  
                ParameterizedBeanPropertyRowMapper.newInstance(clazz), args);  
	}

	@Override
	public void batchUpdateBySql(String sql, List<Object[]> parameters) {
		
		this.simpleJdbcTemplate.batchUpdate(sql, parameters); 
	}

	@Override
	public List select(String namedSql, Class clazz, Map args) {
		return this.simpleJdbcTemplate.query(namedSql,  
                ParameterizedBeanPropertyRowMapper.newInstance(clazz), args); 
	}

	@Override
	public List<Map<String, Object>> selectForList(String sql, Object... args) {
		
		return this.simpleJdbcTemplate.queryForList(sql, args); 
	}

	
}
