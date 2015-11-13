package com.als.frm.module.frm.biz.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.als.frm.bas.dao.BasDAOFacade;
import com.als.frm.comm.dto.AppData;
import com.als.frm.comm.dto.Pagination;
import com.als.frm.comm.util.ConvertUtil;
import com.als.frm.module.frm.biz.BasBIZ;
import com.als.mod.bas.BasEntity;

@Service("basBIZImpl")
public class BasBIZImpl implements BasBIZ{

	@Autowired
	private BasDAOFacade basDAOFacade;
	
	@Override
	public BasEntity addEntity(BasEntity entity) {
		
		basDAOFacade.insert(entity);
		return entity;
	}

	@Override
	public BasEntity modifyEntity(BasEntity entity) {

		basDAOFacade.update(entity);
		return entity;
	}

	@Override
	public int removeEntitiesByIds(String ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BasEntity removeEntity(BasEntity entity) {
		
		basDAOFacade.delete(entity);
		return entity;
	}

	@Override
	public BasEntity saveEntity(BasEntity entity, String newIdValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pagination<Map<String, Object>> queryPageList(AppData appData,
			String sql) {
		sql += " where 1= 1  ";
		Map<String, Object> args = new HashMap<String, Object>();
		//模精查询-----------------------------------------------
		Object searchboxVal = appData.getSearchboxVal();
		Object searchboxKey = appData.getSearchboxKey();
		if (searchboxVal != null){
			sql += " and "+ConvertUtil.convert2ColumnName(searchboxKey.toString())+" like :searchboxVal ";
			args.put("searchboxVal", "%" + searchboxVal + "%");
			
		}
	
		//模精查询 end-----------------------------------------------
		Pagination page = new Pagination();
		int pageNo = 1;
		int pageSize = 10;
		if (appData.getPageNo() != null){
			pageNo = appData.getPageNo();
		}
		
		if (appData.getPageSize() != null){
			pageSize = appData.getPageSize();
		}
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page = basDAOFacade.selectPage(sql, args, page);
		return page;
	}

}
