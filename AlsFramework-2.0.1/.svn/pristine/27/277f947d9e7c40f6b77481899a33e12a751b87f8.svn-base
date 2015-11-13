package com.als.frm.module.frm.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.als.frm.module.frm.dao.FrmBasConstantMappper;
import com.als.frm.module.frm.dao.FrmBasConstantDAO;

@Repository("frmBasConstantDAOImpl")
public class FrmBasConstantDAOImpl implements FrmBasConstantDAO {

	//@Autowired
	//private BasDAOFacade<FrmBasConstant> basDAOFacade;
	
	@Autowired
	private FrmBasConstantMappper frmBasConstantMappper;
	@SuppressWarnings("unchecked")
	@Override
	public List<Map> getCodeList() {
		
		return frmBasConstantMappper.lookupBasConstantCodeList(null);
	}

}
