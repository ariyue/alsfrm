package com.als.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

import com.als.mod.vo.DataColumnVO;

/**
 * 表格中的列
 * @author Vincent
 *
 */
public class ColTag extends TagSupport {

	private String field;
	private String title;
	private String type;
	private String sortable;
	private String align;
	private String checkbox;
	private String width;
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSortable() {
		return sortable;
	}

	public void setSortable(String sortable) {
		this.sortable = sortable;
	}

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}

	public String getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(String checkbox) {
		this.checkbox = checkbox;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	@Override
	public int doStartTag() throws JspTagException {
		return EVAL_PAGE;
	}

	@Override
	public int doEndTag() throws JspException {
		
		GridTag p = (GridTag) this.getParent();
		DataColumnVO column = new DataColumnVO();
		column.setAlign(align);
		column.setCheckbox(checkbox);
		column.setField(field);
		column.setSortable(sortable);
		column.setTitle(title);
		column.setType(type);
		column.setWidth(width);
		//调用父标签的addColumn方法，给父标签中的column赋值
		p.addColumn(column);
		//return EVAL_BODY_INCLUDE;
		return EVAL_PAGE;
	}
}
