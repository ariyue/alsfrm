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
    
    <title>表单实例</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script>

		function test(){
			alert("hello!");
		}

	</script>
  </head>
  
<body>

	<!-- text ++++++++++++++++++++++++++++++++++++++ -->
	<e:Form id="myform">
		<e:Zone id="myZone">
			<e:Row id="row1">
				<e:Fld id="fld1"></e:Fld>
				<e:Fld id="fld2"></e:Fld>
			</e:Row>
			<e:Row id="row2">
				<e:Fld id="fld3"></e:Fld>
				<e:Fld id="fld4"></e:Fld>
			</e:Row>
		</e:Zone>
		
		<e:Zone id="cZone">
			<e:Row id="row3"></e:Row>
			<e:Row id="row4"></e:Row>
		</e:Zone>
	</e:Form>
	<!-- text end ++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>
