package com.als.ums.module.ums.biz;

import java.util.List;
import java.util.Map;

import com.als.mod.domain.UmsUser;
import com.als.mod.domain.UmsUserRole;

public interface UmsUserBIZ {

	/**
	 * 
	 * @param entity
	 * @return
	 */
	public UmsUser addEntity(UmsUser entity);
	
	/**
	 * 
	 * @param entity
	 * @return
	 */
	public UmsUser modifyEntity(UmsUser entity);
	
	public UmsUser removeEntity(UmsUser entity);
	
	/**
	 * 获取用户组织机构ID\名称\开通的系统
	 * @param userName
	 * @param entitySid
	 * @return
	 */
	public Object[] getUserUnit(String id);
	
	
	/**
	 * 获取用户角色列表
	 * @param userName
	 * @param entitySid
	 * @return
	 */
	public List<Map<String, Object>> getUserRoles(String id);
	
	/**
	 * 保存用户组织机构和开通的系统
	 * @param userName
	 * @param entitySid
	 * @param unitId
	 * @param products
	 */
	public void updateUserUnitAndProduct(String id, String unitId, String products);
	
	
	/**
	 * 保存用户角色
	 * @param userName
	 * @param entitySid
	 * @param roleList
	 */
	public void updateUserRoles(String id, List<UmsUserRole> roleList);
	
	
}
