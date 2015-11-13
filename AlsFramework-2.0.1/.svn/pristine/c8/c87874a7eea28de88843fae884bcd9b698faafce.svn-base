package com.als.web.tag;

public class TextTag extends AbsTag {
	
	
	/**
	 * 文本框值
	 */
	private String value;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getReadOnly() {
		return readOnly;
	}

	public void setReadOnly(String readOnly) {
		this.readOnly = readOnly;
	}

	/**
	 * 只读
	 */
	private String readOnly = "false";
	
	/**
	 * 输入框类型 Text：普通输入框，SearchText带有搜索条的输入框
	 */
	private String textType = "Text";
	
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
	
	/**
	 * 输入框类别:可用值有："text"和"password"。
	 */
	private String type = "text";
	
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

	/**
	 * 验证器
	 */
	private String validType;
	
	/**
	 * 验证失败提示信息
	 */
	private String invalidMsg;
	
	public String getInvalidMsg() {
		return invalidMsg;
	}

	public void setInvalidMsg(String invalidMsg) {
		this.invalidMsg = invalidMsg;
	}

	public String getValidType() {
		return validType;
	}

	public void setValidType(String validType) {
		this.validType = validType;
	}

	/**
	 * 回车键事件
	 */
	private String enterKeyPress;
	
	

	public String getEnterKeyPress() {
		return enterKeyPress;
	}

	public void setEnterKeyPress(String enterKeyPress) {
		this.enterKeyPress = enterKeyPress;
	}

	/**
	 * 文本框中没有输入值的提示
	 */
	private String prompt;
	
	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getIconCls() {
		return iconCls;
	}
	
	private String iconAlign;

	public String getIconAlign() {
		return iconAlign;
	}

	public void setIconAlign(String iconAlign) {
		this.iconAlign = iconAlign;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getTextType() {
		return textType;
	}

	private String iconCls;
	
	private String buttonText;

	public String getButtonText() {
		return buttonText;
	}

	public void setButtonText(String buttonText) {
		this.buttonText = buttonText;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	private String width;

	public void setTextType(String textType) {
		this.textType = textType;
	}
	
	/**
	 * 　按钮点击事件
	 */
	private String btnClick;
	
	public String getBtnClick() {
		return btnClick;
	}

	public void setBtnClick(String btnClick) {
		this.btnClick = btnClick;
	}

	public String getIconClick() {
		return iconClick;
	}

	public void setIconClick(String iconClick) {
		this.iconClick = iconClick;
	}

	private String iconClick;
	
	public String getEditable() {
		return editable;
	}

	public void setEditable(String editable) {
		this.editable = editable;
	}

	private String editable;
	
	public String getMaxlength() {
		return maxlength;
	}

	public void setMaxlength(String maxlength) {
		this.maxlength = maxlength;
	}

	private String maxlength;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String setHolderHtml() {
		
		String ml = "";
		if (this.getMaxlength() != null){
			ml = " maxlength=\""+this.getMaxlength()+"\" ";
		}

		return "<input id=\""+this.getId()+"\" "+ml+"  type=\"text\"/>";
	}

	@Override
	public String generalOutString() {
		//script---------------------------------------------------------------------------------
		StringBuffer sb = new StringBuffer();
		
		/*if (this.getpId() != null && !this.getpId().trim().equals("")){
			appendLine(sb, " $('#"+this.getpId()+"').append(' <input id=\""+this.getId()+"\" type=\"text\"/> ')");
		} else {
			appendLine(sb, "document.writeln(' <input id=\""+this.getId()+"\" type=\"text\"/> ');");
		}*/
		
		
		
		//生成占位符
		this.generalHolder(sb);
		
		//创建控件
		appendLine(sb,"var "+ this.getId()+ " = new $$."+this.textType+"(\""+this.getId()+"\");");
		
		if (this.getValue() != null && !this.getValue().trim().equals("")){
			appendLine(sb," "+this.getId()+".setValue(\""+this.getValue()+"\");");
		}
		
		if (this.getWidth() != null && !this.getWidth().trim().equals("")){
			appendLine(sb," "+this.getId()+".setWidth(\""+this.getWidth()+"\");");
		}
		
		
		
		if (this.getType() != null && !this.getType().trim().equals("")){
			appendLine(sb," "+this.getId()+".setType(\""+this.type+"\");");
		}
		
		if (this.getIconCls() != null && !this.getIconCls().trim().equals("")){
			appendLine(sb," "+this.getId()+".setIconCls(\""+this.getIconCls()+"\");");
		}
		
		if (this.getIconAlign() != null && !this.getIconAlign().trim().equals("")){
			appendLine(sb," "+this.getId()+".setIconAlign(\""+this.getIconAlign()+"\");");
		}
		
		if (this.getButtonText() != null && !this.getButtonText().trim().equals("")){
			appendLine(sb," "+this.getId()+".setButtonText(\""+this.getButtonText()+"\");");
		}
		
		if (this.getPrompt() != null && !this.getPrompt().trim().equals("")){
			appendLine(sb," "+this.getId()+".setPrompt(\""+this.getPrompt()+"\");");
		}
		
		
		if (this.getLabel() != null && !this.getLabel().trim().equals("")){
			String lb = this.getLabel();
			String lb_i18n = this.generalI18nMsg(lb, new Object[]{});
			appendLine(sb," "+this.getId()+".setLabel(\""+lb_i18n+"\");");
		}
		
		if (this.getLabelClass() != null && !this.getLabelClass().trim().equals("")){
			appendLine(sb," "+this.getId()+".setLabelClass(\""+this.getLabelClass()+"\");");
		}
		
		if (this.getRequired() != null && !this.getRequired().trim().equals("")){
			appendLine(sb," "+this.getId()+".setRequired(\""+this.getRequired()+"\");");
		}
		if (this.getEditable() != null && !this.getEditable().trim().equals("")){
			appendLine(sb," "+this.getId()+".setEditable(\""+this.getEditable().trim()+"\");");
		}
		
		if (this.getMaxlength() != null && !this.getMaxlength().trim().equals("")){
			appendLine(sb," "+this.getId()+".setMaxlength(\""+this.getMaxlength().trim()+"\");");
		}
		
		/*if (this.getMissingMsg() != null && !this.getMissingMsg().trim().equals("")){
			appendLine(sb," "+this.getId()+".setMissingMsg(\""+this.getMissingMsg()+"\");");
		}*/
		
		if (this.getMissingMsg() != null && !this.getMissingMsg().trim().equals("")){
			String lb = this.getMissingMsg();
			String lb_i18n = this.generalI18nMsg(lb, new Object[]{});
			appendLine(sb," "+this.getId()+".setMissingMsg(\""+lb_i18n+"\");");
		}
		
		
		
		if (this.getValidType() != null && !this.getValidType().trim().equals("")){
			appendLine(sb," "+this.getId()+".setValidType(\""+this.getValidType()+"\");");
		}
		
		/*if (this.getInvalidMsg() != null && !this.getInvalidMsg().trim().equals("")){
			appendLine(sb," "+this.getId()+".setInvalidMsg(\""+this.getInvalidMsg()+"\");");
		}*/
		
		if (this.getInvalidMsg() != null && !this.getInvalidMsg().trim().equals("")){
			String lb = this.getInvalidMsg();
			String lb_i18n = this.generalI18nMsg(lb, new Object[]{});
			appendLine(sb," "+this.getId()+".setInvalidMsg(\""+lb_i18n+"\");");
		}
		
		//按钮单击事件
		if (this.getBtnClick()!=null && !this.getBtnClick().trim().equals("")){
			appendLine(sb," "+this.getId()+".setBtnClickFn(function(val){");
			appendLine(sb," "+this.getBtnClick()+"(val)");
			appendLine(sb," });");
		}
		
		if (this.getIconClick()!=null && !this.getIconClick().trim().equals("")){
			appendLine(sb," "+this.getId()+".setIconClickFn(function(index){");
			appendLine(sb," "+this.getIconClick()+"(index)");
			appendLine(sb," });");
		}
		
		if (this.getEnterKeyPress()!=null && !this.getEnterKeyPress().trim().equals("")){
			appendLine(sb," "+this.getId()+".setEnterKeyFn(function(val){");
			appendLine(sb," "+this.getEnterKeyPress()+"(val)");
			appendLine(sb," });");
		}
		
		if (this.getReadOnly() != null && !this.getReadOnly().trim().equals("")){
			                                 
			appendLine(sb," "+this.getId()+".setReadOnly(\""+this.readOnly+"\");");
		}
		
		//初始化
		appendLine(sb,"$(function(){");
		appendLine(sb," "+this.getId()+".init();");
		appendLine(sb,"});");
		//script end---------------------------------------------------------------------------------
		return sb.toString();
	}

	

}
