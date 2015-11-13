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
    
    <title>文本框实例</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script>

		var tb = new $$.Text("tb");
		tb.setLabel("用户名称:");
		tb.setLabelClass("up");
		//tb.setReadOnly(true);
		var searchText = new $$.SearchText("searchText");
		searchText.setBtnClickFn(function(val){
				textBtnClick(val);
			});

		searchText.setIconClickFn(function(index){
			textIconClick(index);
		});

		
		//初始化
		$(function(){
			tb.init();
			searchText.init();
			
			/*
			$('#tb').textbox({ 
				 buttonText:'Search', 
				 iconCls:'icon-man', 
				 iconAlign:'left' 
				}) 
			*/
			
		});
	
		

		function textBtnClick(val){
			alert("您输入值为=" + val);
		}

		function textIconClick(index){
			alert("您输入值为=" + index);
		}

		function setReadOnlyTrue(){
			//userNameText.setReadOnly("false");
			tb.setReadOnly("true");
		}

		function setReadOnlyFalse(){
			tb.setReadOnly("false");
		}
		

	</script>
  </head>
  
<body>

	<!-- text ++++++++++++++++++++++++++++++++++++++ -->
	
	<input id="tb" type="text"/>
	<label>搜索：</label>
	<input id="searchText" type="text"/>
	<button type="button" onclick="setReadOnlyTrue()">用户名称不可输入</button>
	<button type="button" onclick="setReadOnlyFalse()">用户名称可输入</button>
	<!-- text end ++++++++++++++++++++++++++++++++++++++ -->
	
	
	<div id="p" class="easyui-panel" title="My Panel"     
	        style="width:500px;height:150px;padding:10px;background:#fafafa;"   
	        data-options="iconCls:'icon-save',closable:true,    
	                collapsible:true,minimizable:true,maximizable:true">   
	    <p>panel content.</p>   
	    <p>panel content.</p>   
	</div> 
</body>
</html>
