package com.als.ums.module.ums.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.als.frm.bas.dao.BasDAOFacade;
import com.als.frm.ex.BizException;
import com.als.mod.domain.UmsRole;
import com.als.ums.module.ums.biz.UmsRoleBIZ;

@Service("umsRoleBIZImpl")
public class UmsRoleBIZImpl implements UmsRoleBIZ {

	@Autowired
	private BasDAOFacade basDAOFacade;

	@Override
	public UmsRole addEntity(UmsRole entity) {

		UmsRole qryEntity = new UmsRole();
		String roleName = entity.getRoleName().trim();
		String entitySid = entity.getEntitySid();
		qryEntity.setRoleName(roleName);
		qryEntity.setEntitySid(entitySid);
		List list = basDAOFacade.select(qryEntity);
		if (list != null && list.size() != 0){
			throw new BizException("warning.ums.01007", new Object[]{roleName});
		}
		
		entity.setRoleName(roleName);
		entity.setRoleType("0");//这个默认为0，暂时未使用到该字段
		basDAOFacade.insert(entity);
		
		return entity;
	}

	@Override
	public UmsRole modifyEntity(UmsRole entity) {
		
		UmsRole qryEntity = new UmsRole();
		String roleName = entity.getRoleName().trim();
		String entitySid = entity.getEntitySid();
		qryEntity.setRoleName(roleName);
		qryEntity.setEntitySid(entitySid);
		List<UmsRole> list = basDAOFacade.select(qryEntity);
		if (list != null && list.size() != 0 && !entity.getId().equals(list.get(0).getId())){
			throw new BizException("warning.ums.01007", new Object[]{roleName});
		}
		
		basDAOFacade.update(entity);
		return entity;
	}

	@Override
	public UmsRole removeEntity(UmsRole entity) {

		basDAOFacade.delete(entity);
		return entity;
	}

	private static final String SQL_ENTITY_ROLE="select t.id id, t.role_name roleName from ums_role t where t.entity_sid='00000' or t.entity_sid=:entitySid";
	@Override
	public List<Map<String, Object>> getRoleList(String entitySid) {

		Map args = new HashMap<String, String>(1);
		args.put("entitySid", entitySid);
		List<Map<String, Object>> list =  basDAOFacade.select(SQL_ENTITY_ROLE, args);
		return list;
	}

	
}
