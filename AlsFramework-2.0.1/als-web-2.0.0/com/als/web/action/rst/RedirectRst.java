package com.als.web.action.rst;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.als.frm.bas.ddl.RstType;
import com.als.frm.comm.dto.RstData;
import com.als.frm.comm.dto.RstMsg;
import com.als.frm.comm.dto.RstRedirect;
import com.als.frm.comm.util.Base64Util;
import com.als.frm.comm.util.MessageUtil;
import com.als.frm.ex.AppException;

public class RedirectRst implements IRst {

	@Override
	public void build(HttpServletRequest request, HttpServletResponse response,
			Object result) {
		PrintWriter out;
		try {
			out = response.getWriter();
			RstData rstData = new RstData();
			
			rstData.setRstType(RstType.redirect);
			JSONObject resultJSON = new JSONObject();// 构建一个JSONObject

			RstRedirect rstMsg =  (RstRedirect) result;
			Map newRst = new HashMap(2);
			
			Map<String, String> map = rstMsg.getParams();
			StringBuffer b = new StringBuffer();
			for(Map.Entry<String, String> entry: map.entrySet()){  
				b.append("&"+entry.getKey()+ "=" +entry.getValue());
			} 
			String bs = b.toString();
			if (bs.length() > 1){
				bs = bs.substring(1);
				bs = Base64Util.encode(bs.getBytes());
			}
			newRst.put("params", bs);
			newRst.put("url", rstMsg.getPath());
			rstData.setResult(newRst);
			resultJSON.accumulate("resultData", rstData);
			response.setContentType("application/x-json");// 需要设置ContentType
			// 为"application/x-json"
			out.println(resultJSON.toString());// 向客户端输出JSONObject字符串
			out.flush();
			out.close();
		} catch (Exception e) {
			//任何可能出现异常的地方，如果没有定义，都输出AppException异常，这样，在log文件中就可以找到异常。
			throw new AppException(e.getMessage());
		}
		
	}
}
