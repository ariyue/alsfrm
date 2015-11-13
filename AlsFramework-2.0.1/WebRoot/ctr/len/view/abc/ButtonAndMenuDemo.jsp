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
    
    <title>按钮和菜单实例</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script>

		function home(){
			alert("你点击了home");
		}
		function edit(){
			alert("你点击edit");
		}

		function ok(){
			alert("你点击了确认ok");
		}

		function help(){
			alert("你点击了help");
		}

	</script>
  </head>
  
<body>
<div style="margin-top:20px;margin-left:20px;">
	<h2>链接按钮</h2>
	<div style="margin:10px 0;">
		<a href="javascript:void(0)" class="easyui-linkbutton" id="dd1">3D</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" id="dd2">Plain</a>
		<br/>
		<a href="javascript:void(0)" class="easyui-splitbutton l-btn" data-options="plain:false,menu:'#mm1',iconCls:'icon-edit'">SplitButton，中间有个竖线，光标在三角下拉图标上才会显示下拉菜单</a>
		<br/>
		<a href="javascript:void(0)" class="easyui-menubutton l-btn" data-options="plain:false,menu:'#mm1',iconCls:'icon-edit'">MenuButton，中间没有竖线,光标一放上去就显示下拉菜单</a>
	</div>
	<h2>按钮工具条</h2>
	<p>Move mouse over the arrow area of button to drop down menu.</p>
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" style="padding:5px;">
		<a href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:false"  onclick="home()" >Home</a>
		<a href="javascript:void(0);" class="easyui-splitbutton" onclick="edit()" data-options="plain:false,menu:'#mm1',iconCls:'icon-edit'">Edit</a>
		<a href="javascript:void(0);" class="easyui-splitbutton" onclick="ok()" data-options="menu:'#mm2',iconCls:'icon-ok'">Ok</a>
		<a href="javascript:void(0);" class="easyui-menubutton" onclick="help()" data-options="menu:'#mm3',iconCls:'icon-help'">Help</a>
	</div>
	<div id="mm1" style="width:150px;">
		<div data-options="iconCls:'icon-undo'">Undo</div>
		<div data-options="iconCls:'icon-redo'">Redo</div>
		<div class="menu-sep"></div>
		<div>Cut</div>
		<div>Copy</div>
		<div>Paste</div>
		<div class="menu-sep"></div>
		<div>
			<span>Toolbar</span>
			<div>
				<div>Address</div>
				<div>Link</div>
				<div>Navigation Toolbar</div>
				<div>Bookmark Toolbar</div>
				<div class="menu-sep"></div>
				<div>New Toolbar...</div>
			</div>
		</div>
		<div data-options="iconCls:'icon-remove'">Delete</div>
		<div>Select All</div>
	</div>
	<div id="mm2" style="width:100px;">
		<div data-options="iconCls:'icon-ok'">Ok</div>
		<div data-options="iconCls:'icon-cancel'">Cancel</div>
	</div>
	<div id="mm3" style="width:150px;">
		<div>Help</div>
		<div>Update</div>
		<div>
			<span>About</span>
			<div class="menu-content" style="padding:10px;text-align:left">
				<img src="http://www.jeasyui.com/images/logo1.png" style="width:150px;height:50px">
				<p style="font-size:14px;color:#444">Try jQuery EasyUI to build your modern, interactive, javascript applications.</p>
			</div>
		</div>
	</div>
</div>
	
	

</body>
</html>
