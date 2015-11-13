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
    
    <title>产品信息维护</title>
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
		
		//表单赋值---------------
		productNameTB.setValue(rowData.productName);
		menuIdTB.setValue(rowData.menuId);
		idTB.setValue(rowData.id);
		priceTB.setValue(rowData.price);
		remarkTB.setValue(rowData.remark);
		transCodeTB.setValue(rowData.transCode);

		//userTypeTB.setValue(rowData.userType);
		projectDateTB.setValue(rowData.projectDate);
		developDateTB.setValue(rowData.developDate);
		onlineDateTB.setValue(rowData.onlineDate);
		//表单赋值 end ---------------
		myDialog.show();
		
	}

	var myDialog = new $$.Dialog("myDialog");
	myDialog.setTitle("常量维护");
	myDialog.setWidth("360px");
	myDialog.setHeight("300px");
	
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
		//表单赋值---------------
		productNameTB.setValue("");
		menuIdTB.setValue("");
		idTB.setValue("");
		priceTB.setValue("");
		remarkTB.setValue("");
		transCodeTB.setValue("");

		//userTypeTB.setValue("");
		projectDateTB.setValue("");
		developDateTB.setValue("");
		onlineDateTB.setValue("");
		//表单赋值 end ---------------
		myDialog.show();
	}


	//删除事件
	var removeCmd = new $$.Command();
	var url = ROOT_PATH + "umsproduct/remove";
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
	var url2 = ROOT_PATH + "umsproduct/save";
	saveCmd.setUrl(url2);
	
	function save(){

		//alert("保存");
		
		
		//获取参数值---------------------------------------------------
		var param = {
				id : idTB.getValue(),
				productName: productNameTB.getValue(),
				menuId: menuIdTB.getValue(),
				price: priceTB.getValue(),
				//entitySid: entitySidTB.getValue(),
				remark: remarkTB.getValue(),
				transCode:transCodeTB.getValue(),
				//userType:userTypeTB.getValue(),
				projectDate:projectDateTB.getValue(),
				developDate: developDateTB.getValue(),
				onlineDate: onlineDateTB.getValue(),
				
				//以下参数一般固定即可（表格查询参数、值)
				gridParam: JSONUtil.encode(grid.getQueryParams())
		};
		//获取参数值 end---------------------------------------------------
		
		
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

		productNameTB.setReadOnly(readOnly);
		menuIdTB.setReadOnly(readOnly);
		idTB.setReadOnly(readOnly);
		priceTB.setReadOnly(readOnly);
		remarkTB.setReadOnly(readOnly);
		transCodeTB.setReadOnly(readOnly);

		//userTypeTB.setReadOnly(readOnly);
		projectDateTB.setReadOnly(readOnly);
		developDateTB.setReadOnly(readOnly);
		onlineDateTB.setReadOnly(readOnly);
		
		saveBtn.setDisabled(readOnly);



		
		
	}

	
	</script>
  </head>
  
<body>
	
	<!-- datagrid ++++++++++++++++++++++++++++++++++++++ -->
	<e:Grid id="grid" toolbar="+,icon-add,新建;x,icon-remove,删除;e,icon-edit,修改"   dblRowClick="onRowDblClick" singleSelect="true" showSearchBar="true"  url="umsproduct/lookuppage" clazz="com.als.mod.domain.UmsProductVO"></e:Grid>

	
	<!-- datagrid end ++++++++++++++++++++++++++++++++++++++ -->
	
	<!-- 弹出面版  ++++++++++++++++++++++++++++++++++++++ -->
	<div id="myDialog" class="alsui-dlog">  
		<div id="toolbar" class="alsui-dlog-toolbar"> 
			<e:ChkGrp id="editAbleGrp" conName="DEV_EDIT_FLAG" itemClick="onEditAbleItmeClick"></e:ChkGrp>
			<e:Btn id="saveBtn" text="保存" iconCls="icon-save" btnClick="save" disabled="true"></e:Btn>
		</div>
		<div id="myform" class="alsui-dlog-form">
			<ul id="myformRow0" class="alsui-row" style="display:none;">
				<li id="myformFld0" class="alsui-fld">
					<e:Text id="idTB" label="编号"  labelClass="up" ></e:Text>
				</li>
			</ul>
			<ul id="myformRow1" class="alsui-row">
				<li id="myformFld1" class="alsui-fld">
					<e:Text id="productNameTB" label="产品名称"  labelClass="up" ></e:Text>
				</li>
			</ul>
			<ul id="myformRow2" class="alsui-row">
				<li id="myformFld2" class="alsui-fld">
					<e:Text id="menuIdTB" label="菜单ID"  labelClass="up" ></e:Text>
				</li>
			</ul>
			<ul id="myformRow3" class="alsui-row">
				<li id="myformFld3" class="alsui-fld">
					<e:Text id="priceTB" label="价格"  labelClass="up" ></e:Text>
				</li>
			</ul>
			<ul id="myformRow4" class="alsui-row">
				<li id="myformFld4" class="alsui-fld">
					<e:Text id="remarkTB" label="说明"  labelClass="up" ></e:Text>
				</li>
			</ul>
			<ul id="myformRow5" class="alsui-row">
				<li id="myformFld5" class="alsui-fld">
					<e:Text id="transCodeTB" label="交易码"  labelClass="up" ></e:Text>
				</li>
			</ul>
			<ul id="myformRow7" class="alsui-row">
				<li id="myformFld7" class="alsui-fld">
					<label>立项日期</label><p></p>
					<e:DateText id="projectDateTB" ></e:DateText>
				</li>
			</ul>
			<ul id="myformRow8" class="alsui-row">
				<li id="myformFld8" class="alsui-fld">
					<label>开发日期</label><p></p>
					<e:DateText id="developDateTB" ></e:DateText>
				</li>
			</ul>
			<ul id="myformRow9" class="alsui-row">
				<li id="myformFld9" class="alsui-fld">
					<label>上线日期</label><p></p>
					<e:DateText id="onlineDateTB"></e:DateText>
				</li>
			</ul>
		</div>

	</div> 
	<!-- 弹出面版 end ++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>
