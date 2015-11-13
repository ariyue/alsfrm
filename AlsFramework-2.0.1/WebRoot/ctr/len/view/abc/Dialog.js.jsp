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
    
    <title>面版实例</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script>

		
		var myDialog = new $$.Dialog("myDialog");
		myDialog.setTitle("弹出框标题");
		myDialog.setWidth("345px");
		myDialog.setHeight("400px");
		
		//初始化
		$(function(){
			myDialog.init();
			
		});
	
		

		function showBtnClick(){
			
			myDialog.show();
			
		}

		function okBtnClick(){
			alert("您输入值为=" + unText.getText());
		}

	

	</script>
  </head>
  
<body style="background:#fff;">

	
	
	<e:Btn id="showBtn" btnClick="showBtnClick" text="showDialog" ></e:Btn>
	<div id="myDialog" class="alsui-dlog">   
		<ul class="alsui-row">
			<li><label class="up">用户名:</label><e:Text id="userNameText2"></e:Text></li>
			<li><label class="up">密码:</label><e:Text id="passwdText2"></e:Text></li>
			<li><e:Btn id="okBtn" btnClick="okBtnClick" text="Test" ></e:Btn></li>
		</ul>
	</div> 
</body>
</html>
