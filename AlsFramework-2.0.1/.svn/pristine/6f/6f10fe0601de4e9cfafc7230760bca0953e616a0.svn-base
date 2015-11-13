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
    
    <title>用户信息维护</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script type="text/javascript">


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
	var saveCmdUrl = ROOT_PATH + "umsuser/save";
	saveCmd.setUrl(saveCmdUrl);

	//删除
	var removeCmd = new $$.Command();
	var removeCmdUrl = ROOT_PATH + "umsuser/remove";
	removeCmd.setUrl(removeCmdUrl);

	//页面初始化-----------------------------------------
	$(function(){

		mygrid.setAddFn(function(){
			appendNewData();
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
	//添加新数据
	function appendNewData(){

		var __obj = {};
		__obj.id =  new UUID();//新的结点ID
		__obj.userName = "";
		__obj.password = "";
		__obj.realName = "新用户";
		__obj.email = "";
		__obj.userStatus = "0";
		__obj.userType = "1";
		__obj.isFirstLogon = "";
		__obj.lastLogonTime = "";
		__obj.lastLogonDate = "";
		__obj.isManager = "0";
		__obj.bigPhoto = "";
		__obj.smallPhoto = "";
		__obj.entitySid = "";
		__obj.unitId = "";
		__obj.lastModifyUserName = "";
		__obj.lastModifyDate = "";
		__obj.lastModifyTime = "";
		__obj.lastApproveOption = "";
		__obj.createRealName = "";
		__obj.createUserName = "";
		__obj.createDate = "";
		__obj.createTime = "";
		__obj.lastModifyRealName = "";
		__obj.umProducts = "";
		__obj.skin = "";
		__obj.certSn = "";
		__obj.certDn = "";

		//新建数据标识
		newFlag[__obj.id] = true;
		//添加新行并自动选中
		mygrid.appendRow(__obj);
		//设置表单
		setFormData(__obj);
	}
	
	function onGridRowClick(rowIndex,rowData){

		setFormData(rowData);
	}

	function resetFormData(__obj){
		idTB.setValue("");
		userNameTB.setValue("");
		passwordTB.setValue("");
		realNameTB.setValue("");
		emailTB.setValue("");
		userStatusTB.setValue("");
		userTypeTB.setValue("");
		isFirstLogonTB.setValue("");
		lastLogonTimeTB.setValue("");
		lastLogonDateTB.setValue("");
		isManagerTB.setValue("");
		bigPhotoTB.setValue("");
		smallPhotoTB.setValue("");
		entitySidTB.setValue("");
		unitIdTB.setValue("");
		lastModifyUserNameTB.setValue("");
		lastModifyDateTB.setValue("");
		lastModifyTimeTB.setValue("");
		lastApproveOptionTB.setValue("");
		createRealNameTB.setValue("");
		createUserNameTB.setValue("");
		createDateTB.setValue("");
		createTimeTB.setValue("");
		lastModifyRealNameTB.setValue("");
		umProductsTB.setValue("");
		skinTB.setValue("");

		certSnTB.setValue("");
		certDnTB.setValue("");
	}

	function setFormData(__obj){
		idTB.setValue(__obj.id);
		userNameTB.setValue(__obj.userName);
		passwordTB.setValue(__obj.password);
		realNameTB.setValue(__obj.realName);
		emailTB.setValue(__obj.email);
		userStatusTB.setValue(__obj.userStatus);
		userTypeTB.setValue(__obj.userType);
		isFirstLogonTB.setValue(__obj.isFirstLogon);
		lastLogonTimeTB.setValue(__obj.lastLogonTime);
		lastLogonDateTB.setValue(__obj.lastLogonDate);
		isManagerTB.setValue(__obj.isManager);
		bigPhotoTB.setValue(__obj.bigPhoto);
		smallPhotoTB.setValue(__obj.smallPhoto);
		entitySidTB.setValue(__obj.entitySid);
		unitIdTB.setValue(__obj.unitId);
		lastModifyUserNameTB.setValue(__obj.lastModifyUserName);
		lastModifyDateTB.setValue(__obj.lastModifyDate);
		lastModifyTimeTB.setValue(__obj.lastModifyTime);
		lastApproveOptionTB.setValue(__obj.lastApproveOption);
		createRealNameTB.setValue(__obj.createRealName);
		createUserNameTB.setValue(__obj.createUserName);
		createDateTB.setValue(__obj.createDate);
		createTimeTB.setValue(__obj.createTime);
		lastModifyRealNameTB.setValue(__obj.lastModifyRealName);
		umProductsTB.setValue(__obj.umProducts);
		skinTB.setValue(__obj.skin);

		certSnTB.setValue(__obj.certSn);
		certDnTB.setValue(__obj.certDn);
	}

	function getFormData(__obj){
		__obj.id = idTB.getValue();
		__obj.userName = userNameTB.getValue();
		__obj.password = passwordTB.getValue();
		__obj.realName = realNameTB.getValue();
		__obj.email = emailTB.getValue();
		__obj.userStatus = userStatusTB.getValue();
		__obj.userType = userTypeTB.getValue();
		__obj.isFirstLogon = isFirstLogonTB.getValue();
		__obj.lastLogonTime = lastLogonTimeTB.getValue();
		__obj.lastLogonDate = lastLogonDateTB.getValue();
		__obj.isManager = isManagerTB.getValue();
		__obj.bigPhoto = bigPhotoTB.getValue();
		__obj.smallPhoto = smallPhotoTB.getValue();
		__obj.entitySid = entitySidTB.getValue();
		__obj.unitId = unitIdTB.getValue();
		__obj.lastModifyUserName = lastModifyUserNameTB.getValue();
		__obj.lastModifyDate = lastModifyDateTB.getValue();
		__obj.lastModifyTime = lastModifyTimeTB.getValue();
		__obj.lastApproveOption = lastApproveOptionTB.getValue();
		__obj.createRealName = createRealNameTB.getValue();
		__obj.createUserName = createUserNameTB.getValue();
		__obj.createDate = createDateTB.getValue();
		__obj.createTime = createTimeTB.getValue();
		__obj.lastModifyRealName = lastModifyRealNameTB.getValue();
		__obj.umProducts = umProductsTB.getValue();
		__obj.skin = skinTB.getValue();
		__obj.certSn = certSnTB.getValue();
		__obj.certDn = certDnTB.getValue();
	}


	//保存数据
	function saveData(){

		if($("#myform").form('validate')) { //进行校验并成功  
			
			var __obj = {newFlag: getNewFlag(idTB.getValue())};
			getFormData(__obj);
			//操作完成后进行列表的重新查询时需要
			__obj.gridParam = JSONUtil.encode(mygrid.getQueryParams());
			
			saveCmd.setParam(__obj);
			saveCmd.execute();
			if (saveCmd.commandSuccess){
				var result = saveCmd.getResult();
				mygrid.loadPageData(result);
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


	</script>
  </head>
  
 
<body class="easyui-layout layout" style="height: 100%; overflow: hidden; border: none; margin: 0px; padding: 0px;">
	 	
	 
		
		<!-- west west west west west west west++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<div data-options="region:'west',split:true" style="width:540px;">
			<e:Grid id="mygrid" toolbar="+,icon-add,新建;x,icon-remove,删除" beforeLoad="beforeGridLoad"  loadSuccess="loadGridDataSuccess" rowClick="onGridRowClick"  singleSelect="true" showSearchBar="true"   url="umsuser/lookuppage" clazz="com.als.mod.domain.UmsUserVO"></e:Grid>
		</div>
		<!-- west west west west west west west end++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		
		<!-- center center center center center center center++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->	
		<div data-options="region:'center'">
			<div style="text-align: right;" class="alsui-toolbar" style="">
				<e:Btn id="saveBtn" btnClick="saveData" iconCls="icon-save" text="保存" disabled="false"></e:Btn>
			</div>
			
			<div id="myform" class="alsui-form">
				<ul id="myformRow0" class="alsui-row" style="display:none;">
					<li id="myformFld0" class="alsui-fld">
						<e:Text id="idTB" label="ums.user.id"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow1" class="alsui-row">
					<li id="myformFld1" class="alsui-fld">
						<e:Text id="userNameTB" label="ums.user.userName"  labelClass="up" required="true" validType="userName"></e:Text>
					</li>
				</ul>
				<ul id="myformRow2" class="alsui-row" style="display:none;">
					<li id="myformFld2" class="alsui-fld">
						<e:Text id="passwordTB" label="ums.user.password"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow3" class="alsui-row">
					<li id="myformFld3" class="alsui-fld">
						<e:Text id="realNameTB" label="ums.user.realName"  labelClass="up" required="true" validType="loginName" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow4" class="alsui-row">
					<li id="myformFld4" class="alsui-fld">
						<e:Text id="emailTB" label="ums.user.email"  labelClass="up" validType="email"></e:Text>
					</li>
				</ul>
				<ul id="myformRow5" class="alsui-row" style="display:none;">
					<li id="myformFld5" class="alsui-fld">
						<e:Text id="userStatusTB" label="ums.user.userStatus"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow6" class="alsui-row" style="display:none;">
					<li id="myformFld6" class="alsui-fld">
						<e:Text id="userTypeTB" label="ums.user.userType"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow7" class="alsui-row" style="display:none;">
					<li id="myformFld7" class="alsui-fld">
						<e:Text id="isFirstLogonTB" label="ums.user.isFirstLogon"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow8" class="alsui-row" style="display:none;">
					<li id="myformFld8" class="alsui-fld">
						<e:Text id="lastLogonTimeTB" label="ums.user.lastLogonTime"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow9" class="alsui-row" style="display:none;">
					<li id="myformFld9" class="alsui-fld">
						<e:Text id="lastLogonDateTB" label="ums.user.lastLogonDate"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow10" class="alsui-row" style="display:none;">
					<li id="myformFld10" class="alsui-fld">
						<e:Text id="isManagerTB" label="ums.user.isManager"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow11" class="alsui-row" >
					<li id="myformFld11" class="alsui-fld">
						<e:Text id="bigPhotoTB" label="ums.user.bigPhoto"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow12" class="alsui-row">
					<li id="myformFld12" class="alsui-fld">
						<e:Text id="smallPhotoTB" label="ums.user.smallPhoto"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow13" class="alsui-row">
					<li id="myformFld13" class="alsui-fld">
						<e:Label id="entitySidLB" text="ums.user.entitySid"></e:Label><br/>
						<e:Combo id="entitySidTB" url="umsentity/lookupentitycombo" textField="entityName" valField="entitySid" ></e:Combo>
					</li>
				</ul>
				<ul id="myformRow14" class="alsui-row" style="display:none;">
					<li id="myformFld14" class="alsui-fld">
						<e:Text id="unitIdTB" label="ums.user.unitId"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow15" class="alsui-row" style="display:none;">
					<li id="myformFld15" class="alsui-fld">
						<e:Text id="lastModifyUserNameTB" label="ums.user.lastModifyUserName"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow16" class="alsui-row" style="display:none;">
					<li id="myformFld16" class="alsui-fld">
						<e:Text id="lastModifyDateTB" label="ums.user.lastModifyDate"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow17" class="alsui-row" style="display:none;">
					<li id="myformFld17" class="alsui-fld">
						<e:Text id="lastModifyTimeTB" label="ums.user.lastModifyTime"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow18" class="alsui-row" style="display:none;">
					<li id="myformFld18" class="alsui-fld">
						<e:Text id="lastApproveOptionTB" label="ums.user.lastApproveOption"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow19" class="alsui-row" style="display:none;">
					<li id="myformFld19" class="alsui-fld">
						<e:Text id="createRealNameTB" label="ums.user.createRealName"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow20" class="alsui-row" style="display:none;">
					<li id="myformFld20" class="alsui-fld">
						<e:Text id="createUserNameTB" label="ums.user.createUserName"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow21" class="alsui-row" style="display:none;">
					<li id="myformFld21" class="alsui-fld">
						<e:Text id="createDateTB" label="ums.user.createDate"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow22" class="alsui-row" style="display:none;">
					<li id="myformFld22" class="alsui-fld">
						<e:Text id="createTimeTB" label="ums.user.createTime"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow23" class="alsui-row" style="display:none;">
					<li id="myformFld23" class="alsui-fld">
						<e:Text id="lastModifyRealNameTB" label="ums.user.lastModifyRealName"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow24" class="alsui-row" style="display:none;">
					<li id="myformFld24" class="alsui-fld">
						<e:Text id="umProductsTB" label="ums.user.umProducts"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow25" class="alsui-row" style="display:none;">
					<li id="myformFld25" class="alsui-fld">
						<e:Text id="skinTB" label="ums.user.skin"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow29" class="alsui-row">
					<li id="myformFld29" class="alsui-fld">
						<e:Text id="certSnTB" label="ums.user.certSn"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow30" class="alsui-row">
					<li id="myformFld30" class="alsui-fld">
						<e:Text id="certDnTB" label="ums.user.certDn"  labelClass="up" ></e:Text>
					</li>
				</ul>
			</div>
		</div>
		<!-- center center center center center center center end++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		
		
		
</body>
</html>
