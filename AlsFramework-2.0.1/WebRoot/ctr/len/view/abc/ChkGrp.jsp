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
    
    <title>复选组实例</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script>

        // 多选
		function test2(){
			alert("texts=" + myChkGrp.getTexts() + ";vals=" + myChkGrp.getVals());
		}

	</script>
  </head>
  
<body>

	<!-- text ++++++++++++++++++++++++++++++++++++++ -->
	
	<e:ChkGrp id="myChkGrp" conName="MIS_LEAVE_TYPE"  vals="03,07,09"></e:ChkGrp>
	<button onclick="test2()">获取选中的值（多选）</button>
	<!-- text end ++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>
