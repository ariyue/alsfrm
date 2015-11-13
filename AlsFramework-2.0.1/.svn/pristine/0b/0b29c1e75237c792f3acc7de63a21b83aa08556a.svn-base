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
import com.als.frm.module.frm.biz.FrmBasCfgBIZ;

@Service("frmBasCfgBIZImpl")
public class FrmBasCfgBIZImpl implements FrmBasCfgBIZ{

	@Autowired
	private BasDAOFacade basDAOFacade;
	
	@Autowired
	private FrmBasCfgCache frmBasCfgCache;

	@Override
	public void removeEntity(AppData appData) {
		String id = appData.getValue("id").toString();
		
		if (!(id == null || id.trim().equals(""))){
			String sql = "delete from frm_bas_cfg where id= :id";
			Map<String, Object> args = new HashMap<String, Object>();
			args.put("id", id);
			basDAOFacade.update(sql, args);
			
			String entitySid= FrmConstant.FRM_DEFAULT_ENTITY_SID;  
			if ( appData.getValue("entitySid") != null &&  !appData.getValue("entitySid").toString().trim().equals("")){
				entitySid = appData.getValue("entitySid").toString();
			}
			String code = appData.getValue("code").toString();
			frmBasCfgCache.removeCfgByCode(code);
		}
	}

	@Override
	public void saveEntity(AppData appData) {
		String entitySid= FrmConstant.FRM_DEFAULT_ENTITY_SID;  
		if ( appData.getValue("entitySid") != null &&  !appData.getValue("entitySid").toString().trim().equals("")){
			entitySid = appData.getValue("entitySid").toString();
		}
		
		String id = appData.getValue("id").toString();
		String sql = "";
		boolean newFlag = false;
		if(id == null || id.trim().equals("")){//insert
			id = UuidUtil.create();
			newFlag = true;
			sql = "insert into frm_bas_cfg(id,name,code,val,entity_sid,remark) values (:id, :name, :code, :val, :entitySid, :remark)";
		} else {//update
			sql = "update frm_bas_cfg set id=:id,name=:name,code=:code,val=:val,entity_sid=:entitySid,remark=:remark where id=:id";

		}
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("id", id);
		args.put("name", appData.getValue("name"));
		String code = appData.getValue("code").toString().toUpperCase();
		args.put("code", code);
		args.put("val", appData.getValue("val"));
		args.put("entitySid", entitySid);
		args.put("remark", appData.getValue("remark"));
		basDAOFacade.update(sql, args);
		if (newFlag){
			frmBasCfgCache.addCfg(args);
		} else {
			frmBasCfgCache.updateCfg(args);
		}
	}

}
