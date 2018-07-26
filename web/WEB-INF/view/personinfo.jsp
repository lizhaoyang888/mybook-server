<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>个人页面</title>
</head>
<body>
<h3>个人页面</h3>
<form:form modelAttribute="person" action="insert" method="post">
    <font color="red">${requestScope.message }</font>
    <table>
        <tr>
            <td><label>用户名: </label></td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td><label>性别: </label></td>
            <td><form:input path="sex" /></td>
        </tr>
        <tr>
            <td><label>身份证号: </label></td>
            <td><input value="${person.card.code}" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="注册"></td>
        </tr>
    </table>
</form:form>
</body>
</html>