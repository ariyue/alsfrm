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
	        url: ROOT_PATH + '/ctr/len/view/abc/Student.xml',
	        type: 'GET',
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
	    $(xml).find("student").each(function(i) {     //查找所有student节点并遍历
	        var id = $(this).children("id");          //获得子节点
	        var id_vaule = id.text();                 //获取节点文本
	        var email_vaule = $(this).attr("email");  //获取节点的属性
	        alert(id_vaule);
	        alert(email_vaule);
	    });
	}
	</script>
  </head>
  
<body>

	<div style="margin:10px 10px;">
		刷新页面看效果
	</div>
</body>
</html>
