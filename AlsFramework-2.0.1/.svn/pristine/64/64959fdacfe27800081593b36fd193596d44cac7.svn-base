package com.als.frm.cache;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("frmCacheManager")
public class FrmCacheManager {

	

	@Autowired
	private Ehcache frmCache;

	public void addCache(String key, Object o){
		
		Element e = new Element(key, o);
		frmCache.put(e);
	}
	
	public Object getCache(String key){
		
		Element e = frmCache.get(key);
		return (Object) e.getValue();
	}
	
	public void removeCache(String key){
		
		frmCache.remove(key);
	}
	
	public void updateCache(String key, Object o){
		
		this.removeCache(key);
		this.addCache(key, o);
	}

}
