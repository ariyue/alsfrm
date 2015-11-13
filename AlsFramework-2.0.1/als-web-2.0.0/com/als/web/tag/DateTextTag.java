package com.als.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;

public class DateTextTag extends AbsTag {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	/**
	 * 默认值
	 */
	private String val="";
	
	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}
	
	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	private String width;


	/**
	 *  doStartTag()方法返回一个整数值，用来决定程序的后续流程。 
	 *　A.Tag.SKIP_BODY：表示标签之间的内容被忽略 
	 *　B.Tag.EVAL_BODY_INCLUDE：表示标签之间的内容被正常执行 
	 */
	@Override
	public int doEndTag() throws JspException {
		
		JspWriter out = this.pageContext.getOut();
		StringBuffer sb = new StringBuffer();
		appendLine(sb, "<input id=\""+this.getId()+"\" type=\"text\"/>");
		
		//script---------------------------------------------------------------------------------
		appendLine(sb,"<script type=\"text/javascript\">");
		//创建控件
		appendLine(sb,"var "+ this.getId()+ " = new $$.DateText(\""+this.getId()+"\")");
		appendLine(sb," "+this.getId()+".setVal(\""+this.getVal()+"\");");
		if (this.getWidth() != null && !this.getWidth().trim().equals("")){
			appendLine(sb," "+this.getId()+".setWidth(\""+this.getWidth()+"\");");
		}
		//myCombo.setConName("SWF_ACTION_TYPE");
		
		//初始化
		appendLine(sb,"$(function(){");
		appendLine(sb," "+this.getId()+".init();");
		appendLine(sb,"});");
		appendLine(sb, "</script>");
		try {
			out.print(sb.toString());
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
			throw new JspException(e.getMessage());
		}
		//return EVAL_BODY_INCLUDE;
		return EVAL_PAGE;
	}
	
	@Override
	public int doStartTag() throws JspTagException {
		
		//columnList.clear();
		return EVAL_PAGE;
	}

	@Override
	public String setHolderHtml() {

		return "<input id=\""+this.getId()+"\" type=\"text\"/> ')";
	}
	
	@Override
	public String generalOutString() {

		StringBuffer sb = new StringBuffer();
		//appendLine(sb, "<input id=\""+this.getId()+"\" type=\"text\"/>");
		//appendLine(sb, "document.writeln(' <input id=\""+this.getId()+"\" type=\"text\"/> ');");
		//生成占位符
		this.generalHolder(sb);
		//script---------------------------------------------------------------------------------
		//appendLine(sb,"<script type=\"text/javascript\">");
		//创建控件
		appendLine(sb,"var "+ this.getId()+ " = new $$.DateText(\""+this.getId()+"\")");
		appendLine(sb," "+this.getId()+".setVal(\""+this.getVal()+"\");");
		if (this.getWidth() != null && !this.getWidth().trim().equals("")){
			appendLine(sb," "+this.getId()+".setWidth(\""+this.getWidth()+"\");");
		}
		//myCombo.setConName("SWF_ACTION_TYPE");
		
		//初始化
		appendLine(sb,"$(function(){");
		appendLine(sb," "+this.getId()+".init();");
		appendLine(sb,"});");
		//appendLine(sb, "</script>");
		return sb.toString();
	}

	

}
