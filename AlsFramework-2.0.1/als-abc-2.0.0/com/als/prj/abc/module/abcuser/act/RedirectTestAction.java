package com.als.prj.abc.module.abcuser.act;

import java.util.HashMap;
import java.util.Map;

import com.als.frm.comm.dto.AppData;
import com.als.frm.comm.dto.RstRedirect;
import com.als.frm.comm.dto.RstTab;
import com.als.web.action.BasAction;
import com.als.web.action.IAction;
import com.als.web.action.type.Action;
import com.als.web.action.type.ActionMetod;


@Action("redirectTest")
public class RedirectTestAction extends BasAction implements IAction {

	@Override
	public String getTransCode() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@ActionMetod("test")
	public Object test(AppData data){
		
		
		
		
		RstRedirect redMsg = new RstRedirect();
		Map params = new HashMap();
		params.put("id", "ABC201506050000001");
		params.put("userName", "张三");
		params.put("rd", String.valueOf(Math.random()));
		redMsg.setParams(params);
		redMsg.setPath("ctr/len/view/abc/RedirectTestB.jsp");
		return redMsg;
	}

	@Override
	public Object init(AppData appData) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
