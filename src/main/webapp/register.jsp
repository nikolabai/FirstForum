<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<script>
	function mycheck(){
		if(document.all("user.password").value!=document.al("again").value){
			alert("两次输入的密码不正确，请更正。");
			return false;
		}else{
			return true;
		}
	}
</script>		
</head>
<body>
用户注册信息：
<form action="register.do" method="post" onsubmit="return mycheck()">
<c:if test="${!empty errorMsg }">
	<div style="color=red">${errorMsg }</div>
</c:if>
<table boarder="1px" width="60%">
	<tr>
		<td width="20%">用户名</td>
		<td width="80%"><input type= "text" name ="userName"/></td>
	</tr>
	<tr>
		<td width="20%">密码</td>
		<td width="80%"><input type= "password" name ="password"/></td>
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