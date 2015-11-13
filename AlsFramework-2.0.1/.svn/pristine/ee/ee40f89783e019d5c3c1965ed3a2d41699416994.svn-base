package com.als.frm.module.frm.act;

import com.als.frm.comm.dto.AppData;
import com.als.frm.comm.dto.Pagination;
import com.als.frm.module.frm.biz.UmsProductBIZ;
import com.als.web.action.BasAction;
import com.als.web.action.IAction;
import com.als.web.action.type.Action;
import com.als.web.action.type.ActionMetod;
import com.als.web.action.type.SpringBean;

@Action("umsproduct")
public class UmsProductAction extends BasAction implements IAction {

	@SpringBean
	private UmsProductBIZ umsProductBIZImpl;
	
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
		
		Pagination page = this.umsProductBIZImpl.getPageList(appData);
		return page;
	}
	

	@ActionMetod("save")
	public Object save(AppData appData) {
		
		Pagination page = this.umsProductBIZImpl.saveEntity(appData);
		return page;
	}
	
	@ActionMetod("remove")
	public Object remove(AppData appData) {
		
		Pagination page = this.umsProductBIZImpl.removeEntity(appData);
		return page;
	}

}
