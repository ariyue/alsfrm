<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="common.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>请您登陆</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="AlsFramework">

	<script type="text/javascript">


	
  $(function(){

	  var html = '<div style="text-align:right;">\
		  			<img src="als/skin/icon_i18n_zh.gif" onclick="changLanguage(\'01\')" style="cursor:pointer;" title="中文简体"/>\
		  			<img src="als/skin/icon_i18n_zh_hk.gif" onclick="changLanguage(\'02\')" style="cursor:pointer;"  title="中文繁體"/>\
		  			<img src="als/skin/icon_i18n_en.gif" onclick="changLanguage(\'03\')" style="cursor:pointer;"  title="English"/>\
		  		</div>\
		  		<div style="font-weight:700;margin-top:16px;font-size:14px;margin-bottom:8px;color:#333;">\
		  			<label>用户名:</label>\
					<input id="userNameTB" class="easyui-textbox" style="width:300px;height:30px;padding:6px" data-options="prompt:\'\',iconCls:\'icon-man\',iconWidth:38">\
				</div>\
				<div style="font-weight:700;margin-top:16px;font-size:14px;margin-bottom:8px;color:#333;">\
					<label>密　码:</label>\
					<input id="passwordTB" class="easyui-textbox" type="password" style="width:300px;height:30px;padding:6px" data-options="prompt:\'\',iconCls:\'icon-lock\',iconWidth:38">\
				</div>\
				<div style="font-weight:700;margin-top:16px;font-size:14px;margin-bottom:8px;color:#333;">\
					<label>验证码:</label>\
					<input id="imgCodeTB" class="easyui-textbox" style="width:174px;height:30px;padding:6px" data-options="prompt:\'\',iconWidth:38">\
					<img id="imgCode" onclick="refreshImgCode()" style="cursor:pointer;vertical-align: top;" title="点击图片，更换验证码" src="'+ROOT_PATH+'servlet/ImageRandomCodeServlet.svlt?w=85&h=30&n=loginImageValidator&rnd='+Math.random()+'" ></img>\
					<a href="javascript:;" onclick="refreshImgCode()">刷新</a>\
				</div>\
				<div style="font-weight:700;margin-top:16px;font-size:14px;margin-bottom:8px;color:#333;text-align:center;">\
				<a href="javascript:;" class="easyui-linkbutton"  iconCls="icon-ok" onclick="login()">登陆</a>\
				<a href="javascript:;" class="easyui-linkbutton"  iconCls="icon-reload" onclick="reset()">重置</a></div>';

		 appWin("用户登陆", html, 400, 264);

	  
   });

  function refreshImgCode(){
		
		$("#imgCode").attr("src",ROOT_PATH+'servlet/ImageRandomCodeServlet.svlt?w=85&h=30&n=loginImageValidator&t=' + new Date().getTime());
		$("#" + validatorCodeTB.getId()).focus();
	}
	
  function login(){

	  var userName = $('#userNameTB').textbox('getValue');
	  var password = $('#passwordTB').textbox('getValue');
	  alert(userName + ";"+ password);
  }
  function reset(){

	  	$('#userNameTB').textbox('setValue', '');
	  	$('#passwordTB').textbox('setValue', '');
  }

  function changLanguage(code){
		alert("切换语言=" + code);
	  }
	</script>
  </head>
  
<body action="com.als.ums.module.user.act">
	<div id="topPopInfoWin" class="easyui-window" style="width:300px;height:100px;padding:8px;"  data-options="title:'系统信息',iconCls:'icon-save',closed:true"></div>
</body>
</html>
