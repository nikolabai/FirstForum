var process_request = "<img src='loading.gif' width='16' height='16' border='0' align='absmiddle'>正在数据处理中...";  
var username_empty = "<span style='COLOR:#ff0000'>  × 用户名不能为空!</span>";  
var username_shorter = "<span style='COLOR:#ff0000'> × 用户名长度不能少于 3 个字符。</span>";  
var username_longer = "<span style='COLOR:#ff0000'> × 用户名长度不能大于 30个字符。</span>";  
var username_invalid = "- 用户名只能是由字母数字以及下划线组成。";  
var username_have_register = "<span style='COLOR:#ff0000'> × 用户名已经存在,请重新输入!</span>";  
var username_can_register="<span style='COLOR:#006600'> √ 恭喜您！该用户名可以注册!</span>";  
var password_empty = "<span style='COLOR:#ff0000'> × 登录密码不能为空。</span>";  
var password_shorter_s = "<span style='COLOR:#ff0000'> × 登录密码不能少于 6 个字符。</span>";  
var password_shorter_m = "<span style='COLOR:#ff0000'> × 登录密码不能多于 30 个字符。</span>";  
var confirm_password_invalid = "<span style='COLOR:#ff0000'> × 两次输入密码不一致!</span>";  
var email_empty = "<span style='COLOR:#ff0000'> × 邮箱不能为空！</span>";  
var email_invalid = "<span style='COLOR:#ff0000'> × 邮箱格式出错！</span>";  
var email_have_register = "<span style='COLOR:#ff0000'> × 该邮箱已被注册！ </span>";  
var email_can_register = "<span style='COLOR:#006600'> √ 邮箱可以注册!</span>";  
var agreement_no = "<span style='COLOR:#ff0000'> × 您没有接受协议</span>";  
var agreement_yes= "<span style='COLOR:#006600'> √ 已经接受协议</span>";  
var info_can="<span style='COLOR:#006600'> √ 可以注册!</span>";  
var info_right="<span style='COLOR:#006600'> √ 填写正确!</span>"; 
var name_flag=false;
var email_flag=false;
var password_flag=false;
var accept_flag=false;

$(function(){
	change_submit();	
	if(document.getElementById("agreement").checked){
	    alert("checkbox is checked");
	}
}); 

/*
 * 获取工程的路径
 */
function getRootPath() {
	var pathName = window.location.pathname.substring(1);
	var webName = pathName == '' ? '' : pathName.substring(0, pathName
			.indexOf('/'));
	return window.location.protocol + '//' + window.location.host + '/'
			+ webName + '/';
}
/*
 * 用户名检测
 */
function checkUserName(obj) {
	if (checks(obj.value) == false) {
		showInfo("username_notice", username_invalid);
	} else if (obj.value.length < 1) {
		showInfo("username_notice", username_empty);
	}else if (obj.value.length < 3) {
		showInfo("username_notice", username_shorter);
	} else if(obj.value.length>30){
		showInfo("username_notice", username_longer);
    }else {   	
		// 调用Ajax函数,向服务器端发送查询
        $.ajax({ //一个Ajax过程
    		type: "post", //以post方式与后台沟通
    		url :"/checkUserName.do", //与此页面沟通
    		dataType:'json',//返回的值以 JSON方式 解释
    		data: 'userName='+obj.value, //发给的数据
    		success: function(json){//如果调用成功
    			if(json.flag){
    				showInfo("username_notice", username_have_register);
    			}else {
    				showInfo("username_notice", username_can_register);
    				name_flag=true;
    				change_submit();
    				return;
    			}
    		} 	
    });	
	}
	name_flag=false;
	change_submit();
}  
/*
 * 用户名检测是否包含非法字符
 */
function checks(t) {
	szMsg = "[#%&\'\"\\,;:=!^@]"
	for (i = 1; i < szMsg.length + 1; i++) {
		if (t.indexOf(szMsg.substring(i - 1, i)) > -1) {
			return false;
		}
	}
	return true;
}

 /*
  * 按钮状态设置
  */ 
function change_submit()  
{   	
	if(name_flag){
		  document.forms['formUser'].elements['Submit1'].disabled = '';  
	}
   else  
     {  
          document.forms['formUser'].elements['Submit1'].disabled = 'disabled';  
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

