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
    
    <title>常量维护</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script type="text/javascript">

	
	
	/**
	 * 双击事件
	 * rowIndex 行号
	 * rowData 行数据
	 */
	function onRowClick(rowIndex, rowData){
		//alert("datagrid双击" + rowIndex + ";id=" + rowData.code);

		itemGrid.setQueryParams({
			code:rowData.code
		});
		itemGrid.exeQuery(true);
	}

	var myDialog = new $$.Dialog("myDialog");
	myDialog.setTitle("常量维护");
	myDialog.setWidth("345px");
	myDialog.setHeight("340px");
	
	//初始化
	$(function(){
		myDialog.init();
		/*
		editAbleGrp.setItemClickFn(function(checked){
			alert("cc=" + checked);
		});
		*/
		
	});

	

	function showDialog(rowIndex, rowData){
		//alert(333);
		itemTextTB.setValue(rowData.itemText);
		itemCodeTB.setValue(rowData.itemCode);
		myDialog.show();
		
	}

	function save(){
		alert("保存");;
	}
	//DEV_EDIT_FLAG
	function onEditAbleItmeClick(checked, code, text){
		//alert("mm=" + checked + ";code=" + code + "; text=" + text);
		var readOnly = "true";
		if (checked){
			readOnly = "false";
		}
		idTB.setReadOnly(readOnly);
		nameTB.setReadOnly(readOnly);
		codeTB.setReadOnly(readOnly);
		itemCodeTB.setReadOnly(readOnly);
		itemTextTB.setReadOnly(readOnly);
		saveBtn.setDisabled(readOnly);
	}
	</script>
  </head>
  
<body>
	
	<!-- datagrid ++++++++++++++++++++++++++++++++++++++ -->
	<table style="width:100%; height:100%;">
		<tr>
			<td width="450px" valign="top" >
				<e:Grid id="grid" toolbar="+,icon-add,添加"   rowClick="onRowClick" singleSelect="true" showSearchBar="true"  url="frmBasConstant/getConstantList" clazz="com.als.mod.domain.FrmBasConstantVO2">
				</e:Grid>
			</td>
			
			<td valign="top" >
				<div style="text-align: right;">
					<e:Btn id="insertBtn" iconCls="icon-add" text="添加"></e:Btn>
					<e:Btn id="removeBtn" iconCls="icon-remove" text="删除"></e:Btn>
					<e:Btn id="saveBtn" iconCls="icon-save" text="保存"></e:Btn>
				</div>
				<e:Text id="nameText" label="常量组名称"></e:Text>
				<br/>
				<e:Text id="codeText" label="常量组代码"></e:Text>
				<div style="height:400px">
					<e:Grid id="itemGrid" dblRowClick="showDialog" singleSelect="true" showSearchBar="false"  url="frmBasConstant/getConstantItemList" clazz="com.als.mod.domain.FrmBasConstantVO3">
					</e:Grid>
				</div>
			</td>
		</tr>
	</table>

	
	<!-- datagrid end ++++++++++++++++++++++++++++++++++++++ -->
	
	<!-- 弹出面版  ++++++++++++++++++++++++++++++++++++++ -->
	<div id="myDialog" class="alsui-dlog">  
		<div id="toolbar" class="alsui-toolbar"> 
			<e:ChkGrp id="editAbleGrp" conName="DEV_EDIT_FLAG" itemClick="onEditAbleItmeClick"></e:ChkGrp>
			<e:Btn id="saveBtn" text="保存" iconCls="icon-save" btnClick="save" disabled="true"></e:Btn>
		</div>
		<e:Form id="myform">
			<e:Row id="myformRow0">
				<e:Fld id="myformFld0">
					<e:Text id="idTB" label="编号"  labelClass="up" readOnly="true" ></e:Text>
				</e:Fld>
			</e:Row>
			<e:Row id="myformRow1">
				<e:Fld id="myformFld1">
					<e:Text id="nameTB" label="常量名"  labelClass="up" readOnly="true"  ></e:Text>
				</e:Fld>
			</e:Row>
			<e:Row id="myformRow2">
				<e:Fld id="myformFld2">
					<e:Text id="codeTB" label="常量码"  labelClass="up" readOnly="true" ></e:Text>
				</e:Fld>
			</e:Row>
			<e:Row id="myformRow3">
				<e:Fld id="myformFld3">
					<e:Text id="itemCodeTB" label="列码"  labelClass="up" readOnly="true" ></e:Text>
				</e:Fld>
			</e:Row>
			<e:Row id="myformRow4">
				<e:Fld id="myformFld4">
					<e:Text id="itemTextTB" label="列名"  labelClass="up" readOnly="true" ></e:Text>
				</e:Fld>
			</e:Row>
		</e:Form>

	</div> 
	<!-- 弹出面版 end ++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>
