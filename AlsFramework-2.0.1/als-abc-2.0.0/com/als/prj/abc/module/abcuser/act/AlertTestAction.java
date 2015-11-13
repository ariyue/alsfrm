package com.als.prj.abc.module.abcuser.act;

import com.als.frm.bas.ddl.RstMsgType;
import com.als.frm.comm.dto.AppData;
import com.als.frm.comm.dto.RstMsg;
import com.als.web.action.BasAction;
import com.als.web.action.IAction;
import com.als.web.action.type.Action;
import com.als.web.action.type.ActionMetod;


@Action("alertTest")
public class AlertTestAction extends BasAction implements IAction {

	@Override
	public String getTransCode() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@ActionMetod("showInfo")
	public Object showInfo(AppData data){
		
		RstMsg rstMsg = new RstMsg();
		rstMsg.setMsgType(RstMsgType.info);
		rstMsg.setMsgCode("msg.sys.00001");
		return rstMsg;
	}
	
	@ActionMetod("showWarning")
	public Object showWarning(AppData data){
		
		RstMsg rstMsg = new RstMsg();
		rstMsg.setMsgType(RstMsgType.warning);
		rstMsg.setMsgCode("msg.sys.00001");
		return rstMsg;
	}
	
	@ActionMetod("showError")
	public Object showError(AppData data){
		
		RstMsg rstMsg = new RstMsg();
		rstMsg.setMsgType(RstMsgType.error);
		rstMsg.setMsgCode("msg.sys.00001");
		return rstMsg;
	}

	@ActionMetod("showQuestion")
	public Object showQuestion(AppData data){
		
		RstMsg rstMsg = new RstMsg();
		rstMsg.setMsgType(RstMsgType.question);
		rstMsg.setMsgCode("msg.sys.00001");
		return rstMsg;
	}

	@Override
	public Object init(AppData appData) {
		// TODO Auto-generated method stub
		return null;
	}

}
