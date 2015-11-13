package com.als.prj.abc.module.abcuser.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.als.frm.bas.dao.BasDAOFacade;
import com.als.frm.bas.dao.Operator;
import com.als.frm.bas.dao.mybt.MybatisBasDAOSupport;
import com.als.frm.comm.dto.AppData;
import com.als.frm.comm.dto.Pagination;
import com.als.mod.domain.AbcUser;
import com.als.prj.abc.module.abcuser.dao.AbcUserDAO;

@Service("abcUserBIZImpl")
public class AbcUserBIZImpl implements AbcUserBIZ{

	//@Autowired
	//private AbcUserDAO abcUserDAOImpl;
	@Autowired
	private BasDAOFacade<AbcUser> basDAOFacade;


	//@Autowired 
	//private MybatisBasDAOSupport myBatisBasDAOSupport;
	
	@Override
	public AbcUser getAbcUser(String id) {
		//AbcUser u = new AbcUser();
		//u.setId(id);
		//return basDAOFacade.s;
		return null;
	}

	@Override
	public List<AbcUser> getAllAbcUsers() {

		AbcUser a = new AbcUser();
		//a.setId("good");
		//Map<String, Operator> opMap = new HashMap();
		//opMap.put("id", Operator.lk);
		
		//a.setId("bb");
		//Map<String, Operator> opMap = new HashMap<String, Operator>();
		//opMap.put("id", Operator.gt);
		//a.setUserName("aabbcc");
		//a.setId("cc");
		List l = new ArrayList();
		try {
			//l = abcUserDAOImpl.select(a);
			//l = basDAOFacade.selectByJdbc(a);
			//AbcUser rr = abstractService.selectByPrimaryKey("bb@wx");
			//AbcUser b = new AbcUser();
			//b.setId("good 44s");
			//b.setEntityId("mm");
			//myBatisBasDAOSupport.insert(b);
			Pagination<AbcUser> pagination = new Pagination<AbcUser>();
			pagination.setPageNo(1);
			pagination.setPageSize(6);
			pagination = basDAOFacade.selectPageByMybatis(a, null, null, pagination);
			l = pagination.getDataList();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public AbcUser addAbcUser(AbcUser abcUser) {
		
		return null;// abcUserDAOImpl.insert(abcUser);
	}

	@Override
	public AbcUser modAbcUser(AbcUser abcUser) {

		return null;// abcUserDAOImpl.update(abcUser);
	}

	@Override
	public Pagination<AbcUser> getPageUsers(AppData appData) {

		AbcUser a = new AbcUser();
		Map<String,Operator> opMap = new HashMap();
		if (appData.getValue("id") != null){
			a.setId("%" + appData.getValue("id").toString() + "%");
			opMap.put("id", Operator.lk);
		}
		List<Object[]> orderList = new ArrayList();
		if (appData.getOrderField() != null){
			orderList.add(new Object[]{appData.getOrderField(), appData.getOrderType()});
		}
		Pagination<AbcUser> page = new Pagination<AbcUser>();
		page.setPageNo(appData.getPageNo());
		page.setPageSize(appData.getPageSize());
		page = this.basDAOFacade.selectPageByJdbc(a, opMap, orderList, page);
		return page;
	}

}
