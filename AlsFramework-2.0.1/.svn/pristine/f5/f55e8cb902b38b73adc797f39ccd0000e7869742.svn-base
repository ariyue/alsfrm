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
    
    <title>弹出窗实例</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script type="text/javascript">

	function alert1(){
		appAlert('My Title','Here is a message!');
	}
	function alert2(){
		appAlert('My Title','Here is a error message!','error');
	}
	function alert3(){
		appAlert('My Title','Here is a info message!','info');
	}
	function alert4(){
		appAlert('My Title','Here is a question message!','question');
	}
	function alert5(){
		appAlert('My Title','Here is a warning message!','warning');
	}
	
	function showPopWin(){

		var content = "<ui><li>coco 可可</li><li>lily 丽丽</li><li>lanl 兰兰</li></ui>";
		appWin("coco", content);
	}

	function showPopConfirm(){

		var content = "<ui><li>coco 可可</li><li>lily 丽丽</li><li>lanl 兰兰</li></ui>";
		appConfirm("coco", content, function(){

			alert("你点击了确定!");
		});
	}

	function showPopMsg(){
		appMsg("提示您", "有一封新邮件");
	}

	

	</script>
  </head>
  
<body>
	<div style="margin-top:20px;margin-left:20px;">
		<a href="javascript:;" class="easyui-linkbutton l-btn" onclick="alert1()"><span class="l-btn-left"><span class="l-btn-text">Alert</span></span></a>
		<a href="javascript:;" class="easyui-linkbutton l-btn" onclick="alert2()"><span class="l-btn-left"><span class="l-btn-text">Error</span></span></a>
		<a href="javascript:;" class="easyui-linkbutton l-btn" onclick="alert3()"><span class="l-btn-left"><span class="l-btn-text">Info</span></span></a>
		<a href="javascript:;" class="easyui-linkbutton l-btn" onclick="alert4()"><span class="l-btn-left"><span class="l-btn-text">Question</span></span></a>
		<a href="javascript:;" class="easyui-linkbutton l-btn" onclick="alert5()"><span class="l-btn-left"><span class="l-btn-text">Warning</span></span></a>
	</div>
	
	<div style="margin-top:20px;margin-left:20px;">
		<a href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="showPopWin()">显示WINDOW.TOP中的Win</a>
		<a href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-print'" onclick="showPopConfirm()">显示WINDOW.TOP中的confirm</a>
		<a href="javascript:;" class="easyui-linkbutton l-btn" onclick="showPopMsg()"><span class="l-btn-left"><span class="l-btn-text">显示右下角系统提醒</span></span></a>
		
	</div>
	
	
	<!-- 在页面上直接创建 -->
	<div id="win_1" class="easyui-window" title="信息" style="width:300px;height:100px;padding:5px;">Some Content.</div>
</body>
</html>
