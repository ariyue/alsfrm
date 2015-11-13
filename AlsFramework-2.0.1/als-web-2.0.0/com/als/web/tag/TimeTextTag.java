package com.als.web.tag;


public class TimeTextTag extends AbsTag {


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


	@Override
	public String setHolderHtml() {

		return "<input id=\""+this.getId()+"\" type=\"text\"/>";
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
		appendLine(sb,"var "+ this.getId()+ " = new $$.TimeText(\""+this.getId()+"\")");
		appendLine(sb," "+this.getId()+".setVal(\""+this.getVal()+"\");");
		appendLine(sb," "+this.getId()+".setVal(\""+this.getVal()+"\");");
		if (this.getWidth() != null && !this.getWidth().trim().equals("")){
			appendLine(sb," "+this.getId()+".setWidth(\""+this.getWidth()+"\");");
		}
		
		//初始化
		appendLine(sb,"$(function(){");
		appendLine(sb," "+this.getId()+".init();");
		appendLine(sb,"});");
		//appendLine(sb, "</script>");
		return sb.toString();
	}

	

}
