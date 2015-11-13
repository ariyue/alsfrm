package com.als.eml.module.eml.act;

import com.als.frm.comm.dto.AppData;
import com.als.web.action.BasAction;
import com.als.web.action.IAction;
import com.als.web.action.type.Action;
import com.als.web.action.type.ActionMetod;

@Action("emlemail")
public class EmlEmailAction extends BasAction implements IAction  {

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
	
	@ActionMetod("lookuppage")
	public Object lookupPage(AppData appData) {

		return super.lookupPage(appData, "com.als.mod.domain.EmlEmail");
	}

}
