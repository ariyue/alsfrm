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
    
    <title>用户授权</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script type="text/javascript">

	var myDialog = new $$.Dialog("myDialog");
	myDialog.setTitle("组织机构选择");
	myDialog.setWidth("600px");
	myDialog.setHeight("400px");

	//是否是新建数据   --------------------------------
	var newFlag = {};//是否是新建 
	function getNewFlag(id){
		if (newFlag[id] != null && newFlag[id]){
			return true;
		}
		return false;
	}
	//是否是新建数据 end--------------------------------
	
	
	
	//保存
	var saveCmd = new $$.Command();
	var saveCmdUrl = ROOT_PATH + "umsauthorize/save";
	saveCmd.setUrl(saveCmdUrl);

	//删除
	var removeCmd = new $$.Command();
	var removeCmdUrl = ROOT_PATH + "umsauthorize/remove";
	removeCmd.setUrl(removeCmdUrl);

	//页面初始化-----------------------------------------
	$(function(){

		myDialog.init();
		mygrid.setAddFn(function(){
			//appendNewData();
		});
		mygrid.setDelFn(function(rows){

			removeData(rows);
		});
	});
	//页面初始化-----------------------------------------
	
	//加载数据前事件
	function beforeGridLoad(param){
		//按这种方法添加更多的参数
		param.my = "my";
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
	
	
	function loadGridDataSuccess(data){

		//alert("加载完成");
		var len = data.rows.length;
		if(len > 0){
			//默认中选第一行
			mygrid.defaultSelectRow(0);
			//将选中的数据填入表单
			setFormData(data.rows[0]);
		} else {
			resetFormData();
		}
		
	}


	
	
	function comBeforeLoad(param){
		
	}
	
	
	function onGridRowClick(rowIndex,rowData){

		setFormData(rowData);
	}

	function resetFormData(__obj){
		idTB.setValue("");
		
	}

	var qryUserRoleCmd = new $$.Command();
	var qryUserRoleCmdUrl = ROOT_PATH + "umsauthorize/getusrroles";
	qryUserRoleCmd.setUrl(qryUserRoleCmdUrl);

	var qryUserUnitCmd = new $$.Command();
	var qryUserUnitCmdUrl = ROOT_PATH + "umsauthorize/getusrunit";
	qryUserUnitCmd.setUrl(qryUserUnitCmdUrl);
	
	function setFormData(__obj){

		idTB.setValue(__obj.id);
		entitySidTB.setValue(__obj.entitySid);

		//授权系统
		//alert("999=" + __obj.umProducts);

		prdChkGrp.setVals(__obj.umProducts);
		prdChkGrp.setQueryParams({entitySid: __obj.entitySid});
		prdChkGrp.loadData();
		

		//组织机构
		qryUserUnitCmd.setParam({id : __obj.id});
		qryUserUnitCmd.execute();
		if (qryUserUnitCmd.commandSuccess){
			var result = qryUserUnitCmd.getResult();
			if (result != null){
				unitIdTB.setValue(result[0]);
				unitNameTB.setValue(result[1]);
			}
			
		}
		
		//角色
		qryUserRoleCmd.setParam({id : __obj.id});
		qryUserRoleCmd.execute();
		if (qryUserRoleCmd.commandSuccess){
			var result = qryUserRoleCmd.getResult();
			roleIdsCB.setVals(result);
		}

	}

	function getFormData(__obj){
		__obj.id = idTB.getValue();
		__obj.unitId =unitIdTB.getValue();
		__obj.products = prdChkGrp.getVals();
		__obj.roles = roleIdsCB.getVals();
		//alert("roles=" + __obj.roles);
	}


	//保存数据
	function saveData(){

		if($("#myform").form('validate')) { //进行校验并成功  
			
			var __obj = {newFlag: false};
			getFormData(__obj);
			//操作完成后进行列表的重新查询时需要
			__obj.gridParam = JSONUtil.encode(mygrid.getQueryParams());
			
			saveCmd.setParam(__obj);
			saveCmd.execute();
			if (saveCmd.commandSuccess){
				mygrid.exeQuery();
				//var __obj = mygrid.getSelectedData()[0];
				//setFormData(__obj)
			}
		}
	}

	//根据ID删除数据
	function removeData(data){

		var __obj = {
				id: data[0].id
			};

		//操作完成后进行列表的重新查询时需要
		__obj.gridParam = JSONUtil.encode(mygrid.getQueryParams());
		
		removeCmd.setParam(__obj);
		removeCmd.execute();
		if (removeCmd.commandSuccess){
			var result = removeCmd.getResult();
			//alert(3333)
			mygrid.loadPageData(result);
		}
	}

	function lookupUnit(){
		var entitySid = entitySidTB.getValue();
		getTreeData(entitySid);
		myDialog.show();
	}


	//树查询CMD
	var treeQryCmd = new $$.Command();
	var qryCmdUrl = ROOT_PATH + "umsunit/lookuptree";
	treeQryCmd.setUrl(qryCmdUrl);

	function getTreeData(entitySid){

		treeQryCmd.setParam({entitySid: entitySid});
		treeQryCmd.execute();
		//alert(4444);
		if (treeQryCmd.commandSuccess){
			
			$("#dataTree").tree({
				data: treeQryCmd.getResult(),
				onBeforeExpand:function(node,param){  
                   //$("#mainMenuAccTree" + id).tree('options').url = "/@info/Home/GetTreeByEasyui?id=" + node.id;
                 },   
                 onClick : function(node){ 
                     //setFormData(node.attributes.nodeEntityObj);
                 },
                 onDblClick: function (node) {  
             	    //$(this).tree(node.state === 'closed' ? 'expand' : 'collapse', node.target);  
            	    //node.state = node.state === 'closed' ? 'open' : 'closed'; 
            	    var obj = node.attributes.nodeEntityObj;
                	unitIdTB.setValue(obj.id);
                	unitNameTB.setValue(obj.unitName);
                	myDialog.hide();
            	} 
			});
		}
	}

	function onMyChange(newValue, oldValue){

	}

	</script>
  </head>
  
 
<body class="easyui-layout layout" style="height: 100%; overflow: hidden; border: none; margin: 0px; padding: 0px;">
	 	
	 
		
		<!-- west west west west west west west++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<div data-options="region:'west',split:true" style="width:540px;">
			<e:Grid id="mygrid" beforeLoad="beforeGridLoad"  loadSuccess="loadGridDataSuccess" rowClick="onGridRowClick"  singleSelect="true" showSearchBar="true"   url="umsuser/lookuppage" clazz="com.als.mod.domain.UmsUserVO"></e:Grid>
		</div>
		<!-- west west west west west west west end++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		
		<!-- center center center center center center center++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->	
		<div data-options="region:'center'">
			<div style="text-align: right;" class="alsui-toolbar" style="">
				<e:Btn id="saveBtn" btnClick="saveData" iconCls="icon-save" text="保存" disabled="false"></e:Btn>
			</div>
			
			<div id="myform" class="alsui-form">
				<ul id="myformRow0" class="alsui-row" >
					<li id="myformFld0" class="alsui-fld">
						<e:Text id="idTB" label="ums.user.id"  labelClass="up" readOnly="true"></e:Text>
					</li>
				</ul>
				
				<ul id="myformRow1" class="alsui-row">
					<li id="myformFld1" class="alsui-fld">
						<e:Text id="unitNameTB" label="ums.unit.unitName"  labelClass="up" readOnly="true" required="true"></e:Text>
						<e:Btn id="unitNameBTN" btnClick="lookupUnit" text="选择"></e:Btn>
					</li>
				</ul>
				
				
				
				
				<ul id="myformRow2" class="alsui-row" style="display:none;">
					<li id="myformFld2" class="alsui-fld">
						<e:Text id="unitIdTB" label="ums.unit.unitId"  labelClass="up" readOnly="true"></e:Text>
					</li>
				</ul>
				
				<ul id="myformRow3" class="alsui-row" >
					<li id="myformFld3" class="alsui-fld">
						<e:Text id="entitySidTB" label="ums.entity.entitySid"  labelClass="up" readOnly="true"></e:Text>
					</li>
				</ul>
				
				
				
				<ul id="myformRow5" class="alsui-row">
					<li id="myformFld5" class="alsui-fld">
						<e:Label id="roleIdsLB" text="ums.UmsRole.roleName"></e:Label><br/>
						<e:Combo id="roleIdsCB" beforeLoad="comBeforeLoad" url="umsrole/getrolelist" textField="roleName" vals="" valField="id" multiple="true" onChange="onMyChange" editable="false"></e:Combo>
					</li>
				</ul>
				
				<ul id="myformRow4" class="alsui-row">
					<li id="myformFld4" class="alsui-fld">
						<e:Label id="umProductsLB" text="ums.user.umProducts"></e:Label><br/>						
						<e:ChkGrp id="prdChkGrp" url="umsentityproduct/enableproducts" textField="productName" valField="id" beforeLoad="myChkBeforeLoad"></e:ChkGrp>
					</li>
				</ul>
				
				
			</div>
		</div>
		<!-- center center center center center center center end++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		
		
		
		<!-- 弹出面版  ++++++++++++++++++++++++++++++++++++++ -->
	<div id="myDialog" class="alsui-dlog">  
		<div id="toolbar" class="alsui-dlog-toolbar"  style="position: static;"> 
			<font color="red">双击相应的组织机构完成选择，取消直接关闭面版即可。</font>
		</div>
		<ul id="dataTree" class="easyui-tree" data-options="lines:true,animate:true" ></ul>  
	</div>
		
</body>
</html>
