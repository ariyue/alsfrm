package com.als.web.tag;



public class FormTag extends AbsTag implements IContainer{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 表单标题
	 */
	private String caption;
	
	
	
	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	@Override
	public String setHolderHtml() {
		String cpt = this.getCaption();
		if (cpt == null){
			cpt = "";
		}
		String html = "<form id=\""+this.getId()+"Form\" class=\"easyui-form\"  data-options=\"novalidate:true\"><div class=\"titleText\">"+cpt+"</div><div id=\""+this.getId()+"\" class=\"alsui-form\"></div></form>";
		return html; //"";
	}
	
	@Override
	public String generalOutString() {
		
		StringBuffer sb = new StringBuffer();
		/*if (this.getpId() != null && !this.getpId().trim().equals("")){
			appendLine(sb, " $('#"+this.getpId()+"').append(' <div id=\""+this.getId()+"\">Form Tag</div> ')");
		} else {
			appendLine(sb, "document.writeln('<div id=\""+this.getId()+"\">Form Tag</div> ');");
		}*/
		
		//生成占位符
		this.generalHolder(sb);
		
		//生成子元素集
		this.generalSubOut(sb, this.childList);
		
		
		
		return sb.toString();
	}

	
}
