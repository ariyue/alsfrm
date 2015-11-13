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

	$.extend($.fn.validatebox.defaults.rules, {
	    CHS: {
	        validator: function (value, param) {
	            return /^[\u0391-\uFFE5]+$/.test(value);
	        },
	        message: '请输入汉字'
	    },
	    ZIP: {
	        validator: function (value, param) {
	            return /^[1-9]\d{5}$/.test(value);
	        },
	        message: '邮政编码不存在'
	    },
	    QQ: {
	        validator: function (value, param) {
	            return /^[1-9]\d{4,10}$/.test(value);
	        },
	        message: 'QQ号码不正确'
	    },
	    mobile: {
	        validator: function (value, param) {
	            return /^((\(\d{2,3}\))|(\d{3}\-))?13\d{9}$/.test(value);
	        },
	        message: '手机号码不正确'
	    },
	    loginName: {
	        validator: function (value, param) {
	            return /^[\u0391-\uFFE5\w]+$/.test(value);
	        },
	        message: '登录名称只允许汉字、英文字母、数字及下划线。'
	    },
	    safepass: {
	        validator: function (value, param) {
	            return safePassword(value);
	        },
	        message: '密码由字母和数字组成，至少6位'
	    },
	    equalTo: {
	        validator: function (value, param) {
	            return value == $(param[0]).val();
	        },
	        message: '两次输入的字符不一至'
	    },
	    number: {
	        validator: function (value, param) {
	            return /^\d+$/.test(value);
	        },
	        message: '请输入数字'
	    },
	    idcard: {
	        validator: function (value, param) {
	            return idCard(value);
	        },
	        message:'请输入正确的身份证号码'
	    }
	});

	/* 密码由字母和数字组成，至少6位 */
	var safePassword = function (value) {
	    return !(/^(([A-Z]*|[a-z]*|\d*|[-_\~!@#\$%\^&\*\.\(\)\[\]\{\}<>\?\\\/\'\"]*)|.{0,5})$|\s/.test(value));
	}

	var idCard = function (value) {
	    if (value.length == 18 && 18 != value.length) return false;
	    var number = value.toLowerCase();
	    var d, sum = 0, v = '10x98765432', w = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2], a = '11,12,13,14,15,21,22,23,31,32,33,34,35,36,37,41,42,43,44,45,46,50,51,52,53,54,61,62,63,64,65,71,81,82,91';
	    var re = number.match(/^(\d{2})\d{4}(((\d{2})(\d{2})(\d{2})(\d{3}))|((\d{4})(\d{2})(\d{2})(\d{3}[x\d])))$/);
	    if (re == null || a.indexOf(re[1]) < 0) return false;
	    if (re[2].length == 9) {
	        number = number.substr(0, 6) + '19' + number.substr(6);
	        d = ['19' + re[4], re[5], re[6]].join('-');
	    } else d = [re[9], re[10], re[11]].join('-');
	    if (!isDateTime.call(d, 'yyyy-MM-dd')) return false;
	    for (var i = 0; i < 17; i++) sum += number.charAt(i) * w[i];
	    return (re[2].length == 9 || number.charAt(17) == v.charAt(sum % 11));
	}

	var isDateTime = function (format, reObj) {
	    format = format || 'yyyy-MM-dd';
	    var input = this, o = {}, d = new Date();
	    var f1 = format.split(/[^a-z]+/gi), f2 = input.split(/\D+/g), f3 = format.split(/[a-z]+/gi), f4 = input.split(/\d+/g);
	    var len = f1.length, len1 = f3.length;
	    if (len != f2.length || len1 != f4.length) return false;
	    for (var i = 0; i < len1; i++) if (f3[i] != f4[i]) return false;
	    for (var i = 0; i < len; i++) o[f1[i]] = f2[i];
	    o.yyyy = s(o.yyyy, o.yy, d.getFullYear(), 9999, 4);
	    o.MM = s(o.MM, o.M, d.getMonth() + 1, 12);
	    o.dd = s(o.dd, o.d, d.getDate(), 31);
	    o.hh = s(o.hh, o.h, d.getHours(), 24);
	    o.mm = s(o.mm, o.m, d.getMinutes());
	    o.ss = s(o.ss, o.s, d.getSeconds());
	    o.ms = s(o.ms, o.ms, d.getMilliseconds(), 999, 3);
	    if (o.yyyy + o.MM + o.dd + o.hh + o.mm + o.ss + o.ms < 0) return false;
	    if (o.yyyy < 100) o.yyyy += (o.yyyy > 30 ? 1900 : 2000);
	    d = new Date(o.yyyy, o.MM - 1, o.dd, o.hh, o.mm, o.ss, o.ms);
	    var reVal = d.getFullYear() == o.yyyy && d.getMonth() + 1 == o.MM && d.getDate() == o.dd && d.getHours() == o.hh && d.getMinutes() == o.mm && d.getSeconds() == o.ss && d.getMilliseconds() == o.ms;
	    return reVal && reObj ? d : reVal;
	    function s(s1, s2, s3, s4, s5) {
	        s4 = s4 || 60, s5 = s5 || 2;
	        var reVal = s3;
	        if (s1 != undefined && s1 != '' || !isNaN(s1)) reVal = s1 * 1;
	        if (s2 != undefined && s2 != '' && !isNaN(s2)) reVal = s2 * 1;
	        return (reVal == s1 && s1.length != s5 || reVal > s4) ? -10000 : reVal;
	    }
	};



	$(function(){
		  $('#uiform input').each(function () {
		            if ($(this).attr('required') || $(this).attr('validType'))
		                $(this).validatebox();
		        })
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
				<tr><td>登录名：</td><td><input  required="true" id="txtUsername" type="text" class="txt03" /></td><td>真实姓名：</td><td><input id="txtTruename" validType="CHS" required="true" type="text" class="txt03" /></td></tr>
				<tr><td>登录密码：</td><td><input validType="safepass"  required="true" id="txtPassword" name="password" type="password" class="txt03" /></td><td>Email：</td><td><input id="txtEmail" name="email"  validType="email" type="text" class="txt03" /></td></tr>
				<tr><td>身份证号：</td><td><input validType="idcard" id="txtIdcard" name="idcard" type="text" class="txt03" /></td><td>QQ：</td><td><input validType="QQ" id="txtQq" name="qq" type="text" class="txt03" /></td></tr>
				<tr><td>手机：</td><td><input validType="mobile" id="txtMobile" name="mobile" type="text" class="txt03" /></td><td>电话：</td><td><input id="txtTel" name="tel" type="text" class="txt03" /></td></tr>
				<tr><td>家庭住址：</td><td colspan="3"><input validType="equalTo[txtMobile]" style="width:80%" id="txtHomeaddr" name="homeaddr" type="text" class="txt03" /></td></tr>
				<tr><td>备注：</td><td colspan="3"> <input type="text" style="width:80%" class="txt03" id="txtRemark"></textarea></td></tr>
				<tr><td>&nbsp;</td><td colspan="3"><input id="Checkbox1" type="checkbox" /><label>超级管理员</label>&nbsp;&nbsp;<input id="Checkbox2" type="checkbox" /><label>禁用</label></td></tr> 
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
