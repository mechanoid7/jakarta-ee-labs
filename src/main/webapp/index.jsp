<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" href="styles/main-page.less">
    <link rel="stylesheet/less" type="text/css" href="styles/main-page.less"/>
    <script src="scripts/utils.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/less"></script>
</head>
<body>
<h1 class="title">Select role</h1>
<div class="roles">
    <a href="groups" onclick="setEditableCookie(false)">Student</a>
    <a href="groups" onclick="setEditableCookie(true)">Employee of the dean's office</a>
</div>

<%! String example = "one";%>
<% pageContext.setAttribute("example", example); %>

<c:choose>
    <c:when test="${example == 'one'}">
        <p>This is example one.</p>
    </c:when>
    <c:when test="${example == 'two'}">
        <p>This is example two.</p>
    </c:when>
    <c:otherwise>
        <p>This is an unknown example.</p>
    </c:otherwise>
</c:choose>
</body>
</html>