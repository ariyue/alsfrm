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
    
    <title>主键策略维护</title>
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
		idText.setValue(rowData.id);
		moduleText.setValue(rowData.module);
		entitySidText.setValue(rowData.entitySid);
		cacheSizeText.setValue(rowData.cacheSize);
		prefixText.setValue(rowData.prefix);
		subfixText.setValue(rowData.subfix);
		
		itemGrid.setQueryParams({
			module: rowData.module + rowData.entitySid
		});
		itemGrid.exeQuery(true);
	}

	var myDialog = new $$.Dialog("myDialog");
	myDialog.setTitle("缓存起始值维护");
	myDialog.setWidth("345px");
	myDialog.setHeight("240px");
	
	//初始化
	$(function(){
		myDialog.init();

		grid.setAddFn(function(){

			var newCode = "newCode1";
			moduleText.setValue("新建组名1");
			entitySidText.setValue(newCode);
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
	var url = ROOT_PATH + "frmBasSerial/removeSerial";
	removeCmd.setUrl(url);
	
	function onRemoveBtnClick(){
		appConfirm("删除提示", "确定要删除选中项？", remove);
	}

	//删除
	function remove(){
		var list = grid.getSelectedData();
		if ((list.length > 0)){
			var param = list[0];
			param.gridParam = JSONUtil.encode(grid.getQueryParams());
				
			removeCmd.setParam(param);
			removeCmd.execute();
			//alert(4444);
			if (removeCmd.commandSuccess){
				var result = removeCmd.getResult();
				grid.loadPageData(result);
			}
		} else {
			appAlert("系统信息", "没有选中的记录。","warning");
		}
		
	}
	

	function showDialog(rowIndex, rowData){
		
		onEditAbleItmeClick(false);
		if (editAbleGrp.getVals() == "1"){//如果原来就选上了，改成没有选上
			$("#editAbleGrp").checkbox("unCheck", "1");
		}
		itemIdTB.setValue(rowData.id);
		maxValueTB.setValue(rowData.maxValue);
		myDialog.show();
		
	}


	
	//DEV_EDIT_FLAG
	function onEditAbleItmeClick(checked){
		//alert("mm=" + checked + ";code=" + code + "; text=" + text);
		var readOnly = "true";
		if (checked){
			readOnly = "false";
		}
		itemIdTB.setReadOnly(readOnly);
		maxValueTB.setReadOnly(readOnly);
		saveItemBtn.setDisabled(readOnly);
	}

	function insertEntity(){
		idText.setValue("");
		moduleText.setValue("");
		entitySidText.setValue("");
		cacheSizeText.setValue("");
		prefixText.setValue("");
		subfixText.setValue("");
	}


	//保存事件
	var saveCmd = new $$.Command();
	var url2 = ROOT_PATH + "frmBasSerial/saveSerial";
	saveCmd.setUrl(url2);
	
	function saveEntity(){
		
		var param = {
				id : idText.getValue(),
				module: moduleText.getValue(),
				entitySid: entitySidText.getValue(),
				cacheSize: cacheSizeText.getValue(),
				prefix: prefixText.getValue(),
				subfix: subfixText.getValue(),
				gridParam: JSONUtil.encode(grid.getQueryParams())
		};
		saveCmd.setParam(param);
		saveCmd.execute();
		if (saveCmd.commandSuccess){
			//alert(5555);
			var result = saveCmd.getResult();
			grid.loadPageData(result);
		}
	}

	var updateMaxCmd = new $$.Command();
	var url3 = ROOT_PATH + "frmBasSerial/updateMaxValue";
	updateMaxCmd.setUrl(url3);
	
	function updateMaxValue(){

		var param = {
				id : itemIdTB.getValue(),
				maxValue: maxValueTB.getValue()
		};
		updateMaxCmd.setParam(param);
		updateMaxCmd.execute();
		if (updateMaxCmd.commandSuccess){
			itemGrid.setQueryParams({
				module: moduleText.getValue() + entitySidText.getValue()
			});
			itemGrid.exeQuery(true);
		}
	}
	</script>
  </head>
  
<body>
	
	<!-- datagrid ++++++++++++++++++++++++++++++++++++++ -->
	<table style="width:100%; height:100%;">
		<tr>
			<td width="570px" valign="top" >
				<e:Grid id="grid" rowClick="onRowClick" singleSelect="true" showSearchBar="true"  url="frmBasSerial/getSerialList" clazz="com.als.mod.domain.FrmBasSerialVO">
				</e:Grid>
			</td>
			
			<td valign="top" >
			
			<div class="easyui-layout layout" style="height: 100%; overflow: hidden; border: none; margin: 0px; padding: 0px;">
				<div data-options="region:'north'" style="height:243px">
					<div style="text-align: right;" class="alsui-toolbar">
						<e:Btn id="insertBtn" iconCls="icon-add" text="添加" btnClick="insertEntity"></e:Btn>
						<e:Btn id="removeBtn" btnClick="onRemoveBtnClick" iconCls="icon-remove" text="删除"></e:Btn>
						<e:Btn id="saveBtn" btnClick="saveEntity" iconCls="icon-save" text="保存"></e:Btn>
					</div>
					<div class="alsui-form">
						<ul id="aamyformRow5" class="alsui-row" style="display:none">
							<li id="aamyformFld5" class="alsui-fld">
								<e:Text id="idText" label="ID:"></e:Text>
							</li>
						</ul>
						<ul id="aamyformRow0" class="alsui-row" style="padding-left:10px;">
							<li id="aamyformFld0" class="alsui-fld">
								<e:Text id="moduleText" label="模块名称:" required="true" missingMsg="名称必输"></e:Text>
							</li>
						</ul>
						<ul id="aamyformRow1" class="alsui-row" style="padding-left:10px;">
							<li id="aamyformFld1" class="alsui-fld">
								<e:Text id="entitySidText" label="企业简码:" required="true" missingMsg="代码必输" validType="numberOrLetter" invalidMsg="大写英文字母或下划线组成！"></e:Text>
						</li>
						</ul>
						<ul id="aamyformRow2" class="alsui-row" style="padding-left:10px;">
							<li id="aamyformFld2" class="alsui-fld">
								<e:Text id="cacheSizeText" label="缓存大小:" required="true" missingMsg="缓存大小必输"  validType="integer" invalidMsg="请填数字！"  ></e:Text>
						</li>
						</ul>
						<ul id="aamyformRow3" class="alsui-row" style="padding-left:10px;">
							<li id="aamyformFld3" class="alsui-fld">
								<e:Text id="prefixText" label="　　前辍:" ></e:Text>
						</li>
						</ul>
						<ul id="aamyformRow4" class="alsui-row" style="padding-left:10px;">
							<li id="aamyformFld4" class="alsui-fld">
								<e:Text id="subfixText" label="　　后辍:" ></e:Text>
						</li>
						</ul>
					</div>
				</div>
				<div data-options="region:'center'">
					<e:Grid id="itemGrid" dblRowClick="showDialog" singleSelect="true" showSearchBar="false"  url="frmBasSerial/getSerialItemList" clazz="com.als.mod.domain.FrmBasSerialItemVO">
					</e:Grid>
				</div>
			</div>
			</td>
		</tr>
	</table>

	
	<!-- datagrid end ++++++++++++++++++++++++++++++++++++++ -->
	
	<!-- 弹出面版  ++++++++++++++++++++++++++++++++++++++ -->
	<div id="myDialog" class="alsui-dlog">  
		<div id="toolbar" class="alsui-dlog-toolbar"> 
			<e:ChkGrp id="editAbleGrp" conName="DEV_EDIT_FLAG" itemClick="onEditAbleItmeClick"></e:ChkGrp>
			<e:Btn id="saveItemBtn" text="保存" iconCls="icon-save" btnClick="updateMaxValue" disabled="true"></e:Btn>
		</div>
		<e:Form id="myform">
			<e:Row id="myformRow0">
				<e:Fld id="myformFld0" style="display:none;">
					<e:Text id="itemIdTB" label="ID"  labelClass="up" readOnly="true" ></e:Text>
				</e:Fld>
			</e:Row>
			<e:Row id="myformRow1">
				<e:Fld id="myformFld1">
					<e:Text id="maxValueTB" label="缓存起始值"  labelClass="up" readOnly="true"  required="true" missingMsg="必填" validType="integer" invalidMsg="请填数字！"  ></e:Text>
				</e:Fld>
			</e:Row>
			
		</e:Form>

	</div> 
	<!-- 弹出面版 end ++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>
