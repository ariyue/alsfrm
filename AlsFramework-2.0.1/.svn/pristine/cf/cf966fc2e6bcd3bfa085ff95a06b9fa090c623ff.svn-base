package com.als.frm.bas;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.als.frm.bas.dao.Operator;
import com.als.frm.bas.dao.mybt.MybatisBasDAOSupport;
import com.als.frm.comm.dto.Pagination;

@Component("lookupProvider")
public class LookupProvider implements ILookupProvider{

	@Autowired
	private MybatisBasDAOSupport mybatisBasDAOSupport;
	
	@Override
	public List lookup(Object entity, Map<String, Operator> opMap,
			List<Object[]> orderList) {

		return mybatisBasDAOSupport.select(entity, opMap, orderList);
	}
	
	@Override
	public List lookup(Object entity, Map<String, Operator> opMap) {

		return mybatisBasDAOSupport.select(entity, opMap);
	}
	
	
	@Override
	public Pagination lookupPage(Object entity, Map<String, Operator> opMap,
			List<Object[]> orderList, Pagination pagination) {

		return mybatisBasDAOSupport.selectPageMybatis(entity, opMap, orderList, pagination);
	}

}
