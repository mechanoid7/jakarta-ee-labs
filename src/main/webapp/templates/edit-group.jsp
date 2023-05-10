<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Edit Group</title>
    <link rel="stylesheet/less" type="text/css" href="../styles/base.less"/>
    <link rel="stylesheet/less" type="text/css" href="../styles/items-list.less"/>
    <script src="https://cdn.jsdelivr.net/npm/less"></script>
    <script src="../scripts/api.js"></script>
</head>
<body>
<div class="header">
    <a href="${pageContext.request.contextPath}/groups">
        <img class="icon" src="../images/icons/back.png" alt="">
    </a>
    <h1 class="title">Edit Group</h1>
</div>
<div class="list">
    <form action="${pageContext.request.contextPath}/edit-group" method="POST">
        <input type="text" name="id" value="${requestScope.group.id}" hidden/>
        <label title="Name">
            <input type="text" name="name" value="${requestScope.group.name}" />
        </label>
        <button type="submit">Save</button>
    </form>
</div>
</body>
</html>
