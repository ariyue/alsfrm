package com.als.frm.module.frm.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.als.frm.bas.dao.BasDAOFacade;
import com.als.frm.cache.IFrmBasSerialCache;
import com.als.frm.comm.FrmConstant;
import com.als.frm.comm.dto.AppData;
import com.als.frm.comm.dto.Pagination;
import com.als.frm.comm.util.ConvertUtil;
import com.als.frm.comm.util.UuidUtil;
import com.als.frm.ex.AppException;
import com.als.frm.module.frm.biz.FrmBasSerialBIZ;

@Service("frmBasSerialBIZImpl")
public class FrmBasSerialBIZImpl implements FrmBasSerialBIZ{

	@Autowired
	private BasDAOFacade basDAOFacade;
	
	@Autowired
	private IFrmBasSerialCache frmBasSerialCache;
	
	@Override
	public Pagination<Map<String, Object>>  getSerialList(AppData appData) {
		
		String sql = "select id, module, entity_sid entitySid, cache_size cacheSize,prefix, subfix from frm_bas_serial v where 1=1 ";
		Map<String, Object> args = new HashMap<String, Object>();
		//模精查询-----------------------------------------------
		Object searchboxVal = appData.getValue("searchboxVal");
		Object searchboxKey = appData.getValue("searchboxKey");
		if (searchboxVal != null){
			sql += " and v."+ConvertUtil.convert2ColumnName(searchboxKey.toString())+" like :searchboxVal ";
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

	@Override
	public Pagination<Map<String, Object>>  getSerialItemList(AppData appData) {
		
		String sql = "select id, max_value maxValue from frm_bas_serial_item t where id like :id ";
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("id",  "%" + appData.getValue("module") +  "%");
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
	public Pagination<Map<String, Object>> saveSerial(AppData appData) {
		String entitySid= FrmConstant.FRM_DEFAULT_ENTITY_SID;  
		if ( appData.getValue("entitySid") != null &&  !appData.getValue("entitySid").toString().trim().equals("")){
			entitySid = appData.getValue("entitySid").toString();
		}
		
		String id = appData.getValue("id").toString();
		String sql = "";
		if(id == null || id.trim().equals("")){//insert
			id = UuidUtil.create();
			sql = "insert into frm_bas_Serial(id,module,entity_sid,cache_size,prefix,subfix) values (:id, :module, :entitySid, :cacheSize, :prefix, :subfix)";
		} else {//update
			sql = "update frm_bas_Serial set id=:id,module=:module,entity_sid=:entitySid,cache_size=:cacheSize,prefix=:prefix,subfix=:subfix where id=:id";

		}
		Map<String, Object> args = new HashMap<String, Object>();
		Long cacheSize = Long.valueOf(appData.getValue("cacheSize").toString());
		String module = appData.getValue("module").toString();
		args.put("id", id);
		args.put("module", module);
		args.put("entitySid", entitySid);
		args.put("cacheSize", cacheSize);
		args.put("prefix", appData.getValue("prefix"));
		args.put("subfix", appData.getValue("subfix"));
		
		basDAOFacade.update(sql, args);
		
		String sql2 = "select * from frm_bas_serial_item t where t.id like :id";
		Map<String, Object> args2 = new HashMap<String, Object>();
		args2.put("id",  module + entitySid + "%");
		List<Map> itemList = basDAOFacade.select(sql2, args2);
		if(itemList != null && itemList.size() > 0){
			for (int i =0, len = itemList.size(); i < len; i++){
				frmBasSerialCache.updateCache(module, entitySid, cacheSize + Long.valueOf(itemList.get(i).get("max_value").toString()));
			}
		}
		JSONObject gridParams = JSONObject.fromObject(appData.getValue("gridParam"));// JSONArray.fromObject(appData.getValue("siteList"));
		if (gridParams!=null && gridParams.get("searchboxVal") != null &&  gridParams.get("searchboxKey") != null){
			appData.setValue("searchboxVal", gridParams.get("searchboxVal"));
			appData.setValue("searchboxKey", gridParams.get("searchboxKey"));
		}
		return this.getSerialList(appData);
	}

	@Override
	public Pagination<Map<String, Object>> removeSerial(AppData appData) {

		String id = appData.getValue("id").toString();
	
		if (!(id == null || id.trim().equals(""))){
			String sql = "delete from frm_bas_Serial where id= :id";
			Map<String, Object> args = new HashMap<String, Object>();
			args.put("id", id);
			basDAOFacade.update(sql, args);
			
			//删除子项
			String module = appData.getValue("module").toString();
			String entitySid = appData.getValue("entitySid").toString();
			sql = "delete from frm_bas_serial_item where id like :itemId";
			args.put("itemId", module + entitySid);
			basDAOFacade.update(sql, args);
			
			//删除缓存
			frmBasSerialCache.removeCache(module, entitySid);
			
		}
		JSONObject gridParams = JSONObject.fromObject(appData.getValue("gridParam"));// JSONArray.fromObject(appData.getValue("siteList"));
		if (gridParams!=null && gridParams.get("searchboxVal") != null &&  gridParams.get("searchboxKey") != null){
			appData.setValue("searchboxVal", gridParams.get("searchboxVal"));
			appData.setValue("searchboxKey", gridParams.get("searchboxKey"));
		}
		return this.getSerialList(appData);
	}

	@Override
	public void updateItemMaxValue(AppData appData) {

		String itemId = appData.getValue("id").toString();
		Long maxValue = Long.valueOf(appData.getValue("maxValue").toString());
		String module = itemId.substring(0,3);
		String entitySid = itemId.substring(3, 8);
		
		Long currentValue = frmBasSerialCache.getCurrentCacheValue(module, entitySid);
		if (maxValue <= currentValue){
			throw new AppException("修改值必须要大于当前的缓存值" + currentValue);
		}
		
		String sql = "update frm_bas_serial_item t set t.max_value= :maxValue where t.id =  :id";
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("id", itemId);
		args.put("maxValue", maxValue);
		basDAOFacade.update(sql, args);
		frmBasSerialCache.updateCache(module, entitySid, maxValue);
		
	}
	public static void main(String[] args) {
		
		String itemId = "ABB0000720150806";
		String module = itemId.substring(0,3);
		String entitySid = itemId.substring(3, 8);
		System.out.println(module + ";" + entitySid);
	}
}
