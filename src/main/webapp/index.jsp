<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>


<body background="image/background.jpg">
<center>
<img src="<%=request.getContextPath()%>/image/home.png" />
<p>
<a href="/FirstForum/login.jsp">普通登陆</a>
<a href="/FirstForum/shiroLogin.jsp">Shiro登陆</a>
<a href="/FirstForum/register.jsp">注册</a>
<a href="/FirstForum/index2.jsp">游客</a>
<a href="/FirstForum/home.jsp">忘记密码</a>
</p>
<p>
Powered by GoodBai
</p>
</center>
</body>
</html>