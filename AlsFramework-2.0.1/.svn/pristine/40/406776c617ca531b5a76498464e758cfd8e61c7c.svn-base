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
    
    <title>表单实例</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script type="text/javascript">

	

	</script>
  </head>
  
<body>
	<div style="margin-top:20px;margin-left:20px;">
		1.vlidatebox<br/>
		<input id="mydata" class="easyui-validatebox" />
		<br/>获取和设置值：<br/>
		alert($("#mydata").val());<br/>
		$("#mydata").val("mzwu.com");<br/>
	</div>
	
	<div style="margin-top:20px;margin-left:20px;">
		2.combobox<br/>
		<select class="easyui-combobox" name="state" style="width:200px;">
			<option value="AL">Alabama</option>
			<option value="AK">Alaska</option>
			<option value="AZ">Arizona</option>
			<option value="AR">Arkansas</option>
			<option value="CA">California</option>
			<option value="CO">Colorado</option>
			<option value="CT">Connecticut</option>
			<option value="DE">Delaware</option>
			<option value="FL">Florida</option>
			<option value="GA">Georgia</option>
			<option value="HI">Hawaii</option>
			<option value="ID">Idaho</option>
			<option value="IL">Illinois</option>
			<option value="IN">Indiana</option>
			<option value="IA">Iowa</option>
			<option value="KS">Kansas</option>
			<option value="KY">Kentucky</option>
			<option value="LA">Louisiana</option>
			<option value="ME">Maine</option>
			<option value="MD">Maryland</option>
			<option value="MA">Massachusetts</option>
			<option value="MI">Michigan</option>
			<option value="MN">Minnesota</option>
			<option value="MS">Mississippi</option>
			<option value="MO">Missouri</option>
			<option value="MT">Montana</option>
			<option value="NE">Nebraska</option>
			<option value="NV">Nevada</option>
			<option value="NH">New Hampshire</option>
			<option value="NJ">New Jersey</option>
			<option value="NM">New Mexico</option>
			<option value="NY">New York</option>
			<option value="NC">North Carolina</option>
			<option value="ND">North Dakota</option>
			<option value="OH" selected>Ohio</option>
			<option value="OK">Oklahoma</option>
			<option value="OR">Oregon</option>
			<option value="PA">Pennsylvania</option>
			<option value="RI">Rhode Island</option>
			<option value="SC">South Carolina</option>
			<option value="SD">South Dakota</option>
			<option value="TN">Tennessee</option>
			<option value="TX">Texas</option>
			<option value="UT">Utah</option>
			<option value="VT">Vermont</option>
			<option value="VA">Virginia</option>
			<option value="WA">Washington</option>
			<option value="WV">West Virginia</option>
			<option value="WI">Wisconsin</option>
			<option value="WY">Wyoming</option>
		</select>
		<br/>
		获取和设置值：<br/>
		alert($("#mydata").combobox("getText"));<br/>
		alert($("#mydata").combobox("getValue"));<br/>
		$("#mydata").combobox("setValue", "2");<br/>
		
		
	</div>
	
	<div style="margin-top:20px;margin-left:20px;">
		<h2>Basic ComboGrid组合数据表格选择</h2>
		<p>Click the right arrow button to show the DataGrid.</p>
		<div style="margin:20px 0"></div>
		<select class="easyui-combogrid" style="width:250px" data-options="
				panelWidth: 500,
				idField: 'itemid',
				textField: 'productname',
				url: 'datagrid_data1.json',
				method: 'get',
				columns: [[
					{field:'itemid',title:'Item ID',width:80},
					{field:'productname',title:'Product',width:120},
					{field:'listprice',title:'List Price',width:80,align:'right'},
					{field:'unitcost',title:'Unit Cost',width:80,align:'right'},
					{field:'attr1',title:'Attribute',width:200},
					{field:'status',title:'Status',width:60,align:'center'}
				]],
				fitColumns: true
			">
		</select>
	</div>
	<div style="margin-top:20px;margin-left:20px;">
		<h2>Basic ComboTree 组合树选择框</h2>
		<p>Click the right arrow button to show the tree panel.</p>
		<div style="margin:20px 0"></div>
		<input class="easyui-combotree" data-options="url:'tree_data1.json',method:'get',required:true" style="width:200px;">
	
	</div>
	<div style="margin-top:20px;margin-left:20px;">
		3.numberbox<br/>
		<input id="mydata" class="easyui-numberbox" />
		<br/>
		获取和设置值：<br/>
		alert($("#mydata").numberbox("getValue"));<br/>
		$("#mydata").numberbox("setValue", "100");<br/>
	</div>
	
	<div style="margin-top:20px;margin-left:20px;">
		4.datebox<br/>
		<input id="mydata" class="easyui-datebox" />
		<br/>
		获取和设置值：<br/>
		alert($("#mydata").datebox("getValue"));<br/>
		$("#mydata").datebox("setValue", "2013/09/10");<br/>
	</div>
	
	<div style="margin-top:20px;margin-left:20px;">
		5.搜索条<br/>
		<input class="easyui-searchbox" data-options="prompt:'Please Input Value',menu:'#searchTypeMenu'" style="width:50%">
		<div id="searchTypeMenu">
			<div data-options="name:'all',iconCls:'icon-ok'">All News</div>
			<div data-options="name:'sports'">Sports News</div>
		</div>
	</div>
	
	<div style="margin-top:20px;margin-left:20px;">
		
	</div>
	
	<div style="margin-top:20px;margin-left:20px;">
		
	</div>
	
	<div style="margin-top:20px;margin-left:20px;">
		
	</div>
	
	<div style="margin-top:20px;margin-left:20px;">
		
	</div>

</body>
</html>
