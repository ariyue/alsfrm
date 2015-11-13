package com.als.ums.module.ums.biz.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.als.frm.comm.dto.AppData;
import com.als.frm.comm.dto.TreeDTO;
import com.als.frm.ex.AppException;
import com.als.frm.ex.BizException;
import com.als.frm.module.frm.biz.TreeBIZ;
import com.als.mod.domain.UmsEntity;
import com.als.ums.module.ums.biz.UmsEntityBIZ;
import com.als.ums.module.ums.biz.UmsMenuBIZ;
import com.als.ums.module.ums.biz.UmsUnitBIZ;
import com.als.ums.module.ums.dao.UmsEntityDAO;

@Service("umsEntityBIZImpl")
public class UmsEntityBIZImpl implements UmsEntityBIZ {

	@Autowired
	private TreeBIZ treeBIZImpl;
	
	@Autowired
	private UmsMenuBIZ umsMenuBIZImpl;
	
	@Autowired
	private UmsEntityDAO umsEntityDAOImpl;
	
	@Autowired
	private UmsUnitBIZ umsUnitBIZImpl;
	
	@Override
	public List<TreeDTO> execRegist(AppData appData) throws BizException {
		// TODO Auto-generated method stub
		System.out.println("regist.........................");
		List<TreeDTO> resultList = new ArrayList<TreeDTO>();
		//treeBIZImpl.loadTree("ums_menu", "pid", "0", "row_order", "id", "menu_name" , resultList);
		//UmsMenuBIZImpl.getUserMenuTree("9901@wx", 3, "IOAMIS", resultList);
		umsMenuBIZImpl.getUserMenuTree("9901@wx", 1, "0", resultList);
		return resultList;
	}

	@Override
	public UmsEntity addEntity(UmsEntity entity) {
		// 判断ID是否已使用
		// 判断企业名称是否已使用
		// 判断企业简称是否已使用
		
		// 生成sid
		String entitySid = "";
		Boolean lockFlag = new Boolean(false);//解锁
		if (!lockFlag.booleanValue()) {
			synchronized (lockFlag) {
				if (!lockFlag.booleanValue()) {
					try {
						lockFlag = new Boolean(true);// 加锁
						entitySid = umsEntityDAOImpl.getNextEntitySid();
					} catch (Exception e) {
						throw new AppException("err.ums.01005", new Object[]{});
					} finally {
						lockFlag = new Boolean(false);// 解锁
					}
				}
			}
		}
		if (entitySid.equals("")){
			throw new AppException("err.ums.01005", new Object[]{});
		}
		entity.setEntitySid(entitySid);
		entity.setDeleteFlag("n");
		//保存企业
		umsEntityDAOImpl.insertEntity(entity);
		//初始化顶级组织机构
		umsUnitBIZImpl.addTopUnit(entity);
		return entity;
	}

	@Override
	public UmsEntity modifyEntity(UmsEntity entity) {
		
		// 判断ID不是本ID时
		// 判断企业名称是否已使用
		// 判断企业简称是否已使用
		return umsEntityDAOImpl.updateEntity(entity);
	}

	@Override
	public Map getEntityMap() {

		Map<String, String> entityMap = new HashMap<String, String>();
		List<UmsEntity> list = umsEntityDAOImpl.selectAll();
		if (list != null){
			for (int i =0, len =  list.size(); i < len; i++){
				entityMap.put(list.get(i).getEntitySid(), list.get(i).getEntityName());
			}
		}
		return entityMap;
		
	}

}
