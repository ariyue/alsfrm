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
    
    <title>企业组织机构维护</title>
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
	var saveCmdUrl = ROOT_PATH + "umsunit/save";
	saveCmd.setUrl(saveCmdUrl);

	//删除
	var removeCmd = new $$.Command();
	var removeCmdUrl = ROOT_PATH + "umsunit/remove";
	removeCmd.setUrl(removeCmdUrl);

	//页面初始化-----------------------------------------
	$(function(){

		//keyup事件
		$('#unitNameTB').textbox({
		    inputEvents:$.extend({},$.fn.textbox.defaults.inputEvents,{
		        keyup:function(e){
		            console.log('keyup');
		            updateTreeNode();		        }
		    })
		});

		//change事件
		$('#unitNameTB').textbox({
			  onChange: function(value){
				  updateTreeNode();
			  }
		});
		
	});
	//页面初始化-----------------------------------------
	
	function onChange(newValue, oldValue){
		//加载组织机构树
		if(newValue != oldValue){
			var entitySid = newValue;
			getTreeData(entitySid);
		}
		
	}
	//-------------树相关事件---------------------------------------------------------------
	//树查询CMD
	var treeQryCmd = new $$.Command();
	var qryCmdUrl = ROOT_PATH + "umsunit/lookuptree";
	treeQryCmd.setUrl(qryCmdUrl);


	function refreshTree(){
		var entitySid = entityCB.getVal();
		//alert("entitySid=" + entitySid);
		if(entitySid != ""){
			getTreeData(entitySid);
		}
	}

	
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
                     setFormData(node.attributes.nodeEntityObj);
                 },
                 onDblClick: function (node) {  
             	    $(this).tree(node.state === 'closed' ? 'expand' : 'collapse', node.target);  
            	    node.state = node.state === 'closed' ? 'open' : 'closed';  
            	} 
			});
		}
	}

	
	//展开所有(如果有指定了结点，展开指定结点的所有子结点)
	function expandAllTreeNode(){
		var t = $('#dataTree');
		var node = t.tree('getSelected');
		if(node){
			$('#dataTree').tree('expandAll', node.target);
		}else {
			$('#dataTree').tree('expandAll');
		}
		
	}

	//折叠所有
	function collapseAllTreeNode(){
		var t = $('#dataTree');
		var node = t.tree('getSelected');
		if(node){
			$('#dataTree').tree('collapseAll', node.target);
		}else {
			$('#dataTree').tree('collapseAll');
		}
	}

	//双击事件
	function onTreeNodeDblClick(node) {  
	    $(this).tree(node.state === 'closed' ? 'expand' : 'collapse', node.target);  
	    node.state = node.state === 'closed' ? 'open' : 'closed';  
	} 

	//添加子结点
	function appendTreeNodeChild(){

		//newFlag = true;
		var t = $('#dataTree');
		var node = t.tree('getSelected');
		if (node == null){
			appAlert("提示", "请先选中一个结点后，再进行添加子结点", "info");
			return;
		}
		//新的业务对象
		var __obj = {};
		__obj.id = new UUID();//新的结点ID
		__obj.unitName = "新组织机构";
		__obj.pid = node.id;
		__obj.unitRelationship = "";
		__obj.remark = "";
		__obj.entitySid =  entityCB.getVal();//node.attributes.nodeEntityObj.entitySid;
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
		

		//alert("__obj.entitySid =" + __obj.entitySid );
		
		//将新的业务对象组装成新的结点数据
		var newNodeDat = {};
			newNodeDat.id = __obj.id;
			newFlag[newNodeDat.id] = true;//新对象标识
			newNodeDat.text = __obj.unitName;
			newNodeDat.attributes = {};
			newNodeDat.attributes.nodeEntityObj = __obj;

		 //	附加新结点
		 t.tree("append",{
		    parent: node.target,
	        data:[newNodeDat]
		});

		 //展开该结点
		 $('#dataTree').tree('expand', node.target);

		 //选中新结点
		 var newNode = $('#dataTree').tree('find', newNodeDat.id);
		 $("#dataTree").tree("select", newNode.target);   

		 // 结表单赋值
		 setFormData(__obj);
	}

	//更新结点
	function updateTreeNode() {
		var nodetext = unitNameTB.getValue();
		var node = $("#dataTree").tree("getSelected");
		var nodeEntityObj = {};
		getFormData(nodeEntityObj);

		//newId处理--------------------------------
		var oldId = node.id;
		var newId = idTB.getValue();
		if (newId.trim() == ""){
			newId = oldId;
		}
		newFlag[newId] = getNewFlag(oldId);
		//newId处理 end--------------------------------
		
		if(node) {
			$('#dataTree').tree('update', {
	            target: node.target,
	　　　　		text: nodetext,
	            //iconCls: 'icon-edit',
	    		attributes: {nodeEntityObj : nodeEntityObj}
	            
	        });
		}
	}

	//删除选中节点
	function removeTreeNode(){
		var node = $("#dataTree").tree("getSelected");
		$('#dataTree').tree('remove', node.target);
	}

	//-------------树相关事件 end---------------------------------------------------------------

	function resetFormData(__obj){
		idTB.setValue("");
		unitNameTB.setValue("");
		pidTB.setValue("");
		unitRelationshipTB.setValue("");
		remarkTB.setValue("");
		entitySidTB.setValue("");
		createRealNameTB.setValue("");
		createUserNameTB.setValue("");
		createDateTB.setValue("");
		createTimeTB.setValue("");
		lastModifyRealNameTB.setValue("");
		lastModifyUserNameTB.setValue("");
		lastModifyDateTB.setValue("");
		lastModifyTimeTB.setValue("");
		lastApproveOptionTB.setValue("");
		rowOrderTB.setValue("");
	}

	function setFormData(__obj){
		idTB.setValue(__obj.id);
		unitNameTB.setValue(__obj.unitName);
		pidTB.setValue(__obj.pid);
		unitRelationshipTB.setValue(__obj.unitRelationship);
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
		__obj.unitName = unitNameTB.getValue();
		__obj.pid = pidTB.getValue();
		__obj.unitRelationship = unitRelationshipTB.getValue();
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
			var node = $("#dataTree").tree("getSelected");
			var __obj = {newFlag: getNewFlag(node.id)};
			getFormData(__obj);
			
			saveCmd.setParam(__obj);
			saveCmd.execute();
			if (saveCmd.commandSuccess){
				var result = saveCmd.getResult();
				//更新完后newFlag为FLASE
				newFlag[node.id] = false;
				setFormData(result);
				updateTreeNode();
			}
		}
	}

	function removeData(){

		var node = $("#dataTree").tree("getSelected");
		if(node == null){
			appAlert("提示", "没有选中的组织机构", "warning");
			return;
		}
		var pid =  node.attributes.nodeEntityObj.pid;
		//alert("pid=" + pid);
		//return; 
		if (pid == "-1"){
			appAlert("提示", "顶级组织机构不可删除", "warning");
			return;
		}
		appConfirm("提醒","是否要删除该结点？", function(){
			var param = {
					id: idTB.getValue(),
					pid: node.attributes.nodeEntityObj.pid
				};
			removeCmd.setParam(param);
			removeCmd.execute();
			if (removeCmd.commandSuccess){
				var result = removeCmd.getResult();
				//alert("result=" + result);
				if ("success" == result){
					removeTreeNode();
				}
			}
		});
		
	}


	</script>
  </head>
  
 
<body class="easyui-layout layout" style="height: 100%; overflow: hidden; border: none; margin: 0px; padding: 0px;">
	 	
	 
		
		<!-- west west west west west west west++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<div data-options="region:'west',split:true" style="width:660px;">
			<div class="alsui-toolbar" style="height:28px;">
				请选择企业：
				<e:ComboGrid id="entityCB" onChange="onChange"  url="umsentity/lookuppage" clazz="com.als.mod.domain.UmsEntityVO2" textField="entityName" valField="entitySid" ></e:ComboGrid>
				<e:Btn id="refreshBtn" iconCls="icon-reload" text="刷新" btnClick="refreshTree"></e:Btn>
				<e:Btn id="expandAllBtn"   text="展开" btnClick="expandAllTreeNode"></e:Btn>
				<e:Btn id="collapseAllBtn"  text="折叠" btnClick="collapseAllTreeNode"></e:Btn>
				<e:Btn id="insertBtn" iconCls="icon-add" text="添加子结点" btnClick="appendTreeNodeChild"></e:Btn>
				<e:Btn id="removeBtn" btnClick="removeData" iconCls="icon-remove" text="删除"></e:Btn>
			</div>
			<div style="margin-top:28px;">
			
				<ul id="dataTree" class="easyui-tree" data-options="lines:true,animate:true" ></ul>  
			</div>
		</div>
		<!-- west west west west west west west end++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		
		<!-- center center center center center center center++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->	
		<div data-options="region:'center'">
			<div style="text-align: right;" class="alsui-toolbar" style="">
				<e:Btn id="saveBtn" btnClick="saveData" iconCls="icon-save" text="保存" disabled="false"></e:Btn>
			</div>
			
			<div id="myform" class="alsui-form">
				<ul id="myformRow0" class="alsui-row">
					<li id="myformFld0" class="alsui-fld" style="display:none;">
						<e:Text id="idTB" label="ums.unit.id"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow1" class="alsui-row">
					<li id="myformFld1" class="alsui-fld">
						<e:Text id="unitNameTB" label="ums.unit.unitName"  labelClass="up" required="true" validType="loginName" ></e:Text>
					</li>
				</ul>
				
				<ul id="myformRow15" class="alsui-row">
					<li id="myformFld15" class="alsui-fld">
						<e:Text id="rowOrderTB" label="ums.unit.rowOrder"  labelClass="up"  required="true" validType="integer"></e:Text>
					</li>
				</ul>
				
					<ul id="myformRow4" class="alsui-row">
					<li id="myformFld4" class="alsui-fld">
						<e:Text id="remarkTB" label="ums.unit.remark"  labelClass="up" ></e:Text>
					</li>
				</ul>
				
				<ul id="myformRow5" class="alsui-row" style="display:none;">
					<li id="myformFld5" class="alsui-fld">
						<e:Text id="entitySidTB" label="ums.unit.entitySid"  labelClass="up" ></e:Text>
					</li>
				</ul>
				
				<ul id="myformRow2" class="alsui-row" style="display:none;">
					<li id="myformFld2" class="alsui-fld">
						<e:Text id="pidTB" label="ums.unit.pid"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow3" class="alsui-row" style="display:none;">
					<li id="myformFld3" class="alsui-fld">
						<e:Text id="unitRelationshipTB" label="ums.unit.unitRelationship"  labelClass="up" ></e:Text>
					</li>
				</ul>
			
				
				<ul id="myformRow6" class="alsui-row" style="display: none;">
					<li id="myformFld6" class="alsui-fld">
						<e:Text id="createRealNameTB" label="ums.unit.createRealName"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow7" class="alsui-row" style="display: none;">
					<li id="myformFld7" class="alsui-fld">
						<e:Text id="createUserNameTB" label="ums.unit.createUserName"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow8" class="alsui-row" style="display: none;">
					<li id="myformFld8" class="alsui-fld">
						<e:Text id="createDateTB" label="ums.unit.createDate"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow9" class="alsui-row" style="display: none;">
					<li id="myformFld9" class="alsui-fld">
						<e:Text id="createTimeTB" label="ums.unit.createTime"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow10" class="alsui-row" style="display: none;">
					<li id="myformFld10" class="alsui-fld">
						<e:Text id="lastModifyRealNameTB" label="ums.unit.lastModifyRealName"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow11" class="alsui-row" style="display: none;">
					<li id="myformFld11" class="alsui-fld">
						<e:Text id="lastModifyUserNameTB" label="ums.unit.lastModifyUserName"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow12" class="alsui-row" style="display: none;">
					<li id="myformFld12" class="alsui-fld">
						<e:Text id="lastModifyDateTB" label="ums.unit.lastModifyDate"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow13" class="alsui-row" style="display: none;">
					<li id="myformFld13" class="alsui-fld">
						<e:Text id="lastModifyTimeTB" label="ums.unit.lastModifyTime"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow14" class="alsui-row" style="display: none;">
					<li id="myformFld14" class="alsui-fld">
						<e:Text id="lastApproveOptionTB" label="ums.unit.lastApproveOption"  labelClass="up" ></e:Text>
					</li>
				</ul>
				
			</div>
		</div>
		<!-- center center center center center center center end++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		
		
		
</body>
</html>
