package com.als.prj.abc.module.user.biz;

import com.als.mod.domain.UmsUser;
import com.als.mod.domain.UmsUser2;
import com.als.mod.domain.UmsUserInfo;

public interface UmsUserBIZ {

	public UmsUser getUserById(String userId);
	
	public void saveUser(UmsUser user);
	
	public void saveUser2(UmsUser2 user);
	
	public void saveUserAndInfo(UmsUser userId,UmsUserInfo info);
	
	
}
