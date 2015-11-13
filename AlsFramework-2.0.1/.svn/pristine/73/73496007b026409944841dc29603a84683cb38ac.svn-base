package com.als.ums.module.ums.act;

import java.util.HashMap;
import java.util.Map;

import com.als.frm.comm.dto.AppData;
import com.als.web.action.BasAction;
import com.als.web.action.IAction;
import com.als.web.action.type.Action;
import com.als.web.action.type.ActionMetod;

@Action("login")
public class LoginAction extends BasAction implements IAction {

	@Override
	public String getTransCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@ActionMetod("init")
	@Override
	public Object init(AppData appData) {

		Map m = new HashMap();
		String appName = this.generalI18nMsg("msg.sys.00002", new Object[]{});
		m.put("appName", appName);
		return m;
	}

}
