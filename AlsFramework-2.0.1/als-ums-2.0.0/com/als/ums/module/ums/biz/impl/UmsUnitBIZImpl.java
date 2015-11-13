package com.als.ums.module.ums.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.als.frm.bas.dao.BasDAOFacade;
import com.als.frm.comm.util.UuidUtil;
import com.als.frm.ex.BizException;
import com.als.mod.domain.UmsEntity;
import com.als.mod.domain.UmsUnit;
import com.als.ums.module.ums.biz.UmsUnitBIZ;
import com.als.ums.module.ums.dao.UmsUnitDAO;

@Service("umsUnitBIZImpl")
public class UmsUnitBIZImpl implements UmsUnitBIZ {
	
	@Autowired
	private BasDAOFacade<UmsUnit> basDAOFacade;
	
	@Autowired
	private UmsUnitDAO umsUnitDAOImpl;

	/**
	 * 根组织机构的父节点ID
	 */
	private static final String ROOT_UNIT_PID = "-1";
	
	/**
	 * 根组织机构的关系码
	 */
	private static final String ROOT_UNIT_RELATIONSHIP = "00";
	
	@Override
	public UmsUnit addTopUnit(UmsEntity entity) {
		String unitName = entity.getEntitySname();
		if (unitName == null || unitName.trim().equals("")){
			unitName = entity.getEntityName();
		}
		UmsUnit unit = new UmsUnit();
		unit.setId(UuidUtil.create());
		unit.setPid(ROOT_UNIT_PID);
		unit.setUnitName(unitName);
		unit.setUnitRelationship(ROOT_UNIT_RELATIONSHIP);
		unit.setRemark("顶级组织机构");
		unit.setEntitySid(entity.getEntitySid());
		unit.setRowOrder(0);
		
		try {
			return this.basDAOFacade.insert(unit);
		} catch (Exception e) {
			throw new BizException("err.ums.01001", new Object[]{});
		}
	}

	@Override
	public UmsUnit addEntity(UmsUnit unit) {

		//验证名称是否存在
		UmsUnit qryEntity = new UmsUnit();
		qryEntity.setUnitName(unit.getUnitName());
		List list = basDAOFacade.select(qryEntity);
		if (list != null && list.size() > 0){
			throw new BizException("warning.ums.01005", new Object[]{});
		}
		
		//unit.setId(UuidUtil.create());//前端生成
		String unitRelationship = umsUnitDAOImpl.getNewRelationship(unit.getPid());
		unit.setUnitRelationship(unitRelationship);
		this.basDAOFacade.insert(unit);
		return unit;
	}

	@Override
	public UmsUnit modifyEntity(UmsUnit unit) {

		//验证名称是否存在
		UmsUnit qryEntity = new UmsUnit();
		qryEntity.setUnitName(unit.getUnitName());
		List<UmsUnit> list = basDAOFacade.select(qryEntity);
		if (list != null && list.size() != 0){
			if ( list.size() > 1){
				throw new BizException("warning.ums.01005", new Object[]{});
			} else {
				if (!list.get(0).getId().equals(unit.getId())){
					throw new BizException("warning.ums.01005", new Object[]{});
				}
			}
		}
		
		return basDAOFacade.update(unit);
	}

	@Override
	public UmsUnit removeEntity(UmsUnit unit) {
		
		//验证是否含有下级组织机构码
		UmsUnit qryEntity = new UmsUnit();
		qryEntity.setPid(unit.getId());
		List<UmsUnit> list = basDAOFacade.select(qryEntity);
		if(list != null && list.size() > 0){
			throw new BizException("warning.ums.01001", new Object[]{});
		}
		return basDAOFacade.delete(unit);
	}

}
