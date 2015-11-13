package com.als.ums.module.ums.act;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.als.frm.bas.dao.Operator;
import com.als.frm.comm.dto.AppData;
import com.als.frm.comm.dto.Pagination;
import com.als.frm.comm.dto.TreeDTO;
import com.als.frm.comm.util.BeanUtil;
import com.als.frm.ex.AppException;
import com.als.mod.domain.UmsUnit;
import com.als.ums.module.ums.biz.UmsUnitBIZ;
import com.als.web.action.BasAction;
import com.als.web.action.IAction;
import com.als.web.action.type.Action;
import com.als.web.action.type.ActionMetod;
import com.als.web.action.type.SpringBean;

@Action("umsunit")
public class UmsUnitAction extends BasAction implements IAction{

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
	private UmsUnitBIZ umsUnitBIZImpl;
	
	
	@ActionMetod("lookuppage")
	public Object lookupPage(AppData appData) {

		Pagination p = super.lookupPage(appData, "com.als.mod.domain.UmsUnit");
		return p;
	}
	
	@SuppressWarnings("unchecked")
	@ActionMetod("lookuptree")
	public Object lookupTree(AppData appData){
		
		//根父节点ID
		String pid = "-1";
		
		String entitySid = appData.getValue("entitySid").toString();
		//查询实体及条件
		UmsUnit entity = new UmsUnit();
		entity.setPid(pid);
		entity.setEntitySid(entitySid);
		
		//条件操作符
		Map<String,Operator> opMap = new HashMap();
		opMap.put("pid", Operator.eq);
		opMap.put("entitySid", Operator.eq);

		//排序
		List<Object[]> orderList = new ArrayList();
		orderList.add(new Object[]{"row_order", "asc"});
		
		List<UmsUnit> rootList  = this.getLookupProvider().lookup(entity, opMap, orderList);
		List<TreeDTO> resultList = new ArrayList<TreeDTO>();
		
		if (rootList != null){
			for(int i =0, len = rootList.size(); i < len; i++){
				UmsUnit o = rootList.get(i);
				TreeDTO node = new TreeDTO();
				node.setId(o.getId());
				node.setText(o.getUnitName());
				node.setState("closed");//节点不自动展开
				
				//把整个实例放到树的属性中
				Map nodeEntityObj = new HashMap<String, Object>(1);
				nodeEntityObj.put("nodeEntityObj", o);
				node.setAttributes(nodeEntityObj);
				
				List<TreeDTO> children = new ArrayList<TreeDTO>();
				//加载子节点集合
				this.lookupChildren(o.getId(), children);
				node.setChildren(children);
				resultList.add(node);
			}
		}
		
		//如果有必要，可以手动加入根节点--------
		/*TreeDTO rootNode = new TreeDTO();
		rootNode.setId("-1");
		rootNode.setText("交易树");
		rootNode.setState("open");//节点不自动展开
		rootNode.setChildren(resultList);
		List<TreeDTO> rootTreeList = new ArrayList<TreeDTO>();
		rootTreeList.add(rootNode);
		return rootTreeList;*/
		//----------------------------------
		return resultList;
		
	}
	
	private void lookupChildren(String pid, List<TreeDTO> children){
		
		//查询实体及条件
		UmsUnit entity = new UmsUnit();
		entity.setPid(pid);
		
		//条件操作符
		Map<String,Operator> opMap = new HashMap();
		opMap.put("pid", Operator.eq);

		//排序
		List<Object[]> orderList = new ArrayList();
		orderList.add(new Object[]{"row_order", "asc"});
		
		List<UmsUnit> list = this.getLookupProvider().lookup(entity, opMap, orderList);
		
		if (list != null){
			for(int i =0, len = list.size(); i < len; i++){
				UmsUnit o = list.get(i);
				TreeDTO node = new TreeDTO();
				node.setId(o.getId());
				node.setText(o.getUnitName());
				node.setState("closed");//节点不自动展开
				//把整个实例放到树的属性中
				Map nodeEntityObj = new HashMap<String, Object>(1);
				nodeEntityObj.put("nodeEntityObj", o);
				node.setAttributes(nodeEntityObj);
				
				List<TreeDTO> c = new ArrayList<TreeDTO>();
				this.lookupChildren(o.getId(), c);
				node.setChildren(c);
				children.add(node);
			}
		}
	}
	
	@ActionMetod("remove")
	public Object remove(AppData appData) {
		
		Object id = appData.getValue("id");
		if (id == null || id.toString().trim().equals("")){
			throw new AppException("warning.ums.01003", new Object[]{});
		}
		if (id.toString().equals("-1")){
			throw new AppException("warning.ums.01004", new Object[]{});
		}
		UmsUnit entity = new UmsUnit();
		entity.setId(id.toString());
		umsUnitBIZImpl.removeEntity(entity);
		return "success";
	}
	
	@ActionMetod("save")
	public Object save(AppData appData) {
		
		boolean newFlag = Boolean.valueOf(appData.getValue("newFlag").toString()) ;
		UmsUnit entity = new UmsUnit();
		//数据格式转化（根据数据库表结构查一下哪些不是字符串的)
		Map m =  appData.getMap();
		m.put("rowOrder", Integer.valueOf(m.get("rowOrder").toString()));
		//前端数据转为实体类
		BeanUtil.toBean(m, entity, false);
		
		if (newFlag){
			entity = umsUnitBIZImpl.addEntity(entity);
		}else {
			entity = umsUnitBIZImpl.modifyEntity(entity);
		}
		
		return entity;
	}

}
