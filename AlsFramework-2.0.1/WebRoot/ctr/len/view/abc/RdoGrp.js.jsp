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
    
    <title>单选按钮组实例</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script>

		var myRdoGrp = new $$.RdoGrp("myRdoGrp");
		myRdoGrp.setConName("SWF_ACTION_TYPE");
		myRdoGrp.setVal("06");//默认中选项
		myRdoGrp.setItemClickFn(function(checked, code ,text){
			alert("当前单击选项=" + checked + ";code=" + code + "; text=" + text);
		});
		//初始化
		$(function(){
			myRdoGrp.init();
		});
	
		function test(){
			var val = myRdoGrp.getVal();
			var text = myRdoGrp.getText();
			alert("val=" + val + ";text=" + text);
		}

	</script>
  </head>
  
<body>

	<!-- text ++++++++++++++++++++++++++++++++++++++ -->
	<div id="myRdoGrp"></div>
	<e:Btn id="aaaa" text="TEST" btnClick="test"></e:Btn>

  	
	<!-- text end ++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>
