package com.als.web.tag;



public class ZoneTag extends AbsTag implements IContainer{

	private static final long serialVersionUID = 1L;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private String getIconId(){
		return this.getId() + "Icon";
	}
	/**
	 * 标题　
	 */
	private String title;
	@Override
	public String setHolderHtml() {
		
		String html = "<div class=\"alsui-zone\"><div class=\"alsui-zone-hd\"><i title=\""+this.getTitle()+"\" id=\""+this.getIconId()+"\" style=\"padding-left:20px; margin: 0px 5px;width:auto;\" class=\"als-icon als-icon-down alsui-zone-t\">"+this.getTitle()+"</i></div><div id=\""+this.getId()+"\"class=\"alsui-zone-bd\"></div></div>";
		return html;//"<div><div class=\"alsui-zone-hd\">"+this.getTitle()+"</div><div class=\"alsui-zone-bd\"  id=\""+this.getId()+"\"></div></div>";
	}
	
	@Override
	public String generalOutString() {
		
		StringBuffer sb = new StringBuffer();
		//生成占位符
		this.generalHolder(sb);
		
		//初始化
		appendLine(sb,"$(function(){");
		appendLine(sb, " $(\"#"+this.getIconId()+"\").bind(\"click\", function(){  ");
		
		//TODO 含有隐藏信息 要进行国际化
		appendLine(sb, " var hideMsg = \"<font color=red>(含有隐藏信息)</font>\"; ");
		appendLine(sb, " if ($(this).hasClass(\"als-icon-down\")){ ");
		appendLine(sb, " $(this).removeClass(\"als-icon-down\").addClass(\"als-icon-right\").html($(this).attr(\"title\") + hideMsg); ");
		appendLine(sb, " $(\"#"+this.getId()+"\").hide(300); ");
		appendLine(sb, " }else { ");
		appendLine(sb, " $(this).removeClass(\"als-icon-right\").addClass(\"als-icon-down\").html($(this).attr(\"title\"));  ");
		appendLine(sb, " $(\"#"+this.getId()+"\").show(300); ");
		appendLine(sb, " } ");
		appendLine(sb, " }); ");
		appendLine(sb, "  ");
		//$("#myZone1Icon").bind("click", function(){
			//var hideMsg = "<font color=red>(含有隐藏信息)</font>";
			//if ($(this).hasClass("als-icon-down")){
				//$(this).removeClass("als-icon-down").addClass("als-icon-right").html($(this).attr("title") + hideMsg);
				//$("#myZone1").hide(300);
			//}else {
				//$(this).removeClass("als-icon-right").addClass("als-icon-down").html($(this).attr("title"));
				//$("#myZone1").show(300);
			//}
		//});
		appendLine(sb,"});");
		
		//生成子元素
		this.generalSubOut(sb, this.childList);
		
		return sb.toString();
	}

	
}
