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
    
    <title>表单实例3_用户注册</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script>

		

	</script>
  </head>
  
<body class="easyui-layout layout" style="height: 100%; overflow: hidden; border: none; margin: 0px; padding: 0px;border:0px;">
	
		<div data-options="region:'north',border:false" style="height:38px">
		<!-- north north north +++++++++++ -->	
			<div id="pageToolBar" style="padding:5px;border-bottom:1px #d3d3d3 solid;text-align:right;">
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'"  onclick="home()" >编辑</a>
				<a class="als-tool-separator"></a>
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'"  onclick="home()" >暂存</a>
				<a class="als-tool-separator"></a>
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'"  onclick="home()" >删除</a>
				<a class="als-tool-separator"></a>
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'"  onclick="home()" >提交</a>
			</div>
			
		<!-- north north north end+++++++++ -->	
			
		</div>

		<div data-options="region:'center',border:false">
		<!-- center center center +++++++++++ -->	
		<div style="height:300px;background:#fafafa;padding:5px;">
			<div id="p" class="easyui-panel" title="业务信息"  style="width:100%;padding:10px;background:#fafafa;"  data-options="iconCls:'icon-tip',closable:false,
	                collapsible:true,minimizable:false,maximizable:false">
			    <table cellpadding="5">
		    		<tr>
		    			<th>业务流水号:</th>
		    			<td><input class="easyui-textbox" type="text" name="name" data-options="required:true"></input></td>
		    			<th>业务日期:</th>
		    			<td><input class="easyui-textbox" type="text" name="email" data-options="required:true,validType:'email'"></input></td>
		    		</tr>
		    	
		    	</table>
			</div>
			<div id="p2" class="easyui-panel" title="用户基本信息"  style="width:100%;padding:10px;background:#fafafa;"  data-options="iconCls:'icon-save',closable:false,
	                collapsible:true,minimizable:false,maximizable:false">
			
			    <table cellpadding="5">
		    		<tr>
		    			<th>用户ID:</th>
		    			<td><input class="easyui-textbox" type="text" name="name" data-options="required:true"></input></td>
		    			<th>姓名:</th>
		    			<td><input class="easyui-textbox" type="text" name="email" data-options="required:true,validType:'email'"></input></td>
		    		</tr>
		    		<tr>
		    			<th>妮称:</th>
		    			<td><input class="easyui-textbox" type="text" name="name" data-options="required:true"></input></td>
		    			<th>生日:</th>
		    			<td><input class="easyui-textbox" type="text" name="email" data-options="required:true,validType:'email'"></input></td>
		    		</tr>
		    		<tr>
		    			<th>性别:</th>
		    			<td><input class="easyui-textbox" type="text" name="name" data-options="required:true"></input></td>
		    			<th>星座:</th>
		    			<td><input class="easyui-textbox" type="text" name="email" data-options="required:true,validType:'email'"></input></td>
		    		</tr>
		    	
		    	</table>
		    	
			</div>
			<div id="p3" class="easyui-panel" title="联系方式"  style="width:100%;padding:10px;background:#fafafa;"  data-options="iconCls:'icon-save',closable:false,
	                collapsible:true,minimizable:false,maximizable:false">
			
			    <table cellpadding="5">
		    		<tr>
		    			<th>手机号码:</th>
		    			<td><input class="easyui-textbox" type="text" name="name" data-options="required:true"></input></td>
		    			<th>办公室电话:</th>
		    			<td><input class="easyui-textbox" type="text" name="email" data-options="required:true,validType:'email'"></input></td>
		    		</tr>
		    		<tr>
		    			<th>家庭电话:</th>
		    			<td><input class="easyui-textbox" type="text" name="name" data-options="required:true"></input></td>
		    			<th>QQ号:</th>
		    			<td><input class="easyui-textbox" type="text" name="email" data-options="required:true,validType:'email'"></input></td>
		    		</tr>
		    		<tr>
		    			<th>微信号:</th>
		    			<td><input class="easyui-textbox" type="text" name="name" data-options="required:true"></input></td>
		    			<th>住址:</th>
		    			<td><input class="easyui-textbox" type="text" name="email" data-options="required:true,validType:'email'"></input></td>
		    		</tr>
		    	
		    	</table>
		    	
			</div>
		</div>
		<!-- center center center end+++++++++ -->
		</div>
		
		<div data-options="region:'south',border:false" style="height:38px">
		<!-- south south south +++++++++++ -->	
			<div id="pageToolBar" style="padding:5px;border-top:1px #d3d3d3 solid;text-align:right;">
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'"  onclick="home()" >编辑</a>
				<a class="als-tool-separator"></a>
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'"  onclick="home()" >暂存</a>
				<a class="als-tool-separator"></a>
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'"  onclick="home()" >删除</a>
				<a class="als-tool-separator"></a>
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'"  onclick="home()" >提交</a>
			</div>
			
		<!-- south south south end+++++++++ -->	
			
		</div>
		
</body>

</html>
