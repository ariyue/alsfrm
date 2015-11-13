package com.als.eml.module.eml.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.als.eml.module.eml.biz.EmlEmailBIZ;
import com.als.eml.module.eml.dao.EmlEmailDAO;
import com.als.frm.bas.dao.BasDAOFacade;

@Service("emlMailBIZImpl")
public class EmlEmailBIZImpl implements EmlEmailBIZ{

	@Autowired
	private BasDAOFacade basDAOFacade;
	
	@Autowired
	private EmlEmailDAO emlEmailDAOImpl;
}
