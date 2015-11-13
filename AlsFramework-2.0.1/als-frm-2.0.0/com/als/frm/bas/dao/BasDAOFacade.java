package com.als.frm.bas.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.als.frm.bas.dao.hbm.HibernateBasDAOSupport;
import com.als.frm.bas.dao.jdbc.JdbcBasDAOSupport;
import com.als.frm.bas.dao.jpa.JpaBasDAOSupport;
import com.als.frm.bas.dao.mybt.MybatisBasDAOSupport;
import com.als.frm.comm.dto.Pagination;

@Repository("basDAOFacade")
public class BasDAOFacade<T> implements IBasDAOFacade<T>{
	
	@Autowired
	public JdbcBasDAOSupport<T> jdbcBasDAOSupport;
	@Autowired
	private MybatisBasDAOSupport<T> mybatisBasDAOSupport;
	
	private JpaBasDAOSupport<T> jpaBasDAOSupport;
	
	private HibernateBasDAOSupport<T> hibernateBasDAOSupport;

	@Override
	public T insert(T entity) {
		
		return this.jdbcBasDAOSupport.insert(entity);
	}

	@Override
	public T delete(T entity) {
		
		return this.jdbcBasDAOSupport.delete(entity);
	}

	@Override
	public List<T> select(T entity) {
		
		return this.jdbcBasDAOSupport.select(entity);
	}

	@Override
	public T update(T entity) {

		return this.jdbcBasDAOSupport.update(entity);
	}

	@Override
	public T deleteByMybatis(T entity) {

		return this.mybatisBasDAOSupport.delete(entity);
	}

	@Override
	public T insertByMybatis(T entity) {

		return this.mybatisBasDAOSupport.insert(entity);
	}

	@Override
	public List<T> selectByMybatis(T entity) {

		return mybatisBasDAOSupport.select(entity);
	}

	@Override
	public T updateByMybatis(T entity) {

		return this.mybatisBasDAOSupport.update(entity);
	}

	@Override
	public List<T> select(T entity, Map<String, Operator> opMap,
			List<Object[]> orderList) {

		return this.jdbcBasDAOSupport.select(entity, opMap, orderList);
	}

	@Override
	public List<T> selectByMybatis(T entity, Map<String, Operator> opMap,
			List<Object[]> orderList) {
		return this.mybatisBasDAOSupport.select(entity, opMap, orderList);
	}

	@Override
	public Pagination<T> selectPageByJdbc(T entity,
			Map<String, Operator> opMap, List<Object[]> orderList,
			Pagination<T> pagination) {
		
		return this.jdbcBasDAOSupport.selectPage(entity, opMap, orderList, pagination);
	}

	@Override
	public Pagination<T> selectPageByMybatis(T entity,
			Map<String, Operator> opMap, List<Object[]> orderList,
			Pagination<T> pagination) {

		return this.mybatisBasDAOSupport.selectPage(entity, opMap, orderList, pagination);
	}

	@Override
	public int batchUpdate(String namedSql, List list) {
		return this.jdbcBasDAOSupport.batchUpdate(namedSql, list);
	}

	@Override
	public int batchUpdate(String namedSql, T[] entityAry) {
		return this.jdbcBasDAOSupport.batchUpdate(namedSql, entityAry);
	}

	@Override
	public int batchUpdate(String namedSql, Map[] mapAry) {

		return this.jdbcBasDAOSupport.batchUpdate(namedSql, mapAry);
	}

	@Override
	public void batchUpdateBySql(String sql, List<Object[]> parameters) {

		this.jdbcBasDAOSupport.batchUpdateBySql(sql, parameters);
		
	}

	@Override
	public T selectOne(T entity) {

		return this.jdbcBasDAOSupport.selectOne(entity);
	}

	@Override
	public List<Map<String, Object>> select(String sql, Map<String, Object> args) {
		
		return this.jdbcBasDAOSupport.select(sql, args);
	}

	@Override
	public Pagination<Map<String, Object>> selectPage(String sql,
			Map<String, Object> args, Pagination<Map<String, Object>> pagination) {
		
		return this.jdbcBasDAOSupport.selectPage(sql, args, pagination);
	}

	@Override
	public int update(String namedSql, Map<String, Object> args) {
		
		return this.jdbcBasDAOSupport.update(namedSql, args);
	}

	@Override
	public Pagination<Map> selectPageMapByMybatis(T entity,
			Map<String, Operator> opMap, List<Object[]> orderList,
			Pagination<Map> pagination) {
		return this.mybatisBasDAOSupport.selectPageMybatis(entity, opMap, orderList, pagination);
	}
}
