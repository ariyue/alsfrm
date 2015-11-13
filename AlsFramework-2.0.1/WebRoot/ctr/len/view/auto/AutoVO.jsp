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
    
    <title>VO自动生成器</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script>


	var cmd = new $$.Command();
	var url = ROOT_PATH + "autovoaction/genralcode";
	cmd.setUrl(url);

	$(function(){
		//alert(444);
		//boText.setValue("com.als.mod.domain.类名");

	});

	function okBtnClick(){
		cmd.setParam({
			bo: boText.getValue(),
			pkg: pkgText.getValue()
		});
		cmd.execute();
		if (cmd.commandSuccess){
			var r = cmd.getResult();
			$("#code").html(r.vo);
			$("#code2").html(r.i18n);
		}
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
						<e:Text id="boText" label="BO类名(如：com.als.mod.domain.UmsTransCode):" labelClass="up" value="com.als.mod.domain.YourClassName"></e:Text>
					</e:Fld>
				</e:Row>
				<e:Row id="row5">
					<e:Fld id="fld5">
						<e:Text id="pkgText" label="title国际化包名(如：ums.transCode)" labelClass="up"></e:Text>
					</e:Fld>
				</e:Row>
				
				<e:Row id="row99">
					<e:Btn id="okBtn" btnClick="okBtnClick" text="生成" iconCls="icon-ok"></e:Btn>
				</e:Row>
				
				结果说明：<p></p><p></p>
				1.第1列为VO的xml结构<p></p>
				2.第2列为国际化标签源码<p></p>
			</div>
			</td>
			
			<td><textarea id="code"  rows="33" cols="66" readonly="readonly"></textarea></td>
			<td><textarea id="code2"  rows="33" cols="40" readonly="readonly"></textarea></td>
		</tr>
	</table>
	
	
	<!-- text end ++++++++++++++++++++++++++++++++++++++ -->
</body>
</html>
