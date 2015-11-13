package com.als.web.action.rst;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.als.frm.bas.ddl.RstType;
import com.als.frm.comm.dto.RstMsg;
import com.als.frm.comm.dto.RstRedirect;
import com.als.frm.comm.dto.RstTab;

public class RstBuilder {

	public static void build(HttpServletRequest request, HttpServletResponse response, Object result){
		
		RstType type;
		if(result instanceof RstMsg){
			type = RstType.msgWin;
		} else if(result instanceof RstTab){
			type = RstType.tab;
		} else if(result instanceof RstRedirect){
			type = RstType.redirect;
		} else {
			type = RstType.comm;
		}
		IRst rst = RstFactory.CreateRst(type);
		rst.build(request, response, result);
		
	}
}
