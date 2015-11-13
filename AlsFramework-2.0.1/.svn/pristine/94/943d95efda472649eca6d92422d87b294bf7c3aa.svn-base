<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="als/skin/default/layout-default.css">
	<script type="text/javascript" src="als/lib/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="als/lib/jquery-ui.js"></script>
	<script type="text/javascript" src="als/lib/jquery.layout.js"></script>
	<script type="text/javascript" src="als/lib/json2.js"></script>
	<script type="text/javascript" src="als/lib/JSONUtil.js"></script>

	<script type="text/javascript">

	var myLayout;

	$(document).ready(function(){

		myLayout = $('body').layout({
			west__minSize:	50
		,	east__minSize:	200
		});
 
 	});

	function testJson(){

		var data = {
				staDateTime: "2015-05-28",
				endDateTime: "2016-05-28",
				siteList:JSONUtil.encode([{txt:"建阳", val: "jy"},
						{txt:"北京", val: "bj"}
					  
					  ])
		} 
		// alert(11111);
		 var dt = $.param(data, true);
		// alert(22222);
		$.ajax({
				type : "POST",
				url : "http://localhost:8080/AlsFramework-2.0.0/user/testJson.do",
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




	
 	function save(){

 		 $.ajaxSetup({  
 	        contentType : 'application/json'
 	    })
		var data = {
				userId: "A" + Math.random(),
				userName: "王9ttt9",
				password:"123456"
				};

		//alert(5555);
		//http://localhost:8080/AlsFramework-2.0.0/user/query.do
 		 $.ajax({
   			type : "POST",
   			url : "http://localhost:8080/AlsFramework-2.0.0/user/save",
   			data : JSON.stringify(data),//$.param(data, true),         //要传递的数据
   			dataType : "json", 
   			contentType:"application/json",
   			success : function(res){
   				
   				alert("结果＝" + res.result);
   				
   			}
   		});

 	 }


 	function saveList(){

		 $.ajaxSetup({  
	        contentType : 'application/json'
	    })
	    
	    var list = [];
		var user1 = {
				userId: "chemy1",
				userName: "张三",
				password:"123456"
				};
		
		var user2 = {
				userId: "coco1",
				userName: "李四",
				password:"77777"
				};

		list.push(user1);
		list.push(user2);

		
		 $.ajax({
  			type : "POST",
  			url : "http://localhost:8080/AlsFramework-2.0.0/user/saveList",
  			data : JSON.stringify(list),//$.param(data, true),         //要传递的数据
  			dataType : "json", 
  			contentType:"application/json",
  			success : function(result){
  				
  				var dataList = result;
  				
  			}
  		});

	 }

	</script>
  </head>
  
<body>

<!-- manually attach allowOverflow method to pane -->
<div class="ui-layout-north"> North </div>

<div class="ui-layout-west">West
	<p><button onclick="myLayout.close('west')">Close Me</button></p>
</div>

<div class="ui-layout-south"> South
	<p><button onclick="myLayout.toggle('north')">Toggle North Pane</button></p>
</div>

<div class="ui-layout-east"> East
	<p><button onclick="myLayout.close('east')">Close Me</button></p>

	<p>...</p><p>...</p><p>...</p><p>...</p><p>...</p><p>...</p><p>...</p><p>...</p><p>...</p>
	<p>...</p><p>...</p><p>...</p><p>...</p><p>...</p><p>...</p><p>...</p><p>...</p><p>...</p>
	<p>...</p><p>...</p><p>...</p><p>...</p><p>...</p><p>...</p><p>...</p><p>...</p><p>...</p>
	<p>...</p><p>...</p><p>...</p><p>...</p><p>...</p><p>...</p><p>...</p><p>...</p><p>...</p>
</div>

<div class="ui-layout-center">

	<input type="button" id ="saveBtn" onclick="save()" value="saveUser" />
	
	<input type="button" id ="saveListBtn" onclick="saveList()" value="saveUserList" />
	
	<input type="button" id ="jsonTestBtn" onclick="testJson()" value="JSON测试" />
	 
	This center pane auto-sizes to fit the space <I>between</I> the 'border-panes'
	<p>This layout uses default options, except for a minSize on East and West panes</p>
	<p>The Close and Toggle buttons are examples of <B>custom buttons</B></p>
	<p><a href="http://layout.jquery-dev.com/demos.cfm">UI Layout Demos page</a></p>
	<p>...</p><p>...</p><p>...</p><p>...</p><p>...</p><p>...</p><p>...</p><p>...</p><p>...</p>
	<p>...</p><p>...</p><p>...</p><p>...</p><p>...</p><p>...</p><p>...</p><p>...</p><p>...</p>
	<p>...</p><p>...</p><p>...</p><p>...</p><p>...</p><p>...</p><p>...</p><p>...</p><p>...</p>
	<p>...</p><p>...</p><p>...</p><p>...</p><p>...</p><p>...</p><p>...</p><p>...</p><p>...</p>
</div>
   hello svn!
</body>
</html>
