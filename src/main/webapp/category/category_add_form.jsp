<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Category</title>
</head>
<body>
<%@include file="../common/message.jspf"%>

<h1>Add Category</h1>
<form action="add_categories.html" method="post">
    Nazwa: <input type="text" name="name"/><br/>
    <input type="submit" value="ADD"/>
</form>
</body>
</html>
