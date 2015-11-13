package com.als.frm.module.frm.act;

import com.als.frm.comm.dto.AppData;
import com.als.frm.comm.dto.Pagination;
import com.als.frm.module.frm.biz.FrmBasSerialBIZ;
import com.als.web.action.BasAction;
import com.als.web.action.IAction;
import com.als.web.action.type.Action;
import com.als.web.action.type.ActionMetod;
import com.als.web.action.type.SpringBean;

@Action("frmBasSerial")
public class FrmBasSerialAction extends BasAction implements IAction {

	@SpringBean
	private FrmBasSerialBIZ frmBasSerialBIZImpl;
	
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
	
	
	@ActionMetod("getSerialList")
	public Object getSerialList(AppData appData) {
		
		Pagination page = this.frmBasSerialBIZImpl.getSerialList(appData);
		return page;
	}
	
	@ActionMetod("getSerialItemList")
	public Object getSerialItemList(AppData appData) {
		
		Pagination page = this.frmBasSerialBIZImpl.getSerialItemList(appData);
		return page;
	}
	

	@ActionMetod("saveSerial")
	public Object saveSerial(AppData appData) {
		
		Pagination page = this.frmBasSerialBIZImpl.saveSerial(appData);
		return page;
	}
	
	@ActionMetod("removeSerial")
	public Object removeSerial(AppData appData) {
		
		Pagination page = this.frmBasSerialBIZImpl.removeSerial(appData);
		return page;
	}
	
	
	@ActionMetod("updateMaxValue")
	public Object updateMaxValue(AppData appData) {
		
		this.frmBasSerialBIZImpl.updateItemMaxValue(appData);
		return null;
	}

}
