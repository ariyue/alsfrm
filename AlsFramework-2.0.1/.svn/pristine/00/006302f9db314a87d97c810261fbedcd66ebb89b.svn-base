package com.als.ums.module.ums.act;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.als.frm.comm.dto.AppData;
import com.als.frm.comm.dto.Pagination;
import com.als.frm.comm.util.BeanUtil;
import com.als.frm.ex.AppException;
import com.als.mod.domain.UmsUser;
import com.als.ums.module.ums.biz.UmsUserBIZ;
import com.als.web.action.BasAction;
import com.als.web.action.IAction;
import com.als.web.action.type.Action;
import com.als.web.action.type.ActionMetod;
import com.als.web.action.type.SpringBean;

@Action("umsuser")
public class UmsUserAction extends BasAction implements IAction {

	@SpringBean
	private UmsUserBIZ umUserBIZImpl;
	
	public void preHandle(AppData appData) {
		super.preHandle(appData);
		
	} 
	
	@Override
	public String getTransCode() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@ActionMetod("checkuser")
	public Object checkUser(AppData appData){
		
		
		String validatorCode = appData.getValue("validatorCode").toString().trim();
		String imageRandomCode = this.getActionContext().getRequest().getSession().getAttribute("loginImageValidator").toString();
		Map result = new HashMap(3);
		if (!validatorCode.equalsIgnoreCase(imageRandomCode)){
			result.put("msg", "验证码错误！");
			result.put("flag", false);
			return result;
		}
		
		
		
		return result;
		
	}

	@Override
	public Object init(AppData appData) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@ActionMetod("lookuppage")
	public Object lookupPage(AppData appData){
		
		Pagination p = super.lookupPage(appData, "com.als.mod.domain.UmsUser");
		return p;
	}
	
	
	@ActionMetod("remove")
	public Object remove(AppData appData) {
		
		Object id = appData.getValue("id");
		if (id == null || id.toString().trim().equals("")){
			throw new AppException("warning.ums.01003", new Object[]{});
		}
		
		UmsUser entity = new UmsUser();
		entity.setId(id.toString());
		umUserBIZImpl.removeEntity(entity);
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
	
	@ActionMetod("save")
	public Object save(AppData appData) {
		
		boolean newFlag = Boolean.valueOf(appData.getValue("newFlag").toString()) ;
		UmsUser entity = new UmsUser();
		//数据格式转化（根据数据库表结构查一下哪些不是字符串的)
		Map m =  appData.getMap();
		//m.put("rowOrder", Integer.valueOf(m.get("rowOrder").toString()));
		//前端数据转为实体类
		BeanUtil.toBean(m, entity, false);
		
		if (newFlag){
			entity = umUserBIZImpl.addEntity(entity);
		}else {
			entity = umUserBIZImpl.modifyEntity(entity);
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

}
