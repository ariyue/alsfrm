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
    
    <title>Layout面版实例</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script type="text/javascript">

	var myLayout;

	$(document).ready(function(){

		myLayout = $('body').layout({
			west__minSize:	50
		,	east__minSize:	200
		});
 
 	});

	
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

</body>
</html>
