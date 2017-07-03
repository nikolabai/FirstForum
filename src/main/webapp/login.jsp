<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script> --%>
<title>用户登陆</title>
	
</head>
<body>
登陆：
<form action="login/doLogin" method="post" >
<c:if test="${!empty errorMsg }">
	<div style="color=red">${errorMsg }</div>
</c:if>
<table boarder="5px solid red" width="60%">
	<tr>
		<td width="20%">用户名</td>
		<td width="80%"><input type= "text" id ="userName" name ="userName" </td>
	</tr>
	<tr>
		<td width="20%">密码</td>
		<td width="80%"><input type= "password" id ="password"  name ="password" </td>
	</tr>
	<tr>
		<td colspan="2">
			<input type = "submit" value = "登陆"><input type ="reset" value ="重置">
		</td>
	</tr>
</table>
</form>
</body>
</html>