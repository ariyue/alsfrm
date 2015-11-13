package com.als.web.tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import com.als.frm.comm.util.MessageUtil;
import com.als.frm.comm.util.SpringBeanUtil;
import com.als.frm.comm.util.UuidUtil;

public abstract class AbsTag extends TagSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 子元素列表
	 */
	protected List<AbsTag> childList = new ArrayList<AbsTag>();
	public void addChild(AbsTag tag){
		childList.add(tag);
	}
	
	public String generalI18nMsg(String key, Object[] params) {

		MessageSource messageSource = (MessageSource) SpringBeanUtil.getBean("messageSource");
		try {
			String msg = MessageUtil.getMessage(key, params, true);
			return msg;
		} catch (NoSuchMessageException e) {
			return key;
		}
	}
	
	
	/**
	 * 控件ID,字母数字下划线组可，不可重，以防意外
	 */
	private String id;

	public String getId() {
		if (this.id == null || this.id.equals("")){
			this.setId(UuidUtil.create());
		}
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	private String style="";
	
	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	/**
	 * 控件ID,字母数字下划线组可，不可重，以防意外
	 */
	private String pId;
	
	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public void appendLine(StringBuffer sb,String str) {
		String format = "\r\n"; //调试  格式化
		sb.append(str).append(format);
	}
	
	/**
	 * 生成子元素
	 * @param sb
	 */
	public void generalSubOut(StringBuffer sb, List<AbsTag> childList) {

		for (int i = 0, len = childList.size(); i < len; i ++){
			AbsTag z = childList.get(i);
			appendLine(sb, z.generalOutString());
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public int doStartTag() throws JspTagException {
		
		
		AbsTag pTag = (AbsTag) this.getParent();
		//调用父标签的addValue方法，给父标签中的map赋值
		if (pTag != null){
			try {		
				Class clazz = Class.forName(this.getClass().getName());
				AbsTag o=(AbsTag) clazz.newInstance();//根据类型和方法名字符串进行调用
				
				PropertyUtils.copyProperties(o, this);
			/*	if (o.id == null || o.id.equals("")){
					o.setId(UuidUtil.create());
				}*/
				o.setpId(pTag.getId());
				appInstance(o, pTag, 0);				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			this.childList.clear();
			//this.setTagCreIndex(0);
		}
		
		return EVAL_BODY_INCLUDE;
	}
	
	private void appInstance(AbsTag o, AbsTag pTag, int level){
		AbsTag gpTag = (AbsTag) pTag.getParent();
		if (gpTag != null){
			level ++;
			appInstance(o, gpTag, level);

		} else {
			adddf(o, pTag, level);
		}
	}
	
	
	private void adddf(AbsTag o,AbsTag topTag, int level){
		
		
		if(level == 0){
			topTag.addChild(o);
		} else {
			level --;
			AbsTag t = topTag.childList.get(topTag.childList.size() -1);
			adddf(o,t, level);
		}
	}
	
	/**
	 * 生成输出
	 * @return
	 */
	public abstract String generalOutString();
	
	
	/**
	 * 设置占位html元素(this.id设置给子元素的父级，期它的ID接一定的规则进行设置)
	 * @return
	 */
	
	public abstract String setHolderHtml();
	public void generalHolder(StringBuffer sb){
		
		if (this.getpId() != null && !this.getpId().trim().equals("")){
			appendLine(sb, "$('#"+this.getpId()+"').append('"+this.setHolderHtml()+"')");
		} else {
			appendLine(sb, "document.writeln('"+this.setHolderHtml()+" ');");
		}
	}
	
	
	@Override
	public int doEndTag() throws JspException {
		
		Object pTag = this.getParent();
		try {
			//Boolean b = pTag instanceof IContainer;
			//if (!(pTag instanceof IContainer)){//父对象不是容器对象
			if (!(pTag instanceof IContainer)){//父对象不是容器对象
				
				JspWriter out = this.pageContext.getOut();
				//out.clearBuffer();
				StringBuffer sb = new StringBuffer();
				appendLine(sb,"<script type=\"text/javascript\">");
				appendLine(sb, this.generalOutString());
				appendLine(sb, "</script>");
				out.print(sb.toString());
				out.flush();
			} else {
				//((AbsTag)pTag).addChild(this);
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new JspException(e.getMessage());
		}
		//return EVAL_BODY_INCLUDE;
		//release();
		return EVAL_PAGE;
	}

}
