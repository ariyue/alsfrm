package com.als.web.tag;


/**
 * 单选框组
 * @author Administrator
 *
 */
public class RdoGrpTag extends ComboTag {
	
	private String itemClick;

	public String getItemClick() {
		return itemClick;
	}

	public void setItemClick(String itemClick) {
		this.itemClick = itemClick;
	}

	/**
	 * 文本框前面的标签文字
	 */
	private String label;
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabelClass() {
		return labelClass;
	}

	public void setLabelClass(String labelClass) {
		this.labelClass = labelClass;
	}

	private String labelClass;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String setHolderHtml() {

		return "<div id=\""+this.getId()+"\" ></div>";
	}
	
	@Override
	public String generalOutString() {
		
		StringBuffer sb = new StringBuffer();
		//appendLine(sb, "<input id=\""+this.getId()+"\" name=\""+this.getId()+"\"/>");
		//appendLine(sb, "document.writeln(' <input id=\""+this.getId()+"\" name=\""+this.getId()+"\"/> ');");
		//生成占位符
		this.generalHolder(sb);
		//script---------------------------------------------------------------------------------
		//appendLine(sb,"<script type=\"text/javascript\">");
		//创建控件
		appendLine(sb,"var "+ this.getId()+ " = new $$.RdoGrp(\""+this.getId()+"\")");
		appendLine(sb," "+this.getId()+".setConName(\""+this.getConName()+"\");");
		if (this.getLabel() != null && !this.getLabel().trim().equals("")){
			appendLine(sb," "+this.getId()+".setLabel(\""+this.getLabel()+"\");");
		}
		
		if (this.getLabelClass() != null && !this.getLabelClass().trim().equals("")){
			appendLine(sb," "+this.getId()+".setLabelClass(\""+this.getLabelClass()+"\");");
		}
		
		//if (this.getMultiple() != null && this.getMultiple().trim().equals("true")){
		//	appendLine(sb," "+this.getId()+".setMultiple(\"true\");");
		//	appendLine(sb," "+this.getId()+".setVals(\""+this.getVals()+"\");");
		//} else {
			appendLine(sb," "+this.getId()+".setVal(\""+this.getVal()+"\");");
		//}
			
			
		//服务器事件
		//通过JS的ROOT_PATH + url来确定
		if (this.getUrl() != null && !this.getUrl().trim().equals("")){
			appendLine(sb," "+this.getId()+".setUrl( \""+this.getUrl()+"\");   ");
		}
		//值列名
		if (this.getValField() != null && !this.getValField().trim().equals("")){
			appendLine(sb," "+this.getId()+".setValField(\""+this.getValField()+"\");  ");
		}
		//文本列名
		if (this.getTextField() != null && !this.getTextField().trim().equals("")){
			appendLine(sb," "+this.getId()+".setTextField(\""+this.getTextField()+"\");  ");
		}
		if (this.getBeforeLoad()!=null && !this.getBeforeLoad().trim().equals("")){
			appendLine(sb," "+this.getId()+".setOnBeforeLoadFn(function(param){");
			appendLine(sb," "+this.getBeforeLoad()+"(param)");
			appendLine(sb," });");
		}
		
		if (this.getItemClick()!=null && !this.getItemClick().trim().equals("")){
			appendLine(sb," "+this.getId()+".setItemClickFn(function(checked, value, text){");
			appendLine(sb," "+this.getItemClick()+"(checked, value, text)");
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
