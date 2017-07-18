<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>successful</title>
</head>
<body>
<center>  
<h1><b>游客登陆</b></h1>  

<h1>用户拥有权限</h1>
    <!-- 如果当前用户有printer:print权限，标签内的内容才显示 -->
    <shiro:hasRole name="regular">注册用户</shiro:hasRole>
    <shiro:hasRole name="visitor">游客</shiro:hasRole>
</center>  
</body>
