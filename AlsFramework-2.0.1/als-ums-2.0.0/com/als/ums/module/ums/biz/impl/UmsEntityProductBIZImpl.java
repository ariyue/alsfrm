package com.als.ums.module.ums.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.als.frm.bas.dao.BasDAOFacade;
import com.als.frm.comm.util.DateTimeUtil;
import com.als.frm.comm.util.UuidUtil;
import com.als.mod.domain.UmsEntityProduct;
import com.als.ums.module.ums.biz.UmsEntityProductBIZ;

@Service("umsEntityProductBIZImpl")
public class UmsEntityProductBIZImpl implements UmsEntityProductBIZ {

	@Autowired
	private BasDAOFacade basDAOFacade;

	private static final String SQL_OPEN_PRODUCT = "select id id, entity_sid entitySid, product_id productId, product_name productName, valid_start_date validStartDate, valid_end_date validEndDate, valid_date_type validDateType, create_real_name createRealName, create_user_name createUserName, create_date createDate, create_time createTime, last_modify_real_name lastModifyRealName, last_modify_user_name lastModifyUserName, last_modify_date lastModifyDate, last_modify_time lastModifyTime, last_approve_opiton lastApproveOpiton, max_user_count maxUserCount  from ums_entity_product where entity_sid= :entitySid";

	private static final String SQL_UNOPEN_PRODUCT = "select id id, product_name productName, menu_id menuId, price price, remark remark, trans_code transCode, create_real_name createRealName, create_user_name createUserName, create_date createDate, create_time createTime, last_modify_real_name lastModifyRealName, last_modify_user_name lastModifyUserName, last_modify_date lastModifyDate, last_modify_time lastModifyTime, last_approve_option lastApproveOption, project_date projectDate, develop_date developDate, online_date onlineDate from ums_product t where t.id not in (select product_id from ums_entity_product p where p.entity_sid=:entitySid);";

	@Override
	public List<Map<String, Object>> getOpendProducts(String entitySid) {
		// TODO Auto-generated method stub
		Map args = new HashMap(1);
		args.put("entitySid", entitySid);
		List<Map<String, Object>> list = basDAOFacade.select(SQL_OPEN_PRODUCT,
				args);
		return list;
	}

	@Override
	public List<Map<String, Object>> getUnOpendProducts(String entitySid) {
		// TODO Auto-generated method stub
		Map args = new HashMap(1);
		args.put("entitySid", entitySid);
		List<Map<String, Object>> list = basDAOFacade.select(
				SQL_UNOPEN_PRODUCT, args);
		return list;
	}

	@Override
	public UmsEntityProduct addEntity(UmsEntityProduct entity) {

		entity.setId(UuidUtil.create());
		basDAOFacade.insert(entity);
		return entity;
	}

	@Override
	public UmsEntityProduct removeEntity(UmsEntityProduct entity) {

		basDAOFacade.delete(entity);
		return entity;
	}

	@Override
	public UmsEntityProduct updateEntity(UmsEntityProduct entity) {

		basDAOFacade.update(entity);
		return entity;
	}
	
	private static final String SQL_ENABLE_PRODUCT = "select t.product_id id,t.product_name productName from ums_entity_product t where t.entity_sid= :entitySid and t.valid_start_date <= :currentDate and t.valid_end_date >= :currentDate";

	@Override
	public List<Map<String, Object>> getEnableProducts(String entitySid) {
		
		Map args = new HashMap(2);
		args.put("entitySid", entitySid);
		String currentDate = DateTimeUtil.getCurrentDate();
		args.put("currentDate", currentDate);
		List<Map<String, Object>> list = basDAOFacade.select(SQL_ENABLE_PRODUCT,
				args);
		return list;
	}

}
