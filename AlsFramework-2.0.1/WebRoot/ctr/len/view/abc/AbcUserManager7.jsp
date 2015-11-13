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

		
		$(function(){
		
			setupDatagrid();
		});
	
		var datagrid = new $$.EasyDatagrid("userDatagrid");
		
		function setupDatagrid(){
			//服务器事件
			datagrid.setUrl(ROOT_PATH + "abcUser/queryPageList");
			//行单击事件
			datagrid.setRowClickFn(function(rowIndex, rowData){
				//alert("datagrid单击" + rowIndex + ";id=" + rowData.id);
			});
			//双击事件
			datagrid.setDblRowClickFn(function(rowIndex, rowData){
				alert("datagrid双击" + rowIndex + ";id=" + rowData.id);
			});
			//查询设值
			datagrid.setQueryParams({});
			//初始化
			datagrid.init();

	
		}
		function queryDatagridData(){
			var id =  $("#searchBox").val();
			datagrid.setQueryParams({id:  id});
			datagrid.exeQuery(true);//查询并返回第一页
		}

		function getSelected(){

			var list = datagrid.getSelectedData();
			if (list.length == 0){
				alert("至少选中一行!");
				return;
			}
			
			
			alert("被选中的第一行名字为："+list[0].realName);
		}

	

	</script>
  </head>
  
<body>

	<!-- datagrid ++++++++++++++++++++++++++++++++++++++ -->
	<table id="userDatagrid" class="easyui-datagrid" singleSelect="false" checkbox="true" title="用户数据维护" fit="true"  fitcolumns="true"  toolbar="#pageToolBar"
			data-options="
							
							rownumbers:true,
			                singleSelect:false,
			                checkbox:true,
			                autoRowHeight:false,
			                pagination:true,
			                pageSize:10"
						">
		<thead>
			<tr>
				<th data-options="field:'id',checkbox:true,title:'编号',width:80,sortable:true"></th>
				<th data-options="field:'userName',title:'用户名',width:100,sortable:true"></th>
				<th data-options="field:'realName',title:'姓名',width:80,align:'right',sortable:true"></th>
				<th data-options="field:'userType',title:'用户类型',width:80,align:'right',sortable:true"></th>
				<th data-options="field:'lastModifyDate',title:'创建日期',width:250,sortable:true"></th>
				<th data-options="field:'lastModifyTime',title:'创建时间',width:60,align:'center',sortable:true"></th>
			</tr>
		</thead>
	</table>
	<div id="pageToolBar">
		<span style="float: right;">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconcls="icon-add" plain="true" onclick="addEntity()">添加</a> 
			<a href="javascript:void(0)" class="easyui-linkbutton" iconcls="icon-edit" plain="true" onclick="updateEntity()">修改</a> 
			<a href="javascript:void(0)" class="easyui-linkbutton" iconcls="icon-remove" plain="true" onclick="deleteEntity()">删除</a> 
			<a href="javascript:void(0)" class="easyui-linkbutton" iconcls="icon-remove" plain="true" onclick="getSelected()">获取选中行</a> 
		</span>
		<input id="searchBox" class="easyui-searchbox" searcher="queryDatagridData" data-options="prompt:'请输入关键字... ...',menu:'#searchTypeMenu'" style="width:300px;">
		<div id="searchTypeMenu">
			<div data-options="name:'all',iconCls:'icon-ok'">搜索</div>
			<div data-options="name:'sports'">高级搜索...</div>
		</div>
		
    </div>
	<!-- datagrid end ++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>
