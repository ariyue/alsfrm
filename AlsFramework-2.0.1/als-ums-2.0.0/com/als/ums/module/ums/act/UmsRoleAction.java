package com.als.ums.module.ums.act;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.als.frm.bas.dao.Operator;
import com.als.frm.comm.FrmConstant;
import com.als.frm.comm.dto.AppData;
import com.als.frm.comm.dto.Pagination;
import com.als.frm.comm.util.BeanUtil;
import com.als.frm.comm.util.UuidUtil;
import com.als.frm.ex.AppException;
import com.als.mod.domain.UmsEntity;
import com.als.mod.domain.UmsRole;
import com.als.ums.module.ums.biz.UmsEntityBIZ;
import com.als.ums.module.ums.biz.UmsRoleBIZ;
import com.als.web.action.BasAction;
import com.als.web.action.IAction;
import com.als.web.action.type.Action;
import com.als.web.action.type.ActionMetod;
import com.als.web.action.type.SpringBean;

@Action("umsrole")
public class UmsRoleAction extends BasAction implements IAction {

	@SpringBean
	private UmsRoleBIZ umsRoleBIZImpl;
	
	@SpringBean
	private UmsEntityBIZ umsEntityBIZImpl;
	
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
	
	@ActionMetod("lookuppage")
	public Object lookupPage(AppData appData){
		
		Pagination<Map> p =  super.lookupPage(appData, "com.als.mod.domain.UmsRole");
		
		//列表数据格式化-------------------------------------------
		Map<String, String> entityMap = umsEntityBIZImpl.getEntityMap();
		List<Map> list = (List<Map>)p.getDataList();
		for (int i =0; i < list.size(); i++){
			//数据下拉框entityType
			list.get(i).put("entitySidDisplay", entityMap.get(list.get(i).get("entitySid")));
		}
		//数据格式化---------------------------------------------------------------

		return p;
	}
	
	
	@ActionMetod("save")
	public Object save(AppData appData){
		
		boolean newFlag = true;
		String id = appData.getValue("id").toString();
		if (id != null && !id.trim().equals("")){
			newFlag = false;
		}
		
		
		//查询实体及条件
		UmsRole qryEntity = new UmsRole();
		qryEntity.setRoleName(appData.getValue("roleName").toString());
		Object entitySid = appData.getValue("entitySid");
		if (entitySid == null || entitySid.toString().trim().equals("")){
			entitySid = FrmConstant.FRM_DEFAULT_ENTITY_SID;
			appData.setValue("entitySid", entitySid);
		}
		qryEntity.setEntitySid(entitySid.toString());
		
		//条件操作符
		Map<String,Operator> opMap = new HashMap();
		opMap.put("roleName", Operator.eq);
		opMap.put("entitySid", Operator.eq);
		List<UmsRole> rootList  = this.getLookupProvider().lookup(qryEntity, opMap);
		if (rootList != null){
			if (rootList.size() > 1){
				throw new AppException("warning.ums.01002", new Object[]{});
			} else if (rootList.size() == 1 ){
				String dbId = rootList.get(0).getId();
				if (!dbId.equals(id)){
					throw new AppException("warning.ums.01002", new Object[]{});
				}
			}
		}
		
		//组装实体实体----------------------------------------------------
		Map m =  appData.getMap();
		//数据格式转化（根据数据库表结构查一下哪些不是字符串的)
		m.put("rowOrder", Integer.valueOf(m.get("rowOrder").toString()));
		UmsRole entity = new UmsRole();
		
		BeanUtil.toBean(m, entity, false);
		//组装实体实体 end ----------------------------------------------------
		if (newFlag){
			entity.setId(UuidUtil.create());
			umsRoleBIZImpl.addEntity(entity);
		} else {
			umsRoleBIZImpl.modifyEntity(entity);
		}
		//重新查询列表---------------------------------------------------------------------------------------------
		//从grid中取出查询参数
		JSONObject gridParams = JSONObject.fromObject(appData.getValue("gridParam"));
		if (gridParams!=null && gridParams.get("searchboxVal")!= null && gridParams.get("searchboxKey") != null){
			appData.setValue("searchboxVal", gridParams.get("searchboxVal"));
			appData.setValue("searchboxKey", gridParams.get("searchboxKey"));
		}
		//执行查询
		return this.lookupPage(appData);
		//重新查询列表 end -----------------------------------------------------------------------------------------
		
	}
	
	@ActionMetod("remove")
	public Object remove(AppData appData){
		
		String id = appData.getValue("id").toString().trim();
		
		//组装实体实体----------------------------------------------------
		UmsRole entity = new UmsRole();
		entity.setId(id);
		//组装实体实体 end----------------------------------------------------
		
		//执行业务
		umsRoleBIZImpl.removeEntity(entity);
		//重新查询列表---------------------------------------------------------------------------------------------
		//从grid中取出查询参数
		JSONObject gridParams = JSONObject.fromObject(appData.getValue("gridParam"));
		if (gridParams!=null && gridParams.get("searchboxVal")!= null && gridParams.get("searchboxKey") != null){
			appData.setValue("searchboxVal", gridParams.get("searchboxVal"));
			appData.setValue("searchboxKey", gridParams.get("searchboxKey"));
		}
		//执行查询
		return this.lookupPage(appData);
		//重新查询列表 end -----------------------------------------------------------------------------------------
	}
	
	@ActionMetod("getrolelist")
	public Object getRoleList(AppData appData){
		
		String entitySid = appData.getEntitySid();
		return this.umsRoleBIZImpl.getRoleList(entitySid);
	}

}
