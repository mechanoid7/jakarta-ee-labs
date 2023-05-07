<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Edit Student</title>
    <link rel="stylesheet/less" type="text/css" href="../styles/groups.less"/>
    <link rel="stylesheet/less" type="text/css" href="../styles/items-list.less"/>
    <script src="https://cdn.jsdelivr.net/npm/less"></script>
    <script src="../scripts/api.js"></script>
</head>
<body>
<div class="header">
    <h1 class="title">Edit Student</h1>
</div>
<div class="list">
    <form action="${pageContext.request.contextPath}/edit-group" method="POST">
        <input type="text" name="id" value="${requestScope.student.id}" style="visibility: hidden"/>
        <label title="First Name">
            <input type="text" name="name" value="${requestScope.group.firstName}" />
        </label>
        <label title="Last Name">
            <input type="text" name="name" value="${requestScope.group.lastName}" />
        </label>
        <button type="submit">Save</button>
    </form>


<%--    <c:forEach var="group" items="${requestScope.groups}">--%>
<%--        <div class="item">--%>
<%--            <a class="item-body" href="${pageContext.request.contextPath}/students?group=${group.getName()}">--%>
<%--                <div class="item-name">${group.getName()}</div>--%>
<%--            </a>--%>
<%--            <c:if test="${requestScope.editable}">--%>
<%--                <img class="icon" src="../images/icons/edit.png" alt="">--%>
<%--                <img class="icon" src="../images/icons/delete.png" alt="" onclick="deleteGroup('${group.getId()}')">--%>
<%--            </c:if>--%>
<%--        </div>--%>
<%--    </c:forEach>--%>
</div>
</body>
</html>
