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
		nameText.setValue(rowData.name);
		codeText.setValue(rowData.code);
		
		itemGrid.setQueryParams({
			code:rowData.code
		});
		itemGrid.exeQuery(true);
	}

	var myDialog = new $$.Dialog("myDialog");
	myDialog.setTitle("常量维护");
	myDialog.setWidth("345px");
	//myDialog.setHeight("240px");
	
	//初始化
	$(function(){
		myDialog.init();

		grid.setAddFn(function(){

			var newCode = "newCode1";
			nameText.setValue("新建组名1");
			codeText.setValue(newCode);
			itemGrid.setQueryParams({code: newCode});
			itemGrid.exeQuery(true);
		});
		/*
		editAbleGrp.setItemClickFn(function(checked){
			alert("cc=" + checked);
		});
		*/
		
	});


	//删除事件
	var removeCmd = new $$.Command();
	var url = ROOT_PATH + "frmBasConstant/removeConstant";
	removeCmd.setUrl(url);
	
	function onRemoveBtnClick(){
		appConfirm("删除提示", "确定要删除选中项？", remove);
	}

	//删除
	function remove(){
		var list = itemGrid.getSelectedData();
		if ((list.length > 0)){
			var param = {
					id: list[0].id,
					code: list[0].code	
			};
				
			removeCmd.setParam(param);
			removeCmd.execute();
			//alert(4444);
			if (removeCmd.commandSuccess){
				//alert(5555);
				var result = removeCmd.getResult();
				itemGrid.loadPageData(result);
			}
		} else {
			appAlert("系统信息", "没有选中的记录。","warning");
		}
		
	}
	

	function showDialog(rowIndex, rowData){
		
		onEditAbleItmeClick(false);
		//alert(editAbleGrp.getVals());
		//alert("aa=" + editAbleGrp.getVals());
		if (editAbleGrp.getVals() == "1"){//如果原来就选上了，改成没有选上
			$("#editAbleGrp").checkbox("unCheck", "1");
		}
		
		//alert("rowData.id=" + rowData.id);
		idTB.setValue(rowData.id);
		nameTB.setValue(nameText.getValue());
		codeTB.setValue(codeText.getValue());
		rowOrderTB.setValue(rowData.rowOrder);
		itemTextTB.setValue(rowData.itemText);
		itemCodeTB.setValue(rowData.itemCode);
		myDialog.show();
		
	}


	//保存事件
	var saveCmd = new $$.Command();
	var url2 = ROOT_PATH + "frmBasConstant/saveConstant";
	saveCmd.setUrl(url2);
	
	function save(){

		//alert("保存");
		var param = {
				id : idTB.getValue(),
				code: codeTB.getValue(),
				name: nameTB.getValue(),
				itemCode: itemCodeTB.getValue(),
				itemText: itemTextTB.getValue(),
				rowOrder: rowOrderTB.getValue()
		};
		/*
		alert(idTB.getValue() + ";" + 
				codeTB.getValue() + ";" + 
				nameTB.getValue() + ";" + 
				itemCodeTB.getValue() + ";" + 
				itemTextTB.getValue() + ";" + 
				 rowOrderTB.getValue());
		*/
		saveCmd.setParam(param);
		saveCmd.execute();
		//alert(4444);
		if (saveCmd.commandSuccess){
			//alert(5555);
			var result = saveCmd.getResult();
			itemGrid.loadPageData(result);
		}
	}
	//DEV_EDIT_FLAG
	function onEditAbleItmeClick(checked){
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
		rowOrderTB.setReadOnly(readOnly);
		saveBtn.setDisabled(readOnly);
		
	}

	function addItem(){
		onEditAbleItmeClick(true);
		//alert(editAbleGrp.getVals());
		//alert("aa=" + editAbleGrp.getVals());
		if (editAbleGrp.getVals() != "1"){//没有选上就选 上，如果原来就选上了，再选就会变成没有选上
			$("#editAbleGrp").checkbox("check", "1");
		}
		nameTB.setValue(nameText.getValue());
		codeTB.setValue(codeText.getValue());
		rowOrderTB.setValue("");
		itemTextTB.setValue("");
		itemCodeTB.setValue("");
		idTB.setValue("");
		myDialog.show();
	}
	</script>
  </head>
  
<body>
	
	<!-- datagrid ++++++++++++++++++++++++++++++++++++++ -->
	<table style="width:100%; height:100%;">
		<tr>
			<td width="450px" valign="top" >
				<e:Grid id="grid" toolbar="+,icon-add,新建组"   rowClick="onRowClick" singleSelect="true" showSearchBar="true"  url="frmBasConstant/getConstantList" clazz="com.als.mod.domain.FrmBasConstantVO2">
				</e:Grid>
			</td>
			
			<td valign="top" >
			
			<div class="easyui-layout layout" style="height: 100%; overflow: hidden; border: none; margin: 0px; padding: 0px;">
				<div data-options="region:'north'" style="height:120px">
					<div style="text-align: right;" class="alsui-toolbar">
						<e:Btn id="insertBtn" iconCls="icon-add" text="添加" btnClick="addItem"></e:Btn>
						<e:Btn id="removeBtn" btnClick="onRemoveBtnClick" iconCls="icon-remove" text="删除"></e:Btn>
						<e:Btn id="saveAllBtn" iconCls="icon-save" text="保存" disabled="true"></e:Btn>
					</div>
					<div style="margin-top:20px">
					<ul id="aamyformRow0" class="alsui-row" style="padding-left:10px;">
						<li id="aamyformFld0" class="alsui-fld">
							<e:Text id="nameText" label="常量组名称:" required="true" missingMsg="名称必输" validType="loginName"></e:Text>
						</li>
					</ul>
					<ul id="aamyformRow1" class="alsui-row" style="padding-left:10px;">
						<li id="aamyformFld1" class="alsui-fld">
							<e:Text id="codeText" label="常量组代码:" required="true" missingMsg="代码必输" validType="userName" invalidMsg="大写英文字母或下划线组成！"></e:Text>
					</li>
					</ul>
					</div>
				</div>
				<div data-options="region:'center'">
					<e:Grid id="itemGrid" dblRowClick="showDialog" singleSelect="true" showSearchBar="false"  url="frmBasConstant/getConstantItemList" clazz="com.als.mod.domain.FrmBasConstantVO3">
					</e:Grid>
				</div>
			</div>
			</td>
		</tr>
	</table>

	
	<!-- datagrid end ++++++++++++++++++++++++++++++++++++++ -->
	
	<!-- 弹出面版  ++++++++++++++++++++++++++++++++++++++ -->
	<div id="myDialog" class="alsui-dlog">  
		<div id="toolbar" class="alsui-dlog-toolbar"  style="position: static;"> 
			<e:ChkGrp id="editAbleGrp" conName="DEV_EDIT_FLAG" itemClick="onEditAbleItmeClick"></e:ChkGrp>
			<e:Btn id="saveBtn" text="保存" iconCls="icon-save" btnClick="save" disabled="true"></e:Btn>
		</div>
		<div id="myform" class="alsui-dlog-form">
			<e:Row id="myformRow0">
				<e:Fld id="myformFld0" style="display:none;">
					<e:Text id="idTB" label="ID"  labelClass="up" readOnly="true" ></e:Text>
				</e:Fld>
			</e:Row>
			<e:Row id="myformRow1">
				<e:Fld id="myformFld1"  style="display:none;">
					<e:Text id="nameTB" label="常量组名称"  labelClass="up" readOnly="true"   ></e:Text>
				</e:Fld>
			</e:Row>
			<e:Row id="myformRow2">
				<e:Fld id="myformFld2"  style="display:none;">
					<e:Text id="codeTB" label="常量组代码"  labelClass="up" readOnly="true" ></e:Text>
				</e:Fld>
			</e:Row>
			<e:Row id="myformRow3">
				<e:Fld id="myformFld3">
					<e:Text id="itemTextTB" label="常量名称"  labelClass="up" readOnly="true"  required="true" missingMsg="常量名必输"></e:Text>
				</e:Fld>
			</e:Row>
			<e:Row id="myformRow4">
				<e:Fld id="myformFld4">
					<e:Text id="itemCodeTB" label="常量值"  labelClass="up" readOnly="true"  required="true" missingMsg="常量值必输" validType="numberOrLetter" invalidMsg="大写英文字母或下划线组成！"></e:Text>
				</e:Fld>
			</e:Row>
			<e:Row id="myformRow5">
				<e:Fld id="myformFld5">
					<e:Text id="rowOrderTB" label="顺序"  labelClass="up" readOnly="true" readOnly="true"  required="true" missingMsg="顺序必输" validType="integer" invalidMsg="数字组成！" ></e:Text>
				</e:Fld>
			</e:Row>
		</div>

	</div> 
	<!-- 弹出面版 end ++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>
