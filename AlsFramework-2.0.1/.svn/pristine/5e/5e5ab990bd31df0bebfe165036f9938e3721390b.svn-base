package com.als.web.tag;


public class BtnTag extends AbsTag {
	
	
	
	/**
	 * 　按钮点击事件
	 */
	private String btnClick;
	
	/**
	 * 是否可用
	 */
	private String disabled;
	
	public String getDisabled() {
		return disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}


	private String iconCls;
	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}


	private String text;
	
	public String getBtnClick() {
		return btnClick;
	}

	public void setBtnClick(String btnClick) {
		this.btnClick = btnClick;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Override
	public String setHolderHtml() {

		return "<a id=\""+this.getId()+"\" href=\"javascript:;\"></a>";
	}
	
	@Override
	public String generalOutString() {
		
		StringBuffer sb = new StringBuffer();
		//appendLine(sb, "<a id=\""+this.getId()+"\" href=\"javascript:;\"></a>");
		//appendLine(sb, "document.writeln(' <a id=\""+this.getId()+"\" href=\"javascript:;\"></a> ');");
		//script---------------------------------------------------------------------------------
		//appendLine(sb,"<script type=\"text/javascript\">");
		
		//生成占位符
		this.generalHolder(sb);
		//创建控件
		appendLine(sb,"var "+ this.getId()+ " = new $$.Btn(\""+this.getId()+"\");");
		if (this.getIconCls()!=null && !this.getIconCls().trim().equals("")){
			appendLine(sb," "+this.getId()+".setIconCls(\""+this.getIconCls()+"\");");
		}
		
		if (this.getDisabled()!=null && !this.getDisabled().trim().equals("")){
			appendLine(sb," "+this.getId()+".setDisabled(\""+this.getDisabled()+"\");");
		}
		appendLine(sb," "+this.getId()+".setText(\""+this.getText()+"\");");
		//按钮单击事件
		if (this.getBtnClick()!=null && !this.getBtnClick().trim().equals("")){
			appendLine(sb," "+this.getId()+".setBtnClickFn(function(val){");
			appendLine(sb," "+this.getBtnClick()+"()");
			appendLine(sb," });");
		}
		
		
		
		//初始化
		appendLine(sb,"$(function(){");
		appendLine(sb," "+this.getId()+".init();");
		appendLine(sb,"});");
		//appendLine(sb, "</script>");
		return sb.toString();
	}

	

}
