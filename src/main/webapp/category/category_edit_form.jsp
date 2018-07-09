<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Category</title>
</head>
<body>
<%@include file="../common/message.jspf"%>

<h1>Edit Category ${category.name}</h1>
<form action="edit_categories.html" method="post">
    <input type="hidden" name="id" value="${category.id}">
    Nazwa: <input type="text" name="name" value="${category.name}"/><br/>
    <input type="submit" value="Edit"/>
</form>
<hr>
<button><a href="category/category_delete_form.jsp" target="_blank">Delete</a></button>
</body>
</html>
