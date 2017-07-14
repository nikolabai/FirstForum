<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>successful</h1>
    <!-- 如果当前用户有printer:print权限，标签内的内容才显示 -->
    <shiro:hasPermission name="printer:print">
        我有打印机的打印权限
    </shiro:hasPermission>
    <shiro:hasPermission name="printer:query">
        我有打印机的查询权限
    </shiro:hasPermission>
    <shiro:hasPermission name="printer:delete">
        我有打印机的删除权限
    </shiro:hasPermission>
</body>
</html>