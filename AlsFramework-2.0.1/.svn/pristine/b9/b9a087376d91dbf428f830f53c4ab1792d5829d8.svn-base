package com.als.prj.abc.module.user.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.als.mod.domain.UmsUser;
import com.als.mod.domain.UmsUser2;
import com.als.mod.domain.UmsUserInfo;
import com.als.prj.abc.module.user.dao.UmsUserDAO;
import com.als.prj.abc.module.user.dao.UmsUserDAO2;
import com.als.prj.abc.module.user.dao.UmsUserInfoDAO;


@Service
public class UmsUserBIZImpl implements UmsUserBIZ{

	@Autowired
	private UmsUserDAO umsUserDAO; 
	
	@Autowired
	private UmsUserDAO2 umsUserDAO2Impl; 
	
	@Autowired
	private UmsUserInfoDAO umsUserInfoDAO;
	
	@Override
	public UmsUser getUserById(String userId) {

		return umsUserDAO.getUserById(userId);
	}

	@Override
	public void saveUser(UmsUser user) {

		umsUserDAO.addUser(user);
		
	}
	
	@Override
	public void saveUser2(UmsUser2 user){
		
		umsUserDAO2Impl.insert(user);
	}
	

	@Override
	public void saveUserAndInfo(UmsUser user, UmsUserInfo info) {


		umsUserDAO.addUser(user);
		umsUserInfoDAO.addUserInfo(info);
		
	}

}
