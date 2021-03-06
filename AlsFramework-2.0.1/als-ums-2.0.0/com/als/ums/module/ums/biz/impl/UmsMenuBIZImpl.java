package com.als.ums.module.ums.biz.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.als.frm.bas.dao.BasDAOFacade;
import com.als.frm.comm.dto.TreeDTO;
import com.als.frm.ex.BizException;
import com.als.mod.domain.UmsMenu;
import com.als.ums.module.ums.biz.UmsMenuBIZ;
import com.als.ums.module.ums.dao.UmsMenuDAO;

@Service("umsMenuBIZImpl")
public class UmsMenuBIZImpl implements UmsMenuBIZ {

	@Autowired
	private BasDAOFacade basDAOFacade;

	@Autowired
	private UmsMenuDAO umsMenuDAOImpl;
	
	@Override
	public void  getUserMenuTree(String userId, int fromMenuLevel, String currentMenuPid, List<TreeDTO> resultMenuList) {
		
		if (resultMenuList == null){
			resultMenuList = new ArrayList<TreeDTO>();
		}
		//用户开通的交易码
		String sql = "select * from ums_menu t where t.id in (select p.id from ums_privilege p  where p.role_id in  (select u.role_id from ums_user_role u where u.user_id=:userId))";
		
		//String sql = "select p.trans_code id from ums_privilege p  where p.role_id in  (select u.role_id from ums_user_role u where u.user_id=:userId)";
		
		Map<String, Object> args = new HashMap<String, Object>(1);
		args.put("userId", userId);
		List<Map> transCodeList = basDAOFacade.select(sql, args);
		
		//所有的pid
		StringBuffer pidList = new StringBuffer();
		Map<String,List> childrenMap = new HashMap<String, List>();
		List<TreeDTO> resultList = new ArrayList<TreeDTO>();
		for (int i = 0, len = transCodeList.size(); i < len; i++){
			pidList.append(transCodeList.get(i).get("id"));
			generalPid(fromMenuLevel, transCodeList.get(i), pidList);
		}
		
		//构建菜单
		sql = "select * from ums_menu t where t.pid=:currentMenuPid order by t.row_order";
		args = new HashMap<String, Object>(1);
		//args.put("menuLevel", String.valueOf(fromMenuLevel));
		args.put("currentMenuPid", currentMenuPid);
		List<Map> list = basDAOFacade.select(sql, args);
		for (int i = 0, len = list.size(); i < len; i ++){
			
			Map o = list.get(i);
			//
			if (o.get("trans_code") != null && !o.get("trans_code").toString().equals("")){
				
			}
			
			
			//
				
			TreeDTO node = new TreeDTO();
			
			node.setId(o.get("id").toString());
			node.setText(o.get("menu_name").toString());
			node.setAttributes(o);	
			List<TreeDTO> children = new ArrayList<TreeDTO>();
			this.generalChildren(o.get("id").toString(), pidList.toString(), children);
			node.setChildren(children);
			resultMenuList.add(node);
		}
		
		transCodeList.clear();
		transCodeList=null;
		pidList = null;
	}
	
	private void generalChildren(String pid, String pidList, List<TreeDTO> children ){
		
		String sql = "select * from ums_menu t where t.pid=:pid order by t.row_order";
		Map args = new HashMap<String, Object>(1);
		args.put("pid", pid);
		List<Map> list = basDAOFacade.select(sql, args);
		for (int i = 0, len = list.size(); i < len; i++){
			if (pidList.indexOf(list.get(i).get("id").toString()) > -1){
				Map o = list.get(i);
				if(o.get("menu_level").toString().equals("4")){
					
				}
				TreeDTO node = new TreeDTO();
				node.setId(o.get("id").toString());
				node.setText(o.get("menu_name").toString());
				node.setState("closed");//节点不自动展开
				node.setAttributes(o);	
				List<TreeDTO> c = new ArrayList<TreeDTO>();
				this.generalChildren(o.get("id").toString(), pidList, c);
				node.setChildren(c);
				children.add(node);
			}
		}
	}
	
	private void generalPid(int fromMenuLevel,Map menuMap, StringBuffer pidList){
		
		try {
			String pid = menuMap.get("pid").toString();
			String sql = "select * from ums_menu t where t.id = :pid";
			Map<String, Object> args = new HashMap<String, Object>(1);
			args.put("pid", pid);
			
			String level = menuMap.get("menu_level").toString();
			Integer currentLevel = new Integer(level);
			pidList.append(pid).append(",");
			boolean flag =  currentLevel >  fromMenuLevel;
			if (fromMenuLevel == 3){//3级可能有分成多个文件夹包
				 flag =  currentLevel >=  fromMenuLevel;
			}
			if ( flag ){
				List<Map> transCodeList = basDAOFacade.select(sql, args);
				if (transCodeList !=null){
					for (int i =0, len = transCodeList.size(); i < len; i++){
						generalPid(fromMenuLevel, transCodeList.get(i), pidList);
					}
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void autoGroupChildren(Map item,Map childrenMap){
		
		String pid = item.get("pid").toString();
		List l = (List) childrenMap.get(pid);
		if (l == null){
			l = new ArrayList();
		}
		l.add(item);
	}

	@Override
	public List<Map> getProjMenu() {

		String sql = "select * from ums_menu t where t.menu_level = '1' order by t.row_order";
		Map<String, Object> args = new HashMap<String, Object>();
		List<Map> transCodeList = basDAOFacade.select(sql, args);
		return transCodeList;
	}

	@Override
	public List<Map> getSecondLevelMenu(String prijMenuId) {
		
		String sql = "select * from ums_menu t where t.pid =:pid order by t.row_order";
		Map<String, Object> args = new HashMap<String, Object>(1);
		args.put("pid", prijMenuId);
		List<Map> transCodeList = basDAOFacade.select(sql, args);
		return transCodeList;
	}

	@Override
	public UmsMenu addEntity(UmsMenu entity) {
		//验证名称是否存在
		UmsMenu qryEntity = new UmsMenu();
		qryEntity.setMenuName(entity.getMenuName());
		List list = basDAOFacade.select(qryEntity);
		if (list != null && list.size() > 0){
			//TODO I18N
			throw new BizException("warning.ums.01005", new Object[]{});
		}
		
		qryEntity = new UmsMenu();
		qryEntity.setId(entity.getId());
		list = basDAOFacade.select(qryEntity);
		if (list != null && list.size() > 0){
			//TODO I18N
			throw new BizException("菜单码已存在，请假用别的菜单码.");
		}
		
		this.basDAOFacade.insert(entity);
		return entity;
	}

	@Override
	public UmsMenu modifyEntity(UmsMenu entity) {
		//验证名称是否存在
		UmsMenu qryEntity = new UmsMenu();
		qryEntity.setMenuName(entity.getMenuName());
		List<UmsMenu> list = basDAOFacade.select(qryEntity);
		if (list != null && list.size() != 0){
			if ( list.size() > 1){
				//todo
				throw new BizException("warning.ums.01005", new Object[]{});
			} else {
				if (!list.get(0).getId().equals(entity.getId())){
					//TODO
					throw new BizException("warning.ums.01005", new Object[]{});
				}
			}
		}
	
		return (UmsMenu) basDAOFacade.update(entity);
	}

	@Override
	public UmsMenu removeEntity(UmsMenu entity) {
		//验证是否含有下级组织机构码
		UmsMenu qryEntity = new UmsMenu();
		qryEntity.setPid(entity.getId());
		List<UmsMenu> list = basDAOFacade.select(qryEntity);
		if(list != null && list.size() > 0){
			//TODO
			throw new BizException("warning.ums.01001", new Object[]{});
		}
		return (UmsMenu) basDAOFacade.delete(entity);
	}

	@Override
	public List<Map> getLoginUserMenu(String productMenuCode, String userId) {

		String sql = "select * from ums_menu t where t.pid =:pid order by t.row_order";
		Map<String, Object> args = new HashMap<String, Object>(1);
		args.put("pid", productMenuCode);
		List<Map> accMenuList = basDAOFacade.select(sql, args);//acc
		
		sql = "select p.trans_code transCode from ums_privilege p  where p.role_id in  (select u.role_id from ums_user_role u where u.user_id=:userId)";
		args = new HashMap<String, Object>(1);
		args.put("userId", userId);
		List<Map> transCodeList = basDAOFacade.select(sql, args);
		StringBuffer sb = new StringBuffer();
		for (int i = 0, len = transCodeList.size(); i <len; i++){
			sb.append(transCodeList.get(i).get("transCode")).append(",");
		}
		
		String transCodes = sb.toString();
		List<Map> resultList = new ArrayList<Map>();
		for (int i = 0, len = accMenuList.size(); i <len; i++){
			List<TreeDTO> subMenuList = new ArrayList<TreeDTO>();
			generalSubMenuList(subMenuList, accMenuList.get(i).get("id").toString(), transCodes);
			if (subMenuList.size() == 0){//如果子菜单为空时不显示
				accMenuList.remove(i);
				len -= 1;
				i -=1;
				continue;
			}
			Map m = new HashMap(2);
			m.put("item", accMenuList.get(i));
			m.put("itemSubTree", subMenuList);
			resultList.add(m);
		}
		return resultList;
	}
	
	private void generalSubMenuList(List<TreeDTO> subMenuList,String pid, String transCodes){
		
		String sql = "select * from ums_menu t where t.pid =:pid order by t.row_order";
		Map<String, Object> args = new HashMap<String, Object>(1);
		args.put("pid", pid);
		List<Map> menuList = basDAOFacade.select(sql, args);
		if (menuList != null && menuList.size() > 0){
			Object temp ;
			for (int i = 0, len = menuList.size(); i <len; i++){
				
				Map o = menuList.get(i);
				/*List<TreeDTO> subMenuList2 = new ArrayList<TreeDTO>();
				generalSubMenuList(subMenuList2, o.get("id").toString(), transCodes);
				if (subMenuList.size() == 0){//如果子菜单为空时不显示
					subMenuList.remove(i);
					len -= 1;
					i -=1;
					continue;
				}*/
				
				if (o.get("menu_level").toString().equals("4")){
					temp = o.get("trans_code");
					if (temp != null){
						if (transCodes.indexOf(temp.toString()) < 0){
							continue;
						}
					}
				}
				
				TreeDTO node = new TreeDTO();
				
				node.setId(o.get("id").toString());
				node.setText(o.get("menu_name").toString());
				node.setAttributes(o);	
				List<TreeDTO> children = new ArrayList<TreeDTO>();
				this.generalSubMenuList(children, o.get("id").toString(),transCodes);
				if (children.size() == 0 && !o.get("menu_level").toString().equals("4")){//如果子菜单为空且不是功能页（即叶子结点）时，不显示
					menuList.remove(i);
					len -= 1;
					i -=1;
					continue;
				}
				node.setChildren(children);
				subMenuList.add(node);
			}
		}
	}

}
