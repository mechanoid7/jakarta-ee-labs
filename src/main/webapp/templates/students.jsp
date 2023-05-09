<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>${requestScope.groupName} Students</title>
    <link rel="stylesheet/less" type="text/css" href="../styles/students.less"/>
    <link rel="stylesheet/less" type="text/css" href="../styles/items-list.less"/>
    <script src="https://cdn.jsdelivr.net/npm/less"></script>
    <script src="../scripts/api.js"></script>
</head>
<body>
<div class="header">
    <h1 class="title">${requestScope.groupName} Students</h1>
    <c:if test="${requestScope.editable}">
        <a href="${pageContext.request.contextPath}/edit-student?groupId=${requestScope.groupId}">
            <img class="icon" src="../images/icons/add.png" alt="">
        </a>
    </c:if>
</div>
<div class="list">
    <c:if test="${requestScope.students.size() == 0}">
        <div class="not-exist">
            Students not exist
        </div>
    </c:if>
    <c:forEach var="student" items="${requestScope.students}">
        <div class="item">
            <div class="item-body">
                <div class="item-name">${student.getFirstName()} ${student.getLastName()}</div>
            </div>
            <c:if test="${requestScope.editable}">
                <a href="${pageContext.request.contextPath}/edit-student?id=${student.getId()}&groupId=${requestScope.groupId}">
                    <img class="icon" src="../images/icons/edit.png" alt="">
                </a>
                <img class="icon" src="../images/icons/delete.png" alt="" onclick="deleteStudent('${student.getId()}')">
            </c:if>
        </div>
    </c:forEach>
</div>
</body>
</html>