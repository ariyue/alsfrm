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
    
    <title>单选按钮组实例</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script>

		//var myCombo = new $$.Combo("myCombo");
		//myCombo.setConName("SWF_ACTION_TYPE");
		//myCombo.setVal("05");
		//初始化
		$(function(){
			//myCombo.init();
		});
	

		//function test(){
		//	alert("text=" + $("#sexRdoGrp").find("input:checked").val());
		//}

	

		function test(){

			var ckItem = $("#myRadio").radio("getValue");
			 alert(ckItem.value + ";txt=" + ckItem.text);
			 var ckList = $("#myCheckbox").checkbox("getValue");
			 if (ckList.length > 0 ){
				 alert(ckList[0].value + ";txt=" + ckList[0].text);
			}
			
		}

	</script>
  </head>
  
<body>

	<!-- text ++++++++++++++++++++++++++++++++++++++ -->
	<e:Btn id="aaaa" text="TEST" btnClick="test"></e:Btn>
	
	<table>
	    		<tr>
	    			<td>性别:</td>
	    			<td>
						<div class="easyui-radio" id="myRadio">
							<!-- 初始化时至少要有一项选中 -->
							<input type="radio" name="sex" value="0" checked  label="女">
							<input type="radio" name="sex" value="1"  label="男">
							<input type="radio" name="sex" value="2"  label="保密">
						</div>
					</td>
	    		</tr>
	    		<tr>
	    			<td>兴趣爱好:</td>
	    			<td>
						<span class="easyui-checkbox" id="myCheckbox">
							<input type="checkbox" name="likeChek" value="0"  label="羽毛球">
							<input type="checkbox" name="likeChek" value=1  label="台球">
							<input type="checkbox" name="likeChek" value="2"  label="游泳">
						</span>
					</td>
	    		</tr>
	    	</table>
  	
	<!-- text end ++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>
