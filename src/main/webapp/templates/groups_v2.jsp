<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Groups</title>
    <link rel="stylesheet/less" type="text/css" href="../styles/groups.less"/>
    <link rel="stylesheet/less" type="text/css" href="../styles/items-list.less"/>
    <script src="../scripts/routing.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/less"></script>
</head>
<body>
<div class="header">
    <h1 class="title">Groups</h1>
    <c:if test="${requestScope.editable}">
        <img class="icon" src="../images/icons/add.png" alt="">
    </c:if>
</div>
<div class="list">
    <c:forEach var="group" items="${requestScope.groups}">
        <div class="item">
            <a class="item-body" href="${pageContext.request.contextPath}/students?group=${group.name}">
                <div class="item-name">${group.name}</div>
            </a>
            <c:if test="${requestScope.editable}">
                <img class="icon" src="../images/icons/edit.png" alt="">
                <img class="icon" src="../images/icons/delete.png" alt="">
            </c:if>
        </div>
    </c:forEach>
</div>
</body>
</html>
