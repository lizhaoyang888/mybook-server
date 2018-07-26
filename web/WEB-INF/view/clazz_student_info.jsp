<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>首页</title>
    <style type="text/css">
        table{border-collapse:collapse;border-spacing:0;border-left:1px solid #888;border-top:1px solid #888;background:#efefef;}
        th,td{border-right:1px solid #888;border-bottom:1px solid #888;padding:5px 15px;}
        th{font-weight:bold;background:#ccc;}
    </style>
</head>
<body>
欢迎[${sessionScope.user.username }]访问
<br>
<table border="1">
    <tr>
        <th>编号</th><th>姓名</th><th>性别</th>
    </tr>
    <c:forEach items="${requestScope.students }" var="student">
        <tr>
            <td>${student.id }</td>
            <td>${student.name }</td>
            <td>${student.sex }</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>