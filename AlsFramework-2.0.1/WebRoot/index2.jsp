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
