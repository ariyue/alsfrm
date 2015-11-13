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
    
    <title>菜单维护</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script type="text/javascript">

	//是否是新建数据
	var newFlag = {};//是否是新建 
	function getNewFlag(id){
		if (newFlag[id] != null && newFlag[id]){
			return true;
		}
		return false;
	}
	
	//保存
	var saveCmd = new $$.Command();
	var saveCmdUrl = ROOT_PATH + "umsmenu/save";
	saveCmd.setUrl(saveCmdUrl);

	//删除
	var removeCmd = new $$.Command();
	var removeCmdUrl = ROOT_PATH + "umsmenu/remove";
	removeCmd.setUrl(removeCmdUrl);

	//页面初始化-----------------------------------------
	$(function(){
		getTreeData();
		
		//keyup事件
		$('#menuNameTB').textbox({
		    inputEvents:$.extend({},$.fn.textbox.defaults.inputEvents,{
		        keyup:function(e){
		            console.log('keyup');
		            //updateTreeNode();		        
		        }
		    })
		});

		//change事件
		$('#menuNameTB').textbox({
			  onChange: function(value){
				  //updateTreeNode();
			  }
		});
		
	});
	//页面初始化-----------------------------------------
	
	
	//-------------树相关事件---------------------------------------------------------------
	//树查询CMD
	var treeQryCmd = new $$.Command();
	var qryCmdUrl = ROOT_PATH + "umsmenu/lookuptree";
	treeQryCmd.setUrl(qryCmdUrl);


	function refreshTree(){
		getTreeData();
	}

	
	function getTreeData(){

		treeQryCmd.setParam({});
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
		__obj.id = ""; //
		__obj.menuName = "新建菜单";
		__obj.menuLevel = "1";
		__obj.menuType = "";
		__obj.pid = node.attributes.nodeEntityObj.id;//node.id;
		//alert("pid=" + node.attributes.nodeEntityObj.id);
		
		__obj.transCode = "";
		__obj.rowOrder = "1";
		__obj.icon = "";
		__obj.remark = "";
		__obj.menuUrl = "";
		__obj.tip = "";
		__obj.enableFlag = "1";
		__obj.createRealName = "";
		__obj.createUserName = "";
		__obj.createDate = "";
		__obj.createTime = "";
		__obj.lastModifyRealName = "";
		__obj.lastModifyUserName = "";
		__obj.lastModifyDate = "";
		__obj.lastModifyTime = "";
		__obj.lastApproveOption = "";
		__obj.leftShowFlag = "1";
		__obj.complexFlag = "";
		__obj.viewNamespace = "";
		__obj.exeFn = "";
		__obj.params = "";
		__obj.menuStyle = "";
				
		//将新的业务对象组装成新的结点数据
		var newNodeDat = {};
			newNodeDat.id = new UUID();//新的结点ID
			newFlag[newNodeDat.id] = true;//新对象标识
			newNodeDat.text = __obj.menuName;
			newNodeDat.attributes = {};
			newNodeDat.attributes.nodeEntityObj = __obj;

		 //	附加新结点
		 t.tree("append",{
		    parent: node.target,
	        data:[newNodeDat]
		});

			

		 //展开该结点
		 $('#dataTree').tree('collapse', node.target);
		 if (node.state == "closed"){
			 $('#dataTree').tree('expand', node.target);
		 }

		 //选中新结点
		 var newNode = $('#dataTree').tree('find', newNodeDat.id);
		 $("#dataTree").tree("select", newNode.target);   

		 // 结表单赋值
		 setFormData(__obj);
	}

	//更新结点
	function updateTreeNode() {
		var nodetext = menuNameTB.getValue();
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
		menuNameTB.setValue("");
		menuLevelTB.setValue("");
		menuTypeTB.setValue("");
		pidTB.setValue("");
		transCodeTB.setValue("");
		rowOrderTB.setValue("");
		iconTB.setValue("");
		remarkTB.setValue("");
		menuUrlTB.setValue("");
		tipTB.setValue("");
		enableFlagTB.setValue("");
		createRealNameTB.setValue("");
		createUserNameTB.setValue("");
		createDateTB.setValue("");
		createTimeTB.setValue("");
		lastModifyRealNameTB.setValue("");
		lastModifyUserNameTB.setValue("");
		lastModifyDateTB.setValue("");
		lastModifyTimeTB.setValue("");
		lastApproveOptionTB.setValue("");
		leftShowFlagTB.setValue("");
		complexFlagTB.setValue("");
		viewNamespaceTB.setValue("");
		exeFnTB.setValue("");
		paramsTB.setValue("");
		menuStyleTB.setValue("");
	}

	function setFormData(__obj){
		idTB.setValue(__obj.id);
		menuNameTB.setValue(__obj.menuName);
		menuLevelTB.setValue(__obj.menuLevel);
		menuTypeTB.setValue(__obj.menuType);
		pidTB.setValue(__obj.pid);
		transCodeTB.setValue(__obj.transCode);
		rowOrderTB.setValue(__obj.rowOrder);
		iconTB.setValue(__obj.icon);
		remarkTB.setValue(__obj.remark);
		menuUrlTB.setValue(__obj.menuUrl);
		tipTB.setValue(__obj.tip);
		enableFlagTB.setValue(__obj.enableFlag);
		createRealNameTB.setValue(__obj.createRealName);
		createUserNameTB.setValue(__obj.createUserName);
		createDateTB.setValue(__obj.createDate);
		createTimeTB.setValue(__obj.createTime);
		lastModifyRealNameTB.setValue(__obj.lastModifyRealName);
		lastModifyUserNameTB.setValue(__obj.lastModifyUserName);
		lastModifyDateTB.setValue(__obj.lastModifyDate);
		lastModifyTimeTB.setValue(__obj.lastModifyTime);
		lastApproveOptionTB.setValue(__obj.lastApproveOption);
		leftShowFlagTB.setValue(__obj.leftShowFlag);
		complexFlagTB.setValue(__obj.complexFlag);
		viewNamespaceTB.setValue(__obj.viewNamespace);
		exeFnTB.setValue(__obj.exeFn);
		paramsTB.setValue(__obj.params);
		menuStyleTB.setValue(__obj.menuStyle);
	}

	function getFormData(__obj){
		__obj.id = idTB.getValue();
		__obj.menuName = menuNameTB.getValue();
		__obj.menuLevel = menuLevelTB.getValue();
		__obj.menuType = menuTypeTB.getValue();
		__obj.pid = pidTB.getValue();
		__obj.transCode = transCodeTB.getValue();
		__obj.rowOrder = rowOrderTB.getValue();
		__obj.icon = iconTB.getValue();
		__obj.remark = remarkTB.getValue();
		__obj.menuUrl = menuUrlTB.getValue();
		__obj.tip = tipTB.getValue();
		__obj.enableFlag = enableFlagTB.getValue();
		__obj.createRealName = createRealNameTB.getValue();
		__obj.createUserName = createUserNameTB.getValue();
		__obj.createDate = createDateTB.getValue();
		__obj.createTime = createTimeTB.getValue();
		__obj.lastModifyRealName = lastModifyRealNameTB.getValue();
		__obj.lastModifyUserName = lastModifyUserNameTB.getValue();
		__obj.lastModifyDate = lastModifyDateTB.getValue();
		__obj.lastModifyTime = lastModifyTimeTB.getValue();
		__obj.lastApproveOption = lastApproveOptionTB.getValue();
		__obj.leftShowFlag = leftShowFlagTB.getValue();
		__obj.complexFlag = complexFlagTB.getValue();
		__obj.viewNamespace = viewNamespaceTB.getValue();
		__obj.exeFn = exeFnTB.getValue();
		__obj.params = paramsTB.getValue();
		__obj.menuStyle = menuStyleTB.getValue();
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
				//newFlag[node.id] = false;
				newFlag[result.id] = false;
				var node = $("#dataTree").tree("getSelected");
				$('#dataTree').tree('update', {
		            target: node.target,
		　　　　		id: result.id,
		　　　　		text: result.menuName,
		    		attributes: {nodeEntityObj : result}
		        });
				setFormData(result);
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
				
				<e:Btn id="refreshBtn" iconCls="icon-reload" text="刷新" btnClick="refreshTree"></e:Btn>
				<e:Btn id="expandAllBtn"   text="展开" btnClick="expandAllTreeNode"></e:Btn>
				<e:Btn id="collapseAllBtn"  text="折叠" btnClick="collapseAllTreeNode"></e:Btn>
				<e:Btn id="insertBtn" iconCls="icon-add" text="添加子结点" btnClick="appendTreeNodeChild"></e:Btn>
				<e:Btn id="removeBtn" btnClick="removeData" iconCls="icon-remove" text="删除"></e:Btn>
			</div>
			<div style="margin-top:28px;">
			
				<ul id="dataTree" class="easyui-tree" data-options="lines:true,animate:false" ></ul>  
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
					<li id="myformFld0" class="alsui-fld">
						<e:Text id="idTB" label="ums.menu.id"  labelClass="up" required="true" validType="userName" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow1" class="alsui-row">
					<li id="myformFld1" class="alsui-fld">
						<e:Text id="menuNameTB" label="ums.menu.menuName"  labelClass="up"  required="true" validType="loginName" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow2" class="alsui-row">
					<li id="myformFld2" class="alsui-fld">									
						<e:Label id="menuLevelLB" text="ums.menu.menuLevel"></e:Label><br/>
						<e:Combo id="menuLevelTB" conName="SYS_MENU_LEVEL" required="true"></e:Combo>
					</li>
				</ul>
				<ul id="myformRow3" class="alsui-row" style="display:none;">
					<li id="myformFld3" class="alsui-fld">
						<e:Text id="menuTypeTB" label="ums.menu.menuType"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow4" class="alsui-row" style="display:none;">
					<li id="myformFld4" class="alsui-fld">
						<e:Text id="pidTB" label="ums.menu.pid"  labelClass="up" ></e:Text>
					</li>
				</ul>
				
				<ul id="myformRow9" class="alsui-row">
					<li id="myformFld9" class="alsui-fld">
						<e:Text id="menuUrlTB" label="ums.menu.menuUrl"  labelClass="up" ></e:Text>
					</li>
				</ul>
				
				<ul id="myformRow5" class="alsui-row">
					<li id="myformFld5" class="alsui-fld">
						<e:Text id="transCodeTB" label="ums.menu.transCode"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow6" class="alsui-row">
					<li id="myformFld6" class="alsui-fld">
						<e:Text id="rowOrderTB" label="ums.menu.rowOrder"  labelClass="up" required="true" validType="integer"></e:Text>
					</li>
				</ul>
				
				<ul id="myformRow11" class="alsui-row">
					<li id="myformFld11" class="alsui-fld">
						<e:Label id="enableFlagLB" text="ums.menu.enableFlag"></e:Label><br/>
						<e:Combo id="enableFlagTB" conName="SYS_ENABLE_FLAG" required="true" val="1"></e:Combo>
					
					</li>
				</ul>
				
				<ul id="myformRow7" class="alsui-row">
					<li id="myformFld7" class="alsui-fld">
						<e:Text id="iconTB" label="ums.menu.icon"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow8" class="alsui-row">
					<li id="myformFld8" class="alsui-fld">
						<e:Text id="remarkTB" label="ums.menu.remark"  labelClass="up" ></e:Text>
					</li>
				</ul>
				
				<ul id="myformRow10" class="alsui-row">
					<li id="myformFld10" class="alsui-fld">
						<e:Text id="tipTB" label="ums.menu.tip"  labelClass="up" ></e:Text>
					</li>
				</ul>
				
				<ul id="myformRow12" class="alsui-row"  style="display:none;">
					<li id="myformFld12" class="alsui-fld">
						<e:Text id="createRealNameTB" label="ums.menu.createRealName"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow13" class="alsui-row"  style="display:none;">
					<li id="myformFld13" class="alsui-fld">
						<e:Text id="createUserNameTB" label="ums.menu.createUserName"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow14" class="alsui-row"  style="display:none;">
					<li id="myformFld14" class="alsui-fld">
						<e:Text id="createDateTB" label="ums.menu.createDate"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow15" class="alsui-row"  style="display:none;">
					<li id="myformFld15" class="alsui-fld">
						<e:Text id="createTimeTB" label="ums.menu.createTime"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow16" class="alsui-row"  style="display:none;">
					<li id="myformFld16" class="alsui-fld">
						<e:Text id="lastModifyRealNameTB" label="ums.menu.lastModifyRealName"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow17" class="alsui-row"  style="display:none;">
					<li id="myformFld17" class="alsui-fld">
						<e:Text id="lastModifyUserNameTB" label="ums.menu.lastModifyUserName"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow18" class="alsui-row"  style="display:none;">
					<li id="myformFld18" class="alsui-fld">
						<e:Text id="lastModifyDateTB" label="ums.menu.lastModifyDate"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow19" class="alsui-row">
					<li id="myformFld19" class="alsui-fld"  style="display:none;">
						<e:Text id="lastModifyTimeTB" label="ums.menu.lastModifyTime"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow20" class="alsui-row"  style="display:none;">
					<li id="myformFld20" class="alsui-fld">
						<e:Text id="lastApproveOptionTB" label="ums.menu.lastApproveOption"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow21" class="alsui-row"  style="display:none;">
					<li id="myformFld21" class="alsui-fld">
						<e:Text id="leftShowFlagTB" label="ums.menu.leftShowFlag"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow22" class="alsui-row"  style="display:none;">
					<li id="myformFld22" class="alsui-fld">
						<e:Text id="complexFlagTB" label="ums.menu.complexFlag"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow23" class="alsui-row"  style="display:none;">
					<li id="myformFld23" class="alsui-fld">
						<e:Text id="viewNamespaceTB" label="ums.menu.viewNamespace"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow24" class="alsui-row"  style="display:none;">
					<li id="myformFld24" class="alsui-fld">
						<e:Text id="exeFnTB" label="ums.menu.exeFn"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow25" class="alsui-row" style="display:none;">
					<li id="myformFld25" class="alsui-fld">
						<e:Text id="paramsTB" label="ums.menu.params"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow26" class="alsui-row">
					<li id="myformFld26" class="alsui-fld">
						<e:Text id="menuStyleTB" label="ums.menu.menuStyle"  labelClass="up" ></e:Text>
					</li>
				</ul>
			</div>
		</div>
		<!-- center center center center center center center end++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		
		
		
</body>
</html>
