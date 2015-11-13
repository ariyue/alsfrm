package com.als.web.tag;




public class FldTag extends AbsTag implements IContainer{

	private static final long serialVersionUID = 1L;
	@Override
	public String setHolderHtml() {
		
		return "<li id=\""+this.getId()+"\" class=\"alsui-fld\" style=\""+this.getStyle()+"\"></li>";
	}
	
	@Override
	public String generalOutString() {
		
		StringBuffer sb = new StringBuffer();
		/*if (this.getpId() != null && !this.getpId().trim().equals("")){
			appendLine(sb, " $('#"+this.getpId()+"').append(' <div id=\""+this.getId()+"\">Fld Tag</div> ')");
		} else {
			appendLine(sb, "document.writeln('<div id=\""+this.getId()+"\">Fld Tag</div> ');");
		}*/
	    
		//生成占位符
		this.generalHolder(sb);
		//生成子元素
		this.generalSubOut(sb, this.childList);
		
		return sb.toString();
	}

	
}
