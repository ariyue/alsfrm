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

		/*
		function pageData(list,total){
		    var obj=new Object(); 
		    obj.total=total; 
		    obj.rows=list; 
		    return obj; 
		}
		*/

		$(function(){
			
			 var p = $("#userDatagrid").datagrid('getPager');//分页  
			
			 $(p).pagination({
				 //分页条切换页面事件
				 onSelectPage:function(pageNumber, pageSize){
				 	//alert('pageNumber:'+pageNumber+',pageSize:'+pageSize);
					loadData(pageNumber, pageSize);
				 }
			});
			 refreshData();

		});

		function datagridInit(datagridId, loadDataFn){

			var p = $("#" + datagridId).datagrid('getPager');//分页组件
			
			 $(p).pagination({
				 //分页条切换页面事件
				 onSelectPage:function(pageNumber, pageSize){
				 	//alert('pageNumber:'+pageNumber+',pageSize:'+pageSize);
					//loadData(pageNumber, pageSize);

					loadDataFn(datagridId);
				 }
			});
		}

		function loadDatagridData(datagridId){
			var pageOptions = $("#" + datagridId).datagrid('getPager').data("pagination").options;
			var page = pageOptions.pageNumber;//当前页码
			var rows = pageOptions.pageSize;//每页记录数
			alert("rows=" +rows);
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

		
		
		function refreshData(){
			
			loadData(1, 10);
		}
		function loadData(page, rows){
			//alert("aa=" + page);

			/*
			var data = {"total":28,"rows":[
			                               	{"productid":"FI-SW-01","productname":"Koi","unitcost":10.00,"status":"P","listprice":36.50,"attr1":"Large","itemid":"EST-1"},
			                            	{"productid":"K9-DL-01","productname":"Dalmation","unitcost":12.00,"status":"P","listprice":18.50,"attr1":"Spotted Adult Female","itemid":"EST-10"},
			                            	{"productid":"RP-SN-01","productname":"Rattlesnake","unitcost":12.00,"status":"P","listprice":38.50,"attr1":"Venomless","itemid":"EST-11"},
			                            	{"productid":"RP-SN-01","productname":"Rattlesnake","unitcost":12.00,"status":"P","listprice":26.50,"attr1":"Rattleless","itemid":"EST-12"},
			                            	{"selected":true,"productid":"RP-LI-02","productname":"Iguana","unitcost":12.00,"status":"P","listprice":35.50,"attr1":"Green Adult","itemid":"EST-13"},
			                            	{"productid":"FL-DSH-01","productname":"Manx","unitcost":12.00,"status":"P","listprice":158.50,"attr1":"Tailless","itemid":"EST-14"},
			                            	{"productid":"FL-DSH-01","productname":"Manx","unitcost":12.00,"status":"P","listprice":83.50,"attr1":"With tail","itemid":"EST-15"},
			                            	{"productid":"FL-DLH-02","productname":"Persian","unitcost":12.00,"status":"P","listprice":23.50,"attr1":"Adult Female","itemid":"EST-16"},
			                            	{"productid":"FL-DLH-02","productname":"Persian","unitcost":12.00,"status":"P","listprice":89.50,"attr1":"Adult Male","itemid":"EST-17"},
			                            	{"productid":"AV-CB-01","productname":"Amazon Parrot","unitcost":92.00,"status":"P","listprice":63.50,"attr1":"Adult Male","itemid":"EST-18"}
			                            ]};
			 */   


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
				$("#userDatagrid").datagrid('loadData',data);
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
							onSortColumn: onColumnSort,
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
		
		<a href="javascript:void(0)" class="easyui-linkbutton" iconcls="icon-reload" plain="true" onclick="refreshData()">刷新就有数据哦</a>  
		<a href="javascript:void(0)" class="easyui-linkbutton" iconcls="icon-add" plain="true" onclick="newUser()">添加</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton" iconcls="icon-edit" plain="true" onclick="editUser()">修改</a> 
		<a href="javascript:void(0)" class="easyui-linkbutton" iconcls="icon-remove" plain="true" onclick="destroyUser()">删除</a> 
    </div>
	<!-- datagrid end ++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>
