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
    
    <title>下拉框实例</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script>

		function test(){
			//alert("text=" + myComboGrid.getText() + ";val=" + myComboGrid.getVal());
		}

		function onHidePanel(o){
			alert("o=" + o.val);
		}
	</script>
  </head>
  
<body>

	<!-- text ++++++++++++++++++++++++++++++++++++++ -->
	<e:ComboGrid id="myComboGrid" url="abcUser/queryPageList" clazz="com.als.mod.domain.AbcUser" textField="id" valField="userName" val="cc@wx"  onHidePanelFn="onHidePanel"></e:ComboGrid>
	<button onclick="test()">获取选中的值</button>
	<!-- text end ++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>
