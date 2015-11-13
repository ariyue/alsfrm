package com.als.prj.abc.module.abcuser.dao;

import org.springframework.stereotype.Repository;

import com.als.frm.bas.BasDAOImpl;
import com.als.mod.domain.AbcUser;


@Repository("abcUserDAOImpl")
public class AbcUserDAOImpl extends BasDAOImpl<AbcUser> implements AbcUserDAO  {

}
