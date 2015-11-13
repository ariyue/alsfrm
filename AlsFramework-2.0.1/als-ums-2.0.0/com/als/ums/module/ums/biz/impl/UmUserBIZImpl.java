package com.als.ums.module.ums.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.als.frm.bas.dao.BasDAOFacade;
import com.als.frm.comm.util.Md5Util;
import com.als.frm.comm.util.UuidUtil;
import com.als.frm.ex.BizException;
import com.als.mod.domain.UmsUser;
import com.als.mod.domain.UmsUserRole;
import com.als.ums.module.ums.biz.UmsUserBIZ;

@Service("umUserBIZImpl")
public class UmUserBIZImpl implements UmsUserBIZ{

	@Autowired
	private BasDAOFacade<UmsUser> basDAOFacade;
	
	@Override
	public UmsUser addEntity(UmsUser entity) {

		UmsUser qryEntity = new UmsUser();
		String userName = entity.getUserName();
		String entitySid = entity.getEntitySid();
		qryEntity.setUserName(userName);
		qryEntity.setEntitySid(entitySid);
		
		List<UmsUser> list = basDAOFacade.select(qryEntity);
		if (list != null && list.size() > 0){
			throw new BizException("warning.ums.01006", new Object[]{userName});
		}
		//初始化
		entity.setId(userName + "@" + entitySid);
		entity.setPassword(Md5Util.getMD5Str("Aa123456"));
		entity.setUserLanguage("01");
		return basDAOFacade.insert(entity);
	}

	@Override
	public UmsUser modifyEntity(UmsUser entity) {
		
		String oldUserName = entity.getId().split("@")[0];
		String userName = entity.getUserName().trim();
		String entitySid = entity.getEntitySid();
		if (!oldUserName.equals(userName)){//userName有变化
			UmsUser qryEntity = new UmsUser();
			
			
			qryEntity.setUserName(userName);
			qryEntity.setEntitySid(entitySid);
			
			List<UmsUser> list = basDAOFacade.select(qryEntity);
			if (list != null && list.size() > 0){
				throw new BizException("warning.ums.01006", new Object[]{userName});
			}
		}
		entity.setId(userName + "@" + entitySid);
		return basDAOFacade.update(entity);
	}

	@Override
	public UmsUser removeEntity(UmsUser entity) {
		
		return basDAOFacade.delete(entity);
	}

	private static final String SQL_USER_ROLE = "select role_id roleId from  ums_user_role t where t.user_id= :userId";
	@Override
	public List<Map<String, Object>> getUserRoles(String id) {
		
		Map args = new HashMap(1);
		args.put("userId", id);
		List list = basDAOFacade.select(SQL_USER_ROLE, args);
		return list;
	}
	
	private static final String SQL_USER_UNIT = "select t.unit_id unitId,u.unit_name unitName from  ums_user t, ums_unit u where t.id= :id and t.unit_id= u.id";


	@Override
	public Object[] getUserUnit(String id) {
		
		Map args = new HashMap(1);
		args.put("id", id);
		List<Map<String, Object>> list = basDAOFacade.select(SQL_USER_UNIT, args);
		Object[] result = new String[2];
		if (list != null && list.size() > 0){
			result[0] = list.get(0).get("unitId");
			result[1] = list.get(0).get("unitName");
		}
		return result;
	}

	private static final String SQL_REMOVE_ROLE = "delete from ums_user_role   where user_id= :userId";
	
	private static final String SQL_ADD_ROLE = "insert into ums_user_role ( id, user_id, role_id, create_real_name, create_user_name, create_date, 	create_time, 	last_modify_real_name, 	last_modify_user_name, 	last_modify_date, 	last_modify_time, 	last_approve_option	)values (:id,:userId,:roleId,:createRealName,:createUserName,:createDate,:createTime,:lastModifyRealName,:lastModifyUserName,:lastModifyDate,:lastModifyTime,:lastApproveOption )";

	@Override
	public void updateUserRoles(String id,
			List<UmsUserRole> roleList) {

		//删除原来所有
		Map args = new HashMap(1);
		args.put("userId", id);
		basDAOFacade.update(SQL_REMOVE_ROLE, args);
		
		//添加新的
		for (int i=0, len = roleList.size(); i< len; i ++){
			UmsUserRole r = roleList.get(i);
			r.setId(UuidUtil.create());
		}
		basDAOFacade.batchUpdate(SQL_ADD_ROLE, roleList);
	}

	private static final String SQL_UPDATE_UNIT_PRDS = "update ums_user t set t.unit_id= :unitId, t.um_products = :products where t.id= :id";
	@Override
	public void updateUserUnitAndProduct(String id,
			String unitId, String products) {

		Map args = new HashMap(1);
		args.put("id", id);
		args.put("products", products);
		args.put("unitId", unitId);
		basDAOFacade.update(SQL_UPDATE_UNIT_PRDS, args);
		
	}

}
