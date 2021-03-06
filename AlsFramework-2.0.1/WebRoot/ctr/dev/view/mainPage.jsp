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
    $(function(){
    	initVOS();
    	$("#pageLayoutWest").append('<div id="mainMenuAcc" class="easyui-accordion accordion accordion-noborder" fit="true" border="false" style="width: 199px; height: 554px;"></div>');
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
				$('#mainMenuAcc').append('<div title="'+result[i].item.menu_name+'" collapsed="false" class="panel-body accordion-body" style="width: 199px; height: 398px; display: block;"><ul id="mainMenuAccTree'+result[i].item.id+'"></ul></div>');
				getMenuTree(result[i].itemSubTree, result[i].item.id);
				/*
				$('#mainMenuAcc').accordion('add', {
		               title: result[i].item.menu_name,
		               content: "<ul id='mainMenuAccTree"+result[i].item.id+"' ></ul>",
		               selected: true,
		               iconCls: result[i].item.icon//e.Icon
		             });
				$.parser.parse();
				getMenuTree(result[i].itemSubTree, result[i].item.id);
				*/
			}
			$.parser.parse($('#mainMenuAcc').parent());
	       
		}
	});

    function getAllMenuTree(){
        }

    function getMenuTree(tree, pid){

		for (var i = 0, len = tree.length; i < len; i++){
			//tree------------------------------------
			$("#mainMenuAccTree" + pid).tree({
                 data: tree,
                 onBeforeExpand:function(node,param){  
                   //$("#mainMenuAccTree" + id).tree('options').url = "/@info/Home/GetTreeByEasyui?id=" + node.id;
                 },   
                 onDblClick: function (node) {  
               	    $(this).tree(node.state === 'closed' ? 'expand' : 'collapse', node.target);  
              	    node.state = node.state === 'closed' ? 'open' : 'closed';  
              	},
                onClick : function(node){ 
					if(node.attributes.menu_url != null && node.attributes.menu_url != ""){//非文件夹
						var tabTitle = node.text;
                      	var url = ROOT_PATH + node.attributes.menu_url;
                        var icon = node.iconCls;
                        addTab(tabTitle, url, icon);
                     }
                }
            });
             
			//tree end------------------------------------
		}
    }

    // tab-------------------------------------------------------------
    $(function() {
		tabCloseEven();
	
		//TODO 进入主页时自动跳转打开指定面
		//如：http://localhost:8080/AlsFramework-2.0.0/ctr/len/view/abc/mainPageDemo.jsp?loadPath=ctr/len/view/abc/formDemo4.jsp
		var loadPath = "ctr/len/view/abc/formDemo4.jsp";
		if ( !(loadPath == null || loadPath == undefined || loadPath == "")){
			loadTab("用户注册", loadPath);
		}
		
	});
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
//tab-------------------------------------------------------------
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
		<!-- 
			<div id="mainMenuAcc" class="easyui-accordion accordion accordion-noborder" fit="true" border="false" style="width: 199px; height: 554px;">
			
			</div>
		 -->
		<!-- west west west west west west west  ++++++++++++++++++++++++++++++++++++++++ -->
		</div>
		<div data-options="region:'center'">
		<!-- center center center center center center center end++++++++++++++++++++++++++++++++++++++++ -->	
			
			<div id="tabs" class="easyui-tabs tabs-container" fit="true" border="false" style="width: 1163px; height: 580px;">
				<div title="桌面" style="padding:10px">
					<p style="font-size:14px">欢迎您，Vincent.</p>
					<ul>
						<li>待处理任务</li>
						<li>消息提醒</li>
						<li>新闻公告</li>
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
