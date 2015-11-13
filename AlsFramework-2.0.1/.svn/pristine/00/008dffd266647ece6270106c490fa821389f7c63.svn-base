package com.als.frm.bas.dao.mybt;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.als.frm.bas.dao.Operator;
import com.als.frm.bas.dao.TableBeanUtil;
import com.als.frm.bas.dao.TableParser;
import com.als.frm.bas.dao.dialect.Dialect;
import com.als.frm.comm.dto.Pagination;
import com.als.frm.comm.util.BeanUtil;
import com.als.frm.spr.SpringContextUtil;


/**
 * 
 * @author Vincent
 *
 * @param <T>
 */
public class MybatisBasTemplate<T> {

	//@Autowired
	private Dialect dialect;
	
	private Dialect getDialect(){
		if (this.dialect == null){
			return (Dialect) SpringContextUtil.getBean("dialect");
		}
		return dialect;
	}
	
	public String insert(T entity) {  
        
		String[] d = TableParser.getEntityDef(entity);
		String tableName = d[0];
		//String priKeyName = d[1];
		String[] v = this.generalInsert(entity);
		BEGIN();  
        INSERT_INTO(tableName);  
        VALUES(v[0], v[1]);  
  
        return SQL(); 
    }
	
	public String update(T entity) {
		
		String[] d = TableParser.getEntityDef(entity);
		String tableName = d[0];
		String priKeyName = d[1];
		Map map = TableBeanUtil.getEntityMap(entity);
		String priKeyFieldName = this.getKeyByValue(map, priKeyName);
		BEGIN();  
        
        UPDATE(tableName);  
        SET(generalUpdate(entity));  
        WHERE(priKeyName + "=#{" + priKeyFieldName + "}");  
          
        return SQL();  
	}
	
	public String delete(T entity) { 
		
		String[] d = TableParser.getEntityDef(entity);
		String tableName = d[0];
		String priKeyName = d[1];
		Map map = TableBeanUtil.getEntityMap(entity);
		String priKeyFieldName = this.getKeyByValue(map, priKeyName);  
        BEGIN();  
          
        DELETE_FROM(tableName);  
        //WHERE(priKeyName + "=#{" + priKeyFieldName + "}");
        WHERE(generalDelete(entity));
         
        return SQL();  
    }  
	
	public String get(T entity){
		return findBy(entity, null, null,false);
	}
	
	public String selectPage(Map params){
		
		String sql = this.select(params);
		Pagination<T> pagination = (Pagination<T>) params.get("pagination");
		int pageSize = pagination.getPageSize();
		sql = this.getDialect().getLimitString(sql, (pagination.getPageNo() - 1) * pageSize, pageSize);
		
		return sql;
	}
	
	public String selectCount(Map params){
		
		T entity = (T) params.get("entity");
	   	
	   	Map<String,Operator> opMap = (Map<java.lang.String, Operator>) params.get("opMap");

	   	List<Object[]> orderList = (List<Object[]>) params.get("orderList");
	   	
	   	return this.findBy(entity, opMap, orderList, true);
	}
	public String select(Map params){
		
	   	T entity = (T) params.get("entity");
	   	
	   	Map<String,Operator> opMap = (Map<java.lang.String, Operator>) params.get("opMap");

	   	List<Object[]> orderList = (List<Object[]>) params.get("orderList");
	   	
	   	return this.findBy(entity, opMap, orderList, false);
	}
	public String findBy(T entity, Map<String,Operator> opMap, List<Object[]> orderList, Boolean countFlag) { 
		
		String[] d = TableParser.getEntityDef(entity);
		String tableName = d[0];
		String priKeyName = d[1];
		Map map = TableBeanUtil.getEntityMap(entity);
		String priKeyFieldName = this.getKeyByValue(map, priKeyName); 
		org.apache.ibatis.jdbc.SelectBuilder.BEGIN();
		
		org.apache.ibatis.jdbc.SelectBuilder.SELECT(generalSelect(entity, countFlag));
		org.apache.ibatis.jdbc.SelectBuilder.FROM(tableName);
		String whereStr = generalSelectWhere(entity, opMap).trim();
		if (!whereStr.equals("")){
			org.apache.ibatis.jdbc.SelectBuilder.WHERE(whereStr);
		}
		
		
		if (orderList != null && orderList.size() > 0){
			org.apache.ibatis.jdbc.SelectBuilder.ORDER_BY(generalSelectOrder(entity, orderList));
		}
		
		
		
		/*SELECT("P.ID, P.USERNAME, P.PASSWORD, P.FIRST_NAME, P.LAST_NAME");  
		FROM("PERSON P");  
		if (p.id != null) {  
		WHERE("P.ID like #{id}");  
		} if (  
		p.firstName != null) {  
		WHERE("P.FIRST_NAME like #{firstName}");  
		} if (  
		p.lastName != null) {  
		WHERE("P.LAST_NAME like #{lastName}");  
		} ORDER_BY("P.LAST_NAME");  */
		return org.apache.ibatis.jdbc.SelectBuilder.SQL(); 
         
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
	
	/**
	 * 用于获取Insert的字段累加
	 * @return
	 */
	public String generalSelect(T t,Boolean countFlag) {
		
		if (countFlag != null && countFlag){
			return "count('x')";
		}
		
		StringBuilder columnSb = new StringBuilder();
		//StringBuilder fieldSb = new StringBuilder();
		Map map = TableBeanUtil.getEntityMap(t);
		for(Iterator ite = map.entrySet().iterator(); ite.hasNext();){  
			Map.Entry entry = (Map.Entry) ite.next();  
			//entry.getKey();  
			//entry.getValue();  
			columnSb.append(",").append(entry.getValue() + " as " + entry.getKey());
			//fieldSb.append(",").append("#{").append(entry.getKey()).append('}');
		}  
		String columnStr = columnSb.toString().substring(1);
		//String fieldStr = fieldSb.toString().substring(1);
		//String[] result = new String[]{columnStr, fieldStr};
		//return result;
		return columnStr;
	}
	
	/**
	 * 用于获取Update Set的字段累加
	 * @return
	 */
	public String generalSelectWhere(T t, Map<String,Operator> opMap) {
		
		StringBuilder sb = new StringBuilder();
		Map map = TableBeanUtil.getEntityMap(t);
		for(Iterator ite = map.entrySet().iterator(); ite.hasNext();){  
			Map.Entry entry = (Map.Entry) ite.next();  
			//entry.getKey();  
			//entry.getValue();  
			//priKeyName + "=#{" + priKeyFieldName + "}"
			if ( BeanUtil.getFieldValue(t, entry.getKey().toString()) != null){
				String op = "=";
				if(opMap != null && opMap.get(entry.getKey()) != null){
					op = opMap.get(entry.getKey()).getVal();
				} 
				sb.append(" and ").append(entry.getValue()).append(op+"#{entity.").append(entry.getKey()).append('}');
			}
		}  
		String result = sb.toString();
		if (result.length() > 5){
			result = result.substring(5);
		}
		return result;
	}
	
	/**
	 * 用于获取Update Set的字段累加
	 * @return
	 */
	public String generalSelectOrder(T t, List<Object[]> orderList) {
		
		Map map = TableBeanUtil.getEntityMap(t);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0, len = orderList.size(); i < len; i++){
			Object[] item = orderList.get(i);
			sb.append(" and ").append(map.get(item[0])).append(" ").append(item[1]);
			
			//sb.append(" and ").append(entry.getValue()).append("=#{").append(entry.getKey()).append('}');
		}
		String result = sb.toString();
		if (result.length() > 5){
			result = result.substring(5);
		}
		return result;
	}
	
	/**
	 * 用于获取Insert的字段累加
	 * @return
	 */
	public String[] generalInsert(T t) {
		
		StringBuilder columnSb = new StringBuilder();
		StringBuilder fieldSb = new StringBuilder();
		Map map = TableBeanUtil.getEntityMap(t);
		for(Iterator ite = map.entrySet().iterator(); ite.hasNext();){  
			Map.Entry entry = (Map.Entry) ite.next();  
			//entry.getKey();  
			//entry.getValue();  
			columnSb.append(",").append(entry.getValue());
			fieldSb.append(",").append("#{").append(entry.getKey()).append('}');
		}  
		String columnStr = columnSb.toString().substring(1);
		String fieldStr = fieldSb.toString().substring(1);
		String[] result = new String[]{columnStr, fieldStr};
		return result;
	}
	
	/**
	 * 用于获取Update Set的字段累加
	 * @return
	 */
	public String generalUpdate(T t) {
		
		StringBuilder sb = new StringBuilder();
		Map map = TableBeanUtil.getEntityMap(t);
		for(Iterator ite = map.entrySet().iterator(); ite.hasNext();){  
			Map.Entry entry = (Map.Entry) ite.next();  
			//entry.getKey();  
			//entry.getValue();  
			sb.append(',').append(entry.getValue()).append("=#{").append(entry.getKey()).append('}');
		}  
		return sb.toString().substring(1);
	}
	
	/**
	 * 用于获取Update Set的字段累加
	 * @return
	 */
	public String generalDelete(T t) {
		
		StringBuilder sb = new StringBuilder();
		Map map = TableBeanUtil.getEntityMap(t);
		for(Iterator ite = map.entrySet().iterator(); ite.hasNext();){  
			Map.Entry entry = (Map.Entry) ite.next();  
			//entry.getKey();  
			//entry.getValue();  
			//priKeyName + "=#{" + priKeyFieldName + "}"
			sb.append(" and ").append(entry.getValue()).append("=#{").append(entry.getKey()).append('}');
		}  
		return sb.toString().substring(5);
	}
	
	/**
	 * 根据value返回key
	 * @param <T>
	 * @param <String>
	 * @param map
	 * @param value
	 * @return
	 */
	public static <T, String> T getKeyByValue(Map<T, String> map, String value) {
	    for (Entry<T, String> entry : map.entrySet()) {
	        if (value.equals(entry.getValue())) {
	            return entry.getKey();
	        }
	    }
	    return null;
	}
}
