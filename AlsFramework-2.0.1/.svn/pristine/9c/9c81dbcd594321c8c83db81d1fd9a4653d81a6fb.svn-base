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
    
    <title>企业模块管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script type="text/javascript">

	
	var myDialog = new $$.Dialog("myDialog");
	myDialog.setTitle("企业系统模块配置");
	myDialog.setWidth("400px");
	myDialog.setHeight("340px");
	
	//保存
	var saveCmd = new $$.Command();
	var saveCmdUrl = ROOT_PATH + "umsentityproduct/save";
	saveCmd.setUrl(saveCmdUrl);

	//删除
	var removeCmd = new $$.Command();
	var removeCmdUrl = ROOT_PATH + "umsentityproduct/remove";
	removeCmd.setUrl(removeCmdUrl);

	function remove(){
		
		var data = mygrid2.getSelectedData();
		if (data.length > 0){
			appConfirm("确认","确认要关闭选中模块？", function(){
				var __obj = data[0];
				removeCmd.setParam({id: __obj.id, entitySid: __obj.entitySid});
				removeCmd.execute();
				if (removeCmd.commandSuccess){
					loadProducts(__obj.entitySid);
				}
			});
			
		} else {
			appAlert("提示", "请选择要删除的系统模块!", "warming");
		}
	}

	//页面初始化-----------------------------------------
	$(function(){
		myDialog.init();
		
	});
	//页面初始化-----------------------------------------
	
	
	function onGridRowClick(rowIndex,rowData){

		var sid = rowData.entitySid;
		loadProducts(sid);
	}

	function loadProducts(entitySid){
		mygrid2.setQueryParams({entitySid: entitySid});
		mygrid2.exeQuery(true);

		myChkGrp.setQueryParams({entitySid: entitySid});
		myChkGrp.loadData();
	}

	function myChkBeforeLoad(param){
		//alert(44444);
		var data = mygrid.getSelectedData();
		var sid = "00000";
		if (data.length > 0){
			sid = data[0].entitySid;
		}
		param.entitySid = sid;
	}


	//开通 
	var openCmd = new $$.Command();
	var openCmdUrl = ROOT_PATH + "umsentityproduct/open";
	openCmd.setUrl(openCmdUrl);
	
	function open(){

		var data = mygrid.getSelectedData();
		var sid = "";
		if (data.length > 0){
			sid = data[0].entitySid;
		} else {
			appAlert("提示", "请选择要开通的系统模块的企业!", "warming");
			return;
		}
		
		var productIds = myChkGrp.getVals();
		var productNames = myChkGrp.getTexts();
		if(productIds == ""){
			appAlert("提示", "请选择要开通的系统模块!", "warming");
			return;
		}
		var param = {
				entitySid: sid,
				productNames: productNames,
				productIds: productIds,
		}
		openCmd.setParam(param);
		openCmd.execute();
		if (openCmd.commandSuccess){
			var result = openCmd.getResult();
			if (result == "success"){
				loadProducts(sid);
			}
		}
		
	}

	function modify(){
		var data = mygrid2.getSelectedData();
		if (data.length > 0){
			
			//alert(555);
			myDialog.show();
			setFormData(data[0]);
			//alert("配置");
		} else {
			appAlert("提示", "请选择要配置的系统模块!", "warming");
		}
	}

	function onGridRowDblClick(rowIndex,rowData){

		myDialog.show();
		setFormData(rowData);
	}

	function save(){

		if($("#myform").form('validate')) { //进行校验并成功  

			var __obj = {newFlag: false};
			getFormData(__obj);
			saveCmd.setParam(__obj);
			saveCmd.execute();
			if (saveCmd.commandSuccess){
				var result = saveCmd.getResult();
				mygrid2.loadPageData(result);
			}
		}
	}

	function setFormData(__obj){
		idTB.setValue(__obj.id);
		entitySidTB.setValue(__obj.entitySid);
		productIdTB.setValue(__obj.productId);
		productNameTB.setValue(__obj.productName);
		validStartDateTB.setValue(__obj.validStartDate);
		validEndDateTB.setValue(__obj.validEndDate);
		validDateTypeTB.setValue(__obj.validDateType);
		createRealNameTB.setValue(__obj.createRealName);
		createUserNameTB.setValue(__obj.createUserName);
		createDateTB.setValue(__obj.createDate);
		createTimeTB.setValue(__obj.createTime);
		lastModifyRealNameTB.setValue(__obj.lastModifyRealName);
		lastModifyUserNameTB.setValue(__obj.lastModifyUserName);
		lastModifyDateTB.setValue(__obj.lastModifyDate);
		lastModifyTimeTB.setValue(__obj.lastModifyTime);
		lastApproveOpitonTB.setValue(__obj.lastApproveOpiton);
		maxUserCountTB.setValue(__obj.maxUserCount);
	}

	function getFormData(__obj){
		__obj.id = idTB.getValue();
		__obj.entitySid = entitySidTB.getValue();
		__obj.productId = productIdTB.getValue();
		__obj.productName = productNameTB.getValue();
		__obj.validStartDate = validStartDateTB.getValue();
		__obj.validEndDate = validEndDateTB.getValue();
		__obj.validDateType = validDateTypeTB.getValue();
		__obj.createRealName = createRealNameTB.getValue();
		__obj.createUserName = createUserNameTB.getValue();
		__obj.createDate = createDateTB.getValue();
		__obj.createTime = createTimeTB.getValue();
		__obj.lastModifyRealName = lastModifyRealNameTB.getValue();
		__obj.lastModifyUserName = lastModifyUserNameTB.getValue();
		__obj.lastModifyDate = lastModifyDateTB.getValue();
		__obj.lastModifyTime = lastModifyTimeTB.getValue();
		__obj.lastApproveOpiton = lastApproveOpitonTB.getValue();
		__obj.maxUserCount = maxUserCountTB.getValue();
	}

	function resetFormData(__obj){
		idTB.setValue("");
		entitySidTB.setValue("");
		productIdTB.setValue("");
		productNameTB.setValue("");
		validStartDateTB.setValue("");
		validEndDateTB.setValue("");
		validDateTypeTB.setValue("");
		createRealNameTB.setValue("");
		createUserNameTB.setValue("");
		createDateTB.setValue("");
		createTimeTB.setValue("");
		lastModifyRealNameTB.setValue("");
		lastModifyUserNameTB.setValue("");
		lastModifyDateTB.setValue("");
		lastModifyTimeTB.setValue("");
		lastApproveOpitonTB.setValue("");
		maxUserCountTB.setValue("");
	}
	

	</script>
  </head>
  
 
<body class="easyui-layout layout" style="height: 100%; overflow: hidden; border: none; margin: 0px; padding: 0px;">
	 	
	 
		
		<!-- west west west west west west west++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<div data-options="region:'west',split:true" style="width:400px;">
			<e:Grid id="mygrid" rowClick="onGridRowClick"  singleSelect="true" showSearchBar="true"  url="umsentity/lookuppage" clazz="com.als.mod.domain.UmsEntityVO3"></e:Grid>
		</div>
		<!-- west west west west west west west end++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		
		<div data-options="region:'east',split:true" style="width:240px;">
			<div class="alsui-toolbar" style="height:30px;line-height:30px; font-weight: 700;font-size:13px;">
					未开通系统模块
			</div>
			<div class="alsui-form">
				<e:ChkGrp id="myChkGrp" url="umsentityproduct/unopendproducts" textField="productName" valField="id" beforeLoad="myChkBeforeLoad"></e:ChkGrp>
				
			</div>
			<div style="margin:10px">
				<e:Btn id="openBTN" text="立即开通" btnClick="open"></e:Btn>
			</div>
		</div>
		
		<!-- center center center center center center center++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->	
		<div data-options="region:'center'">
			<div style="height:30px;line-height:30px; font-weight: 700;font-size:13px;">
				已开通系统模块 
				<e:Btn id ="modifyBTN" btnClick="modify" text="配置"></e:Btn>
				<e:Btn id ="removeBTN" btnClick="remove" text="关闭"></e:Btn>
			</div>
			<div style="height:500px;" >
				<e:Grid id="mygrid2" dblRowClick="onGridRowDblClick" url="umsentityproduct/opendproducts" showSearchBar="false" singleSelect="true" clazz="com.als.mod.domain.UmsEntityProductVO"></e:Grid>
			</div>
			
			
		</div>
		
		
		<!-- center center center center center center center end++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		
		
		<!-- 弹出面版  ++++++++++++++++++++++++++++++++++++++ -->
	<div id="myDialog" class="alsui-dlog">  
		<div id="toolbar" class="alsui-dlog-toolbar"  style="position: static;"> 
			<e:Btn id="saveBTN" btnClick="save" text="保存"></e:Btn>
		</div>
		
		<div id="myform" class="alsui-dlog-form">
			<ul id="myformRow0" class="alsui-row" style="display:none;">
				<li id="myformFld0" class="alsui-fld">
					<e:Text id="idTB" label="ums.entityproduct.id"  labelClass="up" ></e:Text>
				</li>
			</ul>
			<ul id="myformRow1" class="alsui-row" style="display:none;">
				<li id="myformFld1" class="alsui-fld">
					<e:Text id="entitySidTB" label="ums.entityproduct.entitySid"  labelClass="up" ></e:Text>
				</li>
			</ul>
			<ul id="myformRow2" class="alsui-row" style="display:none;">
				<li id="myformFld2" class="alsui-fld">
					<e:Text id="productIdTB" label="ums.entityproduct.productId"  labelClass="up" readOnly="true"></e:Text>
				</li>
			</ul>
			<ul id="myformRow3" class="alsui-row">
				<li id="myformFld3" class="alsui-fld">
					<e:Text id="productNameTB" label="ums.entityproduct.productName"  labelClass="up" readOnly="true"></e:Text>
				</li>
			</ul>
			<ul id="myformRow4" class="alsui-row">
				<li id="myformFld4" class="alsui-fld">
					<e:Label id="validStartDateLB" text="ums.entityproduct.validStartDate"></e:Label><br/>
					<e:DateText id="validStartDateTB"></e:DateText>
				</li>
			</ul>
			<ul id="myformRow5" class="alsui-row">
				<li id="myformFld5" class="alsui-fld">
					<e:Label id="validEndDateLB" text="ums.entityproduct.validEndDate"></e:Label><br/>
					<e:DateText id="validEndDateTB"></e:DateText>
				</li>
			</ul>
			<ul id="myformRow6" class="alsui-row">
				<li id="myformFld6" class="alsui-fld">
					<e:Label id="validDateTypeLB" text="ums.entityproduct.validDateType"></e:Label><br/>
					<e:Combo id="validDateTypeTB" conName="SYS_PRD_VALID_TYPE" editable="false" required="true"></e:Combo>
				</li>
			</ul>
			<ul id="myformRow7" class="alsui-row" style="display:none;">
				<li id="myformFld7" class="alsui-fld">
					<e:Text id="createRealNameTB" label="ums.entityproduct.createRealName"  labelClass="up" ></e:Text>
				</li>
			</ul>
			<ul id="myformRow8" class="alsui-row" style="display:none;">
				<li id="myformFld8" class="alsui-fld">
					<e:Text id="createUserNameTB" label="ums.entityproduct.createUserName"  labelClass="up" ></e:Text>
				</li>
			</ul>
			<ul id="myformRow9" class="alsui-row" style="display:none;">
				<li id="myformFld9" class="alsui-fld">
					<e:Text id="createDateTB" label="ums.entityproduct.createDate"  labelClass="up" ></e:Text>
				</li>
			</ul>
			<ul id="myformRow10" class="alsui-row" style="display:none;">
				<li id="myformFld10" class="alsui-fld">
					<e:Text id="createTimeTB" label="ums.entityproduct.createTime"  labelClass="up" ></e:Text>
				</li>
			</ul>
			<ul id="myformRow11" class="alsui-row" style="display:none;">
				<li id="myformFld11" class="alsui-fld">
					<e:Text id="lastModifyRealNameTB" label="ums.entityproduct.lastModifyRealName"  labelClass="up" ></e:Text>
				</li>
			</ul>
			<ul id="myformRow12" class="alsui-row" style="display:none;">
				<li id="myformFld12" class="alsui-fld">
					<e:Text id="lastModifyUserNameTB" label="ums.entityproduct.lastModifyUserName"  labelClass="up" ></e:Text>
				</li>
			</ul>
			<ul id="myformRow13" class="alsui-row" style="display:none;">
				<li id="myformFld13" class="alsui-fld">
					<e:Text id="lastModifyDateTB" label="ums.entityproduct.lastModifyDate"  labelClass="up" ></e:Text>
				</li>
			</ul>
			<ul id="myformRow14" class="alsui-row" style="display:none;">
				<li id="myformFld14" class="alsui-fld">
					<e:Text id="lastModifyTimeTB" label="ums.entityproduct.lastModifyTime"  labelClass="up" ></e:Text>
				</li>
			</ul>
			<ul id="myformRow15" class="alsui-row" style="display:none;">
				<li id="myformFld15" class="alsui-fld">
					<e:Text id="lastApproveOpitonTB" label="ums.entityproduct.lastApproveOpiton"  labelClass="up" ></e:Text>
				</li>
			</ul>
			<ul id="myformRow16" class="alsui-row">
				<li id="myformFld16" class="alsui-fld">
					<e:Text id="maxUserCountTB" label="ums.entityproduct.maxUserCount"  labelClass="up" required="true" validType="integer" ></e:Text>
				</li>
			</ul>
		</div>
		
	</div>
	
	<!-- 弹出面版  end  ++++++++++++++++++++++++++++++++++++++ -->
		
</body>
</html>
