<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<script>

		
	//$(document).ready(function() {
		alert(ROOT_PATH);
	    $.ajax({
	        url: ROOT_PATH + '/ctr/len/view/abc/people.xml',
	        type: 'post',
	        async: false,
	        dataType: 'xml',
	        timeout: 1000,  //设定超时
	        cache: false,   //缓存
	        error: function(xml) {
	            alert("加载XML文档出错!");
	        },
	        success: GetStudentComplete   //设置成功后回调函数
	    });
	//});

	//获取XML成功后回调函数
	function GetStudentComplete(xml) {
		$(xml).find("Messages>people").each(function () {
            var ENName = $(this).find("ENName").text();
            var CNName = $(this).find("CNName").text();
            var message = $(this).find("message").text();
            //$("#loadXml").append(ENName+CNName+message+"<br>");
            alert("cnname=" + CNName);
        })
	}
	</script>
  </head>
  
<body>
</body>
</html>
