package com.als.frm.module.frm.biz.impl;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.als.frm.bas.dao.BasDAOFacade;
import com.als.frm.cache.FrmBasCfgCache;
import com.als.frm.comm.FrmConstant;
import com.als.frm.comm.dto.AppData;
import com.als.frm.comm.dto.Pagination;
import com.als.frm.comm.util.ConvertUtil;
import com.als.frm.comm.util.UuidUtil;
import com.als.frm.module.frm.biz.UmsProductBIZ;

@Service("umsProductBIZImpl")
public class UmsProductBIZImpl implements UmsProductBIZ{

	@Autowired
	private BasDAOFacade basDAOFacade;
	
	@Autowired
	private FrmBasCfgCache frmBasCfgCache;
	
	@Override
	public Pagination<Map<String, Object>> getPageList(AppData appData) {
		String sql ="select id,product_name productName, menu_id menuId,price,remark,trans_code transCode,project_date projectDate,develop_date developDate,online_date onlineDate from ums_product  t where 1= 1 ";
		Map<String, Object> args = new HashMap<String, Object>();
		//模糊查询-----------------------------------------------
		Object searchboxVal = appData.getValue("searchboxVal");
		Object searchboxKey = appData.getValue("searchboxKey");
		if (searchboxVal != null){
			sql += " and t."+ConvertUtil.convert2ColumnName(searchboxKey.toString())+" like :searchboxVal ";
			args.put("searchboxVal", "%" + searchboxVal + "%");
			
		}
		/*if (appData.getValue("name") != null){
			sql += " and t.name like :name ";
			args.put("name", "%" + appData.getValue("name").toString().toUpperCase() + "%");
		}
		
		if (appData.getValue("code") != null){
			sql += " and t.code like :code ";
			args.put("code", "%" + appData.getValue("code").toString().toUpperCase() + "%");
		}*/
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
	public Pagination<Map<String, Object>> removeEntity(AppData appData) {
		String id = appData.getValue("id").toString();
		
		if (!(id == null || id.trim().equals(""))){
			String sql = "delete from ums_product where id= :id";
			Map<String, Object> args = new HashMap<String, Object>();
			args.put("id", id);
			basDAOFacade.update(sql, args);		
		}
		
		JSONObject gridParams = JSONObject.fromObject(appData.getValue("gridParam"));// JSONArray.fromObject(appData.getValue("siteList"));
		if (gridParams!=null && appData.getValue("entitySid") != null ){
			appData.setValue("searchboxVal", gridParams.get("searchboxVal"));
			appData.setValue("searchboxKey", gridParams.get("searchboxKey"));
		}
		return this.getPageList(appData);
	}

	@Override
	public Pagination<Map<String, Object>> saveEntity(AppData appData) {
		String entitySid= FrmConstant.FRM_DEFAULT_ENTITY_SID;  
		if ( appData.getValue("entitySid") != null &&  !appData.getValue("entitySid").toString().trim().equals("")){
			entitySid = appData.getValue("entitySid").toString();
		}
		
		String id = appData.getValue("id").toString();
		String sql = "";
		boolean newFlag = false;
		if(id == null || id.trim().equals("")){//insert
			id = appData.getValue("menuId").toString();//UuidUtil.create();
			newFlag = true;
			sql = "insert into ums_product(id,product_name,menu_id,price,remark,trans_code,create_real_name,create_user_name,create_date,create_time,last_modify_real_name,last_modify_user_name,last_modify_date,last_modify_time,last_approve_option,project_date,develop_date,online_date)values(:id,:productName,:menuId,:price,:remark,:transCode,:createRealName,:createUserName,:createDate,:createTime,:lastModifyRealName,:lastModifyUserName,:lastModifyDate,:lastModifyTime,:lastApproveOption,:projectDate,:developDate,:onlineDate)";
		} else {//update
			sql = "update ums_product set id=:id,product_name=:productName,menu_id=:menuId,price=:price,remark=:remark,trans_code=:transCode,create_real_name=:createRealName,create_user_name=:createUserName,create_date=:createDate,create_time=:createTime,last_modify_real_name=:lastModifyRealName,last_modify_user_name=:lastModifyUserName,last_modify_date=:lastModifyDate,last_modify_time=:lastModifyTime,last_approve_option=:lastApproveOption,project_date=:projectDate,develop_date=:developDate,online_date=:onlineDate where id=:id";

		}
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("id", id); 
		args.put("productName", appData.getValue("productName")); 
		args.put("menuId", appData.getValue("menuId")); 
		args.put("price", appData.getValue("price")); 
		args.put("remark", appData.getValue("remark")); 
		args.put("transCode", appData.getValue("transCode")); 
		args.put("createRealName", appData.getValue("createRealName")); 
		args.put("createUserName", appData.getValue("createUserName")); 
		args.put("createDate", appData.getValue("createDate")); 
		args.put("createTime", appData.getValue("createTime")); 
		args.put("lastModifyRealName", appData.getValue("lastModifyRealName")); 
		args.put("lastModifyUserName", appData.getValue("lastModifyUserName")); 
		args.put("lastModifyDate", appData.getValue("lastModifyDate")); 
		args.put("lastModifyTime", appData.getValue("lastModifyTime")); 
		args.put("lastApproveOption", appData.getValue("lastApproveOption")); 
		args.put("projectDate", appData.getValue("projectDate")); 
		args.put("developDate", appData.getValue("developDate")); 
		args.put("onlineDate", appData.getValue("onlineDate")); 
		basDAOFacade.update(sql, args);
		

		JSONObject gridParams = JSONObject.fromObject(appData.getValue("gridParam"));// JSONArray.fromObject(appData.getValue("siteList"));
		if (gridParams!=null  && appData.getValue("entitySid") != null){
			appData.setValue("searchboxVal", gridParams.get("searchboxVal"));
			appData.setValue("searchboxKey", gridParams.get("searchboxKey"));
		}
		
		return this.getPageList(appData);
	}

}
