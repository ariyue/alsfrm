package com.als.web.tag;


public class Tag模板 extends AbsTag implements IElement,IContainer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	
	@Override
	public String setHolderHtml() {

		return "<input id=\""+this.getId()+"\" name=\""+this.getId()+"\" /> ";
	}

	@Override
	public String generalOutString() {
		StringBuffer sb = new StringBuffer();
		//生成占位符
		this.generalHolder(sb);
		//--------your code---------------------------------------------------
		
		//--------your code end---------------------------------------------------
		//生成子元素
		this.generalSubOut(sb, this.childList);
		return sb.toString();
	}






	

}
