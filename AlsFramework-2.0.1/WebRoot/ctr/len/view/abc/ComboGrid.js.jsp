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

		var myComboGrid = new $$.ComboGrid("myComboGrid");
		//服务器事件
		myComboGrid.setUrl(ROOT_PATH + "abcUser/queryPageList");
		//列属性
		myComboGrid.setColumns(top.topDomainMap["com.als.mod.domain.AbcUser"]);
		//值列名
		myComboGrid.setValField("id");
		//文本列名
		myComboGrid.setTextField("userName");
		//设置默认值
		myComboGrid.setVal("cc@wx");
		//查询设值
		myComboGrid.setQueryParams({});

		myComboGrid.setOnHidePanelFn(function(o){
          alert("oooo=" + o.val);
		});
		//初始化
		$(function(){
			myComboGrid.init();
		});
	

		function test(){
			alert("text=" + myComboGrid.getText() + ";val=" + myComboGrid.getVal());
		}

	</script>
  </head>
  
<body>

	<!-- text ++++++++++++++++++++++++++++++++++++++ -->
	<input id="myComboGrid" name="myComboGrid" />  
	<button onclick="test()">获取选中的值</button>
	<!-- text end ++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>
