package com.als.frm.bootup;

import org.springframework.stereotype.Component;

import com.als.frm.cache.FrmBasSerialCache;
import com.als.frm.spr.SpringContextUtil;

@Component("frmBasSerialBootuper")
public class FrmBasSerialBootuper implements IBootup{

	@Override
	public void bootup() {

		System.out.println("frmBasSerial cache start ****************************************************** ");
		FrmBasSerialCache frmBasSerialCache = (FrmBasSerialCache) SpringContextUtil.getBean("frmBasSerialCache");
		frmBasSerialCache.initCache();
		System.out.println("frmBasSerial cache finish ****************************************************** ");
		
	}

}
