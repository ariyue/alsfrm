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

	
		
	var Address = [{ "value": "1", "text": "CHINA" }, { "value": "2", "text": "USA" }, { "value": "3", "text": "Koren" }];
	 
	 
	function unitformatter(value, rowData, rowIndex) {
	    if (value == 0) {
	        return;
	    }
	 
	    for (var i = 0; i < Address.length; i++) {
	        if (Address[i].value == value) {
	            return Address[i].text;
	        }
	    }
	}

	$(function(){
		
		GetTable();
	});
	function GetTable() {
	    var editRow = undefined;
	 
	    $("#userDatagrid").datagrid({
	        height: 300,
	        width: 450,
	        title: '学生表',
	        collapsible: true,
	        singleSelect: true,
	        url: '/Home/StuList',
	        idField: 'ID',
	        columns: [[
	         { field: 'ID', title: 'ID', width: 100 },
	            { field: 'Name', title: '姓名', width: 100, editor: { type: 'text', options: { required: true } } },
	            { field: 'Age', title: '年龄', width: 100, align: 'center', editor: { type: 'text', options: { required: true } } },
	            { field: 'Address', title: '地址', width: 100, formatter: unitformatter, align: 'center', editor: { type: 'combobox', options: { data: Address, valueField: "value", textField: "text" } } }
	        ]],
	        toolbar: [{
	            text: '添加', iconCls: 'icon-add', handler: function () {
	                if (editRow != undefined) {
	                    $("#userDatagrid").datagrid('endEdit', editRow);
	                }
	                if (editRow == undefined) {
	                    $("#userDatagrid").datagrid('insertRow', {
	                        index: 0,
	                        row: {}
	                    });
	 
	                    $("#userDatagrid").datagrid('beginEdit', 0);
	                    editRow = 0;
	                }
	            }
	        }, '-', {
	            text: '保存', iconCls: 'icon-save', handler: function () {
	                $("#userDatagrid").datagrid('endEdit', editRow);
	 
	                //如果调用acceptChanges(),使用getChanges()则获取不到编辑和新增的数据。
	 
	                //使用JSON序列化datarow对象，发送到后台。
	                var rows = $("#userDatagrid").datagrid('getChanges');
	 
	                var rowstr = JSON.stringify(rows);
	                $.post('/Home/Create', rowstr, function (data) {
	 
	                });
	            }
	        }, '-', {
	            text: '撤销', iconCls: 'icon-redo', handler: function () {
	                editRow = undefined;
	                $("#userDatagrid").datagrid('rejectChanges');
	                $("#userDatagrid").datagrid('unselectAll');
	            }
	        }, '-', {
	            text: '删除', iconCls: 'icon-remove', handler: function () {
	                var row = $("#userDatagrid").datagrid('getSelections');
	 
	            }
	        }, '-', {
	            text: '修改', iconCls: 'icon-edit', handler: function () {
	                var row = $("#userDatagrid").datagrid('getSelected');
	                if (row != null) {
	                    if (editRow != undefined) {
	                        $("#userDatagrid").datagrid('endEdit', editRow);
	                    }
	 
	                    if (editRow == undefined) {
	                        var index = $("#userDatagrid").datagrid('getRowIndex', row);
	                        $("#userDatagrid").datagrid('beginEdit', index);
	                        editRow = index;
	                        $("#userDatagrid").datagrid('unselectAll');
	                    }
	                } else {
	 
	                }
	            }
	        }, '-', {
	            text: '上移', iconCls: 'icon-up', handler: function () {
	                MoveUp();
	            }
	        }, '-', {
	            text: '下移', iconCls: 'icon-down', handler: function () {
	                MoveDown();
	            }
	        }],
	        onAfterEdit: function (rowIndex, rowData, changes) {
	            editRow = undefined;
	        },
	        onDblClickRow: function (rowIndex, rowData) {
	            if (editRow != undefined) {
	                $("#userDatagrid").datagrid('endEdit', editRow);
	            }
	 
	            if (editRow == undefined) {
	                $("#userDatagrid").datagrid('beginEdit', rowIndex);
	                editRow = rowIndex;
	            }
	        },
	        onClickRow: function (rowIndex, rowData) {
	            if (editRow != undefined) {
	                $("#userDatagrid").datagrid('endEdit', editRow);
	 
	            }
	 
	        }
	 
	    });
	}

	</script>
  </head>
  
<body>

	<!-- datagrid ++++++++++++++++++++++++++++++++++++++ -->
	<table id="userDatagrid" class="easyui-datagrid"></table>
	
	<!-- datagrid end ++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>
