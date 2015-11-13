/**
 ComboGrid 下拉表格
 */

/*
语法检查：http://www.itlearner.com/code/jslint/
YUI压缩：http://yui.2clics.net/
数字压缩:http://www.wxwdesign.cn/down/script_packer/packer_cn.php
*/
AliceJS.ComboGrid = function (id){
	
	//继承自AliceJS.Text-(2.1)--------------------------------------------------------------
    AliceJS.Combo.call(this, id); //call(this,父参数1,父参数2,.....,父参数n)
	//继承自AliceJS.Text end ---------------------------------------------------------------
   this.cacheParams = {
		page: 1,
		rows: 10,
		orderField: "",
		orderType: ""
	};
   this.columns = [];
   
   //选择完后事件
   this.onHidePanelFn = function(){};
   this.setOnHidePanelFn = function(p){this.onHidePanelFn = p;};
   //this.width="280px";
   //this.height=28;
   //this.setWidth=function(p){this.width=p;};
   //this.setHeight=function(p){this.height=p;};
   this.setColumns = function(c){ this.columns = c;};
   this.singleSelect = true;
   this.setSingleSelect = function(t){ this.singleSelect = t;};
   this.showSearchBar = true;
   this.setShowSearchBar = function(f){this.showSearchBar = f;};
   this.queryParams ={};
   this.val = "";//当前值，默认值
   this.setVal = function(p){this.val=p;};
   this.queryCmd = new $$.Command();
   this.setQueryParams = function(params){
		var params = params || {};
		this.queryParams = params;
		
	}
	this.getQueryParams = function(){
		this.queryParams = this.queryParams || {};
		this.queryParams.page = this.cacheParams.page;
		this.queryParams.rows = this.cacheParams.rows;
		this.queryParams.orderField = this.cacheParams.orderField;
		this.queryParams.orderType = this.cacheParams.orderType;
		
		return this.queryParams;
	}
   
   this.init = function(){
   		var _this= this;
		$('#' + this.id).combogrid({    
		    delay: 500,    
		    panelWidth:450,
		    width:this.width,
			height:this.height,
			onChange: function(newValue, oldValue){
				//alert(666);
				_this.onChangeFn(newValue, oldValue);
			},
		   // mode: 'remote',    
		   // url: _this.url,    
		    idField: _this.valField,    
		    textField:_this.textField,    
		    columns: [_this.columns],
            striped: true,  
            editable:true,  
            onHidePanel: function () {
				_this.onHidePanelFn({text:_this.getText(), val: _this.getVal()});
            },
            pagination : true,//是否分页  
            rownumbers:true,//序号  
            collapsible:false,//是否可折叠的  
            pageSize: 10//每页显示的记录条数，默认为10 
		   
		});  
		
		var p = $("#" + this.id).combogrid("grid").datagrid('getPager');//分页组件
		
		 $(p).pagination({
			 //分页条切换页面事件
			 onSelectPage:function(pageNumber, pageSize){
			 	_this.cacheParams.page = pageNumber;
				_this.cacheParams.rows = pageSize;
				_this.exeQuery();
			 }
		});
		this.exeQuery();
	};
	
	/**
	 * 查询
	 * turn2FirstPageFlag　是否需要转入首页
	 */
	this.exeQuery = function(turn2FirstPageFlag){
		
		if (turn2FirstPageFlag != null && turn2FirstPageFlag != undefined && turn2FirstPageFlag){
			this.turn2FirstPage();
		}
		
		this.queryCmd.setUrl(this.url);
		var params = this.getQueryParams();
		this.queryCmd.setParam(params);
		this.queryCmd.execute();
		if (this.queryCmd.commandSuccess){
			var result = this.queryCmd.getResult();
			var data = {"total":result.total,"rows":result.dataList};
			//$("#" + this.id).combogrid('loadData',data);
			$("#" + this.id).combogrid("grid").datagrid("loadData", data);
			//alert(this.val);
			//$('#'+ this.id).combobox('setValue',this.val);
			$('#' + this.id).combogrid('grid').datagrid('selectRecord',this.val);
		}    
	}
	
	/**
	 * 是否转到第一页，一般改变查询条件的时候要转到第１页
	 */
	this.turn2FirstPage = function(){
		
		var p = $("#" + this.id).combogrid("grid").datagrid('getPager');//分页组件
			 $(p).pagination({
                 pageNumber: 1 //查询时，让分页组件跳转到首页
             });
        this.cacheParams.page = 1;
	};
    
};

//继承自AliceJS.Text-(2.2)--------------------------------------------------------------
AliceJS.ComboGrid.prototype = new AliceJS.Combo();
//继承自AliceJS.Text end ----------------------------------------------------------
