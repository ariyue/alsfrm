package com.als.web.tag;

import java.util.ArrayList;
import java.util.List;

import com.als.mod.vo.DataColumnVO;


/**
 * 下拉框数据表格
 * @author Vincent
 *
 */
public class ComboGridTag extends AbsTag {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String onChange;

	public String getOnChange() {
		return onChange;
	}

	public void setOnChange(String onChange) {
		this.onChange = onChange;
	}
	
	private String onHidePanel;
	
	public String getOnHidePanel() {
		return onHidePanel;
	}

	public void setOnHidePanel(String onHidePanel) {
		this.onHidePanel = onHidePanel;
	}

	/**
	 * 值列名
	 */
	private String valField;
	
	public String getValField() {
		return valField;
	}

	public void setValField(String valField) {
		this.valField = valField;
	}

	public String getTextField() {
		return textField;
	}

	public void setTextField(String textField) {
		this.textField = textField;
	}

	/**
	 * 文本列名
	 */
	private String textField;
	
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
	 * vos_zh_CN.xml中的vo是的class值
	 */
	private String clazz;
	
	private List<DataColumnVO> ColumnList = new ArrayList<DataColumnVO>();
	
	public void addColumn(DataColumnVO column){
		this.ColumnList.add(column);
	}
	
	public String getClazz() {
		return clazz;
	}


	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public Boolean getSingleSelect() {
		return singleSelect;
	}


	public void setSingleSelect(Boolean singleSelect) {
		this.singleSelect = singleSelect;
	}


	public Boolean getShowSearchBar() {
		return showSearchBar;
	}


	public void setShowSearchBar(Boolean showSearchBar) {
		this.showSearchBar = showSearchBar;
	}

	private String url;
	private Boolean singleSelect;
	private Boolean showSearchBar;
	

	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String setHolderHtml() {

		return "<input id=\""+this.getId()+"\" name=\""+this.getId()+"\" />";
	}
	
	@Override
	public String generalOutString() {

		StringBuffer sb = new StringBuffer();
		  
		//appendLine(sb, "<input id=\""+this.getId()+"\" name=\""+this.getId()+"\" />");
		//appendLine(sb, "document.writeln(' <input id=\""+this.getId()+"\" name=\""+this.getId()+"\" /> ');");
		//script---------------------------------------------------------------------------------
		//生成占位符
		this.generalHolder(sb);
		//appendLine(sb,"<script type=\"text/javascript\">");
		//创建控件
		appendLine(sb,"var "+ this.getId()+ " = new $$.ComboGrid(\""+this.getId()+"\")");
		
		//服务器事件
		//通过JS的ROOT_PATH + url来确定
		appendLine(sb," "+this.getId()+".setUrl(ROOT_PATH + \""+this.getUrl()+"\");   ");
		//列属性
		appendLine(sb," "+this.getId()+".setColumns(top.topDomainMap[\""+ this.getClazz()+"\"]);  ");
		
		
		
		
		//值列名
		appendLine(sb," "+this.getId()+".setValField(\""+this.getValField()+"\");  ");
		//文本列名
		appendLine(sb," "+this.getId()+".setTextField(\""+this.getTextField()+"\");  ");
		//默认值
		appendLine(sb," "+this.getId()+".setVal(\""+this.getVal()+"\");");
		if (this.getWidth() != null && !this.getWidth().trim().equals("")){
			appendLine(sb," "+this.getId()+".setWidth(\""+this.getWidth()+"\");");
		}
		/*//是否单选
		if (this.getSingleSelect() != null){
			appendLine(sb," "+this.getId()+".setSingleSelect("+ this.getSingleSelect()+");  ");
		} else {
			appendLine(sb," "+this.getId()+".setSingleSelect(true);  ");//默认为单选
		}
		
		if (this.getShowSearchBar() != null){
			appendLine(sb," "+this.getId()+".setShowSearchBar("+ this.getShowSearchBar()+");  ");
		} else {
			appendLine(sb," "+this.getId()+".setShowSearchBar(true); ");
		}*/
		
		
		//隐藏弹出面版事
		if (this.getOnHidePanel()!=null && !this.getOnHidePanel().trim().equals("")){
			appendLine(sb," "+this.getId()+".setOnHidePanelFn(function(val){");
			appendLine(sb," "+this.getOnHidePanel()+"(val)");
			appendLine(sb," });");
		}
		
		//值变化事件
		if (this.getOnChange()!=null && !this.getOnChange().trim().equals("")){
			appendLine(sb," "+this.getId()+".setOnChangeFn(function(newValue, oldValue){");
			appendLine(sb," "+this.getOnChange()+"(newValue, oldValue)");
			appendLine(sb," });");
		}
		
		//查询设值
		appendLine(sb," "+this.getId()+".setQueryParams({});");
		

		//初始化
		appendLine(sb,"$(function(){");
		appendLine(sb," "+this.getId()+".init();");
		appendLine(sb,"});");
		//appendLine(sb, "</script>");
		return sb.toString();
	}

	
	
	
}
