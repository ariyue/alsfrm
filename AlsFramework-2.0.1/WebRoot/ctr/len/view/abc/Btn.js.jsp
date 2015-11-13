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
    
    <title>按钮实例</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script>

		var btn = new $$.Btn("btn");
		btn.setIconCls("icon-search");
		btn.setText("我是按钮");
		//btn.setDisabled(true);
		btn.setBtnClickFn(function(){
			test();
		});
		//startDateText.setVal("2014-10-01");//设置默认值，不设值时自动选择为当天
		//初始化
		$(function(){
			btn.init();
			  
		});
	

		function test(){
			alert("hello!");
		}

	</script>
  </head>
  
<body>

	<!-- text ++++++++++++++++++++++++++++++++++++++ -->
	<a id="btn" href="javascrpt:;"></a> 
	<!-- text end ++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>
