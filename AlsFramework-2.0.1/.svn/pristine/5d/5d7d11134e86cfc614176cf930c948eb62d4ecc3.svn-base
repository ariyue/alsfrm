/**
 * Combo 下拉框
 *  
 * 
 */
AliceJS.Combo = function (id){
	
	this.cacheParams = {
		text:"",
		value: ""
	};
	this.id= id;//html中input控件的id
	this.conName = "";//常量frm_bas_constant中的name值
	this.entitySid = "00000";
	this.url="frmBasAction/getConstantList";
	this.width="280px";
	this.height=28;
	this.val = "";//当前值，默认值
	this.valField = "itemCode";
	this.textField = "itemText";
	this.text="";
	this.readOnly=false;
	
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
			$('#' + this.id).combobox('readonly',p);
		}catch(e){
			
		}
		//
	};
	
	
	//多选
	this.multiple = "false"; //是否是多选
	this.setMultiple = function(p){this.multiple = p;};
	this.vals = "";//当前值。默认值，多选默认值
	
	this.separator = ","; //多选时的分隔符，默认为逗号
	this.setSeparator = function(p){ this.separator = p;};
	//查询前参数
	this.onBeforeLoadFn = function(){};
	this.setOnBeforeLoadFn = function(fn){this.onBeforeLoadFn = fn;};
	
	this.queryParams ={};
	this.setQueryParams = function(params){
		var params = params || {};
		this.queryParams = params;
		
	}
	this.getQueryParams = function(){
		return this.queryParams;
	}
	
	//setters---
	this.setEditable=function(p){this.editable=p;};
	this.setRequired = function(p){this.required = p;};
	this.setMissingMsg = function(p){this.missingMsg = p;};
	this.setWidth=function(p){this.width=p;};
	this.setHeight=function(p){this.height=p;};
	this.setConName=function(p){this.conName=p;};
	this.setEntitySid=function(p){this.entitySid=p;};
	this.setUrl = function(p){this.url=p;};
	this.setVal = this.setValue = function(p){
		this.val=p;
		//alert("p=" + p);
		try{
			$('#'+ this.id).combobox('setValue',p);
		} catch(e){}
	};
	this.setVals = this.setValues = function(p){
		this.vals = p;
		try{
			$('#'+ this.id).combobox('setValues', this.vals.split(this.separator))
		} catch(e){}
	};
	//获取选中的值
	this.getVal = this.getValue = function(){
		var v = $('#' + this.id).combobox('getValue');
		return v;
	};
	//获取选中的文本
	this.getText= function(){return $('#' + this.id).combobox('getText');}
	
	this.setValField = function(p){this.valField=p;};
	this.setTextField = function(p){this.textField=p;};
	this.getVals = this.getValues = function(){
		 v = $('#' + this.id).combobox('getValues').join(this.separator);
		// alert("v=" + v.indexOf(this.separator));
		 if (v.indexOf(this.separator) == 0){
			v = v.substring(1);
		 }
		// alert("v=" + v);
		 return v;
	};
	this.getTexts= function(){return $('#' + this.id).combobox('getText');}
	//setters---
	
	//如果含有按钮时，按钮的单击事件
	this.onBtnClickFn = function(){};
	this.setBtnClickFn = function(fn){this.onBtnClickFn = fn;};
	
	this.onIconClickFn = function(){};
	this.setIconClickFn = function(fn){this.onIconClickFn = fn;};
	
	this.onChangeFn = function(){};
	this.setOnChangeFn = function(p){ this.onChangeFn = p;};

	
	this.init = function(){
		//alert("this=" + this.id);
		var _this = this;
		if (this.conName == ""){
			alert("请输入常量名");
			return;
		}
	
		
		var params = {    
			    valueField: this.valField,   
			    textField: this.textField,
			    width:this.width,
			    height:this.height,
			    required: this.required,
				missingMessage: this.missingMsg,
				editable: (this.editable == "false" ? false : true),
				onChange: function(newValue, oldValue){
					_this.onChangeFn(newValue, oldValue);
				}
			};
		
		
		if (this.multiple == "true"){
			
			params.multiple = this.multiple;
		}
		$('#'+ this.id).combobox(params); 
		
		this.loadData();
		
	};
	
	/**
	 * 加载数据
	 */
	this.loadData = function(){
		var _this = this;
		var data = this.getData();
		if (data == null){
			return;
		}
		$('#'+ this.id).combobox("loadData", data); 
		//alert("this.multiple=" + this.multiple);
		if (this.multiple == "true"){
			$('#'+ this.id).combobox('setValues', this.vals.split(this.separator))
		} else {
			$('#'+ this.id).combobox('setValue',_this.val);
		}	 
	}
	
	this.getData = function(){
		
		var param = {};
		if (this.url == "frmBasAction/getConstantList"){//通过常量列表的查询
			param.conName = this.conName;
			param.entitySid = this.entitySid;
		
		} else {
			this.onBeforeLoadFn(this.queryParams);
			param = this.queryParams;
		}
		
		var tstCmd = new $$.Command();
		var url = ROOT_PATH + this.url;
		//alert("url=" + url);
		tstCmd.setUrl(url);
		tstCmd.setParam(param);
		tstCmd.execute();
		if (tstCmd.commandSuccess){
			return tstCmd.getResult();
		}
		return [];
	}
	
	
};
