<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>注册页面</title>
</head>
<body>
<h3>注册页面</h3>
<form:form modelAttribute="user" action="insert" method="post">
    <font color="red">${requestScope.message }</font>
    <table>
        <tr>
            <td><label>登录名: </label></td>
            <td><form:input path="loginname" /></td>
        </tr>
        <tr>
            <td><label>密码: </label></td>
            <td><form:password path="password" /></td>
        </tr>
        <tr>
            <td><label>用户名: </label></td>
            <td><form:input path="username" /></td>
        </tr>
        <tr>
            <td><label>电话: </label></td>
            <td><form:input path="phone" /> ></td>
        </tr>
        <tr>
            <td><label>地址: </label></td>
            <td><form:input path="address" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="注册"></td>
        </tr>
    </table>
</form:form>
</body>
</html>