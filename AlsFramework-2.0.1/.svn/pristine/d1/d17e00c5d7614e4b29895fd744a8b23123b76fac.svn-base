/**
 * DateText 日期框
 *  
 * 
 */
AliceJS.DateText = function (id){
	
	this.cacheParams = {
		text:"",
		value: ""
	};
	this.id= id;//html中input控件的id
	this.width="280px";
	this.height=28;
	this.readOnly=false;
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
	/**
	 * 日期格式化
	 */
	this.myformatter = function(date){
	  var y = date.getFullYear();
	  var m = date.getMonth()+1;
	  var d = date.getDate();
	  return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
	 }
	 
	this.val = this.myformatter(new Date());//当前值，默认值
	
	//setters---
	this.setWidth=function(p){this.width=p;};
	this.setHeight=function(p){this.height=p;};
	
	//会将数据库的8位的日期自动转为yyyy-MM-dd
	this.setVal = this.setValue = function(p){

		if (p!= null){
			var dt = p.replace(/ /g,'').replace(/-/g,'').replace(/\//g,'');
			if (dt.length == 8){
				var y = dt.substr(0,4);
				var m = dt.substr(4,2);
				var d = dt.substr(6,2);
				this.val = y +"-"+m+"-" +d;
				try{
					$('#' + this.id).datebox('setValue',this.val);
				} catch(e){}
			}
		}else {
			this.val = "";
			try{
				$('#' + this.id).datebox('setValue',"");
			} catch(e){}
		}
	};
	//获取选中的值,自动将yyyy-MM-dd格式的值转为数据库的8位日期
	this.getVal = this.getValue =  function(){
		var p = $('#' + this.id).datebox('getValue');
		var dt = p.replace(/ /g,'').replace(/-/g,'').replace(/\//g,'');
		return dt;
	};

	
	//setters---
	
	//如果含有按钮时，按钮的单击事件

	
	this.init = function(){
		
		var _this = this;
		
		$('#' + this.id).datebox({    
		    value: _this.val,
		    width:this.width
		}); 
		 
	};
	
	
	
};
