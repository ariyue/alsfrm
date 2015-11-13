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
    
    <title>重定向实例</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script>

		
		function test1(){

			var param = {};
			var tstCmd = new $$.Command();
			var url = ROOT_PATH + "alertTest/showInfo";
			tstCmd.setUrl(url);
			tstCmd.setParam(param);
			tstCmd.execute();
		}

	</script>
  </head>
  
<body>

	<div style="margin:10px 10px;">
		<a onclick="test1()" href="javascript:void(0)" class="easyui-linkbutton" id="btn1">后台重定向后的页面B</a>
		
	</div>
</body>
</html>
