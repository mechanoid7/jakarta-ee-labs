<%@ page import="com.example.jakartaeelabs.Utils.CookieUtils" %>
<%@ page import="java.util.Objects" %>
<%@ page import="com.example.jakartaeelabs.Models.Group" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.jakartaeelabs.Models.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%!
    Boolean editable;
    List<Group> groups;
%>

<%
    editable = Objects.equals(CookieUtils.getCookie(request, CookieUtils.EDITABLE_COOKIE_PARAM_NAME), "true");
    request.setAttribute("editable", editable);
    List<Student> students_IO_99 = new ArrayList<>();
    students_IO_99.add(new Student("IO-99", "John", "Doe"));
    students_IO_99.add(new Student("IO-99", "Jane", "Smith"));
    students_IO_99.add(new Student("IO-99", "Bob", "Johnson"));
    groups = new ArrayList<>();
    groups.add(new Group("IO-99", students_IO_99));
    request.setAttribute("groups", groups);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Groups</title>
    <link rel="stylesheet/less" type="text/css" href="../styles/groups.less"/>
    <script src="https://cdn.jsdelivr.net/npm/less"></script>
</head>
<body>
<%--<c:set var="number" value="10" />--%>
<%--<img class="header" src="images/jakarta-ee.webp" alt="">--%>
<h1 class="title">Groups</h1>
<div class="groups">
    <c:forEach var="group" items="${groups}">
        <div class="group">
            <div class="group-name">${group.name}</div>
            <c:if test="${editable}">
                <img class="icon" src="../images/icons/edit.png" alt="">
                <img class="icon" src="../images/icons/delete.png" alt="">
            </c:if>
        </div>
    </c:forEach>
</div>
</body>
</html>