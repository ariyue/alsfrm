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
	<style type="text/css">
	
	.als-messagebox{
		position:absolute;
		top: 50%; left: 50%;
	}
	
	</style>
	<script type="text/javascript">


	
  $(function(){

	
	
	//可拖放
	  $('#login-box').draggable({ 
		  handle:'#box-head' 
		  }); 
	//可改变大小
	/*
	  $('#login-box').resizable({ 
		  maxWidth:800, 
		  maxHeight:600 
		  }); 
		  */	  
   });

 
	
  function login(){

	  spwd = passwordText.getVal();
	  //密码加密
	  passwordText.setVal(hex_md5(spwd));
	  alert("md5 = " +passwordText.getVal());
	 
  }


  function changLanguage(code){
		alert("切换语言=" + code);
	  }

  ///new ------------------------------------------------
   function refreshImgCode(){
		
		$("#imgCode").attr("src",ROOT_PATH+'servlet/ImageRandomCodeServlet.svlt?w=85&h=30&n=loginImageValidator&t=' + new Date().getTime());
		$("#" + validatorCodeTB.getId()).focus();
	}
  //快速登陆
  function quickLogin(val){
		alert("password=" +val);
   }

  function changeUser(){
		$("#quickLoginPanel").css("display", "none");
		$("#loginPanel").css("display", "block");
  }

  function reset(){
	  userNameText.setValue("");
	  passwordText.setValue("");
	  imgCodeText.setValue("");
	  refreshImgCode();
  }
  ///new end --------------------------------------------
	</script>
  </head>
  
<body>
	<div id="login-box">
		
		<table style="width:100%;" class="als-thin-table-noborder">
			<tr><td>
					<div id="box-head" class="box-head">
						用户登陆
						<div style="color:#7E7E7E;font-size:8px;margin-top:-10px;">Please enter your user name and password.</div>
					</div>
					
			</td></tr>
			<tr><td>
				<div id= "quickLoginPanel">
					<div id="login-head" class="center"></div>
					<div id="loginUserid" class="center" style="color:red;font-size:14px;font-weight:bold;margin:6px 0px;">Vincent</div>
					<div class="center">
						<e:SearchText id="searchText" btnClick="quickLogin" enterKeyPress="quickLogin"  validType="length[6,30]" invalidMsg="密码至少6位数" buttonText="登陆" iconCls="null" type="password" prompt="请输入密码" ></e:SearchText>
						<e:Btn id="changeUserBtn" text="切换用户" iconCls="icon-man" btnClick="changeUser"></e:Btn>
					</div>
				</div>
				
				<div id= "loginPanel" style="display:none;line-height:24px;">
					<div class="center" style="margin:16px 0px 6px;">
						<e:Text id="userNameText" iconCls="icon-man" prompt="用户名"  validType="username" invalidMsg="input userName"></e:Text>
					</div>
					<div class="center">
						<e:Text id="passwordText" iconCls="icon-lock" type="password" prompt="密码" required="true" missingMsg="请输入密码" ></e:Text>
					</div>
					<div class="center" style="margin:6px 0px;">
						<e:Text id="imgCodeText" iconCls="icon-man" prompt="验证码" width="190px"  validType="length[1,4]"></e:Text>
						<script type="text/javascript">
							document.writeln('<img id="imgCode" onclick="refreshImgCode()" style="cursor:pointer;vertical-align: top;" title="点击图片，更换验证码" src="'+ROOT_PATH+'servlet/ImageRandomCodeServlet.svlt?w=85&h=30&n=loginImageValidator&rnd='+Math.random()+'" ></img>');
						</script>
						
					</div>
					<div style="margin-left:55px;">
						<e:ChkGrp id="sslChkGrp" conName="SSL_LOGIN" ></e:ChkGrp>
					</div>
					<div class="center" style="margin:6px 0px;">
						<e:Btn id="loginBtn" text="登陆" iconCls="icon-man" btnClick="login"></e:Btn>
						<e:Btn id="resetBtn" text="重置" iconCls="icon-man" btnClick="reset"></e:Btn>
					</div>
				</div>
			</td></tr>
		</table>
	</div>

</body>
</html>
