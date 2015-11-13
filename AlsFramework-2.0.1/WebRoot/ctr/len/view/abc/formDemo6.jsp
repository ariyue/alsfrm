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
    
    <title>表单实例3_用户注册2</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script>

	

	$(function(){
		
	});

	function submit(){
		var flag = true;

			$('#uiform input').each(function () {
			    if ($(this).attr('required') || $(this).attr('validType')) {
			    if (!$(this).validatebox('isValid')) {
			        flag = false;
			        return;
			    }
			    }
			})

			if (flag)
			    alert('验证通过！');
			else
			    alert('验证失败！');
	}
	</script>
  </head>
  
<body class="easyui-layout layout" style="height: 100%; overflow: hidden; border: none; margin: 0px; padding: 0px;border:0px;">
	
		<div data-options="region:'north',border:false" style="height:38px">
		<!-- north north north +++++++++++ -->	
			<div id="pageToolBar" style="padding:5px;border-bottom:1px #d3d3d3 solid;text-align:right;">
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'"  onclick="submit()" >提交</a>
			</div>
			
		<!-- north north north end+++++++++ -->	
			
		</div>

		<div data-options="region:'center',border:false">
		<!-- center center center +++++++++++ -->	
		<div style="padding:5px;">
			<table class="grid" id="uiform">
				<tr><td>用户名(不含中文)：</td><td><input id="userNameTB"  validType="userName" required="true" maxlength="3" type="text" class="easyui-validatebox"/></td></tr>
				<tr><td>登录名(含中文)：</td><td><input id="realNameTB"  validType="loginName" required="true"  type="text" class="easyui-validatebox"/></td></tr>
				<tr><td>密码：</td><td><input id="passwordTB"  validType="safePassword" required="true"  type="text" class="easyui-validatebox"/></td></tr>	
				<tr><td>电子邮件：</td><td><input id="emailTB"  validType="email" type="text" class="easyui-validatebox"/></td></tr>	
				<tr><td>身份证：</td><td><input id="idcardTB"  validType="idcard" type="text" class="easyui-validatebox"/></td></tr>	
				<tr><td>手机号：</td><td><input id="mobileTB"  validType="mobile" type="text" class="easyui-validatebox"/></td></tr>
				<tr><td>电话号码：</td><td><input id="phoneTB"  validType="phone" type="text" class="easyui-validatebox"/></td></tr>
				<tr><td>到场人数(0,1,2.....)：</td><td><input id="pNumberTB"  validType="zeroAndInteger" type="text" class="easyui-validatebox"/></td></tr>
				<tr><td>价格(可以到4位小数)：</td><td><input id="priceTB"  validType="money" type="text" class="easyui-validatebox"/></td></tr>
				
			</table>
		</div>
		<!-- center center center end+++++++++ -->
		</div>
		
		<div data-options="region:'south',border:false" style="height:38px">
		<!-- south south south +++++++++++ -->	
			<div id="pageToolBar" style="padding:5px;border-top:1px #d3d3d3 solid;text-align:right;">
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'"  onclick="submit()" >提交</a>
			</div>
			
		<!-- south south south end+++++++++ -->	
			
		</div>
		
</body>

</html>
