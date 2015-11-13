/**
 * Dialog 对话框组件
 *  
 * 
 */
AliceJS.Dialog = function (id){
	
	this.cacheParams = {
		text:"",
		value: ""
	};
	this.id= id;//html中input控件的id
	this.title = "";//标题
	this.content = "";//内容
	
	this.width="400px";
	this.height="auto";
	
	//setters---

	this.setTitle = function(p){this.title = p;};
	this.setContent = function(p){this.content=p;};
	this.setWidth=function(p){this.width=p;};
	this.setHeight=function(p){this.height=p;};
	
	//setters---
	
	//如果含有按钮时，按钮的单击事件
	this.onBtnClickFn = function(){};
	this.setBtnClickFn = function(fn){this.onBtnClickFn = fn;};
	
	this.onIconClickFn = function(){};
	this.setIconClickFn = function(fn){this.onIconClickFn = fn;};

	this.getDialogId = function(){return "__" +this.id };
	this.getDialogHeadId = function(){return this.getDialogId() + "hd"};
	this.getDialogBodyId = function(){return this.getDialogId() + "bd"};
	this.getDialogFootId = function(){return this.getDialogId() + "ft"};
	this.getDialogCloseId = function(){return this.getDialogId() + "cls"};
	this.init = function(){
		//alert("this=" + this.id);
		var _this = this;
		var html = '<div id="'+this.getDialogId()+'" class="alsui-dlog-warp" style="width: '+ this.width+'; ">\
					  	<div id="'+this.getDialogHeadId()+'" class="alsui-dlog-hd">\
					  		<div class="alsui-dlog-hdl">&nbsp;</div>\
					  		<div class="alsui-dlog-hdr">&nbsp;</div>\
					  		<div class="alsui-dlog-hdc">&nbsp;<span class="titleText">'+ this.title+'</span><span  id="'+this.getDialogCloseId()+'"   style="cursor: pointer;float:right;" >X</span></div>\
					  	</div>\
					  	<div class="alsui-dlog-bdl">\
					  		<div class="alsui-dlog-bdr">\
					  			<div id="'+this.getDialogBodyId()+'" class="alsui-dlog-bd" style="height: '+this.height+';">\
								</div>\
							</div>\
						</div>\
						<div id="'+ this.getDialogFootId()+'" class="alsui-dlog-ft">\
							<div class="alsui-dlog-ftl">&nbsp;</div>\
							<div class="alsui-dlog-ftr">&nbsp;</div>\
							<div class="alsui-dlog-ftc">&nbsp;</div>\
						</div>\
					</div>';
		
		$('#'+ this.id).before(html).appendTo($('#' + this.getDialogBodyId()));
		$('#' +this.getDialogCloseId()).bind("click", function(){_this.close();});
		
		//可拖放
		$('#'+ this.getDialogId()).draggable({ 
			  handle:'#' + this.getDialogHeadId() 
			  }); 
		//可改变大小
	  	$('#' + this.getDialogId()).resizable({ 
		  maxWidth:800, 
		  maxHeight:600 
		  }); 
		  	  
	};
	
	this.show = function(){
		var w = $('#' + this.getDialogId()).width();
		var h = $('#' + this.getDialogId()).height();
		$('#' + this.getDialogId()).css({'marginLeft':-(w/2) + 'px','marginTop':-(h/2) + 'px','display': 'block'});
	}
	
	this.close = this.hide = function(){
		
		//alert("close");
		$('#' + this.getDialogId()).css('display', 'none');
		
		
	}
	
	
};
