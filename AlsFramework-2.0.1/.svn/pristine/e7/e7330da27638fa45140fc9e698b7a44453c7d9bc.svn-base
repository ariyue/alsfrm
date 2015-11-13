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
	this.toolbar = ""; //格式如："+,icon-add,添加;x,icon-remove,删除;e,icon-edit,修改;|,,;1,icon-your-icon,自定义按钮"
	this.onRowClickFn = function(){};
	this.onBeforeLoadFn = function(){};
	this.onLoadSuccessFn = function(){};
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
	this.setOnBeforeLoadFn = function(fn){this.onBeforeLoadFn = fn;};
	this.setOnLoadSuccessFn = function(fn){this.onLoadSuccessFn = fn;}
	this.setDblRowClickFn = function(fn){this.onDblRowClickFn = fn;};
	this.setUrl = function(url){ this.url = url;};
	this.setTitle = function(t){ this.title = t;};
	this.setSingleSelect = function(t){ this.singleSelect = t;};
	this.setColumns = function(c){ this.columns = c;};
	this.setToolbar = function(t) {this.toolbar = t;};
	this.getToolbar = function(){return this.toolbar};
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
		var btnList = this.toolbar.split(";");     
		for (var i = 0, len = btnList.length; i < len; i ++ ){
			var item = btnList[i];
			var btnPropertys = item.split(",");
			if (btnPropertys[0] == "+"){
				tb.push({text: btnPropertys[2], iconCls: btnPropertys[1], handler:function(){
					_this.addFn();
				}});
				continue;
			} else if (btnPropertys[0] == "e"){
				tb.push({ text: btnPropertys[2], iconCls: btnPropertys[1], handler: function () {
					var rows = $("#" + _this.id).datagrid("getSelections");
					if (rows.length != 1){
						appAlert("有情提醒","请选择一条数据(<font color='red'>有且只能选择一条数据</font>)进行修改!",'warning');
						return ;
					}
					_this.modFn(rows[0]);
                 }});
				continue;
			} else if(btnPropertys[0] == "|"){
				tb.push("-");
				continue;
			} else if (btnPropertys[0] == "x"){
				tb.push({text: btnPropertys[2], iconCls: btnPropertys[1], handler:function(){
					var rows = $("#" + _this.id).datagrid("getSelections");
					if (rows.length == 0){
						//alert("请选中要删除的数据！");
						appAlert("有情提醒","请选中要删除的数据！" , 'warning');
					} else {
						appConfirm("有情提醒","确定要删除的"+rows.length+"条数据！" , function(){_this.delFn(rows);});
					}
				}});
				continue;
			}else if (btnPropertys[0] == "1"){
				tb.push({text: btnPropertys[2], iconCls: btnPropertys[1], handler:function(){
					var rows = $("#" + _this.id).datagrid("getSelections");
					_this.extFn1(rows);
				}});
				continue;
			}else if (btnPropertys[0] == "2"){
				tb.push({text: btnPropertys[2], iconCls: btnPropertys[1], handler:function(){
					var rows = $("#" + _this.id).datagrid("getSelections");
					_this.extFn2(rows);
				}});
				continue;
			}else if (btnPropertys[0] == "3"){
				tb.push({text: btnPropertys[2], iconCls: btnPropertys[1], handler:function(){
					var rows = $("#" + _this.id).datagrid("getSelections");
					_this.extFn3(rows);
				}});
				continue;
			}else if (btnPropertys[0] == "4"){
				tb.push({text: btnPropertys[2], iconCls: btnPropertys[1], handler:function(){
					var rows = $("#" + _this.id).datagrid("getSelections");
					_this.extFn4(rows);
				}});
				continue;
			}else if (btnPropertys[0] == "5"){
				tb.push({text: btnPropertys[2], iconCls: btnPropertys[1], handler:function(){
					var rows = $("#" + _this.id).datagrid("getSelections");
					_this.extFn5(rows);
				}});
				continue;
			}else if (btnPropertys[0] == "6"){
				tb.push({text: btnPropertys[2], iconCls: btnPropertys[1], handler:function(){
					var rows = $("#" + _this.id).datagrid("getSelections");
					_this.extFn6(rows);
				}});
				continue;
			}else if (btnPropertys[0] == "7"){
				tb.push({text: btnPropertys[2], iconCls: btnPropertys[1], handler:function(){
					var rows = $("#" + _this.id).datagrid("getSelections");
					_this.extFn7(rows);
				}});
				continue;
			}else if (btnPropertys[0] == "8"){
				tb.push({text: btnPropertys[2], iconCls: btnPropertys[1], handler:function(){
					var rows = $("#" + _this.id).datagrid("getSelections");
					_this.extFn8(rows);
				}});
				continue;
			}else if (btnPropertys[0] == "9"){
				tb.push({text: btnPropertys[2], iconCls: btnPropertys[1], handler:function(){
					var rows = $("#" + _this.id).datagrid("getSelections");
					_this.extFn9(rows);
				}});
				continue;
			}
		}
		
		
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
			},
			onBeforeLoad: function(param){
				//_this.onBeforeLoadFn(param);//不用grid原有的
				//使用自定义的
				_this.onBeforeLoadFn(_this.queryParams);
			},
			onLoadSuccess: function(data){
				_this.onLoadSuccessFn(data);
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
		
		var _this = this;
		if (turn2FirstPageFlag != null && turn2FirstPageFlag != undefined && turn2FirstPageFlag){
			this.turn2FirstPage();
		}
		
		this.queryCmd.setUrl(this.url);
		var params = this.getQueryParams();
		this.queryCmd.setParam(params);
		this.queryCmd.execute();
		if (this.queryCmd.commandSuccess){
			var result = this.queryCmd.getResult();
			_this.loadPageData(result);
		}    
	}
	
	/**
	 * 加载数据
	 */
	this.loadPageData = function(pageData){
		if (pageData != null){
			var data = {"total":pageData.total,"rows":pageData.dataList};
			$("#" + this.id).datagrid('loadData',data);
		}
		
		//$("#" + this.id).datagrid('checkRow',0);
		/*
		$("#" + this.id).datagrid({onLoadSuccess : function(data){
		    $("#" + this.id).datagrid('selectRow',1);
		}});
		*/
	}
	
	/**
	 * 默认中选行
	 * @param num 行号， 行索引从0开始
	 */
	this.defaultSelectRow = function(num){
		 $("#" + this.id).datagrid('selectRow',num);
	}
	
	/**
	 * 获取选中的数据，如果没有选中,list.length=0
	 */
	this.getCheckedData = function(){
		var list = $('#' + this.id).datagrid('getChecked');
		return list;
	}
	
	this.generalToolBar = function(){
	
	}
	
	this.generalSearchbox = function(){
				
		var _this = this;
		var seachboxHolderId = this.getSearchBoxId() + "HD";
		$("body").append("<div id="+seachboxHolderId+" >" + this.getSearchBoxHtml() + this.getSearchMenuHtml() + "</div>");
		
		//循环列名，生成搜索的下拉列表
		var fields = $('#' + this.id).datagrid('getColumnFields');
		var items = [];
		for(var i=0,len = fields.length; i< len; i++){
			var opts = $('#' + this.id).datagrid('getColumnOption', fields[i]); 
			if (opts.hidden == null || opts.hidden != "true"){
				var muit = "<div name='"+  fields[i] +"'>"+ opts.title +"</div>";
				items.push(muit);
			}
		}
		$('#' + this.getSearchMenuId()).html(items.join(""));
		$('#' + this.getSearchBoxId()).searchbox({  
			menu:'#' + this.getSearchMenuId(),
			searcher: function(value,name){
		    	var qp = {};
		    	qp.searchboxKey = name;//查询的字段
		    	qp.searchboxVal = value;//查询的字段值
		    	//qp[name] = value;//20150806
		    	//alert("name=" + name + ";value=" + value);
		    	_this.setQueryParams(qp);
		    	
		    	_this.exeQuery(true);
		    }
			
		});
		
		//获取生成的搜索框
		var a=$("#" + seachboxHolderId);
		//将生成好的搜索框放入工具栏
		//$("#"+this.id).find(".datagrid-toolbar").append(a);
		$("#" + this.id).datagrid("getPanel").find(".datagrid-toolbar").append(a);	
	}
	
	/**
	 * 获取选中数据列表
	 */
	this.getSelectedData = function(){
		
		return $("#" + this.id).datagrid("getSelections");
	}
	
	this.appendRow = function(rowData){
		 $("#" + this.id).datagrid('appendRow',rowData);
		 var rows =  $("#" + this.id).datagrid("getRows");
		 this.defaultSelectRow(rows.length - 1);
	}
};
