<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
</head>
<body>
<%@include file="../common/message.jspf"%>
<h1>Delete Category ${category.name}</h1>
<form action="delete_categories.html" method="post">
    <input type="hidden" name="id" value="${category.id}">
    Nazwa: <input type="text" name="name" value="${category.name}"/><br/>
    <input type="submit" value="Delete"/>
</form>
</body>
</html>
