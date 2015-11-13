package com.als.eml.module.eml.dao.impl;

import org.springframework.stereotype.Repository;

import com.als.eml.module.eml.dao.EmlEmailDAO;
import com.als.frm.bas.dao.BasDAOFacade;
import com.als.frm.bas.dao.IBasDAOFacade;
import com.als.mod.domain.EmlEmail;

@Repository("emlEmailDAOImpl")
public class EmlEmailDAOImpl extends BasDAOFacade<EmlEmail> implements IBasDAOFacade<EmlEmail>,EmlEmailDAO{

}
