package com.als.frm.module.frm.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.als.frm.bas.dao.BasDAOFacade;
import com.als.frm.cache.IFrmBasConstantCache;
import com.als.frm.comm.FrmConstant;
import com.als.frm.comm.dto.AppData;
import com.als.frm.comm.dto.Pagination;
import com.als.frm.comm.util.ConvertUtil;
import com.als.frm.comm.util.UuidUtil;
import com.als.frm.module.frm.biz.FrmBasConstantBIZ;
import com.als.mod.domain.FrmBasConstant;

@Service("frmBasConstantBIZImpl")
public class FrmBasConstantBIZImpl implements FrmBasConstantBIZ{

	@Autowired
	private BasDAOFacade basDAOFacade;
	
	@Autowired
	private IFrmBasConstantCache frmBasConstantCache;
	
	@Override
	public Pagination<Map<String, Object>>  getConstantList(AppData appData) {
		
		String sql = "select * from (select t.name name, t.code code from frm_bas_constant t group by t.code order by t.code) v where 1=1 ";
		Map<String, Object> args = new HashMap<String, Object>();
		//模精查询-----------------------------------------------
		Object searchboxVal = appData.getValue("searchboxVal");
		Object searchboxKey = appData.getValue("searchboxKey");
		if (searchboxVal != null){
			sql += " and v."+ConvertUtil.convert2ColumnName(searchboxKey.toString())+" like :searchboxVal ";
			args.put("searchboxVal", "%" + searchboxVal + "%");
			
		}
		/*if (appData.getValue("name") != null){
			sql += " and v.name like :name ";
			args.put("name", "%" + appData.getValue("name").toString().toUpperCase() + "%");
		}
		
		if (appData.getValue("code") != null){
			sql += " and v.code like :code ";
			args.put("code", "%" + appData.getValue("code").toString().toUpperCase() + "%");
		}*/
		//模精查询 end-----------------------------------------------
		Pagination page = new Pagination();
		page.setPageNo(appData.getPageNo());
		page.setPageSize(appData.getPageSize());
		page = basDAOFacade.selectPage(sql, args, page);
		return page;
	}

	@Override
	public Pagination<Map<String, Object>>  getConstantItemList(AppData appData) {
		
		String sql = "select t.id id, t.code code, t.item_code itemCode, t.item_text itemText, t.row_order rowOrder from frm_bas_constant t where 1=1 and t.code=:code order by t.row_order";
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("code", appData.getValue("code"));
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

	@Override
	public Pagination<Map<String, Object>> saveConstant(AppData appData) {
		String entitySid= FrmConstant.FRM_DEFAULT_ENTITY_SID;  
		if ( appData.getValue("entitySid") != null &&  !appData.getValue("entitySid").toString().trim().equals("")){
			entitySid = appData.getValue("entitySid").toString();
		}
		
		String id = appData.getValue("id").toString();
		String sql = "";
		if(id == null || id.trim().equals("")){//insert
			id = UuidUtil.create();
			sql = "insert into frm_bas_constant(id,name,code,item_code,item_text,row_order,entity_sid,remark) values (:id, :name, :code, :itemCode, :itemText, :rowOrder, :entitySid, :remark)";
		} else {//update
			sql = "update frm_bas_constant set id=:id,name=:name,code=:code,item_code=:itemCode,item_text=:itemText,row_order=:rowOrder,entity_sid=:entitySid,remark=:remark where id=:id";

		}
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("id", id);
		args.put("name", appData.getValue("name"));
		String code = appData.getValue("code").toString().toUpperCase();
		args.put("code", code);
		args.put("itemCode", appData.getValue("itemCode"));
		args.put("itemText", appData.getValue("itemText"));
		args.put("rowOrder", appData.getValue("rowOrder"));
		args.put("entitySid", entitySid);
		args.put("remark", appData.getValue("remark"));
		basDAOFacade.update(sql, args);
		
		//FrmBasConstant entity = new FrmBasConstant();
		//entity.setCode(code);
		//List constantList = basDAOFacade.select(entity);
		//frmBasConstantCache.updateConstantList(code, entitySid, constantList);
		frmBasConstantCache.cacheConstant(code, entitySid);
		return this.getConstantItemList(appData);
	}

	@Override
	public Pagination<Map<String, Object>> removeConstant(AppData appData) {

		String id = appData.getValue("id").toString();
	
		if (!(id == null || id.trim().equals(""))){
			String sql = "delete from frm_bas_constant where id= :id";
			Map<String, Object> args = new HashMap<String, Object>();
			args.put("id", id);
			basDAOFacade.update(sql, args);
			
			String entitySid= FrmConstant.FRM_DEFAULT_ENTITY_SID;  
			if ( appData.getValue("entitySid") != null &&  !appData.getValue("entitySid").toString().trim().equals("")){
				entitySid = appData.getValue("entitySid").toString();
			}
			String code = appData.getValue("code").toString();
			frmBasConstantCache.cacheConstant(code, entitySid);
			
		}
		return this.getConstantItemList(appData);
	}
}
