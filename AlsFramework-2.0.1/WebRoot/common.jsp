<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="alsTags" prefix="e"%> 
<%

	String  rootPath  =  request.getScheme() + "://" +  request.getServerName()  +  ":"  +  request.getServerPort()  +  request.getContextPath();
    //String rootPath = request.getRequestURL().toString();
    
    // String  appPath  =  "http://"  +  request.getServerName()  +  ":"  +  request.getServerPort()  +  request.getContextPath()+request.getServletPath().substring(0,request.getServletPath().lastIndexOf("/")+1); 
     //System.out.println("web  URL  路径:"+realPath1);
 %>
<script type="text/javascript">
<!--
	//应用站点根目录路径
	var ROOT_PATH = '<%=rootPath%>' + "/";
	//alert("应用站点根目录路径=" + ROOT_PATH);
	
	//usr文件夹的web访问路径
	var USR_PATH = ROOT_PATH + "ctr/usr/";
//-->
</script>

<link rel="stylesheet" type="text/css" href="<%=rootPath%>/als/skin/default/als.css">
<link rel="stylesheet" type="text/css" href="<%=rootPath%>/ctr/usr/skin/default/web.css">
<link rel="stylesheet" type="text/css" href="<%=rootPath%>/als/skin/default/layout-default.css">
<link rel="stylesheet" type="text/css" href="<%=rootPath%>/als/skin/gray/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=rootPath%>/als/skin/icon.css">


<script type="text/javascript" src="<%=rootPath%>/als/lib/jquery-1.11.1.js"></script>
<script type="text/javascript" src="<%=rootPath%>/als/lib/jquery-ui.js"></script>
<script type="text/javascript" src="<%=rootPath%>/als/lib/jquery.layout.js"></script>
<script type="text/javascript" src="<%=rootPath%>/als/lib/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=rootPath%>/als/lib/jquery.radio.js"></script>
<script type="text/javascript" src="<%=rootPath%>/als/lib/jquery.checkbox.js"></script>
<script type="text/javascript" src="<%=rootPath%>/als/lib/md5.js"></script>
<script type="text/javascript" src="<%=rootPath%>/als/lib/UUID.js"></script>

<script type="text/javascript" src="<%=rootPath%>/als/lib/eui.ex.validate.js"></script>
<script type="text/javascript" src="<%=rootPath%>/als/i18n/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=rootPath%>/als/lib/json2.js"></script>
<script type="text/javascript" src="<%=rootPath%>/als/lib/JSONUtil.js"></script>
<script type="text/javascript" src="<%=rootPath%>/als/lib/kindeditor/kindeditor-min.js"></script>


<script type="text/javascript" src="<%=rootPath%>/als/js/core/Core.js"></script>
<script type="text/javascript" src="<%=rootPath%>/als/js/eui/Text.js"></script>
<script type="text/javascript" src="<%=rootPath%>/als/js/eui/SearchText.js"></script>
<script type="text/javascript" src="<%=rootPath%>/als/js/eui/SearchText.js"></script>
<script type="text/javascript" src="<%=rootPath%>/als/js/eui/Combo.js"></script>
<script type="text/javascript" src="<%=rootPath%>/als/js/eui/RdoGrp.js"></script>
<script type="text/javascript" src="<%=rootPath%>/als/js/eui/ChkGrp.js"></script>

<script type="text/javascript" src="<%=rootPath%>/als/js/eui/DateText.js"></script>
<script type="text/javascript" src="<%=rootPath%>/als/js/eui/TimeText.js"></script>
<script type="text/javascript" src="<%=rootPath%>/als/js/eui/Grid.js"></script>
<script type="text/javascript" src="<%=rootPath%>/als/js/eui/ComboGrid.js"></script>
<script type="text/javascript" src="<%=rootPath%>/als/js/eui/Btn.js"></script>
<script type="text/javascript" src="<%=rootPath%>/als/js/eui/Dialog.js"></script>


<link rel="stylesheet" href="<%=rootPath%>/als/lib/kindeditor/themes/default/default.css" />
<link rel="stylesheet" href="<%=rootPath%>/als/lib/kindeditor/plugins/code/prettify.css" />
<script charset="utf-8" src="<%=rootPath%>/als/lib/kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="<%=rootPath%>/als/lib/kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8" src="<%=rootPath%>/als/lib/kindeditor/plugins/code/prettify.js"></script>

<script type="text/javascript">

  function appWin(title, content, width, height){
	//mainPage默认时就有创建了
	var width = width || 320;
	//alert("width=" + width);
	var height = height || 180;
	//alert("height=" + height);
	top.$("#topPopInfoWin").window(
			{
			   iconCls: 'icon-add',
			   closed: true,
                width: width,
                height: height,
                top: ($(window).height() - height) * 0.5,
                left: ($(window).width() - width) * 0.5,
                modal: true,
                title: title,
                content: content
                //href: "ctr/len/view/abc/CommandDemo.jsp"
            }
	);
	top.$("#topPopInfoWin").window('open');
  }

  function appConfirm(title, content, fn){
	  //$.messager.defaults = { ok: "是", cancel: "否" };//可以改变默认的是否值，也可以和国际化中的数据
	  var title = title || "请您确认";
	  var content = content || "是否确定要执行此操作?"
	  top.$.messager.confirm(title, content, function(r){
			if (r){fn();}
		});
	}

  /**
   * 弹出信息框
   * @param type=['info','warning','error','question']
   */
  function appAlert(title, content, type){
	  top.$.messager.alert( title, content, type);
  }

  /**
   * 弹出信息框(右下角)
   * @param type=['info','warning','error','question']
   */
  function appMsg(title, content){

	  top.$.messager.show({
			title: title || '系统信息',
			msg: content || '欢迎您使用本系统！',
			timeout:5000,
			showType:'slide'
		});
  } 

  var action;
  /*
  $(function(){
	  action = $("body").attr("action");
	  //alert("action=" + action);
	  if (action != null){
		  var param = {
					
			};
			var tstCmd = new $$.Command();
			var url = ROOT_PATH + "login/init";
			//alert("url=" + url);
			tstCmd.setUrl(url);
			tstCmd.setParam(param);
			//alert(33333);
			tstCmd.execute();
			//alert(4444);
			if (tstCmd.commandSuccess){
				var result = tstCmd.getResult();
				alert("code=" + result.appName);
			}
	   }
   });
  */
</script>


