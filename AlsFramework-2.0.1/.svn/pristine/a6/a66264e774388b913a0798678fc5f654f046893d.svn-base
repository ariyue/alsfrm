package com.als.ums.module.ums.biz.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.als.frm.bas.dao.BasDAOFacade;
import com.als.frm.comm.util.UuidUtil;
import com.als.mod.domain.UmsPrivilege;
import com.als.ums.module.ums.biz.UmsPrivilegeBIZ;

@Service("umsPrivilegeBIZImpl")
public class UmsPrivilegeBIZImpl implements UmsPrivilegeBIZ{

	@Autowired
	private BasDAOFacade basDAOFacade;
	
	private static final String SQL_INSERT_PRIVILEGE = "insert into ums_privilege(id,role_id,trans_code,remark,create_real_name,create_user_name,create_date,create_time,last_modify_real_name,last_modify_user_name,last_modify_date,last_modify_time,last_approve_opiton)values(:id,:roleId,:transCode,:remark,:createRealName,:createUserName,:createDate,:createTime,:lastModifyRealName,:lastModifyUserName,:lastModifyDate,:lastModifyTime,:lastApproveOpiton)";
	@Override
	public void saveList(String roleId, String transCodes) {
		// TODO Auto-generated method stub
		
		
		String[] ts = transCodes.split(",");
		List<UmsPrivilege> list = new ArrayList<UmsPrivilege>();
		for (int i = 0, len = ts.length; i < len; i++){
			UmsPrivilege o = new UmsPrivilege();
			o.setId(UuidUtil.create());
			o.setRoleId(roleId);
			o.setTransCode(ts[i]);
			list.add(o);
		}
		this.removeList(roleId);
		basDAOFacade.batchUpdate(SQL_INSERT_PRIVILEGE, list);
		
	}
	@Override
	public void removeList(String roleId) {

		UmsPrivilege entity = new UmsPrivilege();
		entity.setRoleId(roleId);
		basDAOFacade.delete(entity);
	}

}
