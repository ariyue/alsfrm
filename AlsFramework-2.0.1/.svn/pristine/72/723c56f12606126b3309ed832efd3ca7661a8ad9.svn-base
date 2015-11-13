package com.als.frm.bootup;

import org.springframework.stereotype.Component;

import com.als.frm.cache.FrmBasConstantCache;
import com.als.frm.spr.SpringContextUtil;

@Component("frmBasConstantBootuper")
public class FrmBasConstantBootuper implements IBootup{

	@Override
	public void bootup() {

		System.out.println("frmBasConstant cache start ****************************************************** ");
		FrmBasConstantCache frmBasConstantCache = (FrmBasConstantCache) SpringContextUtil.getBean("frmBasConstantCache");
		frmBasConstantCache.initCache();
		System.out.println("frmBasConstant cache finish ****************************************************** ");
		
	}

}
