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
    
    <title>表单生成器</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script type="text/javascript">

	

	</script>
  </head>
  
<body>
	<div style="margin-top:20px;margin-left:20px;">
		<e:Grid>
			<e:col field="id" checkbox="true" sortable="true" title="票号" align="center" type="Max3Text" width="150"/>
			<e:col field="bbb" sortable="true" title="出票人" align="center" type="Max3Text" width="150"/>
			<e:col field="ccc" sortable="true" title="承况人" align="center" type="Max3Text" width="150"/>
			<e:col field="ddd" sortable="true" title="收票人" align="center" type="Max3Text" width="150"/>
			<e:col field="eee" sortable="true" title="金额" align="center" type="Max3Text" width="150"/>
		</e:Grid>
	</div>
	
	

</body>
</html>
