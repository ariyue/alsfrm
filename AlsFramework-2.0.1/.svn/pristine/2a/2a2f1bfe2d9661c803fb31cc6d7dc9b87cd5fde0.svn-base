package com.als.frm.cache;

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
import com.als.frm.ex.AppException;
import com.als.frm.ex.BizException;
import com.als.frm.integration.FrmBasITG;
import com.als.mod.domain.FrmBasSerial;
import com.als.mod.domain.FrmBasSerialItem;

@Component("frmBasSerialCache")
public class FrmBasSerialCache implements IFrmBasSerialCache {

	@Autowired
	private Ehcache frmBasSerialCacheBlock;
	@Autowired
	private BasDAOFacade<FrmBasSerialItem> basDAOFacade;
	
	@Override
	@Transactional
	public void initCache(){

		System.out.println("开始缓存主键----------------------------------------------------");
		//每次重启或日切时清除一下缓存
		frmBasSerialCacheBlock.removeAll();
		try {
			List<Map> list = this.querySerialList();
			Map r = null;
			String ItemId = null;
			FrmBasSerialItem item = null;
			for (int i = 0, len = list.size(); i < len; i++) {
				r = list.get(i);
				ItemId = r.get("module").toString() + r.get("entitySid").toString() + FrmBasITG.getBizDate( r.get("entitySid").toString());
				item = new FrmBasSerialItem();
				item.setId(ItemId);
				Long maxValue = 0L;
				item = this.basDAOFacade.selectOne(item);
				if (item != null){
					maxValue = item.getMaxValue() + Long.valueOf(r.get("cacheSize").toString());
				}
				this.updateCache(r, maxValue);
			}

		} catch (Exception e) {
			System.out.println("缓存主键出错！");
			// TODO 错误处理

		}
		System.out.println("缓存主键结束-----------------------------------------------");

	}

	
	@Transactional
	private void updateCache(Map r, Long maxValue) throws BizException {

		String key = r.get("module").toString() + r.get("entitySid").toString();
		String bizDate = FrmBasITG.getBizDate(r.get("entitySid").toString());
		String ItemId = key + bizDate;
		
		
		Long currentValue = maxValue + 1;
		Long maxCacheValue = maxValue + Long.valueOf(r.get("cacheSize").toString());
		Map cacheData = new HashMap(3);
		cacheData.put(FrmConstant.SERIAL_KEY_CURRENT_VALUE, currentValue);
		cacheData.put(FrmConstant.SERIAL_KEY_MAX_VALUE, maxCacheValue);
		cacheData.put(FrmConstant.SERIAL_KEY_PREFIX, r.get("prefix").toString().trim()
				+ r.get("module").toString() + r.get("entitySid").toString());
		cacheData.put(FrmConstant.SERIAL_KEY_SUBFIX, r.get("subfix").toString().trim());
		Element e = new Element(key, cacheData);

		// 缓存
		frmBasSerialCacheBlock.put(e);
		// 更新最大值到数据库
		try {
			FrmBasSerialItem item = new FrmBasSerialItem();
			item.setId(ItemId);
			item = this.basDAOFacade.selectOne(item);
			
			if (item == null){
				item = new FrmBasSerialItem();
				item.setId(ItemId);
				item.setMaxValue(maxValue);
				this.basDAOFacade.insert(item);
			} else {
				item.setMaxValue(maxValue);
				this.basDAOFacade.update(item);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Transactional
	public void updateCache(String module, String entitySid, Long maxValue) {

		String key = module + entitySid;
		//FrmBasSerial r = new FrmBasSerial();
		//r.setModule(module);
		//r.setEntitySid(entitySid);
		String sql = "select id, module, entity_sid entitySid, cache_size cacheSize,prefix, subfix from frm_bas_serial v where 1=1 and v.module=:module and v.entity_sid=:entitySid";
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("module", module);
		args.put("entitySid", entitySid);
		List<Map<String, Object>> list = this.basDAOFacade.select(sql, args);
		if (list != null && list.size() > 0 ){
			Map r = list.get(0);
			this.updateCache(r, maxValue);
		}
	}

	private List querySerialList() {

		try {
			String sql = "select id, module, entity_sid entitySid, cache_size cacheSize,prefix, subfix from frm_bas_serial v where 1=1 ";
			Map<String, Object> args = new HashMap<String, Object>();
			List list = basDAOFacade.select(sql, args);
			return list;
		} catch (Exception e) {
			throw new AppException("FrmBasSerialCache:获取als_bas_Serial失败！");
		}
	}


	@Override
	public Long getCurrentCacheValue(String module, String entitySid) {
		
		String key = module + entitySid;
		Element e = this.frmBasSerialCacheBlock.get(key);
		Map cacheData = (Map) e.getValue();
		Long currentValue = (Long) cacheData.get(FrmConstant.SERIAL_KEY_CURRENT_VALUE);
		return currentValue;
	}


	@Override
	public void removeCache(String module, String entitySid) {

		String key = module + entitySid;
		Element e = this.frmBasSerialCacheBlock.get(key);
		if (e != null){
			this.frmBasSerialCacheBlock.removeElement(e);
		}
	}

}
