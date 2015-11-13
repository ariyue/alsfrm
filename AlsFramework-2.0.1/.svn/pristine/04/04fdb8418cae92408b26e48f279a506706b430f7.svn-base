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

	<script type="text/javascript">

	/**
	 * 单击事件
	 * rowIndex 行号
	 * rowData 行数据
	 */
	function myRowClick(rowIndex, rowData){
		alert("datagrid单击" + rowIndex + ";id=" + rowData.id);
	}
	
	/**
	 * 双击事件
	 * rowIndex 行号
	 * rowData 行数据
	 */
	function myDblClick(rowIndex, rowData){
		alert("datagrid双击" + rowIndex + ";id=" + rowData.id);
	}


	$(function(){
		
		//增加按钮事件
		datagrid.setAddFn(function(){
			alert("打开新的tab页，增加一条数据!");
			 
		});
		//修改（编辑按钮事件)
		datagrid.setModFn(function(row){
			alert("打开新的tab页，修改一条数据!realName=" + row.realName);
			 
		});

		//批量删除
		datagrid.setDelFn(function(rows){
			if (rows.length == 0){
				alert("请选中要删除的数据！");
			} else {
				alert("要删除realName=" +rows[0].realName);
			}
			
			 
		});

		datagrid.setExtFn1(function(rows){

			alert("自定义按钮1")
			
			 
		});
	});

	
	
	</script>
  </head>
  
<body>

	<!-- datagrid ++++++++++++++++++++++++++++++++++++++ -->
	<e:Grid id="datagrid" toolbar="+,icon-add,添加;x,icon-remove,删除;e,icon-edit,修改;|,,;1,icon-ok,自定义按钮1"  dblRowClick="myDblClick" singleSelect="false" showSearchBar="true"  url="abcUser/queryPageList" clazz="com.als.mod.domain.AbcUser">
	</e:Grid>
	<!-- datagrid end ++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>
