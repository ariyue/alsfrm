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
    
    <title>日期选择实例</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script>

		//初始化
		$(function(){
			//myCombo.init();
			$('#dateText').datebox({    
			    value: "2014-10-01"   
			}); 
		});
	

		function test(){
			alert( $('#dateText').datebox('getValue'));
		}

	</script>
  </head>
  
<body>

	<!-- text ++++++++++++++++++++++++++++++++++++++ -->
	<input id="dateText" type="text"></input> 
	<button onclick="test()">获取选中的值</button>
	<!-- text end ++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>
