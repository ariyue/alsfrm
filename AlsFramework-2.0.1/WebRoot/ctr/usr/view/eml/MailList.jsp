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
    
    <title>收信</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script type="text/javascript">
	
	//保存
	var saveCmd = new $$.Command();
	var saveCmdUrl = ROOT_PATH + "umsentity/save";
	saveCmd.setUrl(saveCmdUrl);

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
	


	//页面初始化-----------------------------------------
	$(function(){

		//表格菜单栏-添加事件
		mygrid.setAddFn(function(){
			
		});

		//表格菜单栏-删除事件
		mygrid.setDelFn(function(rows){

		});
	});
	//页面初始化-----------------------------------------
	
	
	//表格行单击事件
	function onGridRowClick(rowIndex,rowData){
		setFormData(rowData);
	}

	

	function resetFormData(__obj){
		
	}

	function setFormData(__obj){
		

	}

	function getFormData(__obj){
		
	}

	</script>
  </head>
  
 
<body class="easyui-layout layout" style="height: 100%; overflow: hidden; border: none; margin: 0px; padding: 0px;">
		<!-- west west west eest west west west++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<div data-options="region:'east',split:true" style="width:210px;">
			<!-- 菜单 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
			<div style="" >
				
			</div>
			<!-- 菜单 end+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->

			<!-- 表单 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
			<div id="myform"  class="alsui-form">
				
			</div>
			<!-- 表单 end+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		</div>
		<!-- west west west west west west west end++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		
		<!-- center center center center center center center++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->	
		<div data-options="region:'center'">
		
			<e:Grid id="mygrid" toolbar="1,icon-add,回复;2,icon-add,回复全部;3,icon-add,转发;4,icon-add,加标签;5,icon-add,移至;2,icon-add,回复全部;x,icon-remove,删除" rowClick="onGridRowClick"  singleSelect="true" showSearchBar="true"  url="emlemail/lookuppage" clazz="com.als.mod.domain.EmlEmailVO2"></e:Grid>
			
		</div>
		<!-- center center center center center center center end++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		
		
		
</body>
</html>
