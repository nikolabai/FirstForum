var username_empty = "<span style='COLOR:#ff0000'>  × 用户名不能为空!</span>";  
var username_shorter = "<span style='COLOR:#ff0000'> × 用户名长度不能少于 3 个字符!</span>";  
var username_longer = "<span style='COLOR:#ff0000'> × 用户名长度不能大于 10个字符!</span>";  
var username_invalid = "-用户名只能由字母数字以及下划线组成!";  
var username_have_register = "<span style='COLOR:#ff0000'> × 用户名不存在</span>";  
var password_empty = "<span style='COLOR:#ff0000'> × 登录密码不能为空</span>";  
var password_shorter = "<span style='COLOR:#ff0000'> × 登录密码不能少于 6 个字符</span>";  
var password_longer = "<span style='COLOR:#ff0000'> × 登录密码不能多于 16 个字符</span>";  
var password_invalid = "<span style='COLOR:#ff0000'> × 密码只能是数字和英文</span>"; 
var password_can_register="<span style='COLOR:#006600'> √ </span>";  

/*
 * 测试
 */
function upperCase()
{
	var x=document.getElementById("userName").value
	document.getElementById("userName").value=x.toUpperCase()
}
/*
 * 用户名检测
 */
function check(){
	var name = document.getElementById("userName").value
	document.getElementById("userName").value=name.toUpperCase()
	if(name == "" || name == null){
		alert("用户名不能为空")
	}
}


function checkUserName(obj) {
	
	if (checks(obj.value) == false) {
		showInfo("username_notice", username_invalid);
	} else if (obj.value.length < 1) {
		showInfo("username_notice", username_empty);
	}else if (obj.value.length < 3) {
		showInfo("username_notice", username_shorter);
	} else if(obj.value.length>10){
		showInfo("username_notice", username_longer);
    }else {   	
		// 调用Ajax函数,向服务器端发送查询
        $.ajax({ //一个Ajax过程
    		type: "post",             //以post方式与后台沟通
    		url :"/FirstForum/checkUserName.do", //与此页面沟通
//    		contentType: "application/json;charset=utf-8", //必须有
    		dataType:"json",          //返回的值以 JSON方式 解释
    		data:'userName='+obj.value, //发给的数据
    		success: function(json){//如果调用成功
    			if(json.flag){
    				showInfo("username_notice", username_have_register);
    			}else {
    				showInfo("username_notice", username_can_register);
    				return;
    			}
    		} 
    });	
	}
}  
/*
 * 用户名检测是否包含非法字符
 */
function checks(t) {
	szMsg = "[# %&\'\"\\,;:=!^@/]"
	for (i = 1; i < szMsg.length + 1; i++) {
		if (t.indexOf(szMsg.substring(i - 1, i)) > -1) {
			return false;
		}
	}
	return true;
}
/**
 * 验证密码
 */
function checkPassword(obj) {
	
	if (checks(obj.value) == false) {
		showInfo("password_notice", password_invalid);
	} else if (obj.value.length < 1) {
		showInfo("password_notice", password_empty);
	}else if (obj.value.length < 3) {
		showInfo("password_notice", password_shorter);
	} else if(obj.value.length>10){
		showInfo("password_notice", password_longer);
    }else {   	
    	showInfo("password_notice", password_can_register);
    }	
}  
/* 
 * 公用程序 
 */    
function showInfo(target,Infos){    
document.getElementById(target).innerHTML = Infos;    
}    
function showclass(target,Infos){    
document.getElementById(target).className = Infos;    
}      
