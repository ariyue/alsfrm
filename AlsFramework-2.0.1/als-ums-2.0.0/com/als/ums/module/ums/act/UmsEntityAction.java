package com.als.ums.module.ums.act;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.als.frm.bas.dao.Operator;
import com.als.frm.cache.FrmBasConstantCache;
import com.als.frm.comm.FrmConstant;
import com.als.frm.comm.dto.AppData;
import com.als.frm.comm.dto.Pagination;
import com.als.frm.comm.util.BeanUtil;
import com.als.frm.comm.util.ConvertUtil;
import com.als.frm.ex.AppException;
import com.als.mod.domain.UmsEntity;
import com.als.mod.domain.UmsUnit;
import com.als.ums.module.ums.biz.UmsEntityBIZ;
import com.als.web.action.BasAction;
import com.als.web.action.IAction;
import com.als.web.action.type.Action;
import com.als.web.action.type.ActionMetod;
import com.als.web.action.type.SpringBean;

@Action("umsentity")
public class UmsEntityAction extends BasAction implements IAction{

	@SpringBean
	private UmsEntityBIZ umsEntityBIZImpl;
	
	@Override
	public String getTransCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object init(AppData appData) {
		return null;
	}
	
	@ActionMetod("regist")
	public Object regist(AppData appData){
		
		return umsEntityBIZImpl.execRegist(appData);
	}
	
	@SpringBean
	private FrmBasConstantCache frmBasConstantCache;

	@ActionMetod("lookuppage")
	public Object lookupPage(AppData appData){
		
		Pagination p = super.lookupPage(appData, "com.als.mod.domain.UmsEntity");
		
		//列表数据格式化--------------------------------------------------------------------------------------------------------------------
		List<Map> entityTypeList = frmBasConstantCache.getConstantList("ENTITY_TYPE", "00000");
		List<Map> entityStatusList = frmBasConstantCache.getConstantList("ENTITY_STATUS", "00000");
		List<Map> list = (List<Map>)p.getDataList();
		
		Object dt;
		for (int i =0; i < list.size(); i++){
			//数据下拉框entityType
			list.get(i).put("entityTypeDisplay", frmBasConstantCache.getText(list.get(i).get("entityType").toString(), entityTypeList));
			list.get(i).put("entityStatusDisplay", frmBasConstantCache.getText(list.get(i).get("entityStatus").toString(), entityStatusList));
			
			//日期格式转化
			list.get(i).put("openDate", ConvertUtil.convert2ViewDate(list.get(i).get("openDate").toString()));
			list.get(i).put("validPeriod", ConvertUtil.convert2ViewDate(list.get(i).get("validPeriod").toString()));
			list.get(i).put("createDate", ConvertUtil.convert2ViewDate(list.get(i).get("createDate").toString()));
			list.get(i).put("lastModifyDate", ConvertUtil.convert2ViewDate(list.get(i).get("lastModifyDate").toString()));
			
			//时间格式转化
			list.get(i).put("openTime", ConvertUtil.convert2ViewTime(list.get(i).get("openTime").toString()));
			list.get(i).put("createTime", ConvertUtil.convert2ViewTime(list.get(i).get("createTime").toString()));
			list.get(i).put("lastModifyTime", ConvertUtil.convert2ViewTime(list.get(i).get("lastModifyTime").toString()));
		}
		//数据格式化--------------------------------------------------------------------------------------------------------------------
		return p;
	}
	@ActionMetod("save")
	public Object save(AppData appData){
		
		String entitySid = appData.getValue("entitySid").toString();
		if (entitySid.equals(FrmConstant.FRM_DEFAULT_ENTITY_SID)){
			throw new AppException("err.ums.01005", new Object[]{});
		}
		
		boolean newFlag = Boolean.valueOf(appData.getValue("newFlag").toString()) ;
		UmsEntity entity = new UmsEntity();
		//数据格式转化（根据数据库表结构查一下哪些不是字符串的)
		Map m =  appData.getMap();
		m.put("maxUserCount", Integer.valueOf(m.get("maxUserCount").toString()));
		m.put("maxDiskSpace", Integer.valueOf(m.get("maxDiskSpace").toString()));
		//前端数据转为实体类
		BeanUtil.toBean(m, entity, false);
		
		if (newFlag){
			//通过界面自己定义，如果有的业务界面没有定义，可用UUID生成或其它方式
			//entity.setId(UuidUtil.create());
			//super.addEntity(entity);
			umsEntityBIZImpl.addEntity(entity);
		}else {
			//super.modifyEntity(entity);
			umsEntityBIZImpl.modifyEntity(entity);
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
		UmsEntity entity = new UmsEntity();
		entity.setId(id);
		//组装实体实体 end----------------------------------------------------
		if (id.equals("sys")){
			throw new AppException("err.ums.01005", new Object[]{});
		}
		//执行业务
		super.removeEntity(entity);
		
		
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
	
	/**
	 * 获取entity下拉列表数据
	 * @param appData
	 * @return
	 */
	@ActionMetod("lookupentitycombo")
	public Object lookupEntityCombo(AppData appData){
		
		
		//查询实体及条件
		UmsEntity entity = new UmsEntity();
		//entity.setEntitySid("00000");
		
		//条件操作符
		Map<String,Operator> opMap = new HashMap();
		//opMap.put("entitySid", Operator.ne);

		//排序
		List<Object[]> orderList = new ArrayList();
		//orderList.add(new Object[]{"row_order", "asc"});
		
		List<UmsEntity> list = this.getLookupProvider().lookup(entity, opMap, orderList);
		return list;
	}

}
