package com.als.frm.bas.dao.dialect;

public class DB2Dialect extends AbstractDialect implements Dialect {
	// int offset, int limit
	@Override
	public String getLimitString(String querySelect, int offset, int limit) {
		int endLineNo = offset + limit;
		int startOfSelect = querySelect.toLowerCase().indexOf("select");

		StringBuffer pagingSelect = new StringBuffer(querySelect.length() + 100)
				.append(querySelect.substring(0, startOfSelect)) // add the
				// comment
				.append("select * from ( select ") // nest the main query in an
				// outer select
				.append(getRowNumber(querySelect)); // add the rownnumber bit
		// into the outer query
		// select list

		if (hasDistinct(querySelect)) {
			pagingSelect.append(" row_.* from ( ") // add another (inner) nested
					// select
					.append(querySelect.substring(startOfSelect)) // add the
					// main
					// query
					.append(" ) as row_"); // close off the inner nested select
		} else {
			pagingSelect.append(querySelect.substring(startOfSelect + 6)); // add
			// the
			// main
			// query
		}

		pagingSelect.append(" ) as temp_ where rownumber_ ");

		// add the restriction to the outer select
		boolean hasOffset = offset > 0 ? true : false;
		if (hasOffset) {
			pagingSelect.append("between " + (offset + 1) + " and " + endLineNo);
		} else {
			pagingSelect.append("<= " + endLineNo);
		}

		return pagingSelect.toString();
	}

	@Override
	public boolean supportsLimit() {

		return true;
	}

	/**
	 * Render the <tt>rownumber() over ( .... ) as rownumber_,</tt> bit, that
	 * goes in the select list
	 */
	private String getRowNumber(String sql) {
		StringBuffer rownumber = new StringBuffer(50)
				.append("rownumber() over(");

		int orderByIndex = sql.toLowerCase().indexOf("order by");

		if (orderByIndex > 0 && !hasDistinct(sql)) {
			rownumber.append(sql.substring(orderByIndex));
		}

		rownumber.append(") as rownumber_,");

		return rownumber.toString();
	}

	private static boolean hasDistinct(String sql) {
		return sql.toLowerCase().indexOf("select distinct") >= 0;
	}

}
