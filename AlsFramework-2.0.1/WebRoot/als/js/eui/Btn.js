/**
 * Btn 按钮
 *  
 * 
 */
AliceJS.Btn = function (id){
	
	this.cacheParams = {
		text:"",
		value: ""
	};
	this.id= id;//html中input控件的id
	this.disabled=false;
	this.toggle=false;
	this.selected=false;
	this.group="";
	this.plain=true;
	this.text="";
	this.iconCls="";
	this.iconAlign="left";
	this.size="small";
	
	//setters---
	this.setId=function(p){this.id=p};
	this.setDisabled=function(p){
		if (p == "true"){
			p = true;
		}else if (p == "false"){
			p = false;
		}
		this.disabled=p;
		try{
			if (p){
				$("#" + this.id).linkbutton("disable");
			} else {
				$("#" + this.id).linkbutton("enable");
			}
			
		}catch(e){}
		
	};
	this.setToggle=function(p){this.toggle=p;};
	this.setSelected=function(p){this.selected=p;};
	this.setGroup=function(p){this.group=p;};
	this.setPlain=function(p){this.plain=p;};
	this.setText=function(p){this.text=p;};
	this.setIconCls=function(p){this.iconCls=p;};
	this.setIconAlign=function(p){this.iconAlign=p;};
	this.setSize=function(p){this.size=p;};
	
	//setters---
	
	//如果含有按钮时，按钮的单击事件
	this.onBtnClickFn = function(){};
	
	this.setBtnClickFn = function(fn){this.onBtnClickFn = fn;};

	
	this.init = function(){
		//alert("this=" + this.id);
		var _this = this;
		$('#'+ this.id).linkbutton({
			disabled:this.disabled,
			toggle:this.toggle,
			selected:this.selected,
			group:this.group,
			plain:this.plain,
			text:this.text,
			iconCls:this.iconCls,
			iconAlign:this.iconAlign,
			size:this.size,
			onClick: this.onBtnClickFn
		}) 
	};
	
	
};
