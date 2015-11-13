package com.als.frm.module.frm.dao;

import com.als.frm.bas.dao.IBasDAOFacade;



public interface FrmBasSerialDAO<T> extends IBasDAOFacade<T>{
	
	
	public void updateCache(String module, String entitySid);
	
}
