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
    
    <title>发信</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	
		.alsui-tagtext-box{
			border:1px solid #d3d3d3;
			height: 60px;
			overflow-y:auto;
		}
		.alsui-tagtext-ct{
			visibility: hidden;
			white-space: nowrap;
		}
		.alsui-tagtext{
			float:left; 
			width:20px;
			height: 28px;
			
			-webkit-appearance: none;
			border-width:0px;
			border: 0;
  			outline: 0;
  			white-space: nowrap;
		}
		.alsui-tagtext-t{
			float: left;
  			margin: 0 3px 0 0;
  			white-space: nowrap;
		}
		.alsui-tagtext-s{
			float: left;
		}
	
	</style>
	<script type="text/javascript">

	KindEditor.ready(function(K) {
		var editor1 = K.create('textarea[name="content1"]', {
			cssPath : '../plugins/code/prettify.css',
			uploadJson : 'upload_json.jsp',
			fileManagerJson : 'file_manager_json.jsp',
			allowFileManager : true,
			afterCreate : function() {
				var self = this;
				K.ctrl(document, 13, function() {
					self.sync();
					document.forms['example'].submit();
				});
				K.ctrl(self.edit.doc, 13, function() {
					self.sync();
					document.forms['example'].submit();
				});
			}
		});
		prettyPrint();
	});
	
	
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
		
			
			KindEditor.ready(function(K) {
				var editor  = K.create('#editor_id', {
					resizeType : 1,
					allowPreviewEmoticons : false,
					allowImageUpload : false,
					items : [
						'formatblock','fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'textcolor', 'bold', 'italic', 'underline','strikethrough', 'subscript', 'superscript',
						'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
						'insertunorderedlist', '|', 'emoticons', 'link',  'aliceimage', 'flash', 'table', 'preview', 'fullscreen'
					]
				});
				//alert(999);
				//_this.setEditor(editor);
			});
			
			
		});
	//页面初始化-----------------------------------------
	
	
	//表格行单击事件
	function onGridRowClick(rowIndex,rowData){
		setFormData(rowData);
	}

	

	function resetFormData(__obj){
		idTB.setValue("");
		subjectTB.setValue("");
		contentTB.setValue("");
		attachmentTB.setValue("");
		senderTB.setValue("");
		senderIdTB.setValue("");
		receiverTB.setValue("");
		bccTB.setValue("");
		ccTB.setValue("");
		sendDateTB.setValue("");
		sendTimeTB.setValue("");
		needReplyFlagTB.setValue("");
		timerFlagTB.setValue("");
		sessionIdTB.setValue("");
	}

	function setFormData(__obj){
		idTB.setValue(__obj.id);
		subjectTB.setValue(__obj.subject);
		contentTB.setValue(__obj.content);
		attachmentTB.setValue(__obj.attachment);
		senderTB.setValue(__obj.sender);
		senderIdTB.setValue(__obj.senderId);
		receiverTB.setValue(__obj.receiver);
		bccTB.setValue(__obj.bcc);
		ccTB.setValue(__obj.cc);
		sendDateTB.setValue(__obj.sendDate);
		sendTimeTB.setValue(__obj.sendTime);
		needReplyFlagTB.setValue(__obj.needReplyFlag);
		timerFlagTB.setValue(__obj.timerFlag);
		sessionIdTB.setValue(__obj.sessionId);
	}

	function getFormData(__obj){
		__obj.id = idTB.getValue();
		__obj.subject = subjectTB.getValue();
		__obj.content = contentTB.getValue();
		__obj.attachment = attachmentTB.getValue();
		__obj.sender = senderTB.getValue();
		__obj.senderId = senderIdTB.getValue();
		__obj.receiver = receiverTB.getValue();
		__obj.bcc = bccTB.getValue();
		__obj.cc = ccTB.getValue();
		__obj.sendDate = sendDateTB.getValue();
		__obj.sendTime = sendTimeTB.getValue();
		__obj.needReplyFlag = needReplyFlagTB.getValue();
		__obj.timerFlag = timerFlagTB.getValue();
		__obj.sessionId = sessionIdTB.getValue();
	}


	function send(){

	}


	AliceJS.TagText = function (id){
		this.id= id;//html中input控件的id

		this.vals = "";
		this.texts = "";
		this.init = function(){

			var _this = this;
			$(function(){
				
				//alert($("#toTX").val());
				$("#" + _this.id)
					.after("<div class='alsui-tagtext-box' id='"+ _this.id+"BOX'></div>")
					//.after("<span class='alsui-tagtext-ct' id='"+ _this.id+"CT'><span>")
					.appendTo($("#" + _this.id + "BOX"));
				_this.bind();
			});

		};

		this.bind = function (){
			var _this = this;

			$("#" + _this.id)
				.bind("click",function(event){
					event.stopPropagation();    //  阻止事件冒泡
				}).bind("dblclick",function(event){
					event.stopPropagation();    //  阻止事件冒泡
				}).blur(function(){_this.addTag();});

			
			$("#" + this.id + "BOX").bind("click",function(){
				_this.addTag();
				$("#" + _this.id).appendTo($(this)).focus();
			});

			$("#" + this.id + "BOX").find(".alsui-tagtext-t").on("click",function(event){
				event.stopPropagation();    //  阻止事件冒泡
				alert(7777)}
			);
			//$(".alsui-tagtext-t").live("dblclick",function(){alert(7777)});

			$("#" + this.id).bind("keydown",function(ev){
				var oEvent = ev || event;
				switch(oEvent.keyCode){
				case 188:  // 逗号
					_this.addTag();
					break;
				case 186:  // 分号
					_this.addTag();
					break;
				case 32:  // 空格
					_this.addTag();
					break;
				case 8:  // Backspace
					//alert("d=" +$("#" + _this.id).val());
					var v = $("#" + _this.id).val();
					if (v == ""){
						_this.removeTag();
					}
					break;
				case 13:  // 回车
					_this.addTag();
					break;
				case 38: // 上
					break;
				case 40: // 下
					break;
				case 37: // 右
					break;
				case 39: // 右
					break;
				default:
					_this.autoLen();
					break;
				}
				if(document.all){//ie
					
				} else {
					
				}
			});


			$("#" + this.id).bind("keyup",function(ev){
				var oEvent = ev || event;
				switch(oEvent.keyCode){
				case 188:  // 逗号
					$("#" + _this.id).val("");
					break;
				case 186:  // 分号
					$("#" + _this.id).val("");
					break;
				case 32:  // 空格
					$("#" + _this.id).val("");
					break;
				case 8:  // Backspace
					//alert($("#" + _this.id).val());
					break;
				case 13:  // 回车
					$("#" + _this.id).val("");
					break;
				case 38: // 上
					break;
				case 40: // 下
					break;
				case 37: // 右
					break;
				case 39: // 右
					break;
				}
				if(document.all){//ie
					
				} else {
					
				}
			});
		};

		this.autoLen = function(){
			
			var _this = this;
			/*
			$("#" + this.id + "CT").html($("#" + this.id).val());
			$("#" + this.id).css("width", $("#" + this.id + "CT").width() + 20 +"px");
			*/
			$("#" + this.id).css("width", _this.GetCurrentStrWidth($("#" + this.id).val()));
		};

		this.GetCurrentStrWidth = function(text, font) {
			var currentFont = font || "normal 13px Helvetica, Arial, sans-serif";
	        var currentObj = $('<span>').hide().appendTo(document.body);
	        $(currentObj).html(text).css('font', font);
	        var width = currentObj.width();
	        currentObj.remove();
	        return width  + 20;
	    }
		
		this.removeTag = function(){
			var _this = this;
			 $("#" + _this.id)
		};

		this.addTag = function(){
			var _this = this;
			var v =$("#" + _this.id).val();
			if (v.trim() == ""){
				return;
			}
			$("<div class='alsui-tagtext-t'>" +v + "</div>")
				.bind("click",function(event){
					event.stopPropagation();    //  阻止事件冒泡
				})
				.bind("dblclick",function(event){
					event.stopPropagation();    //  阻止事件冒泡
					$("#" + _this.id).insertBefore($(this)).val($(this).html());
					$(this).remove();
				})
				.insertBefore($("#" + _this.id));

			$("<div class='alsui-tagtext-s'>;&nbsp;&nbsp;&nbsp;</div>")
			.bind("click",function(event){
				event.stopPropagation();    //  阻止事件冒泡
				$("#" + _this.id).insertAfter($(this)).focus();
			})
			.bind("dblclick",function(event){
				event.stopPropagation();    //  阻止事件冒泡
				//$("#" + _this.id).insertAfter($(this)).val();
			})
			.insertBefore($("#" + _this.id));

			$("#" + _this.id).val("").css("width", 20);
			//$("#" + _this.id).before("<span class='alsui-tagtext-t'>" +v + "</span><span class='alsui-tagtext-s'>;&nbsp;&nbsp;&nbsp;</span>").val("");

		};

		this.updateTag = function(){

		};

		


	}

	var toTT = new $$.TagText("toTT");
	toTT.init();
	
	</script>
  </head>
  
 
<body class="easyui-layout layout" style="height: 100%; overflow: hidden; border: none; margin: 0px; padding: 0px;">
		<!-- west west west eest west west west++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		<div data-options="region:'east',split:true" style="width:210px;">
			<!-- 菜单 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
			<div style="text-align: left; height: 28px;padding-left:2px;" class="alsui-toolbar">
				
				<e:SearchText id="searchTB" buttonText="" prompt="查找联系人" width="200"></e:SearchText>
			</div>
			<!-- 菜单 end+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->

			<!-- 表单 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
			<div class="alsui-form">
				
			</div>
			<!-- 表单 end+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		</div>
		<!-- west west west west west west west end++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		
		<!-- center center center center center center center++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->	
		<div data-options="region:'center'">
		
			<!-- 菜单 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
			<div style="text-align: right;height: 28px;" class="alsui-toolbar">
				<e:Btn id="sendBtn" btnClick="send" iconCls="icon-save" text="发送"></e:Btn>
				<e:Btn id="previewBtn" btnClick="send" iconCls="icon-save" text="预览"></e:Btn>
				<e:Btn id="saveBtn" btnClick="send" iconCls="icon-save" text="存草稿"></e:Btn>
				<e:Btn id="cancelBtn" btnClick="send" iconCls="icon-save" text="取消"></e:Btn>
			</div>
			<!-- 菜单 end+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->

			<!-- 表单 ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
			<div id="myform" class="alsui-form" style="line-height:30px; padding:36px 6px 6px 6px;">
				<div class="alsui-layout">
	                <div class="alsui-layout-left" style="width:60px;">
						收件人
					</div>  
	                <div class="alsui-layout-center" style="margin-left:60px;">
						<input class="alsui-tagtext" id="toTT" value="pppp"></input>
					</div>  
				</div>
			
				<div class="alsui-layout" style="margin-top:5px;">
	                <div class="alsui-layout-left" style="width:60px;">
						主题
					</div>  
	                <div class="alsui-layout-center" style="margin-left:60px;">
						<e:Text id="subjectTX" width="100%"></e:Text>
					</div>  
				</div>
				<div class="alsui-layout" style="margin-top:5px;">
					添加附件
				</div>
				<div class="alsui-layout" style="margin-top:5px;">
					<textarea name="content1" cols="100" rows="8" style="width:100%;height:300px;visibility:hidden;"></textarea>
				</div>
				
			</div>
			<!-- 表单 end+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		</div>
		<!-- center center center center center center center end++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ -->
		
		
		
</body>
</html>
