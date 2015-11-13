/**
 * TimeText 时间框
 *  
 * 
 */
AliceJS.TimeText = function (id){
	
	this.cacheParams = {
		text:"",
		value: ""
	};
	this.id= id;//html中input控件的id
	this.width="280px";
	this.height=28;
	
	this.val = "00:00:00";//当前值，默认值
	
	//setters---
	this.setWidth=function(p){this.width=p;};
	this.setHeight=function(p){this.height=p;};
	
	//会将数据库的8位的日期自动转为yyyy-MM-dd
	this.setVal = this.setValue = function(p){

		if (p!= null && p.replace(/ /g,'') != "" ){
			var dt = p.replace(/ /g,'').replace(/:/g,'');
			if (dt.length == 6){
				var y = dt.substr(0,2);
				var m = dt.substr(4,2);
				var d = dt.substr(4,2);
				this.val = y +":"+m+":" +d;
				try{
					$('#' + this.id).timespinner('setValue',this.val);
				} catch(e){}
			}
		}else {
			this.val = "00:00:00";
			//alert(6677);
			try{
				$('#' + this.id).timespinner('setValue',this.val );
			} catch(e){}
		}
	};
	
	
	
	
	//获取选中的值
	this.getVal = this.getValue = function(){
		var p = $('#' + this.id).timespinner('getValue');
		var dt = p.replace(/ /g,'').replace(/:/g,'');
		return dt;
	};

	
	//setters---
	
	//如果含有按钮时，按钮的单击事件

	
	this.init = function(){
		
		var _this = this;
		$('#' + _this.id).timespinner({    
			    value: _this.val,
			    showSeconds: true,
			    width:_this.width
			}); 
		 
	};
	
	
	
};
