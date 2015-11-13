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
    
    <title>角色维护</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script type="text/javascript">



	$(function(){

		//qryData();

		grid.setAddFn(function(){

			var __obj = {};
			__obj.id = "";
			__obj.roleName = "";
			__obj.roleType = "";
			__obj.remark = "";
			__obj.entitySid = "00000";
			__obj.createRealName = "";
			__obj.createUserName = "";
			__obj.createDate = "";
			__obj.createTime = "";
			__obj.lastModifyRealName = "";
			__obj.lastModifyUserName = "";
			__obj.lastModifyDate = "";
			__obj.lastModifyTime = "";
			__obj.lastApproveOption = "";
			__obj.rowOrder = "1";
			setFormData(__obj);
		});
		grid.setDelFn(function(rows){

			var param = {
					id: rows[0].id,
					gridParam: JSONUtil.encode(grid.getQueryParams())
				};
			
			removeCmd.setParam(param);
			removeCmd.execute();
			if (removeCmd.commandSuccess){
				var result = removeCmd.getResult();
				//alert(3333)
				grid.loadPageData(result);
			}
		});

		
	});

	//保存
	var saveCmd = new $$.Command();
	var saveCmdUrl = ROOT_PATH + "umsrole/save";
	saveCmd.setUrl(saveCmdUrl);

	//删除
	var removeCmd = new $$.Command();
	var removeCmdUrl = ROOT_PATH + "umsrole/remove";
	removeCmd.setUrl(removeCmdUrl);

	function onGridRowClick(rowIndex,rowData){
		//alert(rowData.id);
		setFormData(rowData);
	}


	function loadGridDataSuccess(data){

		//alert("加载完成");
		var len = data.rows.length;
		if(len > 0){
			//默认中选第一行
			grid.defaultSelectRow(0);
			//将选中的数据填入表单
			setFormData(data.rows[0]);
		} else {
			resetFormData();
		}
		
	}

	function setFormData(__obj){

		idTB.setValue(__obj.id);
		roleNameTB.setValue(__obj.roleName);
		roleTypeTB.setValue(__obj.roleType);
		remarkTB.setValue(__obj.remark);
		entitySidTB.setValue(__obj.entitySid);
		createRealNameTB.setValue(__obj.createRealName);
		createUserNameTB.setValue(__obj.createUserName);
		createDateTB.setValue(__obj.createDate);
		createTimeTB.setValue(__obj.createTime);
		lastModifyRealNameTB.setValue(__obj.lastModifyRealName);
		lastModifyUserNameTB.setValue(__obj.lastModifyUserName);
		lastModifyDateTB.setValue(__obj.lastModifyDate);
		lastModifyTimeTB.setValue(__obj.lastModifyTime);
		lastApproveOptionTB.setValue(__obj.lastApproveOption);
		rowOrderTB.setValue(__obj.rowOrder);
				
	}

	function getFormData(__obj){
		
		__obj.id = idTB.getValue();
		__obj.roleName = roleNameTB.getValue();
		__obj.roleType = roleTypeTB.getValue();
		__obj.remark = remarkTB.getValue();
		__obj.entitySid = entitySidTB.getValue();
		__obj.createRealName = createRealNameTB.getValue();
		__obj.createUserName = createUserNameTB.getValue();
		__obj.createDate = createDateTB.getValue();
		__obj.createTime = createTimeTB.getValue();
		__obj.lastModifyRealName = lastModifyRealNameTB.getValue();
		__obj.lastModifyUserName = lastModifyUserNameTB.getValue();
		__obj.lastModifyDate = lastModifyDateTB.getValue();
		__obj.lastModifyTime = lastModifyTimeTB.getValue();
		__obj.lastApproveOption = lastApproveOptionTB.getValue();
		__obj.rowOrder = rowOrderTB.getValue();

			
	}

	//保存数据
	function saveData(){

		if($("#myform").form('validate')) { //进行校验并成功  
			var __obj = {};
			getFormData(__obj);
			//操作完成后进行列表的重新查询时需要
			__obj.gridParam = JSONUtil.encode(grid.getQueryParams());
			saveCmd.setParam(__obj);
			saveCmd.execute();
			if (saveCmd.commandSuccess){
				var result = saveCmd.getResult();
				//alert(3333)
				grid.loadPageData(result);
			}
		}
	}

	</script>
  </head>
  
 
<body class="easyui-layout layout" style="height: 100%; overflow: hidden; border: none; margin: 0px; padding: 0px;">
	 	
	 
		
		<!-- west west west west west west west++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<div data-options="region:'west',split:true" style="width:540px;">
			<e:Grid id="grid" loadSuccess="loadGridDataSuccess"  toolbar="+,icon-add,新建;x,icon-remove,删除" rowClick="onGridRowClick"  singleSelect="true" showSearchBar="true"  url="umsrole/lookuppage" clazz="com.als.mod.domain.UmsRoleVO"></e:Grid>
		</div>
		<!-- west west west west west west west end++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		
		<!-- center center center center center center center++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->	
		<div data-options="region:'center'">
			<div style="text-align: right;" class="alsui-toolbar">
				<e:Btn id="saveBtn" btnClick="saveData" iconCls="icon-save" text="保存" disabled="false"></e:Btn>
			</div>
			<div id="myform" class="alsui-form">
				<ul id="myformRow0" class="alsui-row" style="display:none;">
					<li id="myformFld0" class="alsui-fld">
						<e:Text id="idTB" label="ums.UmsRole.id"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow1" class="alsui-row">
					<li id="myformFld1" class="alsui-fld">
						<e:Text id="roleNameTB" label="ums.UmsRole.roleName"  labelClass="up" required="true" validType="loginName" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow2" class="alsui-row" style="display:none;">
					<li id="myformFld2" class="alsui-fld">
						<e:Text id="roleTypeTB" label="ums.UmsRole.roleType"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow3" class="alsui-row">
					<li id="myformFld3" class="alsui-fld">
						<e:Text id="remarkTB" label="ums.UmsRole.remark"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow4" class="alsui-row">
					<li id="myformFld4" class="alsui-fld">
						<e:Label id="entitySidLB" text="ums.user.entitySid"></e:Label><br/>
						<e:Combo id="entitySidTB" url="umsentity/lookupentitycombo" textField="entityName" valField="entitySid"  required="true" editable="false"></e:Combo>
					</li>
				</ul>
				<ul id="myformRow5" class="alsui-row" style="display:none;">
					<li id="myformFld5" class="alsui-fld">
						<e:Text id="createRealNameTB" label="ums.UmsRole.createRealName"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow6" class="alsui-row" style="display:none;">
					<li id="myformFld6" class="alsui-fld">
						<e:Text id="createUserNameTB" label="ums.UmsRole.createUserName"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow7" class="alsui-row" style="display:none;">
					<li id="myformFld7" class="alsui-fld">
						<e:Text id="createDateTB" label="ums.UmsRole.createDate"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow8" class="alsui-row" style="display:none;">
					<li id="myformFld8" class="alsui-fld">
						<e:Text id="createTimeTB" label="ums.UmsRole.createTime"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow9" class="alsui-row" style="display:none;">
					<li id="myformFld9" class="alsui-fld">
						<e:Text id="lastModifyRealNameTB" label="ums.UmsRole.lastModifyRealName"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow10" class="alsui-row" style="display:none;">
					<li id="myformFld10" class="alsui-fld">
						<e:Text id="lastModifyUserNameTB" label="ums.UmsRole.lastModifyUserName"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow11" class="alsui-row" style="display:none;">
					<li id="myformFld11" class="alsui-fld">
						<e:Text id="lastModifyDateTB" label="ums.UmsRole.lastModifyDate"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow12" class="alsui-row" style="display:none;">
					<li id="myformFld12" class="alsui-fld">
						<e:Text id="lastModifyTimeTB" label="ums.UmsRole.lastModifyTime"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow13" class="alsui-row" style="display:none;">
					<li id="myformFld13" class="alsui-fld">
						<e:Text id="lastApproveOptionTB" label="ums.UmsRole.lastApproveOption"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow14" class="alsui-row">
					<li id="myformFld14" class="alsui-fld">
						<e:Text id="rowOrderTB" label="ums.UmsRole.rowOrder"  labelClass="up" ></e:Text>
					</li>
				</ul>
			</div>
		
		</div>
		<!-- center center center center center center center end++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		
		
		
</body>
</html>
