<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Groups</title>
    <link rel="stylesheet/less" type="text/css" href="../styles/base.less"/>
    <link rel="stylesheet/less" type="text/css" href="../styles/items-list.less"/>
    <script src="https://cdn.jsdelivr.net/npm/less"></script>
    <script src="../scripts/api.js"></script>
</head>
<body>
<div class="header">
    <a href="${pageContext.request.contextPath}/">
        <img class="icon" src="../images/icons/back.png" alt="">
    </a>
    <h1 class="title">Groups</h1>
    <c:if test="${requestScope.editable}">
        <a href="${pageContext.request.contextPath}/edit-group">
            <img class="icon" src="../images/icons/add.png" alt="">
        </a>
    </c:if>
</div>
<div class="list">
    <c:if test="${requestScope.groups.size() == 0}">
        <div class="not-exist">
            Groups not exist
        </div>
    </c:if>
    <c:forEach var="group" items="${requestScope.groups}">
        <div class="item">
            <a class="item-body" href="${pageContext.request.contextPath}/students?groupId=${group.getId()}">
                <div class="item-name">${group.getName()}</div>
            </a>
            <c:if test="${requestScope.editable}">
                <a href="${pageContext.request.contextPath}/edit-group?id=${group.getId()}">
                    <img class="icon" src="../images/icons/edit.png" alt="">
                </a>
                <img class="icon" src="../images/icons/delete.png" alt="" onclick="deleteGroup('${group.getId()}')">
            </c:if>
        </div>
    </c:forEach>
</div>
</body>
</html>
