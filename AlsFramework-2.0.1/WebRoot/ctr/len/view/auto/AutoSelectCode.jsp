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
    
    <title>Select自动生成器</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script>

	function auto(){

		//alert("dfdfdfd");
		var s = $("#sourceCode").val();
			s=s.replace(/[\n]/ig,'');
		var sql = s;
		var num1 = sql.indexOf("select") + 6;
		var num2 = sql.indexOf("from");
		var tableName = sql.substring(num2 + 4);
		tableName = tableName.split(" ")[1].split(".");
		tableName = tableName[tableName.length - 1];
		var qryField = sql.substring(num1,num2);
		var qryFieldAry = qryField.split(",");
		var qryStr = "";
		var temp = "";
		for (var i =0, len = qryFieldAry.length ; i < len; i++ ){
			temp = qryFieldAry[i];
			qryStr += "," + temp + " " + convert2PropertyName(temp);
		}
		qryStr = qryStr.substring(1).replace(/\s+/g, ' ');

		
		var result = "select" + qryStr + " from " + tableName;
	
		$("#code").html(result);
	}


	function convert2PropertyName(columnName){

		var sb = "";
		var c = "_".charAt(0);
		for (var i = 0, len = columnName.length; i < len; i++) {
			var ch = columnName.charAt(i);
			if (c == ch && (i + 1) < len) {
				sb += columnName.charAt(i + 1).toUpperCase();
				i++;
			} else {
				sb += ch;
			}
		}
		return sb;
	
	}
	
	</script>
  </head>
  
<body>

	<!-- text ++++++++++++++++++++++++++++++++++++++ -->
	步骤如下：<p></p><p></p>
	1.通过SQLYog生成select语句，填入下框：<p></p>
	 <textarea id="sourceCode"  rows="15" cols="150" ></textarea><p></p>
	3.<e:Btn id="autoBTN" text="生成" btnClick="auto"></e:Btn><p></p>
	<textarea id="code"  rows="15" cols="150" readonly="readonly"></textarea><p></p>
     
	
	<!-- text end ++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>
