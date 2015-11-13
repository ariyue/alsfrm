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
    
    <title>企业信息维护</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script type="text/javascript">

	//是否是新建数据
	var newFlag = false;
	
	//保存
	var saveCmd = new $$.Command();
	var saveCmdUrl = ROOT_PATH + "umsentity/save";
	saveCmd.setUrl(saveCmdUrl);

	//删除
	var removeCmd = new $$.Command();
	var removeCmdUrl = ROOT_PATH + "umsentity/remove";
	removeCmd.setUrl(removeCmdUrl);

	//页面初始化-----------------------------------------
	$(function(){

		mygrid.setAddFn(function(){
			appendNewData();
		});
		mygrid.setDelFn(function(rows){


			
			var __obj = {
					id: rows[0].id
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
		});
	});
	//页面初始化-----------------------------------------
	
	
	function onGridRowClick(rowIndex,rowData){
		newFlag = false;
		setFormData(rowData);
	}

	//添加新数据
	function appendNewData(){

		var __obj = {};
		__obj.id =  new UUID();//新的结点ID
		
		__obj.entityName = "新企业";
		__obj.entitySname = "";
		__obj.email = "";
		__obj.entityStatus = "";
		__obj.entityType = "";
		__obj.openDate = "";
		__obj.openTime = "";
		__obj.bankAccountNo = "";
		__obj.bankCode = "";
		__obj.validPeriod = "";
		__obj.maxUserCount = "";
		__obj.maxDiskSpace = "";
		__obj.createRealName = "";
		__obj.createUserName = "";
		__obj.createDate ="";
		__obj.createTime = "";
		__obj.lastModifyRealName = "";
		__obj.lastModifyUserName = "";
		__obj.lastModifyDate = "";
		__obj.lastModifyTime = "";
		__obj.lastApproveOption = "";
		__obj.smallLogo = "";
		__obj.bigLogo = "";
		__obj.entitySid = "";
		__obj.deleteFlag = "";
		__obj.certDn = "";

		//新建数据标识
		newFlag = true;
		//添加新行并自动选中
		mygrid.appendRow(__obj);
		//设置表单
		setFormData(__obj);
	}

	function resetFormData(__obj){
		idTB.setValue("");
		entityNameTB.setValue("");
		entitySnameTB.setValue("");
		emailTB.setValue("");
		entityStatusTB.setValue("");
		entityTypeTB.setValue("");
		openDateTB.setValue("");
		openTimeTB.setValue("");
		bankAccountNoTB.setValue("");
		bankCodeTB.setValue("");
		validPeriodTB.setValue("");
		maxUserCountTB.setValue("");
		maxDiskSpaceTB.setValue("");
		createRealNameTB.setValue("");
		createUserNameTB.setValue("");
		createDateTB.setValue("");
		createTimeTB.setValue("");
		lastModifyRealNameTB.setValue("");
		lastModifyUserNameTB.setValue("");
		lastModifyDateTB.setValue("");
		lastModifyTimeTB.setValue("");
		lastApproveOptionTB.setValue("");
		smallLogoTB.setValue("");
		bigLogoTB.setValue("");
		entitySidTB.setValue("");
		deleteFlagTB.setValue("n");
	}

	function setFormData(__obj){
		idTB.setValue(__obj.id);
		entityNameTB.setValue(__obj.entityName);
		entitySnameTB.setValue(__obj.entitySname);
		emailTB.setValue(__obj.email);
		entityStatusTB.setValue(__obj.entityStatus);
		entityTypeTB.setValue(__obj.entityType);
		openDateTB.setValue(__obj.openDate);
		openTimeTB.setValue(__obj.openTime);
		bankAccountNoTB.setValue(__obj.bankAccountNo);
		bankCodeTB.setValue(__obj.bankCode);
		validPeriodTB.setValue(__obj.validPeriod);
		maxUserCountTB.setValue(__obj.maxUserCount);
		maxDiskSpaceTB.setValue(__obj.maxDiskSpace);
		createRealNameTB.setValue(__obj.createRealName);
		createUserNameTB.setValue(__obj.createUserName);
		createDateTB.setValue(__obj.createDate);
		createTimeTB.setValue(__obj.createTime);
		lastModifyRealNameTB.setValue(__obj.lastModifyRealName);
		lastModifyUserNameTB.setValue(__obj.lastModifyUserName);
		lastModifyDateTB.setValue(__obj.lastModifyDate);
		lastModifyTimeTB.setValue(__obj.lastModifyTime);
		lastApproveOptionTB.setValue(__obj.lastApproveOption);
		smallLogoTB.setValue(__obj.smallLogo);
		bigLogoTB.setValue(__obj.bigLogo);
		entitySidTB.setValue(__obj.entitySid);
		deleteFlagTB.setValue(__obj.deleteFlag);

	}

	function getFormData(__obj){
		__obj.id = idTB.getValue();
		__obj.entityName = entityNameTB.getValue();
		__obj.entitySname = entitySnameTB.getValue();
		__obj.email = emailTB.getValue();
		__obj.entityStatus = entityStatusTB.getValue();
		__obj.entityType = entityTypeTB.getValue();
		//alert("entityTypeTB.getValue() =" +entityTypeTB.getValue());
		__obj.openDate = openDateTB.getValue();
		__obj.openTime = openTimeTB.getValue();
		__obj.bankAccountNo = bankAccountNoTB.getValue();
		__obj.bankCode = bankCodeTB.getValue();
		__obj.validPeriod = validPeriodTB.getValue();
		__obj.maxUserCount = maxUserCountTB.getValue();
		__obj.maxDiskSpace = maxDiskSpaceTB.getValue();
		__obj.createRealName = createRealNameTB.getValue();
		__obj.createUserName = createUserNameTB.getValue();
		__obj.createDate = createDateTB.getValue();
		__obj.createTime = createTimeTB.getValue();
		__obj.lastModifyRealName = lastModifyRealNameTB.getValue();
		__obj.lastModifyUserName = lastModifyUserNameTB.getValue();
		__obj.lastModifyDate = lastModifyDateTB.getValue();
		__obj.lastModifyTime = lastModifyTimeTB.getValue();
		__obj.lastApproveOption = lastApproveOptionTB.getValue();
		__obj.smallLogo = smallLogoTB.getValue();
		__obj.bigLogo = bigLogoTB.getValue();
		__obj.entitySid = entitySidTB.getValue();
		__obj.deleteFlag = deleteFlagTB.getValue();
	}


	//保存数据
	function saveData(){

		if($("#myform").form('validate')) { //进行校验并成功  
			
			var __obj = {newFlag: newFlag};
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


	</script>
  </head>
  
 
<body class="easyui-layout layout" style="height: 100%; overflow: hidden; border: none; margin: 0px; padding: 0px;">
	 	
	 
		
		<!-- west west west west west west west++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<div data-options="region:'west',split:true" style="width:540px;">
			<e:Grid id="mygrid" toolbar="+,icon-add,新建;x,icon-remove,删除" rowClick="onGridRowClick"  singleSelect="true" showSearchBar="true"  url="umsentity/lookuppage" clazz="com.als.mod.domain.UmsEntityVO"></e:Grid>
		</div>
		<!-- west west west west west west west end++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		
		<!-- center center center center center center center++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->	
		<div data-options="region:'center'">
			<div style="text-align: right;" class="alsui-toolbar" style="">
				<e:Btn id="saveBtn" btnClick="saveData" iconCls="icon-save" text="保存" disabled="false"></e:Btn>
			</div>
			
			<div id="myform"  class="alsui-form">
				<ul id="myformRow0" class="alsui-row">
					<li id="myformFld0" class="alsui-fld">
						<e:Text id="idTB" label="ums.entity.id"  labelClass="up" required="true"  missingMsg="mst.ums.entity.id" validType="userName" invalidMsg="tip.ums.entity.id"></e:Text>
					</li>
				</ul>
				<ul id="myformRow1" class="alsui-row">
					<li id="myformFld1" class="alsui-fld">
						<e:Text id="entityNameTB" label="ums.entity.entityName"  labelClass="up"  required="true" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow2" class="alsui-row">
					<li id="myformFld2" class="alsui-fld">
						<e:Text id="entitySnameTB" label="ums.entity.entitySname"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow3" class="alsui-row">
					<li id="myformFld3" class="alsui-fld">
						<e:Text id="emailTB" label="ums.entity.email"  labelClass="up" required="true" validType="email"></e:Text>
					</li>
				</ul>
				<ul id="myformRow4" class="alsui-row">
					<li id="myformFld4" class="alsui-fld">
						<e:Label id="entityStatusLB" text="ums.entity.entityStatus"></e:Label><br/>
						<e:Combo id="entityStatusTB" conName="ENTITY_STATUS" required="true" editable="false"></e:Combo>
					</li>
				</ul>
				<ul id="myformRow5" class="alsui-row">
					<li id="myformFld5" class="alsui-fld">
						<e:Label id="entityTypeLB" text="ums.entity.entityType"></e:Label><br/>
						<e:Combo id="entityTypeTB" conName="ENTITY_TYPE" required="true" editable="false"></e:Combo>
					</li>
				</ul>
				<ul id="myformRow6" class="alsui-row">
					<li id="myformFld6" class="alsui-fld">
						<e:Label id ="openDateLB" text="ums.entity.openDate" ></e:Label><br/>
						<e:DateText  id="openDateTB"></e:DateText>
					</li>
				</ul>
				<ul id="myformRow7" class="alsui-row">
					<li id="myformFld7" class="alsui-fld">
						<e:Label id="openTimeLB" text="ums.entity.openTime"></e:Label><br/>
						<e:TimeText id="openTimeTB"></e:TimeText>
					</li>
				</ul>
				<ul id="myformRow8" class="alsui-row">
					<li id="myformFld8" class="alsui-fld">
						<e:Text id="bankAccountNoTB" label="ums.entity.bankAccountNo"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow9" class="alsui-row">
					<li id="myformFld9" class="alsui-fld">
						<e:Text id="bankCodeTB" label="ums.entity.bankCode"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow10" class="alsui-row">
					<li id="myformFld10" class="alsui-fld">
						<e:Label id="validPeriodLB" text="ums.entity.validPeriod"></e:Label><br/>
						<e:DateText id="validPeriodTB"></e:DateText>
					</li>
				</ul>
				<ul id="myformRow11" class="alsui-row">
					<li id="myformFld11" class="alsui-fld">
						<e:Text id="maxUserCountTB" label="ums.entity.maxUserCount"  labelClass="up" required="true" validType="zeroAndInteger"></e:Text>
					</li>
				</ul>
				<ul id="myformRow12" class="alsui-row">
					<li id="myformFld12" class="alsui-fld">
						<e:Text id="maxDiskSpaceTB" label="ums.entity.maxDiskSpace"  labelClass="up" required="true" validType="zeroAndInteger"></e:Text>
					</li>
				</ul>
				<ul id="myformRow13" class="alsui-row">
					<li id="myformFld13" class="alsui-fld">
						<e:Text id="createRealNameTB" label="ums.entity.createRealName"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow14" class="alsui-row">
					<li id="myformFld14" class="alsui-fld">
						<e:Text id="createUserNameTB" label="ums.entity.createUserName"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow15" class="alsui-row">
					<li id="myformFld15" class="alsui-fld">
						<e:Label id="createDateLB" text="ums.entity.createDate"></e:Label><br/>
						<e:DateText id="createDateTB"></e:DateText>
					</li>
				</ul>
				<ul id="myformRow16" class="alsui-row">
					<li id="myformFld16" class="alsui-fld">
						<e:Label id="createTimeLB" text="ums.entity.createTime"></e:Label><br/>
						<e:TimeText id="createTimeTB"></e:TimeText>
					</li>
				</ul>
				<ul id="myformRow17" class="alsui-row">
					<li id="myformFld17" class="alsui-fld">
						<e:Text id="lastModifyRealNameTB" label="ums.entity.lastModifyRealName"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow18" class="alsui-row">
					<li id="myformFld18" class="alsui-fld">
						<e:Text id="lastModifyUserNameTB" label="ums.entity.lastModifyUserName"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow19" class="alsui-row">
					<li id="myformFld19" class="alsui-fld">
						<e:Label id="lastModifyDateLB" text="ums.entity.lastModifyDate"></e:Label><br/>
						<e:DateText id="lastModifyDateTB"></e:DateText>
					</li>
				</ul>
				<ul id="myformRow20" class="alsui-row">
					<li id="myformFld20" class="alsui-fld">
						<e:Label id="lastModifyTimeLB" text="ums.entity.lastModifyTime"></e:Label><br/>
						<e:TimeText id="lastModifyTimeTB"></e:TimeText>
					</li>
				</ul>
				<ul id="myformRow21" class="alsui-row">
					<li id="myformFld21" class="alsui-fld">
						<e:Text id="lastApproveOptionTB" label="ums.entity.lastApproveOption"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow22" class="alsui-row">
					<li id="myformFld22" class="alsui-fld">
						<e:Text id="smallLogoTB" label="ums.entity.smallLogo"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow23" class="alsui-row">
					<li id="myformFld23" class="alsui-fld">
						<e:Text id="bigLogoTB" label="ums.entity.bigLogo"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow25" class="alsui-row">
					<li id="myformFld25" class="alsui-fld">
						<e:Text id="entitySidTB" label="ums.entity.entitySid"  labelClass="up" readOnly="true" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow26" class="alsui-row">
					<li id="myformFld26" class="alsui-fld">
						<e:Text id="deleteFlagTB" label="ums.entity.deleteFlag"  labelClass="up" ></e:Text>
					</li>
				</ul>
			</div>
		</div>
		<!-- center center center center center center center end++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		
		
		
</body>
</html>
