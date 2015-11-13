package com.als.ums.module.ums.biz;

import com.als.mod.domain.UmsEntity;
import com.als.mod.domain.UmsUnit;

public interface UmsUnitBIZ {

	
	/**
	 * 添加顶组织机构
	 * @param entity 
	 * @return
	 */
	public UmsUnit addTopUnit(UmsEntity entity);
	
	/**
	 * 
	 * @param unit
	 * @return
	 */
	public UmsUnit addEntity(UmsUnit unit);
	
	/**
	 * 
	 * @param unit
	 * @return
	 */
	public UmsUnit modifyEntity(UmsUnit unit);
	
	public UmsUnit removeEntity(UmsUnit unit);
	
	
}
