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
    
    <title>文本框实例</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script>


		function textBtnClick(val){
			alert("您输入值为=" + val);
		}

		function okBtnClick(){
			alert("您输入值为userNameText=" + userNameText.getText());
		}

		function setBtnClick(){
			userNameText.setReadOnly("false");
		}

	</script>
  </head>
  
<body>

	<!-- text ++++++++++++++++++++++++++++++++++++++ -->
	<e:Text id="userNameText" label="用户名:"  readOnly="true"></e:Text>
	<e:SearchText id="searchText" btnClick="textBtnClick" label="搜索:"></e:SearchText>
	 <e:Btn id="okBtn" btnClick="okBtnClick" text="Test" ></e:Btn>
	 <e:Btn id="setBtn" btnClick="setBtnClick" text="用户名设为可输" ></e:Btn>
	<!-- text end ++++++++++++++++++++++++++++++++++++++ -->
	
</body>
</html>
