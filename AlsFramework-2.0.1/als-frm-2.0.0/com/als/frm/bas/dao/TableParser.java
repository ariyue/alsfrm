package com.als.frm.bas.dao;

import com.als.frm.comm.dto.Table;

public class TableParser {

	/**
	 * 从Tabel注解中获取参数，目前只有表名，主键字段列名 如果以后要加其它的字段，在返回的字符串数组后面依次加，保证不影响以前的业务
	 */
	public static String[] getEntityDef(Object entity) {

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
}
