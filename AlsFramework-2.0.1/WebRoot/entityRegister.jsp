<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ include file="common.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>企业注册</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="AlsFramework">
		<style type="text/css">
.als-messagebox {
	position: absolute;
	top: 50%;
	left: 50%;
}
</style>
		<script type="text/javascript">
	

	function regist() {

		//spwd = passwordText.getVal();
		//密码加密
		//passwordText.setVal(hex_md5(spwd));
		//alert("md5 = " + passwordText.getVal());


		var param = {
				staDateTime: "2015-05-28",
				endDateTime: "2016-05-28",
				siteList:JSONUtil.encode([{txt:"建阳", val: "jy"},
						{txt:"北京", val: "bj"}
					  
					  ])
		};
		//alert(1111);
		var tstCmd = new $$.Command();
		//alert(22222);
		var url = ROOT_PATH + "umsentity/regist";
		//alert("url=" + url);
		tstCmd.setUrl(url);
		tstCmd.setParam(param);
		//alert(33333);
		tstCmd.execute();
		//alert(4444);
		if (tstCmd.commandSuccess){
			//alert(5555);
			//var result = tstCmd.getResult();
			//alert("code=" + result.resutCode + ";msg=" + result.resutMsg);
			//var userList = result.resutDataList;
			//alert("userId=" + userList[0].userId + ";userName=" +  userList[0].userName);

			$('#myTree').tree({
				data: tstCmd.getResult()
			});
			
		}

	}

	function changLanguage(code) {
		alert("切换语言=" + code);
	}

	///new ------------------------------------------------
	function refreshImgCode() {

		$("#imgCode")
				.attr(
						"src",
						ROOT_PATH
								+ 'servlet/ImageRandomCodeServlet.svlt?w=85&h=30&n=loginImageValidator&t='
								+ new Date().getTime());
		$("#" + validatorCodeTB.getId()).focus();
	}
	//快速登陆
	function quickLogin(val) {
		alert("password=" + val);
	}

	function changeUser() {
		$("#quickLoginPanel").css("display", "none");
		$("#loginPanel").css("display", "block");
	}

	function reset() {
		userNameText.setValue("");
		passwordText.setValue("");
		imgCodeText.setValue("");
		refreshImgCode();
	}
	///new end --------------------------------------------
</script>
	</head>

	<body>
		<div id="register-box" style="margin:20px;">
			<e:Form id="registerForm" caption="注册">
				<e:Row id="row_1">
					<e:Fld id="fld_1">
						<e:Text id="entityNameTxet" label="公司名称全称" labelClass="up"
							required="true" missingMsg="填写工商营业执照 上的公司名称" prompt="填写工商营业执照 上的公司名称"></e:Text>
					</e:Fld>
				</e:Row>
				<e:Row id="row_2">
					<e:Fld id="fld_2">
						<e:Text id="entitySnameText" label="公司简称" labelClass="up" prompt="公司名称简写，便于沟通 "></e:Text>
					</e:Fld>
				</e:Row>
				<e:Row id="row_3">
					<e:Fld id="fld_3">
						<e:Text id="emailTxet" label="电子邮件" labelClass="up"
							required="true" missingMsg="必须填写" prompt="注册激活时需要用到 "></e:Text>
					</e:Fld>
				</e:Row>
				<e:Row id="row_4">
					<e:Fld id="fld_4">
						<e:Btn btnClick="regist" text="注册" id="registBtn"></e:Btn>
					</e:Fld>
				</e:Row>

				<e:Row id="row_5"></e:Row>
				<e:Row id="row_6"></e:Row>
				<e:Row id="row_7"></e:Row>
			</e:Form>

		</div>


<!-- text ++++++++++++++++++++++++++++++++++++++ -->
	<ul id="myTree"></ul>  
	<!-- text end ++++++++++++++++++++++++++++++++++++++ -->

	</body>
	
	<script type="text/javascript">
	
	
	$(function() {

	

		// $("#register-box").live("keydown",function(event){
		//	 alert(444);
		//	 });
		/*
		$("#register-box").live("keydown",function(event){ 
			if(event.keyCode==13){ 
			    $(this).next().facus();
			} 
		});
		*/
	});
	
	
	</script>
</html>
