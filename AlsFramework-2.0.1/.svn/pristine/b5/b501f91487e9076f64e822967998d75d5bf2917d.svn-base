package com.als.frm.module.frm.act;

import net.sf.json.JSONObject;

import com.als.frm.comm.dto.AppData;
import com.als.frm.comm.dto.Pagination;
import com.als.frm.module.frm.biz.FrmBasCfgBIZ;
import com.als.web.action.BasAction;
import com.als.web.action.IAction;
import com.als.web.action.type.Action;
import com.als.web.action.type.ActionMetod;
import com.als.web.action.type.SpringBean;

@Action("frmBasCfg")
public class FrmBasCfgAction extends BasAction implements IAction {

	@SpringBean
	private FrmBasCfgBIZ frmBasCfgBIZImpl;
	
	@Override
	public String getTransCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object init(AppData appData) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	@ActionMetod("getPageList")
	public Object getPageList(AppData appData) {
		
		return super.lookupPage(appData, "com.als.mod.domain.FrmBasCfg");
	}
	

	@ActionMetod("saveEntity")
	public Object saveEntity(AppData appData) {
		
		this.frmBasCfgBIZImpl.saveEntity(appData);
		
		//从grid中取出查询参数
		JSONObject gridParams = JSONObject.fromObject(appData.getValue("gridParam"));// JSONArray.fromObject(appData.getValue("siteList"));
		if (gridParams!=null && gridParams.get("searchboxVal")!= null && gridParams.get("searchboxKey") != null){
			appData.setValue("searchboxVal", gridParams.get("searchboxVal"));
			appData.setValue("searchboxKey", gridParams.get("searchboxKey"));
		}
		//执行查询
		return super.lookupPage(appData, "com.als.mod.domain.FrmBasCfg");
	}
	
	@ActionMetod("removeEntity")
	public Object removeEntity(AppData appData) {
		
		this.frmBasCfgBIZImpl.removeEntity(appData);
		
		//从grid中取出查询参数
		JSONObject gridParams = JSONObject.fromObject(appData.getValue("gridParam"));// JSONArray.fromObject(appData.getValue("siteList"));
		if (gridParams!=null && gridParams.get("searchboxVal")!= null && gridParams.get("searchboxKey") != null){
			appData.setValue("searchboxVal", gridParams.get("searchboxVal"));
			appData.setValue("searchboxKey", gridParams.get("searchboxKey"));
		}
		//执行查询
		return super.lookupPage(appData, "com.als.mod.domain.FrmBasCfg");
	}

}
