package com.als.web.tag;



public class RowTag extends AbsTag implements IContainer{

	private static final long serialVersionUID = 1L;
	@Override
	public String setHolderHtml() {
		String html = "<ul id=\""+this.getId()+"\" class=\"alsui-row\"  style=\""+this.getStyle()+"\"></ul>";
		return html;//"<div id=\""+this.getId()+"\">Row Tag</div>";
	}
	
	@Override
	public String generalOutString() {
		
		StringBuffer sb = new StringBuffer();
		/*if (this.getpId() != null && !this.getpId().trim().equals("")){
			appendLine(sb, " $('#"+this.getpId()+"').append(' <div id=\""+this.getId()+"\">Row Tag</div> ')");
		} else {
			appendLine(sb, "document.writeln('<div id=\""+this.getId()+"\">Row Tag</div> ');");
		}*/
		
		//生成占位符
		this.generalHolder(sb);
		
		
		//生成子元素
		this.generalSubOut(sb, this.childList);
		
		return sb.toString();
	}

	
}
