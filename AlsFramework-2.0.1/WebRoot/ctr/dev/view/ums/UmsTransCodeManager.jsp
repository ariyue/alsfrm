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
    
    <title>交易树维护</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script type="text/javascript">


	var newFlag = {};//是否是新建 
	function getNewFlag(id){
		if (newFlag[id] != null && newFlag[id]){
			return true;
		}
		return false;
	}

	$(function(){

		getTreeData();

		//keyup事件
		$('#transNameTB').textbox({
		    inputEvents:$.extend({},$.fn.textbox.defaults.inputEvents,{
		        keyup:function(e){
		           // console.log('keyup');
		            //updateTreeNode();		        
		         }
		    })
		});

		//change事件
		$('#transNameTB').textbox({
			  onChange: function(value){
				 // updateTreeNode();
			  }
		});
	});

	//查询
	var treeQryCmd = new $$.Command();
	var qryCmdUrl = ROOT_PATH + "umstranscode/lookupall";
	treeQryCmd.setUrl(qryCmdUrl);

	//保存
	var saveCmd = new $$.Command();
	var saveCmdUrl = ROOT_PATH + "umstranscode/save";
	saveCmd.setUrl(saveCmdUrl);

	//删除
	var removeCmd = new $$.Command();
	var removeCmdUrl = ROOT_PATH + "umstranscode/remove";
	removeCmd.setUrl(removeCmdUrl);

	function refreshTree(){
		getTreeData();
	}
	function getTreeData(){

		//treeQryCmd.setParam(param);
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

	function setFormData(__obj){

		idTB.setValue(__obj.id);
		transNameTB.setValue(__obj.transName);
		transCodeTypeTB.setValue(__obj.transCodeType);
		pidTB.setValue(__obj.pid);
		remarkTB.setValue(__obj.remark);
		createRealNameTB.setValue(__obj.createRealName);
		createUserNameTB.setValue(__obj.createUserName);
		createDateTB.setValue(__obj.createDate);
		createTimeTB.setValue(__obj.createTime);
		lastModifyRealNameTB.setValue(__obj.lastModifyRealName);
		lastModifyUserNameTB.setValue(__obj.lastModifyUserName);
		lastModifyDateTB.setValue(__obj.lastModifyDate);
		lastModifyTimeTB.setValue(__obj.lastModifyTime);
		lastApproveOpitonTB.setValue(__obj.lastApproveOpiton);
		rowOrderTB.setValue(__obj.rowOrder);
		timeWinTB.setValue(__obj.timeWin);
		
				
	}

	function getFormData(__obj){
		
		__obj.id = idTB.getValue();
		__obj.transName = transNameTB.getValue();
		__obj.transCodeType = transCodeTypeTB.getValue();
		__obj.pid = pidTB.getValue();
		__obj.remark = remarkTB.getValue();
		__obj.createRealName = createRealNameTB.getValue();
		__obj.createUserName = createUserNameTB.getValue();
		__obj.createDate = createDateTB.getValue();
		__obj.createTime = createTimeTB.getValue();
		__obj.lastModifyRealName = lastModifyRealNameTB.getValue();
		__obj.lastModifyUserName = lastModifyUserNameTB.getValue();
		__obj.lastModifyDate = lastModifyDateTB.getValue();
		__obj.lastModifyTime = lastModifyTimeTB.getValue();
		__obj.lastApproveOpiton = lastApproveOpitonTB.getValue();
		__obj.rowOrder = rowOrderTB.getValue();
		__obj.timeWin = timeWinTB.getValue();
			
	}

	//保存数据
	function saveData(){
		if($("#myform").form('validate')) { //进行校验并成功  
			var node = $("#dataTree").tree("getSelected");
			//alert("id2=" + node.id);
			var __obj = {newFlag: getNewFlag(node.id)};
			getFormData(__obj);
			saveCmd.setParam(__obj);
			saveCmd.execute();
			if (saveCmd.commandSuccess){
				var result = saveCmd.getResult();
				if (result == "success"){
					updateTreeNode();
					//alert(99999);
					//更新完后newFlag为FLASE
					newFlag[node.id] = false;
				}
			}
		}
	}

	function removeData(){

		appConfirm("提醒","是否要删除该结点？", function(){
			var param = {
					id: idTB.getValue()
				};
			removeCmd.setParam(param);
			removeCmd.execute();
			if (removeCmd.commandSuccess){
				var result = removeCmd.getResult();
				//alert("result=" + result);
				if ("success" == result){
					//alert(9988);
					removeTreeNode();
				}
			}
		});
		
	}

	

	//-------------树相关事件---------------------------------------------------------------
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
		var t = $('#dataTree');
		var node = t.tree('getSelected');
		if (node == null){
			appAlert("提示", "请先选中一个结点后，再进行添加子结点", "info");
			return;
		}
		//新的业务对象
		var __obj = {};
		__obj.id = "";
		__obj.transName = "新建交易码";
		__obj.transCodeType = "";
		__obj.pid = node.id;
		__obj.remark = "999";
		__obj.createRealName = "";
		__obj.createUserName = "";
		__obj.createDate = "";
		__obj.createTime = "";
		__obj.lastModifyRealName = "";
		__obj.lastModifyUserName = "";
		__obj.lastModifyDate = "";
		__obj.lastModifyTime = "";
		__obj.lastApproveOpiton = "";
		__obj.rowOrder = "1";
		__obj.timeWin = "00,10,20,30";
		
		//将新的业务对象组装成新的结点数据
		var newNodeDat = {};
			newNodeDat.id = new UUID();//新的结点ID
			newFlag[newNodeDat.id] = true;//新对象标识
			//alert("id=" + newNodeDat.id);
			newNodeDat.text = __obj.transName;
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
		var nodetext = transNameTB.getValue();
		var node = $("#dataTree").tree("getSelected");
		var nodeEntityObj = {};
		getFormData(nodeEntityObj);

		//alert("pid22222=" + nodeEntityObj.pid);
		
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
	　　　　		id: newId,
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
	</script>
  </head>
  
 
<body class="easyui-layout layout" style="height: 100%; overflow: hidden; border: none; margin: 0px; padding: 0px;">
	 	
	 
		
		<!-- west west west west west west west++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<div data-options="region:'west',split:true" style="width:540px;">
			<div class="alsui-toolbar">
				<e:Btn id="refreshBtn" iconCls="icon-reload" text="刷新" btnClick="refreshTree"></e:Btn>
				<e:Btn id="expandAllBtn"   text="展开" btnClick="expandAllTreeNode"></e:Btn>
				<e:Btn id="collapseAllBtn"  text="折叠" btnClick="collapseAllTreeNode"></e:Btn>
				<e:Btn id="insertBtn" iconCls="icon-add" text="添加子结点" btnClick="appendTreeNodeChild"></e:Btn>
				<e:Btn id="removeBtn" btnClick="removeData" iconCls="icon-remove" text="删除"></e:Btn>
			</div>
			<div style="margin-top: 30px;">
				<ul id="dataTree" class="easyui-tree" data-options="lines:true,animate:false" ></ul>  
			</div>

		
		</div>
		<!-- west west west west west west west end++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		
		<!-- center center center center center center center++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->	
		<div data-options="region:'center'">
			<div style="text-align: right;" class="alsui-toolbar">
				<e:Btn id="saveBtn" btnClick="saveData" iconCls="icon-save" text="保存" disabled="false"></e:Btn>
			</div>
			<div id="myform" class="alsui-form">
				<ul id="myformRow0" class="alsui-row">
					<li id="myformFld0" class="alsui-fld">
						<e:Text id="idTB" label="ums.transCode.id" labelClass="up" required="true" validType="userName" maxlength="11"></e:Text>
					</li>
				</ul>
				<ul id="myformRow1" class="alsui-row">
					<li id="myformFld1" class="alsui-fld">
						<e:Text id="transNameTB" label="ums.transCode.transName"  labelClass="up"  required="true" validType="loginName"></e:Text>
					</li>
				</ul>
				<ul id="myformRow2" class="alsui-row">
					<li id="myformFld2" class="alsui-fld">
						<e:Label id ="transCodeTypeLB" text="ums.transCode.transCodeType"></e:Label><br/>
						<e:Combo id="transCodeTypeTB" conName="TRANS_CODE" required="true" editable="false"></e:Combo>
					</li>
				</ul>
				
				<ul id="myformRow15" class="alsui-row">
					<li id="myformFld15" class="alsui-fld">
						<e:Text id="timeWinTB" label="ums.transCode.timeWin"  labelClass="up" value="" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow14" class="alsui-row">
					<li id="myformFld14" class="alsui-fld">
						<e:Text id="rowOrderTB" label="ums.transCode.rowOrder"  labelClass="up" required="true" validType="zeroAndInteger"></e:Text>
					</li>
				</ul>
				
				<ul id="myformRow3" class="alsui-row" >
					<li id="myformFld3" class="alsui-fld">
						<e:Text id="pidTB" label="ums.transCode.pid"  labelClass="up" readOnly="true"></e:Text>
					</li>
				</ul>
				<ul id="myformRow4" class="alsui-row">
					<li id="myformFld4" class="alsui-fld">
						<e:Text id="remarkTB" label="ums.transCode.remark"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow5" class="alsui-row" style="display:none;" >
					<li id="myformFld5" class="alsui-fld">
						<e:Text id="createRealNameTB" label="ums.transCode.createRealName"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow6" class="alsui-row" style="display:none;" >
					<li id="myformFld6" class="alsui-fld">
						<e:Text id="createUserNameTB" label="ums.transCode.createUserName"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow7" class="alsui-row" style="display:none;" >
					<li id="myformFld7" class="alsui-fld">
						<e:Text id="createDateTB" label="ums.transCode.createDate"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow8" class="alsui-row" style="display:none;" >
					<li id="myformFld8" class="alsui-fld">
						<e:Text id="createTimeTB" label="ums.transCode.createTime"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow9" class="alsui-row" style="display:none;" >
					<li id="myformFld9" class="alsui-fld">
						<e:Text id="lastModifyRealNameTB" label="ums.transCode.lastModifyRealName"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow10" class="alsui-row" style="display:none;" >
					<li id="myformFld10" class="alsui-fld">
						<e:Text id="lastModifyUserNameTB" label="ums.transCode.lastModifyUserName"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow11" class="alsui-row" style="display:none;" >
					<li id="myformFld11" class="alsui-fld">
						<e:Text id="lastModifyDateTB" label="ums.transCode.lastModifyDate"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow12" class="alsui-row" style="display:none;" >
					<li id="myformFld12" class="alsui-fld">
						<e:Text id="lastModifyTimeTB" label="ums.transCode.lastModifyTime"  labelClass="up" ></e:Text>
					</li>
				</ul>
				<ul id="myformRow13" class="alsui-row" style="display:none;" >
					<li id="myformFld13" class="alsui-fld">
						<e:Text id="lastApproveOpitonTB" label="ums.transCode.lastApproveOpiton"  labelClass="up" ></e:Text>
					</li>
				</ul>					
			</div>
		
		</div>
		<!-- center center center center center center center end++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		
		
		
</body>
</html>
