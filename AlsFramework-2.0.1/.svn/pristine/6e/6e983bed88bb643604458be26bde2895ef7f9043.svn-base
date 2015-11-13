package com.als.frm.bas.dao.jdbc;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import com.als.frm.bas.dao.Operator;
import com.als.frm.bas.dao.OrderType;
import com.als.frm.bas.dao.TableBeanUtil;
import com.als.frm.bas.dao.TableParser;
import com.als.frm.comm.dto.Table;
import com.als.frm.comm.util.BeanUtil;
import com.als.frm.comm.util.ConvertUtil;

public class JdbcSqlGenerator<T> {

	 private static JdbcSqlGenerator instance = new JdbcSqlGenerator();
	 private JdbcSqlGenerator(){}
	 public static JdbcSqlGenerator getInstance(){
		 if (instance == null){
			 instance = new JdbcSqlGenerator();
		 }
		 return instance;
	 }
	 
	 public String createEntitySelectSql(T entity, boolean only4Count,
			Map<String,Operator> opMap, List<Object[]> orderList) {
		String[] entityDef = TableParser.getEntityDef(entity);
		String tableName = entityDef[0];
		String keyColumnName = entityDef[1];

		StringBuffer sqlBuffer = new StringBuffer();
		try {
			String keyPropertyName = ConvertUtil
					.convert2PropertyName(keyColumnName);
			Object keyColumnValue = BeanUtil.getFieldValueInAllSuper(entity,
					keyPropertyName);
			if (only4Count) {
				sqlBuffer.append("select COUNT('x') from " + tableName + " ");
			} else {
				sqlBuffer.append("select * from " + tableName + " ");
			}

			Field[] fields = entity.getClass().getDeclaredFields();
			int size = fields.length;

			boolean needAnd = false;
			String fieldName = "";
			String columnName = "";
			String op;//操作符
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
					op = null;//每一个循环都要先设为null
					if (opMap != null){
						op = opMap.get(fieldName).getVal();
					}
					if (op == null){
						sqlBuffer.append(columnName + " = :" + fieldName + "");
					} else {
						if (op.equals(Operator.lk.getVal())){//LIKE
							sqlBuffer.append(columnName + " like :" + fieldName
									+ "");
							field.set(entity, "%" + field.get(entity) + "%");
						} else {
							sqlBuffer.append(columnName + " " + op + " :" + fieldName + "");
						}
					}
					
					/*if (autoMatch) {
						sqlBuffer.append(columnName + " like :" + fieldName
								+ "");
						field.set(entity, "%" + field.get(entity) + "%");
					} else {
						sqlBuffer.append(columnName + " = :" + fieldName + "");
					}*/
				}
			}
			
			//order 
			Map map = TableBeanUtil.getEntityMap(entity);
			
			StringBuilder sb = new StringBuilder();
			if (orderList != null){
				for (int i = 0, len = orderList.size(); i < len; i++){
					Object[] item = orderList.get(i);
					if (map.get(item[0]) != null && !map.get(item[0]).toString().trim().equals("")){
						sb.append(" and ").append(map.get(item[0])).append(" ").append(item[1]);
					}
					//sb.append(" and ").append(entry.getValue()).append("=#{").append(entry.getKey()).append('}');
				}		
			}
			
			String result = sb.toString();
			if (result.length() > 5){
				result = result.substring(5);
			}
			if (!result.equals("")){
				sqlBuffer.append(" order by " + result);
			}
			
		} catch (Exception e) {
			throw new RuntimeException("框架错误：自动组装insert的sql语句出错!");
		}
		return sqlBuffer.toString();
	}
	
	/**
	 * 从Tabel注解中获取参数，目前只有表名，主键字段列名 如果以后要加其它的字段，在返回的字符串数组后面依次加，保证不影响以前的业务
	 */
	/*private String[] getEntityDef(T entity) {

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

	}*/
}
