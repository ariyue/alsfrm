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
import com.als.frm.comm.util.MessageUtil;
import com.als.frm.ex.AppException;

public class MsgRst implements IRst{

	@Override
	public void build(HttpServletRequest request, HttpServletResponse response,
			Object result) {
		PrintWriter out;
		try {
			out = response.getWriter();
			RstData rstData = new RstData();
			
			rstData.setRstType(RstType.msgWin);
			JSONObject resultJSON = new JSONObject();// 构建一个JSONObject

			RstMsg rstMsg =  (RstMsg) result;
			String msg = MessageUtil.getMessage(rstMsg.getMsgCode(), rstMsg.getMsgParams(), false);
			Map newRst = new HashMap(2);
			newRst.put("msg", msg);
			newRst.put("winType", rstMsg.getMsgType());
			rstData.setResult(newRst);
			resultJSON.accumulate("resultData", rstData);
			response.setContentType("application/x-json");// 需要设置ContentType
			// 为"application/x-json"
			out.println(resultJSON.toString());// 向客户端输出JSONObject字符串
			out.flush();
			out.close();
		} catch (IOException e) {
			//任何可能出现异常的地方，如果没有定义，都输出AppException异常，这样，在log文件中就可以找到异常。
			throw new AppException(e.getMessage());
		}
		
	}

}
