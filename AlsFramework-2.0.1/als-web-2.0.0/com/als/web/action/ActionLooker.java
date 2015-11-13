package com.als.web.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class ActionLooker {

	public static String[] look(HttpServletRequest request){
		String url=request.getRequestURI();//取得 /shuju/.../a.yht
		url=url.replace(request.getContextPath(), "");//取得    /.../a.yht
		url=url.substring(1);//取得 .../a.yht
		if (url.indexOf(".") > -1){//如果采用reset的方法，即没有.do等等格式的就不要进一步进行处理了
			url=url.substring(0,url.lastIndexOf("."));//取得 .../a
		}
		
		Map<String,String> m = ActionLoader.ACTION_MAP;
		String value=m.get(url);
		
		return new String[]{url, value};
	}
}
