/**
 * Text 文本框
 *  
 * 
 */
AliceJS.Text = function (id){
	
	this.cacheParams = {
		text:"",
		value: ""
	};
	this.id= id;//html中input控件的id
	this.label = "";//输入框前面的文本label标签
	this.labelClass=""//文本label的样式
	
	//回车键事件
	this.enterKeyFn = function(){};
	this.setEnterKeyFn = function(p){this.enterKeyFn = p;};
	
	this.width="280px";
	this.height=28;
	this.prompt="";
	this.value="";
	this.type="text";
	this.multiline=false;
	this.editable=true;
	this.disabled=false;
	this.readOnly=false;
	this.icons=[];
	this.iconCls=null;
	this.iconAlign="right";
	this.iconWidth=18;
	this.buttonText="";
	this.buttonIcon=null;
	this.buttonAlign="right";
	this.required=null;// "false";//是否必输
	this.missingMsg= null;//"请输入值";//为空时的提示
	this.validType=null;//"";//验证器（easyui自带的，也可以使用扩展(eui.ex.validate.js)
	this.invalidMsg=null;//"";//验证器验证时出错的提示信息
	this.maxlength = null;
	
	//setters---
	this.setRequired = function(p){this.required = p;};
	this.setMissingMsg = function(p){this.missingMsg = p;};
	this.setValidType = function(p){this.validType = p;};
	this.setInvalidMsg = function(p){this.invalidMsg = p;};
	this.setLabel = function(p){this.label = p;};
	this.setLabelClass = function(p){this.labelClass = p;};
	this.setWidth=function(p){this.width=p;};
	this.setHeight=function(p){this.height=p;};
	this.setPrompt=function(p){this.prompt=p;};
	this.setMaxlength = function(p){this.maxlength = p;};
	this.setValue=this.setVal = function(p){
		this.value=p;
		try{
			$("#" + this.id).textbox('setValue',p);
		}catch(e){
			
		}
		
	};
	this.setType=function(p){this.type=p;};
	this.setMultiline=function(p){this.multiline=p;};
	this.setEditable=function(p){this.editable=p;};
	this.setDisabled=function(p){this.disabled=p;};
	//true/false
	this.setReadOnly=function(p){
		
		if (p == "true"){
			p = true;
		}
		if (p == "false"){
			p = false;
		}
		this.readOnly=p;
		try{
			$('#' + this.id).textbox('readonly',p);
		}catch(e){
			
		}
		//
	};
	this.setIcons=function(p){this.icons=p;};
	this.setIconCls=function(p){this.iconCls=p;};
	this.setIconAlign=function(p){this.iconAlign=p;};
	this.setIconWidth=function(p){this.iconWidth=p;};
	this.setButtonText=function(p){this.buttonText=p;};
	this.setButtonIcon=function(p){this.buttonIcon=p;};
	this.setButtonAlign=function(p){this.buttonAlign=p;};
	
	//setters---
	
	this.getVal = function(){return $('#'+ this.id).val();};
	this.getValue = function(){return $('#'+ this.id).val();};
	this.getText = function(){return $('#'+ this.id).val();};
	
	//如果含有按钮时，按钮的单击事件
	this.onBtnClickFn = function(){};
	this.setBtnClickFn = function(fn){this.onBtnClickFn = fn;};
	
	this.onIconClickFn = function(){};
	this.setIconClickFn = function(fn){this.onIconClickFn = fn;};

	
	this.init = function(){
		//alert("this=" + this.id);
		var _this = this;
		if(this.label != null && this.label != ""){
			$('#'+ this.id).before('<label class="'+ this.labelClass+'">'+ this.label+'</label>');
		}
		$('#'+ this.id).textbox({ 
		 	width:this.width,
			height:this.height,
			prompt:this.prompt,
			value:this.value,
			type:this.type,
			multiline:this.multiline,
			editable: (this.editable == "false" ? false : true),
			disabled:this.disabled,
			readonly:this.readOnly,
			icons:this.icons,
			iconCls:this.iconCls,
			iconAlign:this.iconAlign,
			iconWidth:this.iconWidth,
			buttonText:this.buttonText,
			buttonIcon:this.buttonIcon,
			buttonAlign:this.buttonAlign,
			validType:this.validType,
			invalidMessage:this.invalidMsg,
			required: this.required,
			missingMessage: this.missingMsg,
			maxlength: this.maxlength,
			onClickButton: function(){_this.onBtnClickFn( $('#'+ _this.id).val());},
			onClickIcon: function(){_this.onIconClickFn(index);}
		});
		
		//回车键事件
		$('#'+ this.id).textbox('textbox').keydown(function (e){
            if (e.keyCode == 13) {
               _this.enterKeyFn($('#'+ _this.id).val());
            }
        });
	};
	
	
};
