package com.als.frm.bas.dao.dialect;

public class OracleDialect extends AbstractDialect implements Dialect {

	@Override
	public String getLimitString(String sql, int offset, int limit) {
		
		sql = trim(sql);
		boolean hasOffset = offset > 0 ? true : false;
		int endLineNo = hasOffset ? offset + limit : limit;
		//
		sql = sql.trim();
		boolean isForUpdate = false;
		if (sql.toLowerCase().endsWith(" for update")) {
			sql = sql.substring(0, sql.length() - 11);
			isForUpdate = true;
		}

		StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);
		if (hasOffset) {
			pagingSelect
					.append("select * from ( select row_.*, rownum rownum_ from ( ");
		} else {
			pagingSelect.append("select * from ( ");
		}
		pagingSelect.append(sql);
		if (hasOffset) {
//			pagingSelect.append(" ) row_ ) where rownum_ <= " + limit
//			+ " and rownum_ > " + start);
			pagingSelect.append(" ) row_ where rownum <= "+ endLineNo+") " 
					+ " where rownum_ > " + offset);
		} else {
			pagingSelect.append(" ) where rownum <= " + endLineNo);
		}

		if (isForUpdate) {
			pagingSelect.append(" for update");
		}

		return pagingSelect.toString();
	}

	@Override
	public boolean supportsLimit() {
		return true;
	}
	
	public static void main(String[] args){
		String sql = "select A.id from mdw_msgincome A left join sys_keyword_msg B on A.ID = B.MSG_ID ";
		Dialect dialect = new OracleDialect();
		System.out.println(dialect.getLimitString(sql,1,10));
	}

}
