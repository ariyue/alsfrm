/**
 单选框组
 基于自定义的easyui组件jquery.radio.js进行制作
 */

/*
语法检查：http://www.itlearner.com/code/jslint/
YUI压缩：http://yui.2clics.net/
数字压缩:http://www.wxwdesign.cn/down/script_packer/packer_cn.php
*/
AliceJS.ChkGrp = function (id){
	
	//继承自AliceJS.Text-(2.1)--------------------------------------------------------------
    AliceJS.Combo.call(this, id); //call(this,父参数1,父参数2,.....,父参数n)
	//继承自AliceJS.Text end ---------------------------------------------------------------
    
    this.nameField = "code"; //<input name="值" />
    this.setNameField = function(p){ this.nameField = p;};
    this.itemClickFn = function(){};
    this.setItemClickFn = function(p){this.itemClickFn = p;};
    //获取选中的值
	this.getVals = function(){
		var list = $("#" + this.id).checkbox("getValue");
		var leen = list.length;
		if (leen == 0){
			return "";
		}
	
		var r = "";
		
		for(var i = 0; i < leen; i++){
			r += list[i].value + this.separator;
		}
		return r.substring(0,r.length - 1);
	};
	//获取选中的文本
	this.getTexts= function(){
		var list = $("#" + this.id).checkbox("getValue");
		var leen = list.length;
		if (leen == 0){
			return "";
		}
	
		var r = "";
		
		for(var i = 0; i < leen; i++){
			r += list[i].text + this.separator;
		}
		return r.substring(0,r.length - 1);
	}
	
	
    
    this.init = function(){
    	this.loadData();
	};
	
	/**
	 * 加载数据
	 */
	this.loadData = function(){
		var _this = this;
		var data = this.getData();
		//alert(5555)
		$('#'+ this.id).addClass("easyui-checkbox");
		if (data != null){
			$('#'+ this.id).empty();
			for (var i =0, len = data.length; i < len; i++){
				if (this._isDefaultChecked(data[i])){
					$('#'+ this.id).append('<input type="checkbox" name="'+data[i][this.nameField]+'" value="'+data[i][this.valField]+'" checked  label="'+data[i][this.textField]+'"></input>');
				} else {
					$('#'+ this.id).append('<input type="checkbox" name="'+data[i][this.nameField]+'" value="'+data[i][this.valField]+'"  label="'+data[i][this.textField]+'"></input>');
				}
			}
			//alert(5555)
			$('#'+ this.id).checkbox({
				onItemClick: function(checked, code, text){
					_this.itemClickFn(checked, code, text);
				}
			});
			//$.parser.parse('#' + this.id);
			//alert(333)
		}
		
		//$.parser.parse('#' + this.id);
	}
	
	this._isDefaultChecked = function(item){
		
		var df = this.vals + this.separator;
		if (df.indexOf(item[this.valField]) > -1){
			return true;
		}
		return false;
	}
    
};

//继承自AliceJS.Text-(2.2)--------------------------------------------------------------
AliceJS.ChkGrp.prototype = new AliceJS.Combo();
//继承自AliceJS.Text end ----------------------------------------------------------
