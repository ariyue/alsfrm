package com.als.prj.abc.module.user.dao;

import org.springframework.stereotype.Repository;

import com.als.mod.domain.UmsUserInfo;

/**
 * 用户信息数据接口
 * 
 */

//@Repository(value = "tUmUserMapper")
@Repository
public interface UmsUserInfoDAO {

	void addUserInfo(UmsUserInfo user);


}