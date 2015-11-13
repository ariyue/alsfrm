package com.als.web.action.rst;

import com.als.frm.bas.ddl.RstType;

public class RstFactory {

	public static IRst CreateRst(RstType type){
		
		IRst r = null;
		switch (type){
			case comm:
				r = new CommRst();
				break;
			case msgWin:
				r = new MsgRst();
				break;
			case tab:
				r = new TabRst();
				break;
			case redirect:
				r = new RedirectRst();
				break;
			default: 
				r = new CommRst();
				break;
		}
		
		return r;
	}
}
