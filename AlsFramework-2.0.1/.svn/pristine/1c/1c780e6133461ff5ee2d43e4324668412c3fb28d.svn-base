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
    
    <title>下拉框实例</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script>


	   //单选实例
		var myCombo = new $$.Combo("myCombo");
		myCombo.setConName("SWF_ACTION_TYPE");
		myCombo.setVal("05");

		//多选实例
		var myCombo2 = new $$.Combo("myCombo2");
		myCombo2.setConName("SWF_ACTION_TYPE");
		myCombo2.setMultiple("true");
		myCombo2.setVals("01,03,05");
		myCombo2.setSeparator(",");//多选项分隔符，不设置默认也是逗号
		//初始化
		$(function(){
			myCombo.init();
			myCombo2.init();
		});
	

		function test(){
			alert("text=" + myCombo.getText() + ";val=" + myCombo.getVal());
		}

		function test2(){
			alert("texts=" + myCombo2.getTexts() + ";vals=" + myCombo2.getVals());
		}

	</script>
  </head>
  
<body>

	<!-- text ++++++++++++++++++++++++++++++++++++++ -->
	<input id="myCombo" name="myCombo" />  
	<button onclick="test()">获取选中的值(单选)</button>
	
	<input id="myCombo2" name="myCombo2" />  
	<button onclick="test2()">获取选中的值(多选)</button>
	<!-- text end ++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>
