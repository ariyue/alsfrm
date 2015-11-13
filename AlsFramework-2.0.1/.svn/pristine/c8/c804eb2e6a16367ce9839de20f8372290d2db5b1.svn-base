package com.als.prj.abc.module.abcuser.act;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.als.frm.bas.dao.Operator;
import com.als.frm.comm.dto.AppData;
import com.als.frm.comm.dto.Pagination;
import com.als.frm.comm.util.MailSendHelper;
import com.als.frm.integration.FrmBasITG;
import com.als.mod.domain.AbcUser;
import com.als.prj.abc.module.abcuser.biz.AbcUserBIZ;
import com.als.web.action.BasAction;
import com.als.web.action.IAction;
import com.als.web.action.type.Action;
import com.als.web.action.type.ActionMetod;
import com.als.web.action.type.SpringBean;

@Action("abcUser")
public class AbcUserAction  extends BasAction implements IAction{

	@SpringBean
	private AbcUserBIZ abcUserBIZImpl;
	
	@SpringBean
	private FrmBasITG frmBasITG; 

	@Override
	public String getTransCode() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@ActionMetod("queryAllList")
	public Object queryAllList(AppData appData){
		
		//abcUserBIZImpl = (AbcUserBIZ) this.getBean("abcUserBIZImpl");
		System.out.println("innn");
		List list = abcUserBIZImpl.getAllAbcUsers();
		this.showMsg("操作成功！");
		return list;
	}
	
	@ActionMetod("queryPageList")
	public Object queryPageList(AppData appData){
		
		//List list = frmBasITG.getConstantList("MIS_LEAVE_TYPE", "00000");
		//String transNo = frmBasITG.getNewSerialId("MIS", "00001");
		//System.out.println("innn");
		//TEST 测试发送邮件
		String content = "<html><head></head><body><h1>Hello! AlsFramework!"           
			+ "</h1></body></html>";
		MailSendHelper.sendSystemMail("76926980@qq.com", "AlsTest", content, null);
		
		
		
		
		Pagination<AbcUser> page = abcUserBIZImpl.getPageUsers(appData);
		this.showMsg("操作成功！");
		return page;
	}

	@Override
	public Object init(AppData appData) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@ActionMetod("lookupPageList")
	public Object lookupPageList(AppData appData){
		
		AbcUser entity = new AbcUser();
		Map<String,Operator> opMap = new HashMap();
		if (appData.getValue("id") != null){
			entity.setId("%" + appData.getValue("id").toString() + "%");
			opMap.put("id", Operator.lk);
		}
		List<Object[]> orderList = new ArrayList();
		if (appData.getOrderField() != null){
			orderList.add(new Object[]{appData.getOrderField(), appData.getOrderType()});
		}
		Pagination<AbcUser> pagination = new Pagination<AbcUser>();
		pagination.setPageNo(appData.getPageNo());
		pagination.setPageSize(appData.getPageSize());
		pagination = this.getLookupProvider().lookupPage(entity, opMap, orderList, pagination);
		return pagination;
	}
	
	@ActionMetod("testGetTransNo")
	public Object testGetTransNo(AppData appData) {

		return frmBasITG.getNewSerialId("ABB", "00007");
	}

}
