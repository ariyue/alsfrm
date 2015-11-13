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
import com.als.mod.domain.UmsTransCode;
import com.als.ums.module.ums.biz.UmsTransCodeBIZ;
import com.als.web.action.BasAction;
import com.als.web.action.IAction;
import com.als.web.action.type.Action;
import com.als.web.action.type.ActionMetod;
import com.als.web.action.type.SpringBean;

@Action("umstranscode")
public class UmsTransCodeAction extends BasAction implements IAction {

	@SpringBean
	private UmsTransCodeBIZ umsTransCodeBIZImpl;
	
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
	
	
	@SuppressWarnings("unchecked")
	@ActionMetod("lookupall")
	public Object lookupAll(AppData appData){
		
		//根父节点ID
		String pid = "-1";
		
		//查询实体及条件
		UmsTransCode entity = new UmsTransCode();
		entity.setPid(pid);
		
		//条件操作符
		Map<String,Operator> opMap = new HashMap();
		opMap.put("pid", Operator.eq);

		//排序
		List<Object[]> orderList = new ArrayList();
		orderList.add(new Object[]{"row_order", "asc"});
		
		List<UmsTransCode> rootList  = this.getLookupProvider().lookup(entity, opMap, orderList);
		List<TreeDTO> resultList = new ArrayList<TreeDTO>();
		
		if (rootList != null){
			for(int i =0, len = rootList.size(); i < len; i++){
				UmsTransCode o = rootList.get(i);
				TreeDTO node = new TreeDTO();
				node.setId(o.getId());
				node.setText(o.getTransName());
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
		rootNode.setId("-1");
		rootNode.setText("交易树");
		rootNode.setState("open");//节点不自动展开
		rootNode.setChildren(resultList);
		List<TreeDTO> rootTreeList = new ArrayList<TreeDTO>();
		rootTreeList.add(rootNode);
		//----------------------------------
		//return resultList;
		return rootTreeList;
	}
	
	private void lookupChildren(String pid, List<TreeDTO> children){
		
		//查询实体及条件
		UmsTransCode entity = new UmsTransCode();
		entity.setPid(pid);
		
		//条件操作符
		Map<String,Operator> opMap = new HashMap();
		opMap.put("pid", Operator.eq);

		//排序
		List<Object[]> orderList = new ArrayList();
		orderList.add(new Object[]{"row_order", "asc"});
		
		List<UmsTransCode> list = this.getLookupProvider().lookup(entity, opMap, orderList);
		
		if (list != null){
			for(int i =0, len = list.size(); i < len; i++){
				UmsTransCode o = list.get(i);
				TreeDTO node = new TreeDTO();
				node.setId(o.getId());
				node.setText(o.getTransName());
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
	
	@ActionMetod("save")
	public Object save(AppData appData){
		
		String id = appData.getValue("id").toString().trim();
		Boolean newFlag = Boolean.valueOf(appData.getValue("newFlag").toString());
		
		//组装实体实体----------------------------------------------------
		Map m =  appData.getMap();
		m.put("rowOrder", Integer.valueOf(m.get("rowOrder").toString()));
		UmsTransCode entity = new UmsTransCode();
		BeanUtil.toBean(m, entity, false);
		//组装实体实体 end ----------------------------------------------------

		if( newFlag){
			umsTransCodeBIZImpl.addEntity(entity);
		} else {
			umsTransCodeBIZImpl.modifyEntity(entity);
		}
		return "success";
		
	}
	
	@ActionMetod("remove")
	public Object remove(AppData appData){
		
		String id = appData.getValue("id").toString().trim();
		
		//组装实体实体----------------------------------------------------
		UmsTransCode entity = new UmsTransCode();
		entity.setId(id);
		//组装实体实体 end----------------------------------------------------
		
		//执行业务
		umsTransCodeBIZImpl.removeEntity(entity);
		return "success";
	}

}
