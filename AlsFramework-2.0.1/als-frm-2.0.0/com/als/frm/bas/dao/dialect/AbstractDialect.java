package com.als.frm.bas.dao.dialect;

public abstract class AbstractDialect implements Dialect {

	protected static final String SQL_END_DELIMITER = ";";

	protected String trim(String sql) {
		sql = sql.trim();
		if (sql.endsWith(SQL_END_DELIMITER)) {
			sql = sql.substring(0, sql.length() - 1
					- SQL_END_DELIMITER.length());
		}
		return sql;
	}
}
