package com.als.ums.module.ums.biz;

import java.util.List;
import java.util.Map;

import com.als.frm.comm.dto.AppData;
import com.als.frm.comm.dto.TreeDTO;
import com.als.frm.ex.BizException;
import com.als.mod.domain.UmsEntity;

public interface UmsEntityBIZ {

	/**
	 * 执行企业注册
	 * @param appData
	 * @return
	 * @throws BizException
	 */
	public List<TreeDTO> execRegist(AppData appData) throws BizException;
	
	UmsEntity addEntity(UmsEntity entity);
	
	UmsEntity modifyEntity(UmsEntity entity);
	
	Map getEntityMap();
	
}
