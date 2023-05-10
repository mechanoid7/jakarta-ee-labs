<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Edit Student</title>
    <link rel="stylesheet/less" type="text/css" href="../styles/base.less"/>
    <link rel="stylesheet/less" type="text/css" href="../styles/items-list.less"/>
    <script src="https://cdn.jsdelivr.net/npm/less"></script>
    <script src="../scripts/api.js"></script>
</head>
<body>
<div class="header">
    <a href="${pageContext.request.contextPath}/students?groupId=${requestScope.group.getId()}">
        <img class="icon" src="../images/icons/back.png" alt="">
    </a>
    <h1 class="title">Edit Student</h1>
</div>
<div class="list">
    <form action="${pageContext.request.contextPath}/edit-student" method="POST">
        <input type="text" name="id" value="${requestScope.student.getId()}" hidden/>
        <input type="text" name="groupId" value="${requestScope.group.getId()}" hidden/>
        <label title="First Name">
            <input type="text" name="firstName" value="${requestScope.student.getFirstName()}" />
        </label>
        <label title="Last Name">
            <input type="text" name="lastName" value="${requestScope.student.getLastName()}" />
        </label>
        <button type="submit">Save</button>
    </form>
</div>
</body>
</html>
