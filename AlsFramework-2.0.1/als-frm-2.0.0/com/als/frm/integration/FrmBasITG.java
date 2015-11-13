package com.als.frm.integration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.als.frm.cache.IFrmBasConstantCache;
import com.als.frm.cache.IFrmBasSerialCache;
import com.als.frm.comm.FrmConstant;
import com.als.frm.ex.AppException;

@Service("frmBasITG")
public class FrmBasITG implements IFrmBasITG {

	
	@Autowired
	private Ehcache frmBasSerialCacheBlock;
	
	@Autowired
	private Ehcache frmBasConstantCacheBlock;
	
	@Autowired
	private IFrmBasSerialCache frmBasSerialCache;
	
	@Autowired
	private IFrmBasConstantCache frmBasConstantCache;

	public static Boolean lockFlag = new Boolean(false);
	@Override
	public String getNewSerialId(String module, String entitySid) {
		
		lockFlag = new Boolean(false);//解锁
		String r = "";
		if (!lockFlag.booleanValue()) {
			synchronized (lockFlag) {
				if (!lockFlag.booleanValue()) {
					try {
						lockFlag = new Boolean(true);// 加锁
						r =	_getNewSerialId(module, entitySid);
					} catch (Exception e) {
						throw new AppException("获取新的BizId失败");
					} finally {
						lockFlag = new Boolean(false);// 解锁
					}
				}
			}
		}
		return r;
	}
	
	private String _getNewSerialId(String module, String entitySid) {
		String key = module + entitySid;
		Element e = this.frmBasSerialCacheBlock.get(key);
		Map cacheData = (Map) e.getValue();
		String prefix = (String) cacheData.get(FrmConstant.SERIAL_KEY_PREFIX);
		String subfix = (String) cacheData.get(FrmConstant.SERIAL_KEY_SUBFIX);
		Long currentValue = (Long) cacheData.get(FrmConstant.SERIAL_KEY_CURRENT_VALUE);
		Long maxValue = (Long) cacheData.get(FrmConstant.SERIAL_KEY_MAX_VALUE);
		
		String currentValueStr =  String.format("%08d", currentValue);     
		
		String id = prefix + getBizDate(entitySid) + currentValueStr + subfix;
		frmBasSerialCacheBlock.remove(key);
		cacheData.put(FrmConstant.SERIAL_KEY_CURRENT_VALUE, currentValue + 1);
		e = new Element(key, cacheData);
		frmBasSerialCacheBlock.put(e);
		if (currentValue.longValue() >=  maxValue.longValue()){
			//获取新的数据库缓存
			this.frmBasSerialCache.updateCache(module, entitySid, currentValue);
		} 
		return id;
	}

	
	/**
	 * 获取业务日期（从业务日历中进行读取）
	 * @param entitySid
	 * @return
	 */
	public static String getBizDate(String entitySid) {
		
		// TODO 通过工作日历来取(每个entity都有一个自己的工作日历，暂时未实现)
		Date dt = new Date();
		String d = new SimpleDateFormat("yyyyMMdd").format(dt);
		return d;
	}
	
	/**
	 * 获取自然日日期
	 * @return
	 */
	public static String getNatureDate(){
		Date dt = new Date();
		String d = new SimpleDateFormat("yyyyMMdd").format(dt);
		return d;
	}
	
	public static void main(String[] args) {
		
		
		Long currentValue =  128l;
		String currentValueStr =  String.format("%08d", currentValue);
		System.out.println(currentValueStr);
	}

	@Override
	public int updateConstantList(String conName,
			String entitySid,List constantList) {
		
		return frmBasConstantCache.updateConstantList(conName, entitySid, constantList);
	}

	@Override
	public List getConstantList(String conName, String entitySid) {

		return frmBasConstantCache.getConstantList(conName, entitySid);
	}
	
	
}
