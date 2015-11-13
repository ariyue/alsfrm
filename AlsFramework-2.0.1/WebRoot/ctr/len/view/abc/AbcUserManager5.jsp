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

		function setupDatagrid(){
			var datagrid = new $$.EasyDatagrid("userDatagrid");
			datagrid.setUrl(ROOT_PATH + "abcUser/queryPageList");
			datagrid.setQueryParams({});
			datagrid.execQuery();

	
		}
		$(function(){
		
			datagridInit("userDatagrid", loadDatagridData);
		});

		/**
		 * 初始化datagrid,一般在页面加载完成后执行
		 * @param datagridId 
		 * @param loadDataFn　加载数据的事件
		 */
		function datagridInit(datagridId, loadDataFn){

			$("#" + datagridId).datagrid({
					onSortColumn: function(field, type){
						alert("field=" + field + "; type=" + type);
					}
				})


			
			var p = $("#" + datagridId).datagrid('getPager');//分页组件
			loadDataFn(datagridId);
			 $(p).pagination({
				 //分页条切换页面事件
				 onSelectPage:function(pageNumber, pageSize){
					loadDataFn(datagridId);
				 }
			});
		}

		function queryDatagridData(datagridId){

			var p = $("#" + datagridId).datagrid('getPager');//分页组件
			 $(p).pagination({
                 pageNumber: 1 //查询时，让分页组件跳转到首页
             }); 
			loadDatagridData(datagridId);
		}

		function loadDatagridData(datagridId){
			var pageOptions = $("#" + datagridId).datagrid('getPager').data("pagination").options;
			var page = pageOptions.pageNumber;//当前页码
			var rows = pageOptions.pageSize;//每页记录数
			//alert("rows=" +rows);
			//TODO 查询条件，从界面上获取
			var param = {
					rows:rows,//每页记录数
					page:page//当前页码
					//其它条件
					};
			
			var tstCmd = new $$.Command();
			var url = ROOT_PATH + "abcUser/queryPageList";
			tstCmd.setUrl(url);
			tstCmd.setParam(param);
			tstCmd.execute();
			if (tstCmd.commandSuccess){
				var result = tstCmd.getResult();
				var abcUserList = result.dataList;
				var data = {"total":result.total,"rows":abcUserList};
				$("#" + datagridId).datagrid('loadData',data);
			}     
		}

		
		//排序
		function onColumnSort(sort,order){
			alert(sort+'-'+order); 
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
		
		<a href="javascript:void(0)" class="easyui-linkbutton" iconcls="icon-reload" plain="true" onclick="queryDatagridData('userDatagrid')">刷新就有数据哦</a>  
		<a href="javascript:void(0)" class="easyui-linkbutton" iconcls="icon-add" plain="true" onclick="newUser()">添加</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton" iconcls="icon-edit" plain="true" onclick="editUser()">修改</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton" iconcls="icon-remove" plain="true" onclick="destroyUser()">删除</a> 
    </div>
	<!-- datagrid end ++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>
