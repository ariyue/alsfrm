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
    
    <title>BO自动生成器</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script>
	
	</script>
  </head>
  
<body>

	<!-- text ++++++++++++++++++++++++++++++++++++++ -->
	步骤如下：<p></p><p></p>
	1.采用HibernateTool反向工程生成相应的BO文件<p></p>
	2.继承自com.als.mod.bas.BasEntity，接口：java.io.Serializable<p></p>
	3.对Class进行注解，如下：<p></p>
     @Table(keyColumnName = "trans_code", tableName = "ums_trans_code")
	
	
	<!-- text end ++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>
