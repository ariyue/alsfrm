

var AliceJS = $$ = {};


/**
 * @param formFlag 表单提交标识
 * @param  asyncFlag 异步执行标识
 * @param callBaackFn 异步返回时执行的方法
 */
AliceJS.Command = function(formFlag, asyncFlag, callBaackFn){
	
	this.url = "";
	this.param = {};
	
	/**
	 * 是否采用表单进行的提交，默为为false，表示采用JSON的param的提交
	 */
	this.formFlag = formFlag || false;
	/**
	 * 异步标识，　true时采用异步
	 */
	this.asyncFlag = asyncFlag || false;
	this.setAsyncFlag = function(f){this.asyncFlag = f;};
	this.getAsyncFlag = function(){ return this.asyncFlag;};
	
	/**
	 * 成功返回，即后台没有返回异常
	 */
	this.commandSuccess = true;
	this.setUrl = function(url){this.url = url;};
	this.getUrl = function(){return this.url;};
	this.setParam = function(param){this.param = param;};
	this.getParam = function(){return this.param;};
	this.callBackFn = callBaackFn || function(){};
	this.setCallBackFn = function(fn){this.callBackFn = fn;};
	this.getCallBackFn = function(){return this.callBackFn;};
	
	this.result;
	this.setResult = function(r){this.result = r;};
	this.getResult = function(){ return this.result;};
	
	this.execute = function(){
		//top.$.messager.progress(); 	
		var _this = this;
		var contentType;
		var data;
		if (_this.formFlag){
			contentType = "application/x-www-form-urlencoded; charset=UTF-8";
			data = $.param( $('#myform').serializeArray(), true);
		} else {
			contentType = "application/json;charset=UTF-8";
			//alert(8899);
			//data = $.toJSON(this.param);
			//data = $.toJSON(this.param);
			data = $.param(this.param, true);
			//alert(4455);
			//alert("tojson="+data);
		}
		
		$.ajax({
	       url:this.url, //后台处理程序
	       type:'POST',         //数据发送方式
	       datatype:"json",
          // contentType: contentType,
	       data: data,         //要传递的数据
	       async: _this.asyncFlag,
	       success:function(result) {
	       		var ajaxResultVO = result.resultData;
	       		
	       		//alert("ajaxResultVO.msg=" + ajaxResultVO.msg);
	       		if (ajaxResultVO.rstType == "msgWin"){
	       			appAlert("", ajaxResultVO.result.msg, ajaxResultVO.result.winType);
	       			_this.commandSuccess = false;
	       			return;
	       		}
	       		
	       		// TODO 重定向
	       		if (ajaxResultVO.rstType == "redirect"){
	       			var url = ajaxResultVO.result.url;
	       			var params = ajaxResultVO.result.params;
	       			alert("url=" + url);
	       			//alert("params=" + params );
	       			window.location.href = url + "?" + params; 
	       			//top.loadTab("abcccc", url + "?" + params);
	       			return;
	       		}
	       		
	       		// TODO 重定向
	       		if (ajaxResultVO.rstType == "tab"){
	       			var url = ajaxResultVO.result.url;
	       			var title = ajaxResultVO.result.title;
	       			var params = ajaxResultVO.result.params;
	       			//alert("url=" + url);
	       			//alert("params=" + params );
	       			//window.location.href=url + "?" + params; 
	       			top.loadTab(title, url + "?" + params);
	       			return;
	       		}
	       		appMsg("操作结果", "操作成功!");
	       		//top.$.messager.progress('close');
	       		_this.setResult(ajaxResultVO.result);
	       		if (_this.asyncFlag){
	       			
	       			_this.getCallBackFn()(ajaxResultVO.result);
	       		}
	       		
	       },
	       error:function(request, textStatus, err){
	    	   
	    	   if ( textStatus == "parsererror" || request.status == "403"){
	    		   var msg = request.responseText;
	    		   try {
	    			   eval(msg); 
	    		   }catch(e){
	    			   alert("没有捕获的错误:" + err);
	    		   }
	    		   
	    	   } else {
	    		   alert("没有捕获的错误:" + err);
	    	   }
	       		//
	       }
	     });
	}
};