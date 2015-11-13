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

	    //单选
		function test(){
			alert("text=" + myCombo.getText() + ";val=" + myCombo.getVal());
		}

        // 多选
		function test2(){
			alert("texts=" + myCombo2.getTexts() + ";vals=" + myCombo2.getVals());
		}
		//录下拉值变化时
		function onMyChange(newValue, oldValue){

			alert("newValue=" + newValue + ";oldValue=" + oldValue);
		}

	</script>
  </head>
  
<body>

	<!-- text ++++++++++++++++++++++++++++++++++++++ -->
	<e:Combo id="myCombo" conName="MIS_LEAVE_TYPE" val="09"></e:Combo>
	<button onclick="test()">获取选中的值(单选）</button>
	
	<e:Combo id="myCombo2" conName="MIS_LEAVE_TYPE" multiple="true" vals="03,07,09" onChange="onMyChange"></e:Combo>
	<button onclick="test2()">获取选中的值（多选）</button>
	<!-- text end ++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>
