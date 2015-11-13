package com.als.frm.bas.dao;

import java.util.Map;

public interface ISqlGenerator<T> {
	
	public String createEntitySelectSql(T entity, boolean only4Count,
			Map<String,Operator> opMap, Map<String,OrderType> odMap);

}
