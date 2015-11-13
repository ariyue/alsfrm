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
    
    <title>list生成器</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script>


	//alert(ROOT_PATH);
	

	</script>
  </head>
  
<body>

	<!-- text ++++++++++++++++++++++++++++++++++++++ -->
	<ul style="margin:10px; padding:10px;line-height:30px;">
		<li><a href="servlet/AutoUIServlet.svlt?filename=EmlEmailDAO.txt">DAO</a></li>
		<li><a href="servlet/AutoUIServlet.svlt?filename=EmlEmailDAOImpl.txt">DAOImpl</a></li>
		<li><a href="servlet/AutoUIServlet.svlt?filename=EmlEmailBIZ.txt">BIZ</a></li>
		<li><a href="servlet/AutoUIServlet.svlt?filename=EmlEmailBIZImpl.txt">BIZImpl</a></li>
		<li><a href="servlet/AutoUIServlet.svlt?filename=EmlEmailAction.txt">Action</a></li>
		
		<li><a href="servlet/AutoUIServlet.svlt?filename=ListCode.txt">JSP页面--Grid</a></li>
		<li><a href="servlet/AutoUIServlet.svlt?filename=TreeCode.txt">JSP页面--Tree</a></li>
		<li><a href="servlet/AutoUIServlet.svlt?filename=popupCode.txt">JSP页面--弹出框</a></li>
	
	</ul>
	
	<!-- text end ++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>
