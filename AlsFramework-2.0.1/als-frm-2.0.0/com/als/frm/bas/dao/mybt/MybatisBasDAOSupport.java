package com.als.frm.bas.dao.mybt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import com.als.frm.bas.dao.IBasDAO;
import com.als.frm.bas.dao.Operator;
import com.als.frm.bas.dao.OrderType;
import com.als.frm.comm.dto.Pagination;
import com.als.frm.comm.util.BeanUtil;
import com.als.frm.ex.AppException;
import com.als.frm.ex.DaoException;

@Repository("myBatisBasDAOSupport")
public class MybatisBasDAOSupport<T> implements IBasDAO<T>{

	@Autowired
	private MybatisBasMapper<T> myBatisBasMapper;
	
	@Override
	public T insert(T entity) {
		
         myBatisBasMapper.insert(entity);
         return entity;
	}
	
	@Override
	public T update(T entity) {
		
		myBatisBasMapper.update(entity);
        return entity;
	}
	
	@Override
	public T delete(T entity) {
		
		myBatisBasMapper.delete(entity);
        return entity;
	}
	
	
	
	@Override
	public void batchInsert(List<T> data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void batchUpdate(List<T> data) {
		// TODO Auto-generated method stub
		
	}

	

	

	@Override
	public List<T> select(T entity) {
		
		return this.select(entity, null, null);
	}

	@Override
	public List<T> select(T entity, Map<String, Operator> opMap) {
		
		return this.select(entity, opMap, null);
	}

	@Override
	public List<T> select(T entity, Map<String, Operator> opMap,
			String orderField, OrderType od) {

		List<Object[]> orderList = new ArrayList<Object[]>(1);
		orderList.add(new Object[]{orderField, od});
		return this.select(entity, opMap, orderList);
	}

	@Override
	public List<T> select(T entity, Map<String, Operator> opMap,
			 List<Object[]> orderList) {
		// TODO Auto-generated method stub
		
		Map params = new HashMap(3);
		params.put("entity", entity);
		params.put("opMap", opMap);
		params.put("orderList", orderList);
		
		List<Map> mapList =  myBatisBasMapper.select(params);
		
		return this.transMap2BeanList(mapList, entity);
		
	}
	
	private List<T>  transMap2BeanList(List<Map> mapList, T entity){
		
		List<T> list = new ArrayList<T>();
		try {
			Class clazz=Class.forName(entity.getClass().getName());
			for (int i =0, len = mapList.size(); i < len; i ++){
				Object o=clazz.newInstance();
				BeanUtil.toBean(mapList.get(i), o, false);//sql语句中已经把下划线给去除了
				list.add((T) o);
			}
		} catch (ClassNotFoundException e) {
			throw new AppException("err.sys.10006", new Object[]{entity.getClass().getName()});
		} catch (Exception e) {
			throw new AppException("err.als.01006", new Object[]{});
		} 
		//myBatisBasMapper.select(entity, opMap, orderList);
		return list;
	}

	@Override
	public Pagination<T> selectPage(T entity, Map<String, Operator> opMap,
			List<Object[]> orderList, Pagination<T> pagination) {
		Map params = new HashMap(3);
		params.put("entity", entity);
		params.put("opMap", opMap);
		params.put("orderList", orderList);
		params.put("pagination", pagination);
		
		List<Map> mapList =  myBatisBasMapper.selectPage(params);
		List<T>  list = this.transMap2BeanList(mapList, entity);
		pagination.setDataList(list);
		
		Integer count = myBatisBasMapper.selectCount(params);
		pagination.setTotal(count);
		return pagination;
	}

	@Override
	public void batchDeleteById(List<T> data) {

		throw new DaoException("请使用jdbcBasDAOSupport进行批量操作！");
	}

	@Override
	public int batchUpdate(String namedSql, List list) {
		throw new DaoException("请使用jdbcBasDAOSupport进行批量操作！");
	}

	@Override
	public int batchUpdate(String namedSql, T[] entityAry) {
		throw new DaoException("请使用jdbcBasDAOSupport进行批量操作！");
	}

	@Override
	public int batchUpdate(String namedSql, Map[] mapAry) {
		throw new DaoException("请使用jdbcBasDAOSupport进行批量操作！");
	}

	@Override
	public void batchUpdateBySql(String sql, List<Object[]> parameters) {
		throw new DaoException("请使用jdbcBasDAOSupport进行批量操作！");
		
	}

	@Override
	public T selectOne(T entity) {
		List<T> list = this.select(entity);
		if (list.size() > 0){
			return list.get(0);
		} else {
			//throw new RuntimeException("框架错误：采用selectOne进行查询，未查到指定记录！");
			return null;
		}
	}

	@Override
	public List<Map<String, Object>> select(String sql, Map<String, Object> args) {
		throw new DaoException("请使用jdbcBasDAOSupport进行批量操作！");
	}

	@Override
	public Pagination<Map<String, Object>> selectPage(String sql,
			Map<String, Object> args, Pagination<Map<String, Object>> pagination) {
		throw new DaoException("请使用jdbcBasDAOSupport进行批量操作！");
	}

	@Override
	public int update(String namedSql, Map<String, Object> args) {
		throw new DaoException("请使用jdbcBasDAOSupport进行批量操作！");
	}

	@Override
	public Pagination<Map> selectPageMybatis(T entity,
			Map<String, Operator> opMap, List<Object[]> orderList,
			Pagination<Map> pagination) {
		Map params = new HashMap(3);
		params.put("entity", entity);
		params.put("opMap", opMap);
		params.put("orderList", orderList);
		params.put("pagination", pagination);
		
		List<Map> mapList =  myBatisBasMapper.selectPage(params);
		pagination.setDataList(mapList);
		
		Integer count = myBatisBasMapper.selectCount(params);
		pagination.setTotal(count);
		return pagination;
	}
	
	

	
	
	
}
