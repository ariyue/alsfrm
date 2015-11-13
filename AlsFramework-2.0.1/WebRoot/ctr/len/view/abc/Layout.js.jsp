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
    
    <title>AlsFrame框架实例</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

</style>
	
<script type="text/javascript">


</script>
  </head>
  
<body class="easyui-layout layout" style="height: 100%; overflow: hidden; border: none; margin: 0px; padding: 0px;">
	 	
	 	<!-- north north north north north north north++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
	 	<div data-options="region:'north'" style="height:50px">
			
			top panel 上 头部
			
		</div>
		<!-- north north north north north north north end+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		
		
		
		<!-- west west west west west west west++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<div data-options="region:'west',split:true" style="width:240px;">
		
			west panel 左 
		
		</div>
		<!-- west west west west west west west end++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		
		<!-- center center center center center center center++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->	
		<div data-options="region:'center'">
		
			center panel 中
			不需要的面版可以直接删除相应的代码即可。
			
		
		</div>
		<!-- center center center center center center center end++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		
		
		<!-- east east east east east east east++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<div data-options="region:'east',split:false" style="width:240px;">
		
			east panel 右
			
		</div>
		<!-- east east east east east east east end++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		
		<!-- bottom bottom bottom bottom bottom bottom+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<div region="south" border="false" class="cs-south panel-body panel-body-noheader panel-body-noborder layout-body" title="" style="width: 1366px; height: 25px;">
			
			bottom panel 下 脚部
			
		</div>
		<!-- bottom bottom bottom bottom bottom bottom+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		
</body>
</html>
