package com.als.ums.module.ums.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.als.frm.bas.dao.BasDAOFacade;
import com.als.frm.ex.BizException;
import com.als.mod.domain.UmsTransCode;
import com.als.ums.module.ums.biz.UmsTransCodeBIZ;

@Service("umsTransCodeBIZImpl")
public class UmsTransCodeBIZImpl implements UmsTransCodeBIZ {

	@Autowired
	private BasDAOFacade<UmsTransCode> basDAOFacade;

	@Override
	public UmsTransCode addEntity(UmsTransCode entity) {

		//检查组织机构ID或Name是否被占用
		UmsTransCode qryEntity = new UmsTransCode();
		qryEntity.setId(entity.getId());
		List list = basDAOFacade.select(qryEntity);
		if (list != null && list.size() > 0){
			throw new BizException("warning.ums.01008", new Object[]{});
		}
		basDAOFacade.insert(entity);
		return entity;
	}

	@Override
	public UmsTransCode modifyEntity(UmsTransCode entity) {
		
		//验证名称是否存在
		UmsTransCode qryEntity = new UmsTransCode();
		qryEntity.setId(entity.getId());
		List<UmsTransCode> list = basDAOFacade.select(qryEntity);
		if (list != null && list.size() != 0){
			if ( list.size() > 1){
				throw new BizException("warning.ums.01008", new Object[]{});
			} else {
				if (!list.get(0).getId().equals(entity.getId())){
					throw new BizException("warning.ums.01008", new Object[]{});
				}
			}
		}
		
		basDAOFacade.update(entity);
		return entity;
	}

	@Override
	public UmsTransCode removeEntity(UmsTransCode entity) {

		//验证是否含有下级组织机构码
		UmsTransCode qryEntity = new UmsTransCode();
		qryEntity.setPid(entity.getId());
		List<UmsTransCode> list = basDAOFacade.select(qryEntity);
		if(list != null && list.size() > 0){
			throw new BizException("warning.ums.01001", new Object[]{});
		}
		basDAOFacade.delete(entity);
		return entity;
	}

	
}
