/**
 单选框组
 基于自定义的easyui组件jquery.radio.js进行制作
 */

/*
语法检查：http://www.itlearner.com/code/jslint/
YUI压缩：http://yui.2clics.net/
数字压缩:http://www.wxwdesign.cn/down/script_packer/packer_cn.php
*/
AliceJS.RdoGrp = function (id){
	
	//继承自AliceJS.Text-(2.1)--------------------------------------------------------------
    AliceJS.Combo.call(this, id); //call(this,父参数1,父参数2,.....,父参数n)
	//继承自AliceJS.Text end ---------------------------------------------------------------
    
    this.label = "";//输入框前面的文本label标签
	this.labelClass=""//文本label的样式
	this.setLabel = function(p){this.label = p;};
	this.setLabelClass = function(p){this.labelClass = p;};	
	
	
    this.nameField = "code"; //<input name="值" />
    this.setNameField = function(p){ this.nameField = p;};
    this.itemClickFn = function(){};
    this.setItemClickFn = function(p){this.itemClickFn = p;};
    //获取选中的值
	this.getVal = function(){
		return $("#" + this.id).radio("getValue").value;
	};
	//获取选中的文本
	this.getText= function(){
		return $("#" + this.id).radio("getValue").text;
	}
    
    this.init = function(){
		//alert("this=" + this.id);
		var _this = this;
		if (this.conName == ""){
			alert("请输入常量名");
			return;
		}
		var data = this.getData();
		
		if(this.label != null && this.label != ""){
			$('#'+ this.id).before('<label class="'+ this.labelClass+'">'+ this.label+'</label>');
		}
		$('#'+ this.id).addClass("easyui-radio");
		for (var i =0, len = data.length; i < len; i++){
			if (data[i][this.valField] == this.val){
				$('#'+ this.id).append('<input type="radio" name="'+data[i][this.nameField]+'" value="'+data[i][this.valField]+'" checked  label="'+data[i][this.textField]+'"></input>');
			} else {
				$('#'+ this.id).append('<input type="radio" name="'+data[i][this.nameField]+'" value="'+data[i][this.valField]+'"  label="'+data[i][this.textField]+'"></input>');
			}
		}
		
		$('#'+ this.id).radio({
				onItemClick: function(checked, code, text){
				_this.itemClickFn(checked, code, text);
			}
		});
		
	};
    
};

//继承自AliceJS.Text-(2.2)--------------------------------------------------------------
AliceJS.RdoGrp.prototype = new AliceJS.Combo();
//继承自AliceJS.Text end ----------------------------------------------------------
