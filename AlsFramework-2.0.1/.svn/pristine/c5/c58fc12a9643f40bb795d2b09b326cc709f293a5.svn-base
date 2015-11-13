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

	/*
		var tb = new $$.Text("tb");
		var searchText = new $$.SearchText("searchText");
		searchText.setBtnClickFn(function(val){
				textBtnClick(val);
			});

		searchText.setIconClickFn(function(index){
			textIconClick(index);
		});

		*/
		//初始化
		$(function(){
			/*
			tb.init();
			searchText.init();
			*/

			var data = [{    
			    "id":1,    
			    "text":"text1"   
			},{    
			    "id":2,    
			    "text":"text2"   
			},{    
			    "id":3,    
			    "text":"text3",    
			    "selected":true   
			},{    
			    "id":4,    
			    "text":"text4"   
			},{    
			    "id":5,    
			    "text":"text5"   
			}];
			
			$('#cc').combobox({    
			    url: "",    
			    valueField:'id',    
			    textField:'text', 
				     
			}); 

			$('#cc').combobox("loadData", data); 
			$('#cc').combobox('setValue',3);

			
			
		});
	
	

	</script>
  </head>
  
<body>

	<!-- text ++++++++++++++++++++++++++++++++++++++ -->
	<input id="cc" name="dept" value="aa">  
	<!-- text end ++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>
