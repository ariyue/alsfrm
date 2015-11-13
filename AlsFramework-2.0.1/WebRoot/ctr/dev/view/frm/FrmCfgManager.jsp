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
    
    <title>参数维护</title>
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
	function onRowDblClick(rowIndex, rowData){
		//alert("datagrid双击" + rowIndex + ";id=" + rowData.code);
		showDialog(rowIndex, rowData);
	
	}

	function showDialog(rowIndex, rowData){
		
		onEditAbleItmeClick(false);
		//alert(editAbleGrp.getVals());
		//alert("aa=" + editAbleGrp.getVals());
		if (editAbleGrp.getVals() == "1"){//如果原来就选上了，改成没有选上
			$("#editAbleGrp").checkbox("unCheck", "1");
		}
		
		//alert("rowData.id=" + rowData.id);
		nameTB.setValue(rowData.name);
		codeTB.setValue(rowData.code);
		idTB.setValue(rowData.id);
		valTB.setValue(rowData.val);
		entitySidTB.setValue(rowData.entitySid);
		remarkTB.setValue(rowData.remark);
		myDialog.show();
		
	}

	var myDialog = new $$.Dialog("myDialog");
	myDialog.setTitle("常量维护");
	myDialog.setWidth("345px");
	//myDialog.setHeight("240px");
	
	//初始化
	$(function(){
		myDialog.init();

		grid.setAddFn(function(){
			showEditWin();
		});

		grid.setDelFn(function(){
			remove();
		});

		grid.setModFn(function(){
			var list = grid.getSelectedData();
			if ((list.length > 0)){
				showDialog(0, list[0]);
				onEditAbleItmeClick(true);
			} else {
				appAlert("系统信息", "没有选中的记录。","warning");
			}
			
		});
		
	});

	function showEditWin(){
		onEditAbleItmeClick(true);
		//alert(editAbleGrp.getVals());
		//alert("aa=" + editAbleGrp.getVals());
		if (editAbleGrp.getVals() != "1"){//没有选上就选 上，如果原来就选上了，再选就会变成没有选上
			$("#editAbleGrp").checkbox("check", "1");
		}
		nameTB.setValue("");
		codeTB.setValue("");
		valTB.setValue("");
		entitySidTB.setValue("");
		remarkTB.setValue("");
		idTB.setValue("");
		myDialog.show();
	}


	//删除事件
	var removeCmd = new $$.Command();
	var url = ROOT_PATH + "frmBasCfg/removeEntity";
	removeCmd.setUrl(url);
	
	function onRemoveBtnClick(){
		appConfirm("删除提示", "确定要删除选中项？", remove);
	}

	//删除
	function remove(){
		var list = grid.getSelectedData();
		if ((list.length > 0)){
			var param = {
					id: list[0].id,
					code: list[0].code,
					gridParam: JSONUtil.encode(grid.getQueryParams())
			};
				
			removeCmd.setParam(param);
			removeCmd.execute();
			//alert(4444);
			if (removeCmd.commandSuccess){
				//alert(5555);
				var result = removeCmd.getResult();
				grid.loadPageData(result);
			}
		} else {
			appAlert("系统信息", "没有选中的记录。","warning");
		}
	}
	

	

	//保存事件
	var saveCmd = new $$.Command();
	var url2 = ROOT_PATH + "frmBasCfg/saveEntity";
	saveCmd.setUrl(url2);
	
	function save(){

		//alert("保存");
		var param = {
				id : idTB.getValue(),
				code: codeTB.getValue(),
				name: nameTB.getValue(),
				val: valTB.getValue(),
				entitySid: entitySidTB.getValue(),
				remark: remarkTB.getValue(),
				gridParam: JSONUtil.encode(grid.getQueryParams())
		};
		saveCmd.setParam(param);
		saveCmd.execute();
		//alert(4444);
		if (saveCmd.commandSuccess){
			//alert(5555);
			var result = saveCmd.getResult();
			grid.loadPageData(result);
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
		valTB.setReadOnly(readOnly);
		entitySidTB.setReadOnly(readOnly);
		remarkTB.setReadOnly(readOnly);
		saveBtn.setDisabled(readOnly);
		
	}

	
	</script>
  </head>
  
<body>
	
	<!-- datagrid ++++++++++++++++++++++++++++++++++++++ -->
	<e:Grid id="grid" toolbar="+,icon-add,新建;x,icon-remove,删除;e,icon-edit,修改"   dblRowClick="onRowDblClick" singleSelect="true" showSearchBar="true"  url="frmBasCfg/getPageList" clazz="com.als.mod.domain.FrmBasCfgVO"></e:Grid>

	
	<!-- datagrid end ++++++++++++++++++++++++++++++++++++++ -->
	
	<!-- 弹出面版  ++++++++++++++++++++++++++++++++++++++ -->
	<div id="myDialog" class="alsui-dlog">  
		<div id="toolbar" class="alsui-dlog-toolbar"> 
			<e:ChkGrp id="editAbleGrp" conName="DEV_EDIT_FLAG" itemClick="onEditAbleItmeClick"></e:ChkGrp>
			<e:Btn id="saveBtn" text="保存" iconCls="icon-save" btnClick="save" disabled="true"></e:Btn>
		</div>
		<div id="myform" class="alsui-dlog-form">
			<ul id="myformRow0" class="alsui-row">
				<li id="myformFld0" class="alsui-fld" style="display:none;">
					<e:Text id="idTB" label="ID"  labelClass="up" ></e:Text>
				</li>
			</ul>
			<ul id="myformRow1" class="alsui-row">
				<li id="myformFld1" class="alsui-fld">
					<e:Text id="nameTB" label="参数名称"  labelClass="up"  required="true" missingMsg="参数名称必输" validType="loginName"></e:Text>
				</li>
			</ul>
			<ul id="myformRow2" class="alsui-row">
				<li id="myformFld2" class="alsui-fld">
					<e:Text id="codeTB" label="参数代码"  labelClass="up"  required="true"  missingMsg="参数代码必输" validType="userName"></e:Text>
				</li>
			</ul>
			<ul id="myformRow3" class="alsui-row">
				<li id="myformFld3" class="alsui-fld">
					<e:Text id="valTB" label="参数值"  labelClass="up"   required="true" missingMsg="参数值必输"></e:Text>
				</li>
			</ul>
			<ul id="myformRow4" class="alsui-row">
				<li id="myformFld4" class="alsui-fld" style="display:none;">
					<e:Text id="entitySidTB" label="企业简码"  labelClass="up" ></e:Text>
				</li>
			</ul>
			<ul id="myformRow5" class="alsui-row">
				<li id="myformFld5" class="alsui-fld">
					<e:Text id="remarkTB" label="备注"  labelClass="up" ></e:Text>
				</li>
			</ul>
		</div>

	</div> 
	<!-- 弹出面版 end ++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>
