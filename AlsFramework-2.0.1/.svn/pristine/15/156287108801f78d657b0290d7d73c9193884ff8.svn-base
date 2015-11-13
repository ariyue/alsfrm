$.extend($.fn.validatebox.defaults.rules,{
	userName : {// 验证用户名
		validator : function(value) {
			return /^[a-zA-Z][a-zA-Z0-9_]{0,49}$/i.test(value);
		},
		message : '用户名不合法（字母开头，允许1-50字节，允许字母数字下划线）'
	},
	loginName : {//登陆名验证
		validator : function(value, param) {
			return /^[\u0391-\uFFE5\w]+$/.test(value);
		},
		message : '登录名称只允许汉字、英文字母、数字及下划线。'
	},
	safePassword: {//密码安全验证
        validator: function (value, param) {
            return euiExValidate.safePassword(value);
        },
        message: '密码由字母和数字组成，至少6位'
    },
    idcard: {//身份证验证
        validator: function (value, param) {
            return euiExValidate.idCard(value);
        },
        message:'请输入正确的身份证号码'
    },
    mobile : {
		validator : function(value, param) {
			return /^(?:13\d|15\d|18\d)-?\d{5}(\d{3}|\*{3})$/
					.test(value);
		},
		message : '手机号码不正确'
	},
	phone : {
		validator : function(value, param) {
			return /^(\d{3}-|\d{4}-)?(\d{8}|\d{7})?(-\d{1,6})?$/
					.test(value);
		},
		message : '电话号码不正确,格式为:区号-固定电话号'
	},
	mobileAndPhone : {
		validator : function(value, param) {
			return /(^([0\+]\d{2,3})\d{3,4}\-\d{3,8}$)|(^([0\+]\d{2,3})\d{3,4}\d{3,8}$)|(^([0\+]\d{2,3}){0,1}13\d{9}$)|(^\d{3,4}\d{3,8}$)|(^\d{3,4}\-\d{3,8}$)/
					.test(value);
		},
		message : '请正确输入电话号码'
	},
	integer : {//正整数1,2,3..............
		validator : function(value, param) {
			return /^[+]?[1-9]\d*$/.test(value);
		},
		message : '请输入最小为1的整数（正整数）'
	},
	zeroAndInteger : {//0和正整数
		validator : function(value, param) {
			return /^(0|[1-9]\d*)$/.test(value);
		},
		message : '请输入0或正整数'
	},
	
	money : {
		validator : function(value, param) {
			return (/^(([1-9]\d*)|\d)(\.\d{1,4})?$/)
					.test(value);
		},
		message : '请输入正确的金额'

	},
	email : {
		validator : function(value, param) {
			return (/^(\w)+(\.\w+)*@(\w)+((\.\w{2,3}){1,3})$/)
					.test(value);
		},
		message : '请输入正确的邮件地址'

	},
	
	
	
	
	number : {
		validator : function(value, param) {
			return /^[0-9]+.?[0-9]*$/.test(value);
		},
		message : '请输入数字'
	},
	
	
	CHS : {
		validator : function(value, param) {
			return /^[\u0391-\uFFE5]+$/.test(value);
		},
		message : '请输入汉字'
	},
	english : {// 验证英语
		validator : function(value) {
			return /^[A-Za-z]+$/i.test(value);
		},
		message : '请输入英文'
	},
	ip : {// 验证IP地址
		validator : function(value) {
			return /\d+\.\d+\.\d+\.\d+/.test(value);
		},
		message : 'IP地址格式不正确'
	},
	ZIP : {
		validator : function(value, param) {
			return /^[0-9]\d{5}$/.test(value);
		},
		message : '邮政编码不存在'
	},
	QQ : {
		validator : function(value, param) {
			return /^[1-9]\d{4,10}$/.test(value);
		},
		message : 'QQ号码不正确'
	},
	mone : {
		validator : function(value, param) {
			return (/^(([1-9]\d*)|\d)(\.\d{1,2})?$/)
					.test(value);
		},
		message : '请输入整数或小数'
	},
	
	range : {
		validator : function(value, param) {
			if (/^[1-9]\d*$/.test(value)) {
				return value >= param[0] && value <= param[1]
			} else {
				return false;
			}
		},
		message : '输入的数字在{0}到{1}之间'
	},
	minLength : {
		validator : function(value, param) {
			return value.length >= param[0]
		},
		message : '至少输入{0}个字'
	},
	maxLength : {
		validator : function(value, param) {
			return value.length <= param[0]
		},
		message : '最多{0}个字'
	},
	// select即选择框的验证
	selectValid : {
		validator : function(value, param) {
			if (value == param[0]) {
				return false;
			} else {
				return true;
			}
		},
		message : '请选择'
	},
	idCode : {
		validator : function(value, param) {
			return /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/
					.test(value);
		},
		message : '请输入正确的身份证号'
	},
	
	equalTo : {
		validator : function(value, param) {
			return value == $(param[0]).val();
		},
		message : '两次输入的字符不一至'
	},
	
	xiaoshu : {
		validator : function(value) {
			return /^(([1-9]+)|([0-9]+\.[0-9]{1,2}))$/
					.test(value);
		},
		message : '最多保留两位小数！'
	},
	ddPrice : {
		validator : function(value, param) {
			if (/^[1-9]\d*$/.test(value)) {
				return value >= param[0] && value <= param[1];
			} else {
				return false;
			}
		},
		message : '请输入1到100之间正整数'
	},
	jretailUpperLimit : {
		validator : function(value, param) {
			if (/^[0-9]+([.]{1}[0-9]{1,2})?$/.test(value)) {
				return parseFloat(value) > parseFloat(param[0])
						&& parseFloat(value) <= parseFloat(param[1]);
			} else {
				return false;
			}
		},
		message : '请输入0到100之间的最多俩位小数的数字'
	},
	rateCheck : {
		validator : function(value, param) {
			if (/^[0-9]+([.]{1}[0-9]{1,2})?$/.test(value)) {
				return parseFloat(value) > parseFloat(param[0])
						&& parseFloat(value) <= parseFloat(param[1]);
			} else {
				return false;
			}
		},
		message : '请输入0到1000之间的最多俩位小数的数字'
	}
});

//以下为自定义的验证------------------------------------------------------------------------------------------------
var euiExValidate = {
		
		/* 密码由字母和数字组成，至少6位 */
		safePassword : function (value) {
		    return !(/^(([A-Z]*|[a-z]*|\d*|[-_\~!@#\$%\^&\*\.\(\)\[\]\{\}<>\?\\\/\'\"]*)|.{0,5})$|\s/.test(value));
		},
		
		/* 身份证验证 */
		idCard : function (value) {
		    if (value.length == 18 && 18 != value.length) return false;
		    var number = value.toLowerCase();
		    var d, sum = 0, v = '10x98765432', w = [7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2], a = '11,12,13,14,15,21,22,23,31,32,33,34,35,36,37,41,42,43,44,45,46,50,51,52,53,54,61,62,63,64,65,71,81,82,91';
		    var re = number.match(/^(\d{2})\d{4}(((\d{2})(\d{2})(\d{2})(\d{3}))|((\d{4})(\d{2})(\d{2})(\d{3}[x\d])))$/);
		    if (re == null || a.indexOf(re[1]) < 0) return false;
		    if (re[2].length == 9) {
		        number = number.substr(0, 6) + '19' + number.substr(6);
		        d = ['19' + re[4], re[5], re[6]].join('-');
		    } else d = [re[9], re[10], re[11]].join('-');
		    if (!euiExValidate.isDateTime.call(d, 'yyyy-MM-dd')) return false;
		    for (var i = 0; i < 17; i++) sum += number.charAt(i) * w[i];
		    return (re[2].length == 9 || number.charAt(17) == v.charAt(sum % 11));
		},
		isDateTime : function (format, reObj) {
		    format = format || 'yyyy-MM-dd';
		    var input = this, o = {}, d = new Date();
		    var f1 = format.split(/[^a-z]+/gi), f2 = input.split(/\D+/g), f3 = format.split(/[a-z]+/gi), f4 = input.split(/\d+/g);
		    var len = f1.length, len1 = f3.length;
		    if (len != f2.length || len1 != f4.length) return false;
		    for (var i = 0; i < len1; i++) if (f3[i] != f4[i]) return false;
		    for (var i = 0; i < len; i++) o[f1[i]] = f2[i];
		    o.yyyy = s(o.yyyy, o.yy, d.getFullYear(), 9999, 4);
		    o.MM = s(o.MM, o.M, d.getMonth() + 1, 12);
		    o.dd = s(o.dd, o.d, d.getDate(), 31);
		    o.hh = s(o.hh, o.h, d.getHours(), 24);
		    o.mm = s(o.mm, o.m, d.getMinutes());
		    o.ss = s(o.ss, o.s, d.getSeconds());
		    o.ms = s(o.ms, o.ms, d.getMilliseconds(), 999, 3);
		    if (o.yyyy + o.MM + o.dd + o.hh + o.mm + o.ss + o.ms < 0) return false;
		    if (o.yyyy < 100) o.yyyy += (o.yyyy > 30 ? 1900 : 2000);
		    d = new Date(o.yyyy, o.MM - 1, o.dd, o.hh, o.mm, o.ss, o.ms);
		    var reVal = d.getFullYear() == o.yyyy && d.getMonth() + 1 == o.MM && d.getDate() == o.dd && d.getHours() == o.hh && d.getMinutes() == o.mm && d.getSeconds() == o.ss && d.getMilliseconds() == o.ms;
		    return reVal && reObj ? d : reVal;
		    function s(s1, s2, s3, s4, s5) {
		        s4 = s4 || 60, s5 = s5 || 2;
		        var reVal = s3;
		        if (s1 != undefined && s1 != '' || !isNaN(s1)) reVal = s1 * 1;
		        if (s2 != undefined && s2 != '' && !isNaN(s2)) reVal = s2 * 1;
		        return (reVal == s1 && s1.length != s5 || reVal > s4) ? -10000 : reVal;
		    }
		}
}
//以下为自定义的验证 end------------------------------------------------------------------------------------------------