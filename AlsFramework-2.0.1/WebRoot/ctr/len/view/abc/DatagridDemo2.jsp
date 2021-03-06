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
    
    <title>数据表格</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script>

	 var users = {total:6,rows:[
	                            {no:1,name:'用户1',addr:'山东济南',email:'user1@163.com',birthday:'1/1/1980'},
	                            {no:2,name:'用户2',addr:'山东济南',email:'user2@163.com',birthday:'1/1/1980'},
	                            {no:3,name:'用户3',addr:'山东济南',email:'user3@163.com',birthday:'1/1/1980'},
	                            {no:4,name:'用户4',addr:'山东济南',email:'user4@163.com',birthday:'1/1/1980'},
	                            {no:5,name:'用户5',addr:'山东济南',email:'user5@163.com',birthday:'1/1/1980'},
	                            {no:6,name:'用户6',addr:'山东济南',email:'user6@163.com',birthday:'1/1/1980'}
	                        ]};
	                        $(function(){
	                            $('#tt').datagrid({
	                                title:'Editable DataGrid',
	                                iconCls:'icon-edit',
	                                width:530,
	                                height:250,
	                                singleSelect:true,
	                                columns:[[
	                                    {field:'no',title:'编号',width:50,editor:'numberbox'},
	                                    {field:'name',title:'名称',width:60,editor:'text'},
	                                    {field:'addr',title:'地址',width:100,editor:'text'},
	                                    {field:'email',title:'电子邮件',width:100,
	                                        editor:{
	                                            type:'validatebox',
	                                            options:{
	                                                validType:'email'
	                                            }
	                                        }
	                                    },
	                                    {field:'birthday',title:'生日',width:80,editor:'datebox'},
	                                    {field:'action',title:'操作',width:70,align:'center',
	                                        formatter:function(value,row,index){
	                                            if (row.editing){
	                                                var s = '<a href="javascript:;" onclick="saverow('+index+')">保存</a> ';
	                                                var c = '<a href="javascript:;" onclick="cancelrow('+index+')">取消</a>';
	                                                return s+c;
	                                            } else {
	                                                var e = '<a href="javascript:;" onclick="editrow('+index+')">编辑</a> ';
	                                                var d = '<a href="javascript:;" onclick="deleterow('+index+')">删除</a>';
	                                                return e+d;
	                                            }
	                                        }
	                                    }
	                                ]],
	                                toolbar:[{
	                                    text:'增加',
	                                    iconCls:'icon-add',
	                                    handler:addrow
	                                },{
	                                    text:'保存',
	                                    iconCls:'icon-save',
	                                    handler:saveall
	                                },{
	                                    text:'取消',
	                                    iconCls:'icon-cancel',
	                                    handler:cancelall
	                                }],
	                                onBeforeEdit:function(index,row){
	                                    row.editing = true;
	                                    $('#tt').datagrid('refreshRow', index);
	                                    editcount++;
	                                },
	                                onAfterEdit:function(index,row){
	                                    row.editing = false;
	                                    $('#tt').datagrid('refreshRow', index);
	                                    editcount--;
	                                },
	                                onCancelEdit:function(index,row){
	                                    row.editing = false;
	                                    $('#tt').datagrid('refreshRow', index);
	                                    editcount--;
	                                }
	                            }).datagrid('loadData',users).datagrid('acceptChanges');
	                        });
	                        var editcount = 0;
	                        function editrow(index){
	                            $('#tt').datagrid('beginEdit', index);
	                        }
	                        function deleterow(index){
	                            $.messager.confirm('确认','是否真的删除?',function(r){
	                                if (r){
	                                    $('#tt').datagrid('deleteRow', index);
	                                }
	                            });
	                        }
	                        function saverow(index){
	                            $('#tt').datagrid('endEdit', index);
	                        }
	                        function cancelrow(index){
	                            $('#tt').datagrid('cancelEdit', index);
	                        }
	                        function addrow(){
	                            if (editcount > 0){
	                                $.messager.alert('警告','当前还有'+editcount+'记录正在编辑，不能增加记录。');
	                                return;
	                            }
	                            $('#tt').datagrid('appendRow',{
	                                no:'',
	                                name:'',
	                                addr:'',
	                                email:'',
	                                birthday:''
	                            });
	                        }
	                        function saveall(){
	                            $('#tt').datagrid('acceptChanges');
	                        }
	                        function cancelall(){
	                            $('#tt').datagrid('rejectChanges');
	                        }
	</script>
  </head>
  
<body>

	<!-- datagrid ++++++++++++++++++++++++++++++++++++++ -->
	<table id="tt"></table>
	<!-- datagrid end ++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>
