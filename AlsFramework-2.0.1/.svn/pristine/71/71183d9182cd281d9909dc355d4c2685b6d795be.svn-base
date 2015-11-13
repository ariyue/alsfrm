<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="../../../../common.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>AlsFrame框架实例</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<style type="text/css">
body {
	font: 12px/20px "微软雅黑", "宋体", Arial, sans-serif, Verdana, Tahoma;
	padding: 0;
	margin: 0;
}
a:link {
 text-decoration: none;
}
a:visited {
 text-decoration: none;
}
a:hover {
 text-decoration: underline;
}
a:active {
 text-decoration: none;
}
.cs-north {
	height:60px;background:#B3DFDA;
}
.cs-north-bg {
	width: 100%;
	height: 100%;
	background: url(themes/gray/images/header_bg.png) repeat-x;
}
.cs-north-logo {
	height: 40px;
	padding: 15px 0px 0px 5px;
	color:#fff;font-size:22px;font-weight:bold;text-decoration:none
}
.cs-west {
	width:200px;padding:0px;border-left:1px solid #99BBE8;
}
.cs-south {
	height:25px;background:url('themes/gray/images/panel_title.gif') repeat-x;padding:0px;text-align:center;
}
.cs-navi-tab {
	padding: 5px;
}
.cs-tab-menu {
	width:120px;
}
.cs-home-remark {
	padding: 10px;
}
</style>
	
<script type="text/javascript">



//----------------------------------
var topDomainMap = {};



function initVOS(){
	//获取所有的VOS
	var qryAllVOCmd = new $$.Command();
	var qryAllVOUrl = ROOT_PATH + "commmainpageaction/initallvos";
	qryAllVOCmd.setUrl(qryAllVOUrl);
	qryAllVOCmd.setParam({});
	qryAllVOCmd.execute();
	if (qryAllVOCmd.commandSuccess){
		//alert(9999);
		topDomainMap = qryAllVOCmd.getResult();
	}	
}
//-------------------------------



function addTab(title, url){
	if ($('#tabs').tabs('exists', title)){
		$('#tabs').tabs('select', title);//选中并刷新
		var currTab = $('#tabs').tabs('getSelected');
		var url = $(currTab.panel('options').content).attr('src');
		if(url != undefined && currTab.panel('options').title != 'Home') {
			$('#tabs').tabs('update',{
				tab:currTab,
				options:{
					content:createFrame(url)
				}
			})
		}
	} else {
		var content = createFrame(url);
		$('#tabs').tabs('add',{
			title:title,
			content:content,
			closable:true
		});
	}
	tabClose();
}
function createFrame(url) {
	var s = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
	return s;
}
		
function tabClose() {
	/*双击关闭TAB选项卡*/
	$(".tabs-inner").dblclick(function(){
		var subtitle = $(this).children(".tabs-closable").text();
		$('#tabs').tabs('close',subtitle);
	})
	/*为选项卡绑定右键*/
	$(".tabs-inner").bind('contextmenu',function(e){
		$('#mm').menu('show', {
			left: e.pageX,
			top: e.pageY
		});

		var subtitle =$(this).children(".tabs-closable").text();

		$('#mm').data("currtab",subtitle);
		$('#tabs').tabs('select',subtitle);
		return false;
	});
}		
//绑定右键菜单事件
function tabCloseEven() {
	//刷新
	$('#mm-tabupdate').click(function(){
		var currTab = $('#tabs').tabs('getSelected');
		var url = $(currTab.panel('options').content).attr('src');
		if(url != undefined && currTab.panel('options').title != 'Home') {
			$('#tabs').tabs('update',{
				tab:currTab,
				options:{
					content:createFrame(url)
				}
			})
		}
	})
	//关闭当前
	$('#mm-tabclose').click(function(){
		var currtab_title = $('#mm').data("currtab");
		$('#tabs').tabs('close',currtab_title);
	})
	//全部关闭
	$('#mm-tabcloseall').click(function(){
		$('.tabs-inner span').each(function(i,n){
			var t = $(n).text();
			if(t != 'Home') {
				$('#tabs').tabs('close',t);
			}
		});
	});
	//关闭除当前之外的TAB
	$('#mm-tabcloseother').click(function(){
		var prevall = $('.tabs-selected').prevAll();
		var nextall = $('.tabs-selected').nextAll();		
		if(prevall.length>0){
			prevall.each(function(i,n){
				var t=$('a:eq(0) span',$(n)).text();
				if(t != 'Home') {
					$('#tabs').tabs('close',t);
				}
			});
		}
		if(nextall.length>0) {
			nextall.each(function(i,n){
				var t=$('a:eq(0) span',$(n)).text();
				if(t != 'Home') {
					$('#tabs').tabs('close',t);
				}
			});
		}
		return false;
	});
	//关闭当前右侧的TAB
	$('#mm-tabcloseright').click(function(){
		var nextall = $('.tabs-selected').nextAll();
		if(nextall.length==0){
			//msgShow('系统提示','后边没有啦~~','error');
			alert('后边没有啦~~');
			return false;
		}
		nextall.each(function(i,n){
			var t=$('a:eq(0) span',$(n)).text();
			$('#tabs').tabs('close',t);
		});
		return false;
	});
	//关闭当前左侧的TAB
	$('#mm-tabcloseleft').click(function(){
		var prevall = $('.tabs-selected').prevAll();
		if(prevall.length==0){
			alert('到头了，前边没有啦~~');
			return false;
		}
		prevall.each(function(i,n){
			var t=$('a:eq(0) span',$(n)).text();
			$('#tabs').tabs('close',t);
		});
		return false;
	});

	//退出
	$("#mm-exit").click(function(){
		$('#mm').menu('hide');
	})
}

$(function() {
	initVOS();
	tabCloseEven();
	$('.cs-navi-tab').click(function() {
		var $this = $(this);
		var href = $this.attr('src');
		var title = $this.text();
		addTab(title, href);
	});

	//TODO 进入主页时自动跳转打开指定面
	//如：http://localhost:8080/AlsFramework-2.0.0/ctr/len/view/abc/mainPageDemo.jsp?loadPath=ctr/len/view/abc/formDemo4.jsp
	var loadPath = "ctr/len/view/abc/formDemo6.jsp";
	if ( !(loadPath == null || loadPath == undefined || loadPath == "")){
		loadTab("用户注册", loadPath);
	}
	
});


function loadTab(title, url){

	addTab(title, url);
}
</script>
  </head>
  
<body class="easyui-layout layout" style="height: 100%; overflow: hidden; border: none; margin: 0px; padding: 0px;">
	<!-- 
	<iframe scrolling="auto" frameborder="0"  src="ctr/len/view/abc/cache.jsp" style="display:none"></iframe>
	 -->
	 	<div data-options="region:'north'" style="height:50px">
			icon
			<div id="topWinHolder">
			
				<div id="topPopInfoWin" class="easyui-window" style="width:300px;height:100px;padding:5px;"  data-options="title:'系统信息',iconCls:'icon-save',closed:true">Some Content.</div>
			</div>
		</div>
		<div data-options="region:'west',split:true" title="Navigation" style="width:240px;">
		<!-- west west west west west west west ++++++++++++++++++++++++++++++++++++++++ -->
			<div class="easyui-accordion accordion accordion-noborder" fit="true" border="false" style="width: 199px; height: 554px;">
				<div title="自动生成" collapsed="false" class="panel-body accordion-body" style="width: 199px; height: 398px; display: block;">
				
					<a href="javascript:void(0);" src="ctr/len/view/auto/AutoBO.jsp" class="cs-navi-tab">1.BO自动生成</a><p></p>
					<a href="javascript:void(0);" src="ctr/len/view/auto/AutoVO.jsp" class="cs-navi-tab">2.VO自动生成</a><p></p>
					<a href="javascript:void(0);" src="ctr/len/view/auto/AutoFormCode.jsp" class="cs-navi-tab">3.UI表单生成</a><p></p>
					<a href="javascript:void(0);" src="ctr/len/view/auto/AutoSelectCode.jsp" class="cs-navi-tab">4.BIZ层SELECT语句生成</a><p></p>
					<a href="javascript:void(0);" src="ctr/len/view/auto/AutoInsertCode.jsp" class="cs-navi-tab">5.BIZ层INSERT语句生成</a><p></p>
					<a href="javascript:void(0);" src="ctr/len/view/auto/AutoUpdateCode.jsp" class="cs-navi-tab">BIZ层UPDATE语句生成</a><p></p>
					
					<a href="javascript:void(0);" src="ctr/len/view/auto/AutoBasCode.jsp" class="cs-navi-tab">7.基础代码模板</a><p></p>
				</div>
				<div title="ALS UI控件" collapsed="false" class="panel-body accordion-body" style="width: 199px; height: 398px; display: block;">
				
					<a href="javascript:void(0);" src="ctr/len/view/abc/Layout.js.jsp" class="cs-navi-tab">页面布局(JS版)</a><p></p>
					
					
					<a href="javascript:void(0);" src="ctr/len/view/abc/Btn.js.jsp" class="cs-navi-tab">按钮(JS版)</a><p></p>
					<a href="javascript:void(0);" src="ctr/len/view/abc/Btn.jsp" class="cs-navi-tab">按钮(标签版)</a><p></p>
					
					<a href="javascript:void(0);" src="ctr/len/view/abc/Text.js.jsp" class="cs-navi-tab">文本框(JS版)</a><p></p>
					<a href="javascript:void(0);" src="ctr/len/view/abc/Text.jsp" class="cs-navi-tab">文本框(标签版)</a><p></p>
					
					<a href="javascript:void(0);" src="ctr/len/view/abc/RdoGrp.js.jsp" class="cs-navi-tab">单选框组(JS版)</a><p></p>
					<a href="javascript:void(0);" src="ctr/len/view/abc/RdoGrp.jsp" class="cs-navi-tab">单选框组(标签版)</a><p></p>
					
					<a href="javascript:void(0);" src="ctr/len/view/abc/ChkGrp.js.jsp" class="cs-navi-tab">复选框组(JS版)</a><p></p>
					<a href="javascript:void(0);" src="ctr/len/view/abc/ChkGrp.jsp" class="cs-navi-tab">复选框组(标签版)</a><p></p>
					
					<a href="javascript:void(0);" src="ctr/len/view/abc/Combo.js.jsp" class="cs-navi-tab">下拉框(JS版)</a><p></p>
					<a href="javascript:void(0);" src="ctr/len/view/abc/Combo.jsp" class="cs-navi-tab">下拉框(标签版)</a><p></p>
					
					<a href="javascript:void(0);" src="ctr/len/view/abc/ComboGrid.js.jsp" class="cs-navi-tab">下拉表格框(JS版)</a><p></p>
					<a href="javascript:void(0);" src="ctr/len/view/abc/ComboGrid.jsp" class="cs-navi-tab">下拉表格框(标签版)</a><p></p>
					
					<a href="javascript:void(0);" src="ctr/len/view/abc/DateText.js.jsp" class="cs-navi-tab">日期框(JS版)</a><p></p>
					<a href="javascript:void(0);" src="ctr/len/view/abc/DateText.jsp" class="cs-navi-tab">日期框(标签版)</a><p></p>
					
					<a href="javascript:void(0);" src="ctr/len/view/abc/TimeText.js.jsp" class="cs-navi-tab">时间框(JS版)</a><p></p>
					<a href="javascript:void(0);" src="ctr/len/view/abc/TimeText.jsp" class="cs-navi-tab">时间框(标签版)</a><p></p>
					
					<a href="javascript:void(0);" src="ctr/len/view/abc/ValidateTest.js.jsp" class="cs-navi-tab">验证(JS版)</a><p></p>
					<a href="javascript:void(0);" src="ctr/len/view/abc/ValidateTest.jsp" class="cs-navi-tab">验证(标签版)</a><p></p>
					
					<a href="javascript:void(0);" src="ctr/len/view/abc/Form.js.jsp" class="cs-navi-tab">综合表单(HTML版)</a><p></p>
					<a href="javascript:void(0);" src="ctr/len/view/abc/Form.jsp" class="cs-navi-tab">综合表单(标签版)</a><p></p>
					
					<a href="javascript:void(0);" src="ctr/len/view/abc/Dialog.js.jsp" class="cs-navi-tab">弹出面版(JS版)</a><p></p>
					<a href="javascript:void(0);" src="ctr/len/view/abc/Dialog.jsp" class="cs-navi-tab">弹出面版(标签版)</a><p></p>
					
					<a href="javascript:void(0);" src="ctr/len/view/abc/AbcUserManager.js.jsp" class="cs-navi-tab">用户管理(JS版)</a><p></p>
					<a href="javascript:void(0);" src="ctr/len/view/abc/AbcUserManager.jsp" class="cs-navi-tab">用户管理(标签版)</a><p></p>
					
					<a href="javascript:void(0);" src="ctr/len/view/abc/AlertTest.jsp" class="cs-navi-tab">信息框实例</a><p></p>
					<a href="javascript:void(0);" src="ctr/len/view/abc/RedirectTestA.jsp" class="cs-navi-tab">后台重定向实例</a><p></p>
					<a href="javascript:void(0);" src="ctr/len/view/abc/OpenNewTabTestA.jsp" class="cs-navi-tab">后台打开tab页</a><p></p>
					
					
					
				</div>
				
				<div title="EasyUI Demo" collapsed="false" class="panel-body accordion-body" style="width: 199px; height: 398px; display: block;">
					<a href="javascript:void(0);" src="ctr/len/view/abc/windowDemo.jsp" class="cs-navi-tab">弹出框(窗) 实例</a><p></p>
					<a href="javascript:void(0);" src="ctr/len/view/abc/formDemo.jsp" class="cs-navi-tab">表单 实例</a><p></p>
					<a href="javascript:void(0);" src="ctr/len/view/abc/formDemo2.jsp" class="cs-navi-tab">表单 实例2</a><p></p>
					<a href="javascript:void(0);" src="ctr/len/view/abc/formDemo3.jsp" class="cs-navi-tab">表单实例3_用户注册</a><p></p>
					<a href="javascript:void(0);" src="ctr/len/view/abc/formDemo4.jsp" class="cs-navi-tab">表单实例3_用户注册2</a><p></p>
					
					<a href="javascript:void(0);" src="ctr/len/view/abc/ButtonAndMenuDemo.jsp" class="cs-navi-tab">按钮和菜单实例</a><p></p>
					<a href="javascript:void(0);" src="ctr/len/view/abc/DatagridDemo.jsp" class="cs-navi-tab">数据表格实例</a><p></p>
					<a href="javascript:void(0);" src="ctr/len/view/abc/EditDatagrid2.jsp" class="cs-navi-tab">可编辑数据表格</a><p></p>
					
					<a href="javascript:void(0);" src="demo/droppable.html" class="cs-navi-tab">droppable</a><p></p>
					<a href="javascript:void(0);" src="demo/droppable1.html" class="cs-navi-tab">droppable1</a><p></p>
					<a href="javascript:void(0);" src="demo/droppable2.html" class="cs-navi-tab">droppable2</a><p></p>
					<a href="javascript:void(0);" src="demo/resizable.html" class="cs-navi-tab">resizable</a><p></p>
					<a href="javascript:void(0);" src="demo/pagination.html" class="cs-navi-tab">pagination</a><p></p>
					<a href="javascript:void(0);" src="demo/searchbox.html" class="cs-navi-tab">searchbox</a><p></p>
					<a href="javascript:void(0);" src="demo/progressbar.html" class="cs-navi-tab">progressbar</a><p></p>
				</div>
				
				<div title="AlsFrame Demo" collapsed="false" class="panel-body accordion-body" style="width: 199px; height: 398px; display: block;">
					<a href="javascript:void(0);" src="ctr/len/view/abc/CommandDemo.jsp" class="cs-navi-tab">CommandDemo</a><p></p>
					<a href="javascript:void(0);" src="demo/draggable.html" class="cs-navi-tab">draggable</a><p></p>
					<a href="javascript:void(0);" src="demo/droppable.html" class="cs-navi-tab">droppable</a><p></p>
					<a href="javascript:void(0);" src="demo/droppable1.html" class="cs-navi-tab">droppable1</a><p></p>
					<a href="javascript:void(0);" src="demo/droppable2.html" class="cs-navi-tab">droppable2</a><p></p>
					<a href="javascript:void(0);" src="demo/resizable.html" class="cs-navi-tab">resizable</a><p></p>
					<a href="javascript:void(0);" src="demo/pagination.html" class="cs-navi-tab">pagination</a><p></p>
					<a href="javascript:void(0);" src="demo/searchbox.html" class="cs-navi-tab">searchbox</a><p></p>
					<a href="javascript:void(0);" src="demo/progressbar.html" class="cs-navi-tab">progressbar</a><p></p>
				</div>
				
				
				
				<div title="AlsFrame框架测试" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
					<a href="javascript:void(0);" src="ctr/len/view/abc/SerialDemo.jsp" class="cs-navi-tab">序列号生成</a><p></p>
					<h3 style="color:#0099FF;">Accordion for jQuery</h3>
					<p>Accordion is a part of easyui framework for jQuery. It lets you define your accordion component on web page more easily.</p>
				</div>
				<div title="Help" data-options="iconCls:'icon-help'" style="padding:10px;">
					<p>The accordion allows you to provide multiple panels and display one or more at a time. Each panel has built-in support for expanding and collapsing. Clicking on a panel header to expand or collapse that panel body. The panel content can be loaded via ajax by specifying a 'href' property. Users can define a panel to be selected. If it is not specified, then the first panel is taken by default.</p> 		
				</div>
				<div title="TreeMenu" data-options="iconCls:'icon-search'" style="padding:10px;">
					<ul class="easyui-tree">
						<li>
							<span>Foods</span>
							<ul>
								<li>
									<span>Fruits</span>
									<ul>
										<li>apple</li>
										<li>orange</li>
									</ul>
								</li>
								<li>
									<span>Vegetables</span>
									<ul>
										<li>tomato</li>
										<li>carrot</li>
										<li>cabbage</li>
										<li>potato</li>
										<li>lettuce</li>
									</ul>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		<!-- west west west west west west west  ++++++++++++++++++++++++++++++++++++++++ -->
		</div>
		<div data-options="region:'center'">
		<!-- center center center center center center center end++++++++++++++++++++++++++++++++++++++++ -->	
			
			<div id="tabs" class="easyui-tabs tabs-container" fit="true" border="false" style="width: 1163px; height: 580px;">
				<div title="Home" style="padding:10px">
					<p style="font-size:14px">jQuery EasyUI framework helps you build your web pages easily.</p>
					<ul>
						<li>easyui is a collection of user-interface plugin based on jQuery.</li>
						<li>easyui provides essential functionality for building modem, interactive, javascript applications.</li>
						<li>using easyui you don't need to write many javascript code, you usually defines user-interface by writing some HTML markup.</li>
						<li>complete framework for HTML5 web page.</li>
						<li>easyui save your time and scales while developing your products.</li>
						<li>easyui is very easy but powerful.</li>
					</ul>
				</div>
			</div>
		<!-- center center center center center center center end++++++++++++++++++++++++++++++++++++++++ -->
		</div>
		
		<div region="south" border="false" class="cs-south panel-body panel-body-noheader panel-body-noborder layout-body" title="" style="width: 1366px; height: 25px;">爱丽丝之家</div>
		
		<!-- 主tab选项卡对应的右键菜单 ++++++++++++++++++++++++++++++ -->
		<div id="mm" class="easyui-menu" style="width:120px;">
			<div id="mm-tabupdate" class="menu-item" >刷新</div>
			<div id="mm-tabclose" class="menu-item" >关闭</div>
			<div id="mm-tabcloseother" class="menu-item" >关闭其他</div>
			<div id="mm-tabcloseall" class="menu-item" >关闭全部</div>
		</div>
		<!-- 主tab选项卡对应的右键菜单 end ++++++++++++++++++++++++++++++ -->
		
		
		
</body>
</html>
