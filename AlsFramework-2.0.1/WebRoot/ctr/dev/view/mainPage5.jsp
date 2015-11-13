<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="../../../common.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>开发管理员</title>
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
	
	
	
	
<script>
    $(function(){

    	var param = {
    			//pid: "IOA"
    			pid: "ALS",
    			userId: "sdevadmin@00000" //TODO 测试时使用
		};
    	var cmd = new $$.Command();
		var url = ROOT_PATH + "umsmenu/getSecondAndThridLevelMenu";
		//alert("url=" + url);
		cmd.setUrl(url);
		cmd.setParam(param);
		//alert(33333);
		cmd.execute();
		//alert(4444);
		if (cmd.commandSuccess){
			//alert(5555);
			var result = cmd.getResult();
			for (var i = 0, len = result.length; i < len; i++){
				$('#mainMenuAcc').accordion('add', {
		               title: result[i].item.menu_name,
		               content: "<ul id='mainMenuAccTree"+result[i].item.id+"' ></ul>",
		               selected: true,
		               iconCls: result[i].item.icon//e.Icon
		             });
				$.parser.parse();
				getMenuTree(result[i].itemSubTree, result[i].item.id);
			}
			
	       
		}
	});


    function getMenuTree(tree, pid){

		for (var i = 0, len = tree.length; i < len; i++){
			//tree------------------------------------
			$("#mainMenuAccTree" + pid).tree({
                 data: tree,
                 onBeforeExpand:function(node,param){  
                   //$("#mainMenuAccTree" + id).tree('options').url = "/@info/Home/GetTreeByEasyui?id=" + node.id;
                 },   
                 onClick : function(node){  
	                 alert("node=" + node.tex);
                   if (node.state == 'closed'){  
                     $(this).tree('expand', node.target);  
                   }else if (node.state == 'open'){  
                     $(this).tree('collapse', node.target);  
                   }else{
	                 
                     var tabTitle = node.text;
                     alert("tabTitle=" + tabTitle);
                     var url = "../../" + node.attributes;
                     var icon = node.iconCls;
                     addTab(tabTitle, url, icon);
                   }
                 }
               });
			//tree end------------------------------------
		}
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
		<div id="pageLayoutWest" data-options="region:'west',split:true" title="菜单码：" style="width:240px;">
		<!-- west west west west west west west ++++++++++++++++++++++++++++++++++++++++ -->
			<div id="mainMenuAcc" class="easyui-accordion accordion accordion-noborder" fit="true" border="false" style="width: 199px; height: 554px;">
			
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
