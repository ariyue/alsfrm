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
    
    <title>AbcUser管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script>

		var datagrid = new $$.EasyDatagrid("userDatagrid");
		
		function setupDatagrid(){
			
			datagrid.setUrl(ROOT_PATH + "abcUser/queryPageList");
			datagrid.setQueryParams({});
			datagrid.init();

	
		}
		$(function(){
		
			setupDatagrid();
		});

		function queryDatagridData(){
			datagrid.setQueryParams({id: "good mybatis"});
			datagrid.exeQuery();
		}

	

	</script>
  </head>
  
<body>

	<!-- datagrid ++++++++++++++++++++++++++++++++++++++ -->
	<table id="userDatagrid" class="easyui-datagrid" title="用户数据维护" fit="true"  fitcolumns="true"  toolbar="#userDatagirdToolbar"
			data-options="
							
							rownumbers:true,
			                singleSelect:true,
			                autoRowHeight:false,
			                pagination:true,
			                pageSize:10"
						">
		<thead>
			<tr>
				<th data-options="field:'id',title:'编号',width:80,sortable:true">Item ID</th>
				<th data-options="field:'userName',title:'用户名',width:100,sortable:true">userName</th>
				<th data-options="field:'realName',title:'姓名',width:80,align:'right',sortable:true">realName</th>
				<th data-options="field:'userType',title:'用户类型',width:80,align:'right',sortable:true">userType</th>
				<th data-options="field:'lastModifyDate',title:'创建日期',width:250,sortable:true">lastModifyDate</th>
				<th data-options="field:'lastModifyTime',title:'创建时间',width:60,align:'center',sortable:true">lastModifyTime</th>
			</tr>
		</thead>
	</table>
	<div id="userDatagirdToolbar">
		<input class="easyui-searchbox" data-options="prompt:'请输入关键字... ...',menu:'#searchTypeMenu'" style="width:300px;">
		<div id="searchTypeMenu">
			<div data-options="name:'all',iconCls:'icon-ok'">搜索</div>
			<div data-options="name:'sports'">高级搜索...</div>
		</div>
		
		<a href="javascript:void(0)" class="easyui-linkbutton" iconcls="icon-reload" plain="true" onclick="queryDatagridData()">刷新就有数据哦</a>  
		<a href="javascript:void(0)" class="easyui-linkbutton" iconcls="icon-add" plain="true" onclick="newUser()">添加</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton" iconcls="icon-edit" plain="true" onclick="editUser()">修改</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton" iconcls="icon-remove" plain="true" onclick="destroyUser()">删除</a> 
    </div>
	<!-- datagrid end ++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>
