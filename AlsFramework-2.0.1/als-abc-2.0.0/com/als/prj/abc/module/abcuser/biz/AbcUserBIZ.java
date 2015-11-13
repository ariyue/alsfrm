package com.als.prj.abc.module.abcuser.biz;

import java.util.List;

import com.als.frm.comm.dto.AppData;
import com.als.frm.comm.dto.Pagination;
import com.als.mod.domain.AbcUser;

public interface AbcUserBIZ {

	public AbcUser getAbcUser(String id);
	
	public List<AbcUser> getAllAbcUsers();
	
	public AbcUser addAbcUser(AbcUser abcUser);
	
	public AbcUser modAbcUser(AbcUser abcUser);
	
	public Pagination<AbcUser> getPageUsers(AppData appData);
}
