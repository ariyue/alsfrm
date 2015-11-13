package com.als.web.tag;

import java.util.ArrayList;
import java.util.List;

import com.als.mod.vo.DataColumnVO;


/**
 * 数据表格
 * @author Vincent
 *
 */
public class GridTag extends AbsTag {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * vos_zh_CN.xml中的vo是的class值
	 */
	private String clazz;
	
	/**
	 * 工具条
	 */
	private String toolbar;
	
	public String getToolbar() {
		return toolbar;
	}

	public void setToolbar(String toolbar) {
		this.toolbar = toolbar;
	}


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


	/**
	 * 行双击事件
	 */
	private String dblRowClick;

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

	public String getLoadSuccess() {
		return loadSuccess;
	}

	public void setLoadSuccess(String loadSuccess) {
		this.loadSuccess = loadSuccess;
	}


	/**
	 * 加载数据成功后事件
	 */
	private String loadSuccess;
	
	/**
	 * 行单击事件
	 */
	private String rowClick;
	
	


	public String getRowClick() {
		return rowClick;
	}

	public void setRowClick(String rowClick) {
		this.rowClick = rowClick;
	}

	public String getDblRowClick() {
		return dblRowClick;
	}

	public void setDblRowClick(String dblRowClick) {
		this.dblRowClick = dblRowClick;
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

		return "<table id=\""+ this.getId()+"\" class=\"easyui-datagrid\"></table>";
	}
	
	@Override
	public String generalOutString() {
		StringBuffer sb = new StringBuffer();
		//appendLine(sb, "<table id=\""+ this.getId()+"\" class=\"easyui-datagrid\"></table>");
		//appendLine(sb, "document.writeln(' <table id=\""+ this.getId()+"\" class=\"easyui-datagrid\"></table> ');");
		//生成占位符
		this.generalHolder(sb);
		//script---------------------------------------------------------------------------------
		//appendLine(sb,"<script type=\"text/javascript\">");
		//创建控件
		appendLine(sb,"var "+ this.getId()+ " = new $$.Grid(\""+this.getId()+"\")");
		
		//服务器事件
		//通过JS的ROOT_PATH + url来确定
		appendLine(sb," "+this.getId()+".setUrl(ROOT_PATH + \""+this.getUrl()+"\");   ");
		//列属性
		appendLine(sb," "+this.getId()+".setColumns(top.topDomainMap[\""+ this.getClazz()+"\"]);  ");
		//是否单选
		if (this.getSingleSelect() != null){
			appendLine(sb," "+this.getId()+".setSingleSelect("+ this.getSingleSelect()+");  ");
		} else {
			appendLine(sb," "+this.getId()+".setSingleSelect(true);  ");//默认为单选
		}
		
		if (this.getShowSearchBar() != null){
			appendLine(sb," "+this.getId()+".setShowSearchBar("+ this.getShowSearchBar()+");  ");
		} else {
			appendLine(sb," "+this.getId()+".setShowSearchBar(true); ");
		}
		
		//toolbar
		if (this.getToolbar() != null){
			appendLine(sb," "+this.getId()+".setToolbar(\""+ this.getToolbar()+"\");  ");
		}
		
		
		//查询设值
		appendLine(sb," "+this.getId()+".setQueryParams({});");
		
		//行双击事件
		if (this.getDblRowClick()!=null && !this.getDblRowClick().trim().equals("")){
			appendLine(sb," "+this.getId()+".setDblRowClickFn(function(rowIndex, rowData){");
			appendLine(sb," "+this.getDblRowClick()+"(rowIndex, rowData)");
			appendLine(sb," });");
		}
		
		if (this.getRowClick()!=null && !this.getRowClick().trim().equals("")){
			appendLine(sb," "+this.getId()+".setRowClickFn(function(rowIndex, rowData){");
			appendLine(sb," "+this.getRowClick()+"(rowIndex, rowData)");
			appendLine(sb," });");
		}
		
		if (this.getBeforeLoad()!=null && !this.getBeforeLoad().trim().equals("")){
			appendLine(sb," "+this.getId()+".setOnBeforeLoadFn(function(param){");
			appendLine(sb," "+this.getBeforeLoad()+"(param)");
			appendLine(sb," });");
		}
		
		if (this.getLoadSuccess()!=null && !this.getLoadSuccess().trim().equals("")){
			appendLine(sb," "+this.getId()+".setOnLoadSuccessFn(function(data){");
			appendLine(sb," "+this.getLoadSuccess()+"(data)");
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
