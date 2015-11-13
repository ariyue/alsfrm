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
    
    <title>数据验字实例</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script>

		
		//初始化
		$(function(){

		});

	</script>
  </head>
  
<body>

	<!-- text ++++++++++++++++++++++++++++++++++++++ -->
	<div class="easyui-panel" title="Register" style="width:400px;padding:10px">
        <table>
            <tr>
                <td>User Name:</td>
                <td><input class="easyui-validatebox" data-options="required:true,validType:'username'"></td>
            </tr>
            <tr>
                <td>password:</td>
                <td><input class="easyui-validatebox" id="password"  type="password" data-options="required:true"></td>
            </tr>
            <tr>
                <td>repassword:</td>
                <td><input class="easyui-validatebox" type="password" data-options="required:true" validType="same[‘#password’]"></td>
            </tr>
            <tr>
                <td>date:</td>
                <td><input class="easyui-validatebox" data-options="required:true,validType:'date'"></td>
            </tr>
            <tr>
                <td>zip:</td>
                <td><input class="easyui-validatebox" data-options="required:true,validType:'zip'"></td>
            </tr>
            <tr>
                <td>faxno:</td>
                <td><input class="easyui-validatebox" data-options="required:true,validType:'faxno'"></td>
            </tr>
            <tr>
                <td>name:</td>
                <td><input class="easyui-validatebox" data-options="required:true,validType:'name'"></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input class="easyui-validatebox" data-options="required:true,validType:'email'"></td>
            </tr>
            <tr>
                <td>Birthday:</td>
                <td><input class="easyui-datebox"></td>
            </tr>
            <tr>
                <td>URL:</td>
                <td><input class="easyui-validatebox" data-options="required:true,validType:'url'"></td>
            </tr>
            <tr>
                <td>Phone:</td>
                <td><input class="easyui-validatebox" data-options="required:true,validType:'phone'"></td>
            </tr>
            <tr>
                <td>idcard:</td>
                <td><input class="easyui-validatebox" data-options="required:true,validType:'idcard'"></td>
            </tr>
            <tr>
                <td>mobile:</td>
                <td><input class="easyui-validatebox" data-options="required:true,validType:'mobile'"></td>
            </tr>
            <tr>
                <td>intOrFloat :</td>
                <td><input class="easyui-validatebox" data-options="required:true,validType:'intOrFloat'"></td>
            </tr>
            <tr>
                <td>currency:</td>
                <td><input class="easyui-validatebox" data-options="required:true,validType:'currency'"></td>
            </tr>
            <tr>
                <td>qq:</td>
                <td><input class="easyui-validatebox" data-options="required:true,validType:'qq'"></td>
            </tr>
            <tr>
                <td>integer:</td>
                <td><input class="easyui-validatebox" data-options="required:true,validType:'integer'"></td>
            </tr>
            <tr>
                <td>age:</td>
                <td><input class="easyui-validatebox" data-options="required:true,validType:'age'"></td>
            </tr>
            <tr>
                <td>chinese:</td>
                <td><input class="easyui-validatebox" data-options="required:true,validType:'chinese'"></td>
            </tr>
            <tr>
                <td>english:</td>
                <td><input class="easyui-validatebox" data-options="required:true,validType:'english'"></td>
            </tr>
            <tr>
                <td>unnormal:</td>
                <td><input class="easyui-validatebox" data-options="required:true,validType:'unnormal'"></td>
            </tr>
            <tr>
                <td>ip:</td>
                <td><input class="easyui-validatebox" data-options="required:true,validType:'ip'"></td>
            </tr>
        </table>
    </div>
    
     邮箱验证：<input type="text" validtype="email" required="true" missingMessage="不能为空" invalidMessage="邮箱格式不正确" /><br />  
    网址验证：<input type="text" validtype="url" invalidMessage="url格式不正确[http://www.example.com]" /><br />  
    长度验证：<input type="text" validtype="length[8,20]" invalidMessage="有效长度8-20" /><br />  
    手机验证：<input type="text" validtype="mobile"  /><br />  
    邮编验证：<input type="text" validtype="zipcode" /><br />  
    账号验证：<input type="text" validtype="account[8,20]" /><br />  
    汉子验证：<input type="text" validtype="CHS" /><br />  
    远程验证：<input type="text" validtype="remote['checkname.aspx','name']" invalidMessage="用户名已存在"/>  
	<!-- text end ++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>
