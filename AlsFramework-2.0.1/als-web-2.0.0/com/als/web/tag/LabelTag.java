package com.als.web.tag;

public class LabelTag extends AbsTag{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	public String generalOutString() {

		StringBuffer sb = new StringBuffer();

		//生成占位符
		this.generalHolder(sb);
		//script---------------------------------------------------------------------------------
		//创建控件
		
		//初始化
		appendLine(sb,"$(function(){");
		String lb = this.getText();
		String lb_i18n = this.generalI18nMsg(lb, new Object[]{});
		
		appendLine(sb," $(\"#"+this.getId()+"\").html(\""+ lb_i18n+"\").addClass(\" "+this.getLabelClass()+"\");");
		appendLine(sb,"});");
		return sb.toString();

		
	}
	
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}


	private String text;
	
	
	/**
	 * 文件框标签样式（如:up,将使文本在文本框上面）
	 * @return
	 */
	public String getLabelClass() {
		return labelClass;
	}

	public void setLabelClass(String labelClass) {
		this.labelClass = labelClass;
	}

	private String labelClass;

	@Override
	public String setHolderHtml() {

		String html = "<label id=\""+ this.getId()+"\"></label>";
		return html;
	}

}
