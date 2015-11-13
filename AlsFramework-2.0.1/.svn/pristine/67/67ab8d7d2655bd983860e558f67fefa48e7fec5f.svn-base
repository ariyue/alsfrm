package com.als.frm.module.frm.act;

import com.als.frm.comm.dto.AppData;
import com.als.frm.comm.dto.Pagination;
import com.als.frm.module.frm.biz.FrmBasConstantBIZ;
import com.als.web.action.BasAction;
import com.als.web.action.IAction;
import com.als.web.action.type.Action;
import com.als.web.action.type.ActionMetod;
import com.als.web.action.type.SpringBean;

@Action("frmBasConstant")
public class FrmBasConstantAction extends BasAction implements IAction {

	@SpringBean
	private FrmBasConstantBIZ frmBasConstantBIZImpl;
	
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
		
		Pagination page = this.frmBasConstantBIZImpl.getConstantList(appData);
		return page;
	}
	
	@ActionMetod("getConstantItemList")
	public Object getConstantItemList(AppData appData) {
		
		Pagination page = this.frmBasConstantBIZImpl.getConstantItemList(appData);
		return page;
	}
	

	@ActionMetod("saveConstant")
	public Object saveConstant(AppData appData) {
		
		Pagination page = this.frmBasConstantBIZImpl.saveConstant(appData);
		return page;
	}
	
	@ActionMetod("removeConstant")
	public Object removeConstant(AppData appData) {
		
		Pagination page = this.frmBasConstantBIZImpl.removeConstant(appData);
		return page;
	}

}
