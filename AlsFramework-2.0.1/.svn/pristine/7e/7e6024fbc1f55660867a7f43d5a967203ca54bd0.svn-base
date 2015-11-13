package com.als.web.tag;


public class ComboTag extends AbsTag {

	private String onChange;

	public String getOnChange() {
		return onChange;
	}

	public void setOnChange(String onChange) {
		this.onChange = onChange;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 是否多选
	 * "true", "false"
	 */
	private String multiple;
	public String getMultiple() {
		return multiple;
	}

	public void setMultiple(String multiple) {
		this.multiple = multiple;
	}

	public String getVals() {
		return vals;
	}

	public void setVals(String vals) {
		this.vals = vals;
	}

	public String getSeparator() {
		return separator;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

	/**
	 * 多选初始值
	 */
	private String vals;
	
	/**
	 * 多选分隔符
	 */
	private String separator;
	
	/**
	 * 常量名
	 */
	private String conName;
	
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
	public String getConName() {
		return conName;
	}

	public void setConName(String conName) {
		this.conName = conName;
	}

	/**
	 * 是否必输
	 */
	private String required;
	
	/**
	 * 未输入时提示信息
	 */
	private String missingMsg;
	
	public String getMissingMsg() {
		return missingMsg;
	}

	public void setMissingMsg(String missingMsg) {
		this.missingMsg = missingMsg;
	}

	public String getRequired() {
		return required;
	}

	public void setRequired(String required) {
		this.required = required;
	}

	@Override
	public String setHolderHtml() {

		return "<input id=\""+this.getId()+"\" name=\""+this.getId()+"\"/>";
	}
	
	public String getEditable() {
		return editable;
	}

	public void setEditable(String editable) {
		this.editable = editable;
	}

	private String editable;
	
	/**
	 * 只读
	 */
	private String readOnly = "false";
	
	
	public String getReadOnly() {
		return readOnly;
	}

	public void setReadOnly(String readOnly) {
		this.readOnly = readOnly;
	}

	/**
	 * 请求url
	 */
	private String url;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTextField() {
		return textField;
	}

	public void setTextField(String textField) {
		this.textField = textField;
	}

	public String getValField() {
		return valField;
	}

	public void setValField(String valField) {
		this.valField = valField;
	}
	
	/**
	 * 加载数据前事件
	 */
	private String beforeLoad;
	public String getBeforeLoad() {
		return beforeLoad;
	}

	public void setBeforeLoad(String beforeLoad) {
		this.beforeLoad = beforeLoad;
	}

	/**
	 * 文本列名
	 */
	private String textField;
	
	/**
	 * 值列名
	 */
	private String valField;

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
		appendLine(sb,"var "+ this.getId()+ " = new $$.Combo(\""+this.getId()+"\")");
		appendLine(sb," "+this.getId()+".setConName(\""+this.getConName()+"\");");
		
		if (this.getWidth() != null && !this.getWidth().trim().equals("")){
			appendLine(sb," "+this.getId()+".setWidth(\""+this.getWidth()+"\");");
		}
		
		if (this.getRequired() != null && !this.getRequired().trim().equals("")){
			appendLine(sb," "+this.getId()+".setRequired(\""+this.getRequired()+"\");");
		}
		if (this.getEditable() != null && !this.getEditable().trim().equals("")){
			appendLine(sb," "+this.getId()+".setEditable(\""+this.getEditable().trim()+"\");");
		}
		if (this.getMissingMsg() != null && !this.getMissingMsg().trim().equals("")){
			appendLine(sb," "+this.getId()+".setMissingMsg(\""+this.getMissingMsg()+"\");");
		}
		if (this.getMultiple() != null && this.getMultiple().trim().equals("true")){
			appendLine(sb," "+this.getId()+".setMultiple(\"true\");");
			appendLine(sb," "+this.getId()+".setVals(\""+this.getVals()+"\");");
		} else {
			appendLine(sb," "+this.getId()+".setVal(\""+this.getVal()+"\");");
		}
		
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
		
		//值变化事件
		if (this.getOnChange()!=null && !this.getOnChange().trim().equals("")){
			appendLine(sb," "+this.getId()+".setOnChangeFn(function(newValue, oldValue){");
			appendLine(sb," "+this.getOnChange()+"(newValue, oldValue)");
			appendLine(sb," });");
		}
		
		if (this.getReadOnly() != null && !this.getReadOnly().trim().equals("")){
			appendLine(sb," "+this.getId()+".setReadOnly(\""+this.readOnly+"\");");
		}
		
		
		//初始化
		appendLine(sb,"$(function(){");
		appendLine(sb," "+this.getId()+".init();");
		appendLine(sb,"});");
		//appendLine(sb, "</script>");
		return sb.toString();
	}

	

}
