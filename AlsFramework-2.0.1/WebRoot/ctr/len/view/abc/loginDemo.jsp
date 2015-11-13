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
    
    <title>登陆实例</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script type="text/javascript">


	
  $(function(){

	  var html = '<div style="font-weight:700;margin-top:16px;font-size:14px;margin-bottom:8px;color:#333;">用户名:</div>\
				<input id="userNameTB" class="easyui-textbox" style="width:100%;height:40px;padding:12px" data-options="prompt:\'请输入用户名... ...\',iconCls:\'icon-man\',iconWidth:38">\
				<div style="font-weight:700;margin-top:16px;font-size:14px;margin-bottom:8px;color:#333;">密码:</div>\
				<input id="passwordTB" class="easyui-textbox" type="password" style="width:100%;height:40px;padding:12px" data-options="prompt:\'请输入密码... ...\',iconCls:\'icon-lock\',iconWidth:38">\
				<div style="font-weight:700;margin-top:16px;font-size:14px;margin-bottom:8px;color:#333;text-align:center;">\
				<a href="javascript:;" class="easyui-linkbutton"  iconCls="icon-ok" onclick="login()">登陆</a>\
				<a href="javascript:;" class="easyui-linkbutton"  iconCls="icon-reload" onclick="reset()">重置</a></div>';

		 appWin("用户登陆", html, 440, 260);

	  
   });

  function login(){

	  var userName = $('#userNameTB').textbox('getValue');
	  var password = $('#passwordTB').textbox('getValue');
	  alert(userName + ";"+ password);
  }
  function reset(){

	  	$('#userNameTB').textbox('setValue', '');
	  	$('#passwordTB').textbox('setValue', '');
  }
	</script>
  </head>
  
<body>
	<div id="topPopInfoWin" class="easyui-window" style="width:300px;height:100px;padding:5px;"  data-options="title:'系统信息',iconCls:'icon-save',closed:true"></div>
</body>
</html>
