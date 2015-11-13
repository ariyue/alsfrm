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
    
    <title>角色交易权限维护</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script type="text/javascript">



	$(function(){

		getTreeData();

		
	});

	//查询
	var treeQryCmd = new $$.Command();
	var qryCmdUrl = ROOT_PATH + "umsprivilege/lookupall";
	treeQryCmd.setUrl(qryCmdUrl);

	//保存
	var saveCmd = new $$.Command();
	var saveCmdUrl = ROOT_PATH + "umsprivilege/save";
	saveCmd.setUrl(saveCmdUrl);

	

	
	function getTreeData(roleId){

		if (roleId != null){
			treeQryCmd.setParam({roleId: roleId});
		}
		treeQryCmd.execute();
		//alert(4444);
		if (treeQryCmd.commandSuccess){
			
			$("#dataTree").tree({
				data: treeQryCmd.getResult(),
				
                onDblClick: function (node) {  
            	    $(this).tree(node.state === 'closed' ? 'expand' : 'collapse', node.target);  
           	    	node.state = node.state === 'closed' ? 'open' : 'closed';  
           		},
           		//级联选中----------------------------------
           		checkbox:true,
           	 	cascadeCheck: false,
             	onCheck: function (node, checked){
	                 if (checked) {
	                     var parentNode = $("#dataTree").tree('getParent', node.target);
	                     if (parentNode != null) {
	                         $("#dataTree").tree('check', parentNode.target);
	                     }
	                 } else {
	                     var childNode = $("#dataTree").tree('getChildren', node.target);
	                     if (childNode.length > 0) {
	                         for (var i = 0; i < childNode.length; i++) {
	                             $("#dataTree").tree('uncheck', childNode[i].target);
	                         }
	                     }
	                 }
             	}
             	//级联选中 end----------------------------------
        
			});
		}
	}

	function onGridRowClick(rowIndex,rowData){
		currentRoleIdText.setValue(rowData.id);
		getTreeData(rowData.id);
	}
	
	function getChecked() {
        var arr = [];
        var checkeds = $('#dataTree').tree('getChecked', 'checked');
        for (var i = 0; i < checkeds.length; i++) {
            arr.push(checkeds[i].id);
        }
        return arr.join(',');
    }

	

	//保存数据
	function saveData(){

		var roleId = currentRoleIdText.getValue();
		if (roleId == null || roleId == ""){
			appAlert("提示", "请先选中一种角色，然后在交易树上勾选后再进行保存", "warning");
			return;
		}
		saveCmd.setParam({ids: getChecked(), roleId: roleId});
		saveCmd.execute();
		if (saveCmd.commandSuccess){
			var result = saveCmd.getResult();
			if (result == "success"){
				alert("保存成功!");
			}
		}
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


	//-------------树相关事件 end---------------------------------------------------------------
	</script>
  </head>
  
 
<body class="easyui-layout layout" style="height: 100%; overflow: hidden; border: none; margin: 0px; padding: 0px;">
	 	
	 
		
		<!-- west west west west west west west++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<div data-options="region:'west',split:true" style="width:440px;">
				<e:Grid id="grid" rowClick="onGridRowClick"  singleSelect="true" showSearchBar="true"  url="umsrole/lookuppage" clazz="com.als.mod.domain.UmsRoleVO2"></e:Grid>
				<e:Text id="currentRoleIdText" readOnly="true"></e:Text>
		</div>
		<!-- west west west west west west west end++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		
		<!-- center center center center center center center++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->	
		<div data-options="region:'center'">
			<div style="text-align: right;" class="alsui-toolbar">
				<e:Btn id="refreshBtn" iconCls="icon-reload" text="刷新" btnClick="refreshTree"></e:Btn>
				<e:Btn id="expandAllBtn"   text="展开" btnClick="expandAllTreeNode"></e:Btn>
				<e:Btn id="collapseAllBtn"  text="折叠" btnClick="collapseAllTreeNode"></e:Btn>
				<e:Btn id="saveBtn" btnClick="saveData" iconCls="icon-save" text="保存" disabled="false"></e:Btn>
			</div>
			<div style="margin-top:30px;">
				<ul id="dataTree" class="easyui-tree" data-options="lines:true,animate:true" ></ul>  
			</div>
			
		
		</div>
		<!-- center center center center center center center end++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		
		
		
</body>
</html>
