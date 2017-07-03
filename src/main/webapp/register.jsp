<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>  
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>  
<script type="text/javascript" src="${pageContext.request.contextPath}/js/register.js"></script>
<title>用户注册</title>
<script>
	function mycheck(){
		if(document.all("password").value!=document.all("again").value){
			alert("两次输入的密码不一致，请更正。");
			return false;
		}else{
			return true;
		}
	}
</script>
	
</head>
<body>
用户注册信息：
<form action="register" method="post" onsubmit="return mycheck()">
<c:if test="${!empty errorMsg }">
	<div style="color=red">${errorMsg }</div>
</c:if>
<table boarder="5px solid red" width="60%">
	<tr>
		<td width="20%">用户名</td>
		<td width="80%"><input type= "text" id ="userName" name ="userName" onblur="checkUserName(this)"/><SPAN id="username_notice" >*</SPAN></td>
	</tr>
	<tr>
		<td width="20%">密码</td>
		<td width="80%"><input type= "password" id ="password"  name ="password" onblur="checkPassword(this)"/><SPAN id="password_notice" >*</SPAN></td>
	</tr>
	<tr>
		<td width="20%">密码确认</td>
		<td width="80%"><input type= "password" name ="again"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type = "submit" value = "注册"><input type ="reset" value ="重置">
		</td>
	</tr>
</table>
</form>
</body>
</html>