<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>注册页面</title>
</head>
<body>
<h3>用户页面</h3>
<table border="1">
    <tr>
        <th>登录名</th><th>用户名</th><th>电话</th><th>地址</th>
    </tr>
    <c:forEach items="${requestScope.user_list }" var="user">
        <tr>
            <td>${user.loginname }</td>
            <td>${user.username }</td>
            <td>${user.phone }</td>
            <td>${user.address }</td>
            <td><a href="/delete?id=${user.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>