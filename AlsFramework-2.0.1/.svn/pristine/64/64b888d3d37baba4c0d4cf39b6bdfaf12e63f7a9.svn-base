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
    
    <title>时间框实例</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script>

		var startTimeText = new $$.TimeText("startTimeText");
		startTimeText.setVal("09:30:00");//设置默认值，不设值时自动选择为当天
		//初始化
		$(function(){
			startTimeText.init();
		});
	

		function test(){
			alert( startTimeText.getVal());
		}

	</script>
  </head>
  
<body>

	<!-- text ++++++++++++++++++++++++++++++++++++++ -->
	<input id="startTimeText" />  
	<button onclick="test()">获取选中的值</button>
	<!-- text end ++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>
