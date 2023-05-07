<%@ page import="com.example.jakartaeelabs.Utils.CookieUtils" %>
<%@ page import="java.util.Objects" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.jakartaeelabs.Models.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%!
    Boolean editable;
    List<Student> students_IO_99;
%>

<%
    editable = Objects.equals(CookieUtils.getCookie(request, CookieUtils.EDITABLE_COOKIE_PARAM_NAME), "true");
    request.setAttribute("editable", editable);

    students_IO_99 = new ArrayList<>();
    students_IO_99.add(new Student("IO-99", "John", "Doe"));
    students_IO_99.add(new Student("IO-99", "Jane", "Smith"));
    students_IO_99.add(new Student("IO-99", "Bob", "Johnson"));

    request.setAttribute("students", students_IO_99);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Groups</title>
    <link rel="stylesheet/less" type="text/css" href="../styles/students.less"/>
    <link rel="stylesheet/less" type="text/css" href="../styles/items-list.less"/>
    <script src="https://cdn.jsdelivr.net/npm/less"></script>
</head>
<body>
<div class="header">
    <h1 class="title">Students</h1>
    <c:if test="${editable}">
        <img class="icon" src="../images/icons/add.png" alt="">
    </c:if>
</div>
<div class="list">
    <c:forEach var="student" items="${students}">
        <div class="item">
            <div class="item-name">${student.firstName} ${student.lastName}</div>
            <c:if test="${editable}">
                <img class="icon" src="../images/icons/edit.png" alt="">
                <img class="icon" src="../images/icons/delete.png" alt="">
            </c:if>
        </div>
    </c:forEach>
</div>
</body>
</html>