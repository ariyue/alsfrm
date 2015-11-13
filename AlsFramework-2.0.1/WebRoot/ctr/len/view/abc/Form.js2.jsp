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
	<e:Btn id="btn" btnClick="test" iconCls="icon-search" text="马上注册"></e:Btn>
	
	<table>
		<tr>
			<td><label>用户名：</label></td>
			<td><e:Text id="userNameText" iconCls="icon-man"></e:Text> </td>
		</tr>
		<tr>
			<td><label>密码：</label></td>
			<td><e:Text id="passwordText" iconCls="icon-lock" type="password"></e:Text> </td>
		</tr>
		<tr>	
			<td><label>姓名：</label></td>
			<td><e:Text id="realNameText"></e:Text> </td>
		</tr>
		<tr>	
			<td><label>出生日期：</label></td>
			<td><e:DateText id="birthDateText"></e:DateText> </td>
		</tr>
		<tr>	
			<td><label>出生时间：</label></td>
			<td><e:TimeText id="brithTimeText"></e:TimeText> </td>
		</tr>
		<tr>	
			<td><label>性别：</label></td>
			<td><e:Combo id="sexComb" conName="SYS_SEXUALITY" val="2"></e:Combo> </td>
		</tr>
	</table>
	<!-- text end ++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>
