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
    
    <title>信息框实例</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script>

		
	$(document).ready(function() {
		alert(ROOT_PATH);
	    $.ajax({
	        url: ROOT_PATH + '/ctr/len/view/abc/people.xml',
	        type: 'post',
	        dataType: 'xml',
	        timeout: 1000,  //设定超时
	        cache: false,   //禁用缓存
	        error: function(xml) {
	            alert("加载XML文档出错!");
	        },
	        success: GetStudentComplete   //设置成功后回调函数
	    });
	});

	//获取XML成功后回调函数
	function GetStudentComplete(xml) {
		$(xml).find("Messages>people").each(function () {
            var ENName = $(this).find("ENName").text();
            var CNName = $(this).find("CNName").text();
            var message = $(this).find("message").text();
            $("#loadXml").append(ENName+CNName+message+"<br>");
        })
	}
	</script>
  </head>
  
<body>

	<div style="margin:10px 10px;">
		
		<div id="loadXml"></div>
	</div>
</body>
</html>
