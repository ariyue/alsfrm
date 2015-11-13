package com.als.frm.bas.dao.dialect;


/**
 * 数据库语言，用于区分各数据库，目前用在写分页的sql上
 * 各个数据库从第0条和大于0条开始取的sql可能不一样
 * @author Vincent
 *
 */
public interface Dialect {

	/**
	 * 是否支持取取部分数据。
	 * @return
	 */
	public boolean supportsLimit();
	
	/**
	 * 根据原有的sql获取分页的sql
	 * @param sql 原有的sql
	 * @param offset 取数的初始位置，第1条数据的位置为0。各个数据库从第0条和大于0条开始取的sql可能不一样
	 * @param limit 取数的长度，如每页取10条数据，则limit为10
	 * @return 返回分页的sql
	 */
	public String getLimitString(String sql, int offset, int limit);
}
