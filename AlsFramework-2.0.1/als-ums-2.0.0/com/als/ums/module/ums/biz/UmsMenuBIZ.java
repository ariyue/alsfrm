package com.als.ums.module.ums.biz;

import java.util.List;
import java.util.Map;

import com.als.frm.comm.dto.TreeDTO;
import com.als.mod.domain.UmsMenu;

public interface UmsMenuBIZ {

	/**
	 * 获取项目菜单，显示在mainPage的右上方的项目图标列表
	 * @return
	 */
	public List<Map> getProjMenu();
	
	
	/**
	 * 获取二级菜单，在点一级菜单后，在左侧
	 * @return
	 */
	public List<Map> getSecondLevelMenu(String prijMenuId);
	
	/**
	 * 获取用户菜单树
	 * @param userId 用户ID 
	 * @param fromMenuLevel 开始菜单级别 如3：表示3级及大于3的4级
	 * @param currentMenuPid 当前级别的父菜单id
	 * @param resultMenuList 构造成的菜单
	 */
	public void  getUserMenuTree(String userId, int fromMenuLevel, String currentMenuPid, List<TreeDTO> resultMenuList);
	
	
	/**
	 * 
	 * @param entity
	 * @return
	 */
	public UmsMenu addEntity(UmsMenu entity);
	
	/**
	 * 
	 * @param entity
	 * @return
	 */
	public UmsMenu modifyEntity(UmsMenu entity);
	
	public UmsMenu removeEntity(UmsMenu entity);
	
	/**
	 * 获取登陆用户菜单
	 * @param productMenuCode 产品菜单码，按规则为3位大写字母，如IOA
	 * @param userId 用户ID如:coco@00001
	 * @return
	 */
	public List<Map>  getLoginUserMenu(String productMenuCode, String userId);
}
