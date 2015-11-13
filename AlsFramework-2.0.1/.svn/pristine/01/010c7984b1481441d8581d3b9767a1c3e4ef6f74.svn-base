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
    
    <title>序列号实例</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script type="text/javascript">

	
	function testJson(){

		var param = {
				staDateTime: "2015-05-28",
				endDateTime: "2016-05-28",
				siteList:JSONUtil.encode([{txt:"建阳", val: "jy"},
						{txt:"北京", val: "bj"}
					  
					  ])
		};
		//alert(1111);
		var tstCmd = new $$.Command();
		//alert(22222);
		var url = ROOT_PATH + "abcUser/testGetTransNo";
		//alert("url=" + url);
		tstCmd.setUrl(url);
		tstCmd.setParam(param);
		//alert(33333);
		tstCmd.execute();
		//alert(4444);
		if (tstCmd.commandSuccess){
			var result = tstCmd.getResult();

			$("#resultDIV").html (result);
		}
	}

	function testJson2(){

		var data = {
				staDateTime: "2015-05-28",
				endDateTime: "2016-05-28",
				siteList:JSONUtil.encode([{txt:"建阳", val: "jy"},
						{txt:"北京", val: "bj"}
					  
					  ])
		} 
		// alert(11111);
		 var dt = $.param(data, true);
		 var url = ROOT_PATH + "user/commadTest.do";
		// alert(22222);
		$.ajax({
				type : "POST",
				url : url,
				data : dt,         //要传递的数据
				dataType : "json",//此处要设置成json   
				success : function(result){
					var resultData = result.resultData;
					alert("code=" + resultData.resutCode + ";msg=" + resultData.resutMsg);
					var userList = resultData.resutDataList;
					alert("userId=" + userList[0].userId + ";userName=" +  userList[0].userName);
				}
			});
	}
	




	
 	

	</script>
  </head>
  
<body>
	<input type="button" id ="jsonTestBtn" onclick="testJson()" value="获取新的序列号" />
	<div id="resultDIV">
	
	</div>
	
</body>
</html>
