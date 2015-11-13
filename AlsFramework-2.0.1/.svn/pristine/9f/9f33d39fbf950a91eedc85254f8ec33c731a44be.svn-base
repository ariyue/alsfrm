package com.als.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

public class SearchTextTag extends TextTag {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 *  doStartTag()方法返回一个整数值，用来决定程序的后续流程。 
	 *　A.Tag.SKIP_BODY：表示标签之间的内容被忽略 
	 *　B.Tag.EVAL_BODY_INCLUDE：表示标签之间的内容被正常执行 
	 *
	 */
	@Override
	public int doEndTag() throws JspException {
		
		this.setTextType("SearchText");
		return super.doEndTag();
	}
	
	@Override
	public int doStartTag() throws JspTagException {
		
		//columnList.clear();
		return EVAL_PAGE;
	}

}
