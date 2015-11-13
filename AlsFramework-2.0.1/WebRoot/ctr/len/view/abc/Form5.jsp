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

		function onSubmitBtnClick(){
			alert(text1.getValue());
		}

	</script>
  </head>
  
<body>

	<!-- text ++++++++++++++++++++++++++++++++++++++ -->
	<e:Form id="myform">
		<e:Zone title="用户期本信息">
			<e:Row>
				<e:Btn id="submitBtn" text="提交" btnClick="onSubmitBtnClick"></e:Btn>
			</e:Row>
			<e:Row>
				<e:Fld>
					<e:Text id="text1" label="userNameaabb:"></e:Text>
				</e:Fld>
				<e:Fld id="fld22">
					<e:Text id="text2" label="userName:"></e:Text>
				</e:Fld>
			</e:Row>
			<e:Row>
				<e:Fld>
					<e:Text id="text3" label="userName:"></e:Text>
				</e:Fld>
				<e:Fld>
					<e:Text id="text4" label="userName:"></e:Text>
				</e:Fld>
			</e:Row>
			<e:Row>
				<e:Fld></e:Fld>
				<e:Fld></e:Fld>
			</e:Row>
		</e:Zone>
		<e:Zone title="联系方式">
			<e:Row>
				<e:Fld>
					<e:Text id="text51" label="userName:"></e:Text>
				</e:Fld>
				<e:Fld>
					<e:Text id="text52" label="userName:"></e:Text>
				</e:Fld>
			</e:Row>
			<e:Row>
				<e:Fld>
					<e:Text id="text63" label="userName:"></e:Text>
				</e:Fld>
				<e:Fld>
					<e:Text id="text64" label="userName:"></e:Text>
				</e:Fld>
			</e:Row>
		</e:Zone>
	</e:Form>
	<!-- text end ++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>
