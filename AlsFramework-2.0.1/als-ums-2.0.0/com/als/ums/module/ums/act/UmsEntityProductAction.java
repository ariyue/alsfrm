package com.als.ums.module.ums.act;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.als.frm.cache.FrmBasConstantCache;
import com.als.frm.comm.dto.AppData;
import com.als.frm.comm.dto.Pagination;
import com.als.frm.comm.util.BeanUtil;
import com.als.frm.comm.util.ConvertUtil;
import com.als.frm.comm.util.DateTimeUtil;
import com.als.frm.ex.AppException;
import com.als.mod.domain.UmsEntityProduct;
import com.als.mod.domain.UmsUser;
import com.als.ums.module.ums.biz.UmsEntityProductBIZ;
import com.als.web.action.BasAction;
import com.als.web.action.IAction;
import com.als.web.action.type.Action;
import com.als.web.action.type.ActionMetod;
import com.als.web.action.type.SpringBean;

@Action("umsentityproduct")
public class UmsEntityProductAction extends BasAction implements IAction {

	
	@SpringBean
	private UmsEntityProductBIZ umsEntityProductBIZImpl;
	
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
	
	@SpringBean
	private FrmBasConstantCache frmBasConstantCache;
	
	@ActionMetod("opendproducts")
	public Object getOpendProducts(AppData appData) {

		Object entitySid = appData.getValue("entitySid");
		if (entitySid != null){
			List<Map<String, Object>> list = umsEntityProductBIZImpl.getOpendProducts(entitySid.toString());
			//列表数据格式化--------------------------------------------------------------------------------------------------------------------
			List<Map> entityTypeList = frmBasConstantCache.getConstantList("SYS_PRD_VALID_TYPE", "00000");
			for (int i =0; i < list.size(); i++){
				//数据下拉框entityType
				list.get(i).put("validDateTypeDisplay", frmBasConstantCache.getText(list.get(i).get("validDateType").toString(), entityTypeList));
				
				//日期格式转化
				list.get(i).put("validStartDate", ConvertUtil.convert2ViewDate(list.get(i).get("validStartDate").toString()));
				list.get(i).put("validEndDate", ConvertUtil.convert2ViewDate(list.get(i).get("validEndDate").toString()));

			}
			Pagination p = new Pagination();
			p.setDataList(list);
			p.setTotal(list.size());
			return p;
		}
		return null;
		
	}
	
	
	@ActionMetod("enableproducts")
	public Object getEnableProducts(AppData appData) {

		Object entitySid = appData.getValue("entitySid");
		if (entitySid != null){
			List<Map<String, Object>> list = umsEntityProductBIZImpl.getEnableProducts(entitySid.toString());
			return list;
		}
		return null;
		
	}
	
	@ActionMetod("unopendproducts")
	public Object getUnopenProducts(AppData appData) {
		Object entitySid = appData.getValue("entitySid");
		if (entitySid != null){
			List list = umsEntityProductBIZImpl.getUnOpendProducts(entitySid.toString());
			Pagination p = new Pagination();
			p.setDataList(list);
			p.setTotal(list.size());
			//return p;
			return list;
		}
		return new ArrayList();
	}
	
	@ActionMetod("open")
	public Object open(AppData appData) {
		
		//默认值设置
		String sd = DateTimeUtil.getCurrentDate();
		String ed = DateTimeUtil.dateAdd("y", 1, new Date());
		String tp = "1";//试用
		int max = 10;
		String productIds = appData.getValue("productIds").toString();
		String productNames = appData.getValue("productNames").toString();
		String[] productIdAry = productIds.split(",");
		String[] productNameAry = productNames.split(",");
		
		String entitySid = appData.getValue("entitySid").toString();
		for (int i =0, len = productIdAry.length; i < len; i++){
			UmsEntityProduct entity = new UmsEntityProduct();
			entity.setEntitySid(entitySid);
			entity.setProductId(productIdAry[i]);
			entity.setProductName(productNameAry[i]);
			entity.setValidDateType(tp);
			entity.setValidStartDate(sd);
			entity.setValidEndDate(ed);
			entity.setMaxUserCount(max);
			entity = umsEntityProductBIZImpl.addEntity(entity);
		}
		return "success";
		
	}
	
	@ActionMetod("save")
	public Object save(AppData appData) {
		
		boolean newFlag = Boolean.valueOf(appData.getValue("newFlag").toString()) ;
		UmsEntityProduct entity = new UmsEntityProduct();
		//数据格式转化（根据数据库表结构查一下哪些不是字符串的)
		Map m =  appData.getMap();
		m.put("maxUserCount", Integer.valueOf(m.get("maxUserCount").toString()));
		//前端数据转为实体类
		BeanUtil.toBean(m, entity, false);
		
		if (newFlag){
			entity = umsEntityProductBIZImpl.addEntity(entity);
		}else {
			entity = umsEntityProductBIZImpl.updateEntity(entity);
		}
		
		//重新查询列表---------------------------------------------------------------------------------------------
		
		return this.getOpendProducts(appData);
		
		//重新查询列表 end -----------------------------------------------------------------------------------------
	}
	
	@ActionMetod("remove")
	public Object remove(AppData appData) {
		
		Object id = appData.getValue("id");
		if (id == null || id.toString().trim().equals("")){
			throw new AppException("warning.ums.01003", new Object[]{});
		}
		
		UmsEntityProduct entity = new UmsEntityProduct();
		entity.setId(id.toString());
		umsEntityProductBIZImpl.removeEntity(entity);
		//重新查询列表---------------------------------------------------------------------------------------------
		return "success";
		//return this.getOpendProducts(appData);
		
		//重新查询列表 end -----------------------------------------------------------------------------------------
	}

}
