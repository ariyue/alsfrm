/**
 * Grid
 *  
 * 
 */
AliceJS.Grid = function (id){
	
	this.cacheParams = {
		page: 1,
		rows: 10,
		orderField: "",
		orderType: ""
	};
	this.id= id;//html中table控件的id
	this.title = ""; //表标题
	this.queryParams ={};
	this.queryCmd = new $$.Command();
	this.url = "";
	this.singleSelect = true;
	this.columns = [];
	this.toolbar = [];
	this.onRowClickFn = function(){};
	this.addFn = function(){};//增加
	this.delFn = function(){};//删除
	this.modFn = function(){};//修改
	this.extFn1 = function(){};//扩展按钮1
	this.extFn2 = function(){};//扩展按钮1
	this.extFn3 = function(){};//扩展按钮1
	this.extFn4 = function(){};//扩展按钮1
	this.extFn5 = function(){};//扩展按钮1
	this.extFn6 = function(){};//扩展按钮1
	this.extFn7 = function(){};//扩展按钮1
	this.extFn8 = function(){};//扩展按钮1
	this.extFn9 = function(){};//扩展按钮1
	
	this.showSearchBar = true;
	
	
	this.setAddFn = function(fn){ this.addFn = fn;};
	this.setDelFn = function(fn){ this.delFn = fn;};
	this.setModFn = function(fn){ this.modFn = fn;};
	this.setExtFn1 = function(fn){ this.extFn1 = fn;};
	this.setExtFn2 = function(fn){ this.extFn2 = fn;};
	this.setExtFn3 = function(fn){ this.extFn3 = fn;};
	this.setExtFn4 = function(fn){ this.extFn4 = fn;};
	this.setExtFn5 = function(fn){ this.extFn5 = fn;};
	this.setExtFn6 = function(fn){ this.extFn6 = fn;};
	this.setExtFn7 = function(fn){ this.extFn7 = fn;};
	this.setExtFn8 = function(fn){ this.extFn8 = fn;};
	this.setExtFn9 = function(fn){ this.extFn9 = fn;};
	
	
	this.getSearchBoxId = function(){return this.id + "SearchBox"};
	this.getSearchMenuId = function(){return this.id + "SearchMenu"};
	this.getSearchBoxHtml = function(){
		
		return  '<input  class="easyui-searchbox" id="'+this.getSearchBoxId()+'"  data-options="prompt:\'请输入关键字... ...\',menu:\'#'+this.getSearchMenuId()+'\'" style="width:300px;">';
		
	}
	
	this.setShowSearchBar = function(f){this.showSearchBar = f;};
	this.getSearchMenuHtml = function(){
		return '<div id="'+this.getSearchMenuId()+'"></div>';
	}
	
	this.onDblRowClickFn = function(){};
	this.setRowClickFn = function(fn){this.onRowClickFn = fn;};
	this.setDblRowClickFn = function(fn){this.onDblRowClickFn = fn;};
	this.setUrl = function(url){ this.url = url;};
	this.setTitle = function(t){ this.title = t;};
	this.setSingleSelect = function(t){ this.singleSelect = t;};
	this.setColumns = function(c){ this.columns = c;};
	this.setToolbar = function(t) {this.toolbar = t;};
	this.getToolbar = function(){return this.toolbar};
	this.addToolbar = function(t){this.toolbar.push(t);};
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
		var _this = this;
		var tb = [];
		for (var i = 0, len = this.toolbar.length; i < len ;i ++){
			if (this.toolbar[i] == "+"){
				tb.push({text: '添加', iconCls: 'icon-add', handler:function(){
					_this.addFn();
				}});
				continue;
			}else if (this.toolbar[i] == "e"){
				tb.push({ text: '修改', iconCls: 'icon-edit', handler: function () {
					var rows = $("#" + _this.id).datagrid("getSelections");
					if (rows.length != 1){
						appAlert("有情提醒","请选择一条数据(<font color='red'>有且只能选择一条数据</font>)进行修改!",'warning');
						return ;
					}
					_this.modFn(rows[0]);
                 }});
				continue;
			}
			
			else if (this.toolbar[i] == "x"){
				tb.push({text: '删除', iconCls: 'icon-remove', handler:function(){
					var rows = $("#" + _this.id).datagrid("getSelections");
					if (rows.length == 0){
						//alert("请选中要删除的数据！");
						appAlert("有情提醒","请选中要删除的数据！" , 'warning');
					} else {
						appConfirm("有情提醒","确定要删除的"+rows.length+"条数据！" , function(){_this.delFn(rows);});
					}
				}});
				continue;
			}else {
				tb.push( this.toolbar[i]);
			}
		}
		
		/*tb.push({
            id: 'aaaa',
            text: 'bbbbb',
            iconCls: '',
            handler: function () {}
        });*/
		
		$("#" + this.id).datagrid({
			rownumbers:true,
			checkbox: !(_this.singleSelect),
			autoRowHeight:false,
			pagination:true,
			pageSize:10,
			title: _this.title,
			fit: true, //datagrid自适应宽度
			fitColumn: true, //列自适应宽度
            //striped: true, //行背景交换
			singleSelect: _this.singleSelect,
			columns: [ _this.columns ],
			toolbar: tb,
			onSortColumn: function(field, type){
				//alert("field=" + field + "; type=" + type);
				_this.cacheParams.orderField = field;
				_this.cacheParams.orderType = type;
				_this.exeQuery();
			},
			onClickRow:function(rowIndex,rowData){
			   
				//alert("row=" + rowIndex + ";name=" + rowData.realName);
				_this.onRowClickFn(rowIndex,rowData);
			},
			onDblClickRow :function(rowIndex,rowData){
				//this.setDblRowClickFn
				_this.onDblRowClickFn(rowIndex,rowData);
			  	//alert("row=" + rowIndex + ";name=" + rowData.realName);
			} 
		});
		//$("#" + this.id).datagrid("getToolbar").append($("#searchBox"));

		var p = $("#" + this.id).datagrid('getPager');//分页组件
		
		 $(p).pagination({
			 //分页条切换页面事件
			 onSelectPage:function(pageNumber, pageSize){
			 	_this.cacheParams.page = pageNumber;
				_this.cacheParams.rows = pageSize;
				_this.exeQuery();
			 }
		});
		if (this.showSearchBar){
			this.generalSearchbox();		}
		this.exeQuery();
		
	};
	
	/**
	 * 是否转到第一页，一般改变查询条件的时候要转到第１页
	 */
	this.turn2FirstPage = function(){
		
		var p = $("#" + this.id).datagrid('getPager');//分页组件
			 $(p).pagination({
                 pageNumber: 1 //查询时，让分页组件跳转到首页
             });
        this.cacheParams.page = 1;
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
			$("#" + this.id).datagrid('loadData',data);
		}    
	}
	
	/**
	 * 获取选中的数据，如果没有选中,list.length=0
	 */
	this.getSelectedData = function(){
		var list = $('#' + this.id).datagrid('getChecked');
		return list;
	}
	
	this.generalToolBar = function(){
	
	}
	
	this.generalSearchbox = function(){
		
		$("body").append("<div style='float:right;'>" + this.getSearchBoxHtml() + this.getSearchMenuHtml() + "</div>");
		
		//return ;
		
		var _this = this;
		var fields =  $('#' + this.id).datagrid('getColumnFields');
		var items = [];
		for(var i=0,len = fields.length; i< len; i++){
			var opts = $('#' + this.id).datagrid('getColumnOption', fields[i]);  
			var muit = "<div name='"+  fields[i] +"'>"+ opts.title +"</div>";
			items.push(muit);
			
		}
		//alert("ddd=" + items.join(""));
		$('#' + this.getSearchMenuId()).html(items.join(""));
		//alert("333");
		$('.searchbox ').appendTo('.datagrid-toolbar');
		$('#' +this.getSearchBoxId()).appendTo('.datagrid-toolbar');
		$('#' + this.getSearchBoxId()).searchbox({  
			menu:'#' + _this.getSearchMenuId(),
			searcher: function(value,name){
		    	var qp = {};
		    	qp[name] = value;
		    	//alert("name=" + name + ";value=" + value);
		    	_this.setQueryParams(qp);
		    	
		    	_this.exeQuery(true);
		    }
		});  
	}
};
