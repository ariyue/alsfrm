/**
 * Zone 面版组件
 *  
 * 
 */
AliceJS.Zone = function (id){
	
	this.cacheParams = {
		text:"",
		value: ""
	};
	this.id= id;//html中input控件的id
	this.label = "";//输入框前面的文本label标签
	
	this.width="280px";
	this.height=28;
	
	//setters---

	this.setLabel = function(p){this.label = p;};
	this.setWidth=function(p){this.width=p;};
	this.setHeight=function(p){this.height=p;};
	
	//setters---
	
	//如果含有按钮时，按钮的单击事件
	this.onBtnClickFn = function(){};
	this.setBtnClickFn = function(fn){this.onBtnClickFn = fn;};
	
	this.onIconClickFn = function(){};
	this.setIconClickFn = function(fn){this.onIconClickFn = fn;};

	this.getZoneId = function(){return "__" +this.id };
	this.getZoneHeadId = function(){return this.getZoneId() + "hd"};
	this.getZoneBodyId = function(){return this.getZoneId() + "bd"};
	this.getZoneFootId = function(){return this.getZoneId() + "ft"};
	this.init = function(){
		//alert("this=" + this.id);
		var _this = this;
		var html = '<div id="'+this.getZoneId()+'" class="alsui-zone" style="width: 500px; height: auto;">\
					  	<div id="'+this.getZoneHeadId()+'" class="alsui-zone-hd">\
					  		<div class="alsui-zone-hdl">&nbsp;</div>\
					  		<div class="alsui-zone-hdr">&nbsp;<span style="cursor: pointer;">X</span></div>\
					  		<div class="alsui-zone-hdc">&nbsp;<span class="titleText">mingBox简单设置窗</span></div>\
					  	</div>\
					  	<div class="alsui-zone-bdl">\
					  		<div class="alsui-zone-bdr">\
					  			<div id="'+this.getZoneBodyId()+'" class="alsui-zone-bd">\
								</div>\
							</div>\
						</div>\
						<div id="'+ this.getZoneFootId()+'" class="alsui-zone-ft">\
							<div class="alsui-zone-ftl">&nbsp;</div>\
							<div class="alsui-zone-ftr">&nbsp;</div>\
							<div class="alsui-zone-ftc">&nbsp;</div>\
						</div>\
					</div>';
		
		$('#'+ this.id).before(html).appendTo($('#' + this.getZoneBodyId()));
		
		
		//可拖放
		$('#'+ this.getZoneId()).draggable({ 
			  handle:'#' + this.getZoneHeadId() 
			  }); 
		//可改变大小
	  	$('#' + this.getZoneId()).resizable({ 
		  maxWidth:800, 
		  maxHeight:600 
		  }); 
		  	  
 
		
		
	};
	
	
};
