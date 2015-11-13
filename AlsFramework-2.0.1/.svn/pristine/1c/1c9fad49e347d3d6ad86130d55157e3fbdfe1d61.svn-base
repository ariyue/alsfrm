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
    
    <title>表单实例</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script>

		function test(){
			alert("hello!");
		}
		$(function(){
			$("#myZone1Icon").bind("click", function(){
				var hideMsg = "<font color=red>(含有隐藏信息)</font>";
				if ($(this).hasClass("als-icon-down")){
					$(this).removeClass("als-icon-down").addClass("als-icon-right").html($(this).attr("title") + hideMsg);
					$("#myZone1").hide(300);
				}else {
					$(this).removeClass("als-icon-right").addClass("als-icon-down").html($(this).attr("title"));
					$("#myZone1").show(300);
				}
			});
		})

	</script>
  </head>
  
<body>

	<!-- text ++++++++++++++++++++++++++++++++++++++ -->
	<div class="alsui-form" style="width:800px">
		<div class="alsui-zone" >
			<div class="alsui-zone-hd">
				<i id="myZone1Icon" title="用户基本信息" style="padding-left:20px; margin: 0px 5px;width:auto;" class="als-icon als-icon-down alsui-zone-t"">用户基本信息</i>
			</div>
			<div id="myZone1" class="alsui-zone-bd">
			
				<!-- row -->
				<ul class="alsui-row">
					<li><label>用户名用户名用:</label><e:Text id="userNameText"></e:Text></li>
					<li><label>密码:</label><e:Text id="passwdText"></e:Text></li>
				</ul>
				<ul class="alsui-row">
					<li><label class="up">用户名:</label><e:Text id="userNameText2"></e:Text></li>
					<li><label class="up">密码:</label><e:Text id="passwdText2"></e:Text></li>
				</ul>
				<!-- row end -->
			</div>
		</div>
	</div>
	<!-- text end ++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>
