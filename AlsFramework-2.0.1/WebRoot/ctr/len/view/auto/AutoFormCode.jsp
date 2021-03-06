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
    
    <title>表单生成器</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script>

		//var myDialog = new $$.Dialog("myDialog");
		//myDialog.setTitle("弹出框标题");
		//myDialog.setWidth("345px");
		//myDialog.setHeight("400px");
		
		//初始化
		$(function(){
			//myDialog.init();
			
		});

		function replaceAll(str, sptr, sptr1){
            while (str.indexOf(sptr) >= 0){
               str = str.replace(sptr, sptr1);
            }
            return str;
     }

	function okBtnClick(){
		var type = autoCodeTypeGrp.getVal();
		switch (type){
			case "1":
				generalMixCode();
				break;
			case "2":
				generalLabelCode();
				break;
			case "3":
				break;
			default:
				generalMixCode();
				break;
		}
	
	}
	//混合型（排版采用html,表单元素采用标签）
	function generalMixCode(){
		//alert(voClazzText.getValue());
		var list = top.topDomainMap[voClazzText.getValue()];
		if (list == null){
			top.initVOS();//可能是开发过程中新添加的vo，为了避免老是重启，重新加载一次
		}

		 list = top.topDomainMap[voClazzText.getValue()];
		if (list == null){
			alert("没有找到对应的VO，请在vos.xml中配置");
			return;
		}
		var t = [];
		var g = [];//get
		var s = [];//set
		var e = [];//setEmpty
		var formName="myform";
		t.push('<div id="'+formName+'" class="alsui-form">\r\n');
		for (var i =0, len = list.length; i < len; i++ ){
			var id = preText.getValue()+list[i].field+sufText.getValue()+"TB";
			t.push('	<ul id="'+formName+'Row'+i+'" class="alsui-row">\r\n');
			t.push('		<li id="'+formName+'Fld'+i+'" class="alsui-fld">\r\n');
			t.push('			<als:Text id="'+id+'" label="'+list[i].title_code+'"  labelClass="'+labelPositionGrp.getVal()+'" ></als:Text>\r\n');
			t.push('		</li>\r\n');
			t.push('	</ul>\r\n');

			s.push(id +".setValue(__obj."+list[i].field+");\r\n");
			g.push( "__obj."+list[i].field + " = " +id +".getValue();\r\n");
			e.push(id +".setValue(\"\");\r\n");
		}
		t.push('</div>');

		var html = t.join('');
		html = replaceAll(html, "als:", "e:")
		//alert(html);
		$("#code").html(html);

		$("#code2").html("function setFormData(__obj){\r\n" + s.join("") + "}");
		$("#code3").html("function getFormData(__obj){\r\n" + g.join("")+ "}");
		$("#code4").html("function resetFormData(__obj){\r\n" + e.join("")+ "}");
	}
	
	//纯标签型
	function generalLabelCode(){
		//alert(voClazzText.getValue());
		var list = top.topDomainMap[voClazzText.getValue()];
		if (list == null){
			alert("没有找到对应的VO，请在vos.xml中配置");
			return;
		}
		var t = [];//UI
		var g = [];//get
		var s = [];//set
		var e = [];//setEmpty
		var formName="myform";
		t.push('<als:Form id="'+formName+'">\r\n');
		for (var i =0, len = list.length; i < len; i++ ){
			var id = preText.getValue()+list[i].field+sufText.getValue()+"TB";
			t.push('	<als:Row id="'+formName+'Row'+i+'">\r\n');
			t.push('		<als:Fld id="'+formName+'Fld'+i+'">\r\n');
			t.push('			<als:Text id="'+id+'" label="'+list[i].title_code+'"  labelClass="'+labelPositionGrp.getVal()+'" ></als:Text>\r\n');
			t.push('		</als:Fld>\r\n');
			t.push('	</als:Row>\r\n');

			s.push(id +".setValue(__obj."+list[i].field+");\r\n");
			g.push( "__obj."+list[i].field + " = " +id +".getValue();\r\n");
			e.push(id +".setValue(\"\");\r\n");
		}
		t.push('</als:Form>');

		var html = t.join('');
		html = replaceAll(html, "als:", "e:")
		//UI
		$("#code").html(html);
		$("#code2").html("function setFormData(__obj){\r\n" + s.join("") + "}");
		$("#code3").html("function getFormData(__obj){\r\n" + g.join("")+ "}");
		$("#code4").html("function resetFormData(__obj){\r\n" + e.join("")+ "}");
	}

	</script>
  </head>
  
<body>

	<!-- text ++++++++++++++++++++++++++++++++++++++ -->
	<table style="padding:8px;">
		<tr>
			<td>
				<div id="myDialog" class="alsui-dlog">
				<e:Row id="row1">
					<e:Fld id="fld1">
						<e:Text id="voClazzText" label="VO名称(如：com.als.mod.domain.UmsTransCodeVO):" labelClass="up" value="com.als.mod.domain.UmsTransCodeVO"></e:Text>
					</e:Fld>
				</e:Row>
				<e:Row id="row5">
					<e:Fld id="fld5">
						<e:Text id="preText" label="元素ID前辍:" labelClass="up"></e:Text>
					</e:Fld>
				</e:Row>
				<e:Row id="row6">
					<e:Fld id="fld6">
						<e:Text id="sufText" label="元素ID后辍:" labelClass="up"></e:Text>
					</e:Fld>
				</e:Row>
				<e:Row id="row2">
					<e:Fld id="fld2">
						<e:Text id="ColsText" label="列数:" labelClass="up"></e:Text>
					</e:Fld>
				</e:Row>
				
				<e:Row id="row3">
					<e:Fld id="fld3" >
						<e:RdoGrp id="autoCodeTypeGrp" conName="DEV_AUTO_CODE_TYPE" val="1" label="代码类型" labelClass="up"></e:RdoGrp>
					</e:Fld>
				</e:Row>
				<e:Row id="row4">
					<e:Fld id="fld4">
						<e:RdoGrp id="labelPositionGrp" conName="DEV_LABEL_POSITION" val="up" label="标签在" labelClass="up"></e:RdoGrp>
					</e:Fld>
				</e:Row>
				<e:Row id="row99">
					<e:Btn id="okBtn" btnClick="okBtnClick" text="生成" iconCls="icon-ok"></e:Btn>
				</e:Row>
				
				结果说明：<p></p><p></p>
				1.第1列为JSP中的UI<p></p>
				2.第2列为JSP中的set代码<p></p>
				3.第3列为JSP中的get代码<p></p>
				3.第4列为JSP中的set清空（或重置代码代码<p></p>
			</div>
			</td>
			
			<td><textarea id="code"  rows="33" cols="25" readonly="readonly"></textarea></td>
			<td><textarea id="code2"  rows="33" cols="25" readonly="readonly"></textarea></td>
			<td><textarea id="code3"  rows="33" cols="25" readonly="readonly"></textarea></td>
			<td><textarea id="code4"  rows="33" cols="25" readonly="readonly"></textarea></td>
		</tr>
	</table>
	
	
	<!-- text end ++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>
