package com.als.frm.bas.dao;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.als.frm.comm.util.ConvertUtil;

/**
 * 表与java中的字段映射
 * @author Vincent
 *
 */
public class TableBeanUtil {
	
	private static final Map<String,Map<String,String>> cacheMap = new HashMap<String,Map<String,String>>();
	
	public static Map getEntityMap(Object entity){
		
		String name = entity.getClass().getName();
		Map m = cacheMap.get(name);
		if (m == null){
			m = generalEntityMap(entity);
			cacheMap.put(name, m);
		}
		return m;
	}
	
	private static Map generalEntityMap(Object entity){
		
		Field[] fields = entity.getClass().getDeclaredFields();
		int size = fields.length;
		Map m = new HashMap<String,String>(size);
		String fieldName = "";
		String columnName = "";
		for (int i = 0; i < size; i++) {
			Field field = fields[i];
			field.setAccessible(true); // 这句使我们可以访问似有成员变量
			fieldName = field.getName();
			columnName = ConvertUtil.convert2ColumnName(fieldName);
			m.put(fieldName, columnName);
		}
		return m;
	}

}
