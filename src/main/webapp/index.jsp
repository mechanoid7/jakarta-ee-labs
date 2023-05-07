<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
</body>
</html>