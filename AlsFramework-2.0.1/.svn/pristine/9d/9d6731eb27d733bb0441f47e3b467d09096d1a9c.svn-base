package com.als.ums.module.ums.biz;

import java.util.List;
import java.util.Map;

import com.als.mod.domain.UmsRole;

public interface UmsRoleBIZ {

	UmsRole addEntity (UmsRole entity);
	UmsRole modifyEntity (UmsRole entity);
	UmsRole removeEntity (UmsRole entity);
	
	
	/**
	 * 获取企业角色列表（自动包含默认角色)
	 * @param entitySid 企业简码
	 * @return
	 */
	List<Map<String, Object>> getRoleList(String entitySid);
}
