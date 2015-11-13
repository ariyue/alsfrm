package com.als.frm.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.als.frm.bas.dao.BasDAOFacade;
import com.als.frm.comm.FrmConstant;
import com.als.frm.comm.util.UuidUtil;
import com.als.frm.module.frm.dao.FrmBasConstantDAO;
import com.als.mod.domain.FrmBasConstant;


@Component("frmBasConstantCache")
public class FrmBasConstantCache implements
		IFrmBasConstantCache {

	@Autowired
	private BasDAOFacade<FrmBasConstant> basDAOFacade;
	
	@Autowired
	private FrmBasConstantDAO frmBasConstantDAOImpl;

	@Override
	public List getConstantList(String code, String entitySid) {

		String key = code + entitySid;
		Element e = frmBasConstantCacheBlock.get(key);
		return (List) e.getValue();
	}

	@Autowired
	private Ehcache frmBasConstantCacheBlock;

	@Override
	@Transactional
	public int updateConstantList(String conName, String entitySid,
			List constantList) {
		
		//更新数据库
		List newList = new ArrayList<FrmBasConstant>();
		List oldList = new ArrayList<FrmBasConstant>();
		
		for (int i = 0,len = constantList.size(); i < len; i++){
			FrmBasConstant item = (FrmBasConstant) constantList.get(i);
			if (item.getId() == null || item.getId().toString().trim().equals("")){
				String id = UuidUtil.create();
				item.setId(id);
				newList.add(item);
			} else {
				oldList.add(item);
			}
		}
		// 新增的常量
		int newCount = this.basDAOFacade.batchUpdate(FrmConstant.SQL_IST_BAS_CONSTANT, newList);
		
		// 更新的记录
		int oldCount = this.basDAOFacade.batchUpdate(FrmConstant.SQL_UDT_BAS_CONSTANT, oldList);
		
		
		//更新缓存
		newList.addAll(oldList);
		String key = conName + entitySid;
		frmBasConstantCacheBlock.remove(key);
		this.cacheConstant(conName, entitySid);
		
		return newCount + oldCount;
		
		

	}

	private static final String SQL_QUERY_LIST = " select id,name,code,item_code itemCode, item_text itemText, row_order rowOrder, entity_sid entitySid,remark from frm_bas_constant t where t.code=:code and t.entity_sid=:entitySid order by t.row_order";


	@Override
	public void initCache(){
		
		//System.out.println("开始缓存常量-----------------------------------");
		List<Map> list = frmBasConstantDAOImpl.getCodeList();
		String code = null;
		String entitySid = null;
		FrmBasConstant t = null;
		Map m = null;
		
		for (int i = 0, len = list.size(); i < len; i++) {
			m = (Map) list.get(i);
			code = (String) m.get("code");
			entitySid = (String) m.get("entitySid");
			t = new FrmBasConstant();
			t.setCode(code);
			//List itemList = this.basDAOFacade.select(t);
			cacheConstant(code, entitySid);

		}
		//System.out.println("结束缓存常量-----------------------------------");

	}

	@Override
	public void cacheConstant(String code, String entitySid) {
		Map<String, Object> args = new HashMap<String, Object>(2);
		args.put("code", code);
		args.put("entitySid", entitySid);
		List itemList = this.basDAOFacade.select(SQL_QUERY_LIST, args);
		if (itemList != null && itemList.size() > 0) {
			String key = code + entitySid;
			Element e = new Element(key, itemList);
			frmBasConstantCacheBlock.put(e);
		}
		
	}

	@Override
	public FrmBasConstant getBlankLineFrmBasConstant() {
		
		FrmBasConstant t = new FrmBasConstant();
		t.setCode("");
		t.setName("");
		return t;
	}

	@Override
	public Map getConstantByCode(String itemCode,
		List<Map> list) {
		
		int len = list.size();
		Map c = null;
		for (int i = 0; i < len; i++){
			c = list.get(i);
			if (c.get("itemCode").equals(itemCode)){
				break;
			}
		}
		return c;
	}

	@Override
	public String getText(String itemCode, List<Map> list) {

		Map c = this.getConstantByCode(itemCode, list);
		if(c !=null){
			return c.get("itemText").toString();
		}
		return "";
	}

}
