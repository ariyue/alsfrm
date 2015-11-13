package com.als.ums.module.ums.act;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.als.frm.comm.dto.AppData;
import com.als.mod.domain.UmsUserRole;
import com.als.ums.module.ums.biz.UmsUserBIZ;
import com.als.web.action.BasAction;
import com.als.web.action.IAction;
import com.als.web.action.type.Action;
import com.als.web.action.type.ActionMetod;
import com.als.web.action.type.SpringBean;

@Action("umsauthorize")
public class UmsAuthorizeAction extends BasAction implements IAction  {
	
	@SpringBean
	private UmsUserBIZ umUserBIZImpl;

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
	
	@ActionMetod("getusrroles")
	public Object getUserRoles(AppData appData) {
		String id = appData.getValue("id").toString();
		List<Map<String, Object>> list = umUserBIZImpl.getUserRoles(id);
		String roles = "";
		if (list != null && list.size() > 0){
			for (int i = 0, len = list.size(); i< len; i++){
				roles += "," + list.get(i).get("roleId").toString();
			}
		}
		return roles;
	}
	
	@ActionMetod("getusrunit")
	public Object getUserUnit(AppData appData) {
		String id = appData.getValue("id").toString();
		Object[] unitAry = umUserBIZImpl.getUserUnit(id);
		return unitAry;
	}
	
	@ActionMetod("save")
	public Object saveUmsAuthorize(AppData appData) {

		
		String id = appData.getValue("id").toString();
		String unitId = appData.getValue("unitId").toString();
		String products = appData.getValue("products").toString();
		umUserBIZImpl.updateUserUnitAndProduct(id, unitId, products);
		
		String roles = appData.getValue("roles").toString();
		String[] roleAry = roles.split(",");
		List<UmsUserRole> roleList = new ArrayList<UmsUserRole>();
		for (int i = 0, len = roleAry.length; i < len; i ++ ){
			if (!roleAry[i].equals("")){
				UmsUserRole r = new UmsUserRole();
				r.setUserId(id);
				r.setRoleId(roleAry[i]);
				roleList.add(r);
			}
		}
		umUserBIZImpl.updateUserRoles(id, roleList);
		
		return "success";
	}
	
	

}
