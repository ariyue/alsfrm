package com.als.ums.module.ums.act;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.als.frm.bas.dao.Operator;
import com.als.frm.comm.dto.AppData;
import com.als.frm.comm.dto.TreeDTO;
import com.als.frm.comm.util.BeanUtil;
import com.als.frm.ex.AppException;
import com.als.mod.domain.UmsMenu;
import com.als.ums.module.ums.biz.UmsMenuBIZ;
import com.als.web.action.BasAction;
import com.als.web.action.IAction;
import com.als.web.action.type.Action;
import com.als.web.action.type.ActionMetod;
import com.als.web.action.type.SpringBean;

@Action("umsmenu")
public class UmsMenuAction extends BasAction implements IAction {

	@SpringBean
	private UmsMenuBIZ umsMenuBIZImpl;
	
	@Override
	public String getTransCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@ActionMetod("init")
	@Override
	public Object init(AppData appData) {

		Map m = new HashMap();
		String appName = this.generalI18nMsg("msg.sys.00002", new Object[]{});
		m.put("appName", appName);
		return m;
	}
	
	@ActionMetod("getProjectMenu")
	public Object getProjectMenu(AppData appData) {

		return umsMenuBIZImpl.getProjMenu();
	}
	
	
	@ActionMetod("getSecondLevelMenu")
	public Object getSecondLevelMenu(AppData appData) {

		String prijMenuId = appData.getValue("pid").toString();
		return umsMenuBIZImpl.getSecondLevelMenu(prijMenuId);
	}
	
	@ActionMetod("getThridLevelMenu")
	public Object getThridLevelMenu(AppData appData) {

		String currentMenuPid = appData.getValue("pid").toString();
		String userId = appData.getValue("userId").toString();
		List<TreeDTO> resultMenuList = new ArrayList<TreeDTO>();
		umsMenuBIZImpl.getUserMenuTree(userId, 3, currentMenuPid, resultMenuList);
		return resultMenuList;
	}
	
	@ActionMetod("getSecondAndThridLevelMenu")
	public Object getSecondAndThridLevelMenu(AppData appData) {

		String prijMenuId = appData.getValue("pid").toString();
		String userId = appData.getValue("userId").toString();
		List<Map> resultList = new ArrayList<Map>();
		List<Map> secondMenuList = umsMenuBIZImpl.getSecondLevelMenu(prijMenuId);
		
		for (int i = 0, len = secondMenuList.size(); i < len; i++){
			Map item = secondMenuList.get(i);
			Map m = new HashMap(2);
			m.put("item", item);
			List<TreeDTO> resultMenuList = new ArrayList<TreeDTO>();
			umsMenuBIZImpl.getUserMenuTree(userId, 3, item.get("id").toString(), resultMenuList);
			m.put("itemSubTree", resultMenuList);
			resultList.add(m);
		}
		return resultList;
	}
	///////////////////////////201521102///////////////////////////////////
	
	
	@ActionMetod("getloginusermenu")
	public Object getLoginUserMenu(AppData appData) {

		String productMenuCode = appData.getValue("pid").toString();
		String userId = appData.getValue("userId").toString();
		List<Map> resultList = umsMenuBIZImpl.getLoginUserMenu(productMenuCode, userId);
		
		return resultList;
	}
	
	
	
	@SuppressWarnings("unchecked")
	@ActionMetod("lookuptree")
	public Object lookupTree(AppData appData){
		
		//根父节点ID
		String pid = "0";
		
		//String entitySid = appData.getValue("entitySid").toString();
		//查询实体及条件
		UmsMenu entity = new UmsMenu();
		entity.setPid(pid);
		
		//条件操作符
		Map<String,Operator> opMap = new HashMap();
		opMap.put("pid", Operator.eq);

		//排序
		List<Object[]> orderList = new ArrayList();
		orderList.add(new Object[]{"row_order", "asc"});
		
		List<UmsMenu> rootList  = this.getLookupProvider().lookup(entity, opMap, orderList);
		List<TreeDTO> resultList = new ArrayList<TreeDTO>();
		
		if (rootList != null){
			for(int i =0, len = rootList.size(); i < len; i++){
				UmsMenu o = rootList.get(i);
				TreeDTO node = new TreeDTO();
				node.setId(o.getId());
				node.setText(o.getMenuName());
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
		TreeDTO rootNode = new TreeDTO();
		String rootId = "0";
		rootNode.setId(rootId);
		rootNode.setText("菜单树");
		rootNode.setState("open");//节点不自动展开
		rootNode.setChildren(resultList);
		List<TreeDTO> rootTreeList = new ArrayList<TreeDTO>();
		rootTreeList.add(rootNode);
		UmsMenu rootObj = new UmsMenu();
		rootObj.setId(rootId);
		Map nodeEntityObj = new HashMap<String, Object>(1);
		nodeEntityObj.put("nodeEntityObj", rootObj);
		rootNode.setAttributes(nodeEntityObj);

		return rootTreeList;
		//----------------------------------
		//return resultList;
		
	}
	
	private void lookupChildren(String pid, List<TreeDTO> children){
		
		//查询实体及条件
		UmsMenu entity = new UmsMenu();
		entity.setPid(pid);
		
		//条件操作符
		Map<String,Operator> opMap = new HashMap();
		opMap.put("pid", Operator.eq);

		//排序
		List<Object[]> orderList = new ArrayList();
		orderList.add(new Object[]{"row_order", "asc"});
		
		List<UmsMenu> list = this.getLookupProvider().lookup(entity, opMap, orderList);
		
		if (list != null){
			for(int i =0, len = list.size(); i < len; i++){
				UmsMenu o = list.get(i);
				TreeDTO node = new TreeDTO();
				node.setId(o.getId());
				node.setText(o.getMenuName());
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
			//TODO
			throw new AppException("warning.ums.01004", new Object[]{});
		}
		UmsMenu entity = new UmsMenu();
		entity.setId(id.toString());
		umsMenuBIZImpl.removeEntity(entity);
		return "success";
	}
	
	@ActionMetod("save")
	public Object save(AppData appData) {
		
		boolean newFlag = Boolean.valueOf(appData.getValue("newFlag").toString()) ;
		UmsMenu entity = new UmsMenu();
		//数据格式转化（根据数据库表结构查一下哪些不是字符串的)
		Map m =  appData.getMap();
		m.put("rowOrder", Integer.valueOf(m.get("rowOrder").toString()));
		//前端数据转为实体类
		BeanUtil.toBean(m, entity, false);
		
		if (newFlag){
			entity = umsMenuBIZImpl.addEntity(entity);
		}else {
			entity = umsMenuBIZImpl.modifyEntity(entity);
		}
		
		return entity;
	}
	

}
