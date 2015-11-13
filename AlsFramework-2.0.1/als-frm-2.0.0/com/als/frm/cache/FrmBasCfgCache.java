package com.als.frm.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.als.frm.bas.dao.BasDAOFacade;
import com.als.frm.ex.AppException;

@Component("frmBasCfgCache")
public class FrmBasCfgCache {

	
	@Autowired
	private FrmCacheManager frmCacheManager;
	
	@SuppressWarnings("unchecked")
	@Autowired
	private BasDAOFacade basDAOFacade;
	
	public static String getKey(String code){
		
		return "_BAS_CFG_" + code;
	}
	
	public void initCache(){

		String sql = "select t.id id, t.code code, t.name name, t.val val, t.remark remark, t.entity_sid entitySid from frm_bas_cfg t";
		Map<String, Object> args = new HashMap<String, Object>();
		List list = basDAOFacade.select(sql, args);
		if (list != null){
			for (int i = 0, len = list.size(); i < len; i++){
				this.addCfg( (Map)list.get(i));
			}
		}		
	}
	
	/**
	 * 更新缓存
	 * @param cfg
	 */
	public void addCfg(Map cfg){
		frmCacheManager.addCache(getKey(cfg.get("code").toString()),  cfg);
	}
	
	/**
	 * 获取缓存
	 * @param code
	 * @return
	 */
	public Map getCfgByCode (String code){
		Object o = frmCacheManager.getCache(getKey(code));
		if (o != null){
			return (Map)o;
		} else {
			throw new AppException("没有找到code为" + code + "的缓存！");
		}
	}

	/**
	 * 更新缓存
	 * @param cfg
	 */
	public void updateCfg(Map cfg){
		frmCacheManager.updateCache(getKey(cfg.get("code").toString()),  cfg);
	}
	
	/**
	 * 删除缓存
	 * @param code
	 */
	public void removeCfgByCode(String code){

		frmCacheManager.removeCache(getKey(code));
	}
}
