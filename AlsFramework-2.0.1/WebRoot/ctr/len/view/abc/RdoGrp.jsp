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
    
    <title>单选组实例</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script>

	    //单选
		function test(){
			alert("text=" + myRdoGrp.getText() + ";val=" + myRdoGrp.getVal());
		}


	</script>
  </head>
  
<body>

	<!-- text ++++++++++++++++++++++++++++++++++++++ -->
	
	
	<e:RdoGrp id="myRdoGrp" conName="MIS_LEAVE_TYPE" val="09"></e:RdoGrp>
	<button onclick="test()">获取选中的值(单选）</button>
	
	<!-- text end ++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>
