package com.als.frm.module.frm.act;

import java.util.List;

import com.als.frm.comm.FrmConstant;
import com.als.frm.comm.dto.AppData;
import com.als.frm.integration.FrmBasITG;
import com.als.web.action.BasAction;
import com.als.web.action.IAction;
import com.als.web.action.type.Action;
import com.als.web.action.type.ActionMetod;
import com.als.web.action.type.SpringBean;

@Action("frmBasAction")
public class FrmBasAction extends BasAction implements IAction {

	@SpringBean
	private FrmBasITG frmBasITG; 
	
	@Override
	public String getTransCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object init(AppData appData) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@ActionMetod("getConstantList")
	public Object getConstantList(AppData appData) {
		
		String entitySid = FrmConstant.FRM_DEFAULT_ENTITY_SID;
		String conName = appData.getValue("conName").toString();//name
		List list = this.frmBasITG.getConstantList(conName, entitySid);
		return list;
	}

}
