package com.als.frm.bootup;

import org.springframework.stereotype.Component;

import com.als.frm.cache.FrmBasCfgCache;
import com.als.frm.spr.SpringContextUtil;

@Component("frmBasCfgBootuper")
public class FrmBasCfgBootuper implements IBootup{
	
	@Override
	public void bootup() {
		
		System.out.println("frmBasCfg cache start ****************************************************** ");
		FrmBasCfgCache frmBasCfgCache = (FrmBasCfgCache) SpringContextUtil.getBean("frmBasCfgCache");
		frmBasCfgCache.initCache();
		System.out.println("frmBasCfg cache finish ****************************************************** ");
	}
}
